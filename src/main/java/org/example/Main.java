package org.example;

import java.util.Map;

import org.graalvm.polyglot.*;

public class Main {

    private static Context createContext() {

        var options = Map.of(
                "js.commonjs-require", "true",
                "js.commonjs-require-cwd", "src/main");

        return Context.newBuilder("js")
                .allowAllAccess(false)
                .allowExperimentalOptions(true)
                .allowHostAccess(HostAccess.ALL)
                .options(options)
                .allowIO(true)
                .build();
    }

    private static void runTest(Value value, String phase, int iterations) {
        System.out.println(phase);

        var start = System.nanoTime();
        var progressStep = iterations / 100;

        for (int i = 0; i < iterations; i++) {
            value.getMember("jsonParseStringify").execute();

            if (i % progressStep == 0) {
                System.out.print(".");
            }
        }

        var stop = System.nanoTime();

        System.out.println("");

        var durationSeconds = (stop - start) / 1_000_000_000f;

        System.out.println("Iterations: %d".formatted(iterations));
        System.out.println("Duration: %f".formatted(durationSeconds));
        System.out.println("Score: %f ops/second".formatted(iterations / durationSeconds));
    }

    public static void testParseStringify() {
        var ctx = createContext();

        Value value = ctx.eval("js", "require('./js');");

        final var warmupIterations = 100_000;
        final var testIterations = 10_000;

        runTest(value, "warming up", warmupIterations);
        runTest(value, "testing", testIterations);
    }

    public static void main(String[] args) {
    }
}
