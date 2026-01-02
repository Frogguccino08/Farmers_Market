package net.raul.farmersmarket.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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

public class FlowerRootSwordItem extends SwordItem {
    public FlowerRootSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(entity instanceof LivingEntity livingEntity){
            livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 80), player);
        }

        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity target, InteractionHand hand) {
        if (!player.level().isClientSide) {
            arremessarEntidade(player, target);
            stack.hurtAndBreak(5, player, p -> p.broadcastBreakEvent(hand));
        }

        player.getCooldowns().addCooldown(this, 50);
        return InteractionResult.SUCCESS;
    }

    private void arremessarEntidade(Player player, LivingEntity target) {
        player.attack(target);

        Vec3 look = player.getLookAngle().normalize();

        double forcaHorizontal = 1.2D;
        double forcaVertical = 0.8D;

        Vec3 velocity = new Vec3(
                look.x * forcaHorizontal,
                forcaVertical,
                look.z * forcaHorizontal
        );

        target.setDeltaMovement(velocity);
        target.hurtMarked = true;
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
        pTooltipComponents.add(Component.translatable("tooltip.farmersmarket.flower_root_sword"));

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
