/**
 * R-Tree.java
 *
 * Author: Karl Damus
 *
 * What is an R-Tree?
 *  - R-Tree is a tree data structure used for storing spatial data indexes in an
 *      efficient manner. R-Trees are highly useful for spatial data queries and storage.
 *  - R-Trees can be used for:
 *      - Indexing multi-dimensional information
 *      - Handling geospatial coordinates
 *      - Implementation of virtual maps
 *      - Handling game data
 *
 *  Properties of an R-Tree:
 *  - Consists of a single root, internals nodes, and leaf nodes.
 *  - Root contains pointer to largest region in spatial domain
 *  - Parent nodes contains pointers to their child nodes where the region of child
 *      nodes completely overlaps the regions of parent nodes.
 *  - Leaf nodes contains data about the MBR to the current objects
 *  - MBR-Min bounding region refers to the minimal bounding box parameter surrounding
 *      the region/object under consideration.
 *
 *  Source: https://www.geeksforgeeks.org/introduction-to-r-tree/
 */

package dataStructures;

import java.util.ArrayList;
import java.util.List;

public class R_Tree {
    private Node root;

    /**
     * Helper class: Point
     */
    private static class Point {
        Rectangle boundingBox;
        Object pointData;

        public Point(Rectangle boundingBox, Object pointData) {
            this.boundingBox = boundingBox;
            this.pointData = pointData;
        }
    }

    /**
     * Helper class: Rectangle
     */
    private static class Rectangle {
        double x1, x2, y1, y2;

        public Rectangle(double x1, double y1, double x2, double y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    /**
     * Helper class: Node
     */
    private static class Node {
        boolean isLeafNode;
        Rectangle boundingBox;
        List<Point> points;
        List<Node> children;

        public Node(boolean isLeafNode) {
            this.isLeafNode = isLeafNode;

            points = new ArrayList<Point>();
            children = new ArrayList<Node>();
        }

        public Node[] split() {
            // TODO: Implement splitting logic

            return new Node[]{};
        }
    }

    /**
     * -----------------------
     */

    public R_Tree() {

    }
}
