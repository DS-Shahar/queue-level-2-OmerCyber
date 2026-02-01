 class TreeNode
 {
    int value;
    TreeNode left, right;
    TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

public class TreeHeight {
    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        System.out.println("Height of tree: " + height(root));
    }
}
 class TreeNode {
    int value;
    TreeNode left, right;
    TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

public class BalancedTree {
    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = …
 public class CipherCount {
    public static int countCiphers(int num) {
        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int number = 12345; 
        System.out.println("Number of ciphers: " + countCiphers(number));
    }
}
 public class CombineNumbers {
    public static boolean containsTwo(int num) {
        return Integer.toString(num).contains("2");
    }

    public static void main(String[] args) {
        int num = 12345;  
        System.out.println("Contains 2: " + containsTwo(num));
    }
}
 public class CheckAllDigits {
    public static boolean containsAllDigits(int num) {
        String numStr = Integer.toString(num);
        for (char digit = '0'; digit <= '9'; digit++) {
            if (!numStr.contains(String.valueOf(digit))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int number = 1234567890; 
        System.out.println("Contains all digits: " + containsAllDigits(number));
    }
}
