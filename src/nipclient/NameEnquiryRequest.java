package nipclient;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="NameEnquiryRequest")
public class NameEnquiryRequest
{
  private String requestID;
  private String destinationInstitutionCode;
  private String accountNumber;
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
