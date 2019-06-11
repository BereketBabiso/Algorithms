package mergeKSortedLists;

/*
  Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
  
  Example: 
  Input:
		[
		  1->4->5,
		  1->3->4,
		  2->6
		]
		Output: 1->1->2->3->4->4->5->6
 */

public class MergeKSortedList {
	
	 public ListNode mergeKLists(ListNode[] lists) {
	        if(lists.length==0) return null;
	        ListNode res = null;      
	        int n = lists.length;
	        int pos=0;
	        int value = 0;
	        boolean flag = true;
	        int count=0;
	        while(flag){
	            count=0;
	            for(int i=0;i<n;i++){
	                if(lists[i]!=null){
	                    value=lists[i].val;
	                    pos=i;
	                    break;
	                }
	                else count++;
	            }
	            if(count==n) break;
	            for(int i=0;i<n;i++){
	                if(lists[i]!=null){
	                    if(lists[i].val<value){
	                        value=lists[i].val;
	                        pos=i;
	                    }
	                }
	            }
	            if(res==null){
	                res = new ListNode(value);               
	            }
	            else {
	                ListNode nNode = new ListNode(value);
	                ListNode t = res;
	                while(t.next!=null){
	                    t=t.next;
	                }
	                t.next=nNode;
	            }
	            lists[pos] = lists[pos].next;
	        }
	       return res;
	    }

	public static void main(String[] args) {
		
		SingleLinkedList list1 = new SingleLinkedList();
		list1.addElement(1);
		list1.addElement(4);
		list1.addElement(5);
		ListNode node1 = list1.getListNode();
		
		SingleLinkedList list2 = new SingleLinkedList();
		list2.addElement(1);
		list2.addElement(3);
		list2.addElement(4);
		ListNode node2 = list2.getListNode();
		
		SingleLinkedList list3 = new SingleLinkedList();
		list3.addElement(2);
		list3.addElement(6);
		ListNode node3 = list3.getListNode();
		
		ListNode[] lists = {node1,node2,node3};
		
		MergeKSortedList mslist = new MergeKSortedList();
		ListNode result = mslist.mergeKLists(lists);
		
		list1.print(result);

	}

}
