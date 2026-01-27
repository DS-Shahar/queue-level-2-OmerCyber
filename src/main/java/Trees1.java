public class TreeTasks {

    private static boolean isGood(BinNode<Integer> t) {
        if (t == null) return false;
        if (t.getValue() % 2 != 0) return false;
        if (t.hasLeft() && t.getLeft().getValue() % 2 != 0) return false;
        if (t.hasRight() && t.getRight().getValue() % 2 != 0) return false;
        return true;
    }

    public static void printGoodNodes(BinNode<Integer> t) {
        if (t == null) return;
        if (isGood(t)) System.out.println(t.getValue());
        printGoodNodes(t.getLeft());
        printGoodNodes(t.getRight());
    }

    public static int countGoodNodes(BinNode<Integer> t) {
        if (t == null) return 0;
        int count = isGood(t) ? 1 : 0;
        count += countGoodNodes(t.getLeft());
        count += countGoodNodes(t.getRight());
        return count;
    }

    public static boolean existsGoodNode(BinNode<Integer> t) {
        if (t == null) return false;
        if (isGood(t)) return true;
        return existsGoodNode(t.getLeft()) || existsGoodNode(t.getRight());
    }

    public static boolean allNodesAreGood(BinNode<Integer> t) {
        if (t == null) return true;
        if (!isGood(t)) return false;
        return allNodesAreGood(t.getLeft()) && allNodesAreGood(t.getRight());
    }

    public static void main(String[] args) {
        BinNode<Integer> n2 = new BinNode<>(2);
        BinNode<Integer> n6 = new BinNode<>(6);
        BinNode<Integer> n4 = new BinNode<>(n2, 4, n6);

        BinNode<Integer> n3 = new BinNode<>(3);
        BinNode<Integer> n10 = new BinNode<>(null, 10, n3);

        BinNode<Integer> root = new BinNode<>(n4, 8, n10);

        printGoodNodes(root);
        System.out.println(countGoodNodes(root));
        System.out.println(existsGoodNode(root));
        System.out.println(allNodesAreGood(root));
    }
}
