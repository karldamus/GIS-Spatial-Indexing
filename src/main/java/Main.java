import dataStructures.KD_Tree;
import dataStructures.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import geotools.TestGeoTools;

public class Main {
    public static void main(String[] args) throws Exception {
        int k = 3, n = 12, r = 1000;
//        testKDTree(k, n, r);

        testGeoTools();
    }

    public static void testKDTree(int k, int n, int resolution) {
        // Generate list of random points
        Random random = new Random();
        ArrayList<Point> points = new ArrayList<Point>();
        Point newPoint;
        while (points.size() < n) {
            int x = random.nextInt(resolution);
            int y = random.nextInt(resolution);
            int z = random.nextInt(resolution);
            newPoint = new Point(x, y, z);

            points.add(newPoint);
        }

        // Overwrite points arraylist?
//        points = new ArrayList<Point>(Arrays.asList(new Point(63, 30), new Point(25, 58), new Point(9, 3), new Point(85, 48), new Point(48, 96), new Point(66, 48), new Point(78, 57), new Point(51, 18)));

//        System.out.println("Keep same points? Paste the following just below //Overwrite points arraylist");
//        System.out.print("       points = new ArrayList<Point>(Arrays.asList(");
//        for (int i = 0; i < points.size(); i++) {
//            System.out.print("new Point(" + points.get(i).getX() + ", " + points.get(i).getY() + ")");
//            if ((i+1) != points.size())
//                System.out.print(", ");
//        }
//        System.out.println("));");


        // Generate KD-Tree with list of points
        KD_Tree kdTree = new KD_Tree(k, points);

        System.out.println("-------------");
        System.out.println("Printing Tree: ");

        kdTree.printTree();

//        kdTree.traverse(KD_Tree.traversalMethod.IN_ORDER);

    }

    public static void testGeoTools() throws Exception {
        TestGeoTools testGeoTools = new TestGeoTools();
        testGeoTools.test();
    }
}
