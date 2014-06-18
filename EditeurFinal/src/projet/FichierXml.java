/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.io.File;
import javax.swing.filechooser.FileFilter;
public class FichierXml extends FileFilter {
	
        public FichierXml() {
		super();
	}
        
        @Override
        public boolean accept(File f) {
            if (f.isDirectory()) {
                return true;
            }
            String extension = f.getName();
            if (extension.endsWith(".xml")) {
        	return true;
            }
            else {
        	return false;
            }
        }
        
        @Override
        public String getDescription() {
            return "Fichier xml";
    }

}
