package sLList;

public class SLList {
	/**Nested class.*/
	private static class IntNode {
		public int item;
		public IntNode next;
		public IntNode(int i, IntNode n) {
			item = i;
			next = n;
		}
	}
	
	private IntNode first;
	
	public SLList(int x) {
		first = new IntNode(x, null);
	}
	
	public static void main(String[] args) {
		SLList L = new SLList(10);
		L.addFirst(5);
		L.addFirst(15);
		int size = L.size();
		System.out.println(size);
	}
	
	public void addFirst(int i) {
		first = new IntNode(i, first);
	}
	
	public int getFirst() {
		return first.item;
	}
	/**Add an integer to the end of the list.*/
	public void addLast(int i) {
		IntNode p = first;
		while (p.next != null) {
			p = p.next;
		}
		p.next = new IntNode(i, null);
	}
//	/**Return size by using iteration.*/
//	public int size() {
//		IntNode p = first;
//		int s = 1;
//		if (p.next == null) {
//			return 1;
//		}
//		while (p.next != null) {
//			s += 1;
//			p = p.next;
//		}
//		return s;
//	}
	/**Return size of a SLList started from IntNode p using recursion.*/
	private static int getSize(IntNode p) {
		if (p.next == null) {
			return 1;
		}
		return getSize(p.next) + 1;
	}
	public int size() {
		return getSize(first);
	}
}

