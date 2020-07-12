/**
 * Generic Binary Search Tree ADT.
 *
 * @author Son Nguyen (Kyrie)
 * @version 6/3/2020
 */
// package proj5;
public class BinarySearchTree<T extends Comparable<T>>
{
	private BSTNode<T> root;

	/**
	 * Default constructor
	 */
	public BinarySearchTree() {
		root=null;
	}

	/**
	 * inserts newNode into tree rooted at startingNode.
	 * Returns root of that tree with newNode inserted.
	 *
	 * @param startingNode
	 * @param newNode
	 * @return root of tree with node inserted
	 */
	private BSTNode<T> insert(BSTNode<T> startingNode, BSTNode<T> newNode) {
		if (startingNode == null) {
			return newNode;
		}
		// pretend that key has compareTo method
		else if (((T) startingNode.key).compareTo((T) newNode.key) > 0) {
			// newNode goes on left
			startingNode.llink = insert(startingNode.llink,newNode);
			return startingNode;
		}
		else {
			// newNode goes on right
			startingNode.rlink = insert(startingNode.rlink,newNode);
			return startingNode;
		}
	}

	/**
	 * inserts an object into BST
	 * @param item object to insert
	 */
	public void insert(T item) {
		BSTNode<T> newNode = new BSTNode<T>(item);
		root=insert(root,newNode);
	}

	/**
	 * get the min key of a subroot
	 * @param subroot the subroot to get min key
	 * @return the min value of this subroot
	 */
	private T minValue(BSTNode<T> subroot) {
		T toReturn = (T) subroot.key;
		while (subroot.llink != null) {
			toReturn = (T) subroot.llink.key;
			subroot = subroot.llink;
		}
		return toReturn;
	}

	/**
	 * get the max key of a subroot
	 * @param subroot the subroot to get max key
	 * @return the max value of this subroot
	 */
	private T maxValue(BSTNode<T> subroot) {
		T toReturn = (T) subroot.key;
		while (subroot.rlink != null) {
			toReturn = (T) subroot.rlink.key;
			subroot = subroot.rlink;
		}
		return toReturn;
	}

	/**
	 * deletes victim from tree rooted at subroot
	 *
	 * @param subroot
	 * @param victim
	 * @return pointer to same part of tree but with victim removed, null otherwise
	 * POST CONDITION: the BSTNode holding the victim is deleted from the subroot
	 * or its key is replaced by the minimum value in the right branch
	 */
	private BSTNode<T> delete(BSTNode<T> subroot, T victim) {
		if (subroot == null) {
			return subroot;
		}
		else if (victim.compareTo((T) subroot.key) < 0) {
			subroot.llink = delete(subroot.llink, victim);
		}
		else if (victim.compareTo((T) subroot.key) > 0) {
			subroot.rlink = delete(subroot.rlink, victim);
		}
		else {
			if (subroot.isLeaf()) {
				return null;
			}
			else if (subroot.hasLeftChildOnly()) {
				return subroot.llink;
			}
			else if (subroot.hasRightChildOnly()) {
				return subroot.rlink;
			}
			else {
				subroot.key = minValue(subroot.rlink);
				subroot.rlink = delete(subroot.rlink, (T) subroot.key);
			}
		}
		return subroot;
	}

	/**
	 * delete an item for the tree, do nothing if the item is not found
	 * @param victim the item to be deleted
	 */
	public void delete(T victim) {
		root = delete(root, victim);
	}

	/**
	 * search for an item in a subtree
	 * @param subroot
	 * @param item
	 * @return the node containing the item, null if the object is not in the tree
	 */
	private BSTNode<T> search(BSTNode<T> subroot, T item) {
		if (subroot != null) {
			if (item.compareTo((T) subroot.key) < 0) {
				return search(subroot.llink, item);
			} else if (item.compareTo((T) subroot.key) > 0) {
				return search(subroot.rlink, item);
			}
		}
		return subroot;
	}

	/**
	 * search for an item in the tree
	 * @param item the item to be searched
	 * @return the item's information stored in the tree,
	 * null if cannot find the item
	 */
	public T search(T item) {
		BSTNode<T> returnNode = search(root, item);
		if (returnNode != null) {
			return (T) returnNode.key;
		}
		return null;
	}

	private int height(BSTNode<T> subtree) {
		if (subtree == null) {
			return -1;
		}
		else {
			int leftHeight = height(subtree.llink);
			int rightHeight = height(subtree.rlink);
			return 1 + Math.max(leftHeight, rightHeight);
		}
	}

	public int height() {
		return height(root);
	}

	/**
	 * @param subroot the branch
	 * @return string representation of a branch
	 */
	private String branchString(BSTNode<T> subroot) {
		String toReturn = "";
		if (subroot != null) {
			if (subroot.llink != null) {
				toReturn += branchString(subroot.llink);
			}
			toReturn += subroot;
			if (subroot.rlink != null) {
				toReturn += branchString(subroot.rlink);
			}
		}
		return toReturn;
	}

	/**
	 * @return string representation of the tree
	 */
	public String toString() {
		return branchString(root);
	}
}
