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
			validateInput(userInput);
		}
		else if (input == 1) {
			generate100();
		}
		// comment
	}
	
	public static void validateCardsInFile(Scanner f) {
		
		String wholeNumber = f.nextLine();
		int[] number = new int[16];
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
	
	public static void generate100() throws IOException {
		int[] number = new int[16];
		int counter = 0;
		File f = new File("generated");
		FileWriter fw = new FileWriter(f, true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		for (int i = 0; i < 100;) {
			for (int j = 0; j < 16; j++) {
				int random = (int) (Math.random() * 10);
				number[j] = random;
			}
			counter ++;
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
					pw.print(number[k]);
				}
				pw.println();
			}
		}
		pw.close();
		bw.close();
		fw.close();
		System.out.println("\n100 potentially valid credit card numbers have been appended to the \"generated\" text file.");
		System.out.println("The system took " + counter + " tries to generate 100 valid numbers.");
	}

	public static void validateInput(Scanner ui) {
		int[] number = new int[16];

		System.out.println("Enter the card number to validate.");
		Scanner userInput = new Scanner(System.in);
		String input = userInput.nextLine();
		for (int i = 0; i < input.length(); i++) {
			number[i] = Integer.parseInt(input.substring(i, i+1));
		}
		
		int[] original = number;
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
			System.out.print("\nYour card number " + input + " is valid.\n");
		}
	}
}
