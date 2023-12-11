/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RentalCentral;

import java.util.HashMap;

/**
 *
 * @author jackg
 */
public class Logins {
    HashMap<String,String> logininfo = new HashMap<String,String>();
    Logins(){
        //name, username, password
        logininfo.put("admin","1234");
        logininfo.put("dguernsey","daniel2023");
        logininfo.put("Jstroder","Jiya2023");
        logininfo.put("Jrose","Jennifer2023");        
    }
    
    public HashMap getLoginInfo(){
        return logininfo;
    }
}
