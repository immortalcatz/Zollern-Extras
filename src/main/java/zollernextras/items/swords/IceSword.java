package zollernextras.items.swords;

import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import zollernextras.lib.KeyHelper;
import zollernextras.lib.ZollernHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class IceSword extends ItemSword {
	
	public IceSword(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, "icesword");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world,
			EntityPlayer entityplayer) {
		float f = 2.0F;
		float f1 = entityplayer.prevRotationPitch
				+ (entityplayer.rotationPitch - entityplayer.prevRotationPitch)
				* f;
		float f2 = entityplayer.prevRotationYaw
				+ (entityplayer.rotationYaw - entityplayer.prevRotationYaw) * f;
		double d = entityplayer.prevPosX
				+ (entityplayer.posX - entityplayer.prevPosX) * f;
		double d1 = entityplayer.prevPosY
				+ (entityplayer.posY - entityplayer.prevPosY) * f
				+ 1.6200000000000001D - entityplayer.yOffset;
		double d2 = entityplayer.prevPosZ
				+ (entityplayer.posZ - entityplayer.prevPosZ) * f;
		Vec3 vec3d = null;
		vec3d = vec3d.createVectorHelper(d, d1, d2);
		float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
		float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
		float f5 = -MathHelper.cos(-f1 * 0.01745329F);
		float f6 = MathHelper.sin(-f1 * 0.01745329F);
		float f7 = f4 * f5;
		float f8 = f6;
		float f9 = f3 * f5;
		double d3 = 5000D;
		Vec3 vec3d1 = vec3d.addVector(f7 * d3, f8 * d3, f9 * d3);
		MovingObjectPosition movingobjectposition = world.rayTraceBlocks(vec3d,
				vec3d1, false);
		if (movingobjectposition == null) {
			return itemstack;
		}
		int i = movingobjectposition.blockX;
		int j = movingobjectposition.blockY;
		int k = movingobjectposition.blockZ;
		for (int u = 0; u < 8; u++) {
			int newJ = j + u;
			world.setBlock(i, j + u, k, Blocks.packed_ice);
			if (newJ <= 256) {
				world.setBlock(i, newJ, k, Blocks.packed_ice);
			}
		}
		if (!entityplayer.capabilities.isCreativeMode) {
			itemstack.damageItem(5, entityplayer);
		}
		return itemstack;
	}
	
	@Override
	public EnumRarity getRarity(ItemStack p_77613_1_) {
		return EnumRarity.epic;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_) {
		return EnumAction.block;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_,
			List list, boolean p_77624_4_) {
		if (KeyHelper.isCtrlKeyDown() || KeyHelper.isShiftKeyDown()) {
			list.add(EnumChatFormatting.ITALIC + "A sword born from");
			list.add(EnumChatFormatting.ITALIC + " the land of ice.");
		} else {
			list.add("Hold SHIFT for");
			list.add("more information.");
		}
	}
}