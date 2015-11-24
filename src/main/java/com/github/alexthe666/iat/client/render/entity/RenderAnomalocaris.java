package com.github.alexthe666.iat.client.render.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.github.alexthe666.iat.client.model.entity.ModelAnomalocaris;
import com.github.alexthe666.iat.client.model.entity.ModelRedlichia;

public class RenderAnomalocaris extends RenderLiving {

	public static ModelAnomalocaris model = new ModelAnomalocaris();

	public RenderAnomalocaris() {
		super(Minecraft.getMinecraft().getRenderManager(), model, 0.3F);
	}

	protected void preRenderCallback(EntityLivingBase entity, float f){
		GL11.glScalef(0.8F, 0.8F, 0.8F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("iat:textures/models/entity/anomalocaris/anomalocaris.png");
	}
}
