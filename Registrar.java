/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationcomponent;

/**
 *
 * @author Pedro
 */
public class Registrar {
        
        private boolean override = false;
        
        void setOverride ( boolean value ){
            override = value;
            
        }
        
        boolean canRegister(int credits, double gpa ){
                if (override){
                        if (gpa < 1.0){
                            return false;
                        }
                        return true;
                }
                else if ( gpa < 2.0 )
                        return false;
                else if ( gpa >= 3.0 )
                        return true;
                else
                        return credits < 16;
        }
        
        boolean creditCost (int totalCredits ){
            
                if (override){
                        return false;
                }                
                else if (totalCredits > 120)
                        return true;
                else
                        return false;
        }
        
        boolean courseRegistration (int attempts){
            if (override){
                    return true;
            }
            else if (attempts <= 3){
                    return true;
            }
            return false;
        }
               
        
    
}
