/*Create a function taking a positive integer as its parameter and returning a string containing the Roman Numeral representation 
of that integer.
Modern Roman numerals are written by expressing each digit separately starting with the left most digit and skipping any digit with
a value of zero. In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC. 2008 is written as 2000=MM, 8=VIII; 
or MMVIII. 1666 uses each Roman symbol in descending order: MDCLXVI.
Symbol    Value
I          1
V          5
X          10
L          50
C          100
D          500
M          1,000
*/
public class RomanNumeralsEncoder {

	public static void main(String[] args) {
		RomanNumeralsEncoder rne= new RomanNumeralsEncoder();
		String result = rne.solution(1746);
		System.out.println(result);
	}
	
    public String solution(int n) {
    	if(n<1)return "";
    String[] simvols= {"I","V","X","L","C","D","M"};
    String result="";
    
    if(n>999){
    	//work with thousands
    	int thousand = n/1000;
    	result +=repeat(simvols[6],thousand); //M 1000
    	n -=thousand*1000;
    }

    if(n>99){
    	//work with five-hundreds
    	System.out.println(n);
    	if (n/100==9) {
    		result +="CM"; //900
    		n -=900;
    	}else 
    	if(n/100==4){
    		result +="CD"; //400
    		n -=400;
    	}
    	else{
    	//work with five-hundreds
    	int fiveHundreds = n/500;
    	result +=repeat(simvols[5],fiveHundreds); //D 500
    	n -=fiveHundreds*500;
    	}
    }
    
    //work with hundreds
    System.out.println(n);
    if(n>99){
    	int hundreds = n/100;
    	result +=repeat(simvols[4],hundreds); //C 100
    	n -=hundreds*100;
    }
    
    //work with tens
    System.out.println(n);
    if(n>9) {
      	if (n/10==9) {
    		result +="XC";//90
    		n -=90;
    	}
      	if (n/10==4) {
    		result +="XL";//40
    		n -=40;
    	}
      	else {
    	//work with five-hundreds
    	int fiveTens = n/50;
    	result +=repeat(simvols[3],fiveTens);//C 50 
    	n -=fiveTens*50;
    	}   	
    }
    
    if(n>9){
    	int tens = n/10;
    	result +=repeat(simvols[2],tens);//X 10 
    	n -=tens*10;
    }
    
    //work with 1-9
    System.out.println(n);   
    if(n>=0) {
      	if (n==9) {
    		result +="IX";//9
    		n -=9;
    	}
      	if (n==4) {
    		result +="IV";//4
    		n -=4;
    	}
      	else {
    	//work with five-hundreds
    	int five = n/5;
    	result +=repeat(simvols[1],five);//V 5 
    	n -=five*5;
    	}   	
    }
    
    if(n>0){
    	int one = n;
    	result +=repeat(simvols[0],one);//I 1 
    	n -=one;
    }    
    System.out.println(n);
        return result;
    }

    
    
    
    
    public static void repeat(StringBuilder stringBuilder, String s, int times) {
        if (times > 0) {
            repeat(stringBuilder.append(s), s, times - 1);
        }
    }

    public static String repeat(String s, int times) {
        StringBuilder stringBuilder = new StringBuilder(s.length() * times);
        repeat(stringBuilder, s, times);
        return stringBuilder.toString();
    }
}
