public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		BigDecimal A = sc.nextBigDecimal();
		BigDecimal B = sc.nextBigDecimal();
		BigDecimal B2 = B.multiply(new BigDecimal(100.00));
		BigDecimal ans = A.multiply(B2);
		String str = null;
		if (new BigDecimal(100.00).compareTo(ans) <= 0) {
			str = ans.toString();
			int int1 = str.indexOf(".");
			if (int1 > -1) str = str.substring(0,int1);
			str = str.substring(0, str.length() - 2);
		} else {
			str = "0";
		}
		
		
		System.out.println(str);
	}
}