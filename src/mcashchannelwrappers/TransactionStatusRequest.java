/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcashchannelwrappers;
import lombok.Getter;
import lombok.Setter;
/**
 *
 * @author dogor-Igbosuah
 */
@Getter @Setter
public class TransactionStatusRequest {
   
    private String requestID;
    private String InstitutionCode;
    private String RequestorID;
    private String PayerPhoneNumber;
    private String MerchantCode;
    private String ReferenceCode;
    private String hash;

}
