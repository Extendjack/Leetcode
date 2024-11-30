


/***
 *
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 思路：
 * 分成K组 每单组按翻转思路翻转，然后连接每组
 *
 *
 *
 *
 * ***/


public class KListNodeRever {
    public ListNode reverseKGroup(ListNode head, int k) {
        int n=0;

        for (ListNode cur=head;cur!=null;cur=cur.next){
            n++;
        }
        ListNode dummyNode=new ListNode(0,head);
        ListNode pre=null;
        ListNode cur=head;
        ListNode p0=dummyNode;

        for(;n>=k;n-=k){
            for (int i=0;i<k;i++){
                ListNode nxt=cur.next;
                cur.next=pre;
                pre=cur;
                cur=nxt;
            }
            ListNode nxt=p0.next;
            p0.next.next=cur;
            p0.next=nxt;
            p0=nxt;


        }
        return dummyNode.next;
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
