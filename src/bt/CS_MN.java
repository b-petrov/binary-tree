/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;



/**
 *
 * @author RK
 */
public class CS_MN {
  
    public String name;
    public String birth;
    public String cs_num;
    public String address;
    public String phone;
    public String in_bl;
    public String ac_type;
    public File inputFile;
    public DocumentBuilderFactory dbFactory;
    public DocumentBuilder dBuilder;
    public NodeList nList;
    public   Document doc;
    public CS_MN(){
      try{
        inputFile = new File("data.xml");
        dbFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(inputFile);
       
      }catch (Exception e) {
           e.printStackTrace();
      }
    }
    
    public void ShowMenu(){
        try {        
             
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         nList = doc.getElementsByTagName("node");
         System.out.println("----------------------------");
         for (int temp = 0; temp < nList.getLength(); temp++) {
            org.w3c.dom.Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" 
               + nNode.getNodeName());
            if (nNode.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               System.out.println("node roll no : " + eElement.getAttribute("rollno"));
               System.out.println("name : "   + eElement.getElementsByTagName("name").item(0).getTextContent());
               System.out.println("birth : "   + eElement.getElementsByTagName("birth").item(0).getTextContent());
               System.out.println("citizenship number : "  + eElement.getElementsByTagName("citizenship_number").item(0).getTextContent());
                System.out.println("address : "  + eElement.getElementsByTagName("address").item(0).getTextContent());
               System.out.println("phone number : "  + eElement.getElementsByTagName("phone").item(0).getTextContent());
               System.out.println("initial balance : "  + eElement.getElementsByTagName("initial_balance").item(0).getTextContent());
               System.out.println("account type : "  + eElement.getElementsByTagName("account_type").item(0).getTextContent());
            }
         }
      }catch (Exception e) {
           e.printStackTrace();
      }
    };
    public void CreatAccount(String name, String birth, String cs_num,String address,String phone,String in_bl,String ac_type) throws TransformerException{
       try{            
         Element root =doc.getDocumentElement();
        
         Element newnode=doc.createElement("node");
         root.appendChild(newnode);
         
         Attr attr = doc.createAttribute("rollno");
         attr.setValue(String.valueOf(2));
         newnode.setAttributeNode(attr);
                  
         Element e_name = doc.createElement("name");
         e_name.appendChild( doc.createTextNode(name));
         
         newnode.appendChild(e_name);
         
         Element e_birth = doc.createElement("birth");
         e_birth.appendChild( doc.createTextNode(birth));
         newnode.appendChild(e_birth);
         
         Element e_cs_num = doc.createElement("citizenship_number");
         e_cs_num.appendChild( doc.createTextNode(cs_num));
         newnode.appendChild(e_cs_num);
         
          Element e_address = doc.createElement("address");
          e_address.appendChild( doc.createTextNode(address));
         newnode.appendChild(e_address);
         
         Element e_phone = doc.createElement("phone");
         e_phone.appendChild( doc.createTextNode(phone));
         newnode.appendChild(e_phone);
         
         Element e_in_bl = doc.createElement("initial_balance");
         e_in_bl.appendChild( doc.createTextNode(in_bl));
         newnode.appendChild(e_in_bl);
         
         Element e_ac_type = doc.createElement("account_type");
         e_ac_type.appendChild( doc.createTextNode(ac_type));
         newnode.appendChild(e_ac_type);
         
         
         
         Transformer transformer = TransformerFactory.newInstance().newTransformer();
         transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
         DOMSource source = new DOMSource(doc);
         StreamResult outfile = new StreamResult(inputFile);
         transformer.transform(source, outfile);         
        
         StreamResult console = new StreamResult(System.out);
         transformer.transform(source, console);
         
       }catch(Exception e){
        e.printStackTrace();
       }
    };
    
    public void DoTransact(){
        
    };
    
    public void EditCustomerInfo(){
     
    };
    
    public void SortCustomersRecord(){
             
    };
    public void DeleteAccount(){
       
    };
    
    public void Print(){
     
    };
    
    public void ShowCustomerList(){
     
    };
    
}
