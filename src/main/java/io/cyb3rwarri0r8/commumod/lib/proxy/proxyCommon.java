package io.cyb3rwarri0r8.commumod.lib.proxy;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import io.cyb3rwarri0r8.commumod.lib.handler.ModGuiHandler;
import io.cyb3rwarri0r8.commumod.entity.EntityMiner;
import io.cyb3rwarri0r8.commumod.entity.TileEntityPurifier;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

/**
 * Created by noah on 5/27/14.
 */
public abstract class proxyCommon{



    public void registerRenderers()
    {

    }



    public void preinit(){

    }

    public void registerSounds()
    {

    }

    public void registerEntitySpawn(){
        BiomeGenBase[] allBiomes = Iterators.toArray(Iterators.filter(Iterators.forArray(BiomeGenBase.getBiomeGenArray()), Predicates.notNull()), BiomeGenBase.class);
        System.out.println("Registering natural spawns");
        EntityRegistry.addSpawn(EntityMiner.class, 10, 3, 10, EnumCreatureType.creature, BiomeGenBase.extremeHills);
        EntityRegistry.addSpawn(EntityMiner.class, 40, 3, 10, EnumCreatureType.creature, BiomeGenBase.extremeHillsEdge);
        EntityRegistry.addSpawn(EntityMiner.class, 40, 3, 10, EnumCreatureType.creature, BiomeGenBase.extremeHillsPlus);

    }

    public static void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntityPurifier.class, Reference.MODID + ":purifierTileEntity");
    }

    public void registerNetwork()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(main.instance, new ModGuiHandler());
    }

}
