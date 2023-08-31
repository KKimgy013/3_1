package Running;

import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;

public class Main {
	public static void main(String[] args){
		File file = new File("C:\\Users\\USER\\eclipse-workspace\\Com_0511\\src\\Running\\Test.java");
		evaluate(file);
	}
	static String result = "";
	private static void evaluate(File file) {
		Lexical_Analyzer Lexana = new Lexical_Analyzer();
		Map<Integer, Map<String, Token>> tokensTable = Lexana.analyzeCode(file.toPath());
    	
        try{
    		File file2 = new File("C:\\Users\\USER\\eclipse-workspace\\Com_0511\\Test_output.txt");
    		FileWriter fileWriter = new FileWriter(file2);
    		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    		tokensTable.forEach((k, v) ->
            v.forEach((str, token) ->
    			 {
    				 	result= "> Line: " + k + "   Token: " + token + "   Attribute: " + str + "\n";
						try {
							bufferedWriter.write(result);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return;
    			 }
    			 )
    		);
    		bufferedWriter.close();
        }catch(IOException e) {
        	e.printStackTrace();
        }
	}
	
}
