package zeta.zetaforged.mod;

import me.zeroeightsix.fiber.exception.FiberException;
import net.fabricmc.fabric.api.biome.v1.NetherBiomes;
import net.fabricmc.fabric.api.biome.v1.TheEndBiomes;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.SharedConstants;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import zeta.zetaforged.mod.features.biomes.BiomesInitializer;
import zeta.zetaforged.mod.features.blocks.NegativeSlipperinessBlock;
import zeta.zetaforged.mod.features.items.SuperFireballItem;
import zeta.zetaforged.mod.managers.commands.CommandsManager;
import zeta.zetaforged.mod.features.errors.compute.ComputeErrorFunction;
import zeta.zetaforged.mod.features.items.ConcernedTater;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.BiomeKeys;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import zeta.zetaforged.mod.features.items.RegisterVoidItems;
import zeta.zetaforged.mod.managers.ConfigManager;

import java.sql.Date;
import java.util.Objects;

public class ZetaForged implements ModInitializer {

    private static Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "zetaforged";
	public static final String MOD_NAME = "ZetaForged";
	public static String MOD_VERSION;
	public static void setModVersion() {
		String modVersionImpl = FabricLoader.getInstance().getModContainer(MOD_ID).get().getMetadata().getVersion().toString();
		String modDataVersion = modVersionImpl.split("-")[0];
		Double modData = Double.parseDouble(modVersionImpl.split("\\.")[1]);
		if (Boolean.TRUE.equals(ConfigManager.getConfig().useClassicVersionString.getValue())) modDataVersion = "v"+modVersionImpl.split("-")[0];

		if (Boolean.TRUE.equals(ConfigManager.getConfig().useClassicVersionString.getValue()) && !modDataVersion.split("\\.")[1].contains("0")) {
			modDataVersion += ".0";
		}
		if (modVersionImpl.contains("prerelease")) {
			MOD_VERSION =  modDataVersion + " Pre-release " + modVersionImpl.split("\\.")[modVersionImpl.split("\\.").length-1];
		} else if(modVersionImpl.contains("rc")) {
			MOD_VERSION = modDataVersion + " Release Candidate " + modVersionImpl.split("\\.")[modVersionImpl.split("\\.").length-1];
		}
		else {
			MOD_VERSION = modVersionImpl;
		}
		if (getModVersion().endsWith("-")) MOD_VERSION = MOD_VERSION.split("-")[0];
		if (modVersionImpl.equals("1.1") || modVersionImpl.equals("v1.1.0")) MOD_VERSION += " - The Fringe Lands Update";
	}


	public static boolean isDevVersion() {
		return Boolean.TRUE.equals(ConfigManager.getConfig().isDevVersion.getValue());
	}

	public static String getModVersion() {
		return FabricLoader.getInstance().getModContainer(MOD_ID).get().getMetadata().getVersion().toString();
	}
	public static final byte V_TYPE = 0;

	public static final Error error = ComputeErrorFunction.computeHandler();
	//public static final Block VOID = new Block(FabricBlockSettings.of(Material.METAL).strength(0.0f));

