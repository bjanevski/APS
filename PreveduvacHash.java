import java.util.HashMap;
import java.util.Scanner;

public class PreveduvacHash {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        HashMap<String, String> hashtable = new HashMap<>();
        String string = null;

        for (int i = 0; i < N; i++) {
            string = scanner.nextLine();
            String[] strings = string.split(" ");
            hashtable.put(strings[1], strings[0]);
        }

        string = scanner.nextLine();

        while (!string.contentEquals("KRAJ")) {
            if (hashtable.containsKey(string)) {
                System.out.println(hashtable.get(string));
            } else {
                System.out.println("/");
            }

            string = scanner.nextLine();
        }

    }
}
