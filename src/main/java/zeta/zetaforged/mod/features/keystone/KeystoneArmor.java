package zeta.zetaforged.mod.features.keystone;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import zeta.zetaforged.mod.ZetaForged;
import zeta.zetaforged.mod.features.materials.KeystoneArmorMaterial;


public class KeystoneArmor {
    public static final ArmorMaterial CUSTOM_ARMOR_MATERIAL = new KeystoneArmorMaterial();
    public static final Item KEYSTONE_HELMET = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(ZetaForged.ZETAFORGED_ITEMS));
    public static final Item KEYSTONE_CHESTPLATE = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(ZetaForged.ZETAFORGED_ITEMS));
    public static final Item KEYSTONE_LEGGINGS = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(ZetaForged.ZETAFORGED_ITEMS));
    public static final Item KEYSTONE_BOOTS = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(ZetaForged.ZETAFORGED_ITEMS));

    public static void register() {
        //Registry.register(Registry.ITEM, new Identifier(ZetaForged.MOD_ID, KEYSTONE"), KEYSTONE);
        Registry.register(Registry.ITEM, new Identifier(ZetaForged.MOD_ID, "keystone_helmet"), KEYSTONE_HELMET);
        Registry.register(Registry.ITEM, new Identifier(ZetaForged.MOD_ID, "keystone_chestplate"), KEYSTONE_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(ZetaForged.MOD_ID, "keystone_leggings"), KEYSTONE_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(ZetaForged.MOD_ID, "keystone_boots"), KEYSTONE_BOOTS);
    }
}

