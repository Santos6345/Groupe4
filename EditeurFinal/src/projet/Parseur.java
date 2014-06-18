
package projet;

import java.io.IOException;
import java.io.StringReader;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class Parseur implements CaretListener{
  
    static Tree xmlJTree;
    static Editeur jTextPane1;
    static int position=0;
    static int positionBalise=0;
    private static  FenetrePrincipale ed;
    static org.w3c.dom.Document document = null;
   @SuppressWarnings("static-access")
public Parseur(Tree xmlJTree, Editeur jTextPane1)
   {
       this.xmlJTree=xmlJTree;
       this.jTextPane1=jTextPane1;
       
       
   }
   public static org.w3c.dom.Document parser()
    {
        
        DocumentBuilderFactory fabrique = DocumentBuilderFactory.newInstance();
        try {

                DocumentBuilder constructeur= fabrique.newDocumentBuilder();
                   constructeur.setErrorHandler(new GestionnaireDErreurs());
                try{
                    document = constructeur.parse(new InputSource(new StringReader(jTextPane1.getText())));
                 
                    reload(document,true);

                }catch(SAXException | IOException se){
                    reload(document,false);
                }
            }catch(Exception evt){
               
              
            }
        return document ;
    }   
   @SuppressWarnings("static-access")
public static void reload(org.w3c.dom.Document document,boolean parsage){
    if (parsage)
    {
        Tree.XmlRoot.removeAllChildren();
        Element elmnt= document.getDocumentElement();
        positionBalise=1;
        position=1;
        creationArbre(elmnt,xmlJTree.XmlRoot);
        xmlJTree. model.reload();
        //Affichage
        for(int i=0;i<xmlJTree.getRowCount();i++)
        xmlJTree.expandRow(i);
    }
    else 
    {
        xmlJTree.XmlRoot.removeAllChildren();
        xmlJTree. model.reload();
    }
        
    }
    static void creationArbre(Node element, Noeud XmlRoot) {
        String nom;
     if(element!=null && element.getNodeType() == Node.TEXT_NODE){
    	 if(!element.getTextContent().trim().isEmpty()){
             nom=enleverEspace(element.getTextContent());    
	     XmlRoot.add(new Noeud(nom,3,position));
             position=position+1;
         }
     }
     if(element!=null && element.getNodeType()!=4 && element.getNodeType()!=5 && element.getNodeType()!=3){
   		Noeud noeud1 = new Noeud(element.getNodeName(),2,positionBalise);
                positionBalise=positionBalise+1;
   		NamedNodeMap nMap = element.getAttributes();
   		if(element.hasChildNodes()){
                    for(int i=0;i<nMap.getLength();i++){
   				Node attribut = nMap.item(i);
				noeud1.add(new Noeud(attribut.getNodeName() + " = " + attribut.getNodeValue(),1,i));
                        }
                       // NodeList list element 1
   			NodeList liste = element.getChildNodes();
   			for(int j=0;j<liste.getLength();j++){
   				Node elem = element.getChildNodes().item(j);
                                //importantttttttttt!(verification)
   				creationArbre(elem, noeud1);
   			}
   			XmlRoot.add(noeud1);   	
   			
                }
   		else
                {
                     XmlRoot.add(noeud1);
   			 for(int i=0;i<nMap.getLength();i++){
   				 Node nAttribut = nMap.item(i);
   				 noeud1.add(new Noeud(nAttribut.getNodeName() + " = " + nAttribut.getNodeValue(),1,i));
   			 }
   						
   		}
   	 }
    
    }
     public static String enleverEspace(String chaine)
    {
        chaine= chaine.trim();
        return chaine;
    }
     @SuppressWarnings("static-access")
	public static void updatecurseur()
{
    int pos = jTextPane1.getCaretPosition();
    int row = 0, column=0;
  
    try {
                            int length = jTextPane1.getDocument().getLength();
                            String text = jTextPane1.getDocument().getText(0, length).replaceAll("\r", "");
                            if(pos+1<=text.length()){
                                text = text.substring(0, pos+1);
                                column--;
                            } 
                            while (text.contains("\n")) {
                                row++;
                                int start = text.indexOf("\n");
                                if (text.length() - start >= 1) {
                                    text = text.substring(start+1, text.length());
                                }
                            }
                            column += text.length();
                            ed.jTextField1.setText("Colonne : " + column +"    "+" Ligne : "+row + "     " +"        "+ "Position du curseur : " + pos);
                    } catch (BadLocationException e1) {

                    }
    
    
    
}
      public void caretUpdate(CaretEvent e) {
            //String parser =jTextPane1.getText();
          //http://java.developpez.com/faq/xml/?page=dom
          //Verifiez l'errorHandler
            parser();
            updatecurseur();
            
     
      
    }
}

