package structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class MaxQueueTest {

  MaxQueue<String> queue;
	
  @Before
  public void setup() {
    queue = new MaxQueue<String>();
  }

  @Test (timeout = 100)
  public void testQueue() {
    queue.enqueue(100, "Highest priority");
    queue.enqueue(50, "High priority");
    queue.enqueue(25, "Medium priority");
    queue.enqueue(0, "Low priority");
    assertEquals("Highest priority", queue.dequeue());
    assertEquals("High priority", queue.dequeue());
    assertEquals("Medium priority", queue.dequeue());
    assertEquals("Low priority", queue.dequeue());
  }

  @Test(timeout=100)
  public void testIterator(){
	  queue.enqueue(100, "Highest priority");
	    queue.enqueue(50, "High priority");
	    queue.enqueue(25, "Medium priority");
	    queue.enqueue(0, "Low priority");
	    Iterator<Entry<Integer, String>> iter = queue.iterator();
	    assertEquals(iter.next().getValue(), "Highest priority");
	    
	    
  }
}
