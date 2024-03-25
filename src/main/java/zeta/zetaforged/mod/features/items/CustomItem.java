package zeta.zetaforged.mod.features.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CustomItem extends Item {
    public CustomItem(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        ItemStack itemStack = playerEntity.getStackInHand(hand);
        itemStack.decrement(1);
        //playerEntity.moveToWorld((ServerWorld) new Identifier("modid","dimensionname"));
        return TypedActionResult.success(itemStack, world.isClient());
        // Fixed concernedtaters in survival
    }

}
