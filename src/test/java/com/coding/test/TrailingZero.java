package com.coding.test;

public class TrailingZero {

		/*find out how many trailling zero in this number factorial
		 * to find out trailling zero of number factorial 
		 * we need to find out how many time that number can be divided by 5.
		 * example= Find out trailling zero of 125!.
		 * 125/5=25;25/5=5; Ans 25+5=30 is trailling zero of 125!
		 * other way we can say how many 5 exist in that number factorial
		 * 20!=20(5*4)*19*18*17*16*15(5*3)*14*13*12*11*10(5*2)*9*8*7*6*5(5*1)*4*3*2*1= 4 five exist.
		 * trailling zero of 20! is 4*/
	public static void getTrailingZero(int num) {
	int count = 0;
	while(num > 5 ) {	
		num = num / 5;
		count = count+num;		
	}
	System.out.println(count);
	
	}	
	public static void main(String[] args) {
		getTrailingZero(234);//1*2*3*4*5*6*7*8*9*10*11*12*
		getCountZero();
	}
	//find out how many trailling zero in this number
	//Trailling zero means how many zero is at the end of any number
	public static void getCountZero() {
		int num =234;
		int count = 0;
		while(num>0) {
			if(num%10==0) {
				count++;
			}
			num=num/10;
		}
		System.out.println(count);
	}
}
