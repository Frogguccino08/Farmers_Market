package net.raul.farmersmarket.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.raul.farmersmarket.FarmersMarketMod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FarmersMarketMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        /*
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.SUGILITE_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SUGILITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_SUGILITE_ORE.get())
                .add(ModBlocks.NETHER_SUGILITE_ORE.get())
                .add(ModBlocks.END_STONE_SUGILITE_ORE.get())
                .add(ModBlocks.SUGILITE_BLOCK.get())
                .add(ModBlocks.RAW_SUGILITE_BLOCK.get())
                .add(ModBlocks.SUGILITE_STAIRS.get())
                .add(ModBlocks.SUGILITE_SLAB.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.SOUND_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SUGILITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_SUGILITE_ORE.get())
                .add(ModBlocks.SUGILITE_BLOCK.get())
                .add(ModBlocks.RAW_SUGILITE_BLOCK.get())
                .add(ModBlocks.SUGILITE_STAIRS.get())
                .add(ModBlocks.SUGILITE_SLAB.get());

        /*
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.NETHER_SUGILITE_ORE.get())
                .add(ModBlocks.END_STONE_SUGILITE_ORE.get());
         */
        /*
        this.tag(ModTags.Blocks.NEEDS_SUGILITE_TOOL)
                .add(ModBlocks.NETHER_SUGILITE_ORE.get())
                .add(ModBlocks.END_STONE_SUGILITE_ORE.get());

        this.tag(ModTags.Blocks.PAXEL_MINEABLE)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL);

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.SUGILITE_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.SUGILITE_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.SUGILITE_WALL.get());
        */
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
