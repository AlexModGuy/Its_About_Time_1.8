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

	public BlockPos currentTarget;

	public EntityWatcher(World worldIn) {
		super(worldIn);
		this.setSize(0.9F, 0.9F);
		//this.noClip = true;
		
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityAnimal.class, 1.0D, false));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityAnimal.class, 8.0F));
        this.tasks.addTask(3, new EntityWatcher.AIRandomFly());
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

	public void onUpdate(){
		super.onUpdate();
	}

	public void onLivingUpdate(){
		super.onLivingUpdate();
		if(this.getAITarget() != null){
			//this.faceEntity(getAITarget(), 360, 360);
			currentTarget = new BlockPos((int) getAITarget().posX, ((int) getAITarget().posY + getAITarget().getEyeHeight()), (int) getAITarget().posZ);
			flyTowardsTarget();
		}
	}

	public void flyTowardsTarget()
	{
		if (currentTarget != null)
		{
			double targetX = currentTarget.getX() + 0.5D - posX;
			double targetY = currentTarget.getY() + 1D - posY;
			double targetZ = currentTarget.getZ() + 0.5D - posZ;
			motionX += (Math.signum(targetX) * 0.5D - motionX) * 0.10000000149011612D;
			motionY += (Math.signum(targetY) * 0.699999988079071D - motionY) * 0.10000000149011612D;
			motionZ += (Math.signum(targetZ) * 0.5D - motionZ) * 0.10000000149011612D;
			float angle = (float) (Math.atan2(motionZ, motionX) * 180.0D / Math.PI) - 90.0F;
			float rotation = MathHelper.wrapAngleTo180_float(angle - rotationYaw);
			moveForward = 0.5F;
			rotationYaw += rotation;
		}

	}
	
	class AIRandomFly extends EntityAIBase
    {
        private EntityWatcher field_179454_a = EntityWatcher.this;

        public AIRandomFly()
        {
            this.setMutexBits(1);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            EntityMoveHelper entitymovehelper = this.field_179454_a.getMoveHelper();

            if (!entitymovehelper.isUpdating())
            {
                return true;
            }
            else
            {
                double d0 = entitymovehelper.func_179917_d() - this.field_179454_a.posX;
                double d1 = entitymovehelper.func_179919_e() - this.field_179454_a.posY;
                double d2 = entitymovehelper.func_179918_f() - this.field_179454_a.posZ;
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                return d3 < 1.0D || d3 > 3600.0D;
            }
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean continueExecuting()
        {
            return false;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            Random random = this.field_179454_a.getRNG();
            double d0 = this.field_179454_a.posX + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d1 = this.field_179454_a.posY + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d2 = this.field_179454_a.posZ + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.field_179454_a.getMoveHelper().setMoveTo(d0, d1, d2, 1.0D);
        }
    }
	  class WatcherMoveHelper extends EntityMoveHelper
	    {
	        private EntityWatcher field_179927_g = EntityWatcher.this;
	        private int field_179928_h;

	        public WatcherMoveHelper()
	        {
	            super(EntityWatcher.this);
	        }

	        public void onUpdateMoveHelper()
	        {
	            if (this.update)
	            {
	                double d0 = this.posX - this.field_179927_g.posX;
	                double d1 = this.posY - this.field_179927_g.posY;
	                double d2 = this.posZ - this.field_179927_g.posZ;
	                double d3 = d0 * d0 + d1 * d1 + d2 * d2;

	                if (this.field_179928_h-- <= 0)
	                {
	                    this.field_179928_h += this.field_179927_g.getRNG().nextInt(5) + 2;
	                    d3 = (double)MathHelper.sqrt_double(d3);

	                    if (this.func_179926_b(this.posX, this.posY, this.posZ, d3))
	                    {
	                        this.field_179927_g.motionX += d0 / d3 * 0.1D;
	                        this.field_179927_g.motionY += d1 / d3 * 0.1D;
	                        this.field_179927_g.motionZ += d2 / d3 * 0.1D;
	                    }
	                    else
	                    {
	                        this.update = false;
	                    }
	                }
	            }
	        }

	        private boolean func_179926_b(double p_179926_1_, double p_179926_3_, double p_179926_5_, double p_179926_7_)
	        {
	            double d4 = (p_179926_1_ - this.field_179927_g.posX) / p_179926_7_;
	            double d5 = (p_179926_3_ - this.field_179927_g.posY) / p_179926_7_;
	            double d6 = (p_179926_5_ - this.field_179927_g.posZ) / p_179926_7_;
	            AxisAlignedBB axisalignedbb = this.field_179927_g.getEntityBoundingBox();

	            for (int i = 1; (double)i < p_179926_7_; ++i)
	            {
	                axisalignedbb = axisalignedbb.offset(d4, d5, d6);

	                if (!this.field_179927_g.worldObj.getCollidingBoundingBoxes(this.field_179927_g, axisalignedbb).isEmpty())
	                {
	                    return false;
	                }
	            }

	            return true;
	        }
	    }
}
