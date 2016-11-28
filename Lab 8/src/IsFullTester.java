
public class IsFullTester {

	public static void main(String[] args) {

		// Binary Tree #1

		BinaryTree<Integer> tree1 = 
			new BinaryTree<Integer>(56, 
				new BinaryTree<Integer>(34,
					new BinaryTree<Integer>(23,null,null),
					new BinaryTree<Integer>(40,null,null)
				),
				new BinaryTree<Integer>(78,
					new BinaryTree<Integer>(61,null,null),
					new BinaryTree<Integer>(92,null,null)
				)
			);

		System.out.println("Tree #1: \n" + tree1);		
		System.out.println("Tree is full: " + tree1.isFull() + "\n");
		
		// Binary Tree #2
	
		BinaryTree<Integer> tree2 = 
			new BinaryTree<Integer>(56, 
				new BinaryTree<Integer>(34,
					new BinaryTree<Integer>(23,null,null),
					new BinaryTree<Integer>(40,
						new BinaryTree<Integer>(37,null,null),
						new BinaryTree<Integer>(49,null,null)
					)
				),
				new BinaryTree<Integer>(78,null,null)
			);

		System.out.println("Tree #2: \n" + tree2);
		System.out.println("Tree is full: " + tree2.isFull() + "\n");
		
		// Binary Tree #3
			
		BinaryTree<Integer> tree3 = 
			new BinaryTree<Integer>(56, 
				new BinaryTree<Integer>(34,
					new BinaryTree<Integer>(23,null,null),
					new BinaryTree<Integer>(40,null,null)
				),
				new BinaryTree<Integer>(78,null,null)
			);

		System.out.println("Tree #3: \n" + tree3);
		System.out.println("Tree is full: " + tree3.isFull() + "\n");
	
		// Binary Tree #4
	
		BinaryTree<Integer> tree4 = 
			new BinaryTree<Integer>(56, 
				new BinaryTree<Integer>(34,
					new BinaryTree<Integer>(23,null,null),
					new BinaryTree<Integer>(40,
						new BinaryTree<Integer>(37,null,null),
						new BinaryTree<Integer>(49,null,null)
					)
				),
				new BinaryTree<Integer>(61,
					null,
					new BinaryTree<Integer>(92, 
						new BinaryTree<Integer>(78, null, null), 
						null)
					)
			);
	
		System.out.println("Tree #4: \n" + tree4);
		System.out.println("Tree is full: " + tree4.isFull() + "\n");
	
		// Binary Tree #5
	
		BinaryTree<Integer> tree5 =
			new BinaryTree<Integer>(11,
				new BinaryTree<Integer>(22,
					new BinaryTree<Integer>(33,
						new BinaryTree<Integer>(44,
							new BinaryTree<Integer>(55,
								new BinaryTree<Integer>(66,
									new BinaryTree<Integer>(77,
										new BinaryTree<Integer>(88,
											new BinaryTree<Integer>(99,null,null),
											null),
										null),
									null),
								null),
							null),
						null),
					null),
				null);
	
		System.out.println("Tree #5: \n" + tree5);
		System.out.println("Tree is full: " + tree5.isFull() + "\n");

		// Binary Tree #6

		BinaryTree<Integer> tree6 = new BinaryTree<Integer>(42,null,null);

		System.out.println("Tree #6: \n" + tree6);
		System.out.println("Tree is full: " + tree6.isFull() + "\n");
		
		// Binary Tree #7
		
		BinaryTree<Integer> tree7 = new BinaryTree<Integer>();
				
		System.out.println("Tree #7: \n" + tree7);
		System.out.println("Tree is full: " + tree7.isFull() + "\n");

	}

	
}
