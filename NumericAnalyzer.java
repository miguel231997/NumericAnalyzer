package edu.cuny.csi.csc330.lab2;

import java.util.ArrayList;//built in
import java.util.Collections;//built in 

	public abstract class NumericAnalyzer implements Runnable // implemented class
	{

	public static void main(String[] args) throws Exception // driver method
	{
	ArrayList num = new ArrayList(); // array to save the arguments
	int sum = 0, index, val = 0; // local variables
	int avg;
	if(args.length==0) {
		System.out.println("System Error...Please try again" );
		System.exit(1);
	}
	try // try catch exception
	{
	for (int i = 0; i < args.length; i++) // loop over the arguments
	{
	num.add(Integer.parseInt(args[i])); // reads data into the list
	}
	Collections.sort(num); // sorts the data 
	System.out.println(num.toString()); // prints the arguments in the screen sorted
	System.out.println("Size : " + num.size()); // counts the size of the data
	for (int j = 0; j < num.size(); j++)
	{
	sum = sum + (int) num.get(j); // adds up the arguments 
	}
	avg = (int) sum / num.size(); // calculates the average value
	int min = (int) Collections.min(num);// the minimum value
	System.out.println("Min : " + min); 
	int max = (int) Collections.max(num); // the maximum value
	System.out.println("Max : " + max); 
	System.out.println("Range : " + (max - min));
	for (int k = 0; k < num.size(); k++)
	{
	val = (int) (val + Math.pow((avg - (int) num.get(k)), 2)); // the variance
	}
	int variance =(int) val / num.size();
	int standardD=(int) +Math.pow(variance, .5);
	System.out.println("Sum : " + sum);
	System.out.println("Mean : " + avg);
	index = num.size() / 2; //gets the median index
	System.out.println("Median : " + num.get(index));
	System.out.println("Variance : " + variance);
	System.out.println("Standard Deviation : " + standardD); //the standard deviation
	} catch (Exception ex) 
	{
	throw new Exception(ex.toString()); 
	}
	}
	}