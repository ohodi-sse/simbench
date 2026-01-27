public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> list = new ArrayList<>();
    int x = sc.nextInt();
    int n = sc.nextInt();
    for(int i=0; i<n; i++){
       list.add(sc.nextInt());
    }

    Collections.sort(list);


    int i = 0;
    int ans = 0;
    while(true){
      if(!(list.contains(x-i))){
        ans = x-i;
        break;
      }

      
      
      
      if(!(list.contains(x+i))){
        ans = x+i;
        break;
      }
      i++;
    }
    System.out.println(ans);

    
      
    

  }

}