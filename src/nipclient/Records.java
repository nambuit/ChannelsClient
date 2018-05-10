package nipclient;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="records")
public class Records
{
  private String institutionName;
  private String category;
  private String institutionCode;
  
  public void setInstitutionName(String institutionName)
  {
    this.institutionName = institutionName;
  }
  
  public void setCategory(String category)
  {
    this.category = category;
  }
  
  public void setInstitutionCode(String institutionCode)
  {
    this.institutionCode = institutionCode;
  }
  
  public String getInstitutionName()
  {
    return this.institutionName;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public String getInstitutionCode()
  {
    return this.institutionCode;
  }
}
