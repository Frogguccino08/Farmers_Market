package net.raul.farmersmarket.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.raul.farmersmarket.FarmersMarketMod;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FarmersMarketMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FARMERSMARKET = CREATIVE_MODE_TABS.register("farmersmarket",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.IRON_SCYTHE.get())).title(Component.translatable("creativetab.farmersmarket"))
                    .displayItems((displayParameters, output) -> {
                        output.accept(ModItems.IRON_SCYTHE.get());
                        output.accept(ModItems.COMICALLY_LARGE_SUNFLOWER.get());
                        output.accept(ModItems.FLOWER_ROOT_SWORD.get());
            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
