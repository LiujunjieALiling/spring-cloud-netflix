package com.eureka.caseinterview;


import lombok.Data;

public class FindParentAncestor{

    private Node ans;

    public static void main(String[] args) {
        Node root = new Node(1);
        Node nodeLeft = new Node(2);
        Node nodeRight = new Node(3);
        Node nodeLeftLeft = new Node(4);
        Node nodeLeftRight = new Node(5);
        Node nodeLeftLeftLeft = new Node(6);
        Node nodeLeftRightRight = new Node(9);
        root.setLeft(nodeLeft);
        root.setRight(nodeRight);
        nodeLeft.setLeft(nodeLeftLeft);
        nodeLeft.setRight(nodeLeftRight);
        nodeLeftLeft.setLeft(nodeLeftLeftLeft);
        nodeLeftRight.setRight(nodeLeftRightRight);

        FindParentAncestor ancestor = new FindParentAncestor();
        // root , 6, 9
        Node result = ancestor.findParent(root, nodeLeftLeftLeft, nodeLeftRightRight);
        System.out.println(result);
    }

    /**
     * 后序遍历
     *
     * @param currentNode currentNode
     * @param node1 node1
     * @param node2 node2
     * @return true or false
     */
    private boolean find(Node currentNode, Node node1, Node node2) {

        // 叶子节点
        if (currentNode == null) {
            return false;
        }
        // 递归左子树
        int left = find(currentNode.left, node1, node2) ? 1 : 0;

        // 递归右子树
        int right = find(currentNode.right, node1, node2) ? 1 : 0;

        //  当前节点是要查找得其中一个
        int mid = (currentNode == node1 || currentNode == node2) ? 1 : 0;

        // 只要其中两个标志位true，即算找到
        if (mid + left + right >= 2)
            this.ans = currentNode;

        // 左、右、当前相同则为+1.
        return (mid + left + right > 0);
    }

    public Node findParent(Node root, Node node1, Node node2) {

        this.find(root, node1, node2);

        return this.ans;
    }

}

@Data
class Node {
    public Object data; // 数据
    public Node left; // 左节点
    public Node right; // 右节点

    public Node(Object data) {
        this.data = data;
    }

}