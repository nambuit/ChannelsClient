/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicelink;

import nibbsnip.service.BalanceEnquiryRequest;
import nibbsnip.service.NIBBSNIPInterface;
import nibbsnip.service.NIBBSNIPInterface_Service;

/**
 *
 * @author Temitope
 */
public class Channels {
    
    
    public void getBVN(String data){
        
        
        
        NIBBSNIPInterface_Service nip =  new NIBBSNIPInterface_Service();
        
       NIBBSNIPInterface nipport = nip.getNIBBSNIPInterfacePort();
       
     BalanceEnquiryRequest  balancerequest = new BalanceEnquiryRequest();
     
     balancerequest.setTargetAccountName("");
       
       nipport.balanceenquiry(balancerequest);
        
    }
    
}
