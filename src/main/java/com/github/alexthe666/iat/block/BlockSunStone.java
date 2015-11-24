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
import com.github.alexthe666.iat.tileentity.TileEntitySunstone;

public class BlockSunStone extends BlockContainer{

	public BlockSunStone(){
		super(Material.rock);
		GameRegistry.registerBlock(this, "sunstone");
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		this.setTickRandomly(true);
		this.setCreativeTab(ItsAboutTime.tab_blocks);
		this.setUnlocalizedName("iat.sunstone");
		this.setBlockBoundsForItemRender();
		this.setHardness(1.5F);
		this.setResistance(10.0F);
		GameRegistry.registerTileEntity(TileEntitySunstone.class, "tileentitysunstone");
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean isFullCube()
	{
		return false;
	}
	
	public int getRenderType(){
		return 3;
	}

	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.CUTOUT;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntitySunstone();
	}
	
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	{
		IBlockState iblockstate = worldIn.getBlockState(pos.down());
		Block block = iblockstate.getBlock();
		return block.isOpaqueCube();
	}
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
	{
		this.checkAndDropBlock(worldIn, pos, state);
	}

	private boolean checkAndDropBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		if (!this.canPlaceBlockAt(worldIn, pos))
		{
			worldIn.destroyBlock(pos, true);
			return false;
		}
		else
		{
			return true;
		}
	}
}
