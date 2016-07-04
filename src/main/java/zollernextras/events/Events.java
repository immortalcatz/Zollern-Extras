package zollernextras.events;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.NameFormat;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import zollernextras.biomes.BiomeList;
import zollernextras.blocks.BabyDragonEgg;
import zollernextras.blocks.BlockList;
import zollernextras.blocks.ores.IOre;
import zollernextras.entity.ExtendedPlayer;
import zollernextras.items.ItemList;
import zollernextras.items.armor.amaranth.AmaranthArmor;
import zollernextras.items.armor.azurite.AzuriteArmor;
import zollernextras.items.armor.zollernium.ZollerniumArmor;
import zollernextras.lib.MainHelper;
import zollernextras.mobs.entities.EntityBabyDragon;
import zollernextras.mobs.entities.EntityShadowSkeleton;
import zollernextras.network.PacketDispatcher;
import zollernextras.network.client.SyncPlayerPropsMessage;
import zollernextras.proxies.CommonProxy;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

public class Events {
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onEntityConstructingEvent(EntityConstructing event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			if (ExtendedPlayer.get((EntityPlayer) event.entity) == null) {
				ExtendedPlayer.register((EntityPlayer) event.entity);
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onLivingUpdate(LivingUpdateEvent event) {
		EntityLivingBase entity = event.entityLiving;
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			ItemStack[] armor = player.inventory.armorInventory;
			int amArmorCount = 0;
			int zArmorCount = 0;
			int azArmorCount = 0;
			for (ItemStack armorStack : armor) {
				if (armorStack != null
						&& armorStack.getItem() instanceof AmaranthArmor) {
					AmaranthArmor amaranthArmor = (AmaranthArmor) armorStack
							.getItem();
					amArmorCount++;
				} else if (armorStack != null
						&& armorStack.getItem() instanceof ZollerniumArmor) {
					ZollerniumArmor zollernArmor = (ZollerniumArmor) armorStack
							.getItem();
					zArmorCount++;
				} else if (armorStack != null
						&& armorStack.getItem() instanceof AzuriteArmor) {
					AzuriteArmor azuriteArmor = (AzuriteArmor) armorStack
							.getItem();
					azArmorCount++;
				}
			}
			for (int i = 0; i < 4; ++i) {
				if (amArmorCount == 4) {
					player.addPotionEffect(new PotionEffect(
							Potion.resistance.id, 5, 4));
				} else if (azArmorCount == 4) {
					player.addPotionEffect(new PotionEffect(
							Potion.damageBoost.id, 5, 4));
				} else if (zArmorCount == 4) {
					player.addPotionEffect(new PotionEffect(
							Potion.fireResistance.id, 5, 4));
					player.stepHeight = 2F;
				}
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onPlayerLoginEvent(PlayerLoggedInEvent event) {
		if (!event.player.worldObj.isRemote) {
			
		}
	}
	
	@SubscribeEvent(priority = EventPriority.HIGH, receiveCanceled = true)
	public void onNameFormatEvent(NameFormat event) {
		String username = event.username;
		if (username.toLowerCase().equals("alphawolf918")) {
			event.displayname = EnumChatFormatting.GOLD + "Zollern Wolf"
					+ EnumChatFormatting.WHITE;
		} else if (username.toLowerCase().equals("applepiec00kie")) {
			event.displayname = EnumChatFormatting.LIGHT_PURPLE + "Queen Apple"
					+ EnumChatFormatting.WHITE;
		} else if (username.toLowerCase().equals("takumikomeiji")) {
			event.displayname = EnumChatFormatting.RED + "Red"
					+ EnumChatFormatting.WHITE;
		} else if (username.toLowerCase().equals("lazy_logic")) {
			event.displayname = EnumChatFormatting.AQUA + "Logic"
					+ EnumChatFormatting.WHITE;
		} else if (username.toLowerCase().equals("cryokor")) {
			event.displayname = EnumChatFormatting.DARK_AQUA + "Ice Lady"
					+ EnumChatFormatting.WHITE;
		} else if (username.toLowerCase().equals("master_zane")) {
			event.displayname = EnumChatFormatting.GOLD + "Master Zane";
		} else if (username.toLowerCase().equals("asylumneeds")) {
			event.displayname = EnumChatFormatting.BLACK + "ChronoxShift";
		}
	}
	
	// @SubscribeEvent(priority = EventPriority.HIGH, receiveCanceled = true)
	// public void onItemCraftedEvent(ItemCraftedEvent event) {
	//
	// }
	
	// @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	// public void onItemSmeltedEvent(ItemSmeltedEvent event) {
	// EntityPlayer player = event.player;
	// ItemStack smelting = event.smelting;
	// // TODO
	// }
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onLivingDeathEvent(LivingDeathEvent event) {
		if (!event.entity.worldObj.isRemote
				&& event.entity instanceof EntityPlayer) {
			NBTTagCompound playerData = CommonProxy
					.getEntityData(((EntityPlayer) event.entity)
							.getCommandSenderName()
							+ ExtendedPlayer.EXT_PROP_NAME);
			if (playerData != null) {
				((ExtendedPlayer) event.entity
						.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))
						.saveNBTData(playerData);
			}
			CommonProxy.storeEntityData(
					((EntityPlayer) event.entity).getCommandSenderName(),
					playerData);
			ExtendedPlayer.saveProxyData((EntityPlayer) event.entity);
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onBlockBrokenEvent(BreakEvent event) {
		World world = event.world;
		if (!world.isRemote) {
			Block block = event.block;
			if (block.getClass() == BlockTallGrass.class) {
				Random rand = new Random();
				int randInt = rand.nextInt(75);
				if (randInt <= 5) {
					Item seedToDrop;
					switch (randInt) {
					default:
						seedToDrop = ItemList.tomatoSeeds;
						break;
					case 1:
						seedToDrop = ItemList.cucumberSeeds;
						break;
					}
					EntityItem seedItem = new EntityItem(world, event.x,
							event.y, event.z, new ItemStack(seedToDrop, 1));
					world.spawnEntityInWorld(seedItem);
				}
			} else if (block.getClass() == BabyDragonEgg.class) {
				EntityBabyDragon dragon = new EntityBabyDragon(world);
				dragon.setLocationAndAngles(event.x + 0.5D, event.y + 0.5D,
						event.z + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(dragon);
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void FillBucket(FillBucketEvent event) {
		ItemStack result = attemptFill(event.world, event.target);
		if (result != null) {
			event.result = result;
			event.setResult(Result.ALLOW);
		}
	}
	
	private ItemStack attemptFill(World world, MovingObjectPosition p) {
		Block id = world.getBlock(p.blockX, p.blockY, p.blockZ);
		if (id == BlockList.blockChocolate) {
			if (world.getBlockMetadata(p.blockX, p.blockY, p.blockZ) == 0) {
				world.setBlock(p.blockX, p.blockY, p.blockZ, Blocks.air);
				return new ItemStack(ItemList.chocolateBucket);
			}
		}
		return null;
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onEntityJoinWorldEvent(EntityJoinWorldEvent event) {
		if (event.entity instanceof EntityPlayer
				&& !event.entity.worldObj.isRemote) {
			if (!event.entity.worldObj.isRemote
					&& event.entity instanceof EntityPlayer) {
				NBTTagCompound playerData = CommonProxy
						.getEntityData(((EntityPlayer) event.entity)
								.getCommandSenderName());
				if (playerData != null) {
					((ExtendedPlayer) event.entity
							.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))
							.loadNBTData(playerData);
				}
				
				if (event.entity instanceof EntityPlayer) {
					EntityPlayer player = (EntityPlayer) event.entity;
					ExtendedPlayer props = ExtendedPlayer.get(player);
					if (!player.capabilities.isCreativeMode) {
						
						// Max Health
						double maxHealth = props.getMaxHealth();
						player.getEntityAttribute(
								SharedMonsterAttributes.maxHealth)
								.setBaseValue(maxHealth);
						
						// Max Attack
						double maxAttack = props.getMaxDamage();
						double attrMaxDamage = player.getEntityAttribute(
								SharedMonsterAttributes.attackDamage)
								.getBaseValue();
						player.getEntityAttribute(
								SharedMonsterAttributes.attackDamage)
								.setBaseValue(attrMaxDamage + maxAttack);
					}
					PacketDispatcher.sendTo(new SyncPlayerPropsMessage(
							(EntityPlayer) event.entity),
							(EntityPlayerMP) event.entity);
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onPlayerRespawnEvent(PlayerRespawnEvent event) {
		EntityPlayer player = event.player;
		ExtendedPlayer props = ExtendedPlayer.get(player);
		if (!player.capabilities.isCreativeMode) {
			double maxHealth = props.getMaxHealth();
			player.getEntityAttribute(SharedMonsterAttributes.maxHealth)
					.setBaseValue(maxHealth);
		}
	}
	
	@SubscribeEvent
	public void onLivingJumpEvent(LivingJumpEvent event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			ExtendedPlayer props = ExtendedPlayer.get(player);
			if (!event.entity.worldObj.isRemote) {
				event.entity.motionY += props.getMaxJump();
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onLivingFallEvent(LivingFallEvent event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			if (!player.capabilities.isCreativeMode) {
				ExtendedPlayer props = ExtendedPlayer.get(player);
				float fallDistance = event.distance;
				if (fallDistance >= 2.5F) {
					double resist = props.getFallResistance();
					double totalResistance = fallDistance - resist;
					if (totalResistance > 0.0D) {
						event.distance -= (float) resist;
					}
					
					if (new Random().nextInt(15) == 1) {
						double incrAmnt = new Random().nextDouble();
						if (incrAmnt > 0.3D) {
							incrAmnt = 0.3D;
						}
						if (incrAmnt < 0.1D) {
							incrAmnt = 0.1D;
						}
						if (incrAmnt > 0.0D) {
							props.setMaxFallResistance(resist + incrAmnt);
							String fullResist = "" + resist + incrAmnt;
							String strIncrAmnt = "" + incrAmnt;
							MainHelper.addChatMessage(
									player,
									EnumChatFormatting.GOLD + "+"
											+ strIncrAmnt.substring(0, 3)
											+ " Fall Resistance! Total: "
											+ fullResist.substring(0, 3));
							if (new Random().nextInt(20) <= 2) {
								if (props.getMaxJump() < 8.0D) {
									props.setMaxJump(props.getMaxJump()
											+ incrAmnt);
									fullResist = props.getMaxJump() + incrAmnt
											+ "";
									MainHelper.addChatMessage(
											player,
											EnumChatFormatting.GOLD
													+ "+"
													+ strIncrAmnt.substring(0,
															3)
													+ " Jump Height! Total: "
													+ fullResist
															.substring(0, 3));
								}
							}
						}
					}
				}
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onLivingHurtEvent(LivingHurtEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			ExtendedPlayer props = ExtendedPlayer.get(player);
			double defense = props.getMaxDefense();
			event.ammount = (float) (event.ammount - defense > 0F ? event.ammount
					- defense
					: 0F);
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onHarvestDropsEvent(BlockEvent.HarvestDropsEvent event) {
		if (event.harvester instanceof EntityPlayer) {
			if (event.harvester.getClass() == EntityPlayer.class) {
				EntityPlayer player = event.harvester;
				if (!event.world.isRemote) {
					if (!player.capabilities.isCreativeMode) {
						if (event.block instanceof IOre) {
							Random rand = new Random();
							IOre oreBlock = (IOre) event.block;
							ExtendedPlayer props = ExtendedPlayer.get(player);
							double fortune = props.getMaxFortune();
							if (new Random().nextInt(10) == 1) {
								double blockFortune = oreBlock.getFortune();
								props.setMaxFortune(fortune + blockFortune);
								String strFortuneLevel = ""
										+ props.getMaxFortune();
								MainHelper.addChatMessage(
										player,
										EnumChatFormatting.GOLD
												+ "+"
												+ blockFortune
												+ " Fortune! Total: "
												+ strFortuneLevel.substring(0,
														3));
							}
							if (new Random().nextInt(5) == 1) {
								int numDropped = 0;
								if (fortune >= 1.0D) {
									int r = new Random().nextInt((int) fortune);
									numDropped = r == 0 ? 1 : r;
								}
								if (numDropped > oreBlock.getMaxDropIncrease()) {
									numDropped = oreBlock.getMaxDropIncrease();
								}
								Item droppedItem = oreBlock
										.getDroppedItemStack().getItem();
								event.drops.add(new ItemStack(droppedItem,
										numDropped));
							}
						} else if (event.block instanceof BlockCrops) {
							// TODO
						}
					}
				}
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onLivingDropsEvent(LivingDropsEvent event) {
		Entity theEntity = event.entityLiving;
		World worldObj = theEntity.worldObj;
		if (theEntity instanceof EntityZombie) {
			if (new Random().nextInt(100) <= 50) {
				EntityItem item = new EntityItem(worldObj, theEntity.posX,
						theEntity.posY, theEntity.posZ, new ItemStack(
								ItemList.flour, 1));
				worldObj.spawnEntityInWorld(item);
			}
		} else if (theEntity instanceof EntityBlaze) {
			EntityItem item = new EntityItem(worldObj, theEntity.posX,
					theEntity.posY, theEntity.posZ, new ItemStack(
							Items.blaze_rod, 1));
			worldObj.spawnEntityInWorld(item);
		} else if (theEntity instanceof EntityEnderman) {
			EntityItem item = new EntityItem(worldObj, theEntity.posX,
					theEntity.posY, theEntity.posZ, new ItemStack(
							Items.ender_pearl, 1));
			worldObj.spawnEntityInWorld(item);
		} else if (theEntity.getClass() == EntitySkeleton.class) {
			EntityItem item = new EntityItem(worldObj, theEntity.posX,
					theEntity.posY, theEntity.posZ,
					new ItemStack(Items.bone, 1));
			worldObj.spawnEntityInWorld(item);
		} else if (theEntity instanceof EntitySilverfish) {
			EntityItem item = new EntityItem(worldObj, theEntity.posX,
					theEntity.posY, theEntity.posZ, new ItemStack(
							ItemList.silverNugget, 1));
			worldObj.spawnEntityInWorld(item);
		} else if (theEntity instanceof EntityGhast) {
			EntityItem item = new EntityItem(worldObj, theEntity.posX,
					theEntity.posY, theEntity.posZ, new ItemStack(
							Items.ghast_tear, 1));
			worldObj.spawnEntityInWorld(item);
		} else if (theEntity instanceof EntitySheep) {
			Item theItem = theEntity.isBurning() ? ItemList.cookedLamb
					: ItemList.rawLamb;
			Random rand = new Random();
			int numDropped = rand.nextInt(2);
			numDropped = numDropped == 0 ? 1 : numDropped;
			EntityItem item = new EntityItem(worldObj, theEntity.posX,
					theEntity.posY, theEntity.posZ, new ItemStack(theItem,
							numDropped));
			worldObj.spawnEntityInWorld(item);
		} else if (theEntity instanceof EntityShadowSkeleton) {
			Random rand = new Random();
			int randInt = rand.nextInt(100);
			if (randInt <= 10) {
				ItemStack itemStack = new ItemStack(ItemList.shadowEssence, 1);
				EntityItem itemEntity = new EntityItem(worldObj,
						theEntity.posX, theEntity.posY, theEntity.posZ,
						itemStack);
				worldObj.spawnEntityInWorld(itemEntity);
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onClonePlayerEvent(PlayerEvent.Clone event) {
		ExtendedPlayer.get(event.entityPlayer).copy(
				ExtendedPlayer.get(event.original));
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void UseHoeEvent(UseHoeEvent event) {
		EntityPlayer par2EntityPlayer = event.entityPlayer;
		ItemStack par1ItemStack = par2EntityPlayer.getHeldItem();
		World par3World = event.world;
		int par4 = event.x;
		int par5 = event.y;
		int par6 = event.z;
		int par7 = 1;
		
		if (event.getResult() == Result.ALLOW) {
			par1ItemStack.damageItem(1, par2EntityPlayer);
		}
		
		Block i1 = par3World.getBlock(par4, par5, par6);
		boolean air = par3World.isAirBlock(par4, par5 + 1, par6);
		
		if (par7 != 0 && air && i1 == BlockList.betterGrass) {
			Block block = Block.getBlockById(60);
			par3World.playSoundEffect(par4 + 0.5F, par5 + 0.5F, par6 + 0.5F,
					block.stepSound.getBreakSound(),
					(block.stepSound.getVolume() + 1.0F) / 2.0F,
					block.stepSound.getPitch() * 0.8F);
			
			if (!par3World.isRemote) {
				par3World.setBlock(par4, par5, par6, block);
				par1ItemStack.damageItem(1, par2EntityPlayer);
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onChunkPreLoadEvent(PopulateChunkEvent.Pre event) {
		World worldObj = event.world;
		BiomeGenBase biome = worldObj.getBiomeGenForCoords(event.chunkX * 16,
				event.chunkZ * 16);
		if (biome.isEqualTo(BiomeList.candyLand)) {
			Chunk chunk = event.world.getChunkFromChunkCoords(event.chunkX,
					event.chunkZ);
			Block fromBlock = Blocks.stone;
			Block toBlock = BlockList.candyCubeBrown;
			for (ExtendedBlockStorage storage : chunk.getBlockStorageArray()) {
				if (storage != null) {
					for (int x = 0; x < 16; ++x) {
						for (int y = 0; y < 16; ++y) {
							for (int z = 0; z < 16; ++z) {
								if (storage.getBlockByExtId(x, y, z) == fromBlock) {
									Block theBlock = toBlock;
									int rand = new Random().nextInt(34);
									if (rand == 0) {
										theBlock = BlockList.candyCubeWhite;
									} else if (rand == 1) {
										theBlock = BlockList.candyCubeBlue;
									} else if (rand == 2) {
										theBlock = BlockList.candyCubeRed;
									} else if (rand == 3) {
										theBlock = BlockList.candyCubeCyan;
									} else if (rand == 4) {
										theBlock = BlockList.candyCubeOrange;
									} else if (rand == 5) {
										theBlock = BlockList.candyCubePurple;
									} else if (rand == 6) {
										theBlock = BlockList.candyCubeGreen;
									} else if (rand == 7) {
										theBlock = BlockList.candyCubeBrown;
									} else if (rand == 8) {
										theBlock = BlockList.candyCubeYellow;
									} else if (rand == 9) {
										theBlock = BlockList.candyCubePurple;
									} else if (rand == 10) {
										theBlock = BlockList.sugarCube;
									} else if (rand == 11) {
										theBlock = BlockList.chocolateBlock;
									} else if (rand == 12) {
										theBlock = BlockList.brownieBlock;
									} else if (rand == 13) {
										theBlock = BlockList.iceCreamSandwichBlock;
									} else if (rand == 14) {
										theBlock = BlockList.cookieBlock;
									} else {
										theBlock = toBlock;
									}
									storage.func_150818_a(x, y, z, theBlock);
								} else if (storage.getBlockByExtId(x, y, z) == Blocks.dirt) {
									storage.func_150818_a(x, y, z,
											BlockList.candyCubeOrange);
								} else if (storage.getBlockByExtId(x, y, z) == Blocks.gravel) {
									storage.func_150818_a(x, y, z,
											BlockList.candyCubeGray);
								} else if (storage.getBlockByExtId(x, y, z) == Blocks.clay) {
									storage.func_150818_a(x, y, z,
											BlockList.candyCubeBlack);
								}
							}
						}
					}
				}
			}
			chunk.isModified = true;
		} else if (biome.isEqualTo(BiomeList.crystalOcean)) {
			Chunk chunk = event.world.getChunkFromChunkCoords(event.chunkX,
					event.chunkZ);
			Block fromBlock = Blocks.stone;
			Block toBlock = BlockList.prismarine;
			for (ExtendedBlockStorage storage : chunk.getBlockStorageArray()) {
				if (storage != null) {
					for (int x = 0; x < 16; ++x) {
						for (int y = 0; y < 16; ++y) {
							for (int z = 0; z < 16; ++z) {
								if (storage.getBlockByExtId(x, y, z) == fromBlock
										|| storage.getBlockByExtId(x, y, z) == Blocks.dirt) {
									Block theBlock = toBlock;
									storage.func_150818_a(x, y, z, toBlock);
								}
							}
						}
					}
				}
			}
			chunk.isModified = true;
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onEntityStruckByLightningEvent(
			EntityStruckByLightningEvent event) {
		Entity theEntity = event.entity;
		World worldObj = theEntity.worldObj;
		if (theEntity instanceof EntityVillager) {
			EntityVillager theVillager = (EntityVillager) theEntity;
			theVillager.setDead();
			EntityWitch theWitch = new EntityWitch(worldObj);
			theWitch.setLocationAndAngles(theVillager.posX, theVillager.posY,
					theVillager.posZ, theVillager.rotationYaw,
					theVillager.rotationPitch);
			worldObj.spawnEntityInWorld(theWitch);
		}
	}
}