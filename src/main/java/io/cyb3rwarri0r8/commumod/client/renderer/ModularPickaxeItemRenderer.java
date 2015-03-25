package io.cyb3rwarri0r8.commumod.client.renderer;

import io.cyb3rwarri0r8.commumod.items.ItemModularPickaxe;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * CommuMod - A Minecraft Modification
 * Copyright (C) 2015 Cyb3rWarri0r8
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
public class ModularPickaxeItemRenderer implements IItemRenderer {

    /**
     * Checks if this renderer should handle a specific item's render type
     *
     * @param item The item we are trying to render
     * @param type A render type to check if this renderer handles
     * @return true if this renderer should handle the given render type,
     * otherwise false
     */
    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON || type == IItemRenderer.ItemRenderType.EQUIPPED;
    }

    /**
     * Checks if certain helper functionality should be executed for this renderer.
     * See ItemRendererHelper for more info
     *
     * @param type   The render type
     * @param item   The ItemStack being rendered
     * @param helper The type of helper functionality to be ran
     * @return True to run the helper functionality, false to not.
     */
    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    /**
     * Called to do the actual rendering, see ItemRenderType for details on when specific
     * types are run, and what extra data is passed into the data parameter.
     *
     * @param type The render type
     * @param item The ItemStack being rendered
     * @param data Extra Type specific data
     */
    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        if(type == ItemRenderType.EQUIPPED || type == ItemRenderType.EQUIPPED_FIRST_PERSON)
        {
            if(!(item.getItem() instanceof ItemModularPickaxe))
            {
                return;
            }

            ItemModularPickaxe modularPickaxe = (ItemModularPickaxe)item.getItem();

            EntityPlayer entityPlayer = (EntityPlayer)data[1];

            float i2 = 0.0F;
            float translation = -1.5F;

            if((entityPlayer.inventory.getCurrentItem()==null)||(!(entityPlayer.inventory.getCurrentItem().getItem() instanceof ItemModularPickaxe)))
            {
                return;
            }

            GL11.glPushMatrix();
            if(i2 < 0.0F)
            {
                i2 = 0.0F;
            }

            if(type == ItemRenderType.EQUIPPED_FIRST_PERSON)
            {
                GL11.glTranslatef(0.0F, -(Math.abs(i2) / 2.0F), 0.0F);
                if (entityPlayer.getItemInUseCount() > 0)
                {
                    GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glRotatef(-77.0F, 0.0F, 0.0F, 1.0F);
                    GL11.glRotatef(-44.0F, 0.0F, 1.0F, 0.0F);
                    GL11.glTranslatef(-0.9F, -1.2F, -0.85F);
                    GL11.glRotatef(15.0F, 0.0F, 0.0F, 1.0F);
                    GL11.glTranslatef(0.1F, -0.25F, 0.08F);
                }

                if (entityPlayer.inventory.getCurrentItem().getItem() instanceof ItemModularPickaxe)
                {
                    GL11.glRotatef(10.0F, 0.0F, 0.0F, 0.0F);
                    GL11.glTranslatef(0.3F, 0.515F, 0.5F);
                }
            }
            else
            {
                GL11.glTranslatef(0.7F, 0.225F, 0.6125F);
                GL11.glRotatef(-40.0F, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(-110.0F, 1.0F, 0.0F, 0.0F);
                GL11.glTranslatef(0.1F, -0.9F, 0.15F);
                GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(1.3F, 1.3F, 1.3F);
            }

            renderItemCustom(type, item, data);
            GL11.glPopMatrix();
            GL11.glPushMatrix();

            float f28 = item.getMaxItemUseDuration() - (entityPlayer.getItemInUseCount() - 1.0F + 1.0F);
            float f32 = f28 / 50.0F;
            f32 = (f32 * f32 + f32 * 2.0F) / 3.0F;

            if (f32 > 1.0F)
            {
                f32 = 1.0F;
            }

            if (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON)
            {
                GL11.glRotatef(-330.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(1.0F, 1.0F, 0.0F, 0.0F);
                GL11.glTranslatef(0.0F, 0.5F, 0.15F);
                GL11.glTranslatef(0.0F, 0.05F, -0.25F);
                GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(331.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(2.0F, 1.0F, 0.0F, 1.0F);
                GL11.glScalef(0.7F, 0.7F, 0.7F);

                if (entityPlayer.inventory.getCurrentItem().getItem() instanceof ItemModularPickaxe)
                {
                    GL11.glRotatef(83.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glRotatef(-62.0F, 0.0F, 0.0F, 1.0F);
                    GL11.glRotatef(-45.0F, 0.0F, 1.0F, 0.0F);
                    GL11.glTranslatef(-1.5F, -1.22F, -0.7F);
                }
            }
            else
            {
                GL11.glTranslatef(0.7F, 0.225F, 0.6125F);
                GL11.glRotatef(-40.0F, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(-110.0F, 1.0F, 0.0F, 0.0F);
                GL11.glTranslatef(0.05F, -0.7F, 0.15F);
                GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(1.3F, 1.3F, 1.3F);
            }
            GL11.glPopMatrix();
            }

        }

    private void renderItemCustom(ItemRenderType type, ItemStack item, Object[] data) {
        int i = 0;
        EntityLivingBase entity = (EntityLivingBase)data[1];
        GL11.glPushMatrix();

        Tessellator tes = Tessellator.getInstance();
        IIcon icon = entity.getItemIcon(item, i);

        float f = ((IIcon)icon).getMinU();
        float f1 = ((IIcon)icon).getMaxU();
        float f2 = ((IIcon)icon).getMinV();
        float f3 = ((IIcon)icon).getMaxV();

        float j = 0.1F;
        float l = 0.3F;
        GL11.glEnable(32826);
        GL11.glTranslatef(-j, -l, 0.0F);
        float m = 1.5F;
        GL11.glScalef(m, m, m);
        GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(330.0F, 0.0F, 0.0F, 1.0F);
        GL11.glTranslatef(-0.9375F, -0.0625F, 0.0F);
        ItemRenderer.renderItemIn2D(tes, f1, f2, f, f3, icon.getIconWidth(), icon.getIconHeight(), 0.0625F);

        GL11.glDisable(32826);

        GL11.glPopMatrix();
    }
}

