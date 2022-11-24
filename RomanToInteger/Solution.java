
class Solution {
    public static int romanToInt(String s) {
        char[] keys = new char[] {'I', 'V', 'X',  'L',  'C',   'D',  'M'};
        int[] values = new int[] { 1,   5,   10,   50,   100,  500,  1000};

        int count = 0;
        boolean skip = false;
        for (int i = 0; i<s.length(); i++){
            if (skip) {
                skip = !skip;
                continue;
            }
            char foundCharacter = s.charAt(i);
            int keyPosition = new String(keys).indexOf(foundCharacter);
            int value = values[keyPosition];

            if (keyPosition%2==0 && keyPosition!=values.length-1 && i!=s.length()-1) {                
                if (s.charAt(i+1) == keys[keyPosition+1]) {
                    int nextValue = values[keyPosition+1];
                    value = nextValue - value;
                    skip = !skip;
                }else if (s.charAt(i+1) == keys[keyPosition+2]) {
                    int nextValue = values[keyPosition+2];
                    value = nextValue - value;
                    skip = !skip;
                }
            } 
            count += value;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(Solution.romanToInt(s));
    }
}