package zollernextras.items;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.items.armor.ArmorMaterials;
import zollernextras.items.armor.amaranth.AmaranthArmor;
import zollernextras.items.armor.azurite.AzuriteArmor;
import zollernextras.items.armor.radium.RadiumArmor;
import zollernextras.items.armor.stone.StoneArmor;
import zollernextras.items.armor.wood.WoodArmor;
import zollernextras.items.armor.zollernium.ZollerniumArmor;
import zollernextras.items.crops.ItemEnderReed;
import zollernextras.items.crops.Seed;
import zollernextras.items.crops.SeedFood;
import zollernextras.items.food.CookedFood;
import zollernextras.items.food.CropFood;
import zollernextras.items.food.IceCream;
import zollernextras.items.food.PopcornBowl;
import zollernextras.items.food.RawFood;
import zollernextras.items.food.SweetFood;
import zollernextras.items.food.TreeFood;
import zollernextras.items.ingots.Gem;
import zollernextras.items.storage.ItemQuiver;
import zollernextras.items.swords.EnderSword;
import zollernextras.items.swords.IceSword;
import zollernextras.items.swords.LightSword;
import zollernextras.items.swords.NetherSword;
import zollernextras.items.swords.ThunderSword;
import zollernextras.items.swords.WitherSword;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.items.tools.amaranth.AmaranthAxe;
import zollernextras.items.tools.amaranth.AmaranthHoe;
import zollernextras.items.tools.amaranth.AmaranthPickaxe;
import zollernextras.items.tools.amaranth.AmaranthShovel;
import zollernextras.items.tools.amaranth.AmaranthSword;
import zollernextras.items.tools.azurite.AzuriteAxe;
import zollernextras.items.tools.azurite.AzuriteHoe;
import zollernextras.items.tools.azurite.AzuritePickaxe;
import zollernextras.items.tools.azurite.AzuriteShovel;
import zollernextras.items.tools.azurite.AzuriteSword;
import zollernextras.items.tools.ruby.RubyAxe;
import zollernextras.items.tools.ruby.RubyHoe;
import zollernextras.items.tools.ruby.RubyPickaxe;
import zollernextras.items.tools.ruby.RubyShovel;
import zollernextras.items.tools.ruby.RubySword;
import zollernextras.items.tools.sapphire.SapphireAxe;
import zollernextras.items.tools.sapphire.SapphireHoe;
import zollernextras.items.tools.sapphire.SapphirePickaxe;
import zollernextras.items.tools.sapphire.SapphireShovel;
import zollernextras.items.tools.sapphire.SapphireSword;
import zollernextras.items.tools.zollernium.ZollerniumAxe;
import zollernextras.items.tools.zollernium.ZollerniumHoe;
import zollernextras.items.tools.zollernium.ZollerniumPickaxe;
import zollernextras.items.tools.zollernium.ZollerniumShovel;
import zollernextras.items.tools.zollernium.ZollerniumSword;
import zollernextras.lib.ZollernHelper;
import zollernextras.potions.ZollernPotion;
import cpw.mods.fml.common.registry.GameRegistry;

public class ZollernItems {
	
	public static int totalItems = 0;
	
	public static Item spcItem = new GenericItem("superchargedcoal");
	public static Item shinedust = new GenericItem("shinedust");
	public static Item fuelonite = new GenericItem("fuelonite");
	public static Item ingotFueltonium = new GenericItem("fueltoniumingot");
	public static Item enderShard = new GenericItem("endershard");
	public static Item amaranthIngot = new GenericItem("amaranthingot");
	public static Item amaranthDust = new GenericItem("amaranthdust");
	public static Item zollerniumIngot = new GenericItem("zollerniumingot");
	public static Item zollerniumDust = new GenericItem("zollerniumdust");
	
	public static Item amaranthPickaxe = new AmaranthPickaxe(
			ToolMaterials.AMARANTH);
	public static Item amaranthSword = new AmaranthSword(ToolMaterials.AMARANTH);
	public static Item amaranthAxe = new AmaranthAxe(ToolMaterials.AMARANTH);
	public static Item amaranthShovel = new AmaranthShovel(
			ToolMaterials.AMARANTH);
	public static Item amaranthHoe = new AmaranthHoe(ToolMaterials.AMARANTH);
	
