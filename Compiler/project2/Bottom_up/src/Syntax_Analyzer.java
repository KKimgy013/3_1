import java.util.ArrayList;
import java.io.*;
public class Syntax_Analyzer {
	String [][] table = new String[77][42];      
	ArrayList<String> stack = new ArrayList<String>();
	ArrayList<String> input = new ArrayList<String>();
	ArrayList<String> action = new ArrayList<String>();
	String stackString,inputString,actionString;
	String fileName = "Test_input.txt";  
	public  Syntax_Analyzer(String input,String fileName){        
		 for(int i = 0;i<77;i++)
		 for (int j = 0 ;j<42;j++)
		    table[i][j] = "X";
		        table[0][0] = "Shift 5";
		        table[0][21] = "Shift 6";
		        table[0][24] = "1";
		        table[0][25] = "2";
		        table[0][31] = "3";
		        table[0][40] = "4";

		        table[1][22] = "acc";

		        table[2][0] = "Shift 5";
		        table[2][21] = "Shift 6";
		        table[2][24] = "7";
		        table[2][25] = "2";
		        table[2][31] = "3";
		        table[2][40] = "4";

		        table[3][0] = "Shift 5";
		        table[3][21] = "Shift 6";
		        table[3][24] = "8";
		        table[3][25] = "2";
		        table[3][31] = "3";
		        table[3][40] = "4";

		        table[4][0] = "Shift 5";
		        table[4][21] = "Shift 6";
		        table[4][24] = "9";
		        table[4][25] = "2";
		        table[4][31] = "3";
		        table[4][40] = "4";

		        table[5][1] = "Shift 10";
		        table[5][26] = "11";

		        table[6][1] = "Shift 12";
		        
		        table[7][22] = "Reduce 1";

		        table[8][22] = "Reduce 2"; 

		        table[10][2] = "Shift 13";
		        table[10][3] = "Shift 15";
		        table[10][9] = "Shift 14"; 

		        table[11][2] = "Shift 16";

		        table[12][12] = "Shift 17";

		        table[13][0] = "Reduce 4";
		        table[13][1] = "Reduce 4"; 
		        table[13][15] = "Reduce 4";
		        table[13][16] = "Reduce 4";
		        table[13][21] = "Reduce 4"; 
		        
		        table[14][0] = "Shift 19";
		        table[14][32] = "18";

		        table[15][2] = "Reduce 6";
		        
		        table[16][0] = "Reduce 5";
		        table[16][1] = "Reduce 5"; 
		        table[16][15] = "Reduce 5"; 
		        table[16][16] = "Reduce 5"; 
		        table[16][21] = "Reduce 5"; 

		        table[17][0] = "Shift 5"; 
		        table[17][25] = "21"; 
		        table[17][31] = "22"; 
		        table[17][41] = "20"; 

		        table[18][10] = "Shift 23";

		        table[19][1] = "Shift 24";

		        table[20][13] = "Shift 25";

		        table[21][0] = "Shift 5";
		        table[21][25] = "21"; 
		        table[21][31] = "22"; 
		        table[21][41] = "26";

		        table[22][0] = "Shift 5";
		        table[22][25] = "21"; 
		        table[22][31] = "22";
		        table[22][41] = "27"; 

		        table[23][12] = "Shift 28";

		        table[24][14] = "Shift 30";
		        table[24][33] = "29";

		        table[25][0] = "Reduce 28"; 
		        table[25][21] = "Reduce 28"; 

		        table[27][13] = "Reduce 30";
		        
		        table[28][0] = "Shift 37";
		        table[28][1] = "Shift 38";
		        table[28][15] = "Shift 35";
		        table[28][16] = "Shift 36";  
		        table[28][25] = "33";
		        table[28][26] = "34"; 
		        table[28][34] = "31";
		        table[28][35] = "32";

		        table[30][0] = "Shift 39"; 

		        table[31][19] = "Shift 41"; 
		        table[31][39] = "40"; 

		        table[32][0] = "Shift 37";
		        table[32][1] = "Shift 38"; 
		        table[32][15] = "Shift 35";
		        table[32][16] = "Shift 36";  
		        table[32][25] = "33"; 
		        table[32][26] = "34"; 
		        table[32][34] = "42";
		        table[32][35] = "32";

		        table[33][0] = "Reduce 20";
		        table[33][1] = "Reduce 20"; 
		        table[33][15] = "Reduce 20";
		        table[33][16] = "Reduce 20";  

		        table[34][2] = "Shift 43";

		        table[35][9] = "Shift 44"; 

		        table[36][9] = "Shift 45"; 

		        table[37][1] = "Shift 46"; 
		        table[37][26] = "11";

		        table[38][3] = "Shift 15";

		        table[39][1] = "Shift 47"; 

		        table[40][13] = "Shift 48";

		        table[41][1] = "Shift 55"; 
		        table[41][4] = "Shift 51";
		        table[41][5] = "Shift 52";
		        table[41][6] = "Shift 53"; 
		        table[41][9] = "Shift 54";
		        table[41][11] = "Shift 56";  
		        table[41][27] = "49"; 
		        table[41][30] = "50"; 

		        table[43][0] = "Reduce 21";
		        table[43][1] = "Reduce 21";
		        table[43][15] = "Reduce 21";
		        table[43][16] = "Reduce 21"; 

		        table[44][6] = "Shift 58";
		        table[44][37] = "57";  

		        table[45][6] = "Shift 58";  
		        table[45][37] = "59"; 

		        table[46][2] = "Shift 13";
		        table[46][3] = "Shift 15";

		        table[47][14] = "Shift 30";
		        table[47][33] = "60"; 

		        table[48][0] = "Reduce 16";
		        table[48][21] = "Reduce 16"; 

		        table[49][20] = "Shift 61"; 

		        table[50][20] = "Reduce 7"; 

		        table[51][20] = "Reduce 8";

		        table[52][20] = "Reduce 9";

		        table[53][20] = "Reduce 10";

		        table[54][1] = "Shift 55"; 
		        table[54][9] = "Shift 54";
		        table[54][11] = "Shift 56";  
		        table[54][30] = "62";  

		        table[55][7] = "Reduce 14"; 
		        table[55][8] = "Reduce 14"; 
		        table[55][10] = "Reduce 14";
		        table[55][20] = "Reduce 14";

		        table[56][7] = "Reduce 15"; 
		        table[56][8] = "Reduce 15"; 
		        table[56][10] = "Reduce 15";
		        table[56][20] = "Reduce 15";

		        table[57][10] = "Shift 63";
		        
		        table[58][10] = "Reduce 25"; 
		        table[58][17] = "Reduce 25";

		        table[59][10] = "Shift 64"; 

		        table[61][2] = "Shift 65"; 
		        
		        table[62][10] = "Shift 66"; 

		        table[63][12] = "Shift 67";

		        table[64][12] = "Shift 68";

	 	        table[65][13] = "Reduce 27"; 
	 	        
		        table[66][7] = "Reduce 13";
		        table[66][8] = "Reduce 13";
		        table[66][10] = "Reduce 13"; 
		        table[66][20] = "Reduce 13";

		        table[67][0] = "Shift 37";  
		        table[67][1] = "Shift 38"; 
		        table[67][15] = "Shift 35"; 
		        table[67][16] = "Shift 36"; 
		        table[67][25] = "33";
		        table[67][26] = "34";
		        table[67][34] = "69"; 
		        table[67][35] = "32";

		        table[68][0] = "Shift 37";  
		        table[68][1] = "Shift 38"; 
		        table[68][15] = "Shift 35"; 
		        table[68][16] = "Shift 36"; 
		        table[68][25] = "33";
		        table[68][26] = "34";
		        table[68][34] = "70"; 
		        table[68][35] = "32";

		        table[69][16] = "Shift 71";  

		        table[70][13] = "Shift 72"; 
		        
		        table[71][18] = "Shift 74"; 
		        table[71][38] = "73"; 

		        table[72][0] = "Reduce 23";
		        table[72][1] = "Reduce 23";
		        table[72][15] = "Reduce 23"; 
		        table[72][16] = "Reduce 23";

		        table[73][0] = "Reduce 22";
		        table[73][1] = "Reduce 22";
		        table[73][15] = "Reduce 22"; 
		        table[73][16] = "Reduce 22";

		        table[74][12] = "Shift 75";  

		        table[75][0] = "Shift 37";  
		        table[75][1] = "Shift 38"; 
		        table[75][15] = "Shift 35"; 
		        table[75][16] = "Shift 36"; 
		        table[75][25] = "33";
		        table[75][26] = "34";
		        table[75][34] = "76"; 
		        table[75][35] = "32";
		        
		        table[76][13] = "Shift 77";   

		        stackString = "0";
		        inputString = input;
		        actionString = this.findAction();
		        stack.add("0");
		        this.input.add(input);
		        action.add(actionString);
		        this.fileName = fileName;
		    }

