package org.example;

import org.example.Alphabet;
import org.example.Generator;
import org.example.Password;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class PasswordBenchmark {

    @Benchmark
    @Fork(value = 2)
    @Measurement(iterations = 5,time=1)
    @Warmup(iterations =3, time = 1)
    public void passwordGeneration() {
        Generator generator = new Generator(true,false,false,false);
        generator.GeneratePassword(10);

    }

    @Benchmark
    @Fork(value = 2)
    @Measurement(iterations = 5,time=1)
    @Warmup(iterations =3, time = 1)
    public void passwordStrength() {
        Password password= new Password("Secret");
        password.PasswordStrength();
    }

}
