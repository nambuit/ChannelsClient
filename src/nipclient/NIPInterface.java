/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nipclient;

import com.google.gson.Gson;
import java.util.UUID;
import tools.RestClient;

/**
 *
 * @author Administrator
 */
public class NIPInterface {
    
    public String doNameEquiry(String input){
      
        
        try{
          Gson gson = new Gson(); 
        String [] data = input.split("#");
        
        String targetacct = data[0];
        String destInst =  data[1];
        
        NameEnquiryRequest request = new NameEnquiryRequest();
        
        request.setAccountNumber(targetacct);
        request.setDestinationInstitutionCode(destInst);
        request.setRequestID(UUID.randomUUID().toString());
        
       
        
      RestClient client =  new RestClient();
      
       String stringtohash = request.getRequestID() + request.getDestinationInstitutionCode() + request.getAccountNumber();
      
      String hash = client.get_SHA_512_Hash(stringtohash, "inlaks");
      
       request.setHash(hash);
      
      String payload = gson.toJson(request);
     
      
   
        
       String responsebody = client.ProcessNIPRequest(payload, "NameEnquiry");
      
        NameEnquiryResponse response  = (NameEnquiryResponse) gson.fromJson(responsebody, NameEnquiryResponse.class);
        
        return response.getAccountName()+"#"+response.getAccountNumber();
        }
        catch(Exception s){
            return s.getMessage();
        }
    }
    
    
      public static void main(String [] args){
      //  String payload = "{\n\"requestID\":\"d997e1d2-17a6-11e8-b642-0ed5f89f718b\",\n\"destinationInstitutionCode\":\"999057\",\n\"accountNumber\":\"2003456773\",\n\"hash\":\"bf5d37684d83e676e8d76538461601442ca7030efbbf661d7fb2932993b412f06dac7c34390e028506a35a74c5cf8dcc488f4e4c208b8c405f2db335b5cbb17a\"\n}";
        String response = new NIPInterface().doNameEquiry("333232423#13232");
    }
    
}
