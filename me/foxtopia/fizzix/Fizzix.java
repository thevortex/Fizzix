package me.foxtopia.fizzix;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.Icon;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = "Fizzix", name = "Fizzix", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class Fizzix {

   
	public static Block Dirt;
	public static Block Clay;
	public static Block SoulSand;
	public static Block CobbleStone;
	 public Fizzix()
	 {
		 
	 }
	   
	 @PreInit
	 public void preInit(FMLPreInitializationEvent event)
	 {
		 
		 Block.blocksList[3] = null;
		 Block.blocksList[4] = null;
		 Block.blocksList[82] = null;
		 Block.blocksList[88] = null;
		 
		 
		 Dirt = new fzDirt(3,Material.ground).setUnlocalizedName("dirt");
		 CobbleStone = new fzCobbleStone(4,Material.rock).setUnlocalizedName("stonebrick");
		 Clay = new fzClay(82,Material.clay).setUnlocalizedName("clay");
		 SoulSand = new fzSoulSand(88,Material.sand).setUnlocalizedName("hellsand");
		 
		 
		 
		 GameRegistry.registerBlock(Dirt,"dirt");
		 GameRegistry.registerBlock(CobbleStone,"stonebrick");
		 GameRegistry.registerBlock(Clay,"clay");
		 GameRegistry.registerBlock(SoulSand,"hellsand");
		 
		 
	 }
	 
}