	public static Item amaranthHelmet = new AmaranthArmor(
			ArmorMaterials.AMARANTH, "amaranthhelmet", 0);
	public static Item amaranthChestplate = new AmaranthArmor(
			ArmorMaterials.AMARANTH, "amaranthchestplate", 1);
	public static Item amaranthLeggings = new AmaranthArmor(
			ArmorMaterials.AMARANTH, "amaranthleggings", 2);
	public static Item amaranthBoots = new AmaranthArmor(
			ArmorMaterials.AMARANTH, "amaranthboots", 3);
	
	public static Item zollerniumPickaxe = new ZollerniumPickaxe(
			ToolMaterials.ZOLLERNIUM);
	public static Item zollerniumAxe = new ZollerniumAxe(
			ToolMaterials.ZOLLERNIUM);
	public static Item zollerniumHoe = new ZollerniumHoe(
			ToolMaterials.ZOLLERNIUM);
	public static Item zollerniumShovel = new ZollerniumShovel(
			ToolMaterials.ZOLLERNIUM);
	public static Item zollerniumSword = new ZollerniumSword(
			ToolMaterials.ZOLLERNIUM);
	
	public static Item zollerniumHelmet = new ZollerniumArmor(
			ArmorMaterials.ZOLLERNIUM, "zollerniumhelmet", 0);
	public static Item zollerniumChestplate = new ZollerniumArmor(
			ArmorMaterials.ZOLLERNIUM, "zollerniumchestplate", 1);
	public static Item zollerniumLeggings = new ZollerniumArmor(
			ArmorMaterials.ZOLLERNIUM, "zollerniumleggings", 2);
	public static Item zollerniumBoots = new ZollerniumArmor(
			ArmorMaterials.ZOLLERNIUM, "zollerniumboots", 3);
	
	public static Item radiantHelmet = new RadiumArmor(ArmorMaterials.RADIANT,
			"radiumhelmet", 0);
	public static Item radiantChestplate = new RadiumArmor(
			ArmorMaterials.RADIANT, "radiumchestplate", 1);
	public static Item radiantLeggings = new RadiumArmor(
			ArmorMaterials.RADIANT, "radiumleggings", 2);
	public static Item radiantBoots = new RadiumArmor(ArmorMaterials.RADIANT,
			"radiumboots", 3);
	
	public static Item azuritePickaxe = new AzuritePickaxe();
	public static Item azuriteAxe = new AzuriteAxe();
	public static Item azuriteHoe = new AzuriteHoe();
	public static Item azuriteShovel = new AzuriteShovel();
	public static Item azuriteSword = new AzuriteSword();
	
	public static Item rubyPickaxe = new RubyPickaxe();
	public static Item rubyShovel = new RubyShovel();
	public static Item rubyAxe = new RubyAxe();
	public static Item rubyHoe = new RubyHoe();
	public static Item rubySword = new RubySword();
	
	public static Item sapphirePickaxe = new SapphirePickaxe();
	public static Item sapphireShovel = new SapphireShovel();
	public static Item sapphireAxe = new SapphireAxe();
	public static Item sapphireHoe = new SapphireHoe();
	public static Item sapphireSword = new SapphireSword();
	
	public static Item azuriteHelmet = new AzuriteArmor(ArmorMaterials.AZURITE,
			"azuritehelmet", 0);
	public static Item azuriteChestPlate = new AzuriteArmor(
			ArmorMaterials.AZURITE, "azuritechestplate", 1);
	public static Item azuriteLeggings = new AzuriteArmor(
			ArmorMaterials.AZURITE, "azuriteleggings", 2);
	public static Item azuriteBoots = new AzuriteArmor(ArmorMaterials.AZURITE,
			"azuriteboots", 3);
	
	public static Item woodHelmet = new WoodArmor(ArmorMaterials.WOOD,
			"woodhelmet", 0);
	public static Item woodChestplate = new WoodArmor(ArmorMaterials.WOOD,
			"woodchestplate", 1);
	public static Item woodLeggings = new WoodArmor(ArmorMaterials.WOOD,
			"woodleggings", 2);
	public static Item woodBoots = new WoodArmor(ArmorMaterials.WOOD,
			"woodboots", 3);
	
