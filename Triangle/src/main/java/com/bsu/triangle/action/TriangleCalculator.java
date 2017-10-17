package com.bsu.triangle.action;

import com.bsu.triangle.entity.Point;
import com.bsu.triangle.entity.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.*;


/**
 * Created by ASUS on 07.10.2017.
 */
public class TriangleCalculator {

    private static final Logger LOGGER = LogManager.getLogger(TriangleCalculator.class);

    public static double square(Triangle triangle) {

        List<Double> distances = distances(triangle);
        double semiPerimeter= perimeter(triangle) / 2;
        double square = sqrt(semiPerimeter* ((semiPerimeter- distances.get(0))
                * (semiPerimeter- distances.get(1))
                * ((semiPerimeter- distances.get(2)))));
        LOGGER.info("Square of " + triangle + " is " + square);
        return square;
    }

    public static double perimeter(Triangle triangle) {

        List<Double> distances = distances(triangle);
        //double perimeter = distances.stream().mapToDouble(Double::doubleValue).sum();
        double perimeter = distances.stream().reduce(0.0, Double::sum);
        LOGGER.info("Perimeter of " + triangle + " is " + perimeter);
        return perimeter;
    }

    public static boolean isRightTriangle(Triangle triangle) {

        List<Double> distances = distances(triangle);
        Double hypotenuse = distances.stream().max(Double::compareTo).orElse(-1.0);
        Double hypotenuseSquare = pow(hypotenuse, 2);
        double eps = 0.000001;
        double realHypotenuseSquare = 0.0;
        for (Double side : distances) {
            if (!Objects.equals(side, hypotenuse)) {
                realHypotenuseSquare += pow(side, 2);
            }
        }
        boolean isRightTriangle = realHypotenuseSquare - hypotenuseSquare <= eps;
        LOGGER.info(triangle + " is right : " + isRightTriangle);
        return isRightTriangle;
    }

    public static boolean isCorrectTriangle(Triangle triangle) {

        boolean isCorrectTriangle = isCorrectTriangle(triangle.getA(), triangle.getB(), triangle.getC());
        LOGGER.info(triangle + " is correct : " + isCorrectTriangle);
        return isCorrectTriangle;
    }

    public static boolean isCorrectTriangle(Point a, Point b, Point c) {

        Triangle triangle = new Triangle(a, b, c);
        List<Double> sides = distances(triangle);
        sides.sort(Double::compareTo);
        if (sides.get(2) >= sides.get(0) + sides.get(1))
            return false;
        if (a.getX() == b.getX() && a.getX() == c.getX() ||
                a.getY() == b.getY() && a.getY() == c.getY())
            return false;
        return true;
    }

    private static double distance(Point a, Point b) {

        double dx = abs(a.getX() - b.getX());
        double dy = abs(a.getY() - b.getY());
        double distance = hypot(dx, dy);
        return distance;
    }

    private static List<Double> distances(Triangle triangle) {

        List<Double> distances = new ArrayList<>(3);
        Point a = triangle.getA();
        Point b = triangle.getB();
        Point c = triangle.getC();

        double ab = distance(a, b);
        double bc = distance(b, c);
        double ca = distance(c, a);

        distances.add(ab);
        distances.add(bc);
        distances.add(ca);

        return distances;
    }
}
