package io.cyb3rwarri0r8.commumod.lib.helpers;/*
* CommuMod - A Minecraft Modification
* Copyright (C) 2016 noahk (Cyb3rWarri0r8)
* 
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* any later version.
* 
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
* 
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
/**
 * A hackish adapter that allows lambdas to be used as {@link ItemMeshDefinition} implementations without breaking ForgeGradle's
 * reobfuscation and causing {@link AbstractMethodError}s.
 * <p>
 * Written by diesieben07 in this thread:
 * http://www.minecraftforge.net/forum/index.php/topic,34034.0.html
 */
public interface MeshDefinitionFix extends ItemMeshDefinition {

	ModelResourceLocation getLocation( ItemStack stack );

	// Helper method to easily create lambda instances of this class
	static ItemMeshDefinition create( MeshDefinitionFix lambda ) {
		return lambda;
	}

	default ModelResourceLocation getModelLocation( ItemStack stack ) {
		return getLocation( stack );
	}
}
