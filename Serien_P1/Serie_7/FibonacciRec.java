public class FibonacciRec{
    public static void main(String[] args) {

        // Computation time is very intense. The recursive method grows quadratic with O(n^2).
        for (int i = 0; i <= 50; i += 1)
            System.out.print(fib(i) + " ");
    }

    public static long fib(int n){
        long fib_result;

        if (n < 2)
            fib_result = n;
        else
            fib_result = fib(n-1) + fib(n-2);

        return fib_result;

    }

}
