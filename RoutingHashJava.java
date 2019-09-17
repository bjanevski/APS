import java.util.*;

public class RoutingHashJava {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> hashtable = new HashMap<>();
        int N = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < N; i++)
            hashtable.put(scanner.nextLine(), scanner.nextLine());

        N = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < N; i++) {

            String tester = scanner.nextLine();
            String[] parts = scanner.nextLine().split("\\.");
            boolean flag = false;

            if (!hashtable.containsKey(tester))
                System.out.println("ne postoi");

            else {
                String[] temp = hashtable.get(tester).split("\\,");

                for (int j = 0; j < temp.length; j++) {
                    String[] address = temp[j].split("\\.");
                    if (address[0].equals(parts[0]) && address[1].equals(parts[1]) && address[2].equals(parts[2]))
                        flag = true;
                }
                if (flag)
                    System.out.println("postoi");
                else
                    System.out.println("ne postoi");
            }
        }

        scanner.close();
    }
}