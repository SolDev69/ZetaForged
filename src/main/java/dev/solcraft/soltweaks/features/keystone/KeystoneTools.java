package dev.solcraft.soltweaks.features.keystone;

import dev.solcraft.soltweaks.SolTweaks;
import net.minecraft.item.*;
import net.minecraft.util.registry.Registry;
import dev.solcraft.soltweaks.features.materials.KeystoneToolMaterial;
import dev.solcraft.soltweaks.features.items.tools.wideners.AxeItem;
import dev.solcraft.soltweaks.features.items.tools.wideners.PickaxeItem;
import dev.solcraft.soltweaks.features.items.tools.wideners.TillerItem;

import static dev.solcraft.soltweaks.features.items.RegisterVoidItems.keystoneTool;

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
    public static ToolItem KEYSTONE_SHOVEL = new ShovelItem(new KeystoneToolMaterial(), 1.5F, -3.0F, new Item.Settings().group(SolTweaks.SOLTWEAKS_ITEMS));
    public static ToolItem KEYSTONE_BLADE = new SwordItem(new KeystoneToolMaterial(), 3, -2.4F, new Item.Settings().group(SolTweaks.SOLTWEAKS_ITEMS));
    public static ToolItem KEYSTONE_PICKAXE = new PickaxeItem(new KeystoneToolMaterial(), 1, -2.8F, new Item.Settings().group(SolTweaks.SOLTWEAKS_ITEMS));
    public static ToolItem KEYSTONE_AXE = new AxeItem(new KeystoneToolMaterial(), 7.0F, -3.2F, new Item.Settings().group(SolTweaks.SOLTWEAKS_ITEMS));
    public static ToolItem KEYSTONE_TILLER = new TillerItem(new KeystoneToolMaterial(), 7, -3.2F, new Item.Settings().group(SolTweaks.SOLTWEAKS_ITEMS));
}
