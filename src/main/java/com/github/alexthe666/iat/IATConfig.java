package com.github.alexthe666.iat;

import net.ilexiconn.llibrary.common.config.IConfigHandler;
import net.minecraftforge.common.config.Configuration;

public class IATConfig implements IConfigHandler {

    public static boolean vanillaSpawnEggs;

	@Override
	public void loadConfig(Configuration config) {
		vanillaSpawnEggs = config.get("toggle", "Add vanilla spawn eggs for iat mobs. Use if normal spawn eggs do not work.", false).getBoolean(false);
	}

}
