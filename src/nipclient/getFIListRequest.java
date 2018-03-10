/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nipclient;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author r16user
 */


@Getter @Setter
@XmlRootElement(name = "NameEnquiryRequest")
public class getFIListRequest {
    
    private String requestID;
    private String hash;
}
