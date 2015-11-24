package com.github.alexthe666.iat.item;

import com.github.alexthe666.iat.ItsAboutTime;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemGeneric extends Item {
	public ItemGeneric(String name){
		this.setCreativeTab(ItsAboutTime.tab_items);
		this.setUnlocalizedName("iat." + name);
		GameRegistry.registerItem(this, name);
	}
}
