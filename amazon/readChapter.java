public class readChapter {
    public static int getMinPages(int[] pages, int days) {
        int start = 0, end = 0;
        for (int page : pages) {
            end = Math.max(end, page);
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (getPage(pages, mid) <= days) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (getPage(pages, start) <= days) {
            return start;
        }
        if (getPage(pages, end) <= days) {
            return end;
        }
        return -1;
    }

    private static int getPage(int[] pages, double speed) {
        int days = 0;
        for (int page : pages) {
            days += Math.ceil(page / speed);
        }
        return days;
    }
}
