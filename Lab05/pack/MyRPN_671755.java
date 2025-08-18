package Lab05.pack;
import java.util.StringTokenizer;
import java.util.regex.Pattern;


public class MyRPN_671755 {
        private static Pattern pattern=Pattern.compile("-?\\d+(\\.\\d+)?");
        public static boolean isNumeric(String strNum){
            if(strNum==null){
                return false;
            }
            return pattern.matcher(strNum).matches();
        }

        public static double computeRPN(String rpn){
            MyStack_671755<Double> stack=new MyStack_671755<>();
            StringTokenizer s=new StringTokenizer(rpn);
            while(s.hasMoreTokens()){
                String text=s.nextToken();
                if(isNumeric(text)){
                    stack.push(Double.parseDouble(text));
                }else{
                    Double num2=stack.pop();
                    Double num1=stack.pop();
                    Double result;

                    switch (text){
                        case "+":
                        result=num1+num2;
                        break;

                        case "-":
                        result=num1-num2;
                        break;

                        case "*":
                        result=num1*num2;
                        break;

                        case "/":
                        result=num1/num2;
                        break;

                        default:
                        result=0.00;
                    }

                    stack.push(result);
                }
            }

            return stack.pop();

        }
}
