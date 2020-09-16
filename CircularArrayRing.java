import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularArrayRing<E> extends AbstractCollection<E> implements Ring<E> {

	Object[] ring;
	int head;
	boolean filled = false;

	//Constructor defines array of size 10
	public CircularArrayRing(int i) 
	{
		ring = new Object[i];
		head = 0;
	}

	//Constructor takes array size as input
	public CircularArrayRing()
	{
		ring = new Object[20];
		head = 0;
	}

	//Element e is added to the ring, if ring is full, the previous element is overwritten
	public boolean add(E e) {
		ring[head] = e;
		head++;
		if (head == ring.length)
		{
			head = 0;
			if (!filled)
			{
				//return true if the add caused no overwriting 
				filled = true;
			}
		}
		//return false if the add caused overwriting
		return false;

	}
	

	//The get method gets the last added variables first. 
	//That is, get(0) gets the last item you added; get(1) gets the previous item.
	@SuppressWarnings("unchecked")
	public E get(int index) throws IndexOutOfBoundsException {
		
	    /*It throws an IndexOutOfBoundsException if the index is either 
	    larger than the number of items added or larger than the ring size.*/
		if (index >= ring.length)
		{
			throw new IndexOutOfBoundsException();
		}
		
		else if ((!filled) && (index > head))
		{
			throw new IndexOutOfBoundsException();
		}
		
		else if (index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		
		index = head-index-1;
		if (index < 0)
		{
			index = ring.length + index;
		} 

		return (E) ring[index];
	}


	public Iterator<E> iterator() {
		return new Iterator<E>() {  

			int pos = head-1;
			int nextPos;
			
			//Checks is the ring has a next element
			public boolean hasNext() {
				nextPos = pos - 1;
				if (nextPos < 0)
				{
					nextPos = ring.length - 1 ;
				}
				
				//if the iterator reaches where it started off, return false, therefore stop iterating
				if (nextPos == head)
				{
					return false;
				}
				else
				{
					return true;
				}
			}  

			@SuppressWarnings("unchecked")
			//If ring has a next element, position 'pos' moves to next element
			public E next() {  
				if(hasNext())
				{
					pos--;
					if (pos < 0)
					{
						pos = ring.length - 1;
					}
					return (E) ring[pos];
				}

				else
				{
					throw new NoSuchElementException();
				}

			}  

			public void remove() {  
				throw new UnsupportedOperationException(); 
			}  
		};
	}

	//Returns the number of elements in the Circular Ring Array
	public int size() {

		if (!filled)
		{
			return head;
		}
		else
		{
			return ring.length;
		}
	}




}

