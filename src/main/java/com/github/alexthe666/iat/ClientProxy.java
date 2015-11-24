package com.github.alexthe666.iat;

import java.util.Iterator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.github.alexthe666.iat.client.render.entity.RenderAnomalocaris;
import com.github.alexthe666.iat.client.render.entity.RenderRedlichia;
import com.github.alexthe666.iat.client.render.entity.RenderWatcher;
import com.github.alexthe666.iat.client.render.tileentity.TileEntitySingularityCrystalRenderer;
import com.github.alexthe666.iat.client.render.tileentity.TileEntitySunstoneRenderer;
import com.github.alexthe666.iat.core.ModBlocks;
import com.github.alexthe666.iat.core.ModItems;
import com.github.alexthe666.iat.entity.IATEntityList;
import com.github.alexthe666.iat.entity.mob.EntityAnomalocaris;
import com.github.alexthe666.iat.entity.mob.EntityRedlichia;
import com.github.alexthe666.iat.entity.mob.EntityWatcher;
import com.github.alexthe666.iat.tileentity.TileEntitySingularityCrystal;
import com.github.alexthe666.iat.tileentity.TileEntitySunstone;

public class ClientProxy extends CommonProxy{

	public void render(){
		renderBlocks();
		renderItems();
		renderEntities();
		renderTileEntities();
	}

	private void renderEntities() {
		RenderingRegistry.registerEntityRenderingHandler(EntityWatcher.class, new RenderWatcher());
		RenderingRegistry.registerEntityRenderingHandler(EntityRedlichia.class, new RenderRedlichia());
		RenderingRegistry.registerEntityRenderingHandler(EntityAnomalocaris.class, new RenderAnomalocaris());

	}

	private void renderTileEntities() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySunstone.class, new TileEntitySunstoneRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySingularityCrystal.class, new TileEntitySingularityCrystalRenderer());
	}

	private void renderItems() {
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		renderItem.getItemModelMesher().register(ModItems.gem_tempus, 0, new ModelResourceLocation("iat:gem_tempus", "inventory"));
		renderItem.getItemModelMesher().register(ModItems.spawnegg, 0, new ModelResourceLocation("iat:spawnegg", "inventory"));
		Iterator iterator = IATEntityList.entities.values().iterator();
		while (iterator.hasNext())
		{
			IATEntityList.Entities entityegginfo = (IATEntityList.Entities) iterator.next();
			renderItem.getItemModelMesher().register(ModItems.spawnegg, entityegginfo.id, new ModelResourceLocation("iat:spawnegg", "inventory"));
		}
	}

	private void renderBlocks() {
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(ModBlocks.sunstone), 0, new ModelResourceLocation("iat:sunstone", "inventory"));
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(ModBlocks.ore_gem), 0, new ModelResourceLocation("iat:ore_gem", "inventory"));
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(ModBlocks.ancienttablet), 0, new ModelResourceLocation("iat:ancienttablet", "inventory"));
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(ModBlocks.singularitycrystal), 0, new ModelResourceLocation("iat:singularitycrystal", "inventory"));

	}
}
