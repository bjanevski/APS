import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SLLSumofTwoNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        DLL<Integer> list1 = new DLL<>();
        DLL<Integer> list2 = new DLL<>();

        String[] broj1 = input1.split("");
        String[] broj2 = input2.split("");

        int zeros1 = 0;
        int zeros2 = 0;

        if (broj1.length > broj2.length) {
            zeros1 = broj1.length - broj2.length;
            for (String string : broj1) {
                list1.insertLast(Integer.parseInt(string));
            }

            for (String string : broj2) {
                list2.insertLast(Integer.parseInt(string));
            }
        } else {
            zeros2 = broj2.length - broj1.length;
            for (String string : broj2) {
                list1.insertLast(Integer.parseInt(string));
            }

            for (String string : broj1) {
                list2.insertLast(Integer.parseInt(string));
            }
        }

        if (broj1.length > broj2.length) {
            for (int i = 0; i < zeros1; i++) {
                list2.insertFirst(0);
            }
        } else {
            for (int i = 0; i < zeros2; i++) {
                list1.insertFirst(0);
            }
        }

        System.out.println(list1);
        System.out.println(list2);

        DLLNode<Integer> current1 = list1.getLast();
        DLLNode<Integer> current2 = list2.getLast();

        int pamtam = 0;

        while (true) {
            int br1 = 0;
            int br2 = 0;
            int rez = 0;
            int cifra;


            br1 = current1.element;
            br2 = current2.element;

            if ((br1 + br2 + pamtam) >= 10) {

                rez = br1 + br2 + pamtam;
                cifra = rez % 10;
                pamtam = rez / 10;
                current1.element = cifra;

                if ((current1.pred == null) && (pamtam != 0)) {
                    list1.insertFirst(pamtam);
                    break;
                }
            } else {
                current1.element = br1 + br2 + pamtam;
                pamtam = 0;
            }

            if (current1.pred == null) {
                break;
            }

            current1 = current1.pred;
            current2 = current2.pred;
        }

        System.out.println(list1);
    }
}
