import dsandalgo.recursion.Fibonacci;

public class Main {
    public static void main(String[] args) {

        Fibonacci fibo = new Fibonacci();
        long fib = fibo.fibonacci(60);
        System.out.println(fib);
    }

}