		    void bottomup (){      
		        while (true){
		            if(actionString.equals("Accept") ){
		                accept();
		                break;
		            }
		            if(actionString.equals("X")){
		                action.set(action.size()-1, "ERROR");
		                error();
		                break;
		            }
		            else if(actionString.charAt(0) == 'S'){
		                shift(actionString);
		                actionString =  findAction();
		                stack.add(stackString);
		                input.add(inputString);
		                action.add(actionString);
		            }
		            else if(actionString.charAt(0) == 'R'){
		                reduce(actionString);
		                actionString =  findAction();
		                stack.add(stackString);
		                input.add(inputString);
		                action.add(actionString);
		            }
		        }
		    }
		    void reduce(String reduce){        
		        int reduceNo = toInteger(reduce.substring(7));
		        if (reduceNo == 1 ){
		            stackString = stackString.substring(0,stackString.lastIndexOf('C'));
		            stackString += "C";
		            int row = parseRowByReducer(stackString);
		            int col = findIndex("C");
		            stackString += table[row][col];
		        }
		        if (reduceNo == 2 ){
		            stackString = stackString.substring(0,stackString.lastIndexOf('V'));
		            stackString += "C";
		            int row = parseRowByReducer(stackString);
		            int col = findIndex("C");
		            stackString += table[row][col];
		        }
		        if (reduceNo == 4 ){
		            stackString = stackString.substring(0,stackString.lastIndexOf('C'));
		            stackString += "C";
		            int row = parseRowByReducer(stackString);
		            int col = findIndex("C");
		            stackString += table[row][col];
		        }
		        if (reduceNo == 5 ){
		            stackString = stackString.substring(0,stackString.lastIndexOf('v'));
		            stackString += "V";
		            int row = parseRowByReducer(stackString);
		            int col = findIndex("V");
		            stackString += table[row][col];
		        }
		        if (reduceNo == 6 ){        // BUNA DIKKATLI BAK
		            stackString = stackString.substring(0,stackString.lastIndexOf('v'));
		            stackString += "V";
		            int row = parseRowByReducer(stackString);
		            int col = findIndex("V");
		            stackString += table[row][col];
		        }
		        if (reduceNo == 7 ){
		            stackString = stackString.substring(0,stackString.lastIndexOf('i'));
		            stackString += "A";
		            int row = parseRowByReducer(stackString);
		            int col = findIndex("A");
		            stackString += table[row][col];
		        }
	 	        if (reduceNo == 8 ){
		            stackString = stackString.substring(0,stackString.lastIndexOf('E'));
		            stackString += "R";
		            int row = parseRowByReducer(stackString);
		            int col = findIndex("R");
		            stackString += table[row][col];
		        }
		        if (reduceNo == 9 ){
		            stackString = stackString.substring(0,stackString.lastIndexOf('l'));
		            stackString += "R";
		            int row = parseRowByReducer(stackString);
		            int col = findIndex("R");
		            stackString += table[row][col];
		        }
		        if (reduceNo == 10 ){
		            stackString = stackString.substring(0,stackString.lastIndexOf('c'));
		            stackString += "R";
		            int row = parseRowByReducer(stackString);
		            int col = findIndex("R");
		            stackString += table[row][col];
		        }
	 	        if (reduceNo == 13 ){
		            stackString = stackString.substring(0,stackString.lastIndexOf('E'));
		            stackString += "E";
		            int row = parseRowByReducer(stackString);
		            int col = findIndex("E");
		            stackString += table[row][col];
		        }
		        if (reduceNo == 14 ){
		            stackString = stackString.substring(0,stackString.lastIndexOf('l'));
		            stackString += "E";
		            int row = parseRowByReducer(stackString);
		            int col = findIndex("E");
		            stackString += table[row][col];
		        }
		        if (reduceNo == 15 ){
		            stackString = stackString.substring(0,stackString.lastIndexOf('i'));
		            stackString += "E";
		            int row = parseRowByReducer(stackString);
		            int col = findIndex("E");
		            stackString += table[row][col];
		        }
		        if (reduceNo == 16 ){
		            stackString = stackString.substring(0,stackString.lastIndexOf('n'));
		            stackString += "E";
		            int row = parseRowByReducer(stackString);
		            int col = findIndex("E");
		            stackString += table[row][col];
		        }
		        if (reduceNo == 20 ){
		            stackString = stackString.substring(0,stackString.lastIndexOf('S'));
		            stackString += "B";
		            int row = parseRowByReducer(stackString);
		            int col = findIndex("B");
		            stackString += table[row][col];
		        }
		        if (reduceNo == 21 ){
		            stackString = stackString.substring(0,stackString.lastIndexOf('V'));
		            stackString += "S";
		            int row = parseRowByReducer(stackString);
		            int col = findIndex("S");
		            stackString += table[row][col];
		        }
		        if (reduceNo == 22 ){
		            stackString = stackString.substring(0,stackString.lastIndexOf('A'));
		            stackString += "S";
		            int row = parseRowByReducer(stackString);
		            int col = findIndex("S");
		            stackString += table[row][col];
		        }
		        if (reduceNo == 23 ){
		            stackString = stackString.substring(0,stackString.lastIndexOf('i'));
		            stackString += "S";
		            int row = parseRowByReducer(stackString);
		            int col = findIndex("S");
		            stackString += table[row][col];
		        }
		        if (reduceNo == 25 ){
		            stackString = stackString.substring(0,stackString.lastIndexOf('C'));
		            stackString += "C";
		            int row = parseRowByReducer(stackString);
		            int col = findIndex("C");
		            stackString += table[row][col];
		        }
		        if (reduceNo == 27 ){
		            stackString = stackString.substring(0,stackString.lastIndexOf('e'));
		            stackString += "E";
		            int row = parseRowByReducer(stackString);
		            int col = findIndex("E");
		            stackString += table[row][col];
		        }
		        if (reduceNo == 28 ){
		            stackString = stackString.substring(0,stackString.lastIndexOf('r'));
		            stackString += "R";
		            int row = parseRowByReducer(stackString);
		            int col = findIndex("R");
		            stackString += table[row][col];
		        }
		    }
		    void shift(String shift){          
		        shift = shift.substring(6);
		        if(inputString.charAt(0) == 'v')  {        
		            stackString += "vtype";
		            stackString += shift;
		            inputString = inputString.substring(5);
		        }
		        else if(inputString.charAt(0) == 'i' & inputString.charAt(1) == 'd')  {       
		            stackString += "id";
		            stackString += shift;
		            inputString = inputString.substring(2);
		        }
		        else if(inputString.charAt(0) == 's')  {   
		            stackString += "semi";
		            stackString += shift;
		            inputString = inputString.substring(4);
		        }
		        else if(inputString.charAt(0) == 'a' & inputString.charAt(1) == 's' )  {      
		            stackString += "assign";
		            stackString += shift;
		            inputString = inputString.substring(6);
		        }
		        else if(inputString.charAt(0) == 'l' & inputString.charAt(1) == 'i')  {        
		            stackString += "literal";
		            stackString += shift;
		            inputString = inputString.substring(7);
		        }
	 	        else if(inputString.charAt(0) == 'c'& inputString.charAt(1) == 'h')  {        
		            stackString += "character";
		            stackString += shift;
		            inputString = inputString.substring(9);
		        }
		        else if(inputString.charAt(0) == 'b')  {        
		            stackString += "boolstr";
		            stackString += shift;
		            inputString = inputString.substring(7);
		        }
		        else if(inputString.charAt(0) == 'a' & inputString.charAt(1) == 'd')  {        
		            stackString += "addsub";
		            stackString += shift;
		            inputString = inputString.substring(6);
		        }
	 	        else if(inputString.charAt(0) == 'm')  {        
		            stackString += "multdiv";
		            stackString += shift;
		            inputString = inputString.substring(7);
		        }
	 	        else if(inputString.charAt(0) == 'l' & inputString.charAt(1) == 'p' )  {        
		            stackString += "lparen";
		            stackString += shift;
		            inputString = inputString.substring(6);
		        }
	 	        else if(inputString.charAt(0) == 'r' & inputString.charAt(1) == 'p' )  {        
	 	        	stackString += "rparen";
		            stackString += shift;
		            inputString = inputString.substring(6);
		        }
	 	        else if(inputString.charAt(0) == 'n' )  {        
		            stackString += "num";
		            stackString += shift;
		            inputString = inputString.substring(6);
		        }
	 	        else if(inputString.charAt(0) == 'l' & inputString.charAt(1) == 'b' )  {        
		            stackString += "lbrace";
		            stackString += shift;
		            inputString = inputString.substring(6);
		        }
	 	        else if(inputString.charAt(0) == 'r' & inputString.charAt(1) == 'b' )  {        
		            stackString += "rbrace";
		            stackString += shift;
		            inputString = inputString.substring(6);
	 	        }
	 	        else if(inputString.charAt(0) == 'c'& inputString.charAt(2) == 'm' )  {        
		            stackString += "comma";
		            stackString += shift;
		            inputString = inputString.substring(6);
		        }
	 	        else if(inputString.charAt(0) == 'i' & inputString.charAt(1) == 'f' )  {        
		            stackString += "if";
		            stackString += shift;
		            inputString = inputString.substring(6);
		        }
	 	        else if(inputString.charAt(0) == 'w' )  {        
		            stackString += "while";
		            stackString += shift;
		            inputString = inputString.substring(6);
		        }
	 	        else if(inputString.charAt(0) == 'c' & inputString.charAt(3) == 'p' )  {        
		            stackString += "comp";
		            stackString += shift;
		            inputString = inputString.substring(6);
	 	        }
	 	       else if(inputString.charAt(0) == 'e' )  {        
		            stackString += "else";
		            stackString += shift;
		            inputString = inputString.substring(6);
	 	        }
	 	      else if(inputString.charAt(0) == 'r' )  {        
		            stackString += "return";
		            stackString += shift;
		            inputString = inputString.substring(6);
	 	        }
	 	     else if(inputString.charAt(0) == ' ' )  {        
		            stackString += " ";
		            stackString += shift;
		            inputString = inputString.substring(6);
	 	        }
	 	    else if(inputString.charAt(0) == 'c' & inputString.charAt(1) == 'l' )  {        
	            stackString += "class";
	            stackString += shift;
	            inputString = inputString.substring(6);
 	        }
	 	   else if(inputString.charAt(0) == '$' )  {        
	            stackString += "$";
	            stackString += shift;
	            inputString = inputString.substring(6);
	       }
		   }

