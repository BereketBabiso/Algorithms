package reverse_linked_list_inplace;

public class ReverseLinkedList {

	public ListNode head;
	
	public int size() {
		ListNode temp = head;
		int count = 1;
		if(head==null) return 0;
		while(temp.next !=null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	public void addElement(int v) {
		if (head == null) {
			head = new ListNode(v);
		} else {
			ListNode temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new ListNode(v);
		}
	}

	public void print(ListNode head) {
		ListNode temp = head;
		System.out.print(temp.val);
		while (temp.next != null) {
			temp = temp.next;
			System.out.print(", " + temp.val);
		}
	}

	public void reverse() {
		long startTime = System.currentTimeMillis();
		int size = 1;
		ListNode temp = head;
		int val1 = head.val;
		while(temp.next !=null) {
			size++;
			temp=temp.next;
		}
		int x = temp.val;
		temp.val = val1;
		val1 = x;
		int start = 2;
		int end = size -1;
		int count = 0;
		while(start<=end) {
			count=1;
			temp = head;
			while(temp.next!=null) {
				if(count+1==start) temp.val = val1;
				temp=temp.next;
				count++;
				if(count==start) val1 = temp.val;
				if(count==end) {
					x=temp.val;
					temp.val = val1;
					val1 = x;
					break;
				}
			}
			start++;
			end--;
		}
		if(size%2==0 && size>1) {
			count=1;
			temp = head;
			while(count!=(size/2)) {
				temp = temp.next;
				count++;
			}
			temp.val = val1;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("time taken to reverse : "+ (endTime - startTime)+"ms");

	}
	
	
	
	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		ReverseLinkedList p = new ReverseLinkedList();

		for(int i= 1; i<10001 ; i++) {
			p.addElement(i);
		}
		p.print(p.head);
		System.out.println("   size : "+p.size());
		p.reverse();
		p.print(p.head);

	}

}
