package me.foxtopia.fizzix;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class fzDirt extends BlockSand {

    public static boolean fallInstantly = false;
   
    public fzDirt(int par1)
    {
        super(par1, Material.ground);
        this.setCreativeTab(CreativeTabs.tabBlock);
        
    }

    public fzDirt(int par1, Material par2Material)
    {
        super(par1, par2Material);
    }
  
@Override
@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister par1IconRegister) {
	// TODO Auto-generated method stub
  this.blockIcon =	par1IconRegister.registerIcon("dirt");
  

}
@SideOnly(Side.CLIENT)
public Icon getIcon(int i,int j)
{
	return this.blockIcon;
}
@Override
@SideOnly(Side.CLIENT)
public Icon getBlockTexture(IBlockAccess par1iBlockAccess, int par2,
		int par3, int par4, int par5) {
	// TODO Auto-generated method stub
	return this.blockIcon;
}



    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            this.tryToFall(par1World, par2, par3, par4);
        }
    }

    /**
     * If there is space to fall below will start this block falling
     */
    private void tryToFall(World par1World, int par2, int par3, int par4)
    {
    	
        if (canFallBelow(par1World, par2, par3 -1, par4) && par3 >= 0)
        {
            byte b0 = 32;
            par1World.playSoundEffect(par2, par3, par4, "rockslide", 1.0F, 1.0F);
            if (!fallInstantly && par1World.checkChunksExist(par2 - b0, par3 - b0, par4 - b0, par2 + b0, par3 + b0, par4 + b0))
            {
                if (!par1World.isRemote)
                {
                    EntityFallingSand entityfallingsand = new EntityFallingSand(par1World, (double)((float)par2 + 0.5F), (double)((float)par3 + 0.5F), (double)((float)par4 + 0.5F), this.blockID, par1World.getBlockMetadata(par2, par3, par4));
                    this.onStartFalling(entityfallingsand);
                    par1World.spawnEntityInWorld(entityfallingsand);
                    par1World.playSoundAtEntity(entityfallingsand, "rockslide", 1.0F, 1.0F);
                }
            }
            else
            {
                par1World.setBlockToAir(par2, par3, par4);
                par1World.playSoundEffect(par2,par3,par4,"rockslide", 1.0F, 1.0F);
                
                while (canFallBelow(par1World, par2, par3 - 1, par4) && par3 > 0)
                {
                    --par3;
                    
                }

                if (par3 > 0)
                {
                    par1World.setBlock(par2, par3, par4, this.blockID);
                }
            }
        }
    }


    /**
     * Called when the falling block entity for this block is created
     */
    protected void onStartFalling(EntityFallingSand par1EntityFallingSand) {}

    /**
     * How many world ticks before ticking
     */
    public int tickRate(World par1World)
    {
        return 10;
    }

    /**
     * Checks to see if the sand can fall into the block below it
     */
    public static boolean canFallBelow(World par0World, int par1, int par2, int par3)
    {
        int l = par0World.getBlockId(par1, par2, par3);
        int a = Block.netherFence.blockID;
        int b = Block.fence.blockID;
        int fence1 = Fizzix.ForestryBlockIdA;
        int fence2 = Fizzix.ForestryBlockIdB;
        int q = Fizzix.QuartzPillar;
        int w = Fizzix.cWall;
        if (l == 0)
        {
        	int f1 = par0World.getBlockId(par1 -1, par2, par3);
        	int f2 = par0World.getBlockId(par1 -1, par2, par3 -1);
        	int f3 = par0World.getBlockId(par1 -1, par2, par3 +1);
        	int f4 = par0World.getBlockId(par1, par2, par3 -1);
        	int f5 = par0World.getBlockId(par1, par2, par3 +1);
        	int f6 = par0World.getBlockId(par1 +1, par2, par3);
        	int f7 = par0World.getBlockId(par1 +1, par2, par3 -1);
        	int f8 = par0World.getBlockId(par1 +1, par2, par3 +1);
        	if ( (f1 == b) || (f2 == b) || (f3 == b) || (f4 == b) || (f5 == b) || (f6 == b) || (f7 == b) || (f8 == b)){
        		return false;
        	}
        	if ( (f1 == a) || (f2 == a) || (f3 == a) || (f4 == a) || (f5 == a) || (f6 == a) || (f7 == a) || (f8 == a)){
        		return false;
        	}
        	if ( (f1 == fence1) || (f2 == fence1) || (f3 == fence1) || (f4 == fence1) || (f5 == fence1) || (f6 == fence1) || (f7 == fence1) || (f8 == fence1)){
        		return false;
        	}
        	if ( (f1 == fence2) || (f2 == fence2) || (f3 == fence2) || (f4 == fence2) || (f5 == fence2) || (f6 == fence2) || (f7 == fence2) || (f8 == fence2)){
        		return false;
        	}
        	if ( (f1 == w) || (f2 == w) || (f3 == w) || (f4 == w) || (f5 == w) || (f6 == w) || (f7 == w) || (f8 == w)){
        		return false;
        	}
        	if ( (f1 == q) || (f2 == q) || (f3 == q) || (f4 == q) || (f5 == q) || (f6 == q) || (f7 == q) || (f8 == q)){
        		return false;
        	}
        	
            return true;
        }
        else if (l == Block.fire.blockID)
        {
            return true;
        }
        else
        {
            Material material = Block.blocksList[l].blockMaterial;
            return material == Material.water ? true : material == Material.lava;
        }
    }

    /**
     * Called when the falling block entity for this block hits the ground and turns back into a block
     */
public void onFinishFalling(World par1World, int par2, int par3, int par4, int par5) {
    	
    	par1World.playSoundEffect(par2,par3,par4,"rockslide", 1.0F, 1.0F);
        
    	
    }
}

