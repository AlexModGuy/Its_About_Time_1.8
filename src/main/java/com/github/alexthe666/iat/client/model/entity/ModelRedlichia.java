package com.github.alexthe666.iat.client.model.entity;

import org.lwjgl.opengl.GL11;

import com.github.alexthe666.iat.client.model.ModelUtils;

import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelBase;
import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRedlichia extends MowzieModelBase {
    public MowzieModelRenderer bodyMain;
    public MowzieModelRenderer crest;
    public MowzieModelRenderer bodyLeft;
    public MowzieModelRenderer bodyRight;
    public MowzieModelRenderer backBody;
    public MowzieModelRenderer underbody;
    public MowzieModelRenderer head;
    public MowzieModelRenderer crestFront;
    public MowzieModelRenderer spineRight;
    public MowzieModelRenderer spineLeft;
    public MowzieModelRenderer underhead;
    public MowzieModelRenderer backRightPlate;
    public MowzieModelRenderer backLeftPlate;
    public MowzieModelRenderer backPlate;
    public MowzieModelRenderer legRight1;
    public MowzieModelRenderer legRight2;
    public MowzieModelRenderer legRight3;
    public MowzieModelRenderer legRight4;
    public MowzieModelRenderer legRight5;
    public MowzieModelRenderer legRight6;
    public MowzieModelRenderer legLeft1;
    public MowzieModelRenderer legLeft2;
    public MowzieModelRenderer legLeft3;
    public MowzieModelRenderer legLeft5;
    public MowzieModelRenderer legLeft6;
    public MowzieModelRenderer legLeft4;

    public ModelRedlichia() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.crest = new MowzieModelRenderer(this, 0, 26);
        this.crest.setRotationPoint(0.0F, 0.0F, -4.5F);
        this.crest.addBox(-2.0F, -2.1F, -4.0F, 4, 2, 4, 0.0F);
        this.setRotateAngle(crest, 0.2792526803190927F, 0.0F, 0.0F);
        this.crestFront = new MowzieModelRenderer(this, 12, 26);
        this.crestFront.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.crestFront.addBox(-3.0F, -1.0F, -1.0F, 6, 2, 1, 0.0F);
        this.legLeft2 = new MowzieModelRenderer(this, 0, 0);
        this.legLeft2.setRotationPoint(-1.5F, 1.0F, -2.0F);
        this.legLeft2.addBox(-3.0F, 0.0F, -0.5F, 3, 0, 1, 0.0F);
        this.setRotateAngle(legLeft2, 0.0F, 0.0F, -0.17453292519943295F);
        this.bodyRight = new MowzieModelRenderer(this, 28, 0);
        this.bodyRight.setRotationPoint(2.5F, -1.0F, 0.0F);
        this.bodyRight.addBox(0.0F, 0.0F, -4.5F, 2, 1, 9, 0.0F);
        this.setRotateAngle(bodyRight, 0.0F, 0.0F, 0.7853981633974483F);
        this.head = new MowzieModelRenderer(this, 0, 20);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-4.5F, -1.0F, -4.0F, 9, 2, 4, 0.0F);
        this.setRotateAngle(head, -0.2792526803190927F, 0.0F, 0.0F);
        this.bodyMain = new MowzieModelRenderer(this, 0, 0);
        this.bodyMain.setRotationPoint(0.0F, 22.0F, 0.0F);
        this.bodyMain.addBox(-2.5F, -1.0F, -4.5F, 5, 2, 9, 0.0F);
        this.underhead = new MowzieModelRenderer(this, 33, 28);
        this.underhead.setRotationPoint(0.0F, 1.0F, -0.8F);
        this.underhead.addBox(-1.5F, -0.5F, -3.0F, 3, 1, 3, 0.0F);
        this.setRotateAngle(underhead, -0.22689280275926282F, 0.0F, 0.0F);
        this.backPlate = new MowzieModelRenderer(this, 11, 14);
        this.backPlate.setRotationPoint(0.0F, -0.5F, 1.8F);
        this.backPlate.addBox(-2.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
        this.setRotateAngle(backPlate, -0.6373942428283291F, 0.0F, 0.0F);
        this.legRight6 = new MowzieModelRenderer(this, 0, 0);
        this.legRight6.setRotationPoint(1.5F, 1.0F, 4.0F);
        this.legRight6.addBox(0.0F, 0.0F, -0.5F, 3, 0, 1, 0.0F);
        this.setRotateAngle(legRight6, 0.0F, 0.0F, 0.17453292519943295F);
        this.backBody = new MowzieModelRenderer(this, 0, 11);
        this.backBody.setRotationPoint(0.0F, 0.0F, 4.5F);
        this.backBody.addBox(-2.0F, -1.0F, 0.0F, 4, 2, 2, 0.0F);
        this.legLeft5 = new MowzieModelRenderer(this, 0, 0);
        this.legLeft5.setRotationPoint(-1.5F, 1.0F, 2.5F);
        this.legLeft5.addBox(-3.0F, 0.0F, -0.5F, 3, 0, 1, 0.0F);
        this.setRotateAngle(legLeft5, 0.0F, 0.0F, -0.17453292519943295F);
        this.bodyLeft = new MowzieModelRenderer(this, 28, 0);
        this.bodyLeft.mirror = true;
        this.bodyLeft.setRotationPoint(-2.5F, -1.0F, 0.0F);
        this.bodyLeft.addBox(-2.0F, 0.0F, -4.5F, 2, 1, 9, 0.0F);
        this.setRotateAngle(bodyLeft, 0.0F, 0.0F, -0.7853981633974483F);
        this.legRight2 = new MowzieModelRenderer(this, 0, 0);
        this.legRight2.setRotationPoint(1.5F, 1.0F, -2.0F);
        this.legRight2.addBox(0.0F, 0.0F, -0.5F, 3, 0, 1, 0.0F);
        this.setRotateAngle(legRight2, 0.0F, 0.0F, 0.17453292519943295F);
        this.legLeft4 = new MowzieModelRenderer(this, 0, 0);
        this.legLeft4.setRotationPoint(-1.5F, 1.0F, 1.0F);
        this.legLeft4.addBox(-3.0F, 0.0F, -0.5F, 3, 0, 1, 0.0F);
        this.setRotateAngle(legLeft4, 0.0F, 0.0F, -0.17453292519943295F);
        this.legRight3 = new MowzieModelRenderer(this, 0, 0);
        this.legRight3.setRotationPoint(1.5F, 1.0F, -0.5F);
        this.legRight3.addBox(0.0F, 0.0F, -0.5F, 3, 0, 1, 0.0F);
        this.setRotateAngle(legRight3, 0.0F, 0.0F, 0.17453292519943295F);
        this.legLeft3 = new MowzieModelRenderer(this, 0, 0);
        this.legLeft3.setRotationPoint(-1.5F, 1.0F, -0.5F);
        this.legLeft3.addBox(-3.0F, 0.0F, -0.5F, 3, 0, 1, 0.0F);
        this.setRotateAngle(legLeft3, 0.0F, 0.0F, -0.17453292519943295F);
        this.underbody = new MowzieModelRenderer(this, 26, 17);
        this.underbody.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.underbody.addBox(-1.5F, 0.0F, -5.5F, 3, 1, 10, 0.0F);
        this.legLeft6 = new MowzieModelRenderer(this, 0, 0);
        this.legLeft6.setRotationPoint(-1.5F, 1.0F, 4.0F);
        this.legLeft6.addBox(-3.0F, 0.0F, -0.5F, 3, 0, 1, 0.0F);
        this.setRotateAngle(legLeft6, 0.0F, 0.0F, -0.17453292519943295F);
        this.backRightPlate = new MowzieModelRenderer(this, 12, 11);
        this.backRightPlate.setRotationPoint(2.0F, -1.0F, 0.0F);
        this.backRightPlate.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(backRightPlate, -0.2617993877991494F, 0.0F, 0.7853981633974483F);
        this.spineRight = new MowzieModelRenderer(this, 0, 16);
        this.spineRight.setRotationPoint(4.0F, 0.4F, -0.5F);
        this.spineRight.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(spineRight, 0.0F, 0.3141592653589793F, 0.0F);
        this.spineLeft = new MowzieModelRenderer(this, 0, 16);
        this.spineLeft.setRotationPoint(-4.0F, 0.4F, -0.5F);
        this.spineLeft.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(spineLeft, 0.0F, -0.3141592653589793F, 0.0F);
        this.legLeft1 = new MowzieModelRenderer(this, 0, 0);
        this.legLeft1.setRotationPoint(-1.5F, 1.0F, -3.5F);
        this.legLeft1.addBox(-3.0F, 0.0F, -0.5F, 3, 0, 1, 0.0F);
        this.setRotateAngle(legLeft1, -0.0054105206811824215F, 0.0F, -0.17453292519943295F);
        this.legRight1 = new MowzieModelRenderer(this, 0, 0);
        this.legRight1.setRotationPoint(1.5F, 1.0F, -3.5F);
        this.legRight1.addBox(0.0F, 0.0F, -0.5F, 3, 0, 1, 0.0F);
        this.setRotateAngle(legRight1, 0.0F, 0.0F, 0.17453292519943295F);
        this.backLeftPlate = new MowzieModelRenderer(this, 12, 11);
        this.backLeftPlate.setRotationPoint(-2.0F, -1.0F, 0.0F);
        this.backLeftPlate.addBox(-2.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(backLeftPlate, -0.2617993877991494F, 0.0F, -0.7853981633974483F);
        this.legRight5 = new MowzieModelRenderer(this, 0, 0);
        this.legRight5.setRotationPoint(1.5F, 1.0F, 2.5F);
        this.legRight5.addBox(0.0F, 0.0F, -0.5F, 3, 0, 1, 0.0F);
        this.setRotateAngle(legRight5, 0.0F, 0.0F, 0.17453292519943295F);
        this.legRight4 = new MowzieModelRenderer(this, 0, 0);
        this.legRight4.setRotationPoint(1.5F, 1.0F, 1.0F);
        this.legRight4.addBox(0.0F, 0.0F, -0.5F, 3, 0, 1, 0.0F);
        this.setRotateAngle(legRight4, 0.0F, 0.0F, 0.17453292519943295F);
        this.bodyMain.addChild(this.crest);
        this.head.addChild(this.crestFront);
        this.underbody.addChild(this.legLeft2);
        this.bodyMain.addChild(this.bodyRight);
        this.crest.addChild(this.head);
        this.head.addChild(this.underhead);
        this.backBody.addChild(this.backPlate);
        this.underbody.addChild(this.legRight6);
        this.bodyMain.addChild(this.backBody);
        this.underbody.addChild(this.legLeft5);
        this.bodyMain.addChild(this.bodyLeft);
        this.underbody.addChild(this.legRight2);
        this.underbody.addChild(this.legLeft4);
        this.underbody.addChild(this.legRight3);
        this.underbody.addChild(this.legLeft3);
        this.bodyMain.addChild(this.underbody);
        this.underbody.addChild(this.legLeft6);
        this.backBody.addChild(this.backRightPlate);
        this.head.addChild(this.spineRight);
        this.head.addChild(this.spineLeft);
        this.underbody.addChild(this.legLeft1);
        this.underbody.addChild(this.legRight1);
        this.backBody.addChild(this.backLeftPlate);
        this.underbody.addChild(this.legRight5);
        this.underbody.addChild(this.legRight4);
        ModelUtils.doMowzieStuff(boxList, false);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        ModelUtils.renderAll(boxList);
        ModelUtils.doMowzieStuff(boxList, true);

    }
    
    @Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        ModelUtils.doMowzieStuff(boxList, true);
        float globalSpeed = 1.6F;
        MowzieModelRenderer[] rightLegs = {this.legRight1, this.legRight2, this.legRight3, this.legRight4, this.legRight5, this.legRight6};
        MowzieModelRenderer[] leftLegs = {this.legLeft1, this.legLeft2, this.legLeft3, this.legLeft4, this.legLeft5, this.legLeft6};
        MowzieModelRenderer[] body = {this.crest, this.bodyMain, this.backBody};
        this.chainSwing(rightLegs, globalSpeed, 0.6F, 3, f, f1);
		this.chainSwing(leftLegs, globalSpeed, -0.6F, 3, f, f1);
		
		if (this.isRiding)
        {
			globalSpeed = 0.3F;
			this.chainFlap(rightLegs, globalSpeed, 0.6F, 3, entity.ticksExisted, 1);
			this.chainFlap(leftLegs, globalSpeed, -0.6F, 3, entity.ticksExisted, 1);
			this.chainWave(body, globalSpeed, -0.6F, 2, entity.ticksExisted, 1);
			
        }
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
