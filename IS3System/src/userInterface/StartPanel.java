/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package startpage;

public class StartPage {

// P. Yordanov
 
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
    }
   
    public HashMap<String, HashMap <String, String>> getData(){
        return data;
    }
   
    // P. Yordanov
    
}
