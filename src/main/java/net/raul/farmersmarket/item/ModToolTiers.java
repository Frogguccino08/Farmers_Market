package net.raul.farmersmarket.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.raul.farmersmarket.FarmersMarketMod;

import java.util.List;

public class ModToolTiers {
    public static final Tier GRASS = TierSortingRegistry.registerTier(
            new ForgeTier(2, 250, 6.0f, 2.0f, 14, BlockTags.SWORD_EFFICIENT, () -> Ingredient.EMPTY),
            new ResourceLocation(FarmersMarketMod.MOD_ID, "grass"), List.of(Tiers.IRON), List.of());
}
