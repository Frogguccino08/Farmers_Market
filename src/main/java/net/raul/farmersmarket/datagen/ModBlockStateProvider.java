package net.raul.farmersmarket.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.raul.farmersmarket.FarmersMarketMod;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FarmersMarketMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        /*
        blockWithItem(ModBlocks.SUGILITE_BLOCK);
        blockWithItem(ModBlocks.RAW_SUGILITE_BLOCK);

        blockWithItem(ModBlocks.SUGILITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SUGILITE_ORE);
        blockWithItem(ModBlocks.END_STONE_SUGILITE_ORE);
        blockWithItem(ModBlocks.NETHER_SUGILITE_ORE);

        blockWithItem(ModBlocks.SOUND_BLOCK);

        stairsBlock((StairBlock) ModBlocks.SUGILITE_STAIRS.get(), blockTexture(ModBlocks.SUGILITE_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.SUGILITE_SLAB.get()), blockTexture(ModBlocks.SUGILITE_BLOCK.get()), blockTexture(ModBlocks.SUGILITE_BLOCK.get()));

        buttonBlock((ButtonBlock) ModBlocks.SUGILITE_BUTTON.get(), blockTexture(ModBlocks.SUGILITE_BLOCK.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.SUGILITE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.SUGILITE_BLOCK.get()));

        fenceBlock((FenceBlock) ModBlocks.SUGILITE_FENCE.get(), blockTexture(ModBlocks.SUGILITE_BLOCK.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.SUGILITE_FENCE_GATE.get(), blockTexture(ModBlocks.SUGILITE_BLOCK.get()));
        wallBlock((WallBlock) ModBlocks.SUGILITE_WALL.get(), blockTexture(ModBlocks.SUGILITE_BLOCK.get()));

        doorBlockWithRenderType((DoorBlock) ModBlocks.SUGILITE_DOOR.get(), modLoc("block/sugilite_door_bottom"), modLoc("block/sugilite_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.SUGILITE_TRAPDOOR.get(), modLoc("block/sugilite_trapdoor"), true, "cutout");


        blockItem(ModBlocks.SUGILITE_STAIRS);
        blockItem(ModBlocks.SUGILITE_SLAB);
        blockItem(ModBlocks.SUGILITE_PRESSURE_PLATE);
        blockItem(ModBlocks.SUGILITE_FENCE_GATE);
        blockItem(ModBlocks.SUGILITE_TRAPDOOR, "_bottom");

         */
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix){
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("farmersmarket:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("farmersmarket:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
