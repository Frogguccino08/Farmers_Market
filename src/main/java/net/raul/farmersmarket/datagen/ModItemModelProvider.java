package net.raul.farmersmarket.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.raul.farmersmarket.FarmersMarketMod;
import net.raul.farmersmarket.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FarmersMarketMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        handheldItem(ModItems.IRON_SCYTHE);
            handheldItem(ModItems.COMICALLY_LARGE_SUNFLOWER);
        handheldItem(ModItems.FLOWER_ROOT_SWORD);

        /*
        simpleItem(ModItems.SUGILITE);
        simpleItem(ModItems.RAW_SUGILITE);

        simpleItem(ModItems.KOHLRABI);
        simpleItem(ModItems.METAL_DETECTOR);
        simpleItem(ModItems.PEAT_BRICK);
        simpleItem(ModItems.SUGILITE_HORSE_ARMOR);

        handheldItem(ModItems.SUGILITE_SWORD);
        handheldItem(ModItems.SUGILITE_PICKAXE);
        handheldItem(ModItems.SUGILITE_SHOVEL);
        handheldItem(ModItems.SUGILITE_AXE);
        handheldItem(ModItems.SUGILITE_HOE);
        handheldItem(ModItems.SUGILITE_PAXEL);
        handheldItem(ModItems.SUGILITE_HAMMER);
        handheldItem(ModItems.IRON_SCYTHE);

        buttonItem(ModBlocks.SUGILITE_BUTTON, ModBlocks.SUGILITE_BLOCK);
        fenceItem(ModBlocks.SUGILITE_FENCE, ModBlocks.SUGILITE_BLOCK);
        wallItem(ModBlocks.SUGILITE_WALL, ModBlocks.SUGILITE_BLOCK);

        simpleBlockItem(ModBlocks.SUGILITE_DOOR);
         */
    }

    private void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory")).
                texture("texture", new ResourceLocation(FarmersMarketMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory")).
                texture("wall", new ResourceLocation(FarmersMarketMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory")).
                texture("texture", new ResourceLocation(FarmersMarketMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(FarmersMarketMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FarmersMarketMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
            new ResourceLocation("item/generated")).texture("layer0",
            new ResourceLocation(FarmersMarketMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
