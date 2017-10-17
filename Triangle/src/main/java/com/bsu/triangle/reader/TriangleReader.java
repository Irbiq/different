package com.bsu.triangle.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 12.10.2017.
 */
public class TriangleReader {


    private static final Logger LOGGER = LogManager.getLogger(TriangleReader.class);

    public static List<String> readTriangles(String filename) {

        List<String> triangles = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            LOGGER.info("Started reading from file : " + filename);
            reader.lines().forEach(triangles::add);
            LOGGER.info("Finished reading from file : " + filename);
            return triangles;
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return triangles;
    }

}
