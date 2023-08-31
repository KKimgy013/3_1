package Running;
import java.util.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Lexical_Analyzer {
	private Map<String, Token> keywordsAndOperatorsMap;
	
	public Lexical_Analyzer() {
		this.keywordsAndOperatorsMap = new HashMap<>();
		keywordsAndOperatorsMap.put("true", Token.BOOLEAN_STRING);
		keywordsAndOperatorsMap.put("false", Token.BOOLEAN_STRING);
		
        keywordsAndOperatorsMap.put("if", Token.KEYWORD);
        keywordsAndOperatorsMap.put("else", Token.KEYWORD);
        keywordsAndOperatorsMap.put("while", Token.KEYWORD);  
        keywordsAndOperatorsMap.put("class", Token.KEYWORD);
        keywordsAndOperatorsMap.put("return", Token.KEYWORD);
        keywordsAndOperatorsMap.put("public", Token.KEYWORD);
        keywordsAndOperatorsMap.put("static", Token.KEYWORD);  
        keywordsAndOperatorsMap.put("void", Token.KEYWORD);
        keywordsAndOperatorsMap.put("main", Token.KEYWORD);
        keywordsAndOperatorsMap.put("args", Token.KEYWORD);  
        keywordsAndOperatorsMap.put("package", Token.KEYWORD);
        
        keywordsAndOperatorsMap.put("int", Token.TYPE);
        keywordsAndOperatorsMap.put("char", Token.TYPE);  
        keywordsAndOperatorsMap.put("boolean", Token.TYPE);
        keywordsAndOperatorsMap.put("String", Token.TYPE);
        
        keywordsAndOperatorsMap.put("+", Token.ARITHMETIC_OPERATOR);
        keywordsAndOperatorsMap.put("-", Token.ARITHMETIC_OPERATOR);
        keywordsAndOperatorsMap.put("*", Token.ARITHMETIC_OPERATOR);
        keywordsAndOperatorsMap.put("/", Token.ARITHMETIC_OPERATOR);
        keywordsAndOperatorsMap.put("=", Token.ASSIGNMENT_OPERATOR);
        keywordsAndOperatorsMap.put(">", Token.COMPARISON_OPERATOR);
        keywordsAndOperatorsMap.put("<", Token.COMPARISON_OPERATOR);
        keywordsAndOperatorsMap.put("==", Token.COMPARISON_OPERATOR);
        keywordsAndOperatorsMap.put("!=", Token.COMPARISON_OPERATOR);        
        keywordsAndOperatorsMap.put("<=", Token.COMPARISON_OPERATOR);
        keywordsAndOperatorsMap.put(">=", Token.COMPARISON_OPERATOR);
        
        keywordsAndOperatorsMap.put(";", Token.SEMI);
        
        keywordsAndOperatorsMap.put("{", Token.LBRACE);
        keywordsAndOperatorsMap.put("}", Token.RBRACE);
        
        keywordsAndOperatorsMap.put("(", Token.LPAREN);
        keywordsAndOperatorsMap.put(")", Token.RPAREN);
        
        keywordsAndOperatorsMap.put("[", Token.LBRACK);
        keywordsAndOperatorsMap.put("]", Token.RBRACK);
        
        keywordsAndOperatorsMap.put(",", Token.COMMA);
	}
	public Map<Integer, Map<String, Token>> analyzeCode(Path filePath) {
	        Map<Integer, Map<String, Token>> mapTokensLine = new LinkedHashMap<>();
	        try {
	            List<String> lines = Files.readAllLines(filePath, Charset.forName("UTF-8"));
	            for (int i = 0; i < lines.size(); i++) {
	                Map<String, Token> lineTokens = analyzeLine(lines.get(i).strip());
	                mapTokensLine.put(i + 1, lineTokens);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return mapTokensLine;
	    }
	    private Map<String, Token> analyzeLine(String line) {
	        Map<String, Token> lineTokens = new HashMap<>();
	        Automata automaton = new Automata();
	        for (String str : line.split(" ")) {
	            if (keywordsAndOperatorsMap.containsKey(str.toLowerCase()))
	                lineTokens.put(str, keywordsAndOperatorsMap.get(str.toLowerCase()));
	            else
	                lineTokens.put(str, automaton.evaluate(str));
	        }
	        return lineTokens;
	    }


}
