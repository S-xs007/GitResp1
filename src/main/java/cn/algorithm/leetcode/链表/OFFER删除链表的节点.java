package cn.algorithm.leetcode.链表;

public class OFFER删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode root = head;
        ListNode pre = null;
        while (root!=null){
            if(root.val == val){
                if(pre==null){
                    return root.next;
                }else {
                    pre.next = root.next;
                    return head;
                }
            }
            pre = root;
            root = root.next;
        }
        return head;
    }

}
