public class Main
{
    public static void main(final String[] array) throws Exception {
        int int1;
        int x;
        for (int1 = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()), x = 1; x * 2 <= int1; x *= 2) {}
        System.out.println(x);
    }
}