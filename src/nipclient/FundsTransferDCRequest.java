package nipclient;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="FundsTransferDCRequest")
public class FundsTransferDCRequest
{
  private String requestID;
  private String nameEnquiryRef;
  private String destinationInstitutionCode;
  private String beneficiaryAccountName;
  private String beneficiaryAccountNumber;
  private String beneficiaryBankVerificationNumber;
  private String beneficiaryKYCLevel;
  private String originatorAccountName;
  private String originatorAccountNumber;
  private String originatorBankVerificationNumber;
  private String originatorKYCLevel;
  private String transactionLocation;
  private String narration;
  private String amount;
  private String hash;
  private String ChannelCode;
  private String InstitutionCode;
  private String PaymentReference;
  
  public void setRequestID(String requestID)
  {
    this.requestID = requestID;
  }
  
  public void setNameEnquiryRef(String nameEnquiryRef)
  {
    this.nameEnquiryRef = nameEnquiryRef;
  }
  
  public void setDestinationInstitutionCode(String destinationInstitutionCode)
  {
    this.destinationInstitutionCode = destinationInstitutionCode;
  }
  
  public void setBeneficiaryAccountName(String beneficiaryAccountName)
  {
    this.beneficiaryAccountName = beneficiaryAccountName;
  }
  
  public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber)
  {
    this.beneficiaryAccountNumber = beneficiaryAccountNumber;
  }
  
  public void setBeneficiaryBankVerificationNumber(String beneficiaryBankVerificationNumber)
  {
    this.beneficiaryBankVerificationNumber = beneficiaryBankVerificationNumber;
  }
  
  public void setBeneficiaryKYCLevel(String beneficiaryKYCLevel)
  {
    this.beneficiaryKYCLevel = beneficiaryKYCLevel;
  }
  
  public void setOriginatorAccountName(String originatorAccountName)
  {
    this.originatorAccountName = originatorAccountName;
  }
  
  public void setOriginatorAccountNumber(String originatorAccountNumber)
  {
    this.originatorAccountNumber = originatorAccountNumber;
  }
  
  public void setOriginatorBankVerificationNumber(String originatorBankVerificationNumber)
  {
    this.originatorBankVerificationNumber = originatorBankVerificationNumber;
  }
  
  public void setOriginatorKYCLevel(String originatorKYCLevel)
  {
    this.originatorKYCLevel = originatorKYCLevel;
  }
  
  public void setTransactionLocation(String transactionLocation)
  {
    this.transactionLocation = transactionLocation;
  }
  
  public void setNarration(String narration)
  {
    this.narration = narration;
  }
  
  public void setAmount(String amount)
  {
    this.amount = amount;
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
  
  public void setPaymentReference(String PaymentReference)
  {
    this.PaymentReference = PaymentReference;
  }
  
  public String getRequestID()
  {
    return this.requestID;
  }
  
  public String getNameEnquiryRef()
  {
    return this.nameEnquiryRef;
  }
  
  public String getDestinationInstitutionCode()
  {
    return this.destinationInstitutionCode;
  }
  
  public String getBeneficiaryAccountName()
  {
    return this.beneficiaryAccountName;
  }
  
  public String getBeneficiaryAccountNumber()
  {
    return this.beneficiaryAccountNumber;
  }
  
  public String getBeneficiaryBankVerificationNumber()
  {
    return this.beneficiaryBankVerificationNumber;
  }
  
  public String getBeneficiaryKYCLevel()
  {
    return this.beneficiaryKYCLevel;
  }
  
  public String getOriginatorAccountName()
  {
    return this.originatorAccountName;
  }
  
  public String getOriginatorAccountNumber()
  {
    return this.originatorAccountNumber;
  }
  
  public String getOriginatorBankVerificationNumber()
  {
    return this.originatorBankVerificationNumber;
  }
  
  public String getOriginatorKYCLevel()
  {
    return this.originatorKYCLevel;
  }
  
  public String getTransactionLocation()
  {
    return this.transactionLocation;
  }
  
  public String getNarration()
  {
    return this.narration;
  }
  
  public String getAmount()
  {
    return this.amount;
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
  
  public String getPaymentReference()
  {
    return this.PaymentReference;
  }
}
