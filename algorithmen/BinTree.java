package algorithmen;

/**
 * Algorithmen HA4
 * 
 * BinTree Class implements a binary search tree with fundamental operations
 * such as searching, inserting and removing.
 * 
 *
 */
public class BinTree {
	Node root; // start node

	/**
	 * Supportive class that provides nodes that the tree is made of. Each node has
	 * the int value that it contains and references its right and left successor
	 *
	 */
	class Node {
		int data;
		Node left_child;
		Node right_child;

		// Constructor
		public Node(int new_data) {
			data = new_data;
			left_child = null;
			right_child = null;
		}
	}

	/**
	 * Searches for a value
	 * 
	 * @param x int value to search for
	 * @return node that contains the value x (null if x does not exist in the tree)
	 */
	private Node getNode(int x) {
		if (root == null || root.data == x) {
			return root;
		}
		if (root.data < x) {
			return getNode(root.right_child, x);
		} else {
			return getNode(root.left_child, x);
		}
	}

	/**
	 * helper function to support recursion by looking for data in subtree with
	 * given root node
	 * 
	 * @param Node root is the node from which onwards to start looking
	 * @param x    int value to search for
	 * @return node that contains the value x
	 */
	private Node getNode(Node root, int x) {
		if (root == null || root.data == x) {
			return root;
		}
		if (root.data < x) {
			return getNode(root.right_child, x);
		} else {
			return getNode(root.left_child, x);
		}

	}

	/**
	 * Looks for the parent node of a value.
	 * 
	 * @param x int value for which to find the parent node
	 * @return Node parent node of value x
	 */
	private Node getParentNode(int x) {
		if (getNode(x) == null || root.data == x) {
			return null;
		}
		return getParentNodeRec(root, x);

	}

	/**
	 * Helper function to recursively find parent node
	 * 
	 * @param node starting point from which to look for value
	 * @param x    int value for which to find the parent node
	 * @return Node parent node of value x
	 */
	private Node getParentNodeRec(Node node, int x) {
		if (node.data==x) {
			return node;
		}
		if (node.left_child != null) {
			if (node.left_child.data > x) {
				return getParentNodeRec(node.left_child, x);
			}
			else if (node.left_child.data == x) {
				return node;
			}
		}
		if (node.right_child != null && node.data < x) {
			if (node.right_child.data < x) {
				return getParentNodeRec(node.right_child, x);
			}
			else if (node.right_child.data == x) {
				return node;
			}
		}
		return null;
	}

	/**
	 * Insert a new value into the binary tree.
	 * 
	 * @param x int value to be inserted
	 * @throws ArithmeticException if value already exists
	 */
	public void insert(int x) {
		if (getNode(x) != null) {
			throw new ArithmeticException("Wert schon vorhanden.");
		}
		if (root == null) {
			root = new Node(x);
		} else {
			insertRecursive(root, x);
		}
	}

	/**
	 * Helper function for recursion
	 * 
	 * @param node from which to look for place to insert x
	 * @param x    int value to be inserted
	 * @return node newly inserted node
	 */
	private void insertRecursive(Node node, int x) {
		if (x < node.data) {
			if (node.left_child == null) {
				node.left_child = new Node(x);
			} else {
				insertRecursive(node.left_child, x);
			}
		} else if (x > node.data) {
			if (node.right_child == null) {
				node.right_child = new Node(x);
			} else {
				insertRecursive(node.right_child, x);
			}
		}
	}

	/**
	 * Clears the binary search tree by deleting its root value
	 */
	public void clear() {
		root = null;
	}

	/**
	 * Delete a value x from the binary search tree.
	 * 
	 * @param x int value to be deleted
	 * @throws ArithmeticException if value x does not exist in the tree
	 */
	public void remove(int x) {
		if (getNode(x) == null) {
			throw new ArithmeticException("Value does not exist in the tree.");
		}
		removeRec(root, x);
	}

	/**
	 * helper function to recursively retrieve the node that contains the value that
	 * should be removed
	 * 
	 * @param node Node starting point to search for the value
	 * @param x    int value to be removed
	 * @return node Node for recursion
	 */
	public Node removeRec(Node node, int x) {
		if (node == null) {
			return node;
		}
		if (x < node.data) {
			node.left_child = removeRec(node.left_child, x);
			return node;

		} else if (x > node.data) {
			node.right_child = removeRec(node.right_child, x);
			return node;

		} else {
			if (node.left_child == null)
				return node.right_child;
			else if (node.right_child == null)
				return node.left_child;
			return node;
		}
	}

	/**
	 * test class for class BinTree (copied from the assignment, plus removal test)
	 * 
	 */
	public static void main(String[] args) {
		BinTree tree = new BinTree();
		tree.insert(20);
		tree.insert(10);
		tree.insert(30);
		tree.insert(50);
		int[] testcases = { 30, 35, 50 };
		for (int testcase : testcases) {
			Node node = tree.getNode(testcase);
			if (node == null) {
				System.out.println("Knoten " + testcase + " nicht gefunden.");
			} else {
				System.out.println("Knoten " + testcase + " gefunden: " + node.data);
			}
		}
		tree.remove(30);
		System.out.println("Knoten geloescht: 30");
		Node node = tree.getNode(30);
		if (node == null) {
			System.out.println("Knoten 30" + " nicht gefunden.");
		}
		System.out.println("Elternknoten von 50: " + tree.getParentNode(50).data);// 20
		tree.insert(5);
		System.out.println(tree.getNode(5).data);
		System.out.println("Elternknoten von 5: " + tree.getParentNode(5).data);// 10

	}
}
