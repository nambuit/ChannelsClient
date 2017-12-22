/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicelink;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.StringWriter;
//import jdk.internal.org.xml.bind.StringInputStream;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
//import jdk.internal.org.xml.sax.InputSource;
import nibbsnip.service.NIBBSNIPInterface;
import nibbsnip.service.NIBBSNIPInterface_Service;
import org.json.JSONObject;
import org.json.XML;
import org.xml.sax.InputSource;

/**
 *
 * @author Temitope
 */

public class ChannelsLink {

    
    public static String BalanceEnquiryRequestMethod(String data){

        try {
//       Gson gson = new Gson();
        
       NIBBSNIPInterface_Service nip =  new NIBBSNIPInterface_Service();
        
       NIBBSNIPInterface nipport = nip.getNIBBSNIPInterfacePort();
//       
       BalanceEnquiryRequest BalanceRequestIn = new BalanceEnquiryRequest();
      
       BalanceRequestIn.setChannelCode("1");
       
       BalanceRequestIn.setDestinationInstitutionCode("0001");
       
       BalanceRequestIn.setSessionID("10010");

       BalanceRequestIn.setTargetAccountName("Dimm");
       
       BalanceRequestIn.setTargetAccountNumber("11056");
       
       BalanceRequestIn.setTargetBankVerificationNumber(data);
       
       BalanceRequestIn.setAuthorizationCode(data);
               
       String BalanceRequestXml = ObjectToXML(BalanceRequestIn);
 
       String Response = nipport.balanceenquiry(BalanceRequestXml);
//  
////       String tag = "balanceEnquiryResponse";
//
       BalanceEnquiryResponse ObjRespons = (BalanceEnquiryResponse)XMLToObject(Response,new BalanceEnquiryResponse());
       String ResponseOut = ObjRespons.getAuthorizationCode()+':'+"AuthorizationCode"+"@FM"+ObjRespons.getChannelCode()+':'+"ChannelCode"+"@FM"+ObjRespons.getDestinationInstitutionCode()+':'+"DestinationInstitutionCode"+"@FM"+ObjRespons.getSessionID()+':'+"SessionID"+"@FM"+ObjRespons.getTargetAccountName()+':'+"TargetAccountName"+"@FM"+ObjRespons.getTargetAccountNumber()+':'+"TargetAccountNumber"+"@FM"+ObjRespons.getTargetBankVerificationNumber()+':'+"TargetBankVerificationNumber"+"@FM"+ObjRespons.getAvailableBalance()+':'+"AvailableBalance"+"@FM"+ObjRespons.getResponseCode()+':'+"AvailableBalance";
       return ResponseOut;
//       return "done";
    } 
//        catch (InvocationTargetException x) {
//            System.err.println("An InvocationTargetException was caught!");
//            Throwable cause = x.getCause();
//            String reason = "Invocation of %s failed because of: %s%n" + cause.getMessage();
//            return reason;
//        }
        catch (Exception ex) {
            Logger.getLogger(ChannelsLink.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage()+" exception";
        }
       
    }
    
    
    
    public static String ObjectToXML(Object object){
       try{
    JAXBContext jcontext = JAXBContext.newInstance(object.getClass());
    Marshaller m = jcontext.createMarshaller();
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    StringWriter sw = new StringWriter();
    
    m.marshal(object, sw);
    
    return sw.toString();
       }
       catch(Exception y){
//          getServiceLogger("XMLConversion").LogError(y.getMessage(), y, Level.FATAL);
          return "";
       }
    }
    
//    public static Object XMLtoObject(String XmlObject,String tag, Object target) {
////        BalanceEnquiryResponse accountbalance = new BalanceEnquiryResponse();
//        String json = "";
//        Gson gson = new Gson();
//        try {
//            JSONObject object = XML.toJSONObject(XmlObject);       
//            object = (JSONObject)object.get(tag);
//            json = object.toString();
//           
//            return gson.fromJson(json,target.getClass());
//        } catch (Exception d) {
//            return(d.getMessage());
//        }
//       
//    }
    
    public static Object XMLToObject (String xml, Object object) throws Exception{
       try{
    JAXBContext jcontext = JAXBContext.newInstance(object.getClass());
    Unmarshaller um = jcontext.createUnmarshaller();

    InputSource s = new InputSource(new StringReader(xml));
      return um.unmarshal(s);
   
       }
       catch(Exception y){
           throw (y);
       }
}
    
    public static void main(String[] args){
        String rep = BalanceEnquiryRequestMethod("");
        Gson gson = new Gson();
    }
}
