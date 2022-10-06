package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * An implementation of a Searcher that performs an iterative search,
 * storing the list of next states in a Stack. This results in a
 * depth-first search.
 * 
 */
public class StackBasedDepthFirstSearcher<T> extends Searcher<T> {
	
	public StackBasedDepthFirstSearcher(SearchProblem<T> searchProblem) {
		super(searchProblem);
	}

	@Override
	public List<T> findSolution() {
		// TODO
		//System.out.println("*************");
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
		Stack<T> stack = new Stack<T>();
		stack.push(initialState);
		T current = initialState;
		path.add(current);
		if(searchProblem.isGoal(initialState)){
			//path.add(initialState);
			return path;
		}
		//System.out.println("initialized everything");
		do{
			//System.out.println("beginning loop");
			//path.add(current);
			//System.out.println(current);
			visited.add(current);
			List<T> n = searchProblem.getSuccessors(current);
			List<T> neighbors = new ArrayList<T>();
			for(T a : n){
				if(!visited.contains(a)){
					neighbors.add(a);
				}
			}
			if(neighbors.size()==0){
				//System.out.println("path size: " + path.size());
				path.remove(path.size()-1);
				current = path.get(path.size()-1);
				continue;
			}
			for(T b: neighbors){
					stack.push(b);
				//visited.add(n);
			}
			current = stack.pop();
			path.add(current);
			//System.out.println("infinite loop");
		}while(!searchProblem.isGoal(current));
		
		if(path.size()>0){
			if(!isValidSolution(path)){
				throw new RuntimeException("searcher should never find an invalid solution!");
			}
		}
		
		return path;
	}
	
	private boolean isPath(){
		visited.clear();
		boolean found = false;
		Stack<T> stack = new Stack<T>();
		stack.push(searchProblem.getInitialState());
		do{
			T top = stack.pop();
			if(searchProblem.isGoal(top)){
				found = true;
			}else{
				if(!visited.contains(top)){
					visited.add(top);
					List<T> neighbors = searchProblem.getSuccessors(top);
					for(T a : neighbors){
						stack.push(a);
					}
				}
			}
		}while(!stack.isEmpty() && !found);
		
		return found;
	}
}
