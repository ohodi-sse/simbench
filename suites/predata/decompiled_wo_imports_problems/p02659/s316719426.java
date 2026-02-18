public final class Main
{
    private static long n;
    private static long m;
    private static long ans;
    
    private static void main$3231c38a() throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter printWriter = new PrintWriter(System.out);
        final String[] split;
        Main.n = Long.parseLong((split = bufferedReader.readLine().split(" "))[0]);
        Main.m = (split[1].charAt(0) - '0') * 100 + (split[1].charAt(2) - '0') * 10 + (split[1].charAt(3) - '0');
        bufferedReader.close();
        printWriter.println(Main.m * Main.n / 100L);
        printWriter.flush();
    }
}