	public static Item stoneHelmet = new StoneArmor(ArmorMaterials.STONE,
			"stonehelmet", 0);
	public static Item stoneChestplate = new StoneArmor(ArmorMaterials.STONE,
			"stonechestplate", 1);
	public static Item stoneLeggings = new StoneArmor(ArmorMaterials.STONE,
			"stoneleggings", 2);
	public static Item stoneBoots = new StoneArmor(ArmorMaterials.STONE,
			"stoneboots", 3);
	
	public static Item banana = new TreeFood("banana", 4, 4);
	public static Item orange = new TreeFood("orange", 3, 5);
	public static Item guava = new TreeFood("guava", 2, 6);
	public static Item lemon = new TreeFood("lemon", 2, 2);
	public static Item lime = new TreeFood("lime", 3, 2);
	public static Item limon = new TreeFood("limon", 3, 3);
	public static Item cherry = new TreeFood("cherry", 2, 2);
	public static Item grapefruit = new TreeFood("grapefruit", 5, 5);
	public static Item peach = new TreeFood("peach", 4, 6);
	
	public static Item swampClayBall = new GenericItem("swampclayball");
	public static Item zincIngot = new GenericItem("zincingot");
	public static Item zincDust = new GenericItem("zincdust");
	public static Item shinestoneIngot = new GenericItem("shinestoneingot");
	public static Item shiniumIngot = new GenericItem("shinium");
	public static Item shiniumDust = new GenericItem("shiniumdust");
	public static Item flour = new GenericItem("flour");
	public static Item heartForce = new ItemHeartForce();
	public static Item heart = new ItemHeart();
	public static Item amber = new Gem("amber");
	public static Item staticAmber = new Gem("staticamber");
	public static Item azurite = new Gem("azurite");
	public static Item aquamarine = new Gem("aquamarine");
	public static Item icyAqua = new Gem("icyaqua");
	public static Item garnet = new Gem("garnet");
	public static Item fireGarnet = new Gem("firegarnet");
	public static Item topaz = new Gem("topaz");
	public static Item opal = new Gem("opal");
	public static Item enderOpal = new Gem("enderopal");
	public static Item enderite = new Gem("enderite");
	public static Item lapisIngot = new Gem("lapisingot");
	public static Item witherite = new Gem("witherite");
	public static Item shadowEssence = new Gem("shadowessence");
	public static Item netheridium = new Gem("netheridium");
	public static Item ruby = new Gem("ruby");
	public static Item sapphire = new Gem("sapphire");
	public static Item enderDiamond = new Gem("enderdiamond");
	
	public static Item thorSword = new ThunderSword(ToolMaterials.POWER);
	public static Item enderSword = new EnderSword(ToolMaterials.POWER);
	public static Item diabloSword = new NetherSword(ToolMaterials.POWER);
	public static Item iceSword = new IceSword(ToolMaterials.POWER);
	public static Item witherSword = new WitherSword(ToolMaterials.POWER);
	public static Item lightSword = new LightSword(ToolMaterials.POWER);
	
	public static Item rawShrimp = new RawFood("rawshrimp");
	public static Item cookedShrimp = new CookedFood("cookedshrimp");
	public static Item rawDuck = new RawFood("rawduck");
	public static Item cookedDuck = new CookedFood("cookedduck");
	public static Item rawBacon = new RawFood("rawbacon");
	public static Item cookedBacon = new CookedFood("cookedbacon");
	public static Item boiledEgg = new CookedFood("boiledegg");
	public static Item duckEgg = new ItemDuckEgg();
	public static Item duckFeather = new GenericItem("duckfeather");
	public static Item shadowBone = new GenericItem("shadowbone");
	public static Item marbleStick = new GenericItem("marblestick");
	public static Item blackMarbleStick = new GenericItem("blackmarblestick");
	public static Item lapisStick = new GenericItem("lapisstick");
	public static Item powerStick = new GenericItem("powerrod");
	public static Item greenDye = new GenericItem("greendye");
	public static Item quiver = new ItemQuiver();
	
