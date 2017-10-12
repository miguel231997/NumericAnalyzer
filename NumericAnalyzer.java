package edu.cuny.csi.csc330.lab2;

import java.util.Arrays;

public class NumericAnalyzer {
	
	
	private int size, average, median, min , max, sum, range; 
	private double variance=0, deviation;
	private int varianceVariable, varianceSum;		//only used for variance
	private int [] intArr;
	
	
	public NumericAnalyzer(String[] arry) {
							
		int arrSize = arry.length;
		intArr = new int[arrSize];
		
		for(int i = 0; i< arry.length;i++)			//converts command line arg into an array of ints
			intArr[i] = Integer.valueOf(arry[i]);
		
		Arrays.sort(intArr);						//sorts the int array
		
		size = intArr.length;
	}

	public void calculate() {
	sum = 0;
		
	for(int i = 0; i< intArr.length;i++)
			sum +=  intArr[i];
	
	average = sum/size;
	
	median = size/2;
	median = intArr[median];
	
	min = intArr[0];
	max = intArr[size-1];
	
	range = max-min;
	
	for(int i = 0; i < size; i++) {					//starts the calculation of the variance
	
		varianceVariable = intArr[i]-average;
		varianceVariable = varianceVariable * varianceVariable;
		variance = variance + varianceVariable;
		
	}
	variance=variance/size;							//finishes the calculation of the variance
	variance = Math.round(variance);				//rounds variance
	
	
	deviation = Math.sqrt(variance);			
	deviation = Math.round(deviation);				//rounds deviation
	
	
		
	}
	
	
	public void display() {
		
		
		for(int i = 0; i< size;i++)
			System.out.printf("%5s",intArr[i]);
		
		System.out.printf("\n%-30s %d", "Size:", size);
		System.out.printf("\n%-30s %d", "Min:", min);
		System.out.printf("\n%-30s %d", "Max:", max);
		System.out.printf("\n%-30s %d", "Range:", range);
		System.out.printf("\n%-30s %d","Sum:", sum);
		System.out.printf("\n%-30s %d", "Mean:", average);
		System.out.printf("\n%-30s %d","Median:", median);
		System.out.printf("\n%-30s %f","Variance", variance);
		System.out.printf("\n%-30s %f","Standard Deviation:", deviation);
	}
	
	
	
	
	public static void main(String[] args) {
		
		if(args.length == 0) {
			System.out.printf("ERROR : No values were entered!");
		
			System.exit(1);
		}
		
		NumericAnalyzer analyzer = new NumericAnalyzer(args);

		analyzer.calculate();
		analyzer.display();
		
		System.exit(0);
	}
}
