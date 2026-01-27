public class Main
{
    static StringTokenizer st;
    static BufferedReader br;
    static PrintWriter out;
    
    public static void main(final String[] array) throws IOException {
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
    
    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    
    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
    
    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
    
    static String next() throws IOException {
        while (Main.st == null || !Main.st.hasMoreTokens()) {
            Main.st = new StringTokenizer(Main.br.readLine().trim());
        }
        return Main.st.nextToken();
    }
}