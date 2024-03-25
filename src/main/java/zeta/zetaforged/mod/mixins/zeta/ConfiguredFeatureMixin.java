package zeta.zetaforged.mod.mixins.zeta;

import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ConfiguredStructureFeature.class)
public class ConfiguredFeatureMixin {
    public ConfiguredFeatureMixin(Feature feature, FeatureConfig config) {
    }
}
