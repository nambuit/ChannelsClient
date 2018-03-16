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
         //  String [] data = input.split("#");
//        
//        String targetacct = data[0];
//        String destInst =  data[1];
//        
        NameEnquiryRequest request = (NameEnquiryRequest) gson.fromJson(input, NameEnquiryRequest.class);
        
        request.setRequestID(UUID.randomUUID().toString());

        request.setChannelCode("1");
        request.setInstitutionCode("999103");
     
        
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
    
    public String doFundsTransferDC(String input){
        try{
          Gson gson = new Gson(); 
//        String [] data = input.split("#");
//        
//        String targetacct = data[0];
//        String destInst =  data[1];
        
        FundsTransferDCRequest request = (FundsTransferDCRequest) gson.fromJson(input, FundsTransferDCRequest.class);
//        request.setAccountNumber(targetacct);
//        request.setDestinationInstitutionCode(destInst);
        request.setRequestID(UUID.randomUUID().toString());

      RestClient client =  new RestClient();
      
       String stringtohash = request.getRequestID() + request.getDestinationInstitutionCode() + request.getBeneficiaryAccountNumber()+request.getAmount();
         
      
      String hash = client.get_SHA_512_Hash(stringtohash, "inlaks");
      
       request.setHash(hash);
      
      String payload = gson.toJson(request);

       String responsebody = client.ProcessNIPRequest(payload, "FundsTransferDC");
      
        FundsTransferDCResponse response  = (FundsTransferDCResponse) gson.fromJson(responsebody, FundsTransferDCResponse.class);
        
        return response.getNibssSessionID()+"#"+response.getResponseCode()+"#"+response.getResponseDescription();
        }
        catch(Exception s){
            return s.getMessage();
        }
    }
    
    public String doTransactionStatusQuery(String input){
        try{
          Gson gson = new Gson(); 
//        String [] data = input.split("#");
//        
//        String targetacct = data[0];
//        String destInst =  data[1];
        
        TransactionStatusQueryRequest request = new TransactionStatusQueryRequest();
        
//        request.setAccountNumber(targetacct);
//        request.setDestinationInstitutionCode(destInst);
        request.setRequestID(UUID.randomUUID().toString());

      RestClient client =  new RestClient();
      
       String stringtohash = request.getRequestID();
      
      String hash = client.get_SHA_512_Hash(stringtohash, "inlaks");
      
       request.setHash(hash);
      
      String payload = gson.toJson(request);

       String responsebody = client.ProcessNIPRequest(payload, "TransactionStatusQuery");
      
        TransactionStatusQueryResponse response  = (TransactionStatusQueryResponse) gson.fromJson(responsebody, TransactionStatusQueryResponse.class);
        
        return response.getNibssSessionID()+"#"+response.getResponseCode()+"#"+response.getResponseDescription();
        }
        catch(Exception s){
            return s.getMessage();
        }
    }
    
    public String dogetFIList(){
        try{
          Gson gson = new Gson(); 
//        String [] data = input.split("#");
//        
//        String targetacct = data[0];
//        String destInst =  data[1];
        
        getFIListRequest request = new getFIListRequest();
        
//        request.setAccountNumber(targetacct);
//        request.setDestinationInstitutionCode(destInst);
        request.setRequestID(UUID.randomUUID().toString());

      RestClient client =  new RestClient();
      
       String stringtohash = request.getRequestID();
      
      String hash = client.get_SHA_512_Hash(stringtohash, "inlaks");
      
       request.setHash(hash);
      
      String payload = gson.toJson(request);

       String responsebody = client.ProcessNIPRequest(payload, "getFIList");
      
        getFIListResponse response  = (getFIListResponse) gson.fromJson(responsebody, getFIListResponse.class);
       
//        return response.getNibssSessionID()+"#"+response.getResponseCode()+"#"+response.getResponseDescription(); 
        return "list";
        }
        catch(Exception s){
            return s.getMessage();
        }
    }
      public static void main(String [] args){
          FundsTransferDCRequest request = new FundsTransferDCRequest();

          request.setAmount("20000.00");
          request.setNameEnquiryRef("999103181016131036476130226526");
          request.setNarration("Inlaks FT Single DC Test ");
          request.setBeneficiaryAccountNumber("1910000338");
          request.setBeneficiaryAccountName("Adekunle Lawal USMAN");
          request.setBeneficiaryBankVerificationNumber("22166598355");
          request.setBeneficiaryKYCLevel("1");
          request.setDestinationInstitutionCode("999100");
          request.setOriginatorAccountName("DENNIS MADU");
          request.setOriginatorAccountNumber("0010011709");
          request.setOriginatorBankVerificationNumber("08069846565");
          request.setOriginatorKYCLevel("1");
          request.setChannelCode("1");
          request.setInstitutionCode("999103");
          
          Gson gson = new Gson();
          
         
          
          String payload = gson.toJson(request);//"{\n\"requestID\":\"d997e1d2-17a6-11e8-b642-0ed5f89f718b\",\n\"destinationInstitutionCode\":\"999100\",\n\"accountNumber\":\"1910000338\",\n\"hash\":\"bf5d37684d83e676e8d76538461601442ca7030efbbf661d7fb2932993b412f06dac7c34390e028506a35a74c5cf8dcc488f4e4c208b8c405f2db335b5cbb17a\"\n}";
        String response = new NIPInterface().doFundsTransferDC(payload);
    }
    
}
