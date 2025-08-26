package Lab05;

import java.util.Stack;

public class Soution_671755 {

    public static void main(String[] args){
        // String s="ab##";
        // String t="c#d#";

        // String s="a#c";
        // String t="b";

        String s="ab#c";
        String t="ad#c";

        boolean a=backspaceCompare(s,t);
        System.out.println(a);

    }

    public static boolean backspaceCompare (String s, String t){
        Stack<Character> s1= new Stack<>();
        Stack<Character> s2= new Stack<>();
        for(int i=0; i<s.length(); i++){
            if (s.charAt(i)=='#'){
                s1.pop();
                continue;
            }
            s1.push(s.charAt(i));
        }

        for(int j=0; j<t.length(); j++){
            if (t.charAt(j)=='#'){
                s2.pop();
                continue;
            }
            s2.push(t.charAt(j));
        }

        return s1.equals(s2);
    }
    
}
