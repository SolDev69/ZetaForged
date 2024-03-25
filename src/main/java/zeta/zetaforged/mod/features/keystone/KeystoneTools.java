package zeta.zetaforged.mod.features.keystone;

import net.minecraft.item.*;
import net.minecraft.util.registry.Registry;
import zeta.zetaforged.mod.features.materials.KeystoneToolMaterial;
import zeta.zetaforged.mod.features.items.tools.wideners.AxeItem;
import zeta.zetaforged.mod.features.items.tools.wideners.PickaxeItem;
import zeta.zetaforged.mod.features.items.tools.wideners.TillerItem;

import static zeta.zetaforged.mod.features.items.RegisterVoidItems.keystoneTool;

public class KeystoneTools {
    public KeystoneTools() {

    }
    public static void register() {
        Registry.register(Registry.ITEM, keystoneTool("sword"), KeystoneTools.KEYSTONE_BLADE);
        Registry.register(Registry.ITEM, keystoneTool("shovel"), KeystoneTools.KEYSTONE_SHOVEL);
        Registry.register(Registry.ITEM, keystoneTool("pickaxe"), KeystoneTools.KEYSTONE_PICKAXE);
        Registry.register(Registry.ITEM, keystoneTool("axe"), KeystoneTools.KEYSTONE_AXE);
        Registry.register(Registry.ITEM, keystoneTool("tiller"), KeystoneTools.KEYSTONE_TILLER);
    }
    public static ToolItem KEYSTONE_SHOVEL = new ShovelItem(new KeystoneToolMaterial(), 1.5F, -3.0F, new Item.Settings().group(zeta.zetaforged.mod.ZetaForged.ZETAFORGED_ITEMS));
    public static ToolItem KEYSTONE_BLADE = new SwordItem(new KeystoneToolMaterial(), 3, -2.4F, new Item.Settings().group(zeta.zetaforged.mod.ZetaForged.ZETAFORGED_ITEMS));
    public static ToolItem KEYSTONE_PICKAXE = new PickaxeItem(new KeystoneToolMaterial(), 1, -2.8F, new Item.Settings().group(zeta.zetaforged.mod.ZetaForged.ZETAFORGED_ITEMS));
    public static ToolItem KEYSTONE_AXE = new AxeItem(new KeystoneToolMaterial(), 7.0F, -3.2F, new Item.Settings().group(zeta.zetaforged.mod.ZetaForged.ZETAFORGED_ITEMS));
    public static ToolItem KEYSTONE_TILLER = new TillerItem(new KeystoneToolMaterial(), 7, -3.2F, new Item.Settings().group(zeta.zetaforged.mod.ZetaForged.ZETAFORGED_ITEMS));
}
