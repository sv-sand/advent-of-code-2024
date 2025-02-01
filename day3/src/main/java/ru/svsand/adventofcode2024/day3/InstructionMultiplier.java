package ru.svsand.adventofcode2024.day3;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 01.02.2025
 */

public class InstructionMultiplier {

    private final String text;

    public InstructionMultiplier(String text) {
        this.text = text;
    }

    long multiply() {
        Pattern pattern = Pattern.compile("mul\\(\\d+,\\d+\\)");
        Matcher matcher = pattern.matcher(text);

        ArrayList<String> instructions = new ArrayList<>();
        while (matcher.find())
            instructions.add(text.substring(matcher.start(), matcher.end()));

        return multiplyInstructions(instructions);
    }

    long multiplyEnabled() {
        Pattern pattern = Pattern.compile("mul\\(\\d+,\\d+\\)|do\\(\\)|don\'t\\(\\)");
        Matcher matcher = pattern.matcher(text);

        boolean isEnabled = true;
        ArrayList<String> instructions = new ArrayList<>();
        while (matcher.find()) {
            String instruction = text.substring(matcher.start(), matcher.end());

            if (instruction.equals("do()"))
                isEnabled = true;

            if (instruction.equals("don't()"))
                isEnabled = false;

            if (isEnabled && !instruction.equals("do()") && !instruction.equals("don't()"))
                instructions.add(instruction);
        }

        return multiplyInstructions(instructions);
    }

    private long multiplyInstructions(ArrayList<String> instructions) {
        long result = 0;

        for (String instruction: instructions) {
            String data = instruction.substring(4, instruction.length() - 1);
            String[] array = data.split(",");

            int mul1 = Integer.parseInt(array[0]);
            int mul2 = Integer.parseInt(array[1]);
            result += mul1 * mul2;
        }
        return result;
    }
}
