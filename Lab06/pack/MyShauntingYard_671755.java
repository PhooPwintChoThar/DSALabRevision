package Lab06.pack;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class MyShauntingYard_671755 {
    public static String infixToPostfix(String infixString) {
        Stack<String> operatorContainer = new Stack<>();
        StringBuilder post = new StringBuilder();
        StringTokenizer s = new StringTokenizer(infixString);
        
        while (s.hasMoreTokens()) {
            String item = s.nextToken();
            
            if (isNumber(item)) {
                post.append(item).append(" "); 
            } else if (isOperator(item)) {
                while (!operatorContainer.isEmpty() && 
                       !operatorContainer.peek().equals("(") &&
                       order(operatorContainer.peek()) >= order(item)) {
                    post.append(operatorContainer.pop()).append(" ");
                }
                operatorContainer.push(item);
            } else if (item.equals("(")) {
                operatorContainer.push(item);
            } else if (item.equals(")")) {
                while (!operatorContainer.isEmpty() && !operatorContainer.peek().equals("(")) {
                    post.append(operatorContainer.pop()).append(" ");
                }
                if (!operatorContainer.isEmpty()) {
                    operatorContainer.pop();
                }
            } else {
                continue; 
            }
        }
        
        while (!operatorContainer.isEmpty()) {
            post.append(operatorContainer.pop());
        }
        
        return post.toString();
    }
    
    private static Boolean isOperator(String o) {
        switch (o) {
            case "+", "-", "*", "/": 
                return true;
            default:
                return false;
        }
    }
    
    private static int order(String s) {
        switch (s) {
            case "+", "-":
                return 1;
            case "*", "/":
                return 2;
            default:
                return 0;
        }
    }
    
    private static Boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        Pattern p = Pattern.compile("\\d+(\\.\\d+)?"); // Handles integers and decimals
        return p.matcher(s).matches();
    }
}