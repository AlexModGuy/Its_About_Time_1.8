package com.github.alexthe666.iat.entity;

import java.util.HashMap;
import java.util.LinkedHashMap;

import net.minecraft.creativetab.CreativeTabs;

import com.github.alexthe666.iat.ItsAboutTime;
import com.github.alexthe666.iat.item.ItemIATSpawnEgg;

/**
 * @author Ry_dog101
 */
public class IATEntityList {
    public static HashMap<Integer, Entities> entities = new LinkedHashMap<Integer, Entities>();

    /**
     * @param entityClass Class of entity
     * @param entityName  Name of entity
     * @param entityID    ID of entity
     * @param background  Background colour for Entity Spawn Egg
     * @param foreground  Foreground colour for Entity Spawn Egg
     * @param spawnEgg    Instance of Spawn Egg Item
     */
    public static void addToList(Class entityClass, String entityName, int entityID, int background, int foreground, ItemIATSpawnEgg spawnEgg) {
        entities.put(entityID, new Entities(entityClass, entityName, entityID, background, foreground, ItsAboutTime.tab_spawneggs));
    }

    public static class Entities {
        public final Class entityClass;

        public final String entityName;

        public final int id;

        public final int background;

        public final int forground;

        public final CreativeTabs creativeTab;

        public Entities(Class entityClass, String entityName, int id, int background, int forground, CreativeTabs creativeTab) {
            this.entityClass = entityClass;
            this.entityName = entityName;
            this.id = id;
            this.background = background;
            this.forground = forground;
            this.creativeTab = creativeTab;
        }
    }
}