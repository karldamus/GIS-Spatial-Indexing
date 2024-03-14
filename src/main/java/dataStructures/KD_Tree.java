package dataStructures;

import java.util.ArrayList;


public class KD_Tree {

    private final int MAX_K_SIZE = 4;
    private int k; // dimension
    private Node root; // root node

    /**
     * Node class to store points, l and r nodes, and the depth of the node.
     */
    private class Node {
        private Point p;
        private Node l;
        private Node r;
        private int depth; // this can be anywhere between 0->k

        public Node(Point p) {
            this.p = p;
            this.l = this.r = null;
        }

        // getters
        public Point getPoint() {return p;}
        public Node getLeft() {return l;}
        public Node getRight() {return r;}
    }

    /**
     * Generate a new KD-Tree
     * @param k size of the KD-Tree
     * @param points list of points to generate Tree with
     */
    public KD_Tree(int k, ArrayList<Point> points) {
        if (k > MAX_K_SIZE) {
            System.out.printf("Your k is too large! Max size is %d. You shouldn't need any more dimensions than that silly!", MAX_K_SIZE);
            return;
        }

        this.k = k;

        buildTree(points);
    }

    /**
     * Build a new tree from a list of points
     * @param points the list of points to build the tree with
     */
    public void buildTree(ArrayList<Point> points) {
        if (points.size() == 0)
            return;

        root = new Node(points.remove(0));
        System.out.println("Inserting nodes");
        System.out.println(root.p);
        insertNodes(points);
    }

    /**
     * Insert a  list of points into the tree
     * @param points the list of points to insert
     */
    public void insertNodes(ArrayList<Point> points) {
        while (points.size() > 0) {
            System.out.println(points.get(0));
            insertNode(root, points.remove(0), 0);
        }
    }

    /**
     * Insert a single node into the tree, recursively.
     * @param root the current node to compare. If it is null it is the leaf node to insert into
     * @param point the point to be inserted into leaf node
     * @param depth the current depth used for checking which coordinate to compare
     * @return a new Node with data Point point
     */
    public Node insertNode(Node root, Point point, int depth) {
        if (root == null) {
            return new Node(point);
        }

        // check depth of root to determine what coordinate to compare
        // e.g., if depth == 0 then compare point[0] to root[0]
        int currCoord = point.coordinates.get(depth);
        int rootCoord = root.getPoint().coordinates.get(depth);

        // update depth for recursion
        depth = (depth + 1) % k;

        if (currCoord <= rootCoord)
            // go left
            root.l = insertNode(root.l, point, depth);
        else
            // go right
            root.r = insertNode(root.r, point, depth);

        return root;
    }

    public enum traversalMethod {
        IN_ORDER,
        PRE_ORDER
    }

    /**
     * Helper method to start traversal
     */
    public void traverse(traversalMethod traversalMethod) {
        switch (traversalMethod) {
            case IN_ORDER:
                inOrderTraversal(root);
                return;
            case PRE_ORDER:

        }
        inOrderTraversal(root);
    }

    public void inOrderTraversal(Node node) {
        if (node == null) return;
        inOrderTraversal(node.l);
        System.out.println(node.getPoint());
        inOrderTraversal(node.r);
    }

    public void preOrderTraversal(Node node) {

    }

    public void printTree() {
        printTree(root, 0);
    }

    public void printTree(Node node, int space) {
        if (node == null)
            return;

        space += 10;

        printTree(node.r, space);

        System.out.println();

        for (int i = 10; i < space; i++) {
            System.out.print(" ");
        }

        System.out.print(node.getPoint() + "\n");

        printTree(node.l, space);
    }

}


