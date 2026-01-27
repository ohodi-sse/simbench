public class Main {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);

		
		int a = sc.nextInt();
		int b = sc.nextInt();

		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < b; i++) {
			list.add(sc.nextInt());
		}
		
		int index = 0;
		boolean flag = true;
		
		while (flag && -100 <= index && index <= 100) {
			a -= index;
			if (list.indexOf(a) == -1) {
				System.out.println(a);
				flag = false;
			} else {
				if (index >= 0) {
					index++;
				} else {
					index--;
				}
				if (index != 1) {
					index *= -1;
				}
				
			}
		}
	}
}