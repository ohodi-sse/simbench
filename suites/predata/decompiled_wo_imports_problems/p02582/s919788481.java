public class Main
{
    static final Scanner sc;
    
    public static void main(final String[] array) {
        final Matcher matcher = Pattern.compile("R+").matcher(Main.sc.next());
        if (matcher.find()) {
            System.out.println(matcher.group().length());
        }
        else {
            System.out.println(0);
        }
    }
    
    static {
        sc = new Scanner(System.in);
    }
}