	public static Item blueberry = new SeedFood(2, 0.2F,
			ZollernBlocks.blueberry, Blocks.farmland, "blueberry");
	public static Item blackberry = new SeedFood(2, 0.2F,
			ZollernBlocks.blackberry, Blocks.farmland, "blackberry");
	public static Item grape = new SeedFood(2, 0.4F, ZollernBlocks.grape,
			Blocks.farmland, "grape");
	public static Item strawberry = new SeedFood(2, 0.6F,
			ZollernBlocks.strawberry, Blocks.farmland, "strawberry");
	public static Item radish = new SeedFood(3, 0.4F, ZollernBlocks.radish,
			Blocks.farmland, "radish");
	public static Item garlic = new SeedFood(1, 0.2F, ZollernBlocks.garlic,
			Blocks.farmland, "garlic");
	public static Item onion = new SeedFood(2, 0.6F, ZollernBlocks.onion,
			Blocks.farmland, "onion");
	public static Item cornKernel = new Seed("cornkernel", ZollernBlocks.corn);
	public static Item corn = new CropFood("corn", 4, 5);
	public static Item popcorn = new CookedFood("popcorn", 2, 4);
	public static Item popcornBowl = new PopcornBowl();
	public static Item pea = new Seed("pea", ZollernBlocks.peas);
	public static Item peaPod = new CropFood("peas", 2, 3);
	public static Item tomato = new CropFood("tomato", 3, 3);
	public static Item tomatoSeeds = new Seed("tomatoseeds",
			ZollernBlocks.tomatoes);
	public static Item cucumber = new CropFood("cucumber", 4, 4);
	public static Item cucumberSeeds = new Seed("cucumberseeds",
			ZollernBlocks.cucumbers);
	
	public static Item obsidianDust = new GenericItem("obsidiandust");
	public static Item silverNugget = new GenericItem("silvernugget");
	public static Item silverIngot = new GenericItem("silveringot");
	public static Item obsidianIngot = new GenericItem("obsidianingot");
	public static Item rawLamb = new RawFood("rawlamb");
	public static Item cookedLamb = new CookedFood("cookedlamb", true);
	public static Item prismarineShard = new GenericItem("prismarineshard");
	public static Item prismarineCrystal = new GenericItem("prismarinecrystal");
	public static Item rawChocolate = new GenericItem("rawchocolate");
	public static Item creamBall = new GenericItem("creamball");
	public static Item chocolateBar = new SweetFood("chocolatebar",
			Potion.jump.id);
	public static Item brownie = new SweetFood("brownie", Potion.resistance.id);
	public static Item candyApple = new SweetFood("candyapple",
			Potion.moveSpeed.id);
	public static Item iceCream = new IceCream();
	public static Item iceCreamSandwich = new SweetFood("icecreamsandwich",
			Potion.damageBoost.id);
	public static Item chocolateStrawberry = new SweetFood(
			"strawberry_chocolate", Potion.damageBoost.id);
	public static Item sharkLeather = new GenericItem("shagreen");
	public static Item sharkTooth = new GenericItem("sharktooth");
	
	// Colored Bricks
	public static Item bricksBrown = new ColoredBrick("brown");
	public static Item bricksLime = new ColoredBrick("lime");
	public static Item bricksLightBlue = new ColoredBrick("lightblue");
	public static Item bricksLightGray = new ColoredBrick("lightgray");
	public static Item bricksGray = new ColoredBrick("gray");
	public static Item bricksMagenta = new ColoredBrick("magenta");
	public static Item bricksOrange = new ColoredBrick("orange");
	public static Item bricksBlack = new ColoredBrick("black");
	public static Item bricksWhite = new ColoredBrick("white");
	public static Item bricksPink = new ColoredBrick("pink");
	public static Item bricksYellow = new ColoredBrick("yellow");
	public static Item bricksGreen = new ColoredBrick("green");
	public static Item bricksCyan = new ColoredBrick("cyan");
	public static Item bricksRed = new ColoredBrick("red");
	public static Item bricksBlue = new ColoredBrick("blue");
	public static Item bricksPurple = new ColoredBrick("purple");
	public static Item bricksMud = new ColoredBrick("mud");
	
