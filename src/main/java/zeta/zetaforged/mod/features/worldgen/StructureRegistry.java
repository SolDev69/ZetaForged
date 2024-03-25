package zeta.zetaforged.mod.features.worldgen;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.HeightmapDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import zeta.zetaforged.mod.ZetaForged;
import zeta.zetaforged.mod.features.worldgen.features.ConcernSpire;

import static zeta.zetaforged.mod.ZetaForged.MOD_ID;

public class StructureRegistry implements ModInitializer {
    private static final Feature<ConcernSpire.SpiralFeatureConfig> SPIRE = new ConcernSpire(ConcernSpire.SpiralFeatureConfig.CODEC);
    public static final ConfiguredFeature<?, ?> CONCERN_SPIRE = SPIRE.configure(new ConcernSpire.SpiralFeatureConfig(ConstantIntProvider.create(15), new SimpleBlockStateProvider(ZetaForged.CONCERN_BLOCK.getDefaultState())))
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.OCEAN_FLOOR_WG)))
            .spreadHorizontally()
            .applyChance(5);
    @Override
    public void onInitialize() {
        RegistryKey<ConfiguredFeature<?, ?>> concernSpire = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(MOD_ID, "spire"));
        Registry.register(Registry.FEATURE, concernSpire.getValue(), SPIRE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, concernSpire.getValue(), CONCERN_SPIRE);
        //BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, concernSpire);

    }
}
