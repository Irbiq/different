package com.bsu.triangle.factory;

import com.bsu.triangle.entity.Point;
import com.bsu.triangle.entity.Triangle;
import com.bsu.triangle.exception.InvalidTriangleParametersException;
import com.bsu.triangle.reader.TriangleReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

/**
 * Created by ASUS on 08.10.2017.
 */
public class TriangleFactoryTest {

    String testCorrectData = "0 0 0 1 1 0\n" +
            "0 0 0 2 2 0\n" +
            "1 1 1 2 3 3\n";
    String testIncorrectData = "0 0 0 1 1 0\n" +
            "0 0 0 2 2 0\n" +
            "0 0 1 1 4 4\n" +
            "1 1 0 0 0 0\n";
    private File correctDataFile;

    private File incorrectDataFile;

    @BeforeMethod
    public void setUp() throws Exception {
        correctDataFile = File.createTempFile("test-correct-file-", ".txt", new File("files"));
        incorrectDataFile = File.createTempFile("test-incorrect-file-", ".txt", new File("files"));
        FileWriter writer = new FileWriter(correctDataFile);
        writer.write(testCorrectData);
        writer.flush();
        writer.close();
        writer = new FileWriter(incorrectDataFile);
        writer.write(testIncorrectData);
        writer.flush();
        writer.close();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        correctDataFile.delete();
        incorrectDataFile.delete();
    }

    @Test(expectedExceptions = InvalidTriangleParametersException.class)
    public void testCreateTriangle() throws Exception {
        Point a = new Point(0, 0);
        Point b = new Point(1, 1);
        Point c = new Point(2, 2);
        Triangle t = TriangleFactory.createTriangle(a, b, c);
    }

    @Test
    public void testCreateTriangles() throws Exception {

        List<String> trianglesStr = TriangleReader.readTriangles(correctDataFile.getPath());
        TriangleFactory.createTriangles(trianglesStr);

    }

    @Test
    public void testCreateTrianglesInvalidData() throws Exception {
        List<String> trianglesStr = TriangleReader.readTriangles(incorrectDataFile.getPath());
        TriangleFactory.createTriangles(trianglesStr);
    }
}