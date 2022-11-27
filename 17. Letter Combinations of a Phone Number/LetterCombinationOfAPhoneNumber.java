import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class LetterCombinationOfAPhoneNumber {
    static Map<Character,List<Character>> characterMap = Map.of(
        '2', List.of('a','b','c'),
        '3', List.of('d','e','f'),
        '4', List.of('g','h','i'),
        '5', List.of('j','k','l'),
        '6', List.of('m','n','o'),
        '7', List.of('p','q','r','s'),
        '8', List.of('t','u','v'),
        '9', List.of('w','x','y','z'));
        static List<String> result = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        } 
        List<String> iterationResult = new ArrayList<>();
        List<Character> newChars = characterMap.get(digits.charAt(0));
        for (Character c : newChars) {
            if (result.size() != 0){
                for (int i = 0; i < result.size(); i++) {
                    iterationResult.add(result.get(i)+c);
                }
            } else {
                iterationResult.add(String.valueOf(c));
            }
        }
        result = iterationResult;
        return LetterCombinationOfAPhoneNumber.letterCombinations(digits.substring(1));
    }


    public static void main (String[] args) {
        List<String> list = LetterCombinationOfAPhoneNumber.letterCombinations("2");
        for (String s : list) {
            System.out.println(s);
        }
    }
}