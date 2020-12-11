/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalBorders;

/**
 *
 * @author Thiago
 */
//para campos que não podem ser vazios
public class VerificaCampoVazio extends InputVerifier {
      @Override
    public boolean verify(JComponent input) {
         String text = ((JTextField) input).getText();
         
         if(text.equals("") || text.matches("()*")){
             return false;
         }
         return true;
         
    }
    @Override
     public boolean shouldYieldFocus(JComponent input) {

         boolean isValid = verify(input);
        
        Border originalBorder=input.getBorder();
        input.setBorder(MetalBorders.getTextFieldBorder());
        if(isValid){
            input.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
            //input.setBorder(MetalBorders.getTextFieldBorder());
        }else{
            //input.setBorder(BorderFactory.createLineBorder(Color.red, 2));
            //JOptionPane.showMessageDialog(null, "Este Campo obrigatório, não pode ser vazio");
        }
        
        return isValid;
    }
}
