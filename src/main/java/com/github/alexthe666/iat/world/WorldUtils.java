package com.github.alexthe666.iat.world;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBanner;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class WorldUtils {

	public static void setBlock(World world, int x, int y, int z, Block block, int meta, int flags){
		BlockPos pos = new BlockPos(x, y, z);
		world.setBlockState(pos, block.getStateFromMeta(meta), flags);
	}

	public static Block getBlock(World world, int x, int y, int z){
		BlockPos pos = new BlockPos(x, y, z);
		return world.getBlockState(pos).getBlock();
	}

	public static int getBlockMeta(World world, int x, int y, int z){
		BlockPos pos = new BlockPos(x, y, z);
		return world.getBlockState(pos).getBlock().getMetaFromState(world.getBlockState(pos));
	}

	public static void setBanner(World world, int x, int y, int z, int bannerType, int meta, int flags){
		setBlock(world, x, y, z, Blocks.wall_banner, meta, flags);
		if(getBlock(world, x, y, z) instanceof BlockBanner){
			BlockBanner banner = (BlockBanner)getBlock(world, x, y, z);
			TileEntityBanner tile = (TileEntityBanner)world.getTileEntity(new BlockPos(x, y, z));
			ItemStack stack = new ItemStack(Items.banner, 1, 0);
			NBTTagCompound stackTagCompound = new NBTTagCompound();
			stack.setTagCompound(stackTagCompound);

			NBTTagCompound bannerData = new NBTTagCompound();
			stackTagCompound.setTag("BlockEntityTag", bannerData);

			NBTTagList patternsList = new NBTTagList();
			bannerData.setTag("Patterns", patternsList);
			switch(bannerType){
			case 0:
				patternsList.appendTag(createPatternTag(TileEntityBanner.EnumBannerPattern.getPatternByID("gru"), EnumDyeColor.byDyeDamage(2)));
				patternsList.appendTag(createPatternTag(TileEntityBanner.EnumBannerPattern.getPatternByID("flo"), EnumDyeColor.byDyeDamage(15)));
				bannerData.setInteger("Base", 6);
				break;
			case 1:
				patternsList.appendTag(createPatternTag(TileEntityBanner.EnumBannerPattern.getPatternByID("mr"), EnumDyeColor.byDyeDamage(15)));
				patternsList.appendTag(createPatternTag(TileEntityBanner.EnumBannerPattern.getPatternByID("cbo"), EnumDyeColor.byDyeDamage(8)));
				bannerData.setInteger("Base", 7);
				break;
			}

			tile.setItemValues(stack);
		}
	}

	protected static NBTTagCompound createPatternTag(TileEntityBanner.EnumBannerPattern pattern, EnumDyeColor color) {
		NBTTagCompound tag = new NBTTagCompound();
		tag.setString("Pattern", pattern.getPatternID());
		tag.setInteger("Color", color.getDyeDamage());
		return tag;
	}
}
