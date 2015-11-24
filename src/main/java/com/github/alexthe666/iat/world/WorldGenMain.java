package com.github.alexthe666.iat.world;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import com.github.alexthe666.iat.world.gen.timedungeon.WorldGenTimeDungeon;

public class WorldGenMain implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if(world.provider.getDimensionId() == 0){
			if (random.nextInt(8) == 0)
			{
				int Xcoord1 = chunkX * 16 + random.nextInt(16);
				int Zcoord1 = chunkZ * 16 + random.nextInt(16);
				int Ycoord1 = 65;
				//new WorldGenTimeDungeon().generate(world, random, new BlockPos(Xcoord1, Ycoord1, Zcoord1));
			}
		}
	}

}
