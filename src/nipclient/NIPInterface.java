package nipclient;

import com.google.gson.Gson;
import java.util.Random;
import java.util.UUID;
import tools.RestClient;

public class NIPInterface
{
    
    public String APIKey = "4466FA2C-1886-4366-B014-AD140712BE38";
    
  public String doNameEquiry(String input)
  {
    try
    {
      Gson gson = new Gson();
      
      NameEnquiryRequest request = (NameEnquiryRequest)gson.fromJson(input, NameEnquiryRequest.class);
      
      request.setRequestID(UUID.randomUUID().toString());
      
      RestClient client = new RestClient();
      
      String stringtohash = request.getRequestID() + request.getDestinationInstitutionCode() + request.getAccountNumber();
      
      String hash = client.get_SHA_512_Hash(stringtohash, APIKey);
      
      request.setHash(hash);
      
      String payload = gson.toJson(request);
      
      String responsebody = client.ProcessNIPRequest(payload, "NameEnquiry");
      
      NameEnquiryResponse response = (NameEnquiryResponse)gson.fromJson(responsebody, NameEnquiryResponse.class);
      
      return response.getNameEnquiryRef() + '#' + response.getAccountName() + '#' + response.getBankVerificationNo() + '#' + response.getKycLevel() + '#' + response.getResponseCode() + '#' + response.getResponseDescription();
    }
    catch (Exception s)
    {
      return s.getMessage();
    }
  }
  
  public String doFundsTransferDC(String input)
  {
    try
    {
      Gson gson = new Gson();
      
      FundsTransferDCRequest request = (FundsTransferDCRequest)gson.fromJson(input, FundsTransferDCRequest.class);
      
      request.setRequestID(UUID.randomUUID().toString());
      
      RestClient client = new RestClient();
      
      String stringtohash = request.getRequestID() + request.getDestinationInstitutionCode() + request.getBeneficiaryAccountNumber() + request.getAmount();
      
      String hash = client.get_SHA_512_Hash(stringtohash, APIKey);
      
      request.setHash(hash);
      
      String payload = gson.toJson(request);
      
      String responsebody = client.ProcessNIPRequest(payload, "FundsTransferDC");
      
      FundsTransferDCResponse response = (FundsTransferDCResponse)gson.fromJson(responsebody, FundsTransferDCResponse.class);
      
      return response.getNibssSessionID() + '#' + response.getResponseCode() + '#' + response.getResponseDescription();
    }
    catch (Exception s)
    {
      return s.getMessage();
    }
  }
  
  public String doTransactionStatusQuery(String input)
  {
    try
    {
      Gson gson = new Gson();
      
      TransactionStatusQueryRequest request = (TransactionStatusQueryRequest)gson.fromJson(input, TransactionStatusQueryRequest.class);
      
      request.setRequestID(UUID.randomUUID().toString());
      
      RestClient client = new RestClient();
      
      String stringtohash = request.getRequestID() + request.getNibssSessionID();
      
      String hash = client.get_SHA_512_Hash(stringtohash, APIKey);
      
      request.setHash(hash);
      
      String payload = gson.toJson(request);
      
      String responsebody = client.ProcessNIPRequest(payload, "TransactionStatusQuery");
      
      TransactionStatusQueryResponse response = (TransactionStatusQueryResponse)gson.fromJson(responsebody, TransactionStatusQueryResponse.class);
      
      return response.getResponseCode() + "#" + response.getResponseDescription();
    }
    catch (Exception s)
    {
      return s.getMessage();
    }
  }
  
  public String dogetFIList(String in_put)
  {
    try
    {
      Gson gson = new Gson();
      
      String dummy = in_put;
      
      getFIListRequest request = new getFIListRequest();
      
      request.setRequestID(UUID.randomUUID().toString());
      
      RestClient client = new RestClient();
      
      String stringtohash = request.getRequestID();
      
      String hash = client.get_SHA_512_Hash(stringtohash, APIKey);
      
      request.setHash(hash);
      
      String payload = gson.toJson(request);
      
      String responsebody = client.ProcessNIPRequest(payload, "getFIList");
      
      getFIListResponse response = (getFIListResponse)gson.fromJson(responsebody, getFIListResponse.class);
      
      int no_of_rec = Integer.parseInt(response.getNumberOfRecords());
      
      Records[] record_list = response.getRecord();
      
      StringBuilder record_out = new StringBuilder();
      int i = 1;
      for (Records record : record_list)
      {
        String record_row = record.getInstitutionCode().trim() + '*' + record.getInstitutionName().trim() + '*' + record.getCategory().trim();
        
        record_out.append(record_row);
        if (i < record_list.length) {
          record_out.append('/');
        }
        i++;
      }
      return record_out.toString();
    }
    catch (Exception s)
    {
      return s.getMessage();
    }
  }
  
  public static void main(String[] args)
  {
    Gson gson = new Gson();
    FundsTransferDCRequest request = new FundsTransferDCRequest();
    
    getFIListRequest firequest = new getFIListRequest();
    
    String nepayload = gson.toJson(firequest);
    
    String firesponse = new NIPInterface().dogetFIList("");
    
    Random rand = new Random();
    NameEnquiryRequest nerequest = new NameEnquiryRequest();
    nerequest.setAccountNumber("0791000003");
    nerequest.setChannelCode("1");
    nerequest.setDestinationInstitutionCode("999099");
    nerequest.setChannelCode("1");
    nerequest.setInstitutionCode("999103");
    nepayload = gson.toJson(nerequest);
    
    String neresponse = new NIPInterface().doNameEquiry(nepayload);
    
    NameEnquiryResponse neresponseobj = (NameEnquiryResponse)gson.fromJson(neresponse, NameEnquiryResponse.class);
    
    request.setAmount("20000.00");
    request.setNameEnquiryRef(neresponseobj.getNameEnquiryRef());
    request.setNarration("Inlaks FT Single DC Test ");
    request.setBeneficiaryAccountNumber(neresponseobj.getAccountNumber());
    request.setBeneficiaryAccountName(neresponseobj.getAccountName());
    request.setBeneficiaryBankVerificationNumber(neresponseobj.getBankVerificationNo());
    request.setBeneficiaryKYCLevel(neresponseobj.getKycLevel());
    request.setDestinationInstitutionCode(neresponseobj.getDestinationInstitutionCode());
    request.setOriginatorAccountName("DENNIS MADU");
    request.setOriginatorAccountNumber("0010011709");
    request.setOriginatorBankVerificationNumber("08069846565");
    request.setOriginatorKYCLevel("1");
    request.setChannelCode("1");
    request.setInstitutionCode("999103");
    request.setTransactionLocation("");
    request.setPaymentReference("FT3533" + rand.nextInt(458588));
    
    String payload = gson.toJson(request);
    String ftresponse = new NIPInterface().doFundsTransferDC(payload);
    
    FundsTransferDCResponse ftresponseobj = (FundsTransferDCResponse)gson.fromJson(ftresponse, FundsTransferDCResponse.class);
    
    TransactionStatusQueryRequest tsq = new TransactionStatusQueryRequest();
    tsq.setChannelCode("1");
    tsq.setInstitutionCode("999103");
    tsq.setNibssSessionID(ftresponseobj.getNibssSessionID());
    
    String tspayload = gson.toJson(tsq);
    
    String response = new NIPInterface().doTransactionStatusQuery(tspayload);
  }
}
