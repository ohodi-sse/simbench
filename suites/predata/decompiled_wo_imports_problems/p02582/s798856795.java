public final class Main
{
    Scanner sc;
    
    private static void main$3231c38a() {
        new Main();
    }
    
    public Main() {
        this.sc = new Scanner(System.in);
        final String next = new TestA().this$0.sc.next();
        final String[] array = { "SSS" };
        final String[] array2 = { "RSS", "SRS", "SSR", "RSR" };
        final String[] array3 = { "RRS", "SRR" };
        final String[] array4 = { "RRR" };
        for (int i = 0; i < array.length; ++i) {
            if (next.equals(array[0])) {
                System.out.println(0);
            }
        }
        for (int j = 0; j < array2.length; ++j) {
            if (next.equals(array2[j])) {
                System.out.println(1);
            }
        }
        for (int k = 0; k < array3.length; ++k) {
            if (next.equals(array3[k])) {
                System.out.println(2);
            }
        }
        for (int l = 0; l < array4.length; ++l) {
            if (next.equals(array4[0])) {
                System.out.println(3);
            }
        }
    }
    
    final class TestA
    {
        final /* synthetic */ Main this$0;
        
        TestA() {
            Objects.requireNonNull(Main.this);
        }
        
        private void doIt() {
            final String next = Main.this.sc.next();
            final String[] array = { "SSS" };
            final String[] array2 = { "RSS", "SRS", "SSR", "RSR" };
            final String[] array3 = { "RRS", "SRR" };
            final String[] array4 = { "RRR" };
            for (int i = 0; i < array.length; ++i) {
                if (next.equals(array[0])) {
                    System.out.println(0);
                }
            }
            for (int j = 0; j < array2.length; ++j) {
                if (next.equals(array2[j])) {
                    System.out.println(1);
                }
            }
            for (int k = 0; k < array3.length; ++k) {
                if (next.equals(array3[k])) {
                    System.out.println(2);
                }
            }
            for (int l = 0; l < array4.length; ++l) {
                if (next.equals(array4[0])) {
                    System.out.println(3);
                }
            }
        }
    }
}