		    String findAction(){                 
		        int row = parseRowByAction(stackString);
		        int col;
		        if(inputString.charAt(0) == 'v')  {        
		            col = findIndex("vtype");
		        }
		        else if(inputString.charAt(0) == 'i' & inputString.charAt(1) == 'd')  {       
		        	col = findIndex("id");
		        }
		        else if(inputString.charAt(0) == 's')  {   
		        	col = findIndex("semi");
		        }
		        else if(inputString.charAt(0) == 'a' & inputString.charAt(1) == 's' )  {      
		        	col = findIndex("assign");
		        }
		        else if(inputString.charAt(0) == 'l' & inputString.charAt(1) == 'i')  {        
		        	col = findIndex("literal");
		        }
	 	        else if(inputString.charAt(0) == 'c'& inputString.charAt(1) == 'h')  {        
	 	        	col = findIndex("character");
		        }
		        else if(inputString.charAt(0) == 'b')  {        
		        	col = findIndex("boolstr");
		        }
		        else if(inputString.charAt(0) == 'a' & inputString.charAt(1) == 'd')  {        
		        	col = findIndex("addsub");
		        }
	 	        else if(inputString.charAt(0) == 'm')  {        
		        	col = findIndex("multdiv");
		        }
	 	        else if(inputString.charAt(0) == 'l' & inputString.charAt(1) == 'p' )  {        
		        	col = findIndex("lparen");
		        }
	 	        else if(inputString.charAt(0) == 'r' & inputString.charAt(1) == 'p' )  {        
		        	col = findIndex("rparen");
		        }
	 	        else if(inputString.charAt(0) == 'n' )  {        
		        	col = findIndex("num");
		        }
	 	        else if(inputString.charAt(0) == 'l' & inputString.charAt(1) == 'b' )  {        
		        	col = findIndex("lbrace");
		        }
	 	        else if(inputString.charAt(0) == 'r' & inputString.charAt(1) == 'b' )  {        
		        	col = findIndex("rbrace");
	 	        }
	 	        else if(inputString.charAt(0) == 'c'& inputString.charAt(2) == 'm' )  {        
		        	col = findIndex("comma");
		        }
	 	        else if(inputString.charAt(0) == 'i' & inputString.charAt(1) == 'f' )  {        
		        	col = findIndex("if");
		        }
	 	        else if(inputString.charAt(0) == 'w' )  {        
		        	col = findIndex("while");
		        }
	 	        else if(inputString.charAt(0) == 'c' & inputString.charAt(3) == 'p' )  {        
		        	col = findIndex("comp");
	 	        }
	 	       else if(inputString.charAt(0) == 'e' )  {        
		        	col = findIndex("else");
	 	        }
	 	      else if(inputString.charAt(0) == 'r' )  {        
		        	col = findIndex("return");
	 	        }
	 	     else if(inputString.charAt(0) == ' ' )  {        
		        	col = findIndex(" ");
	 	        }
	 	     else if(inputString.charAt(0) == 'c' & inputString.charAt(1) == 'l' )  {        
		        	col = findIndex("class");
 	            }
	 	     else if(inputString.charAt(0) == '$' )  {        
		        	col = findIndex("$");
	            }
		     else {
		        col = -1;
		     }
		     return table[row][col];
		    }

