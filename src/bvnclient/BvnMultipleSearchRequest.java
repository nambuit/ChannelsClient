/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bvnclient;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author emusa
 */
@Getter
@Setter
public class BvnMultipleSearchRequest {

    private String requestID;
    private String BVNs;
    private String bankcodes;
    private String institutioncode;
    private String hash;

}
