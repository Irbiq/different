package com.bsu.triangle.action;

import com.bsu.triangle.entity.Point;
import com.bsu.triangle.entity.Triangle;
import com.bsu.triangle.factory.TriangleFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by ASUS on 08.10.2017.
 */
public class TriangleCalculatorTest {
    Triangle triangle;

    @BeforeMethod
    public void setUp() throws Exception {
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(0, 1);
        triangle = TriangleFactory.createTriangle(a, b, c);
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void testSquare() throws Exception {
        double eps = 0.000_001;
        double expectedSquare = 0.5;
        Assert.assertEquals(TriangleCalculator.square(triangle), expectedSquare, eps);
    }

    @Test
    public void testPerimeter() throws Exception {
        double eps = 0.000_001;
        double expectedPerimeter = 3.41421356;
        Assert.assertEquals(TriangleCalculator.perimeter(triangle), expectedPerimeter, eps);
    }

    @Test
    public void testIsRightTriangle() throws Exception {

        Assert.assertEquals(TriangleCalculator.isRightTriangle(triangle), true);
    }

    @Test
    public void testIsCorrectTriangle() throws Exception {

        Assert.assertEquals(TriangleCalculator.isCorrectTriangle(triangle), true);
    }
}