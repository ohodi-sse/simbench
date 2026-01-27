public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String[] arr = sc.nextLine().split(" ");
        BigDecimal a = new BigDecimal(arr[0]);
        BigDecimal b = new BigDecimal(arr[1]);
        BigDecimal ans = a.multiply(b);
        System.out.println(ans.setScale(0, RoundingMode.DOWN));
    }
}