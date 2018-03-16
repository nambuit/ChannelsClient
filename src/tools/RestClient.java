/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Administrator
 */
public class RestClient {
    
    String endpointurl = "http://localhost:8080/InlaksNIPClient/webresources/NIPOutwardInterface";
    
    public RestClient(String endpointaddresss){
        
        this.endpointurl = endpointaddresss;
    }
    
       public RestClient(){
         
    }
    
    public String ProcessNIPRequest(String payload, String methodName){
        
        try {
            
        URL url = new URL(endpointurl+"/"+methodName); 
        
        HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
        connection.setDoOutput(true); 
        connection.setInstanceFollowRedirects(false); 
        connection.setRequestMethod("POST"); 
        connection.setRequestProperty("Accept", "application/json"); 
        connection.setRequestProperty("applicationID", "NambuitCore");  
        connection.setRequestProperty("Content-Type", "application/json");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        
        Date date = new Date();
        
        connection.setRequestProperty("timeStamp", sdf.format(date));
        connection.setRequestProperty("authenticationID", "ddfff");
       
        
         OutputStream os = connection.getOutputStream();
        
        os.write(payload.getBytes("UTF8")); 
        
        os.flush();

            BufferedReader   br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
          StringBuilder sb = new StringBuilder();
          String output;
          
          while ((output = br.readLine()) != null) {
          sb.append(output);
                 
        }
        
          return sb.toString();

    } catch(Exception e) { 
        throw new RuntimeException(e); 
    } 
    }
    
  
     public String get_SHA_512_Hash(String StringToHash, String   salt) throws Exception{
String generatedPassword = null;
    try {
         MessageDigest md = MessageDigest.getInstance("SHA-512");
         md.update(salt.getBytes(StandardCharsets.UTF_8));
         byte[] bytes = md.digest(StringToHash.getBytes(StandardCharsets.UTF_8));
         StringBuilder sb = new StringBuilder();
         for(int i=0; i< bytes.length ;i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
         }
         generatedPassword = sb.toString();
        } 
       catch (NoSuchAlgorithmException e){
       throw (e);
       }
    return generatedPassword;
}
    
    
  
}
