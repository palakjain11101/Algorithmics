import java.util.NoSuchElementException;

public class CircularArrayQueue implements MyQueue {
	private Integer[] array;
	private int N; //initial size of the array
	private int head;
	private int tail;
	private int count = 0;//total number of items currently in queue.
	
	//Constructor defines array of size 10
	public CircularArrayQueue()
	{
	    this.N = 10;
	    array = new Integer[N];
	    head = tail = 0;
	}
	
	//Constructor takes array size as input
	public CircularArrayQueue(int size)
	{
	    this.N = size;
	    array = new Integer[N];
	    head = tail = 0;
	}
	
	
	//Enqueues an element at the tail of the queue
	//If the queue is already full it is resized
	@Override
	public void enqueue(int in) 
	{
	    count++;
	    if (isFull())
	    {
	       resize();
	       tail = (tail + 1) % N;
	       array[tail] = in;
	    }
	    else
	    {
	       tail = (tail + 1) % N;
	       array[tail] = in;
	    }            
	}
	
	/* When method is called array size is doubled and 
	contents are copied to new array of double the size */
	
	public void resize()
	{
	    Integer[] temp = new Integer[array.length*2];
	    N = array.length*2;
	    for(int i=0; i<array.length; i++)
	    {
	        temp[i] = array[i];
	    }
	
	    array = temp;
	}
	
	
	//Dequeues an element
	//If the queue is empty a NoSuchElement Exception is thrown
	@Override
	public int dequeue() throws NoSuchElementException 
	{
	    if(isEmpty())
	    {
	        try
	        { 
	            throw new NoSuchElementException("The queue is empty"); 
	        } 
	        catch(NoSuchElementException e) 
	        { 
	            System.out.println("The queue is empty"); 
	            throw e; // rethrowing the exception
	        } 
	    }
	
	    head = (head + 1) % N;
	    int headElement = array[head];   
	    count--;
	    return headElement;
	}
	
	//Returns number of items in the array
	@Override
	public int noItems() 
	{   
	    return count;
	}
	
	//If both head and tail are pointing at the same value, then the queue is empty
	@Override
	public boolean isEmpty()
	{
	    return head == tail;
	}
	
	/*Queue is full when head is greater than tail by 1 because then a 
	value cannot be added to the tail and cannot be removed from the head. */
	public boolean isFull()
	{
	    return head == ((tail + 1) % N);
	}
	
	//Tells the user how many items can be added to the array before the array needs to be resized
	public int getCapacityLeft()
	{
	    return N - 1 - count;
	}   
}
