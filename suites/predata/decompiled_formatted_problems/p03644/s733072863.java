import java.util.Scanner;





class Main
{
    public static void main(final String[] array) {
        new Main().compute();
    }
    
    void compute() {
        int nextInt;
        int i;
        for (nextInt = new Scanner(System.in).nextInt(), i = 1; i <= nextInt; i *= 2) {}
        System.out.println(i / 2);
    }
}