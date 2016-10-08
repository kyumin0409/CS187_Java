package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Collections;



import java.util.LinkedList;

/**
 * An implementation of a Searcher that performs an iterative search,
 * storing the list of next states in a Queue. This results in a
 * breadth-first search.
 * 
 */
public class QueueBasedBreadthFirstSearcher<T> extends Searcher<T> {
	public QueueBasedBreadthFirstSearcher(SearchProblem<T> searchProblem) {
		super(searchProblem);
	}

	@Override
	public List<T> findSolution() {
		// TODO
		if(solution != null){
			return solution;
		}
		visited.clear();
		List<T> path = new ArrayList<T>();
		if(isPath()==false){
			return path;
		}
		visited.clear();
		T initialState = searchProblem.getInitialState();
		Queue<T> queue = new LinkedList<T>();
		List<T> temp = new ArrayList<T>();
		T current = initialState;
		queue.add(current);
		do{
			visited.add(current);
			List<T> n = searchProblem.getSuccessors(current);
			List<T> neighbors = new ArrayList<T>();
			for(T a : n){
				if(!visited.contains(a)){
					neighbors.add(a);
				}
			}
			for(T b : neighbors){
				queue.add(b);
			}
			current = queue.remove();
			temp.add(current);
			
		}while(!searchProblem.isGoal(current));
		
		 int pointer = temp.size()-2;
		 path.add(current);
		 for(int i = pointer; i>=0; i--){
			 List<T> successors = searchProblem.getSuccessors(temp.get(i));
			 for(int j=0; j<successors.size(); j++){
				 if(current.equals(successors.get(j))){
					 path.add(temp.get(i));
					 current = temp.get(i);
				 }
			 }
		 }
		 
		 Collections.reverse(path);
		
		 if(path.size()>0){
			 if(!isValidSolution(path)){
				 throw new RuntimeException("searcher should never find an invalid solution!");
			 }
		 }
		 
		return path;
	}
	
	private boolean isPath(){
		boolean found = false;
		visited.clear();
		Queue<T> queue = new LinkedList<T>();
		queue.add(searchProblem.getInitialState());
		do{
			T top = queue.remove();
			if(searchProblem.isGoal(top)){
				found = true;
			}else{
				if(!visited.contains(top)){
					visited.add(top);
					List<T> neighbors = searchProblem.getSuccessors(top);
					for(T a : neighbors){
						queue.add(a);
					}
				}
			}
		}while(!queue.isEmpty() && !found);
		return found;
	}
}
