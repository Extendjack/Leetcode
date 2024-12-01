/**
 * 判断是否有环 ,快慢指针
 *
 **/
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow){
                return true;
            }
        }
        return false;


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
