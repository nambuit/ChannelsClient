package nipclient;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="NameEnquiryResponse")
public class NameEnquiryResponse
{
  private String requestID;
  private String destinationInstitutionCode;
  private String accountNumber;
  private String accountName;
  private String bankVerificationNo;
  private String kycLevel;
  private String responseCode;
  private String responseDescription;
  private String nameEnquiryRef;
  private String hash;
  private String ChannelCode;
  private String InstitutionCode;
  
  public void setRequestID(String requestID)
  {
    this.requestID = requestID;
  }
  
  public void setDestinationInstitutionCode(String destinationInstitutionCode)
  {
    this.destinationInstitutionCode = destinationInstitutionCode;
  }
  
  public void setAccountNumber(String accountNumber)
  {
    this.accountNumber = accountNumber;
  }
  
  public void setAccountName(String accountName)
  {
    this.accountName = accountName;
  }
  
  public void setBankVerificationNo(String bankVerificationNo)
  {
    this.bankVerificationNo = bankVerificationNo;
  }
  
  public void setKycLevel(String kycLevel)
  {
    this.kycLevel = kycLevel;
  }
  
  public void setResponseCode(String responseCode)
  {
    this.responseCode = responseCode;
  }
  
  public void setResponseDescription(String responseDescription)
  {
    this.responseDescription = responseDescription;
  }
  
  public void setNameEnquiryRef(String nameEnquiryRef)
  {
    this.nameEnquiryRef = nameEnquiryRef;
  }
  
  public void setHash(String hash)
  {
    this.hash = hash;
  }
  
  public void setChannelCode(String ChannelCode)
  {
    this.ChannelCode = ChannelCode;
  }
  
  public void setInstitutionCode(String InstitutionCode)
  {
    this.InstitutionCode = InstitutionCode;
  }
  
  public String getRequestID()
  {
    return this.requestID;
  }
  
  public String getDestinationInstitutionCode()
  {
    return this.destinationInstitutionCode;
  }
  
  public String getAccountNumber()
  {
    return this.accountNumber;
  }
  
  public String getAccountName()
  {
    return this.accountName;
  }
  
  public String getBankVerificationNo()
  {
    return this.bankVerificationNo;
  }
  
  public String getKycLevel()
  {
    return this.kycLevel;
  }
  
  public String getResponseCode()
  {
    return this.responseCode;
  }
  
  public String getResponseDescription()
  {
    return this.responseDescription;
  }
  
  public String getNameEnquiryRef()
  {
    return this.nameEnquiryRef;
  }
  
  public String getHash()
  {
    return this.hash;
  }
  
  public String getChannelCode()
  {
    return this.ChannelCode;
  }
  
  public String getInstitutionCode()
  {
    return this.InstitutionCode;
  }
}
