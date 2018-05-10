package nipclient;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="getFIListResponse")
public class getFIListResponse
{
  private String responseCode;
  private String responseDescription;
  private Records[] record;
  private String numberOfRecords;
  private String hash;
  
  public void setResponseCode(String responseCode)
  {
    this.responseCode = responseCode;
  }
  
  public void setResponseDescription(String responseDescription)
  {
    this.responseDescription = responseDescription;
  }
  
  public void setRecord(Records[] record)
  {
    this.record = record;
  }
  
  public void setNumberOfRecords(String numberOfRecords)
  {
    this.numberOfRecords = numberOfRecords;
  }
  
  public void setHash(String hash)
  {
    this.hash = hash;
  }
  
  public String getResponseCode()
  {
    return this.responseCode;
  }
  
  public String getResponseDescription()
  {
    return this.responseDescription;
  }
  
  public Records[] getRecord()
  {
    return this.record;
  }
  
  public String getNumberOfRecords()
  {
    return this.numberOfRecords;
  }
  
  public String getHash()
  {
    return this.hash;
  }
}
