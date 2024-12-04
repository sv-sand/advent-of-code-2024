import java.io.IOException;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 02.12.2024
 */

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Advent of code 2024");
        System.out.println("Day 2: Red-Nosed Reports");

        int countSafeReports = 0;
        int countSafeReportsWithOneError = 0;
        ReportAnalyzer analyzer = new ReportAnalyzer();

        FileParser parser = new FileParser(args[0]);
        while (parser.readLine()) {
            analyzer.loadReport(parser.getData());
            if (analyzer.isReportSafe())
                countSafeReports++;
            if (analyzer.isReportSafeWithOneError())
                countSafeReportsWithOneError++;
        }

        System.out.println("Count safe reports: " + countSafeReports);
        System.out.println("Count safe reports with one error: " + countSafeReportsWithOneError);
    }
}
