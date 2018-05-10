package nipclient;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="TransactionStatusQueryResponse")
public class TransactionStatusQueryResponse
{
  private String ResponseCode;
  private String ResponseDescription;
  private String nibssSessionID;
  
  public void setResponseCode(String ResponseCode)
  {
    this.ResponseCode = ResponseCode;
  }
  
  public void setResponseDescription(String ResponseDescription)
  {
    this.ResponseDescription = ResponseDescription;
  }
  
  public void setNibssSessionID(String nibssSessionID)
  {
    this.nibssSessionID = nibssSessionID;
  }
  
  public String getResponseCode()
  {
    return this.ResponseCode;
  }
  
  public String getResponseDescription()
  {
    return this.ResponseDescription;
  }
  
  public String getNibssSessionID()
  {
    return this.nibssSessionID;
  }
}
