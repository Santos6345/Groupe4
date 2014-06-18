/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.awt.Color;

import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.swing.Timer;
//Ajouter un élément qui actualise le doc a chaque fois


@SuppressWarnings("serial")
public class Document extends DefaultStyledDocument {
    
       @SuppressWarnings("unused")
	private static HashMap<Pattern, Color> patternColors;
       private SimpleAttributeSet caractere;
       private static String baliseouvrante="<";
       private static String balisefermante=">";
       private static  String attributbalise="\\w+=";
       private static String cData="<!";
       private static String fcData=">";
       @SuppressWarnings("unused")
	private static String DebutCdata="[CDATA";
        private static String valeurbalise="\"[^\"]*\"?";
       @SuppressWarnings("unused")
	private static String finCdata="]]";
       private int t = 10;
        public Document ()
        {
            caractere=new SimpleAttributeSet();
            putProperty(DefaultEditorKit.EndOfLineStringProperty, "\n");
            ActionListener CListener = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
                            try {
                                reload();
                            } catch (Exception ex) {
                                Logger.getLogger(Document.class.getName()).log(Level.SEVERE, null, ex);
                            }
				
			}
		};
            new Timer(t, CListener).start();
            
        }
        public  void reload() throws Exception
	{
                    StyleConstants.setForeground(caractere,Color.GREEN.darker());
                    StyleConstants.setBold(caractere,true);
                    Pattern ouverture=Pattern.compile(baliseouvrante);
                    Pattern fermeture=Pattern.compile(balisefermante);
                    this.setCharacterAttributes(0,this.getLength(), caractere, true);      
                    Matcher open = ouverture.matcher(getText(0,this.getLength()));
                    Matcher close = fermeture.matcher(getText(0,this.getLength()));

                    int  longueur;

                    while (open.find())
                    {
			if (close.find(open.end()))
				longueur = close.end() - open.start();
			else
				longueur = this.getLength();
                       StyleConstants.setForeground(caractere,Color.BLACK);
                       StyleConstants.setBold(caractere,true);
                       this.setCharacterAttributes(open.start(),longueur, caractere, true);
                       int deb=open.start();
                       Pattern attribut=Pattern.compile(attributbalise);
                       Matcher attribute = attribut.matcher(getText(deb, longueur));
                       
                   
                        /*while (cdata.find())
                        {
                            StyleConstants.setForeground(carac,Color.RED);
                            StyleConstants.setBold(carac,true);
                            this.setCharacterAttributes(attribute.start()+open.start(),attribute.end() - attribute.start(), carac, true);      
                        }*/
                       while (attribute.find())
                        {
                            deb=open.start();
                            StyleConstants.setForeground(caractere,Color.RED.darker());
                            StyleConstants.setBold(caractere,true);
                            this.setCharacterAttributes(attribute.start()+deb,attribute.end() - attribute.start(), caractere, true);      
                        }
                        deb=open.start();
                        Pattern valeur=Pattern.compile(valeurbalise);
			Matcher begin = valeur.matcher(getText(deb, longueur));

			while (begin.find())
                        {
                            deb=open.start();
                           StyleConstants.setForeground(caractere,Color.BLUE.brighter());
                           this.setCharacterAttributes(begin.start() + deb,begin.end() - begin.start(), caractere, true);                
                        }
                }
                    Pattern Couvrant=Pattern.compile(cData);
                    Pattern Cfermant=Pattern.compile(fcData);
                    Matcher opencomment = Couvrant.matcher(getText(0,this.getLength()));
                    Matcher closecomment = Cfermant.matcher(getText(0,this.getLength()));
                    while (opencomment.find())
                    {
                        
			if (closecomment.find(opencomment.end()))
                        {
                            StyleConstants.setForeground(caractere,Color.MAGENTA);
                            this.setCharacterAttributes(opencomment.start(),(closecomment.end() - opencomment.start()), caractere, true);   
                        }
			else
                        {
                            StyleConstants.setForeground(caractere,Color.MAGENTA);
                            this.setCharacterAttributes( opencomment.start(),this.getLength(), caractere, true);   
                        }
                    }
                     
	}
}