import java.util.Arrays;
import java.io.*;

public class TestSort{
	
	int i;
	
	public TestSort(){
		Graph graph = new Graph(0.5, i);
	}
	
    public void measureTime(){
		
		int N = 6;
		double[] data = new double[N];
		for (int n = 0; n < N; n++){
		
			for(int i=12; i<=17; i++){		long time_prev = System.nanoTime();
					graph.bestColouring(3);
					double time = (System.nanoTime()-time_prev)/1000000000.0;
					System.out.println("Time taken for" + i +"nodes is" + time);	
			}
			
		}
		
	}
}
