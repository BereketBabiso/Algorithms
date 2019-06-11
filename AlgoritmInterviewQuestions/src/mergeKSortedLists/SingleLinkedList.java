package mergeKSortedLists;

public class SingleLinkedList {
	ListNode head;
	
	public void addElement(int v) {
		if(head==null) {
			head = new ListNode(v);
		}
		else {
			ListNode temp = head;
			while(temp.next!=null) {
				temp = temp.next;
			}
			temp.next= new ListNode(v);
		}
	}
	
	public void print(ListNode temp) {		
		System.out.print(temp.val);
		while(temp.next!=null) {
			temp=temp.next;
			System.out.print("->"+temp.val);
		}
	}
	
	public ListNode getListNode() {
		return this.head;
	}
}
