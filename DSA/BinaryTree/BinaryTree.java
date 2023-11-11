import java.util.*;

public class BinaryTree {
    public class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BinaryTree() {
        Scanner sc = new Scanner(System.in);
        root = createTree(sc);
    }

    public Node createTree(Scanner sc) {
        int data = sc.nextInt();
        if (data == -1) return null;

        Node n = new Node(data);
        n.left = createTree(sc);
        n.right = createTree(sc);
        return n;
    }

    public void preorder() {
        preorder(root);
    }

    public void postorder() {
        postorder(root);
    }

    public void inorder() {
        inorder(root);
    }

    private void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + ",");
        preorder(root.left);
        preorder(root.right);
    }

    private void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + ",");
    }

    private void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + ",");
        inorder(root.right);
    }

    public void height() {
        System.out.print(height(root));
    }

    private int height(Node root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }

    public void diameter() {
        int[] diameter = new int[1];
        diameter(root, diameter);
        System.out.print(diameter[0]);
    }

    private int diameter(Node root, int[] diameter) {
        if (root == null) return 0;

        int left = diameter(root.left, diameter);
        int right = diameter(root.right, diameter);
        diameter[0] = Math.max(diameter[0], left + right);
        return Math.max(left, right) + 1;
    }

    public void levelOrder() {
        int level = height(root);
        for (int i = 1; i <= level; i++) {
            levelOrder(root, i);
        }
    }

    private void levelOrder(Node root, int level) {
        if (root == null) return;
        if (level == 1) {
            System.out.print(root.data + ",");
        } else if (level > 1) {
            levelOrder(root.left, level - 1);
            levelOrder(root.right, level - 1);
        }
    }

    public void levelOrderByQueue() {
        levelOrderByQueue(root);
    }

    private void levelOrderByQueue(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node front = queue.remove();
                System.out.print(front.data + ",");
                if (front.left != null) queue.add(front.left);
                if (front.right != null) queue.add(front.right);
            }
            System.out.println();
        }
    }

    public void leftView() {
        leftView(root);
    }

    private void leftView(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node front = queue.remove();
                if (i == 0) System.out.print(front.data + ",");
                if (front.left != null) queue.add(front.left);
                if (front.right != null) queue.add(front.right);
            }
        }
    }

    public void rightView() {
        rightView(root);
    }

    private void rightView(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node front = queue.remove();
                if (i == size - 1) System.out.print(front.data + ",");
                if (front.left != null) queue.add(front.left);
                if (front.right != null) queue.add(front.right);
            }
        }
    }

    public class QueueObj {
        public Node node;
        public int level;

        public QueueObj(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public void topView() {
        topView(root);
    }

    private void topView(Node root) {
        Queue<QueueObj> queue = new LinkedList<>();
        HashMap<Integer, Node> topViewMap = new HashMap<>();
        queue.add(new QueueObj(root, 0));

        while (!queue.isEmpty()) {
            QueueObj queueObj = queue.remove();
            Node node = queueObj.node;
            int level = queueObj.level;
            if (!topViewMap.containsKey(level)) {
                topViewMap.put(level, node);
            }
            if (node.left != null) queue.add(new QueueObj(node.left, level - 1));
            if (node.right != null) queue.add(new QueueObj(node.right, level + 1));
        }

        for (Map.Entry<Integer, Node> map : topViewMap.entrySet()) {
            System.out.print(map.getValue().data + ",");
        }
    }

    public void bottomView() {
        bottomView(root);
    }

    private void bottomView(Node root) {
        Queue<QueueObj> queue = new LinkedList<>();
        HashMap<Integer, Node> bottomViewMap = new HashMap<>();
        queue.add(new QueueObj(root, 0));

        while (!queue.isEmpty()) {
            QueueObj queueObj = queue.remove();
            Node node = queueObj.node;
            int level = queueObj.level;
            bottomViewMap.put(level, node);
            if (node.left != null) queue.add(new QueueObj(node.left, level - 1));
            if (node.right != null) queue.add(new QueueObj(node.right, level + 1));
        }

        for (Map.Entry<Integer, Node> map : bottomViewMap.entrySet()) {
            System.out.print(map.getValue().data + ",");
        }
    }

    public void zigZagTraversal() {
        zigZagTraversal(root);
    }

    private void zigZagTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        int[] arr = new int[0];

        while (!queue.isEmpty()) {
            int size = queue.size();
            arr = new int[size];
            for (int i = 0; i < size; i++) {
                Node front = queue.remove();
                int index = leftToRight ? i : size - i - 1;
                arr[index] = front.data;
                if (front.left != null) queue.add(front.left);
                if (front.right != null) queue.add(front.right);
            }
            for (int x : arr) System.out.print(x + ",");
            leftToRight = !leftToRight;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // 1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1
        BinaryTree tree = new BinaryTree();
        System.out.println("Preorder : ");
        tree.preorder();
        System.out.println("\nPostorder : ");
        tree.postorder();
        System.out.println("\nInorder : ");
        tree.inorder();
        System.out.println("\nHeight of tree : ");
        tree.height();
        System.out.println("\nDiameter of tree : ");
        tree.diameter();
        System.out.println("\nLevel order by recursion : ");
        tree.levelOrder();
        System.out.println("Level order by queue method : ");
        tree.levelOrderByQueue();
        System.out.println("ZigZag Traversal of Tree : ");
        tree.zigZagTraversal();
        System.out.println("\nLeft View : ");
        tree.leftView();
        System.out.println("\nRight View : ");
        tree.rightView();
        System.out.println("\nTopView of Tree : ");
        tree.topView();
        System.out.println("\nBottomView of Tree : ");
        tree.bottomView();
    }
}
