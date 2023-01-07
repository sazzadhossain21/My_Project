package com.coding.test;

public class Prime_Even_NumberCheck {

	public static boolean isPrime1(int num) {
		if (num <= 1) {
			// System.out.println(num+" is not a prime number");
			return false;
		}
		for (int i = 2; i < num; i++)//
			if (num % i == 0) {
				// System.out.println(num+" is not a prime number");
				return false;
			}
		 //System.out.println(num+" is a prime number");
		return true;
	}

	public static void isPrimeNumber1(int startnum, int endnum) {
		for (int i = startnum; i <= endnum; i++) {
			if (isPrime1(i)) {
				System.out.print(i + " ");
			}
		}
	}

	public static void isPrime2(int num) {

		boolean isprime = true;
		if (num <= 1) {// condition not satisfy for prime number
			isprime = false;
		}
		for (int i = 2; i < num; i++) {// condition not satisfy for prime number
			if (num % i == 0) {
				isprime = false;
			}
		}
		if (isprime) {
			System.out.println(num + " is a prime number ");
		} else {
			 System.out.println(num + " is not a prime number");
		}
	}

	public static void isPrimeNumber2(int firstnum, int lastnum) {
		// this loop needed if they give the range
		for (int j = firstnum; j <= lastnum; j++) {
			int num = j;// when check only one number. j should be that number
			boolean isprime = true;
			if (num <= 1) {// condition not satisfy for prime number
				isprime = false;
			}
			for (int i = 2; i < num; i++) {// condition not satisfy for prime number
				if (num % i == 0) {
					isprime = false;
				}
			}
			if (isprime) {
				System.out.print(num + " ");
			} else {
				// System.out.println(num + " is not a prime number");
			}
		}
	}
	//Calculate the even number
	public static int calculateSumOfEven(int[]numbers) {
		int total=0;
		for(int i=0;i<numbers.length;i++) {
			if(numbers[i]%2==0) {
				total=total+numbers[i];
			}
		}
			return total;
	}
	public static void main(String[] args) {
		isPrime2(22);
		isPrimeNumber2(20,70);
	}
}
