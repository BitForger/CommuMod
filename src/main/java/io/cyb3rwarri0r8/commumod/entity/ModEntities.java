package io.cyb3rwarri0r8.commumod.entity;

/*
 * CommuMod - A Minecraft Modification
 * Copyright (c) 2016. noahk (Cyb3rWarri0r8/Endergriefer153/Starwarsman)
 */

import io.cyb3rwarri0r8.commumod.Commumod;
import io.cyb3rwarri0r8.commumod.lib.helpers.RegisterHelper;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ModEntities {

    public static Class[] entities = {
            EntityMiner.class,
            EntitySuperbiumGolem.class,
            EntityAradactiteGolem.class
    };

    public static String[] names = {
            "entityMiner",
            "entitySuperbiumGolem",
            "entityAradactiteGolem"
    };

    public static void init()
    {

        RegisterHelper.registerEntity(EntityMiner.class, "miner", 0);
        RegisterHelper.registerEntity(EntitySuperbiumGolem.class, "superbiumGolem", 1);
        RegisterHelper.registerEntity(EntityAradactiteGolem.class, "aradactiteGolem", 2);
        EntityRegistry.registerModEntity(EntityCobaltBoat.class, "cobaltBoat", 3, Commumod.instance, 80, 3, false);
    }
}
