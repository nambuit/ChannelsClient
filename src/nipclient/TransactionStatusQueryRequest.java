package nipclient;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="TransactionStatusQueryRequest")
public class TransactionStatusQueryRequest
{
  private String requestID;
  private String nibssSessionID;
  private String hash;
  private String ChannelCode;
  private String InstitutionCode;
  
  public void setRequestID(String requestID)
  {
    this.requestID = requestID;
  }
  
  public void setNibssSessionID(String nibssSessionID)
  {
    this.nibssSessionID = nibssSessionID;
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
  
  public String getNibssSessionID()
  {
    return this.nibssSessionID;
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
