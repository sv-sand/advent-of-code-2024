package ru.svsand.adventofcode2024.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InstructionMultiplierTest {

    String Example = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))";
    InstructionMultiplier multiplier = new InstructionMultiplier(Example);

    @Test
    void multiply() {
        Assertions.assertEquals(multiplier.multiply(), 161);
    }

    @Test
    void multiplyEnabled() {
        Assertions.assertEquals(multiplier.multiplyEnabled(), 48);
    }
}