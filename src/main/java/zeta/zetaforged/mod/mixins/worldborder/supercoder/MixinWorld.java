package zeta.zetaforged.mod.mixins.worldborder.supercoder;

import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(World.class)
public abstract class MixinWorld implements WorldAccess {

	/**
	 * @author SuperCoder79
	 * @reason
	 */
	@Overwrite @Final
	public static boolean isValidHorizontally(BlockPos pos) {
		return pos.getX() >= Integer.MIN_VALUE && pos.getZ() >= Integer.MIN_VALUE && pos.getX() < Integer.MAX_VALUE && pos.getZ() < Integer.MAX_VALUE;
	}



	/**
	 * @author SuperCoder79
	 * @reason
	 */
	@Overwrite @Final
	public static boolean isInvalidVertically(int y) {
		return y < Integer.MIN_VALUE || y >= Integer.MAX_VALUE;
	}

	/**
	 * @author
	 */
	@Overwrite
	public int getTopY(Heightmap.Type heightmap, int x, int z) {
		int k;
		if (x >= Integer.MIN_VALUE && z >= Integer.MIN_VALUE && x < Integer.MAX_VALUE && z < Integer.MAX_VALUE) {
			if (this.isChunkLoaded(ChunkSectionPos.getSectionCoord(x), ChunkSectionPos.getSectionCoord(z))) {
				k = this.getChunk(ChunkSectionPos.getSectionCoord(x), ChunkSectionPos.getSectionCoord(z)).sampleHeightmap(heightmap, x & 15, z & 15) + 1;
			} else {
				k = this.getBottomY();
			}
		} else {
			k = this.getSeaLevel() + 1;
		}

		return k;
	}
}
