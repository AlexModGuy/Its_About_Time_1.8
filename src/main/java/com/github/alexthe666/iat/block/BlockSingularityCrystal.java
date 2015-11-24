package com.github.alexthe666.iat.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.github.alexthe666.iat.ItsAboutTime;
import com.github.alexthe666.iat.tileentity.TileEntitySingularityCrystal;
import com.github.alexthe666.iat.tileentity.TileEntitySunstone;

public class BlockSingularityCrystal extends BlockContainer{

	public BlockSingularityCrystal(){
		super(Material.rock);
		GameRegistry.registerBlock(this, "singularitycrystal");
		this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 1F, 0.75F);
		this.setTickRandomly(true);
		this.setCreativeTab(ItsAboutTime.tab_blocks);
		this.setUnlocalizedName("iat.singularitycrystal");
		this.setBlockBoundsForItemRender();
		this.setHardness(1.5F);
		this.setResistance(10.0F);
		GameRegistry.registerTileEntity(TileEntitySingularityCrystal.class, "tileentitysingularitycrystal");
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean isFullCube()
	{
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntitySingularityCrystal();
	}

}
