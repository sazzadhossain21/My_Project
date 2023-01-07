package com.coding.test;
import org.testng.annotations.Test;


@Test
public class Factorial_Class {
	public void findFactorial() {
		int fnum=3;
		int factor = 1;
		if(fnum!=0) {
		for(int i=fnum;i>0;i--) {
			factor = factor*i;
		}
		System.out.println(factor);
		}
		else {
			System.out.println(factor);
		}
		}

}
