package zeta.zetaforged.mod.features.biomes;

import zeta.zetaforged.mod.ZetaForged;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import org.apache.logging.log4j.Level;

public class ObsidianBiome {
    private static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> OBSIDIAN_SURFACE_BUILDER = SurfaceBuilder.DEFAULT
            .withConfig(new TernarySurfaceConfig(
                    Blocks.OBSIDIAN.getDefaultState(),
                    Blocks.DIRT.getDefaultState(),
                    Blocks.GRAVEL.getDefaultState()));

    private static final Biome OBSILAND = createObsiland();

    private static Biome createObsiland() {
        // We specify what entities spawn and what features generate in the biome.
        // Aside from some worldgen, trees, rocks, plants and
        //   custom entities, these are mostly the same for each biome.
        // Vanilla configured features for biomes are defined in DefaultBiomeFeatures.

        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
        DefaultBiomeFeatures.addMonsters(spawnSettings, 95, 5, 100);

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(OBSIDIAN_SURFACE_BUILDER);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(generationSettings);
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addDefaultLakes(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings, true);
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        DefaultBiomeFeatures.addDefaultDisks(generationSettings);
        DefaultBiomeFeatures.addSprings(generationSettings);
        DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);

        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.RAIN)
                .category(Biome.Category.NONE)
                .depth(0.125F)
                .scale(0.05F)
                .temperature(0.8F)
                .downfall(0.4F)
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x3f76e4)
                        .waterFogColor(0x050533)
                        .fogColor(0xc0d8ff)
                        .skyColor(0x77adff)
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }

    private static final String MOD_ID = ZetaForged.MOD_ID;
    public static final RegistryKey<Biome> OBSILAND_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier(MOD_ID, "obsiland"));

    public static void register() {
        ZetaForged.log(Level.INFO, "Adding biomes");
        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier(MOD_ID, "obsidian"), OBSIDIAN_SURFACE_BUILDER);
        Registry.register(BuiltinRegistries.BIOME, OBSILAND_KEY.getValue(), OBSILAND);
        if (addToWorldgenBoolean()) {
            addToWorldgen();
        }
        ZetaForged.log(Level.INFO,
                "Initialized Obsidian biome."
        );
    }
    public static void addToWorldgen() {
        //OverworldBiomes.addContinentalBiome(OBSILAND_KEY, OverworldClimate.TEMPERATE, 0.0625);
        OverworldBiomes.addContinentalBiome(OBSILAND_KEY, OverworldClimate.COOL, 0.0625D);
    }
    public static boolean addToWorldgenBoolean() {
        return true;
    }
}
