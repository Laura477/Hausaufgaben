package algorithmen;

/** ein binaerer Suchbaum mit ganzen Zahlen als Datensatz */
public class BinarySearchTree {

	/** Die Knotenklasse als statische innere Klasse. */
	public static class TreeNode {
		public int value;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int value) {
			this.value = value;
		}

		public String toString() {
			return this.value + " ";
		}

		public int getValue() {
		  return this.value;
		}

		public TreeNode getLeft() {
		  return this.left;
		}

		public TreeNode getRight() {
		  return this.right;
		}

		public void setValue(int value) {
		  this.value = value;
		}

		public void setLeft(TreeNode node) {
		  this.left = node;
		}

		public void setRight(TreeNode node) {
		  this.right= node;
		}
	}

	private TreeNode root;

	/**
	 * Herausfinden, ob ein gewisser Datensatz schon im binaeren Suchbaum enthalten
	 * ist.
	 *
	 * @param data zu suchender Datensatz
	 * @return true: Datensatz ist vorhanden; false: Datensatz ist nicht vorhanden.
	 */
	public boolean contains(int data) {
		TreeNode temp = root;
		while (temp != null) {
			if (temp.value == data) {
				return true;
			}
			if (temp.value > data) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		return false;
	}

	/**
	 * Einen neuen Datensatz in den binaeren Suchbaum einfuegen.
	 *
	 * @param data einzufuegender Datensatz
	 * @return true: Datensatz wurde eingefuegt; false: Datensatz war schon
	 *         vorhanden.
	 */
	public boolean insert(int data) {
		if (root == null) {
			root = new TreeNode(data);
			return true;
		}

		TreeNode temp = root;
		while (temp.value != data) {
			if (temp.value > data) {
				if (temp.left == null) {
					temp.left = new TreeNode(data);
					return true;
				}
				temp = temp.left;
			} else {
				if (temp.right == null) {
					temp.right = new TreeNode(data);
					return true;
				}
				temp = temp.right;
			}
		}
		return false;
	}

	public String toString() {
		return toString(root);
	}

	// A1
	private String toString(TreeNode node) {
		if (node == null) {
			return "";
		}
		if (node.left==null && node.right==null) {
			return ""+node.value;
		}
		else if (node.left == null) {
			return node.value + ", " + toString(node.right);
		}
		else if (node.right == null) {
			return toString(node.left) + ", " + node.value;
		} else {
			return toString(node.left) + ", " + node.value + ", " + toString(node.right);
		}

	}
	
	public int getSum() {
		return getSum(root);
	}
	
	private int getSum(TreeNode node) {
		if (node==null) {
			return 0;
		}
		return getSum(node.left)+ getSum(node.right)+ node.value; 
	}
	
	public int getElementCount() {
		return getElementCount(root);
	}
	
	private int getElementCount(TreeNode node) {
		if (node==null) {
			return 0;
		}
		return getElementCount(node.left)+getElementCount(node.right)+1;
	}
	
	public int getHeight() {
		return getHeight(root)-1;
	}
	
	public int getHeight(TreeNode node) {
		if (node==null) {
			return -1;
		}
		int count = 0;
		if (node.left!=null || node.right!=null) {
			count++;
		}
		return count+Math.max(getHeight(node.left), getHeight(node.right));
	}
	
//	public int getLeafCount() {
//		return getLeafCount(root);
//	}
//	
//	private int getLeafCount(TreeNode node) {
//		if (node==null) {
//			return 0;
//		}
//		int 
//	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		for (int i = 0; i < 20; i++) {
			int x = (int) (Math.random() * 50);
			System.out.println(x);
			tree.insert(x);
		}
		for (int i = 0; i < 50; i++) {
			System.out.println(i + ": " + tree.contains(i));
		}

		// test toString
		System.out.println(tree.toString());
		//test getSum
		System.out.println(tree.getSum());
		//test getElementCount
		System.out.println(tree.getElementCount());
		//test getHeight
		System.out.println(tree.getHeight());
		
	}
}
