class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'R') {
                int j;
                for (j = 0; i <= next.length() - 1 && next.charAt(i) != 'S'; ++i, ++j) {}
                list.add(j);
                --i;
            }
        }
        int max = Integer.MIN_VALUE;
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            max = Math.max(max, (int)iterator.next());
        }
        if (max < 0) {
            System.out.println("0");
        }
        else {
            System.out.println(max);
        }
    }
}