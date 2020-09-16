import java.io.*;
import java.util.*;

public class MySort
{
    public static void main(String [] args){
	int times = 50;
	double[] sortTime = new double[times];
	
	for(int j=0;j < times; j++){
		int N = Integer.parseInt(args[0]);
		double[] data = new double[N];
		for (int i=0; i<N; i++)
			data[i] = Math.random();
		long time_prev = System.nanoTime();

		Arrays.sort(data);
		
		double time = (System.nanoTime()-time_prev)/1000000000.0;
		
		sortTime[j] = time;
		
		System.out.println("Sort Time= " + time);
		/* for (double d: data)
			System.out.println(d); */
		}
		
	System.out.println(median(sortTime));
	}
	
	public static double median(double[] a) {
		Arrays.sort(a);
		return a[a.length/2];
    }
}