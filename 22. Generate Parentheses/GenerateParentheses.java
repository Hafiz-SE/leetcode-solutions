import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class GenerateParentheses {
    static List<String> parentheses = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        GenerateParentheses.generate(new StringBuilder(),0,0,0,n,list);
        return list;
    }

    public static void generate(StringBuilder builder, int startBracket, int endBracket, int index, int n, List<String> list) {
            if (builder.length() == n * 2) {
                list.add(String.valueOf(builder));
                return;
            } 
            if (startBracket < n) {
                builder.append('(');
                generate(builder, startBracket+1, endBracket, index, n, list);
                builder.deleteCharAt(builder.length() - 1);
            }
            if (endBracket < startBracket) {
                builder.append(')');
                generate(builder, startBracket, endBracket+1, index, n, list);
                builder.deleteCharAt(builder.length() -1);
            }
    }

    
    

    public static void main(String[] args) {
       List<String> test =  GenerateParentheses.generateParenthesis(3);
       for (String s : test) {
        System.out.println(s);
       }
    }
}
