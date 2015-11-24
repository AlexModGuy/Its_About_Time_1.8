package com.github.alexthe666.iat;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.github.alexthe666.iat.core.ModBlocks;
import com.github.alexthe666.iat.core.ModEntities;
import com.github.alexthe666.iat.core.ModItems;
import com.github.alexthe666.iat.core.ModWorld;
import com.github.alexthe666.iat.misc.CreativeTab;
import com.github.alexthe666.iat.world.WorldGenMain;

@Mod(modid = ItsAboutTime.MODID, version = ItsAboutTime.VERSION)
public class ItsAboutTime
{
    public static final String MODID = "iat";
    public static final String VERSION = "0.2";
	@Instance(value = MODID)
	public static ItsAboutTime instance;
	public static SimpleNetworkWrapper channel;
	@SidedProxy(clientSide = "com.github.alexthe666.iat.ClientProxy", serverSide = "com.github.alexthe666.iat.CommonProxy")
	public static CommonProxy proxy;
	public static CreativeTabs tab_items;
	public static CreativeTabs tab_blocks;
	public static CreativeTabs tab_spawneggs;

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	tab_items = new CreativeTab(MODID + ".items", 0);
    	tab_blocks = new CreativeTab(MODID + ".blocks", 1);
    	tab_spawneggs = new CreativeTab(MODID + ".spawneggs", 2);
    	ModBlocks.init();
    	ModItems.init();
    	ModEntities.init();
    	ModWorld.init();
    	proxy.render();
        GameRegistry.registerWorldGenerator(new WorldGenMain(), 0);
    }
}
