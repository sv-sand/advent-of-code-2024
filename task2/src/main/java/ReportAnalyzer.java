import java.util.ArrayList;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 02.12.2024
 */

public class ReportAnalyzer {
    private ArrayList<Integer> report = new ArrayList<Integer>();

    public void loadReport(String[] list) {
        report.clear();

        for (String item: list)
            report.add(Integer.parseInt(item));
    }

    public boolean isReportSafe() {
        return findError(report) == -1;
    }

    public boolean isReportSafeWithOneError() {
        int indexOriginalError = findError(report);
        if (indexOriginalError == -1)
            return true;

        // Try to remove level before error
        ArrayList<Integer> reportReducedBeforeError = new ArrayList<>(report);
        reportReducedBeforeError.remove(indexOriginalError);
        int indexErrorBefore = findError(reportReducedBeforeError);
        if (indexErrorBefore == -1)
            return true;

        // Try to remove level after error
        ArrayList<Integer> reportReducedAfterError = new ArrayList<>(report);
        reportReducedAfterError.remove(indexOriginalError + 1);
        int indexErrorAfter = findError(reportReducedAfterError);
        if (indexErrorAfter == -1)
            return true;

        return false;
    }

    public int findError(ArrayList<Integer> currentReport) {
        if (currentReport.size() <= 1)
            return -1;

        int commonTrend = trend(currentReport);
        if (commonTrend == 0)
            return 0;

        for (int i = 0; i < currentReport.size() - 1; i++) {
            int previousItem = currentReport.get(i);
            int currentItem = currentReport.get(i + 1);

            if (!checkTrend(previousItem, currentItem, commonTrend) || !checkDifference(previousItem, currentItem))
                return i;
        }
        return -1;
    }

    boolean checkTrend(int previousItem, int currentItem, int commonTrend) {
        int trend = 0;
        if (previousItem < currentItem)
            trend = 1;
        else if (previousItem > currentItem)
            trend = -1;

        return trend == commonTrend;
    }

    boolean checkDifference(int previousItem, int currentItem) {
        return Math.max(previousItem - currentItem, currentItem - previousItem) <= 3;
    }

    private int trend(ArrayList<Integer> currentReport) {
        int result = 0;

        for (int i = 0; i < currentReport.size() - 1; i++) {
            if (currentReport.get(i) < currentReport.get(i + 1))
                result++;
            else if (currentReport.get(i) > currentReport.get(i + 1))
                result--;
        }

        if (result > 0)
            return 1;
        else if (result < 0)
            return -1;
        else
            return 0;
    }

}
