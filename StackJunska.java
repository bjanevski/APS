import java.util.*;

public class StackJunska {

    static boolean checkIfEqual(int a, int b, int c) {
        if ((a == b) && (b == c))
            return true;
        else
            return false;
    }

    static int highestValue(int a, int b, int c) {
        int max = a;

        if (b > c) {
            if (b > a) {
                max = b;
            }
        } else {
            if (c > a) {
                max = c;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String size = scanner.nextLine();
        String[] sizes = size.split(" ");

        int n1 = Integer.parseInt(sizes[0]);
        int n2 = Integer.parseInt(sizes[1]);
        int n3 = Integer.parseInt(sizes[2]);

        ArrayStack<Integer> stack1 = new ArrayStack<>(n1);
        ArrayStack<Integer> stack2 = new ArrayStack<>(n2);
        ArrayStack<Integer> stack3 = new ArrayStack<>(n3);

        String elements1 = scanner.nextLine();
        String elements2 = scanner.nextLine();
        String elements3 = scanner.nextLine();

        String[] elem1 = elements1.split(" ");
        String[] elem2 = elements2.split(" ");
        String[] elem3 = elements3.split(" ");

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();

        for (String s : elem1) {
            sb1.append(s);
        }

        for (String s : elem2) {
            sb2.append(s);
        }

        for (String s : elem3) {
            sb3.append(s);
        }

        String s1 = sb1.reverse().toString();
        String s2 = sb2.reverse().toString();
        String s3 = sb3.reverse().toString();

        String[] e1 = s1.split("");
        String[] e2 = s2.split("");
        String[] e3 = s3.split("");

        int visina1 = 0;
        int visina2 = 0;
        int visina3 = 0;

        for (String s : e1) {
            stack1.push(Integer.parseInt(s));
            visina1 += Integer.parseInt(s);
        }

        for (String s : e2) {
            stack2.push(Integer.parseInt(s));
            visina2 += Integer.parseInt(s);
        }

        for (String s : e3) {
            stack3.push(Integer.parseInt(s));
            visina3 += Integer.parseInt(s);
        }

        //Algorithm
        if (checkIfEqual(visina1, visina2, visina3)) {
            System.out.println(visina1);

        } else {
            int highest = highestValue(visina1, visina2, visina3);

        }


    }
}










