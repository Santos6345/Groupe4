
package projet;

import java.awt.event.ActionEvent;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;
import javax.swing.text.TextAction;

/**
 *
 * @author jawher
 */
@SuppressWarnings("serial")
public class Indentation extends TextAction {
    
    
        public Indentation()
          {
               super(DefaultEditorKit.insertBreakAction);
          }

          public void actionPerformed(ActionEvent e)
          {
               JTextComponent zonedutexte = getTextComponent(e);

               if (zonedutexte == null) return;
               try
               {
                    //  Determiner dans quelle ligne on est

                    Document doc = zonedutexte.getDocument();
                    Element elementparDefaut = doc.getDefaultRootElement();
                    int debutdelaselection = zonedutexte.getSelectionStart();
                    int numLigne = elementparDefaut.getElementIndex( debutdelaselection );

                    //  Avoir le texte de cette ligne

                    int debut = elementparDefaut.getElement(numLigne).getStartOffset();
                    int fin = elementparDefaut.getElement(numLigne).getEndOffset();
                    String text = doc.getText(debut,fin - debut);
                    int i = 0;
                    //Avoir le nombre d'espace au début de cette ligne
                    for (i = 0; i < fin - debut; i++)
                    {
                         char c = text.charAt(i);

                         if (c != ' ' && c != '\t')
                              break;
                    }
                    //  Quand le texte contient des espaces au début de la ligne
                    if (debutdelaselection - debut > i)
                    {  
                        zonedutexte.replaceSelection("\n"+text.substring(0, i)+"          \n"+text.substring(0, i));
                        zonedutexte.setCaretPosition(elementparDefaut.getElement(elementparDefaut.getElementIndex(zonedutexte.getSelectionStart()) - 1).getEndOffset() - 1);
 
                    }        //Sinon 
                    else
                         zonedutexte.replaceSelection("           \n");
               }
               catch(BadLocationException ex) {}
          }
     }

