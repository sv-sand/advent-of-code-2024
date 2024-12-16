package ru.svsand.adventofcode2024.day7;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 07.12.2024
 */

public class Equation {
    @Getter @Setter
    private long result;
    @Getter @Setter
    private ArrayList<Integer> values = new ArrayList<>();

    public boolean isValid() {
        ArrayList<Integer> newValues = (ArrayList<Integer>) values.clone();
        newValues.remove(0);

        return isValidRecurse(values.get(0), newValues);
    }

    private boolean isValidRecurse(long currentResult, ArrayList<Integer> currentValues) {
        if (currentValues.size() == 0)
            return currentResult == result;

        ArrayList<Integer> newValues = (ArrayList<Integer>) currentValues.clone();
        newValues.remove(0);

        if (isValidRecurse(currentResult + currentValues.get(0), newValues))
            return true;

        if (isValidRecurse(currentResult * currentValues.get(0), newValues))
            return true;

        return false;
    }

    public boolean isValidWithConcatenation() {
        ArrayList<Integer> newValues = (ArrayList<Integer>) values.clone();
        newValues.remove(0);

        return isValidRecurseWithConcatenation(values.get(0), newValues);
    }

    private boolean isValidRecurseWithConcatenation(long currentResult, ArrayList<Integer> currentValues) {
        if (currentValues.size() == 0)
            return currentResult == result;

        ArrayList<Integer> newValues = (ArrayList<Integer>) currentValues.clone();
        newValues.remove(0);

        if (isValidRecurseWithConcatenation(currentResult + currentValues.get(0), newValues))
            return true;

        if (isValidRecurseWithConcatenation(currentResult * currentValues.get(0), newValues))
            return true;

        String concatenated = String.valueOf(currentResult) + String.valueOf(currentValues.get(0));
        if (isValidRecurseWithConcatenation(Long.parseLong(concatenated), newValues))
            return true;

        return false;
    }
}
