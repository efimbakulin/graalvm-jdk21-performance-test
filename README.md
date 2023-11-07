This project compares the peformance of GraalVM ce-java17-22.3.3 and GraalVM for JDK-21.

It runs a simple test with multiple invocations of `JSON.parse` and `JSON.stringify` and prints the execution summary to stdout.


```
docker compose run graalvm-example-22.3.3
```

```
warming up
....................................................................................................
Iterations: 100000
Duration: 125.514641
Score: 796.719788 ops/second

testing
....................................................................................................
Iterations: 10000
Duration: 12.805132
Score: 780.936890 ops/second
```

```
docker compose run graalvm-example-jdk21
```

```
warming up
....................................................................................................
Iterations: 100000
Duration: 157.155243
Score: 636.313477 ops/second

testing
....................................................................................................
Iterations: 10000
Duration: 15.578632
Score: 641.904846 ops/second
```
