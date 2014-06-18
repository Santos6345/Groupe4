/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author jawher
 */
public class GestionnaireDErreurs implements ErrorHandler {
    

    @Override
    public void warning(SAXParseException exception) throws SAXException {

    }

    @Override
    public void error(SAXParseException exception) throws SAXException {

    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {

    }
    
    
}
