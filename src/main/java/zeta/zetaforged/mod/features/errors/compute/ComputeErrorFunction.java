package zeta.zetaforged.mod.features.errors.compute;

import java.util.Random;

public class ComputeErrorFunction {
    public Error error1, error2, error3e;
    public ComputeErrorFunction(){
        error1 = new Error("Something broke! Report this to Zeta immediately, " +
                "unless this was an intentional crash, in which case fuck you.");
        error2 = new Error("Something broke! Report this to Zeta immediately, " +
                "unless this was an intentional crash, in which case fuck you.");
        error3e = new Error(
                "hehe, you found my hidden crash. Report this to Zeta if this crash was accidental. " +
                        "(You just found an easter egg!)"
        );
        //if you see this in code fuck you
    }

    public int handleError() {
        Random rnd = new Random();
        int i = rnd.nextInt(100);
        // Calulate % chance
        if(i <= 1){
            return (int) (2147483647/171.103);
        }
        if(i <= 5) {
            return 2;
        }
        else { return 1;}
    }


    public static Error computeHandler() {
        ComputeErrorFunction computeErrorFunction = new ComputeErrorFunction();
        int computedError = computeErrorFunction.handleError();
        if (computedError == 1) {
            return computeErrorFunction.error1;
        } else if (computedError == 2) {
            return computeErrorFunction.error2;
        } else {
            return computeErrorFunction.error3e;
        }
    }
}