	public static Item netherEye = new ItemNetherEye();
	public static Item upsideDownEyeUncharged = new GenericItem(
			"upsidedowneye_uncharged");
	public static Item upsideDownEye = new ItemUpsideDownEye();
	public static Item enderReeds = new ItemEnderReed();
	public static Item dough = new GenericItem("dough");
	public static Item cookedDough = new GenericItem("cookeddough");
	public static Item tomatoPaste = new ZollernBottle("tomatopaste");
	public static Item enderBerry = new TreeFood("enderberry", 2, 5);
	public static Item enderGlowstoneDust = new GenericItem(
			"enderglowstonedust");
	public static Item chargiumDust = new GenericItem("chargiumdust");
	public static Item chargiumIngot = new GenericItem("chargiumingot");
	public static Item radiance = new GenericItem("radiance");
	public static Item shadeKey = new GenericItem("shadekey")
			.setDetails("Unlocks the Shadow Spawner.");
	public static Item steelIngot = new GenericItem("steelingot");
	public static Item steelDust = new GenericItem("steeldust");
	public static Item steelStick = new GenericItem("steelstick");
	
	public static Item chocolateBucket = new ZollernBucket("bucket_chocolate",
			ZollernBlocks.blockChocolate);
	public static Item fuelBucket = new ZollernBucket("fuelbucket",
			ZollernBlocks.blockFuel);
	public static Item chargiumBucket = new ZollernBucket("chargiumbucket",
			ZollernBlocks.blockChargium);
	public static Item whiteLavaBucket = new ZollernBucket("whitelavabucket",
			ZollernBlocks.blockWhiteLava);
	
	public static Item radiancePotion = new ZollernPotionItem("radiancepotion",
			ZollernPotion.radiance);
	public static Item jumpPotion = new ZollernPotionItem("jumppotion",
			Potion.jump);
	
