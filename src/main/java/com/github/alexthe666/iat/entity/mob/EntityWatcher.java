package com.github.alexthe666.iat.entity.mob;

import java.util.Random;

import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityWatcher extends EntityMob{


	public EntityWatcher(World worldIn) {
		super(worldIn);
		this.setSize(0.9F, 0.9F);
		//this.noClip = true;
		
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityAnimal.class, 1.0D, false));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityAnimal.class, 8.0F));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityAnimal.class, true));

	}

	protected String getLivingSound()
	{
		return "iat:watcher_living";
	}
	protected String getHurtSound()
	{
		return "iat:watcher_hurt";
	}
	protected String getDeathSound()
	{
		return "iat:watcher_hurt";
	}
	public boolean isEntityInvulnerable(DamageSource dmg)
	{
		return dmg != DamageSource.outOfWorld && !dmg.isCreativePlayer();
	}

}
