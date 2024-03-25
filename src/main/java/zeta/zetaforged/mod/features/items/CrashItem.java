package zeta.zetaforged.mod.features.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import zeta.zetaforged.mod.features.errors.compute.ComputeErrorFunction;


public class CrashItem extends Item {
    public CrashItem(Settings settings) {
        super(settings);
    }


    private static Error error1 = new Error("You crashed the game! Oh noes!");
    private static final  Error error2 = new Error("You pulled a shitass and crashed the game");
    /**
     * @author ZetaTheEliatrope
     * @reason Why not?
     */
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        ItemStack itemStack = playerEntity.getStackInHand(hand);
        itemStack.decrement(1);
        throw computeHandler();
    }

    public static Error computeHandler() {
        ComputeErrorFunction computeErrorFunction = new ComputeErrorFunction();
        int computedError = computeErrorFunction.handleError();
        if (computedError == 1) {
            return error1;
        } else if (computedError == 2) {
            return error2;
        } else {
            return computeErrorFunction.error3e;
        }
    }

}
