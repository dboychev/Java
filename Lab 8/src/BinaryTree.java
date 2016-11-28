
public class BinaryTree<E> {

	protected BTNode<E> root;
	
	public BinaryTree() {
		root = null;
	}
	
	public BinaryTree(E element, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		root = new BTNode<E>(element);
		if (leftTree != null)
			root.left = leftTree.root;
		if (rightTree != null)
			root.right = rightTree.root;
	}
	
	//Private helper method that initially takes the root as a parameter and recursively goes through its children
	private int countHelper(BTNode<E> node)
	{
		if (node != null)
		{
			//Takes all the nodes from left and right side
			return 1 + countHelper(node.left) + countHelper(node.right);
		}
		
		//If the root is null - there are no nodes at the tree
		return 0;
	}
	
	public int count() 
	{
		return countHelper(root);
	}

	//Private helper method for finding the height
	private int heightHelper(BTNode<E> node)
	{
		
		if (node != null)
		{
			//If the root is not null, we find the longest way to a null children
			return 1 + Math.max(heightHelper (node.left), heightHelper (node.right));
		}
		
		//If the root is null - height is also 0, there are not any nodes at the tree
		return 0;
	}
	
	public int height()
	{
		return heightHelper(root);
	}
	
	//Private helper method to check whether the tree is a full one or not
	private boolean isFullHelper(BTNode<E> node)
	{
		//If left and right children both do not exist - that is ok
		if (node.left == null && node.right == null)
		{
			return true;
		}
		
		//If left and right children both exist - we continue checking with their children
		else if (node.left != null && node.right != null)
		{
			return isFullHelper(node.left) && isFullHelper(node.right);
		}
		
		//If one of the children exists, but the other one - does not - the tree is not full
		return false;
	}
	
	public boolean isFull() 
	{
		if (root != null)
		{
			return isFullHelper(root);		
		}
		
		return true;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		preOrderTraversal(root, 1, sb);
		return sb.toString();
	}
	
	private void preOrderTraversal(BTNode<E> node, int depth, StringBuilder sb) {
		for (int i = 1; i < depth; i++)
			sb.append ("  ");
		if (node == null)
			sb.append("null\n");
		else {
			sb.append(node.toString());
			sb.append("\n");
			preOrderTraversal(node.left, depth+1, sb);
			preOrderTraversal(node.right, depth+1, sb);
		}
	}
	
	protected static class BTNode<E> {
		protected E data;
		protected BTNode<E> left;
		protected BTNode<E> right;
		
		public BTNode(E element) {
			data = element;
			left = null;
			right = null;
		}
		
		public String toString() {
			return data.toString();
		}
	}
	
}
