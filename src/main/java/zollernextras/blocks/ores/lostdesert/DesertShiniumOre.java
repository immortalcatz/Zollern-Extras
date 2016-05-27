package zollernextras.blocks.ores.lostdesert;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import zollernextras.blocks.ores.IOre;
import zollernextras.lib.MainHelper;

public class DesertShiniumOre extends Block implements IOre {
	public DesertShiniumOre() {
		super(Material.rock);
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, "desertshiniumore");
		this.setHardness(4.0F);
		this.setResistance(2.0F);
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 3);
	}
	
	private Random rand = new Random();
	
	@Override
	public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_,
			int p_149690_7_) {
		if (this.getItemDropped(p_149690_5_, rand, p_149690_7_) != Item
				.getItemFromBlock(this)) {
			int j1 = 0;
			j1 = MathHelper.getRandomIntegerInRange(rand, 8, 14);
			
			return j1;
		}
		return 0;
	}
	
	@Override
	public double getFortune() {
		return 0.2D;
	}
	
	@Override
	public int getMaxDropIncrease() {
		return 4;
	}
	
	@Override
	public ItemStack getDroppedItemStack() {
		return new ItemStack(this);
	}
}