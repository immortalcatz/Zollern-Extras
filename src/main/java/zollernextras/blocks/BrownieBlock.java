package zollernextras.blocks;

import net.minecraft.block.material.Material;

public class BrownieBlock extends GenericBlock {
	public BrownieBlock() {
		super("brownieblock", 0.4F);
		this.setMaterial(Material.cloth);
		this.setStepSound(soundTypeCloth);
	}
}