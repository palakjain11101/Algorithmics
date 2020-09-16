import java.io.*;
import java.util.*;

public class MySortAL
{
    public static void main(String [] args )
    {
	int times = 50;
	double[] sortTime = new double[times];
	
	for(int j=0;j < times; j++){
		int N = Integer.parseInt(args[0]);
		List<Double> data = new ArrayList<Double>(N);
		for (int i=0; i<N; i++)
			data.add(Math.random());
		long time_prev = System.nanoTime();
		Collections.sort(data);
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
