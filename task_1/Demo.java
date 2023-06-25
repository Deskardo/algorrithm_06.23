import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo {

    public static void main(String[] args) {
        // List<Integer> availableDivider = findSimpleNumbers(10);
        // for (Integer integer : availableDivider) {
        //     System.out.println(integer);
        // }
        AtomicInteger counter = new AtomicInteger(0);
        int fib = fib(10, counter);
        System.out.println("Fib number: " + fib);
        System.out.println("Counter: " + counter.get());

        counter = new AtomicInteger(0);
        fib = fib(11, counter);
        System.out.println("Fib number: " + fib);
        System.out.println("Counter: " + counter.get());

        counter = new AtomicInteger(0);
        fib = fib(12, counter);
        System.out.println("Fib number: " + fib);
        System.out.println("Counter: " + counter.get());

        counter = new AtomicInteger(0);
        fib = fib(13, counter);
        System.out.println("Fib number: " + fib);
        System.out.println("Counter: " + counter.get());

        counter = new AtomicInteger(0);
        fib = fib(14, counter);
        System.out.println("Fib number: " + fib);
        System.out.println("Counter: " + counter.get());
    }

    public static List<Integer> findAvailbleDivider(int number) { // поиск всех делителей числа алгоритм простой
                                                                  // сложности O(N)
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                result.add(i);
            }
        }
        return result;
    }

    public static List<Integer> findSimpleNumbers(int max) { // поиск всех простых чисел до значения максимум
                                                             // Квадратичная сложность O(n2)
        int counter = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                counter++; // добавили счетчик, чтоб выводить количество итераций
                if (i % j == 0) {
                    simple = false;
                }
            }
            if (simple) {
                result.add(i);
            }
        }

        System.out.println("Counter: " + counter);
        return result;

    }

    public static double find(int sum) {          // О по экспоненте, пример - вычисление вероятности выпадения числа для трех кубиков
        int count = 0;
        int successResult = 0;
        for (int i = 1; i <= 6; i++){
            for (int j = 1; j <= 6; j++){
                for (int k = 1; k <= 6; k++){
                    if( i+ j + k == sum) {
                        successResult ++;
                    }
                    count ++;
                }                
            }
        }
        return ((double) successResult)/((double) count);
    }

    public static int fib(int position, AtomicInteger counter){          // О большое по экспоненте, пример - рекурсивная фнукция для поиска числа фибоначчи
        counter.incrementAndGet();
        if (position == 1) {
            return 0;
        }
        if (position == 2) {
            return 1;
        }
        return fib(position - 1, counter) + fib(position - 2, counter);
    }
}