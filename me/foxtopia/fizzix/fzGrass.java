package me.foxtopia.fizzix;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class fzGrass extends BlockGrass {

	
	    @SideOnly(Side.CLIENT)
	    private Icon iconGrassTop;
	    @SideOnly(Side.CLIENT)
	    private Icon iconSnowSide;
	    @SideOnly(Side.CLIENT)
	    private static Icon iconGrassSideOverlay;
	    @SideOnly(Side.CLIENT)
	    private Icon iconGrassBottom;

	    protected fzGrass(int par1)
	    {
	        super(par1);
	        this.setTickRandomly(true);
	        this.setCreativeTab(CreativeTabs.tabBlock);
	    }
	    @Override
	    @SideOnly(Side.CLIENT)

	    public Icon getIcon(int par1, int par2)
	    {
	        return par1 == 1 ? this.iconGrassTop : (par1 == 0 ? this.iconGrassBottom : this.blockIcon);
	    }

	    public int idDropped(int par1, Random par2Random, int par3)
	    {
	        return Fizzix.Dirt.idDropped(0, par2Random, par3);
	    }
	    @Override
	    @SideOnly(Side.CLIENT)
	    public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	    {
	        if (par5 == 1)
	        {
	            return this.iconGrassTop;
	        }
	        else if (par5 == 0)
	        {
	            return this.iconGrassBottom;
	        }
	        else
	        {
	            Material material = par1IBlockAccess.getBlockMaterial(par2, par3 + 1, par4);
	            return material != Material.snow && material != Material.craftedSnow ? this.blockIcon : this.iconSnowSide;
	        }
	    }
	    @Override
	    @SideOnly(Side.CLIENT)

	    public void registerIcons(IconRegister par1IconRegister)
	    {
	        this.blockIcon = par1IconRegister.registerIcon("grass_side");
	        this.iconGrassTop = par1IconRegister.registerIcon("grass_top");
	        this.iconSnowSide = par1IconRegister.registerIcon("snow_side");
	        this.setIconGrassSideOverlay(par1IconRegister.registerIcon("grass_side_overlay"));
	        this.iconGrassBottom = par1IconRegister.registerIcon("dirt");
	    }
	@Override
	@SideOnly(Side.CLIENT)
	public void setIconGrassSideOverlay(Icon iconGrassSideOverlay) {
	// TODO Auto-generated method stub
	this.iconGrassSideOverlay = iconGrassSideOverlay;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconGrassSideOverlay() {
	// TODO Auto-generated method stub
	return this.iconGrassSideOverlay;
	}
	@SideOnly(Side.CLIENT)
	public static Icon getIconSideOverlay() {
	// TODO Auto-generated method stub
	return iconGrassSideOverlay;
	}
	}

