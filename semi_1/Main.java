package semi_1;
import java.util.Date;

public class Main {

    public static int Sum(int N) { // O(1) + O(N)*O(1) + O(1) = O(1 + N + 1) = O(n)
        int result = 0; // O(1)
        for (int i = 0; i <= N; i++) { // O(N)
            result += i; // O(1)
        }
        return result; // O(1)
    }

    // При последовательном выполнении итераций, O = O(max), В данном случае, N не
    // может быть меньше единицы, значит O = O(N)

    public static void Simple(int N) {       // O(n * sqrt(n)) - степенная функция
        for (int num = 2; num <= N; num++) { // O(n)
            boolean simple = true;           // O(1)
            for(int i = 2; i*i <= num; i++){ // O(sqrt n)
                if(num % i == 0){            // O(1)
                    simple = false;          // O(1)
                    break;                   
                }
            }
            if(simple){                      // O(1)
            System.out.printf("%d ", num);
            }
        }
    }

    // Всегда необходимо думать над тем, как сделать решение более оптимальным. O(n * sqrt(n)) меньше, чем O(n2)

    public static int Cubs(int K, int N){
        return Cubs(K, N, 1);
    }

    private static int Cubs(int K, int N, int H){  // O(N^K) вычисляется как количество вызовов рекурсии в степени количества кубиков
        if(H == K +1){
            return 1;
        }
        int res = 0;
        for(int i = 1; i <= N; i++){
            res += Cubs(K, N, H + 1);
        }
        return res;
    }

    public static long F1(int N){  // O(1,6^N) Функция фибоначчи, экспоненциональная сложность
        if(N <= 2){
            return 1;
        }
        return F1(N-1) + F1(N-2);
    }

    public static long F2(int N){  // O(N) 
        if(N <= 2){
            return 1;
        }
        long[] F = new long[N+1];
        F[1] = 1;
        F[2] = 1;
        for(int i =3; i<=N; i++){
            F[i] = F[i-1] + F[i-2];
        }
        return F[N];
    }   

    public static void test(){
        for(int N = 10; N <= 50; N++){
            Date start = new Date();
            F1(N);
            Date end = new Date();
            long time1 = end.getTime() - start.getTime();

            start = new Date();
            F2(N);
            end = new Date();
            long time2 = end.getTime() - start.getTime();

            System.out.printf("N=%d, time1=%d, time2=%d%n", N, time1, time2);
        }
    }

    public static void main(String[] args) {
        // Simple(100);
        // System.out.println(Cubs(4, 6));
        // System.out.println(F1(50));
        // System.out.println(F2(50));

        test();
    }
}