	public static final Block CONCERN_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f));
	public static final Block HYPERCONCERN_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f));
	public static final ConcernedTater CONCERNED_TATER = new ConcernedTater(new FabricItemSettings().group(ZetaForged.ZETAFORGED_ITEMS));
	//public static final Item EXAMPLE_ITEM = Registry.register(Registry.ITEM,new Identifier("mymodid","example_item"), new Item(new FabricItemSettings().group(zeta.zetaforged.mod.ZetaForged.ZETAFORGED_ITEMS)));

	public static final Level LV = Level.INFO;
	public static double concerning_weight = Math.pow(2, -4);

	public static final ItemGroup ZETAFORGED_ITEMS = FabricItemGroupBuilder.create(
			new Identifier(MOD_ID,"zetaforged_group")).icon(
			() -> new ItemStack(CONCERN_BLOCK)).
			build();
	public static final Block TATER_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(5.0f));
	public static final Block GIGACONCERN_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(8.0f));

	public static final NegativeSlipperinessBlock TEST_BLOCK = new NegativeSlipperinessBlock();
	public static String ZFVersionString;

	@Override
	public void onInitialize() {
		//System.out.println(getModVersion().split("-")[1]);
		setModVersion();
		ZFVersionString = "ZetaForged " + ZetaForged.MOD_VERSION;
		log2("Initializing ZetaForged");
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "op_fireball"), new SuperFireballItem(new FabricItemSettings().group(ZETAFORGED_ITEMS)));
		//TrinaryHash.checkHash();
		log(Level.INFO, "Initializing config");
		log(Level.INFO, "Loading on minecraft version " + SharedConstants.getGameVersion().getName());
		try {
			ConfigManager.initialize();
		} catch (FiberException e) {
			log2("Loading failed!");
			e.printStackTrace();
		}
		log(Level.INFO, "Mod version " + MOD_VERSION);
		CommandsManager commandsInitializer = new CommandsManager();
		commandsInitializer.initCommands();
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		/*
		Do not uncomment!
		 */
		//if (!System.getProperty("java.version").contains("16")) {
		//	String error = "Java version too old or too new!";
		//	JavaVersionTooOldException exception = new JavaVersionTooOldException(error);
		//	exception.printStackTrace();
		//	throw new Error(exception);
		//}
		log2("Running on java version " + System.getProperty("java.version"));
		log(Level.INFO,"Credit to SuperCoder79 for letting me use the worldborder expansion code");

		log2("I really need to remember to do this stuff (Adding easter eggs)");
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "tater_block"), TATER_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "tater_block"), new BlockItem(TATER_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		if (isDevVersion()) {
			Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "test_negative_slipperiness_titanium"), TEST_BLOCK);
			Registry.register(Registry.ITEM, new Identifier(MOD_ID, "test_negative_slipperiness_titanium"), new BlockItem(TEST_BLOCK, new FabricItemSettings()));
		}

		log(Level.INFO, "Loading!");
		log(Level.INFO, "Adding biomes");
		OverworldBiomes.addContinentalBiome(BiomeKeys.LUSH_CAVES, OverworldClimate.TEMPERATE, 0.25D);
		OverworldBiomes.addContinentalBiome(BiomeKeys.DRIPSTONE_CAVES, OverworldClimate.COOL, 0.25D);
		//OverworldBiomes.addContinentalBiome(BiomeKeys.NETHER_WASTES, OverworldClimate.DRY, 0.0625D);
		//TheEndBiomes.addHighlandsBiome(BiomeKeys.LUSH_CAVES, 0.0625d);
		//NetherBiomes.addNetherBiome(BiomeKeys.LUSH_CAVES);
		TheEndBiomes.addMainIslandBiome(BiomeKeys.LUSH_CAVES, 0.0625d);
		TheEndBiomes.addSmallIslandsBiome(BiomeKeys.LUSH_CAVES, 0.25d);
		NetherBiomes.addNetherBiome(BiomeKeys.LUSH_CAVES, new Biome.MixedNoisePoint(Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE));
		log(Level.INFO, "Adding concerning items!");
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "concern_block"), CONCERN_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "concern_block"), new BlockItem(CONCERN_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "hyperconcern_block"), HYPERCONCERN_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "hyperconcern_block"), new BlockItem(HYPERCONCERN_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "gigaconcern_block"), GIGACONCERN_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "gigaconcern_block"), new BlockItem(GIGACONCERN_BLOCK, new Item.Settings().group(ZetaForged.ZETAFORGED_ITEMS)));

		Registry.register(Registry.ITEM, new Identifier(MOD_ID,"concerned_tater"), CONCERNED_TATER);
		//ZetaForged.log(Level.INFO, "Patching Farlands!");

		//log2("Adding a very concern easter egg");
		OverworldBiomes.addContinentalBiome(BiomeKeys.THE_VOID, OverworldClimate.DRY,
				0.5D);


		BiomesInitializer.initializeBiomes();
		log(Level.INFO, "Registering extra items...");
		RegisterVoidItems items = new RegisterVoidItems();
		items.registerItems();
		//log(Level.INFO, "DONE!");
	}

	public static void log(Level level, String message){
		LOGGER.log(level, "["+MOD_NAME+"] " + message);
	}
	public static void log2(String message) {
		LOGGER.log(Level.INFO, "["+MOD_NAME+"] " + message);
	}
}
