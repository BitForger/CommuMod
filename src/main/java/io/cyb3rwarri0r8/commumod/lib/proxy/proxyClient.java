package io.cyb3rwarri0r8.commumod.lib.proxy;



/*
 *  CommuMod - A Minecraft Modification
 *  Copyright (C) ${YEAR} Cyb3rWarri0r8
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
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
