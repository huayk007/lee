package lee;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *  keypoint: 1.关键点是构造 head tail 两个对象  2.tem = value / 10;  3 if (tem > 0) tail.next = new ListNode(tem); 添加个位数
 *
 *
 */
public class Lee2 {
    /**
     * definition for singly-linked list.
     * public class listnode {
     *     int val;
     *     listnode next;
     *     listnode() {}
     *     listnode(int val) { this.val = val; }
     *     listnode(int val, listnode next) { this.val = val; this.next = next; }
     * }
     */

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int tem = 0;
        while (l1 != null || l2 != null){
            ListNode tempNode = new ListNode();
            int value = (l1 == null?0:l1.val) + (l2 == null?0:l2.val) + tem;
            tem = 0;
            tempNode.val = value % 10;
            tem = value / 10;
            if(head == null){
                head = tail = tempNode;
            }else {
                tail.next = new ListNode(value % 10);
                tail = tail.next;
            }
            l1 = l1 != null ? l1.next:null;
            l2 = l2 != null ? l2.next:null;
        }
        if (tem > 0) {
            tail.next = new ListNode(tem);
        }
        return head;
    }

    public static void main(String[] args) {
        Lee2 lee2 = new Lee2();
        ListNode listNode = new ListNode(6,new ListNode(9));
        ListNode l2 = new ListNode(5);
        ListNode result = lee2.addTwoNumbers(l2,listNode);
        System.out.println(result);
    }
}
