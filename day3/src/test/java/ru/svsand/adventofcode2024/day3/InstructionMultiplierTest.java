package ru.svsand.adventofcode2024.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InstructionMultiplierTest {

    private final String Example = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))";
    private final InstructionMultiplier multiplier = new InstructionMultiplier(Example);

    @Test
    void multiply() {
        Assertions.assertEquals(161, multiplier.multiply());
    }

    @Test
    void multiplyEnabled() {
        Assertions.assertEquals(48, multiplier.multiplyEnabled());
    }
}