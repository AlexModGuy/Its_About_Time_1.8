package com.github.alexthe666.iat.item;

import java.util.Iterator;

import com.github.alexthe666.iat.ItsAboutTime;
import com.github.alexthe666.iat.entity.IATEntityList;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Ry_dog101
 */
public class ItemIATSpawnEgg extends ItemMonsterPlacer {

    public ItemIATSpawnEgg() {
        super();
        this.setCreativeTab(ItsAboutTime.tab_spawneggs);
        this.setUnlocalizedName("iat.spawnEgg");
		GameRegistry.registerItem(this, "spawnegg");
    }

    /**
     * Spawns the creature specified by the egg's type in the location specified by the last three parameters.
     * Parameters: world, entityID, x, y, z.
     */
    public static Entity spawnCreature(World world, int i, double x, double y, double z) {
        if (!IATEntityList.entities.containsKey(Integer.valueOf(i))) {
            return null;
        } else {
            Entity entity = null;

            for (int j = 0; j < 1; ++j) {
                entity = EntityList.createEntityByID(i, world);

                if (entity != null && entity instanceof EntityLivingBase) {
                    EntityLiving entityliving = (EntityLiving) entity;
                    entity.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
                    entityliving.rotationYawHead = entityliving.rotationYaw;
                    entityliving.renderYawOffset = entityliving.rotationYaw;
                    entityliving.func_180482_a(null, null);
                    world.spawnEntityInWorld(entity);
                    entityliving.playLivingSound();
                }
            }

            return entity;
        }
    }

    public String getItemStackDisplayName(ItemStack stack) {
        String s = ("" + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name")).trim();
        String s1 = IATEntityList.entities.get(stack.getItemDamage()).entityName;

        if (s1 != null) {
            s = s + " " + StatCollector.translateToLocal("entity." + s1 + ".name");
        }

        return s;
    }

    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack stack, int i) {
        IATEntityList.Entities entityegginfo = IATEntityList.entities.get(Integer.valueOf(stack.getItemDamage()));
        return entityegginfo != null ? (i == 0 ? entityegginfo.background : entityegginfo.forground) : 16777215;
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, java.util.List list) {
        Iterator iterator = IATEntityList.entities.values().iterator();

        while (iterator.hasNext()) {
            IATEntityList.Entities entityegginfo = (IATEntityList.Entities) iterator.next();
            	list.add(new ItemStack(item, 1, entityegginfo.id));
        }
    }
}