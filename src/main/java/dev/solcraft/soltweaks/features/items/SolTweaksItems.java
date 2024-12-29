package dev.solcraft.soltweaks.features.items;

import dev.solcraft.soltweaks.SolTweaks;
import dev.solcraft.soltweaks.features.blocks.VoidBlock;
import dev.solcraft.soltweaks.features.items.keystone.KeystoneArmor;
import dev.solcraft.soltweaks.features.items.tools.wideners.AxeItem;
import dev.solcraft.soltweaks.features.items.tools.wideners.TillerItem;
import dev.solcraft.soltweaks.features.materials.KeystoneArmorMaterial;
import dev.solcraft.soltweaks.features.materials.KeystoneToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Locale;

public class SolTweaksItems {
    public static Item KEYSTONE = Registry.register(Registry.ITEM, new Identifier(SolTweaks.MOD_ID,
            "KEYSTONE".toLowerCase(Locale.ROOT)
    ), new KeystoneItem(new FabricItemSettings().group(SolTweaks.SOLTWEAKS_ITEMS)));
    public static Block KEYSTONE_BLOCK = new Block(FabricBlockSettings.of(Material.AMETHYST).strength(9.0f));
    public static Block VoidBlock_BLOCK = Registry.register(Registry.BLOCK, id("void"), new VoidBlock());
    public static BlockItem VoidBlock_ITEM = Registry.register(Registry.ITEM, id("void"),
                new BlockItem(VoidBlock_BLOCK, new Item.Settings().group(SolTweaks.SOLTWEAKS_ITEMS)));

    protected static Identifier id(String s) {
        return new Identifier(SolTweaks.MOD_ID, s);
    }

    public static ToolItem KEYSTONE_SHOVEL = new ShovelItem(new KeystoneToolMaterial(), 1.5F, -3.0F, new Item.Settings().group(SolTweaks.SOLTWEAKS_ITEMS));
    public static ToolItem KEYSTONE_BLADE = new SwordItem(new KeystoneToolMaterial(), 3, -2.4F, new Item.Settings().group(SolTweaks.SOLTWEAKS_ITEMS));
    public static ToolItem KEYSTONE_PICKAXE = new dev.solcraft.soltweaks.features.items.tools.wideners.PickaxeItem(new KeystoneToolMaterial(), 1, -2.8F, new Item.Settings().group(SolTweaks.SOLTWEAKS_ITEMS));
    public static ToolItem KEYSTONE_AXE = new AxeItem(new KeystoneToolMaterial(), 7.0F, -3.2F, new Item.Settings().group(SolTweaks.SOLTWEAKS_ITEMS));
    public static ToolItem KEYSTONE_TILLER = new TillerItem(new KeystoneToolMaterial(), 7, -3.2F, new Item.Settings().group(SolTweaks.SOLTWEAKS_ITEMS));

    public static final ArmorMaterial CUSTOM_ARMOR_MATERIAL = new KeystoneArmorMaterial();
    public static final Item KEYSTONE_HELMET = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(SolTweaks.SOLTWEAKS_ITEMS));
    public static final Item KEYSTONE_CHESTPLATE = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(SolTweaks.SOLTWEAKS_ITEMS));
    public static final Item KEYSTONE_LEGGINGS = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(SolTweaks.SOLTWEAKS_ITEMS));
    public static final Item KEYSTONE_BOOTS = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(SolTweaks.SOLTWEAKS_ITEMS));


    public static Identifier keystoneTool(String s) {
        return new Identifier(SolTweaks.MOD_ID, "keystone_"+s);
    }
    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier(SolTweaks.MOD_ID, "keystone_block"), KEYSTONE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(SolTweaks.MOD_ID, "keystone_block"), new BlockItem(KEYSTONE_BLOCK,
                new FabricItemSettings().group(SolTweaks.SOLTWEAKS_ITEMS)));

        Registry.register(Registry.ITEM, new Identifier(SolTweaks.MOD_ID, "keystone_helmet"), KEYSTONE_HELMET);
        Registry.register(Registry.ITEM, new Identifier(SolTweaks.MOD_ID, "keystone_chestplate"), KEYSTONE_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(SolTweaks.MOD_ID, "keystone_leggings"), KEYSTONE_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(SolTweaks.MOD_ID, "keystone_boots"), KEYSTONE_BOOTS);

        Registry.register(Registry.ITEM, keystoneTool("sword"), KEYSTONE_BLADE);
        Registry.register(Registry.ITEM, keystoneTool("shovel"), KEYSTONE_SHOVEL);
        Registry.register(Registry.ITEM, keystoneTool("pickaxe"), KEYSTONE_PICKAXE);
        Registry.register(Registry.ITEM, keystoneTool("axe"), KEYSTONE_AXE);
        Registry.register(Registry.ITEM, keystoneTool("tiller"), KEYSTONE_TILLER);
    }

}
