/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.*;
/**
 *
 * @author RK
 */
public class BT {

    /**
     * @param args the command line arguments
     */
 
    public static void main(String[] args) {
        // TODO code application logic here
        CS_MN mn = new CS_MN();
        
        String cs_num = "cs_num";
        String ac_type = "ac_type";
        String address = "address";
        String birth = "brith";
        String in_bl = "in_bl";
        String name = "name";
        String phone = "phone";

        // System.out.println(mn.cs_num+" "+mn.ac_type+" "+mn.address+" "+mn.birth+" "+mn.in_bl+" "+mn.name+" "+mn.phone);
      
        
      try {	
        
          mn.CreatAccount(name, birth, cs_num, address, phone, in_bl, ac_type);
          
         mn.ShowMenu();
          
         /*.......................create hashtable....................................*/
         System.out.println("................Create hasetable............................................");
         Hashtable balance=new Hashtable();
         Enumeration names; 
         String str;
         balance.put("cs_num1", 1);
         balance.put("cs_num2", 2);
         balance.put("cs_num3", 3);
         balance.put("cs_num4", 4);
         balance.put("cs_num5", 5);
         
         names = balance.keys(); 
         
         while(names.hasMoreElements()) { 
               str = (String) names.nextElement(); 
               System.out.println(str + ": " +  balance.get(str)); 
         } 
         
       /*............................BST  insert  find  delete  .......................................*/
     
       System.out.println("................BST insert find delete..........................................");
		Bst b = new Bst();
                
		b.insert(3);b.insert(8);
		b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
                
                
		System.out.println("Original Tree : ");
		b.display(b.root);
                
		System.out.println("");
		System.out.println("Check whether Node with value 4 exists : " + b.find(4));
                
		System.out.println("Delete Node with no children (2) : " + b.delete(2));
                
		b.display(b.root);
	
               System.out.println("");
       
       
       
         
      } catch (Exception e) {
           e.printStackTrace();
      }
      
      
          
    }

}
