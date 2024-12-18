/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * **/
public class DeleteDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(0,head);
        ListNode cur=dummy;
        while (cur.next!=null&&cur.next.next!=null){
            int val= cur.next.val;
                if(cur.next.next.val==val){
                    while (cur.next!=null&&cur.next.val==val){
                        cur.next=cur.next.next;
                    }
                }else {
                    cur=cur.next;
                }

            }
        return dummy.next;
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
