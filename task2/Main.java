package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int temp = n;
        if(n != 1 && n != 2) {
            for (int i = 1; i < n; i++) {
                int pre = temp;
                temp -= i;
                if (temp >= i + 1)
                    result.add(i);
                else {
                    result.add(pre);
                    break;
                }
            }
        }
        else {
            result.add(n);
        }
        System.out.println(result.size());
        result.stream().forEach((x)-> System.out.print(x+" "));
    }
}
