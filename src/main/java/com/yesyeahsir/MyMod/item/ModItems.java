package com.yesyeahsir.MyMod.item;

import com.yesyeahsir.MyMod.MyMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

// The main Custom Items Class
public class ModItems
{
    // ITEMS DeferredRegister
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MyMod.MOD_ID);

    // Emeraldus Item (Temporary)
    public static final RegistryObject<Item> Emeraldus = ITEMS.register("emeraldus", () -> new Item(new Item.Properties()));

    // Fake Book Item (Temporary)
    public static final RegistryObject<Item> Fake_Book = ITEMS.register("fake_book", () -> new Item(new Item.Properties()));

    // Items Register Method
    public static void Register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
