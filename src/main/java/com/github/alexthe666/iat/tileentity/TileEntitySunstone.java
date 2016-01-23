package com.github.alexthe666.iat.tileentity;

import java.util.Random;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntitySunstone extends TileEntity implements ITickable{

	public float ticksExisted;
	public float innerRotation;
	public int prevPosX;
	public int prevPosY;
	public int prevPosZ;

	public TileEntitySunstone(){
        this.innerRotation = new Random().nextInt(100000);
	}
	@Override
	public void update() {
		prevPosX = pos.getX();
		prevPosY = pos.getY();
		prevPosZ = pos.getZ();
		ticksExisted++;
        innerRotation++;
	}
	
	public double getDistanceSqToTileEntity(TileEntity tile)
	{
		double d0 = this.pos.getX() - tile.getPos().getX();
		double d1 = this.pos.getY() - tile.getPos().getY();
		double d2 = this.pos.getZ() - tile.getPos().getZ();
		return d0 * d0 + d1 * d1 + d2 * d2;
	}
}
