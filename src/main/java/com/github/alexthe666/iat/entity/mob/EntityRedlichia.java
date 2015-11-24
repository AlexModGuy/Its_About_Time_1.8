package com.github.alexthe666.iat.entity.mob;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.world.World;

import com.google.common.base.Predicate;

public class EntityRedlichia extends EntityIATAquatic{

	public EntityRedlichia(World worldIn) {
		super(worldIn);
		this.setSize(0.5F, 0.4F);
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
		this.tasks.addTask(9, new EntityAIAvoidEntity(this, new Predicate()
		{
			public boolean check(Entity entity)
			{
				return entity instanceof EntityLivingBase;
			}
			public boolean apply(Object entity)
			{
				return this.check((Entity)entity);
			}
		}, 16.0F, 0.8D, 1.33D));
		this.tasks.addTask(11, new EntityAIWander(this, 1.0F));

	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
	}

	@Override
	public boolean isFreeSwimmer() {
		return false;
	}

	@Override
	public double swimSpeed() {
		return 0.01000000372529D;
	}

}
