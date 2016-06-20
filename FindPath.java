package tao;

import java.util.ArrayList;

public class FindPath {
    ArrayList<ArrayList<Integer>> path = new ArrayList<>();
    ArrayList<Integer> subPath = new ArrayList<>();
    int currentSum = 0;
    
    public  ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root==null) return null;
        
        currentSum += root.val;
        subPath.add(root.val);
        
        boolean isLeaf = (root.left==null&&root.right==null);
        if(currentSum==target&&isLeaf) {
            ArrayList<Integer> p = new ArrayList<>();
            p.addAll(subPath);
            path.add(p);
        }
        if(root.left!= null) {
            FindPath(root.left,target);
        }
        if(root.right!=null) {
            FindPath(root.right,target);
        }
        subPath.remove(subPath.indexOf(root.val));
        currentSum -= root.val;
        return path;
    }
    public static void main(String[] args) {
    	FindPath f = new FindPath();
 	   TreeNode node1 = new  TreeNode(10);
 	   TreeNode node2 = new  TreeNode(5); 
 	   TreeNode node3 = new  TreeNode(12);
 	   TreeNode node4 = new  TreeNode(4);
 	   TreeNode node5 = new  TreeNode(7);
 	   node1.left=node2;
 	   node1.right = node3;
 	   node2.left=node4;
 	   node2.right=node5;
 	   System.out.println(f.FindPath(node1,22));
    }
}
