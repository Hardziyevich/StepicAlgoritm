package task1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        int n = Integer.parseInt(first.split(" ")[0]);
        int capacity = Integer.parseInt(first.split(" ")[1]);
        Thing[] things = new Thing[n];
        BackPack steal = new BackPack(capacity);
        int j = 0;
        while (j < n) {
            String temp = scanner.nextLine();
            things[j++] = new Thing(Integer.parseInt(temp.split(" ")[0]), Integer.parseInt(temp.split(" ")[1]));
        }
        Arrays.sort(things);

        for (int i = things.length - 1; i >= 0; i--) {
            while (!steal.isFull() && !things[i].isEmptyThing()) {
                steal.add(things[i].getOneThings());
            }
            if (steal.isFull())
                break;
        }

        System.out.println(steal.getPrice());

    }

    static class Thing implements Comparable<Thing> {
        private List<Double> allThings = new ArrayList<>();
        private Double priceOneThings;

        public Thing(int costAll, int sizeThings) {
            priceOneThings = ((double) costAll) / sizeThings;
            Double[] temp = new Double[sizeThings];
            Arrays.fill(temp, priceOneThings);
            Collections.addAll(allThings, temp);
        }

        public Double getOneThings() {
            double result = 0;
            result = allThings.remove(allThings.size() - 1);
            return result;
        }

        public boolean isEmptyThing() {
            return allThings.isEmpty();
        }


        @Override
        public int compareTo(Thing o) {
            return Double.compare(priceOneThings, o.priceOneThings);
        }
    }

    static class BackPack {
        private Double[] things;
        private Double price = new Double(0);
        int size;

        public BackPack(int capacity) {
            things = new Double[capacity];
        }

        public boolean isFull() {
            return size > things.length - 1;
        }

        public void add(Double thing) {
            things[size++] = thing;
            price = Double.sum(price, thing);
        }

        public Double getPrice() {
            return price;
        }

    }
}
