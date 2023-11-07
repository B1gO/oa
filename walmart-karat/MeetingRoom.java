

public class MeetingRoom {
    public static void main(String[] args) {
        int[][] meetings = new int[][]{
                {1300, 1500}, {930, 1200}, {830, 845}
        };
        boolean res1 = addNewMeeting(meetings, 820, 830);
        boolean res2 = addNewMeeting(meetings, 1450, 1500);
        System.out.println(res1 + " " + res2);
    }

    public static boolean addNewMeeting(int[][] meetings, int start, int end) {
        for (int[] meeting : meetings) {
            if ((start >= meeting[0] && end <= meeting[1]) ||
                    (start < meeting[0] && end > meeting[0]) ||
                    (start <  meeting[1] && end > meeting[1])) {
                return false;
            }
        }
        return true;
    }
}
