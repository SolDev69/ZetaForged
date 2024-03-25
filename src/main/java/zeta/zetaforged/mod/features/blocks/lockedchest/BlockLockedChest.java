package zeta.zetaforged.mod.features.blocks.lockedchest;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.world.World;

public class BlockLockedChest extends Block {
    protected BlockLockedChest(int var1) {
        super(FabricBlockSettings.of(Material.WOOD));
        //this.blockIndexInTexture = 26;
    }

    // Sneaky sneaky, not yet
}

