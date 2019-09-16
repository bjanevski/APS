import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class LozinkiHashMap {

    class MapEntry<K extends Comparable<K>, E> implements Comparable<K> {
        // Each MapEntry object is a pair consisting of a key (a Comparable object) and a value (an arbitrary object).
        K key;
        E value;

        public MapEntry(K key, E val) {
            this.key = key;
            this.value = val;
        }

        public int compareTo(K that) { // Compare this map entry to that map entry.
            @SuppressWarnings("unchecked")
            MapEntry<K, E> other = (MapEntry<K, E>) that;
            return this.key.compareTo(other.key);
        }

        public String toString() {
            return "<" + key + "," + value + ">";
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, String> htable = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String password = br.readLine();
            String[] pom = password.split(" ");
            htable.put(pom[0], pom[1]);
        }
        String s = br.readLine();
        while (!s.equals("KRAJ")) {
            String[] pom = s.split(" ");
            if (htable.containsKey(pom[0]))
                if (htable.get(pom[0]).equals(pom[1])) {
                    System.out.println("Najaven");
                    break;
                } else
                    System.out.println("Nenajaven");
            else
                System.out.println("Nenajaven");

            s = br.readLine();
        }

        br.close();
    }
}
