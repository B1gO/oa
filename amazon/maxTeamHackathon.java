import java.util.Arrays;

public class maxTeamHackathon {
    public static int getMaxTeams(int[] skill, int teamSize, int maxDiff) {
        Arrays.sort(skill);
        int len = skill.length;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (skill[i] + maxDiff >= skill[i + teamSize - 1]) {
                cnt++;
                i = i + teamSize - 1;
            }
        }
        return cnt;
    }
}
