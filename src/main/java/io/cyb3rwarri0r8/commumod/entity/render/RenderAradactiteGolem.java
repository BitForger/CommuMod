package io.cyb3rwarri0r8.commumod.entity.render;

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

import io.cyb3rwarri0r8.commumod.entity.model.ModelAradactiteGolem;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

/**
 * Created by noah on 10/1/14.
 */
public class RenderAradactiteGolem extends RenderLiving {
    private static final ResourceLocation aradactiteGolemTextures = new ResourceLocation(Reference.MODID + ":" + "textures/entity/aradactiteGolem.png");
    /** aradactite Golem's Model. */
    private final ModelAradactiteGolem aradactiteGolemModel;


    public RenderAradactiteGolem(RenderManager renderManager)
    {
        super(renderManager, new ModelAradactiteGolem(), 0.5F);
        this.aradactiteGolemModel = (ModelAradactiteGolem)this.mainModel;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     *
     * @param p_110775_1_
     */
    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return this.getEntityTexture(p_110775_1_);
    }


}
