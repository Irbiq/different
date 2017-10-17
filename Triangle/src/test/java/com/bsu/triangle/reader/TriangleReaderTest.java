package com.bsu.triangle.reader;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;

/**
 * Created by ASUS on 15.10.2017.
 */
public class TriangleReaderTest {

    File file;

    String testData = "0 0 0 1 1 0\n" +
            "0 0 0 2 2 0\n" +
            "1 1 1 2 3 3\n";

    @BeforeMethod
    public void setUp() throws Exception {
        file = File.createTempFile("test-file-", ".txt", new File("files"));
        FileWriter writer = new FileWriter(file);
        writer.write(testData);
        writer.flush();
        writer.close();

    }

    @AfterMethod
    public void tearDown() throws Exception {
        file.delete();
    }

    @Test
    public void testReadTriangles() throws Exception {
        TriangleReader.readTriangles(file.getPath());
    }

}