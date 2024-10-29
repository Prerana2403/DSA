package hw;

public class Doubly {
	class Node{
		int data;
		int head;
		int prev;
		int next;
		
		Node(int data){
			this.data = data;
			
		}
		
		public void addFirst() {
			Node n = new Node(data);
			if(head==null) {
				head = n;
				n.next = head;
			}
		}
		
		
	}
	
	public static void main(String[]args) {
		Doubly D = new Doubly();
	}

}
