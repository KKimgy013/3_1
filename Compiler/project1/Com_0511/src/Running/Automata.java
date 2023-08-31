package Running;

import java.util.HashMap;
import java.util.Map;

public class Automata {
	private Map<State, Token> finalStates;
    public Automata() {
        finalStates = new HashMap<>();
        finalStates.put(State.Q1, Token.INTEGER);       
        finalStates.put(State.Q2, Token.LITERAL_STRING);           
        finalStates.put(State.Q3, Token.IDENTIFIER);
        finalStates.put(State.Q6, Token.ARITHMETIC_OPERATOR);

    }
    private State executeTransition(State currentState, char entry) {
        switch (currentState) {
            case INITIAL: {
            	if ((entry >= '0' && entry <= '9'))
                    return State.Q1;
            	else if (entry == '"')                	
                    return State.Q2;
                else if ((entry >= 'A' && entry <= 'Z') || (entry >= 'a' && entry <= 'z') || entry == '_')
                    return State.Q3;
                else if(entry == '-')
                	return State.Q4;
                else
                    return State.INVALIDATION_STATE;
            }
            case Q1: {
                if (entry >= '0' && entry <= '9')
                    return State.Q1;
                else
                    return State.INVALIDATION_STATE;
            }
            case Q2: {
            	return (entry == '\0')
            			||(entry >= 'A' && entry <= 'Z')
                        || (entry >= 'a' && entry <= 'z')
                        ? State.Q2 : State.INVALIDATION_STATE;
            }
            case Q3: {
            	return (entry >= 'A' && entry <= 'Z')
                        || (entry >= 'a' && entry <= 'z')
                        || (entry == '_')
                        || (entry >= '0' && entry <= '9')
                        ? State.Q3 : State.INVALIDATION_STATE;
            }
            case Q4: {
            	if(entry == '\0')
            		return State.Q5;
            }
           case Q5: {
            	if (entry >= '0' && entry <= '9')
                    return State.Q1;
            	else if((entry >= 'A' && entry <= 'Z') || (entry >= 'a' && entry <= 'z'))
            		return State.Q6;
            }
           case Q6: 
            default:
                return State.INVALIDATION_STATE;
        }
    }
    public Token evaluate(String str){
        State state = State.INITIAL;
        for(char c : str.toCharArray()){
        	state = executeTransition(state, c);
        }
        return finalStates.getOrDefault(state, Token.INVALID);
    }
}
