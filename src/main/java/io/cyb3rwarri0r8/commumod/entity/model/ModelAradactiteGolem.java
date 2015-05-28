package io.cyb3rwarri0r8.commumod.entity.model;

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

import io.cyb3rwarri0r8.commumod.entity.EntityAradactiteGolem;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

/**
 * Created by noah on 10/1/14.
 */
public class ModelAradactiteGolem extends ModelBase {
    /** The head model for the aradactite golem. */
    public ModelRenderer aradactiteGolemHead;
    /** The body model for the aradactite golem. */
    public ModelRenderer aradactiteGolemBody;
    /** The right arm model for the aradactite golem. */
    public ModelRenderer aradactiteGolemRightArm;
    /** The left arm model for the aradactite golem. */
    public ModelRenderer aradactiteGolemLeftArm;
    /** The left leg model for the Superbium Golem. */
    public ModelRenderer aradactiteGolemLeftLeg;
    /** The right leg model for the Superbium Golem. */
    public ModelRenderer aradactiteGolemRightLeg;
    private static final String __OBFID = "CL_00000863";

    public ModelAradactiteGolem()
    {
        this(0.0F);
    }

    public ModelAradactiteGolem(float p_i1161_1_)
    {
        this(p_i1161_1_, -7.0F);
    }

    public ModelAradactiteGolem(float p_i1162_1_, float p_i1162_2_)
    {
        short short1 = 128;
        short short2 = 128;
        this.aradactiteGolemHead = (new ModelRenderer(this)).setTextureSize(short1, short2);
        this.aradactiteGolemHead.setRotationPoint(0.0F, 0.0F + p_i1162_2_, -2.0F);
        this.aradactiteGolemHead.setTextureOffset(0, 0).addBox(-4.0F, -12.0F, -5.5F, 8, 10, 8, p_i1162_1_);
        this.aradactiteGolemHead.setTextureOffset(24, 0).addBox(-1.0F, -5.0F, -7.5F, 2, 4, 2, p_i1162_1_);
        this.aradactiteGolemBody = (new ModelRenderer(this)).setTextureSize(short1, short2);
        this.aradactiteGolemBody.setRotationPoint(0.0F, 0.0F + p_i1162_2_, 0.0F);
        this.aradactiteGolemBody.setTextureOffset(0, 40).addBox(-9.0F, -2.0F, -6.0F, 18, 12, 11, p_i1162_1_);
        this.aradactiteGolemBody.setTextureOffset(0, 70).addBox(-4.5F, 10.0F, -3.0F, 9, 5, 6, p_i1162_1_ + 0.5F);
        this.aradactiteGolemRightArm = (new ModelRenderer(this)).setTextureSize(short1, short2);
        this.aradactiteGolemRightArm.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.aradactiteGolemRightArm.setTextureOffset(60, 21).addBox(-13.0F, -2.5F, -3.0F, 4, 30, 6, p_i1162_1_);
        this.aradactiteGolemLeftArm = (new ModelRenderer(this)).setTextureSize(short1, short2);
        this.aradactiteGolemLeftArm.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.aradactiteGolemLeftArm.setTextureOffset(60, 58).addBox(9.0F, -2.5F, -3.0F, 4, 30, 6, p_i1162_1_);
        this.aradactiteGolemLeftLeg = (new ModelRenderer(this, 0, 22)).setTextureSize(short1, short2);
        this.aradactiteGolemLeftLeg.setRotationPoint(-4.0F, 18.0F + p_i1162_2_, 0.0F);
        this.aradactiteGolemLeftLeg.setTextureOffset(37, 0).addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, p_i1162_1_);
        this.aradactiteGolemRightLeg = (new ModelRenderer(this, 0, 22)).setTextureSize(short1, short2);
        this.aradactiteGolemRightLeg.mirror = true;
        this.aradactiteGolemRightLeg.setTextureOffset(60, 0).setRotationPoint(5.0F, 18.0F + p_i1162_2_, 0.0F);
        this.aradactiteGolemRightLeg.addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, p_i1162_1_);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
        this.aradactiteGolemHead.render(p_78088_7_);
        this.aradactiteGolemBody.render(p_78088_7_);
        this.aradactiteGolemLeftLeg.render(p_78088_7_);
        this.aradactiteGolemRightLeg.render(p_78088_7_);
        this.aradactiteGolemRightArm.render(p_78088_7_);
        this.aradactiteGolemLeftArm.render(p_78088_7_);
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_)
    {
        this.aradactiteGolemHead.rotateAngleY = p_78087_4_ / (180F / (float)Math.PI);
        this.aradactiteGolemHead.rotateAngleX = p_78087_5_ / (180F / (float)Math.PI);
        this.aradactiteGolemLeftLeg.rotateAngleX = -1.5F * this.func_78172_a(p_78087_1_, 13.0F) * p_78087_2_;
        this.aradactiteGolemRightLeg.rotateAngleX = 1.5F * this.func_78172_a(p_78087_1_, 13.0F) * p_78087_2_;
        this.aradactiteGolemLeftLeg.rotateAngleY = 0.0F;
        this.aradactiteGolemRightLeg.rotateAngleY = 0.0F;
    }

    /**
     * Used for easily adding entity-dependent animations. The second and third float params here are the same second
     * and third as in the setRotationAngles method.
     */
    public void setLivingAnimations(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_)
    {
        EntityAradactiteGolem entityaradactitegolem = (EntityAradactiteGolem)p_78086_1_;
        int i = entityaradactitegolem.getAttackTimer();

        if (i > 0)
        {
            this.aradactiteGolemRightArm.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - p_78086_4_, 10.0F);
            this.aradactiteGolemLeftArm.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - p_78086_4_, 10.0F);
        }
        else
        {
            int j = entityaradactitegolem.getHoldRoseTick();

            if (j > 0)
            {
                this.aradactiteGolemRightArm.rotateAngleX = -0.8F + 0.025F * this.func_78172_a((float)j, 70.0F);
                this.aradactiteGolemLeftArm.rotateAngleX = 0.0F;
            }
            else
            {
                this.aradactiteGolemRightArm.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(p_78086_2_, 13.0F)) * p_78086_3_;
                this.aradactiteGolemLeftArm.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(p_78086_2_, 13.0F)) * p_78086_3_;
            }
        }
    }

    private float func_78172_a(float p_78172_1_, float p_78172_2_)
    {
        return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
    }
}
