public class Main {

    public static void main(String args[]) {

        
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        sc.close();

        
        Integer[] num = new Integer[] { 2, 4, 8, 16, 32, 64 };
        Arrays.sort(num, Collections.reverseOrder());
        int result = 1;
        for (int i = 0; i < num.length; i++) {
            if (num[i] <= n) {
                result = num[i];
                break;
            }
        }

        
        System.out.println(result);
    }
}