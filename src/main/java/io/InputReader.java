package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public interface InputReader {
    String readLine() throws IOException;

    BufferedReader getReader();

    List<String> readGrid(int rows) throws IOException;
}
