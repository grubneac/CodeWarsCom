
public class OddorEven {

	public static void main(String[] args) {
		System.out.println(oddOrEven(new int[] {0}));

	}
	  public static String oddOrEven (int[] array) {
		  // your code
		    int summary = 0;
		    for(int i=0; i<array.length;i++){
		      summary +=array[i];
		    }
		    if(summary/2==0)return"even";
		    else return "odd";
		  }
}
