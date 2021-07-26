// TreeOperation.java
public class TreeOperation {
    /*
         Example of the structure of the tree:
              1
            /   \
          2       3
         / \     / \
        4   5   6   7
    */

    // the number of layers used to get the tree
    public static int getTreeDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(root.getLeft()), getTreeDepth(root.getRight())));
    }


    private static void writeArray(TreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // Ensure that the input tree is not empty
        if (currNode == null) return;
        // First save the current node to a two-dimensional array
        res[rowIndex][columnIndex] = String.valueOf(currNode.getValue());

        // Calculate the current layer in the tree
        int currLevel = ((rowIndex + 1) / 2);
        // If it reaches the last level, it will return
        if (currLevel == treeDepth) return;
        // Calculate the interval between each element from the current line to the next line (the interval between the column index of the next line and the column index of the current element)
        int gap = treeDepth - currLevel - 1;

        // judge the left son, if there is a left son, record the corresponding "/" and the value of the left son
        if (currNode.getLeft() != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.getLeft(), rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // Make a judgment on the right son. If there is a right son, record the value of the corresponding "\" and the right son.
        if (currNode.getRight() != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.getRight(), rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }


    public static void show(TreeNode root) {
        if (root == null) System.out.println("EMPTY!");
        // Get the depth of the tree
        int treeDepth = getTreeDepth(root);

        // The width of the last line is 2 (n - 1) and the power is 3, plus 1
        // as the width of the entire two-dimensional array
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // Use an array of strings to store the elements that should be displayed at each location
        String[][] res = new String[arrayHeight][arrayWidth];
        // Initialize the array, the default is a space
        for (int i = 0; i < arrayHeight; i ++) {
            for (int j = 0; j < arrayWidth; j ++) {
                res[i][j] = " ";
            }
        }

        // Recursive processing of the entire tree from the root node
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.getValue() + '0');
        writeArray(root, 0, arrayWidth/ 2, res, treeDepth);

        // At this point, all the elements that need to be displayed have been stored in a two-dimensional array, spliced ​​and printed.
        for (String[] line: res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i ++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2: line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }
}
