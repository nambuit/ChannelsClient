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
@XmlRootElement(name = "TransactionStatusQueryRequest")
public class TransactionStatusQueryRequest {
 
    private String requestID;
    private String nibssSessionID;
    private String hash;
     private String ChannelCode;
     private String InstitutionCode;
}