package io.cyb3rwarri0r8.commumod.entity;

/*
 * CommuMod - A Minecraft Modification
 * Copyright (c) 2016. noahk (Cyb3rWarri0r8/Endergriefer153/Starwarsman)
 */

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;


public class EntityAxe extends EntityThrowable {
    public EntityAxe(World world, double par2, double par4, double par6)
    {
        super(world, par2, par4, par6);
    }
    public EntityAxe(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }
    public EntityAxe(World par1World)
    {
        super(par1World);
    }

    @Override
    protected void onImpact(MovingObjectPosition mop)
    {
        //If this hit's a block, continue
        if(mop.typeOfHit == MovingObjectType.BLOCK)
        {
/*
* You might be wondering what
* all these case and break are
* These are use to switch the number
* mop.sideHit
*
* Example:
* If mop.sideHit == 3 whatever is in
* case 3 Happens!
*/
            switch(mop.sideHit)
            {
                case DOWN: //BOTTOM
                    mop.getBlockPos().add(0,-1,0);
                    break;
                case UP: //TOP
                    mop.getBlockPos().add(0,1,0);
                    break;
                case EAST: //EAST
                    mop.getBlockPos().add(0,0,-1);
                    break;
                case WEST: //WEST
                    mop.getBlockPos().add(0,0,1);
                    break;
                case NORTH: //NORTH
                    mop.getBlockPos().add(-1,0,0);
                    break;
                case SOUTH: //SOUTH
                    mop.getBlockPos().add(1,0,0);
                    break;
            }
/* This method creates the explosion!
* It uses the entity (Can be null)
* the three coordinates, the strength
* and if it should set neighboring blocks on fire
* around after exploding, the last parameter
* is if it  should spawn smoke particles
*/
            this.worldObj.newExplosion(this, mop.getBlockPos().getX(), mop.getBlockPos().getY(), mop.getBlockPos().getZ(), 4.0F, true, true);
        }
//If the Server is online and works, kill this entity
        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }


    }
}
