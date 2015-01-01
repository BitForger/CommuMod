package io.cyb3rwarri0r8.commumod.lib;

import gnu.trove.map.TMap;
import gnu.trove.map.hash.THashMap;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

/**
 * CommuMod - A Minecraft Modification
 * Copyright (C) 2014 Cyb3rWarri0r8
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
public class IconRegistry {
    private static TMap<String, IIcon> icons = new THashMap<String, IIcon>();

    private IconRegistry() {

    }

    public static void addIcon(String iconName, String iconLocation, IIconRegister ir) {

        icons.put(iconName, ir.registerIcon(iconLocation));
    }

    public static void addIcon(String iconName, IIcon icon) {

        icons.put(iconName, icon);
    }

    public static IIcon getIcon(String iconName) {

        return icons.get(iconName);
    }

    public static IIcon getIcon(String iconName, int iconOffset) {

        return icons.get(iconName + iconOffset);
    }
}
