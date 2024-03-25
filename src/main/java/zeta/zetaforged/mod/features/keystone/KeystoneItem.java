package zeta.zetaforged.mod.features.keystone;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class KeystoneItem extends Item {
    public KeystoneItem(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        ItemStack itemStack = playerEntity.getStackInHand(hand);

        itemStack.decrement(1);
        return TypedActionResult.success(itemStack, world.isClient());
        // Fixed concernedtaters in survival
    }

}
