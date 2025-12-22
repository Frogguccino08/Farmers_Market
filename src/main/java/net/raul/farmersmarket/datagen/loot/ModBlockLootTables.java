package net.raul.farmersmarket.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.raul.farmersmarket.block.ModBlocks;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        /*
        this.dropSelf(ModBlocks.SUGILITE_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_SUGILITE_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());

        this.add(ModBlocks.SUGILITE_ORE.get(),
                block -> createOreDrop(ModBlocks.SUGILITE_ORE.get(), ModItems.RAW_SUGILITE.get()));
        this.add(ModBlocks.DEEPSLATE_SUGILITE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_SUGILITE_ORE.get(), ModItems.RAW_SUGILITE.get()));
        this.add(ModBlocks.END_STONE_SUGILITE_ORE.get(),
                block -> createOreDrop(ModBlocks.END_STONE_SUGILITE_ORE.get(), ModItems.RAW_SUGILITE.get()));
        this.add(ModBlocks.NETHER_SUGILITE_ORE.get(),
                block -> createOreDrop(ModBlocks.NETHER_SUGILITE_ORE.get(), ModItems.RAW_SUGILITE.get()));

        this.dropSelf(ModBlocks.SUGILITE_STAIRS.get());
        this.add(ModBlocks.SUGILITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SUGILITE_SLAB.get()));

        this.dropSelf(ModBlocks.SUGILITE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.SUGILITE_BUTTON.get());

        this.dropSelf(ModBlocks.SUGILITE_FENCE.get());
        this.dropSelf(ModBlocks.SUGILITE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.SUGILITE_WALL.get());

        this.dropSelf(ModBlocks.SUGILITE_TRAPDOOR.get());
        this.add(ModBlocks.SUGILITE_DOOR.get(),
                block -> createDoorTable(ModBlocks.SUGILITE_DOOR.get()));
         */
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
