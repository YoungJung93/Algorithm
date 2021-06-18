package Problem;

import java.util.Arrays;

public class Solution_힙_이중우선순위큐 {
	static class DoublyPriorityQueue {
		class Node {
			int data;
			Node preNode;
			Node nextNode;
			public Node(int data) {
				this.data = data;
				this.preNode = null;
				this.nextNode = null;
			}
		}
		private Node head, tail;
		private int size;
		public DoublyPriorityQueue() {
			this.size=0;
			this.head = null;
			this.tail = null;
		}
		public void offer(int data) {
			Node newNode = new Node(data);
			if(size==0) {
				head = newNode;
				tail = newNode;
			} else {
				Node find = head;
				while(find != null) {
					if(find.data <= newNode.data) find = find.nextNode;
					else break;
				}
				if(find == null) {
					this.tail.nextNode = newNode;
					newNode.preNode = this.tail;
					this.tail = newNode;
				} else if(find == this.head) {
					find.preNode = newNode;
					newNode.nextNode = find;
					this.head = newNode;
				} else {
					find.preNode.nextNode = newNode;
					newNode.preNode = find.preNode;
					newNode.nextNode = find;
					find.preNode = newNode;
				}
			}
			this.size++;
		}
		public int poll_max() {
			int res = Integer.MIN_VALUE;
			if(this.size==1) {
				this.size--;
				res = this.head.data;
				this.head = null;
				this.tail = null;
			} else if(this.size!=0) {
				this.size--;
				res = this.tail.data;
				this.tail = this.tail.preNode;
				this.tail.nextNode = null;
			}
			return res;
		}
		public int poll_min() {
			int res = Integer.MAX_VALUE;
			if(this.size==1) {
				this.size--;
				res = this.head.data;
				this.head = null;
				this.tail = null;
			} else if(this.size!=0) {
				this.size--;
				res = this.head.data;
				this.head = this.head.nextNode;
				this.head.preNode = null;
			}
			return res;
		}
		public int size() {
			return this.size;
		}
	}
	static String[] operations;
	static int[] answer;
	public static void main(String[] args) {
		operations = new String[] {
				"I 16", "D 1"
//				"I 7", "I 5", "I -5", "D -1"
		};
		answer = new int[2];
		
		DoublyPriorityQueue dpq = new DoublyPriorityQueue();
		
		int len = operations.length;
		for(int i=0; i<len; i++) {
			String com = operations[i];
			if(com.split(" ")[0].equals("I")) {
				int a = Integer.parseInt(com.split(" ")[1]);
				dpq.offer(a);
			} else {
				if(com.split(" ")[1].equals("1")) {
					dpq.poll_max();
				} else {
					dpq.poll_min();
				}
			}
		}
		if(dpq.size==0) {
			answer[0]=0; answer[1]=0;
		} else if(dpq.size==1) {
			int a = dpq.poll_max();
			answer[0]=a; answer[1]=a;
		} else {
			answer[0] = dpq.poll_max();
			answer[1] = dpq.poll_min();
		}
		
		System.out.println(Arrays.toString(answer));
	}
}
