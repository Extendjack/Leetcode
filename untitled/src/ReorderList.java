public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode mid=getMiddleNode(head);
        ListNode head2=reverListNode(mid);
        while (head2.next!=null){
            ListNode next=head.next;
            ListNode next2=head2.next;
            head.next=head2;
            head2.next=next;
            head=next;
            head2=next2;
        }


    }

    //求出链表中点
    private ListNode getMiddleNode(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    //翻转链表
    private  ListNode reverListNode(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }








    public class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int val){
            this.val=val;
        }
        ListNode(int val ,ListNode next){
            this.val=val;
            this.next=next;
        }
    }



}
