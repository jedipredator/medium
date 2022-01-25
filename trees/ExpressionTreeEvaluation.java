class ExpressionTreeNode {

	String value;
	ExpressionTreeNode left;
	ExpressionTreeNode right;

	ExpressionTreeNode(String value) {
		this.value = value;
	}

	ExpressionTreeNode(String value, ExpressionTreeNode left, ExpressionTreeNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

public class ExpressionTreeEvaluation {

    public int evaluate(ExpressionTreeNode node){
        if (node.value.equals("/")) {
        	return evaluate(node.left) / evaluate(node.right);
        } else if (node.value.equals("*")) {
        	return evaluate(node.left) * evaluate(node.right);
        } else if (node.value.equals("-")) {
        	return evaluate(node.left) - evaluate(node.right);
        } else if (node.value.equals("+")) {
        	return evaluate(node.left) + evaluate(node.right);
        } else {
        	return Integer.valueOf(node.value);
        }
    }

	public static void main(String[] args) {
		ExpressionTreeEvaluation expressionTree = new ExpressionTreeEvaluation();

		ExpressionTreeNode expressionTreeRoot = new ExpressionTreeNode("+");
		expressionTreeRoot.left = new ExpressionTreeNode("3");
		expressionTreeRoot.right = new ExpressionTreeNode("*");
		expressionTreeRoot.right.left = new ExpressionTreeNode("+");
		expressionTreeRoot.right.left.left = new ExpressionTreeNode("5");
		expressionTreeRoot.right.left.right = new ExpressionTreeNode("9");
		expressionTreeRoot.right.right = new ExpressionTreeNode("2");

		System.out.println(expressionTree.evaluate(expressionTreeRoot)); // 31 should be printed
	}
}
