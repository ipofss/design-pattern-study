package compositemode;

/**
 * 组合模式有时又叫部分-整体模式，在处理类似树形结构的问题时比较方便
 *
 * @author: wangbingshuai
 * @create: 2020-01-04 11:56
 **/
public class CompositeMode {
    public static void main(String[] args) {
        Tree tree = new Tree("root");
        tree.createTree(4);
        tree.printTree();
    }
}

class TreeNode {
    private String name;
    private TreeNode parent;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(String name, TreeNode parent) {
        this.name = name;
        this.parent = parent;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public String getName() {
        return name;
    }
}

class Tree {
    private TreeNode root;

    public Tree(String rootName) {
        this.root = new TreeNode(rootName, null);
    }

    /**
     * 创建一棵完全二叉树
     *
     * @param parent      父节点
     * @param nBeginLevel 初始层级
     * @param nEndLevel   结束层级
     */
    private void createTree(TreeNode parent, int nBeginLevel, int nEndLevel) {
        if (nBeginLevel == nEndLevel) {
            return;
        }
        // 创建左边节点
        TreeNode left = new TreeNode(nBeginLevel + "-left", parent);
        parent.setLeft(left);
        // 创建右边节点
        TreeNode right = new TreeNode(nBeginLevel + "-right", parent);
        parent.setRight(right);
        // 递归创建左子树
        createTree(left, nBeginLevel + 1, nEndLevel);
        // 递归创建右子树
        createTree(right, nBeginLevel + 1, nEndLevel);
    }

    /**
     * 创建一棵完全二叉树
     *
     * @param treeHeight 树的深度
     */
    public void createTree(int treeHeight) {
        createTree(root, 1, treeHeight + 1);
    }

    /**
     * 打印树
     *
     * @param root  根节点
     * @param blank 空格
     */
    private void printTree(TreeNode root, String blank) {
        if (root == null) {
            return;
        }
        System.out.println(blank + root.getName());
        // 递归打印左子树
        printTree(root.getLeft(), blank + " ");
        // 递归打印右子树
        printTree(root.getRight(), blank + " ");
    }

    /**
     * 打印树
     */
    public void printTree() {
        printTree(root, " ");
    }
}
