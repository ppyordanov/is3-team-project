/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is3system;

import java.io.FileNotFoundException;
import userInterface.IS3SystemUI;

/**
 *
 * @author Samsung
 */
public class IS3System {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        IS3SystemUI theUI = new IS3SystemUI();
        theUI.setVisible(true);
    }
}
