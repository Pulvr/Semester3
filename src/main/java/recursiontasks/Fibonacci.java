package recursiontasks;

class Fibonacci {

    static long fibonacci (int n){
        if (n<=1){
            return n;
        }

        long prev1 = 0;
        long prev2 = 1;
        long current = 0;

        for (int i = 2;i <= n ;i++){
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }

    return current;
    }

    static long fibonacciRecursive(int n){
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    }
}
