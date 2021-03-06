package zollernextras.worldgen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSwampClay extends WorldGenerator {
	/** The block ID of the ore to be placed using this generator. */
	private final Block minableBlockId;
	private int minableBlockMeta = 0;
	
	/** The number of blocks to generate. */
	private final int numberOfBlocks;
	
	/** The block ID of the block to be replaced with the ore (usually stone) */
	private final Block blockToReplace;
	
	public WorldGenSwampClay(Block par1, int par2) {
		this(par1, par2, Blocks.grass);
	}
	
	public WorldGenSwampClay(Block par1, int par2, Block par3) {
		this.minableBlockId = par1;
		this.numberOfBlocks = par2;
		this.blockToReplace = par3;
	}
	
	public WorldGenSwampClay(Block id, int meta, int number, Block target) {
		this(id, number, target);
		this.minableBlockMeta = meta;
	}
	
	@Override
	public boolean generate(World par1World, Random par2Random, int par3,
			int par4, int par5) {
		float f = par2Random.nextFloat() * (float) Math.PI;
		double d0 = par3 + 8 + MathHelper.sin(f) * this.numberOfBlocks / 8.0F;
		double d1 = par3 + 8 - MathHelper.sin(f) * this.numberOfBlocks / 8.0F;
		double d2 = par5 + 8 + MathHelper.cos(f) * this.numberOfBlocks / 8.0F;
		double d3 = par5 + 8 - MathHelper.cos(f) * this.numberOfBlocks / 8.0F;
		double d4 = par4 + par2Random.nextInt(3) - 2;
		double d5 = par4 + par2Random.nextInt(3) - 2;
		
		for (int l = 0; l <= this.numberOfBlocks; ++l) {
			double d6 = d0 + (d1 - d0) * l / this.numberOfBlocks;
			double d7 = d4 + (d5 - d4) * l / this.numberOfBlocks;
			double d8 = d2 + (d3 - d2) * l / this.numberOfBlocks;
			double d9 = par2Random.nextDouble() * this.numberOfBlocks / 16.0D;
			double d10 = (MathHelper.sin(l * (float) Math.PI
					/ this.numberOfBlocks) + 1.0F)
					* d9 + 1.0D;
			double d11 = (MathHelper.sin(l * (float) Math.PI
					/ this.numberOfBlocks) + 1.0F)
					* d9 + 1.0D;
			int i1 = MathHelper.floor_double(d6 - d10 / 2.0D);
			int j1 = MathHelper.floor_double(d7 - d11 / 2.0D);
			int k1 = MathHelper.floor_double(d8 - d10 / 2.0D);
			int l1 = MathHelper.floor_double(d6 + d10 / 2.0D);
			int i2 = MathHelper.floor_double(d7 + d11 / 2.0D);
			int j2 = MathHelper.floor_double(d8 + d10 / 2.0D);
			
			for (int k2 = i1; k2 <= l1; ++k2) {
				double d12 = (k2 + 0.5D - d6) / (d10 / 2.0D);
				
				if (d12 * d12 < 1.0D) {
					for (int l2 = j1; l2 <= i2; ++l2) {
						double d13 = (l2 + 0.5D - d7) / (d11 / 2.0D);
						
						if (d12 * d12 + d13 * d13 < 1.0D) {
							for (int i3 = k1; i3 <= j2; ++i3) {
								double d14 = (i3 + 0.5D - d8) / (d10 / 2.0D);
								
								Block block = par1World.getBlock(k2, l2, i3);
								if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0D
										&& block != null
										&& block.isReplaceableOreGen(par1World,
												k2, l2, i3, this.blockToReplace)) {
									par1World.setBlock(k2, l2, i3,
											this.minableBlockId,
											minableBlockMeta, 2);
								}
							}
						}
					}
				}
			}
		}
		return true;
	}
}
