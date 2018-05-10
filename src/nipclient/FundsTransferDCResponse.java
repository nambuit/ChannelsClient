package nipclient;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="FundsTransferDCResponse")
public class FundsTransferDCResponse
{
  private String requestID;
  private String nibssSessionID;
  private String destinationInstitutionCode;
  private String beneficiaryAccountNumber;
  private String responseCode;
  private String responseDescription;
  private String hash;
  
  public void setRequestID(String requestID)
  {
    this.requestID = requestID;
  }
  
  public void setNibssSessionID(String nibssSessionID)
  {
    this.nibssSessionID = nibssSessionID;
  }
  
  public void setDestinationInstitutionCode(String destinationInstitutionCode)
  {
    this.destinationInstitutionCode = destinationInstitutionCode;
  }
  
  public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber)
  {
    this.beneficiaryAccountNumber = beneficiaryAccountNumber;
  }
  
  public void setResponseCode(String responseCode)
  {
    this.responseCode = responseCode;
  }
  
  public void setResponseDescription(String responseDescription)
  {
    this.responseDescription = responseDescription;
  }
  
  public void setHash(String hash)
  {
    this.hash = hash;
  }
  
  public String getRequestID()
  {
    return this.requestID;
  }
  
  public String getNibssSessionID()
  {
    return this.nibssSessionID;
  }
  
  public String getDestinationInstitutionCode()
  {
    return this.destinationInstitutionCode;
  }
  
  public String getBeneficiaryAccountNumber()
  {
    return this.beneficiaryAccountNumber;
  }
  
  public String getResponseCode()
  {
    return this.responseCode;
  }
  
  public String getResponseDescription()
  {
    return this.responseDescription;
  }
  
  public String getHash()
  {
    return this.hash;
  }
}
