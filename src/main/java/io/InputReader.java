package io;

import java.io.BufferedReader;
import java.io.IOException;

public interface InputReader {
    String readLine() throws IOException;

    BufferedReader getReader();
}
