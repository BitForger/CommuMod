package io.cyb3rwarri0r8.commumod.entity;

import io.cyb3rwarri0r8.commumod.lib.helpers.RegisterHelper;

/**
 * Created by noah on 10/12/14.
 */
public class ModEntities {
    public static void init()
    {
        RegisterHelper.registerEntity(EntityMiner.class, "miner");
        RegisterHelper.registerEntity(EntitySuperbiumGolem.class, "superbiumGolem");
        RegisterHelper.registerEntity(EntityAradactiteGolem.class, "aradactiteGolem");
    }
}
