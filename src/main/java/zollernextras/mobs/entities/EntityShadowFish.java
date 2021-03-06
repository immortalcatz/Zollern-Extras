package zollernextras.mobs.entities;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSilverfish;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.Facing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import org.apache.commons.lang3.tuple.ImmutablePair;
import zaneextras.interfaces.ILightEntity;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.lib.modhelper.ModHelperBase;

public class EntityShadowFish extends EntityMob implements IShadeEntity {
	
	/**
	 * A cooldown before this entity will search for another Silverfish to join
	 * them in battle.
	 */
	private int allySummonCooldown;
	
	public EntityShadowFish(World p_i1740_1_) {
		super(p_i1740_1_);
		this.setSize(this.width, this.height);
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this,
				EntityPlayer.class, 2.4D, false));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				EntityPlayer.class, 0, true));
		if (ModHelperBase.useZaneExtras && this.shouldAttackLightEntity()) {
			this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(
					this, ILightEntity.class, 10, false));
		}
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(28.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(0.6500000238418579D);
	}
	
	/**
	 * returns if this entity triggers Block.onEntityWalking on the blocks they
	 * walk on. used for spiders and wolves to prevent them from trampling crops
	 */
	@Override
	protected boolean canTriggerWalking() {
		return false;
	}
	
	/**
	 * Finds the closest player within 16 blocks to attack, or null if this
	 * Entity isn't interested in attacking (Animals, Spiders at day, peaceful
	 * PigZombies).
	 */
	@Override
	protected Entity findPlayerToAttack() {
		double d0 = 10.0D;
		return this.worldObj.getClosestVulnerablePlayerToEntity(this, d0);
	}
	
	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	@Override
	protected String getLivingSound() {
		return "mob.silverfish.say";
	}
	
	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound() {
		return "mob.silverfish.hit";
	}
	
	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound() {
		return "mob.silverfish.kill";
	}
	
	/**
	 * Called when the entity is attacked.
	 */
	@Override
	public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
		if (this.isEntityInvulnerable()) {
			return false;
		} else {
			if (this.allySummonCooldown <= 0
					&& (p_70097_1_ instanceof EntityDamageSource || p_70097_1_ == DamageSource.magic)) {
				this.allySummonCooldown = 20;
			}
			
			return super.attackEntityFrom(p_70097_1_, p_70097_2_);
		}
	}
	
	/**
	 * Basic mob attack. Default to touch of death in EntityCreature. Overridden
	 * by each mob to define their attack.
	 */
	@Override
	protected void attackEntity(Entity p_70785_1_, float p_70785_2_) {
		if (this.attackTime <= 0 && p_70785_2_ < 1.2F
				&& p_70785_1_.boundingBox.maxY > this.boundingBox.minY
				&& p_70785_1_.boundingBox.minY < this.boundingBox.maxY) {
			this.attackTime = 20;
			this.attackEntityAsMob(p_70785_1_);
		}
	}
	
	@Override
	protected void func_145780_a(int p_145780_1_, int p_145780_2_,
			int p_145780_3_, Block p_145780_4_) {
		this.playSound("mob.silverfish.step", 0.15F, 1.0F);
	}
	
	@Override
	protected Item getDropItem() {
		return Item.getItemById(0);
	}
	
	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void onUpdate() {
		this.renderYawOffset = this.rotationYaw;
		super.onUpdate();
	}
	
	@Override
	protected void updateEntityActionState() {
		super.updateEntityActionState();
		
		if (!this.worldObj.isRemote) {
			int i;
			int j;
			int k;
			int i1;
			
			if (this.allySummonCooldown > 0) {
				--this.allySummonCooldown;
				
				if (this.allySummonCooldown == 0) {
					i = MathHelper.floor_double(this.posX);
					j = MathHelper.floor_double(this.posY);
					k = MathHelper.floor_double(this.posZ);
					boolean flag = false;
					
					for (int l = 0; !flag && l <= 5 && l >= -5; l = l <= 0 ? 1 - l
							: 0 - l) {
						for (i1 = 0; !flag && i1 <= 10 && i1 >= -10; i1 = i1 <= 0 ? 1 - i1
								: 0 - i1) {
							for (int j1 = 0; !flag && j1 <= 10 && j1 >= -10; j1 = j1 <= 0 ? 1 - j1
									: 0 - j1) {
								if (this.worldObj.getBlock(i + i1, j + l, k
										+ j1) == ZollernBlocks.bloodStone) {
									if (!this.worldObj.getGameRules()
											.getGameRuleBooleanValue(
													"mobGriefing")) {
										int k1 = this.worldObj
												.getBlockMetadata(i + i1,
														j + l, k + j1);
										ImmutablePair immutablepair = BlockSilverfish
												.func_150197_b(k1);
										this.worldObj
												.setBlock(
														i + i1,
														j + l,
														k + j1,
														(Block) immutablepair
																.getLeft(),
														((Integer) immutablepair
																.getRight())
																.intValue(), 3);
									} else {
										this.worldObj.func_147480_a(i + i1, j
												+ l, k + j1, false);
									}
									
									ZollernBlocks.bloodStone
											.onBlockDestroyedByPlayer(
													this.worldObj, i + i1, j
															+ l, k + j1, 0);
									
									if (this.rand.nextBoolean()) {
										flag = true;
										break;
									}
								}
							}
						}
					}
				}
			}
			
			if (this.entityToAttack == null && !this.hasPath()) {
				i = MathHelper.floor_double(this.posX);
				j = MathHelper.floor_double(this.posY + 0.5D);
				k = MathHelper.floor_double(this.posZ);
				int l1 = this.rand.nextInt(6);
				Block block = this.worldObj.getBlock(i
						+ Facing.offsetsXForSide[l1], j
						+ Facing.offsetsYForSide[l1], k
						+ Facing.offsetsZForSide[l1]);
				i1 = this.worldObj.getBlockMetadata(i
						+ Facing.offsetsXForSide[l1], j
						+ Facing.offsetsYForSide[l1], k
						+ Facing.offsetsZForSide[l1]);
				
				if (BlockSilverfish.func_150196_a(block)) {
					this.worldObj.setBlock(i + Facing.offsetsXForSide[l1], j
							+ Facing.offsetsYForSide[l1], k
							+ Facing.offsetsZForSide[l1],
							ZollernBlocks.bloodStone,
							BlockSilverfish.func_150195_a(block, i1), 3);
					this.spawnExplosionParticle();
					this.setDead();
				} else {
					this.updateWanderPath();
				}
			} else if (this.entityToAttack != null && !this.hasPath()) {
				this.entityToAttack = null;
			}
		}
	}
	
	/**
	 * Takes a coordinate in and returns a weight to determine how likely this
	 * creature will try to path to the block. Args: x, y, z
	 */
	@Override
	public float getBlockPathWeight(int p_70783_1_, int p_70783_2_,
			int p_70783_3_) {
		return this.worldObj.getBlock(p_70783_1_, p_70783_2_ - 1, p_70783_3_) == ZollernBlocks.bloodStone ? 10.0F
				: super.getBlockPathWeight(p_70783_1_, p_70783_2_, p_70783_3_);
	}
	
	/**
	 * Checks to make sure the light is not too bright where the mob is spawning
	 */
	@Override
	protected boolean isValidLightLevel() {
		return true;
	}
	
	/**
	 * Checks if the entity's current position is a valid location to spawn this
	 * entity.
	 */
	@Override
	public boolean getCanSpawnHere() {
		if (super.getCanSpawnHere()) {
			EntityPlayer entityplayer = this.worldObj.getClosestPlayerToEntity(
					this, 5.0D);
			return entityplayer == null;
		} else {
			return false;
		}
	}
	
	/**
	 * Get this Entity's EnumCreatureAttribute
	 */
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.ARTHROPOD;
	}
	
	@Override
	public boolean shouldAttackLightEntity() {
		return true;
	}
}