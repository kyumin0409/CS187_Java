package filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;

import structures.Queue;
import structures.UnboundedQueueInterface;

/**
 * An iterator to perform a level order traversal of part of a 
 * filesystem. A level-order traversal is equivalent to a breadth-
 * first search.
 * 
 * @author liberato
 *
 */
public class LevelOrderIterator extends FileIterator<File> {	
	
	UnboundedQueueInterface<File> queue;
	File[] fileArr;
	
	/**
	 * Instantiate a new LevelOrderIterator, rooted at the rootNode.
	 * @param rootNode
	 * @throws FileNotFoundException if the rootNode does not exist
	 */
	public LevelOrderIterator(File rootNode) throws FileNotFoundException {
		// TODO 1
		if(!rootNode.exists()){
			throw new FileNotFoundException();
		}
		queue = new Queue<File>();
		queue.enqueue(rootNode);
		fileArr = null;
	}
	
	@Override
	public boolean hasNext() {
		// TODO 2
		if(!(queue.isEmpty())){
				return true;
		}
		return false;
	}

	@Override
	public File next() throws NoSuchElementException {
		// TODO 3
		if(!hasNext()){
			throw new NoSuchElementException();
		}
		else{
			File temp = queue.dequeue();
			if(temp.isDirectory()){
				fileArr = temp.listFiles();
				Arrays.sort(fileArr);
				for(int i=0; i<fileArr.length; i++){
					queue.enqueue(fileArr[i]);
				}
			}
			return temp;
		}
	}

	@Override
	public void remove() {
		// Leave this one alone.
		throw new UnsupportedOperationException();		
	}

}
