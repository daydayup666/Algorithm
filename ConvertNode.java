package com.company;

public class ConvertNode {
    public TreeNode convert(TreeNode pRootOfTree) {
        TreeNode pLastNodeInList = null;

        pLastNodeInList = convertNode(pRootOfTree, pLastNodeInList);
        //pLastNodeInList指向双向链表的尾结点
        //我们需要返回头结点
        TreeNode pHeadOfList = pLastNodeInList;
        while (pHeadOfList != null && pHeadOfList.left != null)
            pHeadOfList = pHeadOfList.left;

        return pHeadOfList;
    }

    public TreeNode convertNode(TreeNode pNode,
                            TreeNode pLastNodeInList) {
        if (pNode == null) return null;
        //pCurrent指向当前结点
        TreeNode pCurrent = pNode;
        //如果左孩子不空，那么递归左子树
        if (pCurrent.left != null) {
           pLastNodeInList = convertNode(pCurrent.left, pLastNodeInList);
        }
        //当前结点指向左子树中序遍历的最后一个结点
        pCurrent.left = pLastNodeInList;
        if (pLastNodeInList != null) {
            pLastNodeInList.right = pCurrent;
        }
        //pLastNodeInList表示双向链表的尾结点
        pLastNodeInList = pCurrent;
        if (pCurrent.right != null)
            pLastNodeInList = convertNode(pCurrent.right, pLastNodeInList);
        return pLastNodeInList;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(14);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(12);
        TreeNode node7 = new TreeNode(16);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        ConvertNode c = new ConvertNode();
        TreeNode head = c.convert(node1);
        TreeNode node = head;
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.right;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

