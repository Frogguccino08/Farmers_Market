package net.raul.farmersmarket.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.raul.farmersmarket.FarmersMarketMod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> future, CompletableFuture<TagLookup<Block>> completableFuture,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, future, completableFuture, FarmersMarketMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //Adds tags here
        /*
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.SUGILITE_HELMET.get(),
                        ModItems.SUGILITE_CHESTPLATE.get(),
                        ModItems.SUGILITE_LEGGINGS.get(),
                        ModItems.SUGILITE_BOOTS.get());
         */
    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
