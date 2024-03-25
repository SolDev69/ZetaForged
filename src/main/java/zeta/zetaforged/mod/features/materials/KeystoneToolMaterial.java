package zeta.zetaforged.mod.features.materials;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import zeta.zetaforged.mod.features.keystone.Keystone;

public class KeystoneToolMaterial implements ToolMaterial {
    public int durability = 1920;
    public float miningSpeed = 10.0f;
    public float attackDamage = 3.5f;
    public int miningLevel = 5;
    public int enchantability = 16;
    public Ingredient repairIngredient = Ingredient.ofItems(Keystone.KEYSTONE);
    @Override
    public int getDurability() {
        return durability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return miningLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient;
    }
}
