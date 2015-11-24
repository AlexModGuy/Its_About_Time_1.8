package com.github.alexthe666.iat.entity.mob.ai;

import java.util.Collections;
import java.util.List;

import com.google.common.base.Predicates;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;

public class EntityAIAnomalocarisTarget extends EntityAINearestAttackableTarget {

	public EntityAIAnomalocarisTarget(EntityCreature mob, Class clazz, boolean idk) {
		super(mob, clazz, idk);
	}
	@Override
	public boolean shouldExecute()
	{
		if (this.taskOwner.getRNG().nextInt(10) != 0)
		{
			return false;
		}
		else
		{
			double d0 = this.getTargetDistance();
			List list = this.taskOwner.worldObj.getEntitiesWithinAABB(this.targetClass, this.taskOwner.getEntityBoundingBox().expand(d0, 4.0D, d0), Predicates.and(this.targetEntitySelector, IEntitySelector.NOT_SPECTATING));
			Collections.sort(list, this.theNearestAttackableTargetSorter);

			if (list.isEmpty())
			{
				return false;
			}
			else
			{
				this.targetEntity = (EntityLivingBase)list.get(0);
				if(targetEntity.riddenByEntity != null){
					return false;
				}
				if(taskOwner.ridingEntity != null){
					return false;
				}
				return true;
			}
		}
	}

	@Override
	public boolean continueExecuting()
	{
		EntityLivingBase entitylivingbase = this.taskOwner.getAttackTarget();
		if(entitylivingbase.riddenByEntity != null){
			return false;
		}
		else if(entitylivingbase.ridingEntity != null){
			return false;
		}else{
			return super.continueExecuting();
		}
	}
}
