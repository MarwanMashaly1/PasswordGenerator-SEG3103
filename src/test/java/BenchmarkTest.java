
import org.example.PasswordBenchmark;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkTest {

    @Test
    public void testBenchMark() throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(".*" + PasswordBenchmark.class.getSimpleName() + ".*")
                .measurementIterations(2)
                .build();

        new Runner(opt).run();
    }
}
