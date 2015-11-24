package com.github.alexthe666.iat.client.model.entity;

import org.lwjgl.opengl.GL11;

import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelBase;
import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;
import net.minecraft.entity.Entity;

import com.github.alexthe666.iat.client.model.ModelUtils;

public class ModelWatcher extends MowzieModelBase {
    public MowzieModelRenderer segment1;
    public MowzieModelRenderer segment2;
    public MowzieModelRenderer head;
    public MowzieModelRenderer segment3;
    public MowzieModelRenderer segment4;
    public MowzieModelRenderer tailup;
    public MowzieModelRenderer taildown;
    public MowzieModelRenderer eyeOverlay;

    public ModelWatcher() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.taildown = new MowzieModelRenderer(this, 0, 7);
        this.taildown.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.taildown.addBox(0.0F, -2.5F, -3.0F, 0, 5, 6, 0.0F);
        this.setRotateAngle(taildown, 0.0F, 0.0F, 1.5707963267948966F);
        this.head = new MowzieModelRenderer(this, 44, 0);
        this.head.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.head.addBox(-2.5F, -2.5F, 0.0F, 5, 5, 2, 0.0F);
        this.segment3 = new MowzieModelRenderer(this, 40, 7);
        this.segment3.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.segment3.addBox(-2.0F, -2.0F, -4.0F, 4, 4, 4, 0.0F);
        this.segment4 = new MowzieModelRenderer(this, 22, 9);
        this.segment4.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.segment4.addBox(-1.5F, -1.5F, -4.0F, 3, 3, 4, 0.0F);
        this.segment2 = new MowzieModelRenderer(this, 26, 0);
        this.segment2.setRotationPoint(0.0F, 0.0F, -5.0F);
        this.segment2.addBox(-2.5F, -2.5F, -4.0F, 5, 5, 4, 0.0F);
        this.segment1 = new MowzieModelRenderer(this, 0, 0);
        this.segment1.setRotationPoint(0.0F, 21.0F, -6.0F);
        this.segment1.addBox(-3.0F, -3.0F, -5.0F, 6, 6, 7, 0.0F);
        this.setRotateAngle(segment1, 0, (float)Math.toRadians(180.00), 0);
        this.tailup = new MowzieModelRenderer(this, 0, 7);
        this.tailup.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.tailup.addBox(0.0F, -2.5F, -3.0F, 0, 5, 6, 0.0F);
        this.eyeOverlay = new MowzieModelRenderer(this, 53, 15);
        this.eyeOverlay.setRotationPoint(0.0F, 21.0F, -8.0F);
        this.eyeOverlay.addBox(-2.5F, -2.5F, -2.0F, 5, 5, 0, 0.0F);
        this.segment4.addChild(this.taildown);
        this.segment1.addChild(this.head);
        this.segment2.addChild(this.segment3);
        this.segment3.addChild(this.segment4);
        this.segment1.addChild(this.segment2);
        this.segment4.addChild(this.tailup);
        ModelUtils.doMowzieStuff(boxList, false);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.segment1.render(f5);
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        this.eyeOverlay.render(f5);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
        ModelUtils.doMowzieStuff(boxList, true);

    }
    
    @Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		eyeOverlay.rotateAngleX = head.rotateAngleX;
		eyeOverlay.rotateAngleY = head.rotateAngleY;
		eyeOverlay.rotateAngleZ = head.rotateAngleZ;

    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(MowzieModelRenderer MowzieModelRenderer, float x, float y, float z) {
        MowzieModelRenderer.rotateAngleX = x;
        MowzieModelRenderer.rotateAngleY = y;
        MowzieModelRenderer.rotateAngleZ = z;
    }
}
