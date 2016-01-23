package com.github.alexthe666.iat.entity.mob.ai;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.github.alexthe666.iat.entity.mob.EntityIATAquatic;

public class EntityAIWaterFindTarget extends EntityAIBase
{
	private EntityIATAquatic mob;
	private double shelterX;
	private double shelterY;
	private double shelterZ;
	private double movementSpeed;
	private World theWorld;

	public EntityAIWaterFindTarget(EntityIATAquatic mob, double speed)
	{
		this.mob = mob;
		this.movementSpeed = speed;
		this.theWorld = mob.worldObj;
		this.setMutexBits(1);
	}

	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	public boolean shouldExecute()
	{
		if(mob.isDirectPathBetweenPoints(mob.getPositionVector(), new Vec3(shelterX, shelterY, shelterZ))){
			mob.currentTarget = null;
		}

		if(mob.currentTarget != null && mob.getDistance(mob.currentTarget.getX(), mob.currentTarget.getY(), mob.currentTarget.getZ()) < 10F){
			return false;
		}
		else
		{
			Vec3 vec3 = this.findWaterTarget();

			if (vec3 == null)
			{
				return false;
			}
			else
			{
				this.shelterX = vec3.xCoord;
				this.shelterY = vec3.yCoord;
				this.shelterZ = vec3.zCoord;
				mob.shelterX = this.shelterX;
				mob.shelterY = this.shelterY;
				mob.shelterZ = this.shelterZ;
				return true;
			}
		}
	}

	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	public boolean continueExecuting()
	{
		return mob.currentTarget != null;
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	public void startExecuting()
	{
		this.mob.currentTarget = new BlockPos(shelterX, shelterY, shelterZ);
	}

	public Vec3 findWaterTarget()
	{
		if(mob.getAttackTarget() == null || mob.ridingEntity != null && mob.getAttackTarget() != null){
			Random random = this.mob.getRNG();
			mob.setAttackTarget(null);
			BlockPos blockpos = new BlockPos(this.mob.posX, this.mob.getEntityBoundingBox().minY, this.mob.posZ);

			for (int i = 0; i < 10; ++i)
			{
				BlockPos blockpos1;
				if(mob.isFreeSwimmer()){
					blockpos1 = blockpos.add(random.nextInt(20) - 10, random.nextInt(6) - 3, random.nextInt(20) - 10);
				}
				else{
					blockpos1 = blockpos.add(random.nextInt(20) - 10, 0, random.nextInt(20) - 10);	
				}
				if (mob.worldObj.getBlockState(blockpos1).getBlock().getMaterial() == Material.water)
				{
					return new Vec3((double)blockpos1.getX(), (double)blockpos1.getY(), (double)blockpos1.getZ());
				}
			}
		}else{
			Random random = this.mob.getRNG();
			BlockPos blockpos = new BlockPos(this.mob.posX, this.mob.getEntityBoundingBox().minY, this.mob.posZ);

			for (int i = 0; i < 10; ++i)
			{
				BlockPos blockpos1;
				if(mob.isFreeSwimmer()){
					blockpos1 = new BlockPos(mob.getAttackTarget());
				}
				else{
					blockpos1 = new BlockPos(mob.getAttackTarget().posX, mob.getAttackTarget().posY, mob.getAttackTarget().posZ);
				}
				if (mob.worldObj.getBlockState(blockpos1).getBlock().getMaterial() == Material.water)
				{
					return new Vec3((double)blockpos1.getX(), (double)blockpos1.getY(), (double)blockpos1.getZ());
				}
			}
			//return mob.getAttackTarget().getPositionVector();
		}

		return null;
	}


}