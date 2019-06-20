package jsonparser;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ProceessOloJsonData {
	private static ProcessData  data   =  new  ProcessData() ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
      StringBuilder builder  = new  StringBuilder() ;
           try {
			data.processJson(); // process the file pizza.json url
			//calling the container  for the topping datas
          System.out.println("Printing  out the  toppings with  the ranks and frequencies");
			System.out.println("Toppings Number\tNo of Occurence\t\tName");
          TreeMap<String,Integer> toppings  = (TreeMap<String,Integer>)data.getToppingsMap() ;
          TreeMap<Integer , String> newToppings   = reArrangeToppingsByValue(toppings) ;
            newToppings.forEach((e,v)->{
	        System.out.println("\t"+toppingsFrequencies()+"\t\t"+e+"\t\t"+v);
			      });
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        }
	public  static TreeMap<Integer , String> reArrangeToppingsByValue(TreeMap<String,Integer> mytoppings) {
	       Collection  values  =  mytoppings.values()  ;	
	       TreeMap<Integer , String> rearrangeToppings  =  new  TreeMap<>()  ; // to rearrange  toppings so  that  it can  come  in ascending  order
	         Set<String>  entrySet  = mytoppings.keySet()  ;	
	        //int flag =  mytoppings.get("ham") ;
	         Iterator<String> it =  entrySet.iterator()  ;
	         while(it.hasNext()){
	          String item  = it.next()  ;
	          int intItemValue   = mytoppings.get(item) ;
	          rearrangeToppings.put(intItemValue,item)  ;
	              }
	         return rearrangeToppings  ;
	         }
	 private static  int  i   = 0  ;
	public static  int toppingsFrequencies(){ //  recursive  method  in  lamda exp
		//System.out.println(nos); 
     // int  p  = toppingsFrequencies(nos-1) ;
		i++;  
		if(i<=data.getToppingsMap().size()){  
		     return i; 
		         }
		  return  toppingsFrequencies(); 
	        }
	}


	
	
	