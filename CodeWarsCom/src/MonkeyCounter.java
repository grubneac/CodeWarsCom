
public class MonkeyCounter {

	public static void main(String[] args) {
		int[] tt =monkeyCount(10);
		
		for (int i : tt) {
			
			System.out.println(i);
		}
	}
	
	 public static int[] monkeyCount(final int n){
		    int[] result= new int[n];
		    for(int i=0;i<result.length;i++)
		      result[i]=i+1;
		      
		    return result;
		  
		  }

}
