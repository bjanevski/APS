import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Hashtable;


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

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        HashMap<String, String> hashtable = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String password = reader.readLine();
            String[] temp = password.split(" ");
            hashtable.put(temp[0], temp[1]);
        }

        String string = reader.readLine();

        while (!string.equals("KRAJ")) {
            String[] temp = string.split(" ");
            if (hashtable.containsKey(temp[0])) {
                if (hashtable.get(temp[0]).equals(temp[1])) {
                    System.out.println("Najaven");
                    break;
                } else
                    System.out.println("Nenajaven");
            } else {
                System.out.println("Nenajaven");
            }

            string = reader.readLine();
        }

        reader.close();
    }

}






