package com.github.alexthe666.iat.client.render.entity;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import com.github.alexthe666.iat.client.model.entity.ModelWatcher;

public class RenderWatcher extends RenderLiving {

	public static ModelWatcher model = new ModelWatcher();
	public RenderWatcher() {
		super(Minecraft.getMinecraft().getRenderManager(), model, 0.3F);

	}

    protected void preRenderCallback(EntityLivingBase entity, float f){
    	GL11.glScalef(1.5F, 1.5F, 1.5F);
    }

	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("iat:textures/models/entity/watcher/watcher.png");
	}
	
}
