/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ActionMap;
import javax.swing.JTextPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;

/**
 *
 * @author jawher
 */
@SuppressWarnings("serial")
public class Editeur extends JTextPane implements KeyListener {
  boolean key1=false;
 public Editeur(){
     this.setEditable(true);
     this.setDocument(new Document());
     ActionMap am =this.getActionMap();
     am.put(DefaultEditorKit.insertBreakAction, new Indentation());
       this.addKeyListener(this);
    }
    @Override
    public void keyTyped(KeyEvent e) {
       
    
      
    }

    @Override
    public void keyPressed(KeyEvent e) {
       /*<script>
<![CDATA[
function matchwo(a,b)
{
if (a < b && a < 0) then
  {
  return 1;
  }
else
  {
  return 0;
  }
}
]]>
</script>*/
//KeyEvent.VK_EXCLAMATION_MARK
        if (e.getKeyCode() ==17){
           key1=true;
        }
          if (e.getKeyCode() ==KeyEvent.VK_EXCLAMATION_MARK){
          if (key1)
          {
            if (this.getSelectedText()!=null)
            {
             String texte=this.getSelectedText();
             this.replaceSelection(("<![CDATA["+texte+"]]>"));
            }
          } 
      }
      if (e.getKeyCode() ==10){
          if (key1)
          {
          new InsertionCdata();
          key1=false;
          }
      }
    }
    @SuppressWarnings("unused")
	@Override
    public void keyReleased(KeyEvent e) {
        //Action Listener sur le curseur pour mettre a jour jTextField1 (à changer dans Clistener CaretUpdate
         
         if (e.getKeyCode() == 16 )
        {
            boolean verif = true;
            int positioncurseur = this.getCaretPosition();
            int ouverture = this.getText().lastIndexOf('<', positioncurseur-1);
            int ouvertureprologue = this.getText().lastIndexOf("<?", positioncurseur-1);
            int ouverturecommentaire =this.getText().lastIndexOf("<!", positioncurseur-1);
            int fermeture = this.getText().lastIndexOf(">", positioncurseur-2);
            int fermetureouverture = this.getText().lastIndexOf("/>", positioncurseur-1);
            int ouverturefermeture = this.getText().lastIndexOf("</", positioncurseur-1);
             String[] balise=new String[1];
            if ( (ouverture > ouverturefermeture) && (ouverture > fermetureouverture) && (ouverture > ouverturecommentaire) && (ouverture > ouvertureprologue) && (ouverture > fermeture))
            {
               
                if( this.getText().contains(" "))
                    balise =  this.getText().substring(ouverture+1, positioncurseur-1).split(" "); //Division de la balise dans un tableau de string
                else 
                    balise[0] = this.getText().substring(ouverture+1, positioncurseur-1);
                this.select(positioncurseur, positioncurseur);
                if(!balise[0].isEmpty())
                {
                    Pattern fermant = Pattern.compile("</" + balise[0] + ">");
                    Pattern ouvrant = Pattern.compile("<" + balise[0]);
                    Matcher fermer = null;
                    try {
                        fermer = fermant.matcher( this.getText(0, this.getText().length()));
                    } catch (BadLocationException ex) {
                        Logger.getLogger(Editeur.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  
                 
                    Matcher ouvrir = null;
                    try {                   
                        ouvrir = ouvrant.matcher( this.getText(0, this.getText().length()));
                    } catch (BadLocationException ex) {
                        Logger.getLogger(Editeur.class.getName()).log(Level.SEVERE, null, ex);
                    }
   
                     this.replaceSelection("</" + balise[0] + ">");
                    verif=false;
                }
                if(!verif)
                    this.setCaretPosition(positioncurseur);
                else
                    this.setCaretPosition(positioncurseur-1);
            }
        }
        if (e.getKeyCode() ==17)
        {
            key1=false;
        }
        
         
    }

    public void valueChanged(TreeSelectionEvent e) {
        //http://www.lifl.fr/~secq/IUT/XML/xmlTut/4_tree.html
        /* transferer dans la classe tree
 *  int ELEMENT_TYPE =   1;
    int ATTR_TYPE =      2;
    int TEXT_TYPE =      3;*/
         
        
                         
                        
    }
  
    
    
    
    
    
    
}
