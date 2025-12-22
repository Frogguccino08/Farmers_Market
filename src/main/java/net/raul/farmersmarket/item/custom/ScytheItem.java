package net.raul.farmersmarket.item.custom;

import net.minecraft.core.BlockPos;
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
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class ScytheItem extends HoeItem {
    public ScytheItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(entity instanceof LivingEntity livingEntity){
            livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 30, 2), player);
        }

        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment.category == EnchantmentCategory.WEAPON
                || enchantment.category == EnchantmentCategory.BREAKABLE
                || super.canApplyAtEnchantingTable(stack, enchantment);

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (level.isClientSide) {
            return InteractionResultHolder.pass(stack);
        }

        int raio = 3;

        quebrarPlantasAoRedor(level, player, raio);
        causarDanoEmMobs(level, player, raio);

        player.getCooldowns().addCooldown(this, 50);
        stack.hurtAndBreak(5, player, p -> p.broadcastBreakEvent(hand));

        return InteractionResultHolder.success(stack);
    }

    private void quebrarPlantasAoRedor(Level level, Player player, int raio) {
        BlockPos centro = player.blockPosition();

        for (BlockPos pos : BlockPos.betweenClosed(
                centro.offset(-raio, -1, -raio),
                centro.offset(raio, 2, raio)
        )) {
            BlockState state = level.getBlockState(pos);
            Block block = state.getBlock();

            if (block instanceof CropBlock) {
                level.destroyBlock(pos, true, player);
            }
            else if (block instanceof BushBlock) {
                level.destroyBlock(pos, true, player);
            }
        }
    }

    private void causarDanoEmMobs(Level level, Player player, int raio) {
        BlockPos centro = player.blockPosition();

        AABB area = new AABB(
                centro.offset(-raio, -1, -raio),
                centro.offset(raio, 1, raio)
        );

        for (LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, area)) {
            if (entity != player) {
                player.attack(entity);
            }
        }
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
        pTooltipComponents.add(Component.translatable("tooltip.farmersmarket.iron_scythe"));

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
