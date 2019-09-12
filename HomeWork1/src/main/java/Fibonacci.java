public class Fibonacci {
    public static void createFibonacciNumbers(int amount) {
        int a, b, next;
        a = 0;
        b = 1;
        if(amount==1){
            System.out.println(a);
        }
        else {
            System.out.print(a + ", ");
            System.out.print(b + ", ");
            for (int i = 0; i < amount - 2; i++) {
                next = a + b;
                System.out.print(next + ", ");
                a = b;
                b = next;
            }
        }
    }
}
