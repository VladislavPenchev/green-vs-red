import core.Engine;
import core.impl.GameEngine;
import io.InputReader;
import io.OutputWriter;
import io.impl.ConsoleReader;
import io.impl.ConsoleWriter;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();
        Engine engine = new GameEngine(reader, writer);
        engine.start();
    }
}
