package io.cyb3rwarri0r8.commumod.world;


import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by noah on 5/14/14.
 */
public class modWorld {

    public static void mainRegistry()
    {
        initWorldGen();
    }
    public static void initWorldGen()
    {
        registerWorldGen(new WorldGenMod(), 1);

    }

    public static void registerWorldGen(IWorldGenerator worldGenClass, int weightedProbability)
    {
        GameRegistry.registerWorldGenerator(worldGenClass, weightedProbability);
    }
}
