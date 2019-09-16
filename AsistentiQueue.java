import java.util.Scanner;

public class AsistentiQueue {

    static class Asistent {
        public String name;

        public Asistent() {
        }

        public Asistent(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class Predmet {
        public String name;
        public int number;

        public Predmet() {
        }

        public Predmet(String name, int number) {
            this.name = name;
            this.number = number;
        }

        @Override
        public String toString() {
            return name + "\n" + number;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        ArrayQueue<Asistent> asistentiqueue = new ArrayQueue<>(n);
        ArrayQueue<Asistent> tempasistenti = new ArrayQueue<>(n);

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            Asistent asistent = new Asistent(name);

            asistentiqueue.enqueue(asistent);
        }

        int m = Integer.parseInt(scanner.nextLine());

        ArrayQueue<Predmet> predmetqueue = new ArrayQueue<>(m);

        int numOfSubjects = 0;

        for (int i = 0; i < m; i++) {
            String predmetinput = scanner.nextLine();
            String[] nameNumber = predmetinput.split(" ");
            Predmet predmet = new Predmet(nameNumber[0], Integer.parseInt(nameNumber[1]));

            predmetqueue.enqueue(predmet);
            numOfSubjects += Integer.parseInt(nameNumber[1]);
        }

        int ots = Integer.parseInt(scanner.nextLine());

        ArrayQueue<Asistent> otsutniqueue = new ArrayQueue<>(ots);

        for (int i = 0; i < ots; i++) {
            String name = scanner.nextLine();
            Asistent otsuten = new Asistent(name);

            otsutniqueue.enqueue(otsuten);
        }


        while (!otsutniqueue.isEmpty()) {
            Asistent otsuten = otsutniqueue.dequeue();

            while (!asistentiqueue.isEmpty()) {
                if (otsuten.name.equals(asistentiqueue.peek().name)) {
                    asistentiqueue.dequeue();
                } else {
                    tempasistenti.enqueue(asistentiqueue.dequeue());
                }
            }

        }


        while (!predmetqueue.isEmpty()) {

            Predmet subject = predmetqueue.dequeue();

            System.out.println(subject.name);
            System.out.println(subject.number);

            while (subject.number != 0) {

                Asistent assistant = tempasistenti.dequeue();
                System.out.println(assistant);

                subject.number--;
                numOfSubjects--;

                if (numOfSubjects > tempasistenti.size()) {
                    tempasistenti.enqueue(assistant);
                }

            }
        }

    }
}




