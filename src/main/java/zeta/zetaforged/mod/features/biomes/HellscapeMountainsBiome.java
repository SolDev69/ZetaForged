package zeta.zetaforged.mod.features.biomes;

import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import org.apache.logging.log4j.Level;
import zeta.zetaforged.mod.ZetaForged;

public class HellscapeMountainsBiome {
    private static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> HELLSCAPE_MOUNTAINS_SURFACE_BUILDER = SurfaceBuilder.NOPE.withConfig(new TernarySurfaceConfig(Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState()));

    private static final Biome HELLSCAPE_MOUNTAINS = empty();

    private static Biome empty() {
        // We specify what entities spawn and what features generate in the biome.
        // Aside from some worldgen, trees, rocks, plants and
        //   custom entities, these are mostly the same for each biome.
        // Vanilla configured features for biomes are defined in DefaultBiomeFeatures.

        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
        DefaultBiomeFeatures.addMonsters(spawnSettings, 95, 5, 100);

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(
                HELLSCAPE_MOUNTAINS_SURFACE_BUILDER);

        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.NONE)
                .category(Biome.Category.NONE)
                .depth(Float.MIN_VALUE)
                .scale(0)
                .temperature(Float.POSITIVE_INFINITY)
                .downfall(0.0f)

                .effects(
                        (new BiomeEffects.Builder())
                        .waterColor(0)
                        .waterFogColor(0)
                        .fogColor(0)
                        .skyColor(0)
                        .build()
                )
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }

    private static final String MOD_ID = ZetaForged.MOD_ID;
    public static final RegistryKey<Biome> HELLSCAPE_MOUNTAINS_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier(MOD_ID, "hellscape_mountains"));

    public static void register() {
        ZetaForged.log(Level.INFO, "Adding hell");
        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier(MOD_ID, "hellscape_mountains"), HELLSCAPE_MOUNTAINS_SURFACE_BUILDER);
        Registry.register(BuiltinRegistries.BIOME, HELLSCAPE_MOUNTAINS_KEY.getValue(), HELLSCAPE_MOUNTAINS);
        if (addToWorldgenBoolean()) {
            addToWorldgen();
        }
        ZetaForged.log(Level.INFO,
                "Initialized easter egg biome, hehe."
                        //"Thanks to https://misode.github.io/ for the custom dimension creator I used to make the Lush Nether."
        );

    }

    public static void addToWorldgen() {
        OverworldBiomes.addContinentalBiome(HELLSCAPE_MOUNTAINS_KEY, OverworldClimate.SNOWY, 0.0625D);
        //OverworldBiomes.addContinentalBiome(CONCERNING_KEY, OverworldClimate.COOL, conc);
    }
    public static boolean addToWorldgenBoolean() {
        return false;
    }
}
