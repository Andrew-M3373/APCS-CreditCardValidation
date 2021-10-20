import java.io.*;
import java.util.*;


public class CreditCardValidation {

	static int validSum = 0;
	
	public static void main(String[] args) throws IOException {

		Scanner file = new Scanner(new File("CardNumbers"));
		while (file.hasNextLine()) {
			validateCardsInFile(file);
		}

		System.out.println("There are " + validSum + " valid card numbers in the document.");
		
		System.out.println("\nWhat do you want to do?"
				+ "\n1.\tGenerate 100 valid card numbers"
				+ "\n2.\tCheck if your number is valid"
				+ "\n3.\tExit");
		Scanner userInput = new Scanner(System.in);
		int input = userInput.nextInt();
		if (input == 2) {
//			validateInput();
		}
		else if (input == 1) {
			generate100();
		}
	}
	
	public static void validateCardsInFile(Scanner f) {
		
		String wholeNumber = f.nextLine();
		int[] number = {5,4,2,4,1,8,0,1,2,3,4,5,6,7,8,9};
				//Integer.parseInt(f.nextLine().split(""));
		for (int i = 0; i < wholeNumber.length(); i++) {
			number[i] = Integer.parseInt(wholeNumber.substring(i, i+1));
		}
		
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
		
	}
	
	public static void generate100() {
		int[] number = {5,4,2,4,1,8,0,1,2,3,4,5,6,7,8,9};
		for (int i = 0; i < 100;) {
			for (int j = 0; j < 16; j++) {
				int random = (int) (Math.random() * 10);
				number[j] = random;
			}
			for (int j = 0; j < 16; j++) {
				if (j % 2 == 0) {
					number[j] = number[j]*2;
					if (number[j] >= 10) {
						number[j] = number[j] % 10 + number[j] / 10;
					}
				}
			}
			int sum = 0;
			for (int j = 0; j < 16; j++) {
				sum += number[j];
			}
			if (sum % 10 == 0) {
				i++;
				for (int k = 0; k < 16; k++) {
					System.out.print(number[k]);
				}
				System.out.println();
			}
		}
	}

}
