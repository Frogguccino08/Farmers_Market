package net.raul.farmersmarket.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class SunflowerItem extends SwordItem {
    public SunflowerItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(entity instanceof LivingEntity livingEntity){
            livingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100), player);

            livingEntity.knockback(
                    1.5F,
                    player.getX() - livingEntity.getX(),
                    player.getZ() - livingEntity.getZ()
            );
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            dash(player);
            stack.hurtAndBreak(5, player, p -> p.broadcastBreakEvent(hand));
        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide);
    }

    private void dash(Player player) {
        Vec3 look = player.getLookAngle().normalize();

        double forca = 1.2D;
        double impulsoY = 0.2D;

        Vec3 movimento = new Vec3(
                look.x * forca,
                look.y * forca + impulsoY,
                look.z * forca
        );

        player.setDeltaMovement(movimento);
        player.getCooldowns().addCooldown(this, 50);
        player.hurtMarked = true;
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        if (!(book.getItem() instanceof EnchantedBookItem)) {
            return false;
        }

        Map<Enchantment, Integer> enchants =
                EnchantmentHelper.getEnchantments(book);

        return enchants.keySet().stream()
                .anyMatch(enchantment ->
                        canApplyAtEnchantingTable(stack, enchantment)
                );
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.farmersmarket.sunflower"));

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}