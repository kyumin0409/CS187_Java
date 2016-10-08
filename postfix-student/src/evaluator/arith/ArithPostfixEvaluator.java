package evaluator.arith;

import language.Operand;
import language.Operator;
import parser.IllegalPostfixExpressionException;
import parser.PostfixParser.Type;
import parser.Token;
import parser.arith.ArithPostfixParser;
import stack.StackInterface;
import stack.LinkedStack;
import evaluator.PostfixEvaluator;

/**
 * An {@link ArithPostfixEvaluator} is a postfix evaluator over simple arithmetic expressions.
 *
 */
public class ArithPostfixEvaluator implements PostfixEvaluator<Integer> {

	private final StackInterface<Operand<Integer>> stack;
	
	/**
	 * Constructs an {@link ArithPostfixEvaluator}
	 */
	public ArithPostfixEvaluator(){
		stack = new LinkedStack();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer evaluate(String expr) throws IllegalPostfixExpressionException {
		// TODO use all of the things you've built so far to 
		// implement the algorithm for postfix expression evaluation
		boolean operatorExists = false;
		Integer result =null;
		ArithPostfixParser parser = new ArithPostfixParser(expr);
		for (Token<Integer> token : parser) {
			Type type = token.getType();
			switch(type){ 
			case OPERAND:
				//TODO What do we do when we see an operand?
				stack.push(token.getOperand());
				//System.out.println("operand: " + token.getOperand());
				break;
			case OPERATOR:
				operatorExists = true;
				//TODO What do we do when we see an operator?
				Operand<Integer> t = stack.pop();
				if(token.getOperator().getNumberOfArguments()==1){
					token.getOperator().setOperand(0, t);
				}
				else{
					//System.out.println("t: " + t);
					//System.out.println("size: " + stack.size());
					token.getOperator().setOperand(1, t);
					//System.out.println("2");
					Operand<Integer> s = stack.pop();
					//System.out.println("s: " + s);
					//System.out.println("size: " + stack.size());
					token.getOperator().setOperand(0, s);

				}
				stack.push(token.getOperator().performOperation());
				break;
			default:
				throw new IllegalStateException("Parser returned an invalid Type: " + type);
			}			
		}
		if(operatorExists == false && stack.size()!=1){
			throw new IllegalPostfixExpressionException("There was no operator");
		}
		result = stack.top().getValue();
		//System.out.println(result);
		//TODO What do we return?
		return result;
	}

}
