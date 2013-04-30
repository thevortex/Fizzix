package me.foxtopia.fizzix;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = "Fizzix", name = "Fizzix", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class Fizzix {

   
	public static Block Dirt;
	public static Block Clay;
	public static Block SoulSand;
	
	 
	 public Fizzix()
	 {
		 
	 }
	   
	 @PreInit
	 public void preInit(FMLPreInitializationEvent event)
	 {
		 
		 Block.blocksList[3] = null;
		 Block.blocksList[82] = null;
		 Block.blocksList[88] = null;
		 
		 Dirt = new fzDirt(3,Material.ground);
		 Clay = new fzClay(82,Material.clay);
		 SoulSand = new fzSoulSand(88,Material.sand);
		 
		 GameRegistry.registerBlock(Dirt,"Dirt");
		 GameRegistry.registerBlock(Clay,"Clay");
		 GameRegistry.registerBlock(SoulSand,"SoulSand");
		 
	 }
	 
}
