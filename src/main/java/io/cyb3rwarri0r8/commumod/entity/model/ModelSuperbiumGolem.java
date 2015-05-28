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

import io.cyb3rwarri0r8.commumod.entity.EntitySuperbiumGolem;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

/**
 * Created by noah on 8/29/14.
 */
public class ModelSuperbiumGolem extends ModelBase  {
    /** The head model for the superbium golem. */
    public ModelRenderer superbiumGolemHead;
    /** The body model for the superbium golem. */
    public ModelRenderer superbiumGolemBody;
    /** The right arm model for the superbium golem. */
    public ModelRenderer superbiumGolemRightArm;
    /** The left arm model for the superbium golem. */
    public ModelRenderer superbiumGolemLeftArm;
    /** The left leg model for the Superbium Golem. */
    public ModelRenderer superbiumGolemLeftLeg;
    /** The right leg model for the Superbium Golem. */
    public ModelRenderer superbiumGolemRightLeg;
    private static final String __OBFID = "CL_00000863";

    public ModelSuperbiumGolem()
    {
        this(0.0F);
    }

    public ModelSuperbiumGolem(float p_i1161_1_)
    {
        this(p_i1161_1_, -7.0F);
    }

    public ModelSuperbiumGolem(float p_i1162_1_, float p_i1162_2_)
    {
        short short1 = 128;
        short short2 = 128;
        this.superbiumGolemHead = (new ModelRenderer(this)).setTextureSize(short1, short2);
        this.superbiumGolemHead.setRotationPoint(0.0F, 0.0F + p_i1162_2_, -2.0F);
        this.superbiumGolemHead.setTextureOffset(0, 0).addBox(-4.0F, -12.0F, -5.5F, 8, 10, 8, p_i1162_1_);
        this.superbiumGolemHead.setTextureOffset(24, 0).addBox(-1.0F, -5.0F, -7.5F, 2, 4, 2, p_i1162_1_);
        this.superbiumGolemBody = (new ModelRenderer(this)).setTextureSize(short1, short2);
        this.superbiumGolemBody.setRotationPoint(0.0F, 0.0F + p_i1162_2_, 0.0F);
        this.superbiumGolemBody.setTextureOffset(0, 40).addBox(-9.0F, -2.0F, -6.0F, 18, 12, 11, p_i1162_1_);
        this.superbiumGolemBody.setTextureOffset(0, 70).addBox(-4.5F, 10.0F, -3.0F, 9, 5, 6, p_i1162_1_ + 0.5F);
        this.superbiumGolemRightArm = (new ModelRenderer(this)).setTextureSize(short1, short2);
        this.superbiumGolemRightArm.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.superbiumGolemRightArm.setTextureOffset(60, 21).addBox(-13.0F, -2.5F, -3.0F, 4, 30, 6, p_i1162_1_);
        this.superbiumGolemLeftArm = (new ModelRenderer(this)).setTextureSize(short1, short2);
        this.superbiumGolemLeftArm.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.superbiumGolemLeftArm.setTextureOffset(60, 58).addBox(9.0F, -2.5F, -3.0F, 4, 30, 6, p_i1162_1_);
        this.superbiumGolemLeftLeg = (new ModelRenderer(this, 0, 22)).setTextureSize(short1, short2);
        this.superbiumGolemLeftLeg.setRotationPoint(-4.0F, 18.0F + p_i1162_2_, 0.0F);
        this.superbiumGolemLeftLeg.setTextureOffset(37, 0).addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, p_i1162_1_);
        this.superbiumGolemRightLeg = (new ModelRenderer(this, 0, 22)).setTextureSize(short1, short2);
        this.superbiumGolemRightLeg.mirror = true;
        this.superbiumGolemRightLeg.setTextureOffset(60, 0).setRotationPoint(5.0F, 18.0F + p_i1162_2_, 0.0F);
        this.superbiumGolemRightLeg.addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, p_i1162_1_);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
        this.superbiumGolemHead.render(p_78088_7_);
        this.superbiumGolemBody.render(p_78088_7_);
        this.superbiumGolemLeftLeg.render(p_78088_7_);
        this.superbiumGolemRightLeg.render(p_78088_7_);
        this.superbiumGolemRightArm.render(p_78088_7_);
        this.superbiumGolemLeftArm.render(p_78088_7_);
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_)
    {
        this.superbiumGolemHead.rotateAngleY = p_78087_4_ / (180F / (float)Math.PI);
        this.superbiumGolemHead.rotateAngleX = p_78087_5_ / (180F / (float)Math.PI);
        this.superbiumGolemLeftLeg.rotateAngleX = -1.5F * this.func_78172_a(p_78087_1_, 13.0F) * p_78087_2_;
        this.superbiumGolemRightLeg.rotateAngleX = 1.5F * this.func_78172_a(p_78087_1_, 13.0F) * p_78087_2_;
        this.superbiumGolemLeftLeg.rotateAngleY = 0.0F;
        this.superbiumGolemRightLeg.rotateAngleY = 0.0F;
    }

    /**
     * Used for easily adding entity-dependent animations. The second and third float params here are the same second
     * and third as in the setRotationAngles method.
     */
    public void setLivingAnimations(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_)
    {
        EntitySuperbiumGolem entitysuperbiumgolem = (EntitySuperbiumGolem)p_78086_1_;
        int i = entitysuperbiumgolem.getAttackTimer();

        if (i > 0)
        {
            this.superbiumGolemRightArm.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - p_78086_4_, 10.0F);
            this.superbiumGolemLeftArm.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - p_78086_4_, 10.0F);
        }
        else
        {
            int j = entitysuperbiumgolem.getHoldRoseTick();

            if (j > 0)
            {
                this.superbiumGolemRightArm.rotateAngleX = -0.8F + 0.025F * this.func_78172_a((float)j, 70.0F);
                this.superbiumGolemLeftArm.rotateAngleX = 0.0F;
            }
            else
            {
                this.superbiumGolemRightArm.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(p_78086_2_, 13.0F)) * p_78086_3_;
                this.superbiumGolemLeftArm.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(p_78086_2_, 13.0F)) * p_78086_3_;
            }
        }
    }

    private float func_78172_a(float p_78172_1_, float p_78172_2_)
    {
        return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
    }
}
