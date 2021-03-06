package zollernextras.blocks;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PurpurPillar extends GenericBlock {
	
	@SideOnly(Side.CLIENT)
	private IIcon field_150035_a;
	@SideOnly(Side.CLIENT)
	private IIcon field_150034_b;
	
	public PurpurPillar() {
		super("purpurpillar", 1.2F);
		this.setHarvestLevel("pickaxe", 3);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		return p_149691_1_ == 1 ? this.field_150035_a
				: p_149691_1_ == 0 ? ZollernBlocks.purpurBlock
						.getBlockTextureFromSide(p_149691_1_)
						: p_149691_1_ != 2 && p_149691_1_ != 4 ? this.blockIcon
								: this.field_150034_b;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		this.blockIcon = p_149651_1_.registerIcon(this.getTextureName());
		this.field_150035_a = p_149651_1_.registerIcon(this.getTextureName()
				+ "_top");
		this.field_150034_b = p_149651_1_.registerIcon(this.getTextureName());
	}
	
}