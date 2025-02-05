package ru.svsand.adventofcode2024.day7;

import java.util.ArrayList;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 05.02.2025
 */

public class EquationCounter {
    ArrayList<Equation> equations;

    public EquationCounter(ArrayList<Equation> equations) {
        this.equations = equations;
    }

    public long sumOfValid() {
        long result = 0;
        for (Equation equation: equations) {
            if (equation.isValid())
                result += equation.getResult();
        }
        return result;
    }

    public long sumOfValidWithConcatenation() {
        long result = 0;
        for (Equation equation: equations) {
            if (equation.isValidWithConcatenation())
                result += equation.getResult();
        }
        return result;
    }
}
