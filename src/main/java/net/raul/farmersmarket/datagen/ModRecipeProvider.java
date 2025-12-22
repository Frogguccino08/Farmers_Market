package net.raul.farmersmarket.datagen;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.raul.farmersmarket.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }
        /*

        private static final List<ItemLike> sugiliteSmeltables = List.of(ModItems.RAW_SUGILITE.get(), ModBlocks.NETHER_SUGILITE_ORE.get(), ModBlocks.DEEPSLATE_SUGILITE_ORE.get()
            , FarmersMarketMod.END_STONE_SUGILITE_ORE.get(), ModBlocks.SUGILITE_ORE.get());
    }

*/
    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.IRON_SCYTHE.get())
                .pattern("BBA")
                .pattern(" A ")
                .pattern("A  ")
                .define('A', Items.STICK)
                .define('B', Items.IRON_INGOT)
                .unlockedBy("has_iron", inventoryTrigger(ItemPredicate.Builder.item().of(Items.IRON_INGOT).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COMICALLY_LARGE_SUNFLOWER.get())
                .pattern("   ")
                .pattern("BAB")
                .pattern("   ")
                .define('A', Items.SUNFLOWER)
                .define('B', Items.STICK)
                .unlockedBy("has_sunflower", inventoryTrigger(ItemPredicate.Builder.item().of(Items.SUNFLOWER).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.FLOWER_ROOT_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .define('B', Ingredient.of(ItemTags.FLOWERS))
                .define('A', Ingredient.of(ItemTags.LEAVES))
                .unlockedBy("has_flower", inventoryTrigger(ItemPredicate.Builder.item().of(ItemTags.FLOWERS).build()))
                .save(pWriter);
    }
}
