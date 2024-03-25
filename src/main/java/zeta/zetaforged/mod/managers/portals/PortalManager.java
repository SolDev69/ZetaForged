package zeta.zetaforged.mod.managers.portals;

import net.fabricmc.api.ModInitializer;
import net.kyrptonaught.customportalapi.CustomPortalApiRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import zeta.zetaforged.mod.ZetaForged;
import zeta.zetaforged.mod.features.items.RegisterVoidItems;
import zeta.zetaforged.mod.features.keystone.Keystone;

public class PortalManager implements ModInitializer {
    @Override
    public void onInitialize() {
        CustomPortalApiRegistry.addPortal(Blocks.MOSS_BLOCK,
                new Identifier(ZetaForged.MOD_ID, "lush_nether"),
                0, 64, 8);
        CustomPortalApiRegistry.addPortal(Keystone.KEYSTONE_BLOCK,
                new Identifier(ZetaForged.MOD_ID, "etheral"),
                127, 127, 0);
        CustomPortalApiRegistry.addPortal(ZetaForged.GIGACONCERN_BLOCK,
                new Identifier(ZetaForged.MOD_ID, "concerningworld"),
                32, 105, 168
        );
        CustomPortalApiRegistry.addPortal(RegisterVoidItems.VoidBlock_BLOCK,
                new Identifier(ZetaForged.MOD_ID, "void_dimension"),
                0,0,0
        );

    }
    public Identifier ZMI(String name) {
        return new Identifier(ZetaForged.MOD_ID, name);
    }
}
