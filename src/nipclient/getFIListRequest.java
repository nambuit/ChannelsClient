package nipclient;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="NameEnquiryRequest")
public class getFIListRequest
{
  private String requestID;
  private String hash;
  
  public void setRequestID(String requestID)
  {
    this.requestID = requestID;
  }
  
  public void setHash(String hash)
  {
    this.hash = hash;
  }
  
  public String getRequestID()
  {
    return this.requestID;
  }
  
  public String getHash()
  {
    return this.hash;
  }
}
