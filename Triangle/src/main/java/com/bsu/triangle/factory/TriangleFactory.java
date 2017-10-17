package com.bsu.triangle.factory;

import com.bsu.triangle.action.TriangleCalculator;
import com.bsu.triangle.entity.Point;
import com.bsu.triangle.entity.Triangle;
import com.bsu.triangle.exception.InvalidTriangleParametersException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Created by ASUS on 08.10.2017.
 */
public class TriangleFactory {

    private static final Logger LOGGER = LogManager.getLogger(TriangleFactory.class);

    public static Triangle createTriangle(Point a, Point b, Point c) throws InvalidTriangleParametersException {

        if (TriangleCalculator.isCorrectTriangle(a, b, c)) {
            Triangle triangle = new Triangle(a, b, c);
            LOGGER.info("Triangle created. Vertexes are : " + a + " " + b + " " + c);
            return triangle;
        } else {
            throw new InvalidTriangleParametersException();
        }
    }

    public static List<Triangle> createTriangles(List<String> trianglesData) {

        List<Triangle> triangles = new ArrayList<>(trianglesData.size());
        Triangle triangle;
        List<Point> points;
        try {
            for(String triangleCoordinates : trianglesData){
                points = coordinatesToPoints(triangleCoordinates);
                triangle = TriangleFactory.createTriangle(points.get(0),points.get(1),points.get(2));
                triangles.add(triangle);
            }
        } catch (InvalidTriangleParametersException e) {
            LOGGER.error("Incorrect coordinates", e.getMessage(), e);
        }
        return triangles;
    }

    private static  List<Point> coordinatesToPoints(String triangleStr){

        List<Point> points = new ArrayList<>();
        String[] coordinates =  triangleStr.split(" ");
        for(int i=0; i<coordinates.length;i+=2){
            points.add(new Point(Double.parseDouble(coordinates[i]),Double.parseDouble(coordinates[i+1])));
        }
        return points;
    }


    /*разбить read / create*/
    /*public static List<Triangle> createTriangles(String filename) {

        List<Triangle> triangles = null;
        try {
            //BufferedReader reader = new BufferedReader(new FileReader(filename));
            Scanner sc = new Scanner(new File(filename));
            triangles = new ArrayList<>();
            LOGGER.info("Started reading from file : " + filename);
            Point a, b, c;
            Triangle triangle;
            while (sc.hasNext()) {
                a = new Point(sc.nextDouble(), sc.nextDouble());
                b = new Point(sc.nextDouble(), sc.nextDouble());
                c = new Point(sc.nextDouble(), sc.nextDouble());
                triangle = TriangleFactory.createTriangle(a, b, c);
                triangles.add(triangle);
            }
            LOGGER.info("Finished reading from file : " + filename);
            return triangles;
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (InvalidTriangleParametersException e) {
            LOGGER.error("Incorrect coordinates", e.getMessage(), e);
        }
        return triangles;
    }*/
}
