import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.lang.Exception;

import org.json.JSONException;
import org.json.JSONObject;


//get org.json jar file from:
//https://mvnrepository.com/artifact/org.json/json/20140107
//https://gist.github.com/doug-ol/0c018e82c095cd3addcb1275999c966f

public class JSON {

	public static void main(String[] args) {
		
		 
 		File file;
		  if (args.length > 0) {
			  System.out.println("args[0] "+args[0]);
			  file= new File(args[0]);
		  }
		  else file= new File("JSON_Cases.txt");
		try{
			  Scanner sc = new Scanner(file); //throws FileNotFoundException if file not found
			  while (sc.hasNextLine()){
			    	jsonInput.append(sc.nextLine());
			  }
			  System.out.println("File found. Read JSON string from file.");
		  }
		  catch(Exception e) { 
			System.out.println("File Not found. \nEnter input JSON below and press 'enter' twice :\n");
		     // enter string input in the console
		    Scanner scanner = new Scanner(System.in);
			while (scanner.hasNextLine()) {
				String hold = scanner.nextLine();
				if (!hold.equals("")) jsonInput.append(hold);
				else break;
			}
			scanner.close(); // Not required for stdin but good practice
		   }
		   System.out.println("Input JSON:\n"+jsonInput);
		     
		
		     try {
		            JSONObject j = new JSONObject(jsonInput.toString());
		            String prevNodesList= "";
		            JSONObject result = new JSONObject();
		            parseJSON(j, prevNodesList, result);
		            System.out.println(result);

		     }  catch (JSONException e) {
		            e.printStackTrace();
		        }
		

	}

//given a JSONObject j, the method will return a path to every terminal value in the JSON structure.
//	For example, consider the following JSON object:
//
//	{
//	    "a": 1,
//	    "b": true,
//	    "c": {
//	        "d": 3
//	    }
//	}
//	In this example the path to the terminal value 1 is "a" and the path to the terminal value 3 is "c.d".
//	The JSONObject result from this method is:
//	{
//	    "a": 1,
//	    "b": true,
//	    "c.d": 3
//	}

public static void parseJSON(JSONObject j, String prevNodesList, JSONObject result){
    if(j==null)return;
      try {
          Iterator itrKey = j.keys();
          while(itrKey.hasNext()){
              String key = (String)itrKey.next();
              String prevNodesListCopy= prevNodesList+ "."+key;
              Object value = j.get(key);
              if ( value instanceof JSONObject) {
                  parseJSON((JSONObject)value,prevNodesListCopy,result);
              }
              else {
            	  	result.put(prevNodesListCopy.substring(1), value);
              } 
          }
         
      }  catch (JSONException e) {
          e.printStackTrace();
      }
  }

}
