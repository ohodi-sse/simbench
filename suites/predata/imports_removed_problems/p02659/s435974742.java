public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        
        String b = sc.next();

        

        
        
        

        

        long b0 = (b.charAt(0) - '0') * 100;
        long b1 = (b.charAt(2) - '0') * 10;
        long b2 = b.charAt(3) - '0';

        long ans = (a * b0 + a * b1 + a * b2) / 100;

        System.out.println(ans);
    }
}