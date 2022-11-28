import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FindPlayersWithZeroOrOneLosses {
    
    public static List<List<Integer>> findWinners(int[][] matches) {
        List<Integer> unbeaten = new ArrayList<>();
        List<Integer> lostOnce = new ArrayList<>();

        boolean[] winners = new boolean[100001];
        Arrays.fill(winners, Boolean.FALSE);

        short[] losers = new short[100001];
        Arrays.fill(losers, (short) 0);

        for (int i=0; i<matches.length; i++) {
            winners[matches[i][0]] = true;
        }

        for (int i=0; i<matches.length; i++) {
            winners[matches[i][1]] = false;
            losers[matches[i][1]] = (short) (losers[matches[i][1]]+1);
        }

        for (int i=1; i<100001; i++) {
            if (winners[i] == true) {
                unbeaten.add(i);
            } else if (losers[i] == 1) {
                lostOnce.add(i);
            }
        }
        return List.of(unbeaten,lostOnce);
    }

    public static void main(String[] args) {
        int[][] arr = {{1,5},{2,5},{2,8},{2,9},{3,8},{4,7},{4,9},{5,7},{6,8}};
        List<List<Integer>> result = FindPlayersWithZeroOrOneLosses.findWinners(arr);
        System.out.print("Unbeaten = ");
        for (int i : result.get(0)) {
            System.out.print(":" + i);
        }
        System.out.println("");
        System.out.print("Lost once only = ");
        for (int i : result.get(1)) {
            System.out.print(":" + i);
        }
    }
}
