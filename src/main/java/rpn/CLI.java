package rpn;

import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    private static double recursiveCalculator(Stack<String> pile) {
        if (pile.empty()) return 0;
        String poped = pile.pop();
        if (poped.equals("*") || poped.equals("/") || poped.equals("+") || poped.equals("-")) {
            double right = recursiveCalculator(pile);
            double left = recursiveCalculator(pile);
            switch(poped.charAt(0)){
                case '*':
                    return left * right;
                case '/':
                    return left / right;
                case '+':
                    return left + right;
                case '-':
                    return left - right;
            }
            return 0;
        } else {
            return Double.parseDouble(poped);
        }
    }

    public static void main(String []args) {
        String expression = Stream.of(args).collect(Collectors.joining(" "));

        System.out.println("About to evaluate '" + expression + "'");
        double result = evaluate(expression);
        System.out.println("> " + result);
    }

    static double evaluate(String expression) {
        StringTokenizer in = new StringTokenizer(expression);
        Stack<String> pile = new Stack<String>();
        while (in.hasMoreTokens()) {
            pile.push(in.nextToken());
        }
        return recursiveCalculator(pile);
    }

}
