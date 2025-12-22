package net.raul.farmersmarket.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.raul.farmersmarket.FarmersMarketMod;
import net.raul.farmersmarket.item.custom.FlowerRootSwordItem;
import net.raul.farmersmarket.item.custom.ScytheItem;
import net.raul.farmersmarket.item.custom.SunflowerItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FarmersMarketMod.MOD_ID);

    //Mine
    public static final RegistryObject<Item> IRON_SCYTHE = ITEMS.register("iron_scythe",
            () -> new ScytheItem(Tiers.IRON, 3, -3.2f,new Item.Properties().durability(250)));

    public static final RegistryObject<Item> COMICALLY_LARGE_SUNFLOWER = ITEMS.register("comically_large_sunflower",
            () -> new SunflowerItem(ModToolTiers.GRASS, 6, -3.4f,new Item.Properties().durability(100)));

    public static final RegistryObject<Item> FLOWER_ROOT_SWORD = ITEMS.register("flower_root_sword",
            () -> new FlowerRootSwordItem(ModToolTiers.GRASS, 4, -2.2f,new Item.Properties().durability(100)));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
