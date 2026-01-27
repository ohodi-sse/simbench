class Main
{
    static Scanner sc;
    
    public static void main(final String[] array) {
        final int nextInt = Main.sc.nextInt();
        final int nextInt2 = Main.sc.nextInt();
        if (nextInt2 != 0) {
            final ArrayList list = new ArrayList();
            for (int i = 0; i < nextInt2; ++i) {
                list.add(Main.sc.nextInt());
            }
            int n;
            for (n = 0; list.contains(nextInt - n); ++n) {
                if (!list.contains(nextInt + n)) {
                    System.out.println(nextInt + n);
                    return;
                }
            }
            System.out.println(nextInt - n);
            return;
        }
        System.out.println(nextInt);
    }
    
    static {
        Main.sc = new Scanner(System.in);
    }
}