package com.github.alexthe666.iat.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.github.alexthe666.iat.ItsAboutTime;
import com.github.alexthe666.iat.core.ModBlocks;
import com.github.alexthe666.iat.core.ModItems;

public class BlockOreGem extends Block {

	public BlockOreGem() {
		super(Material.rock);
		GameRegistry.registerBlock(this, "ore_gem");
		this.setTickRandomly(true);
		this.setCreativeTab(ItsAboutTime.tab_blocks);
		this.setUnlocalizedName("iat.ore_gem");
		this.setHardness(3.5F);
		this.setResistance(6.0F);
		this.setLightLevel(0.5F);
	}
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return ModItems.gem_tempus;
	}
	@Override
	public int getExpDrop(IBlockAccess world, BlockPos pos, int fortune)
	{
		return MathHelper.getRandomIntegerInRange(new Random(), 3, 7);
	}
	
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.CUTOUT;
	}

}
