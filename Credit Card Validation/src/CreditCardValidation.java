import java.io.*;
import java.util.*;


public class CreditCardValidation {

	static int validSum = 0;
	
	public static void main(String[] args) throws IOException {

		Scanner file = new Scanner(new File("CardNumbers"));
//		while (file.hasNextLine()) {
			validateCard(file);
//		}
		
	}
	
	public static void validateCard(Scanner f) {
		int[] number = {5,4,2,4,1,8,0,1,2,3,4,5,6,7,8,9};
//		for (int i = 0; i < 16; i++) {
//			number[i] = Integer.parseInt(f.next());
//		}
//		f.next();
		for (Integer i: number) {
			System.out.print(i);
		}
		System.out.println();
		
		for (int i = 0; i < 16; i++) {
			if (i % 2 == 0) {
				number[i] = number[i]*2;
				if (number[i] >= 10) {
					number[i] = number[i] % 10 + number[i] / 10;
				}
			}
		}
		
		int sum = 0;
		for (int i = 0; i < 16; i++) {
			sum += number[i];
		}
		if (sum % 10 == 0) {
			validSum ++;
		}
		System.out.println(validSum);
		
	}

}
