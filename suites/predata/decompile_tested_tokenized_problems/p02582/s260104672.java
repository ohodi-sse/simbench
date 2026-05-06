import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final String nextLine = scanner.nextLine();
            int x;
            if (nextLine.equalsIgnoreCase("ssr") || nextLine.equalsIgnoreCase("srs") || nextLine.equalsIgnoreCase("rss") || nextLine.equalsIgnoreCase("rsr")) {
                x = 1;
            }
            else if (nextLine.equalsIgnoreCase("rrs") || nextLine.equalsIgnoreCase("srr")) {
                x = 2;
            }
            else if (nextLine.equalsIgnoreCase("rrr")) {
                x = 3;
            }
            else {
                x = 0;
            }
            System.out.println(x);
        }
    }
}
