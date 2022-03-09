package org.learning.javapractice.leetcode;

public class L_237_DeleteNode {

    public static void main(String[] args) {
        L_237_DeleteNode a = new L_237_DeleteNode();
    }

    public void deleteNode(ListNode node) {
        ListNode temp = node.next;
        node.val = temp.val;
        node.next = temp.next;
        temp.next = null;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {

        val = x;
    }
}