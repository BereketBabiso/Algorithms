package removeNthNodeFromList;

import isPalindromeNumber.PlandromeWithList;
import isPalindromeNumber.PlandromeWithList.ListNode;

/*
 Given a linked list, remove the n-th node from the end of list and return its head.
 Do it with only one pass and space complexity O(1).
 
 Example: 
 Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class Solution {
	
public ListNode head;
	
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
	public void print(ListNode head) {
		ListNode temp = head;
		System.out.print(temp.val);
		while(temp.next!=null) {
			temp=temp.next;
			System.out.print(", "+temp.val);
		}
	}
	
	 public ListNode removeNthFromEnd(ListNode head1,int n) {
		if(head1==null) return null;
		if(head1.next==null && n==1) return null;
		if(n==0) return head1;
		boolean flag = true;
		int count=1;
		ListNode temp = head1;
		ListNode removeNode = head1;
		ListNode pre = head1;
		
		while(flag) {
			if(count<n) {
				temp=temp.next;
				count++;
			}
			else {
				if(count==n && temp.next==null) {
					head1=head1.next;
					flag=false;
					break;
				}
				else if(count==3 && temp.next!=null) {
					count++;
					temp=temp.next;
					removeNode = removeNode.next;
				}
				else if(count>3 && temp.next==null) {
					count++;					
					pre.next=removeNode.next;
					removeNode=null;
					break;
					
				}
				else {
					count++;
					temp=temp.next;
					removeNode = removeNode.next;
					pre = pre.next;					
				}
			}
		}
		return head1;
	    }
	

	// Definition for singly-linked list.
	 public class ListNode {
	     int val;
	     ListNode next;
	    ListNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		
		Solution p = new Solution();
		p.addElement(129);
		p.addElement(22);
		p.addElement(129);
		p.addElement(5);
		p.addElement(7);
		p.print(p.head);
		System.out.println();
		p.print(p.removeNthFromEnd(p.head,0));

	}

}
