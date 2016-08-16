package threadmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Main {

    final String[] patterns = {"nnonnoo", "nnonono", "nnnoono", "nnnonoo",
            "nnnnooo"};
    final String ops = "+-*/^";

    String solution;
    List<Integer> digits;

    public static void main(String[] args) {
        while (true) {
            new Main().play();
        }
    }

    void play() {
        Scanner in = new Scanner(System.in);
        System.out.print("> ");
        String line = in.nextLine();
        String[] numbers = line.split(",");
        List<Integer> nums = new ArrayList<Integer>();
        for (String num : numbers) {
            nums.add(Integer.valueOf(num));
        }
        digits = getSolvableDigits(nums);
        if (digits.size() > 0) {
            System.out.println("the result:" + solution);
        } else {
            System.out.println("error numbers");
        }
    }

    boolean evaluate(char[] line) throws Exception {
        Stack<Float> s = new Stack<Float>();
        try {
            for (char c : line) {
                if ('0' <= c && c <= '9')
                    s.push((float) c - '0');
                else
                    s.push(applyOperator(s.pop(), s.pop(), c));
            }
        } catch (EmptyStackException e) {
            throw new Exception("Invalid entry.");
        }
        return (Math.abs(24 - s.peek()) < 0.001F);
    }

    float applyOperator(float a, float b, char c) {
        switch (c) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                return b / a;
            default:
                return Float.NaN;
        }
    }

    List<Integer> getSolvableDigits(List<Integer> integers) {
        if (isSolvable(integers)) {
            return integers;
        } else {
            return new ArrayList<Integer>();
        }
    }

    boolean isSolvable(List<Integer> digits) {
        Set<List<Integer>> dPerms = new HashSet<List<Integer>>(4 * 3 * 2);
        permute(digits, dPerms, 0);

        int total = 4 * 4 * 4;
        List<List<Integer>> oPerms = new ArrayList<List<Integer>>(total);
        permuteOperators(oPerms, 4, total);

        StringBuilder sb = new StringBuilder(4 + 3);

        for (String pattern : patterns) {
            char[] patternChars = pattern.toCharArray();

            for (List<Integer> dig : dPerms) {
                for (List<Integer> opr : oPerms) {

                    int i = 0, j = 0;
                    for (char c : patternChars) {
                        if (c == 'n')
                            sb.append(dig.get(i++));
                        else
                            sb.append(ops.charAt(opr.get(j++)));
                    }

                    String candidate = sb.toString();
                    try {
                        if (evaluate(candidate.toCharArray())) {
                            solution = postfixToInfix(candidate);
                            return true;
                        }
                    } catch (Exception ignored) {
                    }
                    sb.setLength(0);
                }
            }
        }
        return false;
    }

    String postfixToInfix(String postfix) {
        class Expression {
            String op, ex;
            int prec = 3;

            Expression(String e) {
                ex = e;
            }

            Expression(String e1, String e2, String o) {
                ex = String.format("%s %s %s", e1, o, e2);
                op = o;
                prec = ops.indexOf(o) / 2;
            }
        }

        Stack<Expression> expr = new Stack<Expression>();

        for (char c : postfix.toCharArray()) {
            int idx = ops.indexOf(c);
            if (idx != -1) {

                Expression r = expr.pop();
                Expression l = expr.pop();

                int opPrec = idx / 2;

                if (l.prec < opPrec)
                    l.ex = '(' + l.ex + ')';

                if (r.prec <= opPrec)
                    r.ex = '(' + r.ex + ')';

                expr.push(new Expression(l.ex, r.ex, "" + c));
            } else {
                expr.push(new Expression("" + c));
            }
        }
        return expr.peek().ex;
    }

    void permute(List<Integer> lst, Set<List<Integer>> res, int k) {
        for (int i = k; i < lst.size(); i++) {
            Collections.swap(lst, i, k);
            permute(lst, res, k + 1);
            Collections.swap(lst, k, i);
        }
        if (k == lst.size())
            res.add(new ArrayList<Integer>(lst));
    }

    void permuteOperators(List<List<Integer>> res, int n, int total) {
        for (int i = 0, npow = n * n; i < total; i++)
            res.add(Arrays.asList((i / npow), (i % npow) / n, i % n));
    }
}



