import java.util.Stack;

/**
 * Created by Administrator on 2016/6/15.
 */
public class PopOrder {
    public static boolean IsPopOrder(int[] pushA,int[] popA) {
        boolean bPossible = false;
        Stack<Integer> stack = new Stack<>();

        if(pushA.length!=0&&popA.length!=0) {
            int pPush = 0;
            int pPop = 0;
            while (pPop < popA.length) {
                while (stack.isEmpty() || stack.peek() != popA[pPop]) {
                    if (pPush < 0)
                        break;
                    stack.push(pushA[pPush]);
                    pPush++;
                }

                if (stack.peek() != popA[pPop])
                    break;
                stack.pop();
                pPop++;
            }
            if (stack.isEmpty() && pPop == popA.length)
                bPossible = true;
        }
        return bPossible;
    }
    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {3,5,4,2,1};
        boolean b = IsPopOrder(pushA,popA);
        System.out.println(b);
    }
}
