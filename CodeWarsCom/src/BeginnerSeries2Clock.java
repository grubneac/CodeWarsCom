

public class BeginnerSeries2Clock {

	public static void main(String[] args)  {
		System.out.println("Result "+Past(1, 1, 1));
	}
	public static int Past(int h, int m, int s) 
	  {
		return h*3600000+m*60000+s*1000;

	  }
}
