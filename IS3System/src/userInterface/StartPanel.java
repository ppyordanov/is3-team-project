/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package startpage;

public class StartPage {

// P. Yordanov
	/* BASIC STRUCTURE
	a hash map data to store everything from the imported .csv file
	data <String, hash map item> = <K,V> will comprise of K - country V - attrubutes which will be easily accessible
	item hash map <String, String> = <K,V> K - attribute names from 1st line of CSV file - V - their according values in the file -this should/ could be changed to double later
	
	getters:
		param1 getter for main screen
		param2 getter for main screen
		chosen country getter
		chosen continents arraylist getter for main screen
		String country getter for main scr.
	*/
    public ArrayList<String> parameters = new ArrayList<String>();
    public ArrayList<String> continents = new ArrayList<String>();
   
    public ArrayList<String> keys = new ArrayList<String>();
    public String country;
    public String param_1;
    public String param_2;
   
    public HashMap <String, HashMap <String, String>> data = new HashMap <String, HashMap <String, String>>();
    public HashMap <String, String> item = new HashMap <String, String>();
   
    public void main1(String[] args) throws IOException {
        FileReader reader = new FileReader("WHO_data.csv");
        Scanner fScan = new Scanner(reader);
        keys = new  ArrayList<String> (Arrays.asList(fScan.nextLine().split("\\;")));
        String c;
       
        while(fScan.hasNextLine()){
            int i = 1;
            String line = fScan.nextLine();
            Scanner lScan = new Scanner(line);
            lScan.useDelimiter(";");
            item = new HashMap <String, String>();
            c = lScan.next();
            while(lScan.hasNext()){
                String value = lScan.next();
                item.put(keys.get(i), value);
                i++;
            }
           
            data.put(c, item);
        }
       
       
        // get parameter values
       
        // getters and setters
        
        // the arrays/ array lists will be built into dropdown menus
    }
   
   
    public String getParam1(){
        return param1;
    }
    
    public String getParam2(){
        return param2;
    }

    public String getCountry){
        return country;
    }
    
    public ArrayList<String> getContinents(){
        return continents;
    }
   
    public HashMap<String, HashMap <String, String>> getData(){
        return data;
    }
   
    // P. Yordanov
    
}
