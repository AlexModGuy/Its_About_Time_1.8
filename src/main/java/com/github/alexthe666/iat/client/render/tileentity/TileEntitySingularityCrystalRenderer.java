package com.github.alexthe666.iat.client.render.tileentity;

import java.util.Random;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.github.alexthe666.forge.obj.AdvancedModelLoader;
import com.github.alexthe666.forge.obj.IModelCustom;
import com.github.alexthe666.iat.tileentity.TileEntitySingularityCrystal;

public class TileEntitySingularityCrystalRenderer extends TileEntitySpecialRenderer {

	private static final ResourceLocation enderDragonCrystalBeamTextures = new ResourceLocation("textures/entity/endercrystal/endercrystal_beam.png");

	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f, int f1) {
		IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation("iat:models/singularitycrystal/singularitycrystal.obj"));
		TileEntitySingularityCrystal crystal = (TileEntitySingularityCrystal)entity;
		float bob = (float) (Math.sin(crystal.ticksExisted * 0.05F) * 1 * 0.1F - 1 * 0.1F);

		GL11.glPushMatrix();
		
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F);
		GL11.glTranslatef(0, -bob, 0);
		GL11.glScalef(0.4F, 0.4F, 0.4F);
		GL11.glRotatef(crystal.ticksExisted * 1F, 0, 1, 0);
		GL11.glTranslatef((float)0F, (float)1F, (float)2F);
		doDragonEffect();
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F);
		GL11.glTranslatef(0, -bob, 0);
		GL11.glRotatef(crystal.ticksExisted * 1F, 0, 1, 0);
		GL11.glRotatef(90F, 1, 0, 0);
		GL11.glScalef(0.6F, 0.6F, 0.6F);
		this.bindTexture(new ResourceLocation("iat:models/singularitycrystal/singularitycrystal.png"));
		GL11.glPushMatrix();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.enableNormalize();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(770, 771);
		GlStateManager.disableCull();
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);
		model.renderAll();
		GlStateManager.enableCull();
		GlStateManager.disableBlend();
		GlStateManager.disableNormalize();
		GL11.glPopMatrix();
		GL11.glPopMatrix();


	}
	/* GL11.glEnable(GL11.GL_NORMALIZE);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);*/
	private void doDragonEffect(){
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		RenderHelper.disableStandardItemLighting();
		float f7 = 120 / 200.0F;
		float f8 = 0.0F;

		if (f7 > 0.8F)
		{
			f8 = (f7 - 0.8F) / 0.2F;
		}

		Random random = new Random(432L);
		GlStateManager.disableTexture2D();
		GlStateManager.shadeModel(7425);
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(770, 1);
		GlStateManager.disableAlpha();
		GlStateManager.enableCull();
		GlStateManager.depthMask(false);
		GlStateManager.pushMatrix();
		GlStateManager.translate(0.0F, -1.0F, -2.0F);

		for (int i = 0; (float)i < (f7 + f7 * f7) / 2.0F * 30.0F; ++i)
		{
			GlStateManager.rotate(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotate(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
			GlStateManager.rotate(random.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
			GlStateManager.rotate(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotate(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
			GlStateManager.rotate(random.nextFloat() * 360.0F + f7 * 90.0F, 0.0F, 0.0F, 1.0F);
            worldrenderer.begin(6, DefaultVertexFormats.POSITION_COLOR);
			float f9 = random.nextFloat() * 2.0F + f8 * 10.0F;
			float f10 = random.nextFloat() * 2.0F + 1.0F + f8 * 2.0F;
			worldrenderer.pos(0.0D, 0.0D, 0.0D).color(255, 255, 255, (int)(255.0F * (1.0F - f8))).endVertex();
			worldrenderer.pos(-0.866D * (double)f10, (double)f9, (double)(-0.5F * f10)).color(0, 0, 0, 0).endVertex();
			worldrenderer.pos(0.866D * (double)f10, (double)f9, (double)(-0.5F * f10)).color(0, 0, 0, 0).endVertex();
			worldrenderer.pos(0.0D, (double)f9, (double)(1.0F * f10)).color(0, 0, 0, 0).endVertex();
			worldrenderer.pos(-0.866D * (double)f10, (double)f9, (double)(-0.5F * f10)).color(0, 0, 0, 0).endVertex();
			tessellator.draw();
		}

		GlStateManager.popMatrix();
		GlStateManager.depthMask(true);
		GlStateManager.disableCull();
		GlStateManager.disableBlend();
		GlStateManager.shadeModel(7424);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.enableTexture2D();
		GlStateManager.enableAlpha();
		RenderHelper.enableStandardItemLighting();
	}

}
