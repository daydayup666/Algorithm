import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class PrintBinaryTree {
    public static ArrayList<Integer> printBinaryTreeNode(TreeNode root) {
        if(root==null) {
            return null;
        }
        ArrayList<Integer> list= new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left!=null) {
                queue.offer(node.left);
            }
            if(node.right!=null) {
                queue.offer(node.right);
            }

        }
        return list;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}