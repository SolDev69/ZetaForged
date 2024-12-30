package dev.solcraft.soltweaks.mixins.accessors;

import net.minecraft.util.math.noise.PerlinNoiseSampler;
import net.minecraft.util.math.noise.SimplexNoiseSampler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value = SimplexNoiseSampler.class, priority = 999)
public interface SimplexNoiseSamplerAccessors {
    @Invoker("dot")
    double invokeDot(int [] gArr, double x, double y, double z);
}
