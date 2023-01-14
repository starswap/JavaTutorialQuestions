public class Q98e3 {
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
