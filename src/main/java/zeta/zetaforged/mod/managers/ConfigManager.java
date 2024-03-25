package zeta.zetaforged.mod.managers;

import me.zeroeightsix.fiber.JanksonSettings;
import me.zeroeightsix.fiber.exception.FiberException;
import me.zeroeightsix.fiber.tree.ConfigNode;
import me.zeroeightsix.fiber.tree.ConfigValue;
import me.zeroeightsix.fiber.tree.Node;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import zeta.zetaforged.mod.ZetaForged;

import java.io.*;
import java.nio.file.Files;

public class ConfigManager  {
    /*
     * Copied from https://github.com/geniiii/FarLands/blob/master/src/main/java/site/geni/farlands/config/Config.java
     */
    public static final File CONFIG_FILE = new File(FabricLoader.getInstance().getConfigDirectory(),
             "zetaforged." +
                    "json5"
    );

    final private ConfigNode root = new ConfigNode();

    private final Node general = root.fork("General");
    private Node world = root.fork("World");
    private Node gameplay = root.fork("Gameplay");

    // Still @Overwrite-able!

    public static boolean farlandsDefaultValue() {
        return true;
    }
    public ConfigValue<Boolean> useClassicVersionString = ConfigValue.builder(Boolean.class)
            .withName("useClassicVersionString")
            .withComment("This will add back the \"v\" before the version number and the extra 0 at the end if no minor version is found")
            .withDefaultValue(false)
            .withParent(general)
            .build();
    public ConfigValue<Boolean> isDevVersion = ConfigValue.builder(Boolean.class)
            .withName("isDev")
            .withComment("Will force enable /dev flags")
            .withDefaultValue(ZetaForged.getModVersion().contains("-") || FabricLoader.getInstance().isDevelopmentEnvironment())
            .withParent(general)
            .build();
    public ConfigValue<Integer> superFireballStrength = ConfigValue.builder(Integer.class)
            .withName("superFireballStrength")
            .withDefaultValue(100)
            .withParent(gameplay)
            .build();
    public ConfigValue<Integer> fireballCap = ConfigValue.builder(Integer.class)
            .withName("fireballCap")
            .withComment("Maximum strength a fireball can be set. Currently useless. Will override fixFireballs.")
            .withDefaultValue(100)
            .withParent(gameplay)
            .build();
    public ConfigValue<Boolean> fixFireballs = ConfigValue.builder(Boolean.class)
            .withName("capFireballs")
            .withComment("If set to true, removes the patch done " +
                    "to fix " +
                    "https://bugs.mojang.com/browse/MC-220698" +
                    "and makes bedrock farms work again")
            .withDefaultValue(true)
            .withParent(gameplay)
            .build();
    public ConfigValue<Boolean> farLandsEnabled = ConfigValue.builder(Boolean.class)
            .withName("farLandsEnabled")
            .withComment("Whether or not the " +
                    "Far Lands should generate.")
            .withDefaultValue(farlandsDefaultValue())
            .withParent(general)
            .build();
    public ConfigValue<Boolean> shardFarLands = ConfigValue.builder(Boolean.class)
            .withName("shardFarLands")
            .withComment("Should the shard farlands spawn?")
            .withDefaultValue(false)
            .withParent(general)
            .build();
    private Node hashNode = root.fork("Hash Key");
    public ConfigValue<String> hash = ConfigValue.builder(String.class)
            .withName("hash")
            .withComment("private hash given out to testers")
            .withDefaultValue("")
            .withParent(hashNode)
            .build();
    public ConfigValue<Double> coordinateScale = ConfigValue.builder(Double.class)
            .withName("coordinateScale")
            .withComment("The world's coordinate scale.")
            .withDefaultValue(684.412D)
            .withParent(world)
            .build();
    public ConfigValue<Double> individualCoordinateScaleMultiplierX = ConfigValue.builder(Double.class)
            .withName("individualCoordinateScaleMultiplierX")
            //.withComment("World's coordinate scale on the X axis")
            .withDefaultValue(1.0d)
            .withParent(world)
            .build();
    public ConfigValue<Double> individualCoordinateScaleMultiplierZ = ConfigValue.builder(Double.class)
            .withName("individualCoordinateScaleMultiplierZ")
            //.withComment("World's coordinate scale on the Z axis")
            .withDefaultValue(1.0d)
            .withParent(world)
            .build();
    public ConfigValue<Double> coordinateScaleMultiplier = ConfigValue.builder(Double.class)
            .withName("coordinateScaleMulti")
            .withComment("Coordinate scale " +
                    "multiplyer so you don't have to mess with" +
                    " the one above.")
            .withDefaultValue(1.0D)
            .withParent(world)
            .build();
    public ConfigValue<Double> heightScale = ConfigValue.builder(Double.class)
            .withName("heightScale")
            .withComment("The world's height scale.")
            .withDefaultValue(684.412D)
            .withParent(world)
            .build();
    public ConfigValue<Double> heightScaleMultiplier = ConfigValue.builder(Double.class)
            .withName("heightScaleMulti")
            .withComment("Height scale multiplyer" +
                    " so you don't have to mess with the one " +
                    "above.")
            .withDefaultValue(1.0D)
            .withParent(world)
            .build();
    public ConfigValue<Boolean> worldborderExpansion = ConfigValue.builder(Boolean.class)
            .withName("expandWorldBorder")
            .withComment("Will be the config value to expand worldborder in a later version")
            .withDefaultValue(true)
            .withParent(world)
            .build();
    public static ConfigManager getConfig() {
        return GeneralManager.CONFIG;
    }
    /*
    private ConfigManager() throws FiberException, IOException {
        File currentConfigFile = new File(FabricLoader.getInstance().getGameDir().toFile(),
                CONFIG_FILE.getName() + ".tmp");
        currentConfigFile.createNewFile();
        save(currentConfigFile);
        File configFile = new File(FabricLoader.getInstance().getConfigDirectory(),
                CONFIG_FILE.getName() + ".tmp");
        configFile.createNewFile();
        //if(CONFIG_FILE.exists()) {
        //    if(currentConfigFile.hashCode() != CONFIG_FILE.hashCode()) {

        //    } else {
        //        LogManager.getLogger().log(Level.INFO, "Will not delete config file!");
        //    }
        //}
        if((!configFile.exists()) && CONFIG_FILE.exists()) {
            try {
                copy(CONFIG_FILE, configFile);
            } catch (NoSuchFileException e) {
                e.printStackTrace();
                throw e;
            }
        }
        if(!HelperUtilities.hash(configFile).equals(HelperUtilities.hash(currentConfigFile))) {
            logger.error("CONFIG FOUND WITH DIFFERENT HASH, DELETING!");
            CONFIG_FILE.delete();
             //configFile.delete();
        }
         //currentConfigFile.delete();
    }
     */
    public ConfigManager() throws FiberException {}


    private Logger logger = LogManager.getLogger();

    public static ConfigManager initialize() throws FiberException {
        return new ConfigManager();
    }

    public void save() {
        try {
            new JanksonSettings().serialize(this.root, Files.newOutputStream(CONFIG_FILE.toPath()), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ConfigManager load() {
        if (!CONFIG_FILE.exists()) {
            this.save();
        }

        try {
            new JanksonSettings().deserialize(this.root, Files.newInputStream(CONFIG_FILE.toPath()));
        } catch (IOException | FiberException e) {
            e.printStackTrace();
        }
        return this;
    }
}
