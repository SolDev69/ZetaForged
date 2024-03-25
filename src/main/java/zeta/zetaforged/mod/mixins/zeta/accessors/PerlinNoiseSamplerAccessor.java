package zeta.zetaforged.mod.mixins.zeta.accessors;

import net.minecraft.util.math.noise.PerlinNoiseSampler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value = PerlinNoiseSampler.class, priority = 999)
public interface PerlinNoiseSamplerAccessor {
    @Invoker("sample")
    double invokeSample(int sectionX, int sectionY, int sectionZ, double localX, double localY, double localZ, double fadeLocalX);
}