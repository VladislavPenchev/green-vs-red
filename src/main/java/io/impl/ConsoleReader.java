package io.impl;

import io.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleReader implements InputReader {

    private BufferedReader reader;

    public ConsoleReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() throws IOException {
        return this.reader.readLine();
    }

    @Override
    public BufferedReader getReader() {
        return reader;
    }

    @Override
    public List<String> readGrid(int rows) throws IOException {
        List<String> collectionOfRows = new ArrayList<String>();
        for (int row = 0; row < rows; row++) {
            collectionOfRows.add(reader.readLine());
        }

        return collectionOfRows;
    }

}
