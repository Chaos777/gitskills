class Tree {
	int value;
	Tree left, right;
	public Tree(int v){
		this.value = v;
	}
}

public class TreeTest {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	static void preorder(Tree root) {
		if (root != null) {
			if (root.value < min)
				min = root.value;
			if (root.value > max)
				max = root.value;
			preorder(root.left);
			preorder(root.right);
		}
	}

	static int maxDiff(Tree root) {
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		preorder(root);
		if (max >= min)
			return max - min;
		else
			return -1;
	}

	public static void main(String[] args) {
		Tree root = new Tree(0);
		Tree root1 = new Tree(1);
		Tree root2 = new Tree(2);
		Tree root3 = new Tree(3);
		Tree root4 = new Tree(4);
		root .left = root1;
		root .right = root2;
		root1 .left = root3;
		root2 .right = root4;
		System.out.println(maxDiff(root));
		
	}
}