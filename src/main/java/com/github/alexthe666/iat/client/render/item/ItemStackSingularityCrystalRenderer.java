package com.github.alexthe666.iat.client.render.item;

import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;

import com.github.alexthe666.iat.core.ModBlocks;
import com.github.alexthe666.iat.tileentity.TileEntitySingularityCrystal;
import com.google.common.collect.Maps;

public class ItemStackSingularityCrystalRenderer extends TileEntityItemStackRenderer {
	private Map<Integer, TileEntitySingularityCrystal> itemRenders = Maps.newHashMap();
	
	public ItemStackSingularityCrystalRenderer(){
		itemRenders.put(0, (TileEntitySingularityCrystal) new TileEntitySingularityCrystal());
	}
	private TileEntitySingularityCrystal entity = new TileEntitySingularityCrystal();
	@Override
	public void renderByItem(ItemStack itemStack) {
		Block block = Block.getBlockFromItem(itemStack.getItem());
		if (block == ModBlocks.singularitycrystal) {
			TileEntityRendererDispatcher.instance.renderTileEntityAt(this.entity, 0.0D, 0.0D, 0.0D, 0.0F);
		}else {
			super.renderByItem(itemStack);
		}
	}
}