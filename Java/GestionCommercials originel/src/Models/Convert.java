/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author djiby
 */
public class Convert {
    public static String listToString(List<String> categorie){
      String stringCategorie="";
      for(String val:categorie){
          stringCategorie+=val+";";
      }
      return stringCategorie;
  }
    
    public static List<String> stringToList(String categorie){
        List<String> lCategorie=new ArrayList<>();
        String tab[]= categorie.split(";"); 
        for(String val :tab){
            lCategorie.add(val);
        }
        return lCategorie;
    }
}
