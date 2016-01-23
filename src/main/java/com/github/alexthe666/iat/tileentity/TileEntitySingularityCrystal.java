package com.github.alexthe666.iat.tileentity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ITickable;

import com.github.alexthe666.iat.core.ModBlocks;

public class TileEntitySingularityCrystal extends TileEntity implements ITickable{

	private AxisAlignedBB boundingBox = new AxisAlignedBB((double)pos.getX() - 9, (double)pos.getY() - 9, (double)pos.getZ() - 9, (double)pos.getX() + 9, (double)pos.getY() + 9, (double)pos.getZ() + 9);
	public float ticksExisted;
	public TileEntitySunstone sunstone;
	
	@Override
	public void update() {
		List<TileEntitySunstone> sunstones = new ArrayList<TileEntitySunstone>();
		Random rand = new Random();
			for (int i = -2; i <= 2; ++i)
			{
				for (int j = -2; j <= 2; ++j)
				{
					if (i > -2 && i < 2 && j == -1)
					{
						j = 2;
					}

					for (int k = 0; k <= 1; ++k)
					{
						BlockPos blockpos1 = pos.add(i, k, j);

						if (worldObj.getBlockState(blockpos1).getBlock() == ModBlocks.sunstone)
						{
							if (!worldObj.isAirBlock(pos.add(i / 2, 0, j / 2)))
							{
								break;
							}
							this.attackSunstone((TileEntitySunstone)worldObj.getTileEntity(blockpos1));
						}
					}
				}
			}

		ticksExisted++;
	}

	private void attackSunstone(TileEntitySunstone tileEntity) {
		sunstone = tileEntity;
	}
}
