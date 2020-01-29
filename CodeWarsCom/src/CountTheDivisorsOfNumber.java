
public class CountTheDivisorsOfNumber {

	public static void main(String[] args) {
		CountTheDivisorsOfNumber fd = new CountTheDivisorsOfNumber();
		System.out.println(fd.numberOfDivisors(30));
	}

	public long numberOfDivisors(int n) {
		    int result=0;
		    
		    for(int i=1;i<=n;i++)
		      if(n%i==0)result++;
		      
		      return result;
		      
		  }

}
