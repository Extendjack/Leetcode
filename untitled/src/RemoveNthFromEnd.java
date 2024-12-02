/**
 * 利用前后指针求出
 *，在不知道链表长度的前提下，设计一个算法，在「到达链表末尾的瞬间」就能知道倒数第 n 个节点。
 *
 * **/

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0,head);
        ListNode left=dummy;
        ListNode right=dummy;
        while (n-->0){
            right=right.next;
        }
        while (right.next!=null){
            left=left.next;
            right=right.next;
        }
        //TODO 【1,2】 n=1的场景
        //left.next=right;
        left.next=left.next.next;
        return  dummy;

    }



    public class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int val){
            this.val=val;
        }
        ListNode(int val , ListNode next){
            this.val=val;
            this.next=next;
        }
    }
}
