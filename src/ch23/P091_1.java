package ch23;

public class P091_1 {
    public int fib(int n) {
        if (n <= 1) return n;
        else return fib(n - 1) + fib(n - 2);
    }
}