		    void printStates(){             
		        if( (stack.size() != input.size()) && (stack.size() != action.size()) && input.size() != action.size()){
		            System.out.println("Error occurred.");
		            System.exit(1);
		        }
		        PrintWriter writer = null;
		    	String fileName2 = "output.txt";  
		        try  {
		            writer = new PrintWriter(new FileWriter(fileName2));
		        }
		        catch(IOException e)
		        {
		            e.printStackTrace();
		        }
		        for (int i = 0;i<stack.size();i++){
		            int stackElementSize = stack.get(i).length();
		            int inputElementSize = input.get(i).length();
		            int actionElementSize = action.get(i).length();
		            writer.println();
		            writer.print(stack.get(i));
		            for(int j = 0;j<20-stackElementSize;j++){
		                writer.print(" ");
		            }
		            writer.print(input.get(i));
		            for(int j = 0;j<20-inputElementSize;j++){
		                writer.print(" ");
		            }
		            writer.print(action.get(i));
		        }
		        writer.close();
		    }
		    int toInteger(String s){       
		        return Integer.parseInt(s);
		    }
		    int findIndex(String state){       
		        
		    }
		    int parseRowByReducer(String current){  
		        current = current.substring( 0,current.length()-1) ;
		        int i = current.length();
		        while (i > 0 && Character.isDigit(current.charAt(i-1))) {
		            i--;
		        }
		        return toInteger(current.substring(i));
		    }
		    int parseRowByAction(String current){    
		        if (stackString.equals("0"))
		            return 0;
		        int i = current.length();
		        while (i > 0 && Character.isDigit(current.charAt(i - 1))) {
		            i--;
		        }
		        return toInteger(current.substring(i));
		    }

		    public static void main(String[] args) {
		        Syntax_Analyzer s = new Syntax_Analyzer(args[0],args[1]);
		        s.bottomup();
		    }
}

