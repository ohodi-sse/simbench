public class Main {
    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		
		long a = sc.nextLong();
		String b = sc.next();
		BigDecimal A = new BigDecimal(a);
		BigDecimal B = new BigDecimal(b);
		
		
		
		
		System.out.println(A.multiply(B).toBigInteger());
	}

}