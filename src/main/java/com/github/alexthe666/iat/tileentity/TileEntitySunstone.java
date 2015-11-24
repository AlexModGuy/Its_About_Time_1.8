package com.github.alexthe666.iat.tileentity;

import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySunstone extends TileEntity implements IUpdatePlayerListBox{

	public float ticksExisted;
	@Override
	public void update() {
		ticksExisted++;
	}
}
