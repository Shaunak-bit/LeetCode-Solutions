/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;

        if(head == null){
            return null;
        }
        while(cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        ListNode temp = stack.pop();
        int max = temp.val;

        while(!stack.isEmpty()){
            ListNode temp2 = stack.pop();

            if(temp2.val<max){
                continue;
            }else{
                temp2.next = temp;
                temp = temp2;
                max = temp.val;
            }
        }
        return temp;
    }
}