import java.util.*;

public class PostfixStack {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] str = input.split(" ");

        ArrayStack<Integer> stack = new ArrayStack<>(50);

        for (String s : str) {
            if (Character.isDigit(s.charAt(0))) {
                stack.push(Integer.parseInt(s));
            } else if (s.charAt(0) == '+') {
                stack.push(stack.pop() + stack.pop());
            } else if (s.charAt(0) == '-') {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 - num1);
            } else if (s.charAt(0) == '/') {
                int num1 = stack.pop();
                if (num1 == 0) {
                    throw new Exception("Delenje so 0!!!");
                }
                int num2 = stack.pop();
                stack.push(num2 / num1);
            } else if (s.charAt(0) == '*') {
                stack.push(stack.pop() * stack.pop());
            }
        }

        System.out.println(stack.pop());
    }

}

