class Node {
	private Node left, right;
	        int  value;
	private int  height;
	
	Node(int _value) {
		left = null;
		right = null;
		value = _value;
		height = 1;
	}
	
	private static int getHeight(Node n) {
		if (n==null)
			return 0;
		return n.height;
	}
	
	private void fixHeight() {
		height = Math.max(Node.getHeight(left), Node.getHeight(right))+1;
	}
	
	private void setLeft(Node n) {
		left = n;
		fixHeight();
	}
	
	private void setRight(Node n) {
		right = n;
		fixHeight();
	}
	
	void add(int x) {
		assert Math.abs(Node.getHeight(left) - Node.getHeight(right)) <= 1;
		
		if (x <= value)
		{
			if (left == null)
				setLeft(new Node(x));
			else
				left.add(x);
		}
		else
		{
			if (right == null)
				setRight(new Node(x));
			else
				right.add(x);
		}
		final int lmr = Node.getHeight(left) - Node.getHeight(right);
		assert Math.abs(lmr) <= 2;
		if (lmr == 2)
		{
			if (Node.getHeight(left.left) >= Node.getHeight(left.right))
			{
				final Node nodeTmp = right;
				setRight(new Node(value));
				value = left.value;
				right.setLeft(left.right);
				setLeft(left.left);
				right.setRight(nodeTmp);
			}
			else
			{
				final Node nodeTmp = right;
				setRight(new Node(value));
				value = left.right.value;
				right.setRight(nodeTmp);
				right.setLeft(left.right.right);
				left.setRight(left.right.left);
			}
		}
		else if (lmr == -2)
		{
			if (Node.getHeight(right.right) >= Node.getHeight(right.left))
			{
				final Node nodeTmp = left;
				setLeft(new Node(value));
				value = right.value;
				left.setRight(right.left);
				setRight(right.right);
				left.setLeft(nodeTmp);
			}
			else
			{
				final Node nodeTmp = left;
				setLeft(new Node(value));
				value = right.left.value;
				left.setLeft(nodeTmp);
				left.setRight(right.left.left);
				right.setLeft(right.left.right);
			}
		}
		
		fixHeight();
		
		assert Math.abs(Node.getHeight(left) - Node.getHeight(right)) <= 1;
	}
	
	public String toString() {
		String s = "";
		if (left != null)
			s = left.toString() + " ";
		s += String.valueOf(value);
		if (right != null)
			s += " " + right.toString();
		return s;
	}
}

public class AvlTree {
	Node root;
	
	public void add(int x) {
		if (root == null)
			root = new Node(x);
		else
			root.add(x);
	}
	
	public String toString() {
		if (root == null)
			return "[]";
		else
			return "[" + root.toString() + "]";
	}
}