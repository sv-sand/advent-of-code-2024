import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReportAnalyzerTest {

    @Test
    void loadReport() {
        ReportAnalyzer analyzer = new ReportAnalyzer();

        String[] data1 = {"7", "6", "4", "2", "1"};
        Assertions.assertDoesNotThrow(
                () -> analyzer.loadReport(data1)
        );

        String[] data2 = {"q"};
        Assertions.assertThrows(NumberFormatException.class,
                () -> analyzer.loadReport(data2)
        );
    }

    @Test
    void isReportSafe() {
        ReportAnalyzer analyzer = new ReportAnalyzer();

        String[] data1 = {"7", "6", "4", "2", "1"};
        analyzer.loadReport(data1);
        Assertions.assertTrue(analyzer.isReportSafe(), "line 1: 7 6 4 2 1");

        String[] data2 = {"1", "2", "7", "8", "9"};
        analyzer.loadReport(data2);
        Assertions.assertFalse(analyzer.isReportSafe(), "line 2: 1 2 7 8 9");

        String[] data3 = {"9", "7", "6", "2", "1"};
        analyzer.loadReport(data3);
        Assertions.assertFalse(analyzer.isReportSafe(), "line 3: 9 7 6 2 1");

        String[] data4 = {"1", "3", "2", "4", "5"};
        analyzer.loadReport(data4);
        Assertions.assertFalse(analyzer.isReportSafe(), "line 4: 1 3 2 4 5");

        String[] data5 = {"8", "6", "4", "4", "1"};
        analyzer.loadReport(data5);
        Assertions.assertFalse(analyzer.isReportSafe(), "line 5: 8 6 4 4 1");

        String[] data6 = {"1", "3", "6", "7", "9"};
        analyzer.loadReport(data6);
        Assertions.assertTrue(analyzer.isReportSafe(), "line 6: 1 3 6 7 9");
    }

    @Test
    void isReportSafeWithOneError() {
        ReportAnalyzer analyzer = new ReportAnalyzer();

        // Original test
        String[] data1 = {"7", "6", "4", "2", "1"};
        analyzer.loadReport(data1);
        Assertions.assertTrue(analyzer.isReportSafeWithOneError(), "line 1: 7 6 4 2 1");

        String[] data2 = {"1", "2", "7", "8", "9"};
        analyzer.loadReport(data2);
        Assertions.assertFalse(analyzer.isReportSafeWithOneError(), "line 2: 1 2 7 8 9");

        String[] data3 = {"9", "7", "6", "2", "1"};
        analyzer.loadReport(data3);
        Assertions.assertFalse(analyzer.isReportSafeWithOneError(), "line 3: 9 7 6 2 1");

        String[] data4 = {"1", "3", "2", "4", "5"};
        analyzer.loadReport(data4);
        Assertions.assertTrue(analyzer.isReportSafeWithOneError(), "line 4: 1 3 2 4 5");

        String[] data5 = {"8", "6", "4", "4", "1"};
        analyzer.loadReport(data5);
        Assertions.assertTrue(analyzer.isReportSafeWithOneError(), "line 5: 8 6 4 4 1");

        String[] data6 = {"1", "3", "6", "7", "9"};
        analyzer.loadReport(data6);
        Assertions.assertTrue(analyzer.isReportSafeWithOneError(), "line 6: 1 3 6 7 9");

        // Additional tests

        // Right
        String[] data7 = {"1", "2", "4", "7"};
        analyzer.loadReport(data7);
        Assertions.assertTrue(analyzer.isReportSafeWithOneError(), "line 7");

        String[] data8 = {"7", "4", "2", "1"};
        analyzer.loadReport(data8);
        Assertions.assertTrue(analyzer.isReportSafeWithOneError(), "line 8");

        // Exclude 1
        String[] data9 = {"3", "2", "3", "4"};
        analyzer.loadReport(data9);
        Assertions.assertTrue(analyzer.isReportSafeWithOneError(), "line 9");

        String[] data10 = {"1", "5", "6", "7"};
        analyzer.loadReport(data10);
        Assertions.assertTrue(analyzer.isReportSafeWithOneError(), "line 10");

        String[] data11 = {"2", "1", "5", "6"};
        analyzer.loadReport(data11);
        Assertions.assertTrue(analyzer.isReportSafeWithOneError(), "line 11");

        // Exclude 4
        String[] data12 = {"1", "2", "3", "3"};
        analyzer.loadReport(data12);
        Assertions.assertTrue(analyzer.isReportSafeWithOneError(), "line 12");

        String[] data13 = {"1", "2", "3", "2"};
        analyzer.loadReport(data13);
        Assertions.assertTrue(analyzer.isReportSafeWithOneError(), "line 13");

        String[] data14 = {"1", "2", "3", "7"};
        analyzer.loadReport(data14);
        Assertions.assertTrue(analyzer.isReportSafeWithOneError(), "line 14");

        String[] data15 = {"1", "2", "2", "4"};
        analyzer.loadReport(data15);
        Assertions.assertTrue(analyzer.isReportSafeWithOneError(), "line 15");

        String[] data16 = {"1", "2", "1", "4"};
        analyzer.loadReport(data16);
        Assertions.assertTrue(analyzer.isReportSafeWithOneError(), "line 16");
    }
}