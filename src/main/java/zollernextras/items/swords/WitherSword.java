package zollernextras.items.swords;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import zollernextras.lib.KeyHelper;
import zollernextras.lib.ZollernHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WitherSword extends ItemSword {
	
	public WitherSword(ToolMaterial toolMaterial) {
		super(toolMaterial);
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, "withersword");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3Player) {
		super.onItemRightClick(par1ItemStack, par2World, par3Player);
		if (!par2World.isRemote) {
			Vec3 look = par3Player.getLookVec();
			EntityWitherSkull witherSkull = new EntityWitherSkull(par2World);
			witherSkull.setPosition(par3Player.posX + look.xCoord * 5,
					par3Player.posY + 1 + look.yCoord * 5, par3Player.posZ
							+ look.zCoord * 5);
			witherSkull.accelerationX = look.xCoord * 0.1;
			witherSkull.accelerationY = look.yCoord * 0.1;
			witherSkull.accelerationZ = look.zCoord * 0.1;
			this.playWitherSound(par2World, par3Player.posX, par3Player.posY,
					par3Player.posZ);
			par2World.spawnEntityInWorld(witherSkull);
			if (!par3Player.capabilities.isCreativeMode) {
				par1ItemStack.damageItem(5, par3Player);
			}
		}
		return par1ItemStack;
	}
	
	private void playWitherSound(World world, double i, double j, double k) {
		world.playSoundEffect(i + 5.0D, j + 5.0D, k + 5.0D, "mob.wither.idle",
				1.0F, world.rand.nextFloat() * 0.1F + 0.9F);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, Entity entity) {
		super.onLeftClickEntity(par1ItemStack, par2EntityPlayer, entity);
		if (entity instanceof EntityLivingBase) {
			EntityLivingBase living = (EntityLivingBase) entity;
			living.addPotionEffect(new PotionEffect(Potion.wither.id, 50, 2));
			this.playWitherSound(living.worldObj, living.posX, living.posY,
					living.posZ);
		}
		return false;
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
			list.add(EnumChatFormatting.ITALIC + "A withering");
			list.add(EnumChatFormatting.ITALIC + "blade, touched with death.");
		} else {
			list.add("Hold SHIFT for");
			list.add("more information.");
		}
	}
}