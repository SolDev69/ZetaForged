package dev.solcraft.soltweaks.mixins.worldborder.supercoder;

import dev.solcraft.soltweaks.managers.ConfigManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.world.border.WorldBorder;

@Mixin(WorldBorder.class)
public class MixinWorldBorder {
	@Shadow private int maxRadius;

	@Shadow private WorldBorder.Area area;

	@Inject(method = "<init>", at = @At("RETURN"))
	private void handleConstructor(CallbackInfo ci) {
		this.maxRadius = (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Boolean.TRUE.equals(ConfigManager.getConfig().worldborderExpansion.getValue()) ? ConfigManager.getConfig().worldBorderMaxSize.getValue() : 6E7D / 2.0D));
		this.area = ((WorldBorder)(Object)this).new StaticArea(Boolean.TRUE.equals(ConfigManager.getConfig().worldborderExpansion.getValue()) ? ConfigManager.getConfig().worldBorderSize.getValue() : 6E7D);
	}
}
