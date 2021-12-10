import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Tenth {
	public static void main(String[] args) {
		int somme=0, j=0;
		String[] tab= new String [106];
		int index=0;
		ArrayList<Integer> scores = new ArrayList<Integer>();
		String s="";
		int mult=0;
		ArrayList<String> brakets = new ArrayList<String>();
		ArrayList<String> corrupted = new ArrayList<String>();
		ArrayList<String> incomplete = new ArrayList<String>();
		boolean bool=false;
	    try {
	      File myObj = new File("text.txt");
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        tab[j] = data;
	        j++;
	      }
	      for(int k=0; k<tab.length; k++) {
	    	  s = tab[k];
	    	  for(int i=0; i<s.length(); i++) {
	    		  //System.out.println(s.charAt(i));
	    		  if(s.charAt(i)== '[' || s.charAt(i)== '(' || s.charAt(i)== '{' || s.charAt(i)== '<') {
	    			  brakets.add(""+s.charAt(i));
	    			  index = brakets.size();
	    		  }else {
	    			  if(index==0) {
	    				  corrupted.add(""+s.charAt(i));
	    				  bool = true;
	    				  break;
	    			  }else if(brakets.get(index-1).contentEquals("[")) {
	    				  //System.out.println("you're here");
	    				  if(s.charAt(i)== ']') {
	    					  brakets.remove(index-1); 
	    					  index = brakets.size();
	    				  }else {
	    					  corrupted.add(""+s.charAt(i));
	    					  bool = true;
	    					  break;
	    				  }
	    			  }else if(brakets.get(index-1).contentEquals("(")) {
	    				  if(s.charAt(i)== ')') {
	    					  brakets.remove(index-1); 
	    					  index = brakets.size();
	    				  }else {
	    					  corrupted.add(""+s.charAt(i));
	    					  bool = true;
	    					  break;
	    				  }
	    			  }else if(brakets.get(index-1).contentEquals("{")) {
	    				  if(s.charAt(i)== '}') {
	    					  brakets.remove(index-1); 
	    					  index = brakets.size();
	    				  }else {
	    					  corrupted.add(""+s.charAt(i));
	    					  bool = true;
	    					  break;
	    				  }
	    			  }else if(brakets.get(index-1).contentEquals("<")) {
	    				  if(s.charAt(i)== '>') {
	    					  brakets.remove(index-1); 
	    					  index = brakets.size();
	    				  }else {
	    					  corrupted.add(""+s.charAt(i));
	    					  bool = true;
	    					  break;
	    				  }
	    			  }
	    		  }
	    	  }
	    	  System.out.println("this is the rest" + brakets);
	    	  for(int o=brakets.size()-1; o>=0 && !bool; o--) {
	    		  incomplete.add(brakets.get(o));
	    		  if(incomplete.get(brakets.size()-1-o).equals("[")) {
		    		  mult = Math.abs(mult*5) + 2;
		    	  }
		    	  else if(incomplete.get(brakets.size()-1-o).equals("(")) {
		    		  mult = Math.abs(mult*5) + 1;
		    	  }else if(incomplete.get(brakets.size()-1-o).equals("{")) {
		    		  mult = Math.abs(mult*5) + 3;
		    	  }else if(incomplete.get(brakets.size()-1-o).equals("<")) {
		    		  mult = Math.abs(mult*5) + 4;
		    	  }

		    	  
		    	  
	    	  }
    		  if(mult != 0) {
    			  scores.add(mult);
    		  }
	    	  mult =0;
	    	  brakets.clear();
	    	  incomplete.clear();
	    	  bool = false;
	      }

	      System.out.println(scores.size());
	      
	      int total=0;

	      for(int i=0; i<corrupted.size(); i++) {
	    	  //System.out.println(corrupted.get(i).toString());
	    	  if(corrupted.get(i).equals("]")) {
	    		  total = total + 57;
	    	  }
	    	  else if(corrupted.get(i).equals(")")) {
	    		  total = total + 3;
	    	  }else if(corrupted.get(i).equals("}")) {
	    		  total = total + 1197;
	    	  }else if(corrupted.get(i).equals(">")) {
	    		  total = total + 25137;
	    	  }
	      }
	      System.out.println(total);
	      
	      
	      for(int i=0; i<incomplete.size(); i++) {
	    	  //System.out.println(incomplete.get(i).toString());
	    	  if(incomplete.get(i).equals("[")) {
	    		  mult = mult*5 + 2;
	    	  }
	    	  else if(incomplete.get(i).equals("(")) {
	    		  mult = mult*5 + 1;
	    	  }else if(incomplete.get(i).equals("{")) {
	    		  mult = mult*5 + 3;
	    	  }else if(incomplete.get(i).equals("<")) {
	    		  mult = mult*5 + 4;
	    	  }
	    	  scores.add(mult);
	    	  mult =0;
	      }
	      
	      Collections.sort(scores);
	      for(int i=0; i<scores.size(); i++) {
	    	  System.out.println("this is mult "+scores.get(i));
	      }
	      int res = scores.get(scores.size()/2);
	      
	      
	      System.out.println(res);
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }
}
