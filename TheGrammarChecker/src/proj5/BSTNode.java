

/**
 * A generic BSTNode in a BST with instance variable key
 * as the value of the node and left, right link of that node
 * @param <T> the item type
 * author: Son Nguyen (Kyrie)
 * version: 6/3/2020
 */
public class BSTNode<T> {

    // instance variable
    public Object key;
    public BSTNode<T> llink;
    public BSTNode<T> rlink;

    /**
     * non-default constructor
     * @param data the data stored in this node
     */
    public BSTNode(T data){
    	key=data;  // autoboxing!
    	llink=null;
    	rlink=null;
    }

    /**
     * @return string representation of this node
     */
    public String toString() {
        return key.toString();
    }

    /**
     * a leaf is a node with no children
     * @return true if this node is a leaf, false otherwise
     */
    public boolean isLeaf() {
    	return this.llink == null && this.rlink == null;
    }

    /**
     * @return true if this node has only right branch, false otherwise
     */
    public boolean hasRightChildOnly() {
    	return this.llink == null && this.rlink != null;
    }

    /**
     * @return true if this node has only left branch, false otherwise
     */
    public boolean hasLeftChildOnly() {
    	return this.llink != null && this.rlink == null;
    }
}
