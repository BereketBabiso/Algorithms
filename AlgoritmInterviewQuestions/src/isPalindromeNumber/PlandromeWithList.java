package isPalindromeNumber;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PlandromeWithList {
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
	public void print() {
		ListNode temp = head;
		System.out.print(temp.val);
		while(temp.next!=null) {
			temp=temp.next;
			System.out.print(temp.val);
		}
	}
	
public boolean isPalindrome() {
       if(head==null || head.next==null) return true;
       int sign = 1;
       ListNode temp = head;
       int x = head.val;
       if(x<0) {
    	   x=x*-1;
    	   sign=-1*sign;
       }
       int t = x;
       int pw =0;
       int c =0;
       while(t!=0) {
    	   t=t/10;
    	   c++;
       }
       c=c+pw;
       while(temp.next!=null) {
    	   temp = temp.next;
    	   int y = temp.val;
    	   if(y<0) {
    		   y=-1*y;
    		   sign= -1*sign;    		   
    	   }
    	   x=y*(int)Math.pow(10, c) + x;
    	    t = x;
           pw =0;
           c =0;
           while(t!=0) {
        	   t=t/10;
        	   c++;
           }
           c=c+pw;
       }
       if(sign<0) return false;      
       boolean flag = true;
       int i =1;
       
       while(flag) {
    	   c--; 
    	   System.out.println(x);
//    	   if(x==0) return true;
    	   int temp1 = x/(int)Math.pow(10, c);
    	   int temp2 = x%(int)Math.pow(10, i);     	  
    	   if(temp1!=temp2) {
    		   flag=false;
    		   break;
    	   }
    	   x=x%(int)Math.pow(10, c);    	   
    	   int tt = x%(int)Math.pow(10, 1);
   			x=(x - tt)/10;
   			
    	   if(i>=c) break;
    	   c--;
       }
       return flag;
    }

	// Definition for singly-linked list.
	 public class ListNode {
	     int val;
	     ListNode next;
	    ListNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlandromeWithList p = new PlandromeWithList();
		p.addElement(129);
		//p.addElement(22);
		p.addElement(129);
		System.out.println(p.isPalindrome());
		
		
		//This part is for fun ---> how to read class info from the JVMs method area
		//this returns the full qualified name of the methods
		Class c = p.getClass();
		Method[] methods = c.getDeclaredMethods();
		for(Method m : methods) {
			System.out.println(m);
		}
		
		//getting all fields in an array
		Field[] fields = c.getDeclaredFields();
		for(Field f : fields) {
			System.out.println(f);
		}

	}

}
