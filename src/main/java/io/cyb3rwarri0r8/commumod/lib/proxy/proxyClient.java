package io.cyb3rwarri0r8.commumod.lib.proxy;



/*
 * CommuMod - A Minecraft Modification
 * Copyright (c) 2016. noahk (Cyb3rWarri0r8/Endergriefer153/Starwarsman)
 */

import io.cyb3rwarri0r8.commumod.entity.*;
import io.cyb3rwarri0r8.commumod.entity.model.ModelMiner;
import io.cyb3rwarri0r8.commumod.entity.render.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Items;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class proxyClient extends proxyCommon {

    @Override
    public void registerRenderers(){
        //TODO Change to rendering factory
        RenderingRegistry.registerEntityRenderingHandler(EntityMiner.class, new RenderMiner(Minecraft.getMinecraft().getRenderManager(), new ModelMiner(0.5F, true), 0.5F));
        //FIXME
        RenderingRegistry.registerEntityRenderingHandler(EntityAxe.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), Items.snowball, Minecraft.getMinecraft().getRenderItem()));
        RenderingRegistry.registerEntityRenderingHandler(EntitySuperbiumGolem.class, new RenderSuperbiumGolem(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityAradactiteGolem.class, new RenderAradactiteGolem(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityHydrogenTNTPrimed.class, new RenderHydrogenTNTPrimed(Minecraft.getMinecraft().getRenderManager()));

    }

    @Override
    public void preinit()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityCobaltBoat.class, new RenderCobaltBoat(Minecraft.getMinecraft().getRenderManager()));
    }

    @Override
    public void registerSounds()
    {

    }

}
