public final class Main
{
    private static StringTokenizer st;
    private static BufferedReader br;
    private static PrintWriter out;
    
    private static void main$3231c38a() throws IOException {
        Main.br = new BufferedReader(new InputStreamReader(System.in));
        final char[] charArray = next().toCharArray();
        int b = 0;
        int max = 0;
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == 'R') {
                ++b;
            }
            else {
                b = 0;
            }
            max = Math.max(max, b);
        }
        System.out.println(max);
    }
    
    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    
    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
    
    private static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
    
    private static String next() throws IOException {
        while (Main.st == null || !Main.st.hasMoreTokens()) {
            Main.st = new StringTokenizer(Main.br.readLine().trim());
        }
        return Main.st.nextToken();
    }
}