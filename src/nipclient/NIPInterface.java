package nipclient;

import com.google.gson.Gson;
import java.util.Random;
import java.util.UUID;
import mcashchannelwrappers.RegisterMerchantRequest;
import mcashchannelwrappers.RegisterMerchantResponse;
import mcashchannelwrappers.RegisterPaymentDetailRequest;
import mcashchannelwrappers.RegisterPaymentDetailResponse;
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
  
  public String RegisterMerchantRequest(String input)
  {
    try
    {
      Gson gson = new Gson();
      
      RegisterMerchantRequest request = (RegisterMerchantRequest)gson.fromJson(input, RegisterMerchantRequest.class);
      
      request.setRequestID(UUID.randomUUID().toString());
      
      RestClient client = new RestClient("http://172.16.10.5:8080/NIPClient/webresources/McashInterface");
      
      String stringtohash = request.getRequestID() + request.getMerchantCode() + request.getAccountNumber(); //+ request.getAmount();
      
      String hash = client.get_SHA_512_Hash(stringtohash, APIKey);
      
      request.setHash(hash);
      
      String payload = gson.toJson(request);
      
      String responsebody = client.ProcessMcashRequest(payload, "RegisterMerchant");
      
      RegisterMerchantResponse response = (RegisterMerchantResponse)gson.fromJson(responsebody, RegisterMerchantResponse.class);
      
      return response.getHash()+ '#' + response.getMerchantCode()+ '#' + response.getResponseCode() + '#' + response.getSessionID();
    }
    catch (Exception s)
    {
      return s.getMessage();
    }
  }
  
  public String RegisterPaymentDetailRequest(String input)
  {
    try
    {
      Gson gson = new Gson();
      
      RegisterPaymentDetailRequest request = (RegisterPaymentDetailRequest)gson.fromJson(input, RegisterPaymentDetailRequest.class);
      
      request.setRequestID(UUID.randomUUID().toString());
      
      RestClient client = new RestClient("http://172.16.10.5:8080/NIPClient/webresources/McashInterface");
      
      String stringtohash = request.getRequestID() + request.getMerchantcode() + request.getAccountnumber(); //+ request.getAmount();
      
      String hash = client.get_SHA_512_Hash(stringtohash, APIKey);
      
      request.setHash(hash);
      
      String payload = gson.toJson(request);
      
      String responsebody = client.ProcessMcashRequest(payload, "executePaymentDetails");
      
      RegisterPaymentDetailResponse response = (RegisterPaymentDetailResponse) gson.fromJson(responsebody, RegisterPaymentDetailResponse.class);

      
      return response.getHash()+ '#' + response.getMerchantCode()+ '#' + response.getResponsecode() + '#' + response.getSessionID();
    }
    catch (Exception s)
    {
      return s.getMessage();
    }
  }
  
  public static void main(String[] args)
  {
    Gson gson = new Gson();
//    FundsTransferDCRequest request = new FundsTransferDCRequest();
//    
//    getFIListRequest firequest = new getFIListRequest();
//    
//    String nepayload = gson.toJson(firequest);
    
 //   String firesponse = new NIPInterface().dogetFIList("");
    
//    Random rand = new Random();
//    NameEnquiryRequest nerequest = new NameEnquiryRequest();
//    nerequest.setAccountNumber("0019291825");
//    nerequest.setChannelCode("1");
//    nerequest.setDestinationInstitutionCode("000013");
//    nerequest.setChannelCode("1");
//    nerequest.setInstitutionCode("070001");
//    String nepayload = gson.toJson(nerequest);
    
    String neresponse = new NIPInterface().RegisterPaymentDetailRequest("{\n" +
"	\"requestID\": \"0000001\",\n" +
"	\"sessionID\": \"367\",\n" +
"	\"payerphonenumber\": \"08167473832\",\n" +
"	\"payerBVN\": \"22222222233\",\n" +
"	\"merchantcode\": \"00123456\",\n" +
"	\"Amount\": \"100.5\",\n" +
"	\"InstitutionCode\": \"2456789\",\n" +
"	\"FinancialInstitutionCode\": \"4784739\",\n" +
"	\"Accountnumber\": \"23456788945\",\n" +
"	\"hash\": \"34785-958kfj\"\n" +
"} ");
    
    RegisterPaymentDetailRequest neresponseobj = (RegisterPaymentDetailRequest)gson.fromJson(neresponse, RegisterPaymentDetailRequest.class);
    
    String sd ="";
//    request.setNameEnquiryRef(neresponseobj.getNameEnquiryRef());
//    request.setNarration("Inlaks FT Single DC Test ");
//    request.setBeneficiaryAccountNumber(neresponseobj.getAccountNumber());
//    request.setBeneficiaryAccountName(neresponseobj.getAccountName());
//    request.setBeneficiaryBankVerificationNumber(neresponseobj.getBankVerificationNo());
//    request.setBeneficiaryKYCLevel(neresponseobj.getKycLevel());
//    request.setDestinationInstitutionCode(neresponseobj.getDestinationInstitutionCode());
//    request.setOriginatorAccountName("DENNIS MADU");
//    request.setOriginatorAccountNumber("0010011709");
//    request.setOriginatorBankVerificationNumber("08069846565");
//    request.setOriginatorKYCLevel("1");
//    request.setChannelCode("1");
//    request.setInstitutionCode("000013");
//    request.setTransactionLocation("");
//    request.setPaymentReference("FT3533" + rand.nextInt(458588));
//    
//    String payload = gson.toJson(request);
//    String ftresponse = new NIPInterface().doFundsTransferDC(payload);

//    request.setAmount("150.00");
//    request.setNameEnquiryRef("070001180613105630087666370806");
//    request.setNarration("Iledk");
//    request.setBeneficiaryAccountNumber("0019291825");
//    request.setBeneficiaryAccountName("OKUSADA, OLUFEMI OLUMIDE");
//    request.setBeneficiaryBankVerificationNumber("22179818329");
//    request.setBeneficiaryKYCLevel("2");
//    request.setDestinationInstitutionCode("000013");
//    request.setOriginatorAccountName("ISIMHANZE KESTER FRANCIS");
//    request.setOriginatorAccountNumber("0020246245");
//    request.setOriginatorBankVerificationNumber("22282110079");
//    request.setOriginatorKYCLevel("2");
//    request.setChannelCode("1");
//    request.setInstitutionCode("070001");
//    request.setTransactionLocation("");
//    request.setPaymentReference("FT18159600441691");
//    
//    String payload = gson.toJson(request);
//    String ftresponse = new NIPInterface().doFundsTransferDC(payload);
    
//    String payload = gson.toJson("{\"nameEnquiryRef\":\"070001180613105630087666370806\",\"destinationInstitutionCode\":\"000013\",\"beneficiaryAccountName\":\"OKUSADA, OLUFEMI OLUMIDE\",\"beneficiaryAccountNumber\":\"0019291825\",\"beneficiaryBankVerificationNumber\":\"22179818329\",\"beneficiaryKYCLevel\":\"2\",\"originatorAccountName\":\"ISIMHANZE KESTER FRANCIS\",\"originatorAccountNumber\":\"0020246245\",\"originatorBankVerificationNumber\":\"22282110079\",\"originatorKYCLevel\":\"2\",\"transactionLocation\":\"\",\"narration\":\"ledk\",\"InstitutionCode\":\"070001\",\"amount\":\"150.00\"}");
//    String ftresponse = new NIPInterface().doFundsTransferDC("{\"nameEnquiryRef\":\"070001180613105630087666370806\",\"destinationInstitutionCode\":\"000013\",\"beneficiaryAccountName\":\"OKUSADA, OLUFEMI OLUMIDE\",\"beneficiaryAccountNumber\":\"0019291825\",\"beneficiaryBankVerificationNumber\":\"22179818329\",\"beneficiaryKYCLevel\":\"2\",\"originatorAccountName\":\"ISIMHANZE KESTER FRANCIS\",\"originatorAccountNumber\":\"0020246245\",\"originatorBankVerificationNumber\":\"22282110079\",\"originatorKYCLevel\":\"2\",\"transactionLocation\":\"\",\"narration\":\"ledk\",\"InstitutionCode\":\"070001\",\"ChannelCode\":\"1\",\"PaymentReference\":\"FT18159600441691\",\"amount\":\"150.00\"}");
//    
//    FundsTransferDCResponse ftresponseobj = (FundsTransferDCResponse)gson.fromJson(ftresponse, FundsTransferDCResponse.class);
    
//    TransactionStatusQueryRequest tsq = new TransactionStatusQueryRequest();
//    tsq.setChannelCode("1");
//    tsq.setInstitutionCode("070001");
//    //tsq.setNibssSessionID(ftresponseobj.getNibssSessionID());
//    tsq.setNibssSessionID("000013180609072010000124705923");
//    
//    String tspayload = gson.toJson(tsq);
//    
//    String response = new NIPInterface().doTransactionStatusQuery(tspayload);
  }
}
