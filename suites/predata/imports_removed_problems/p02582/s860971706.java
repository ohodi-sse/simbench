public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		if (n.equals("RRR")) {
			System.out.println(3);
		} else if (n.contentEquals("SRR") || n.contentEquals("RRS")) {
			System.out.println(2);
		} else if (n.equals("SSS")) {
			System.out.println(0);
		} else {
			System.out.println(1);
		}
	}
}