public class Q98e3 {

    // This could be improved by using the Ternary Operator
    // In addition, it would make sense for the next() function to be private, since it is a property of this question
    //    really, which would not be useful outside this question. We can still make it static.
    public static int next(int x) {
        if (x % 2 == 0) {
            return x / 2;
        }
        else {
            return 3 * x + 1;
        }
    }

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        while (x != 1) {
            System.out.print(x + " ");
            x = next(x);
        }
        System.out.println(x);
    }
}
