package io.cyb3rwarri0r8.commumod.entity.render;

/*
 * CommuMod - A Minecraft Modification
 * Copyright (c) 2016. noahk (Cyb3rWarri0r8/Endergriefer153/Starwarsman)
 */

import io.cyb3rwarri0r8.commumod.entity.model.ModelAradactiteGolem;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

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
     * @param entity
     */
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
       return aradactiteGolemTextures;
    }


}
