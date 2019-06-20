package jsonparser;
	import java.io.IOException;
	import java.io.InputStream;
	import java.net.MalformedURLException;
	import java.net.URL;
	import java.util.TreeMap;
	import com.fasterxml.jackson.core.JsonFactory;
	import com.fasterxml.jackson.core.JsonParser;
	import com.fasterxml.jackson.core.JsonToken;
import jsonparser.Toppings_Data;

	public class ProcessData {
		 private static final String TOPPINGS = "toppings";
		 private  TreeMap<String,Integer> toppingsMap  = new TreeMap<String,Integer>();
		 public  TreeMap<String, Integer> getToppingsMap() {
			return toppingsMap;
		}
		public  int toppingsFrequencies(int nos){//recursive method
		 	    if(nos == 0){
		 	    return nos ; 	
		 	    }	 	    
		 	 return toppingsFrequencies(nos-1);  
		           }  
		    // using the  jackson api  
		  public void processJson() throws MalformedURLException {
			  URL url = new URL("http://files.olo.com/pizzas.json"); // calling  the  webservices 
			   try (InputStream is = url.openStream() ;
			       JsonParser parser   =  new JsonFactory().createParser(is);) {
				   if(parser.nextToken() != JsonToken.START_ARRAY) {
					 System.out.println("there  is an error . it  has  to  start  with an array ");  
				       return ;
				      }	
				   JsonToken jsonToken = parser.nextToken();
				   //start  parsing the json file               
	                   while (parser.nextToken() != JsonToken.END_ARRAY) {
	                 String fieldname = parser.getCurrentName(); //get current name of token
	                	   if (TOPPINGS.equals(fieldname)) {  //array type field
	                          jsonToken = parser.nextToken();
	                   //  toppingsMap = new HashMap<>(); //read all elements and store into list
	                           while (parser.nextToken() != JsonToken.END_ARRAY) {
	                        	 parseToppingsData(parser.getText());                            
	                             } 
	                	    
	                          }
	                	   if(jsonToken==JsonToken.END_OBJECT){
	                           //do some processing, Indexing, saving in DB etc..                       
	                           //numberOfRecords++;
	                          }
	                       jsonToken = parser.nextToken();  
	                   }
			          }catch(IOException io) {
		                    io.printStackTrace(); 
	                  }
			   }
		private void parseToppingsData(String text) {
			toppingsMap   =  getToppingsMap()   ;
			   // toppingsMap  =  new  HashMap<>() ;
				 switch (text) {
				case "ham":			
					 toppingsMap.put("ham",Toppings_Data.COUNT_HAM++) ;
					break;
				case "pepperoni":
					 toppingsMap.put("pepperoni",Toppings_Data.COUNT_PEPPERONI++) ;
					break;
				case "feta cheese":
					 toppingsMap.put("feta cheese",Toppings_Data.COUNT_FETA_CHEESE++) ;
					break;
				case "bacon":
					 toppingsMap.put("bacon",Toppings_Data.COUNT_BACON++) ;
					break;
				case "beef":
					 toppingsMap.put("beef",Toppings_Data.COUNT_BEEF++) ;
					break;
				case "black olives":		
					 toppingsMap.put("black olives",Toppings_Data.COUNT_BLACK_OLIVES++) ;
					break;
				case "sausage":			 
					 toppingsMap.put("sausage",Toppings_Data.COUNT_SAUSAGE++) ;
					break;
				case "jalapenos":			
					 toppingsMap.put("jalapenos",Toppings_Data.COUNT_JALAPENO++) ;
					break;
				case "mushrooms":			
					 toppingsMap.put("mushrooms",Toppings_Data.COUNT_MUSHROOM++) ;
					break;
				case "alredo sauce":			
					 toppingsMap.put("alredo sauce",Toppings_Data.COUNT_ALREDO_SAUCE++) ;
					break;
				case "chicken":			
					 toppingsMap.put("chicken",Toppings_Data.COUNT_CHICKEN++) ;
					break;
				case "canadian bacon":			
					 toppingsMap.put("canadian bacon",Toppings_Data.COUNT_CHEDAR_CHEESE++) ;
					break;
				case "cheda cheese":			
					 toppingsMap.put("cheda cheese",Toppings_Data.COUNT_CHEDAR_CHEESE++) ;
					break;
				case "onions":			
					 toppingsMap.put("onions",Toppings_Data.COUNT_ONIONS++) ;
					break;
				case "pineapple":			
					 toppingsMap.put("pineapple",Toppings_Data.COUNT_PINEAPPLE++) ;
					break;	
				case "mozzarella cheese":			
					 toppingsMap.put("mozzarella cheese",Toppings_Data.COUNT_MOZA++) ;
					break;
				case "artichokes":			
					 toppingsMap.put("artichokes",Toppings_Data.COUNT_ARTICKOKES++) ;
					break;
				case "green pepper":			
					 toppingsMap.put("green pepper",Toppings_Data.COUNT_GREEN_PEPPERS++) ;
					break;
				case "garlic":			
					 toppingsMap.put("garlic",Toppings_Data.COUNT_GARLIC++) ;
					break;
				case "italian sausage":			
					 toppingsMap.put("italian sausage",Toppings_Data.COUNT_SAUSAGE++) ;
					break;
				case "refried beans":			
					 toppingsMap.put("refried beans",Toppings_Data.COUNT_REFRIED_BEANS++) ;
					break;
				case "dice white onions":			
					 toppingsMap.put("dice white onions",Toppings_Data.COUNT_DICE_WHITE_ONIONS++) ;
					break;
				case "roasted peppers":		
					 toppingsMap.put("roasted peppers",Toppings_Data.COUNT_ROASTED_PEPPER++) ;
					break;
				case "parmesan pasley":
					
					 toppingsMap.put("parmesan pasley",Toppings_Data.COUNT_PARMESAN_PASLEY++) ;
					break;
				case "slice breaded chicken":			
					 toppingsMap.put("slice breaded chicken",Toppings_Data.COUNT_SLICED_BREADED_CHICKEN++) ;
					break;
				case "slice tomatoes":		
					 toppingsMap.put("slice tomatoes",Toppings_Data.COUNT_SLICE_ROMATOES++) ;
					break;
				case "red onions":			
					 toppingsMap.put("red onions",Toppings_Data.COUNT_RED_ONIONS++) ;
					break;
				case "rosa pepperoni":			
					 toppingsMap.put("rosa pepperoni",Toppings_Data.COUNT_ROSA_PEPPERONI++) ;
					break;
				case "diced tomatoes":			
					 toppingsMap.put("diced tomatoes",Toppings_Data.COUNT_DICED_TOMATOEs++) ;
					break;
				case "giants pepperoni":			
					 toppingsMap.put("giants pepperoni",Toppings_Data.COUNT_GIANTS_PEPPERONI++) ;
					break;
				default:
					break;
				}
		}	      
	}

