package com.github.alexthe666.iat.entity.mob;

import com.github.alexthe666.iat.entity.mob.ai.EntityAIAnomalocarisTarget;

import net.ilexiconn.llibrary.client.model.modelbase.ChainBuffer;
import net.ilexiconn.llibrary.common.animation.Animation;
import net.ilexiconn.llibrary.common.animation.IAnimated;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityAnomalocaris extends EntityIATAquatic implements IAnimated{

	public ChainBuffer tailbuffer = new ChainBuffer(4);
	public ChainBuffer bodybuffer = new ChainBuffer(4);
	private Animation currentAnimation;
	private int animTick;
	public static Animation animation_shakehead = new Animation(1, 80);
	public static Animation animation_strecharm = new Animation(2, 80);

	public EntityAnomalocaris(World worldIn) {
		super(worldIn);
		this.setSize(1.2F, 0.5F);
		this.targetTasks.addTask(1, new EntityAIAnomalocarisTarget(this, EntityRedlichia.class, true));

	}

	public void onUpdate(){
		super.onUpdate();
		Animation.tickAnimations(this);
		if(this.riddenByEntity == null){
			if(!this.worldObj.isRemote && this.getAttackTarget() == null && this.getRNG().nextInt(150) == 0 && this.getAnimation() == this.animation_none){
				if(this.getRNG().nextInt(2) == 0){
					this.setAnimation(animation_shakehead);
				}
				else{
					this.setAnimation(animation_strecharm);

				}
			}
		}
		tailbuffer.calculateChainSwingBuffer(70F, 5, 4, this);
		bodybuffer.calculateChainSwingBuffer(70F, 5, 4, this);
		tailbuffer.calculateChainWaveBuffer(70F, 5, 4, this);
		bodybuffer.calculateChainWaveBuffer(70F, 5, 4, this);
	}

	public void onLivingUpdate(){
		super.onLivingUpdate();
		if(getAttackTarget() != null){
			float d = this.getDistanceToEntity(getAttackTarget());
			if(d <= 1.78F){
				getAttackTarget().mountEntity(this);
				if(true){
					getAttackTarget().attackEntityFrom(DamageSource.generic, 1);
				}
			}
		}
	}

	public void updateRiderPosition()
	{
		super.updateRiderPosition();
		if (this.riddenByEntity != null)
		{
			rotationYaw = renderYawOffset;
			float radius = 0.4F * 0.2F - 0.6F;
			float angle = (0.01745329251F * this.renderYawOffset) + 3.15F;
			((EntityLivingBase)this.riddenByEntity).rotationYaw = (float) (angle * (180 / Math.PI) - 150.0F);
			double extraX = (double) (radius * MathHelper.sin((float) (Math.PI + angle)));
			double extraZ = (double) (radius * MathHelper.cos(angle));
			this.riddenByEntity.setPosition(this.posX + extraX, this.posY, this.posZ + extraZ);
			((EntityLivingBase)this.riddenByEntity).renderYawOffset = this.renderYawOffset * 3;
			((EntityLivingBase)this.riddenByEntity).rotationYaw = this.rotationYaw * 3;
		}
	}

	@Override
	public boolean isFreeSwimmer() {
		return true;
	}

	public void setAnimationTick(int tick) {
		animTick = tick;
	}

	public int getAnimationTick() {
		return animTick;
	}

	@Override
	public void setAnimation(Animation animation) {
		currentAnimation = animation;
	}

	@Override
	public Animation getAnimation() {
		return currentAnimation;
	}

	public final Animation[] animations() {
		return new Animation[]{this.animation_none, this.animation_shakehead, this.animation_strecharm};
	}

	@Override
	public double swimSpeed() {
		return 0.100000000372529D;
	}

	@Override
	public boolean shouldDismountInWater(Entity rider)
	{
		return false;
	}


}
