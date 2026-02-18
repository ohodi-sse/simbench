public final class Main
{
    private static void main$3231c38a() throws IOException {
        int int1 = Integer.parseInt(new MyReader().readLine());
        int n = 1;
        while ((int1 >>= 1) > 0) {
            ++n;
        }
        System.out.println(Integer.valueOf(1 << n - 1).toString());
    }
    
    private static void print(final Object o) {
        System.out.print(o.toString());
    }
    
    private static void println(final Object o) {
        System.out.println(o.toString());
    }
    
    private static int Int(final String s) {
        return Integer.parseInt(s);
    }
    
    private static long Long(final String s) {
        return Long.parseLong(s);
    }
    
    static final class MyReader extends BufferedReader
    {
        MyReader() {
            super(new InputStreamReader(System.in));
        }
        
        private String s() throws IOException {
            return this.readLine();
        }
        
        private String[] ss() throws IOException {
            return this.readLine().split(" ");
        }
        
        private int i() throws IOException {
            return Integer.parseInt(this.readLine());
        }
        
        private int[] ii() throws IOException {
            final String[] ss;
            final int length;
            final int[] array = new int[length = (ss = this.ss()).length];
            for (int i = 0; i < length; ++i) {
                array[i] = Integer.parseInt(ss[i]);
            }
            return array;
        }
        
        private long l() throws IOException {
            return Long.parseLong(this.readLine());
        }
        
        private long[] ll() throws IOException {
            final String[] ss;
            final int length;
            final long[] array = new long[length = (ss = this.ss()).length];
            for (int i = 0; i < length; ++i) {
                array[i] = Long.parseLong(ss[i]);
            }
            return array;
        }
    }
}