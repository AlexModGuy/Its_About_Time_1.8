package com.github.alexthe666.iat.core;

import com.github.alexthe666.iat.item.ItemGeneric;
import com.github.alexthe666.iat.item.ItemIATSpawnEgg;

import net.minecraft.item.Item;


public class ModItems{

	public static Item gem_tempus;
	public static ItemIATSpawnEgg spawnegg;

	public static void init(){
		gem_tempus = new ItemGeneric("gem_tempus"); 
		spawnegg = new ItemIATSpawnEgg();
	}
	
}
