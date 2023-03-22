package com.yesyeahsir.MyMod;

import com.mojang.logging.LogUtils;
import com.yesyeahsir.MyMod.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// Main Mod Class
@Mod(MyMod.MOD_ID)
public class MyMod
{
    // The Mod ID
    public static final String MOD_ID = "mymod";
    private static final Logger LOGGER = LogUtils.getLogger();

    // Register
    public MyMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.Register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add Items to Creative Tabs
    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == CreativeModeTabs.INGREDIENTS)
        {
            // Items
            event.accept(ModItems.Emeraldus);
            event.accept(ModItems.Fake_Book);
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
