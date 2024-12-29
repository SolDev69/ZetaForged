package dev.solcraft.soltweaks.features.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import dev.solcraft.soltweaks.SolTweaks;
import dev.solcraft.soltweaks.features.blocks.VoidBlock;

public class RegisterVoidItems {
    public RegisterVoidItems(){}
    public static Block VoidBlock_BLOCK;
    public static BlockItem VoidBlock_ITEM;
    public void registerItems() {
        // Register keystone item
        //Keystone keystone = new Keystone();
        VoidBlock_BLOCK = Registry.register(Registry.BLOCK, id("void"), new VoidBlock());
        VoidBlock_ITEM = Registry.register(Registry.ITEM, id("void"),
                new BlockItem(VoidBlock_BLOCK, new Item.Settings().group(SolTweaks.SOLTWEAKS_ITEMS)));
                // CODE DEF NOT RIPPED FROM A DUMMY MCREATOR MOD



    }
    protected static final Identifier id(String s) {
        return new Identifier(SolTweaks.MOD_ID, s);
    }
    public static final Identifier keystoneTool(String s) {return new Identifier(SolTweaks.MOD_ID, "keystone_"+s);}
}
