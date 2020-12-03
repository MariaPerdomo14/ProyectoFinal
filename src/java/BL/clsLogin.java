/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

/**
 *
 * @author Maria Angelica
 */
public class clsLogin {
    public boolean validarLogin(Models.clsLogin obclsLogin){
        try{
            
            return obclsLogin.getStEmail().equals("mariajhon04@gmail.com")&&
                    obclsLogin.getStPassword().equals("14321");
            
        }catch(Exception ex){
            throw ex;
            
        }
        
    }   
   
}
