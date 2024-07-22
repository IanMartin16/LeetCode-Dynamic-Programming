class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class HouseRobberIII {

    public int rob(TreeNode root) {
        int[] result = robHelper(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robHelper(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = robHelper(node.left);
        int[] right = robHelper(node.right);

        int robCurrent = node.val + left[1] + right[1];
        int notRobCurrent = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{robCurrent, notRobCurrent};
    }

    public static void main(String[] args) {
        HouseRobberIII solution = new HouseRobberIII();

        // Construct the tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        System.out.println(solution.rob(root)); // Expected output: 7
    }
}


//The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.

//Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.

//Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.