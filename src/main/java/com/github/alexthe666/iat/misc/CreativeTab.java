package com.github.alexthe666.iat.misc;

import com.github.alexthe666.iat.core.ModBlocks;
import com.github.alexthe666.iat.core.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CreativeTab extends CreativeTabs {

	private int type; 
	
	public CreativeTab(String label, int type) {
		super(label);
		this.type = type;
	}

	@Override
	public Item getTabIconItem() {
		switch(type){
		default:
			return ModItems.gem_tempus;
		case 1:
			return Item.getItemFromBlock(ModBlocks.ore_gem);
		case 2:
			return ModItems.spawnegg;
			
		}
	}

}
