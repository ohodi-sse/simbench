public class Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);

		int x=sc.nextInt();		
		int n=sc.nextInt();		

		ArrayList<Integer>array=new ArrayList<>();
		for(int i=0;i<n;i++) {
			array.add(sc.nextInt());
		}
		
		for(int i=0;i<100;i++) {
			if(!array.contains(x-i)) {
				System.out.println(x-i);
				break;
			}else if(!array.contains(x+i)) {
				System.out.println(x+i);
				break;
			}
			
		}
    }
}