	public static void init() {
		addItem(spcItem, "Super Charged Coal");
		addItem(shinedust, "Shinedust");
		addItem(fuelonite, "Fuelonite");
		addItem(ingotFueltonium, "Fueltonium Ingot");
		addItem(enderShard, "Ender Shard");
		addItem(amaranthIngot, "Amaranth Ingot");
		addItem(amaranthDust, "Amaranth Dust");
		addItem(amaranthPickaxe, "Amaranth Pickaxe");
		addItem(amaranthSword, "Amaranth Sword");
		addItem(amaranthAxe, "Amaranth Axe");
		addItem(amaranthShovel, "Amaranth Shovel");
		addItem(amaranthHoe, "Amaranth Hoe");
		addItem(amaranthHelmet, "Amaranth Helmet");
		addItem(amaranthChestplate, "Amaranth Chestplate");
		addItem(amaranthLeggings, "Amaranth Leggings");
		addItem(amaranthBoots, "Amaranth Boots");
		addItem(swampClayBall, "Swamp Clay Ball");
		addItem(zincIngot, "Zinc Ingot");
		addItem(zincDust, "Zinc Dust");
		addItem(zollerniumIngot, "Zollernium Ingot");
		addItem(zollerniumDust, "Zollernium Dust");
		addItem(zollerniumPickaxe, "Zollernium Pickaxe");
		addItem(zollerniumAxe, "Zollernium Axe");
		addItem(zollerniumShovel, "Zollernium Shovel");
		addItem(zollerniumHoe, "Zollernium Hoe");
		addItem(zollerniumSword, "Zollernium Sword");
		addItem(zollerniumHelmet, "Zollernium Helmet");
		addItem(zollerniumChestplate, "Zollernium Chestplate");
		addItem(zollerniumLeggings, "Zollernium Leggings");
		addItem(zollerniumBoots, "Zollernium Boots");
		addItem(radiantHelmet, "Radiant Helmet");
		addItem(radiantChestplate, "Radiant Chestplate");
		addItem(radiantLeggings, "Radiant Leggings");
		addItem(radiantBoots, "Radiant Boots");
		
		addItem(azuritePickaxe, "Azurite Pickaxe");
		addItem(azuriteAxe, "Azurite Axe");
		addItem(azuriteHoe, "Azurite Hoe");
		addItem(azuriteShovel, "Azurite Shovel");
		addItem(azuriteSword, "Azurite Sword");
		addItem(azuriteHelmet, "Azurite Helmet");
		addItem(azuriteChestPlate, "Azurite Chestplate");
		addItem(azuriteLeggings, "Azurite Leggings");
		addItem(azuriteBoots, "Azurite Boots");
		addItem(rubyPickaxe, "Ruby Pickaxe");
		addItem(rubyAxe, "Ruby Axe");
		addItem(rubyHoe, "Ruby Hoe");
		addItem(rubyShovel, "Ruby Shovel");
		addItem(rubySword, "Ruby Sword");
		addItem(sapphirePickaxe, "Sapphire Pickaxe");
		addItem(sapphireAxe, "Sapphire Axe");
		addItem(sapphireHoe, "Sapphire Hoe");
		addItem(sapphireShovel, "Sapphire Shovel");
		addItem(sapphireSword, "Sapphire Sword");
		addItem(woodHelmet, "Wood Helmet");
		addItem(woodChestplate, "Wood Chestplate");
		addItem(woodLeggings, "Wood Leggings");
		addItem(woodBoots, "Wood Boots");
		addItem(stoneHelmet, "Stone Helmet");
		addItem(stoneChestplate, "Stone Chestplate");
		addItem(stoneLeggings, "Stone Leggings");
		addItem(stoneBoots, "Stone Boots");
		addItem(shinestoneIngot, "Shinestone Ingot");
		addItem(shiniumIngot, "Shinium Ingot");
		addItem(shiniumDust, "Precious Shinium");
		addItem(flour, "Flour");
		addItem(heart, "Healing Heart");
		addItem(heartForce, "Health Upgrade");
		addItem(amber, "Amber");
		addItem(staticAmber, "Static Amber");
		addItem(azurite, "Azurite");
		addItem(aquamarine, "Aquamarine");
		addItem(icyAqua, "Icy Aqua");
		addItem(garnet, "Garnet");
		addItem(fireGarnet, "Fire Garnet");
		addItem(topaz, "Topaz");
		addItem(opal, "Opal");
		addItem(enderOpal, "Ender Opal");
		addItem(enderite, "Enderite");
		addItem(lapisIngot, "Lapis Ingot");
		addItem(witherite, "Witherite");
		addItem(shadowEssence, "Shadow Essence");
		addItem(netheridium, "Netheridium");
		addItem(ruby, "Ruby");
		addItem(sapphire, "Sapphire");
		
		addItem(thorSword, "Thunder Sword");
		addItem(enderSword, "Ender Sword");
		addItem(diabloSword, "Nether Sword");
		addItem(iceSword, "Ice Sword");
		addItem(witherSword, "Wither Sword");
		addItem(lightSword, "Light Sword");
		
		addItem(rawShrimp, "Raw Shrimp");
		addItem(cookedShrimp, "Cooked Shrimp");
		addItem(rawDuck, "Raw Duck");
		addItem(cookedDuck, "Cooked Duck");
		addItem(duckEgg, "Duck Egg");
		addItem(duckFeather, "Duck Feather");
		addItem(boiledEgg, "Boiled Egg");
		addItem(shadowBone, "Shadow Bone");
		addItem(marbleStick, "White Cave Marble Stick");
		addItem(blackMarbleStick, "Black Cave Marble Stick");
		addItem(lapisStick, "Lapis Stick");
		addItem(powerStick, "Power Stick");
		addItem(greenDye, "Green Dye");
		addItem(quiver, "Quiver");
		
		addItem(blueberry, "Blueberry");
		addItem(blackberry, "Blackberry");
		addItem(grape, "Grape");
		addItem(strawberry, "Strawberry");
		addItem(radish, "Radish");
		addItem(garlic, "Garlic");
		addItem(onion, "Onion");
		addItem(cucumber, "Cucumber");
		addItem(cucumberSeeds, "Cucumber Seeds");
		addItem(pea, "Pea");
		addItem(tomato, "Tomato");
		addItem(tomatoSeeds, "Tomato Seeds");
		addItem(peaPod, "Pea Pod");
		addItem(cornKernel, "Corn Kernel");
		addItem(corn, "Corn");
		addItem(popcorn, "Popcorn");
		addItem(popcornBowl, "Popcorn Bowl");
		
		addItem(banana, "Banana");
		addItem(orange, "Orange");
		addItem(guava, "Guava");
		addItem(lemon, "Lemon");
		addItem(lime, "Lime");
		addItem(limon, "Limon");
		addItem(cherry, "Cherry");
		addItem(grapefruit, "Grapefruit");
		addItem(peach, "Peach");
		
		addItem(rawBacon, "Raw Bacon");
		addItem(cookedBacon, "Cooked Bacon");
		addItem(obsidianDust, "Obsidian Dust");
		addItem(silverNugget, "Silver Nugget");
		addItem(silverIngot, "Silver Ingot");
		addItem(obsidianIngot, "Obsidian Ingot");
		addItem(rawLamb, "Raw Mutton");
		addItem(cookedLamb, "Cooked Mutton");
		addItem(prismarineShard, "Prismarine Shard");
		addItem(prismarineCrystal, "Prismarine Crystal");
		addItem(rawChocolate, "Raw Chocolate");
		addItem(creamBall, "Cream Ball");
		addItem(chocolateBar, "Chocolate Bar");
		addItem(brownie, "Brownie");
		addItem(candyApple, "Candy Apple");
		addItem(iceCream, "Ice Cream");
		addItem(iceCreamSandwich, "Ice Cream Sandwich");
		addItem(chocolateStrawberry, "Chocolate Strawberry");
		addItem(sharkLeather, "Shagreen");
		addItem(sharkTooth, "Shark Tooth");
		
		addItem(bricksBrown, "Brown Brick Ingot");
		addItem(bricksLime, "Lime Green Brick Ingot");
		addItem(bricksLightBlue, "Light Blue Brick Ingot");
		addItem(bricksLightGray, "Light Gray Brick Ingot");
		addItem(bricksGray, "Gray Brick Ingot");
		addItem(bricksMagenta, "Magenta Brick Ingot");
		addItem(bricksOrange, "Orange Brick Ingot");
		addItem(bricksBlack, "Black Brick Ingot");
		addItem(bricksWhite, "White Brick Ingot");
		addItem(bricksPink, "Pink Brick Ingot");
		addItem(bricksYellow, "Yellow Brick Ingot");
		addItem(bricksGreen, "Green Brick Ingot");
		addItem(bricksCyan, "Cyan Brick Ingot");
		addItem(bricksRed, "Red Brick ingot");
		addItem(bricksBlue, "Blue Brick Ingot");
		addItem(bricksPurple, "Purple Brick Ingot");
		addItem(bricksMud, "Mud Brick Ingot");
		
		addItem(netherEye, "Nether Eye");
		addItem(upsideDownEyeUncharged, "Upside-Down Eye Uncharged");
		addItem(upsideDownEye, "Upside-Down Eye");
		addItem(enderReeds, "Ender Cane");
		addItem(dough, "Dough");
		addItem(tomatoPaste, "Tomato Paste");
		addItem(cookedDough, "Cooked Dough");
		addItem(enderBerry, "Ender Berry");
		addItem(enderDiamond, "Ender Diamond");
		addItem(enderGlowstoneDust, "Ender Glowstone Dust");
		addItem(chargiumDust, "Chargium Dust");
		addItem(chargiumIngot, "Chargium Ingot");
		addItem(radiance, "Radiance");
		addItem(shadeKey, "Shade Key");
		addItem(steelIngot, "Steel Ingot");
		addItem(steelDust, "Steel Dust");
		addItem(steelStick, "Steel Stick");
		
		addItem(chocolateBucket, "Chocolate Bucket");
		addItem(fuelBucket, "Fueltonium Bucket");
		addItem(chargiumBucket, "Chargium Bucket");
		addItem(whiteLavaBucket, "White Lava Bucket");
		
		addItem(radiancePotion, "radiance potion");
		addItem(jumpPotion, "jump potion");
		
		ZollernHelper.Log("Items loaded, " + totalItems + " entries.");
	}
	
	public static void addItem(Item item, String name) {
		GameRegistry.registerItem(item, name);
		// LanguageRegistry.addName(item, name);
		totalItems++;
	}
}