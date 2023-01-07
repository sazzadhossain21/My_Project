package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class InterestDemo {
	InterestDemo obj;
public  List <Double> get_Total_Interest(double loanamount, int loanyear, double interestrate) {
	double loan_amount=loanamount;
	int loan_year =loanyear;
	double interest_rate = interestrate;
	
	int year = 1;
	double interest_amount = 0;
	double total_interest_amount=0;
	double total_loan_amount =0;
	List<Double> value = new ArrayList<>();
	
	while(year<=loan_year) {
	loan_amount=loan_amount+interest_amount;
	interest_amount = (interest_rate*loan_amount)/100;
	total_interest_amount=total_interest_amount+interest_amount;
	total_loan_amount=loan_amount+interest_amount;
	year++;
	//System.out.println(interest_amount);
	}
	value.add(total_interest_amount);
	value.add(total_loan_amount);
	//System.out.println(total_interest_amount);
	//System.out.println(total_loan_amount);
	return value;
}

public void get_Total_Loan_Amount_paid(double loanamount, int loanyear, double interestrate) {
	List <Double> value = get_Total_Interest(loanamount,loanyear,interestrate);
    System.out.println("The total interest amount you paid at the end is : "+value.get(0));
}
public void get_Total_interest_Amount_paid(double loanamount, int loanyear, double interestrate) {
	List <Double> value = get_Total_Interest(loanamount,loanyear,interestrate);
    System.out.println("The total loan amount you paid at the end is : "+value.get(1));
}
public static void main(String[] args) {
	InterestDemo obj = new InterestDemo();
	obj.get_Total_Loan_Amount_paid(615200, 30, 5.344);//loan,year,rate
	obj.get_Total_interest_Amount_paid(615200, 30, 5.344);//loan,year,rate
	
	
}
}
