import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Dota2Senate {

    public static String predictPartyVictory(String senate) {
        Queue<Integer> radiantQueue = new LinkedList<>();
        Queue<Integer> direQueue = new LinkedList<>();

        boolean[] votingRight = new boolean[senate.length()];
        Arrays.fill(votingRight, true);

        int cursor = 0;
        while (cursor < senate.length()) {
            if (senate.charAt(cursor) == 'R') {
                radiantQueue.add(cursor);
            } else {
                direQueue.add(cursor);
            }
            cursor++;
        }
        cursor = 0;
        while (!direQueue.isEmpty() && !radiantQueue.isEmpty()) {
            while (cursor < senate.length()) {
                Character currentChar = senate.charAt(cursor);
                if (votingRight[cursor++] == false) {
                    continue;
                } else if (currentChar.equals('R')) {
                    if (direQueue.isEmpty()) {
                        return "Radiant";
                    } else {
                        int removedValue = direQueue.remove();
                        votingRight[removedValue] = false;
                    }
                } else if (currentChar.equals('D')) {
                    if (radiantQueue.isEmpty()) {
                        return "Dire";
                    } else {
                        int removedValue = radiantQueue.remove();
                        votingRight[removedValue] = false;
                    }
                }
            }
            cursor = 0;
        }
        return direQueue.isEmpty() ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {
        String result = Dota2Senate.predictPartyVictory(Dota2Senate.getRandomString());
        System.out.println(result);
    }

    public static String getRandomString() {
        String SALTCHARS = "RD";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        System.out.println("String =" + saltStr);
        return saltStr;
    }
}