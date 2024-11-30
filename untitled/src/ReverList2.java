public class ReverList2 {

   /***
    *
    *
    * 在一定范围内链表翻转
    *
    * **/

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode duyNode=new ListNode(0,head);
        ListNode p0=duyNode;
        for(int i=0;i<left-1;i++){
           p0=p0.next;
        }
        ListNode cur=p0.next;
        ListNode pre=null;
        for (int i=0;i<=right-left+1;i++){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        p0.next.next=cur;
        p0.next=pre;
        return duyNode.next;
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
