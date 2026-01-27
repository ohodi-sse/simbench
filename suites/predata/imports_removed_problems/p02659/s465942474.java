public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        long a = sc.nextLong();
        BigDecimal ba = BigDecimal.valueOf(a);
        String b = sc.next();
        BigDecimal bb = new BigDecimal(b);


        System.out.println(ba.multiply(bb).longValue());
    }
}