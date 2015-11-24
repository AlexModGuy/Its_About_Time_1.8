package com.github.alexthe666.iat.client.render.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.github.alexthe666.iat.client.model.entity.ModelRedlichia;

public class RenderRedlichia extends RenderLiving {

	public static ModelRedlichia model = new ModelRedlichia();

	public RenderRedlichia() {
		super(Minecraft.getMinecraft().getRenderManager(), model, 0.3F);
	}

	protected void preRenderCallback(EntityLivingBase entity, float f){
		GL11.glScalef(0.5F, 0.5F, 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("iat:textures/models/entity/redlichia/redlichia.png");
	}
}
