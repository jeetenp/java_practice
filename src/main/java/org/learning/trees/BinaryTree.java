package org.learning.trees;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BinaryTree {
    int index = -1;

    public Node buildTree(int[] nodes) {
        index++;
        if (nodes[index] == -1) {
            return null;
        }
        Node node = new Node(nodes[index]);
        node.setLeft(buildTree(nodes));
        node.setRight(buildTree(nodes));
        return node;
    }

    //Root -> Left -> Right
    public void preOrder(Node root) {
        if (root == null) {
            System.out.print("-1 ");
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    //Left -> Root -> Right
    public void inOrder(Node root) {
        if (root == null) {
            System.out.print("-1 ");
            return;
        }
        preOrder(root.getLeft());
        System.out.print(root.data + " ");
        preOrder(root.getRight());
    }

    //Left -> Right -> Root
    public void postOrder(Node root) {
        if (root == null) {
            System.out.print("-1 ");
            return;
        }
        preOrder(root.getLeft());
        preOrder(root.getRight());
        System.out.print(root.data + " ");
    }

    public void levelOrder(Node root) {
        if (root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node == null) {
                System.out.println(" ");
                if (queue.isEmpty()) {
                    return;
                } else {
                    queue.add(null);
                }
            } else {
                System.out.print(node.data + " ");
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }

        }

    }

    public int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftCount = countNodes(root.getLeft());
        int rightCount = countNodes(root.getRight());
        return leftCount + rightCount + 1;
    }

    public int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumOfNodes(root.getLeft());
        int rightSum = sumOfNodes(root.getRight());
        return leftSum + rightSum + root.getData();
    }
    public int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        int heightOfLeftTree = heightOfTree(root.getLeft());
        int heightOfRightTree = heightOfTree(root.getRight());
        return Math.max(heightOfLeftTree, heightOfRightTree) + 1;
    }

    public int diameterOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        int heightOfLeftTree = heightOfTree(root.getLeft());
        int heightOfRightTree = heightOfTree(root.getRight());
        return Math.max(heightOfLeftTree, heightOfRightTree) + 1;
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        System.out.println("\n--PreOrder");
        tree.preOrder(root);
        System.out.println("\n--InOrder");
        tree.inOrder(root);
        System.out.println("\n--PostOrder");
        tree.postOrder(root);
        System.out.println("\n--levelOrder");
        tree.levelOrder(root);
        System.out.println("\n--Count Nodes");
        System.out.println(tree.countNodes(root));
        System.out.println("\n--Sum Nodes");
        System.out.println(tree.sumOfNodes(root));
        System.out.println("\n--Height of Tree");
        System.out.println(tree.heightOfTree(root));
        System.out.println("\n--Diameter of Tree");
        System.out.println(tree.diameterOfTree(root));
    }
}
