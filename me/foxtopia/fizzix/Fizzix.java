package me.foxtopia.fizzix;

import java.util.Arrays;
import java.util.List;

import org.bouncycastle.asn1.cms.MetaData;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import forestry.api.core.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
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

	
	 public List<Integer> modFences;
	 
	 public Fizzix()
	 {
		
	 }
	 @PreInit
	 public void preInit(FMLPreInitializationEvent event) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException
	 {
		 /*
		 Block.blocksList[3] = null;
		 Block.blocksList[3] = (new fzDirt(3)).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("dirt");
   
		 Block.blocksList[4] = null;
		 Block.blocksList[4] = (new fzCobbleStone(4,Material.rock).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stonebrick"));
		 
		 Block.blocksList[82] = null;
		 Block.blocksList[82] = (new fzClay(82,Material.clay).setHardness(0.6F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("clay"));
		 
		 Block.blocksList[88] = null;
		 Block.blocksList[88] = (new fzSoulSand(88,Material.sand).setHardness(0.5F).setStepSound(Block.soundSandFootstep).setUnlocalizedName("hellsand"));
		 */
		 
		try {
			Class<?> modClass = Class.forName("net.minecraft.block.Block");
				//Dirt
				  Field fieldDirt = modClass.getDeclaredField("dirt");
			      fieldDirt.setAccessible(true);
				  Field modifiersField = Field.class.getDeclaredField("modifiers");
			      modifiersField.setAccessible(true);
			      modifiersField.setInt(fieldDirt, fieldDirt.getModifiers() & ~Modifier.FINAL);
			      Block.blocksList[3] = null;
			      fieldDirt.set(null,(new fzDirt(3)).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("dirt"));
				
				//Cobble
			      Field fieldCobble = modClass.getDeclaredField("cobblestone");
			      fieldCobble.setAccessible(true);
				  Field modifiersFieldCobble = Field.class.getDeclaredField("modifiers");
				  modifiersFieldCobble.setAccessible(true);
				  modifiersFieldCobble.setInt(fieldCobble, fieldCobble.getModifiers() & ~Modifier.FINAL);
				  Block.blocksList[4] = null;
				  fieldCobble.set(fieldCobble,(new fzCobbleStone(4,Material.rock).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stonebrick")));
					
				
				//Clay
			      Field fieldClay = modClass.getDeclaredField("blockClay");
			      fieldClay.setAccessible(true);
				  Field modifiersFieldClay = Field.class.getDeclaredField("modifiers");
				  modifiersFieldClay.setAccessible(true);
				  modifiersFieldClay.setInt(fieldClay, fieldClay.getModifiers() & ~Modifier.FINAL);
				  Block.blocksList[82] = null;
				  fieldClay.set(fieldClay,(new fzClay(82,Material.clay).setHardness(0.6F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("clay")));
	
				
				//SoulSand
			      Field fieldhSand = modClass.getDeclaredField("slowSand");
			      fieldhSand.setAccessible(true);
				  Field modifiersFieldhSand = Field.class.getDeclaredField("modifiers");
				  modifiersFieldhSand.setAccessible(true);
				  modifiersFieldhSand.setInt(fieldhSand, fieldhSand.getModifiers() & ~Modifier.FINAL);
				  Block.blocksList[88] = null;
				  fieldhSand.set(fieldhSand,(new fzSoulSand(88,Material.sand).setHardness(0.5F).setStepSound(Block.soundSandFootstep).setUnlocalizedName("hellsand")));
	
				  
				  
				}  catch (ClassNotFoundException e) {
					Class<?> modClass2 = Class.forName("apa.class");
					//Dirt
					  Field fieldDirt2 = modClass2.getDeclaredField("z");
				      fieldDirt2.setAccessible(true);
					  Field modifiersField = Field.class.getDeclaredField("modifiers");
				      modifiersField.setAccessible(true);
				      modifiersField.setInt(fieldDirt2, fieldDirt2.getModifiers() & ~Modifier.FINAL);
				      Block.blocksList[3] = null;
				      fieldDirt2.set(fieldDirt2,(new fzDirt(3)).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("dirt"));
					
					//Cobble
				      Field fieldCobble2 = modClass2.getDeclaredField("A");
				      fieldCobble2.setAccessible(true);
					  Field modifiersFieldCobble = Field.class.getDeclaredField("modifiers");
					  modifiersFieldCobble.setAccessible(true);
					  modifiersFieldCobble.setInt(fieldCobble2, fieldCobble2.getModifiers() & ~Modifier.FINAL);
					  Block.blocksList[4] = null;
					  fieldCobble2.set(fieldCobble2,(new fzCobbleStone(4,Material.rock).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stonebrick")));
						
					
					//Clay
				      Field fieldClay2 = modClass2.getDeclaredField("ba");
				      fieldClay2.setAccessible(true);
					  Field modifiersFieldClay2 = Field.class.getDeclaredField("modifiers");
					  modifiersFieldClay2.setAccessible(true);
					  modifiersFieldClay2.setInt(fieldClay2, fieldClay2.getModifiers() & ~Modifier.FINAL);
					  Block.blocksList[82] = null;
					  fieldClay2.set(fieldClay2,(new fzClay(82,Material.clay).setHardness(0.6F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("clay")));
		
					
					//SoulSand
				      Field fieldhSand2 = modClass2.getDeclaredField("bg");
				      fieldhSand2.setAccessible(true);
					  Field modifiersFieldhSand2 = Field.class.getDeclaredField("modifiers");
					  modifiersFieldhSand2.setAccessible(true);
					  modifiersFieldhSand2.setInt(fieldhSand2, fieldhSand2.getModifiers() & ~Modifier.FINAL);
					  Block.blocksList[88] = null;
					  fieldhSand2.set(fieldhSand2,(new fzSoulSand(88,Material.sand).setHardness(0.5F).setStepSound(Block.soundSandFootstep).setUnlocalizedName("hellsand")));
		
					  
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		 
		 
	 }
	
}
