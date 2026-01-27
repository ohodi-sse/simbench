public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigDecimal atemp = sc.nextBigDecimal();
        BigDecimal b = sc.nextBigDecimal();
        String ans = atemp.multiply(b).toString();


        int index = ans.indexOf('.');
        System.out.println(ans.substring(0,index));





















    }
}