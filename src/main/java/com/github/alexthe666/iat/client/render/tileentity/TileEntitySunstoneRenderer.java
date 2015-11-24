package com.github.alexthe666.iat.client.render.tileentity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import com.github.alexthe666.iat.core.ModItems;
import com.github.alexthe666.iat.tileentity.TileEntitySunstone;

public class TileEntitySunstoneRenderer extends TileEntitySpecialRenderer {
    
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f, int f1) {
	   
		TileEntitySunstone sunstone = (TileEntitySunstone)entity;
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1F, (float) z + 0.5F);
		float bob = (float) (Math.sin(sunstone.ticksExisted * 0.05F) * 1 * 0.1F - 1 * 0.1F);
		GL11.glTranslatef(0, bob, 0);
		GL11.glRotatef(sunstone.ticksExisted * 3.1F, 0, 1, 0);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		Minecraft.getMinecraft().getItemRenderer().renderItem((EntityLivingBase)null, new ItemStack(ModItems.gem_tempus), TransformType.NONE);
		GL11.glPopMatrix();
	}

}
