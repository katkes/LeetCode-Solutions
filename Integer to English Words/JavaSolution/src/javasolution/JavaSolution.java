package javasolution;

import java.util.HashMap;

public class JavaSolution {

	private static final HashMap<Integer, String> numberMap = new HashMap<>();

	static {
		numberMap.put(1, "One");
		numberMap.put(2, "Two");
		numberMap.put(3, "Three");
		numberMap.put(4, "Four");
		numberMap.put(5, "Five");
		numberMap.put(6, "Six");
		numberMap.put(7, "Seven");
		numberMap.put(8, "Eight");
		numberMap.put(9, "Nine");
		numberMap.put(10, "Ten");
		numberMap.put(11, "Eleven");
		numberMap.put(12, "Twelve");
		numberMap.put(13, "Thirteen");
		numberMap.put(14, "Fourteen");
		numberMap.put(15, "Fifteen");
		numberMap.put(16, "Sixteen");
		numberMap.put(17, "Seventeen");
		numberMap.put(18, "Eighteen");
		numberMap.put(19, "Nineteen");
		numberMap.put(20, "Twenty");
		numberMap.put(30, "Thirty");
		numberMap.put(40, "Forty");
		numberMap.put(50, "Fifty");
		numberMap.put(60, "Sixty");
		numberMap.put(70, "Seventy");
		numberMap.put(80, "Eighty");
		numberMap.put(90, "Ninety");
		numberMap.put(100, "Hundred");
		numberMap.put(1000, "Thousand");
		numberMap.put(1000000, "Million");
		numberMap.put(1000000000, "Billion");
	}

	public String numberToWords(int num) {
		String word = "";
		boolean notFirst = false;

		if (num == 0)
			return "Zero";

		int firstThree = num % 1000;
		num /= 1000;
		int secondThree = num % 1000;
		num /= 1000;
		int thirdThree = num % 1000;
		num /= 1000;
		int fourthThree = num % 1000;

		
		System.out.println(firstThree);

		System.out.println(secondThree);
		 

		System.out.println(thirdThree);
		

		System.out.println(fourthThree);
		
		
		if (fourthThree != 0) {
			word += convertToBillions(fourthThree);
			notFirst = true;
		}
		
		if (thirdThree != 0) {
			if (notFirst) word += " ";
			word += convertToMillions(thirdThree);
			notFirst = true;
		} 
		if (secondThree != 0) {
			if (notFirst) word += " ";
			word += convertToThousands(secondThree);
			notFirst = true;
		}
		if (firstThree != 0) {
			if (notFirst) word += " ";
			word += convertToHundreds(firstThree);
		}
		
		
		return word.trim();
	}

	private String convertToHundreds(int num) {
		String ret = "";
		int hundreds = num / 100;
		int tensAndOnes = num % 100;

		if (hundreds != 0) {
			ret += numberMap.get(hundreds) + " " + numberMap.get(100);
		}

		if (tensAndOnes != 0) {
			if (!ret.isEmpty()) {
				ret += " ";
			}
			if (tensAndOnes < 20) {
				ret += numberMap.get(tensAndOnes);
			} else {
				int tens = tensAndOnes / 10 * 10;
				int ones = tensAndOnes % 10;
				ret += numberMap.get(tens);
				if (ones != 0) {
					ret += " " + numberMap.get(ones);
				}
			}
		}

		return ret.trim();
	}

	private String convertToThousands(int num) {
		if (num == 0) {
			return "";
		}
		return (convertToHundreds(num) + " " + numberMap.get(1000)).trim();
	}

	private String convertToMillions(int num) {
		if (num == 0) {
			return "";
		}
		return (convertToHundreds(num) + " " + numberMap.get(1000000)).trim();
	}

	private String convertToBillions(int num) {
		if (num == 0) {
			return "";
		}
		return (convertToHundreds(num) + " " + numberMap.get(1000000000)).trim();
	}

}
