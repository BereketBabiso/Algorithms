
public class Sum {
	Node node;
	
	public void insert(int v) {
		if(node==null) {
			node = new Node(v);
		}
		else {
			Node temp = new Node(v);
			Node t = node;
			while(t.next!=null) {
				t=t.next;
			}
			t.next=temp;
		}
	}
	void print() {
		Node t = node;
		while(t.next!=null) {
			System.out.print(t.val+", ");
			t=t.next;
		}
		System.out.print(t.val);
	}
	
	public Node addTwoNumbers(Node l1, Node l2) {
        int x = l1.val + l2.val;
        int carry =0;
        Node ret;
        if(x<10){
            ret = new Node(x);
        }
        else{
            ret = new Node(x%10);
            carry = x/10;
        }
        Node t = ret;
        
        while(l1.next!=null && l2.next!=null){
            l1 = l1.next;
            l2 = l2.next;
            x = l1.val + l2.val + carry;
            if(x<10){
            	Node temp = new Node(x);
                t.next = temp;
                t=t.next;
                carry = 0;
            }
            else{
            	Node temp = new Node(x%10);
                t.next = temp;
                t=t.next;
                carry = x/10;
            }
        }
        if(carry!=0) {
        	Node temp = new Node(carry);
            t.next = temp;
        }
        return ret;
    }
	
	
	public class Node{
		int val;
		Node next;
		
		Node(int val){
			this.val = val;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sum s = new Sum();
		s.insert(1);
		s.insert(2);
		s.insert(3);
		s.print();

	}

}
