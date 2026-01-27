public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int x = scan.nextInt();
		int n = scan.nextInt();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < n; i++) {
			list.add(scan.nextInt());
		}
		
		for(int i = 0; i < 102; i++) {
			if(list.contains(x-i) != true) {
				System.out.print(x-i);
				return;
			}
			else if(list.contains(x+i) != true) {
				System.out.print(x+i);
				return;
			}
		}
		
	}
}