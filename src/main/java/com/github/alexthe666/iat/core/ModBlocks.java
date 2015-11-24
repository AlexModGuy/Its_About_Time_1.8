package com.github.alexthe666.iat.core;

import com.github.alexthe666.iat.block.BlockAncientTablet;
import com.github.alexthe666.iat.block.BlockOreGem;
import com.github.alexthe666.iat.block.BlockSingularityCrystal;
import com.github.alexthe666.iat.block.BlockSunStone;

import net.minecraft.block.Block;


public class ModBlocks{

	public static Block sunstone;
	public static Block ore_gem;
	public static Block ancienttablet;
	public static Block singularitycrystal;

	public static void init(){
		sunstone = new BlockSunStone();
		ore_gem = new BlockOreGem();
		ancienttablet = new BlockAncientTablet();
		singularitycrystal = new BlockSingularityCrystal();
	}
}
