package zeta.zetaforged.mod.features.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class NegativeSlipperinessBlock extends Block {
    public NegativeSlipperinessBlock() {
        super(FabricBlockSettings.of(Material.METAL).slipperiness(-10.0f).strength(0.0f).hardness(0.0f));
    }
}
