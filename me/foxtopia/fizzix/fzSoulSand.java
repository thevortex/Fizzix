package me.foxtopia.fizzix;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class fzSoulSand extends BlockSand
{

    public static boolean fallInstantly = false;
    public fzSoulSand(int par1)
    {
        super(par1, Material.sand);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    public fzSoulSand(int par1, Material par2Material)
    {
        super(par1, par2Material);
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
    	// TODO Auto-generated method stub
      this.blockIcon =	par1IconRegister.registerIcon("hellsand");
     
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getBlockTexture(IBlockAccess par1iBlockAccess, int par2,
    		int par3, int par4, int par5) {
    	// TODO Auto-generated method stub
    	return this.blockIcon;
    }
   
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        float f = 0.125F;
        return AxisAlignedBB.getAABBPool().getAABB((double)par2, (double)par3, (double)par4, (double)(par2 + 1), (double)((float)(par3 + 1) - f), (double)(par4 + 1));
    }
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        par5Entity.motionX *= 0.4D;
        par5Entity.motionZ *= 0.4D;
    }

    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
    }

    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            this.tryToFall(par1World, par2, par3, par4);
        }
    }

    private void tryToFall(World par1World, int par2, int par3, int par4)
    {
        if (canFallBelow(par1World, par2, par3 - 1, par4) && par3 >= 0)
        {
            byte b0 = 32;

            if (!fallInstantly && par1World.checkChunksExist(par2 - b0, par3 - b0, par4 - b0, par2 + b0, par3 + b0, par4 + b0))
            {
                if (!par1World.isRemote)
                {
                    EntityFallingSand entityfallingsand = new EntityFallingSand(par1World, (double)((float)par2 + 0.5F), (double)((float)par3 + 0.5F), (double)((float)par4 + 0.5F), this.blockID, par1World.getBlockMetadata(par2, par3, par4));
                    this.onStartFalling(entityfallingsand);
                    par1World.spawnEntityInWorld(entityfallingsand);
                }
            }
            else
            {
                par1World.setBlockToAir(par2, par3, par4);

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

  
    protected void onStartFalling(EntityFallingSand par1EntityFallingSand) {}

  
    public int tickRate(World par1World)
    {
        return 2;
    }

  
    public static boolean canFallBelow(World par0World, int par1, int par2, int par3)
    {
        int l = par0World.getBlockId(par1, par2, par3);
        int a = Block.netherFence.blockID;
        int b = Block.fence.blockID;
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

  
    public void onFinishFalling(World par1World, int par2, int par3, int par4, int par5) {}
}

