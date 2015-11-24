package com.github.alexthe666.iat.core;

import java.util.Random;

import net.minecraft.entity.EntityList;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.github.alexthe666.iat.ItsAboutTime;
import com.github.alexthe666.iat.entity.IATEntityList;
import com.github.alexthe666.iat.entity.mob.EntityAnomalocaris;
import com.github.alexthe666.iat.entity.mob.EntityRedlichia;
import com.github.alexthe666.iat.entity.mob.EntityWatcher;


public class ModEntities{

	public static void init(){
		//registerSpawnable(EntityWatcher.class, "iat.watcher", 0, 0, 64);
		registerSpawnable(EntityRedlichia.class, "iat.redlichia", 0X382A1A, 0X4C3923, 64);
		registerSpawnable(EntityAnomalocaris.class, "iat.anomalocaris", 0XF1D7B4, 0XA36528, 64);

	}
	public static void registerSpawnable(Class entityClass, String name, int mainColor, int subColor, int range){
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, name, entityId);
		EntityRegistry.registerModEntity(entityClass, name, entityId, ItsAboutTime.instance, 64, 1, true);
		IATEntityList.addToList(entityClass, name, entityId, mainColor, subColor, ModItems.spawnegg);
	}
	
	public static void registerUnspawnable(Class entityClass, String name){
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, name, entityId);
		EntityRegistry.registerModEntity(entityClass, name, entityId, ItsAboutTime.instance, 64, 1, true);

	}
}
