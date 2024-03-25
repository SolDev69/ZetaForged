package zeta.zetaforged.mod.mixins.worldborder.supercoder;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.server.MinecraftServer;

@Mixin(MinecraftServer.class)
public class MixinMinecraftServer {
	/**
	 * @author SuperCoder79
	 * @reason a
	 */
	@Overwrite
	public int getMaxWorldBorderRadius() {
		return Integer.MAX_VALUE;
	}
}
