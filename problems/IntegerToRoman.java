import java.util.Scanner;

//input int 
public class IntToRoman{
	
	public static String intToRoman(int num) {
        int[] value ={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL","X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < value.length && num >= 0; i++){
            while(num >= value[i]){
                result.append(symbol[i]);
                num -= value[i];
            }
        }
        return result.toString();
    }
	
	public static void main(String[] args) {
		Scanner i = new Scanner(System.in);
		int n = i.nextInt();
        System.out.println(intToRoman(n));
	}
}