
package projet;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author jawher
 */
@SuppressWarnings("serial")
public class Tree extends JTree implements TreeSelectionListener, MouseListener, ActionListener{
    static DefaultTreeModel model;
    static Noeud XmlRoot;
    FenetrePrincipale ed;
    Parseur p;
    private JPopupMenu Tree_Popup_Menu;
    private JMenuItem Popup_Menu_Select,Popup_Menu_Creer, Popup_Menu_Supprimer, Popup_Menu_Renommer, Popup_Menu_Copier, Popup_Menu_Deplacer;
    private final String Button_Creer = "Creer";
    private final String Button_Selectionner = "Select";
    private final String Button_Deplacer= "Deplacer";
    private final String Button_Copier= "copier";
    private final String Button_Supprimer = "Supprimer";
    private final String Button_Renommer = "Renommer";
    private Noeud courant;
    public Tree()
    {
        XmlRoot=new Noeud("Votre Editeur XML-navigateur-");
        model = new DefaultTreeModel(XmlRoot);
         this.setModel(model);
         this.addTreeSelectionListener(this);
         //Autoriser qu'une seule selection 
         this.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
         this.setCellRenderer((TreeCellRenderer) new JreeCellRenderer());
          this.setEditable(true);
         this.setDragEnabled(true);
         this.setShowsRootHandles(true);
         this.setFocusable(true);
         this.setMinimumSize(new Dimension(300,300));
         //Tree_Popup_Menu//
          Tree_Popup_Menu = new JPopupMenu();
        Popup_Menu_Creer = new JMenuItem("Créer");
        Popup_Menu_Creer.setName(Button_Creer);
	Popup_Menu_Creer.addActionListener(this);
	Tree_Popup_Menu.add(Popup_Menu_Creer); 
	Popup_Menu_Supprimer = new JMenuItem("Supprimer");
        Popup_Menu_Supprimer.setName(Button_Supprimer );
	Popup_Menu_Supprimer.addActionListener(this);
        Tree_Popup_Menu.add(Popup_Menu_Supprimer);
        Popup_Menu_Renommer = new JMenuItem("Re-nommer");
        Popup_Menu_Renommer.setName(Button_Renommer);
	Popup_Menu_Renommer.addActionListener(this);
	Tree_Popup_Menu.add(Popup_Menu_Renommer);
	Tree_Popup_Menu.addSeparator();
        Popup_Menu_Copier= new JMenuItem("Copier");
        Popup_Menu_Copier.setName(Button_Copier);
	Popup_Menu_Copier.addActionListener(this);
	Tree_Popup_Menu.add(Popup_Menu_Copier); 
        Popup_Menu_Deplacer= new JMenuItem("Déplacer");
        Popup_Menu_Deplacer.setName(Button_Deplacer);
	Popup_Menu_Deplacer.addActionListener(this);
	Tree_Popup_Menu.add(Popup_Menu_Deplacer); 
        Popup_Menu_Select= new JMenuItem("Sélectionner dans l'editeur");
        Popup_Menu_Select.setName(Button_Selectionner);
	Popup_Menu_Select.addActionListener(this);
	Tree_Popup_Menu.add(Popup_Menu_Select); 
                

    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        //L'ordre est important
    
      
        if(e.getNewLeadSelectionPath() != null){

                courant = (Noeud)e.getPath().getLastPathComponent();
                  this.addMouseListener(
                new MouseAdapter() {
                   public void mousePressed(MouseEvent e) {
                      checkTrigger(e);
                   }
                   public void mouseReleased(MouseEvent e) {
                      checkTrigger(e);
                   }
                   private void checkTrigger(MouseEvent e) {
                      if (e.isPopupTrigger()) {
                         updatePopupOptions();
                         Tree_Popup_Menu.show(e.getComponent(), e.getX(), e.getY());
                      }
                   }
                }
             );
       }

    }
    public void updatePopupOptions(){
	      
	    	  Popup_Menu_Creer.setEnabled(true);
	    	  Popup_Menu_Supprimer.setEnabled(true);
                  Popup_Menu_Renommer.setEnabled(true);
    }
	      
	    
   

    @Override
    public void mouseClicked(MouseEvent evt) {
       
    }

    @Override
    public void mousePressed(MouseEvent evt) {
       
    }

    @Override
    public void mouseReleased(MouseEvent evt) {
      
    }

    @Override
    public void mouseEntered(MouseEvent evt) {
        
    }

    @Override
    public void mouseExited(MouseEvent evt) {
       
    }

    @Override
    public void actionPerformed(ActionEvent ex) {
        if (ex.getSource().equals((Popup_Menu_Creer)))
        {
             creer(courant);
        }
        else if (ex.getSource().equals((Popup_Menu_Supprimer)))
        {
            supprimer(courant);
        }
        else if (ex.getSource().equals((Popup_Menu_Renommer)))
        {
            System.out.println("Renommer");
        }
        else if (ex.getSource().equals((Popup_Menu_Copier)))
        {
            copier(courant);
        }
        else if (ex.getSource().equals((Popup_Menu_Deplacer)))
        {
            System.out.println("Deplacer");
        }
        else if (ex.getSource().equals((Popup_Menu_Select)))
        {
           selectionner(courant);
            //System.out.println(courant.getPosition());
        }
    }
    @SuppressWarnings("static-access")
	public void copier(Noeud courant)
    {
        int valeur[] ={-5,-5};
         
        //Attribut
        if (courant.getType()==1)   
        {
            valeur= rechercherAttribut(courant);
             ed.jTextPane1.select( valeur[0], valeur[1]);
            try {
                StringSelection ss = new StringSelection(ed.jTextPane1.getSelectedText());
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
            } catch( IllegalStateException e) {
            System.out.println("Le presse papier n'est pas disponible");
            }			
             ed.jTextPane1.setCaretPosition(valeur[1]);
            
        }
         //balise
         else if (courant.getType()==2)   
        {
            valeur= rechercherBalise(courant);
             ed.jTextPane1.select(  valeur[0], valeur[1]);
            try {
                StringSelection ss = new StringSelection(ed.jTextPane1.getSelectedText());
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
            } catch( IllegalStateException e) {
            System.out.println("Le presse papier n'est pas disponible");
            }			
             ed.jTextPane1.setCaretPosition(valeur[1]);
        } 
         //texte
         else if (courant.getType()==3)   
        {
             valeur= rechercherTexte(courant);
             ed.jTextPane1.select( valeur[0], valeur[1]);
             try {
                StringSelection ss = new StringSelection(ed.jTextPane1.getSelectedText());
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
            } catch( IllegalStateException e) {
            System.out.println("Le presse papier n'est pas disponible");
            }			
             ed.jTextPane1.setCaretPosition(valeur[1]);
        }
       //ed.jTextPane1.
        
        
    }
    public void creer(Noeud courant)
    {
        new Creation(courant.getPosition());
    }
    @SuppressWarnings("static-access")
	public void supprimer(Noeud courant)
    {
        int valeur[] ={-5,-5};
         
        //Attribut
        if (courant.getType()==1)   
        {
            valeur= rechercherAttribut(courant);
             ed.jTextPane1.select(  valeur[0], valeur[1]);
            ed.jTextPane1.replaceSelection("");
            
        }
         //balise
         else if (courant.getType()==2)   
        {
            valeur= rechercherBalise(courant);
             ed.jTextPane1.select(  valeur[0], valeur[1]);
            ed.jTextPane1.replaceSelection("");
        } 
         //texte
         else if (courant.getType()==3)   
        {
             valeur= rechercherTexte(courant);
             ed.jTextPane1.select(  valeur[0], valeur[1]);
             ed.jTextPane1.replaceSelection("");
        }
    }
    @SuppressWarnings("static-access")
	public void selectionner(Noeud courant)
    {
        int valeur[];

        //Balise ouvrante
        if (courant.getType()!=0)
        {
            if (courant.getType()==2)
             {
                   valeur= rechercherBalise(courant);
                    ed.jTextPane1.requestFocus();
                    ed.jTextPane1.select(  valeur[0], valeur[1]);
             }
            else if (courant.getType()==3)
             {
                   valeur= rechercherTexte(courant);
                    
                    ed.jTextPane1.requestFocus();
                    ed.jTextPane1.select(valeur[0]+1,valeur[1]-1);
             }
            else if (courant.getType()==1)
             {
                   valeur= rechercherAttribut(courant);
                    
                    ed.jTextPane1.requestFocus();
                    ed.jTextPane1.select(  valeur[0], valeur[1]);
             }
            
        }
        
    }
      @SuppressWarnings({ "unused", "static-access" })
	public int[] rechercherBalise(Noeud courant)
    {
        int ferme=-5;
        int ouvert=-5;
        int pos = -5;
        String REGX="<[^/\\!\\?>][^<>]*>";
        int valeur[] ={-5,-5};
        String texte=ed.jTextPane1.getText();
        String chaine=courant.toString();
     
        int position=courant.getPosition();
        int type=courant.getType();
        
            //ELEMENT
            Pattern ouverture=Pattern.compile(REGX);
            Matcher Mouverture=ouverture.matcher(texte);
            int i = 1;
            while (i <=position && Mouverture.find()) {
                            if (i == position) {
                               
                                    ouvert = Mouverture.start();
                                    
                            }
                            i++;
                    }
            valeur[0]=ouvert;
          if(ouvert!=-5)
            {
                 
                 if (Mouverture.group(0).substring(Mouverture.group(0).length() - 2).equals("/>")){
				ferme = Mouverture.end();
			}
                 else{
                     
                     Pattern fermeture=Pattern.compile("</"+chaine+">");
                 Matcher Mfermeture=fermeture.matcher(texte);
                 while ( Mfermeture.find())
                 {
                     ferme =Mfermeture.end();
                 }
                     
                 }
                   
            }
           
           valeur[1]=ferme;
           return valeur;
        }
       @SuppressWarnings({ "static-access", "unused" })
	public int[] rechercherTexte(Noeud courant)
        {
        int pos = -5;
        String REGX=">[^<]*[^\\s<][^<]*<";
        int valeur[] ={-5,-5};
        String texte=ed.jTextPane1.getText();
        int position=courant.getPosition();
        String chaine=courant.toString();
        Pattern t=Pattern.compile(REGX);
        Matcher Mtexte=t.matcher(texte);
        int i=1;
        while (i<=position&&Mtexte.find()) {
             pos = Mtexte.start();
              valeur[0]=pos;
              valeur[1]=Mtexte.end();
              i++;
        }
             System.out.println(valeur[0]);
             System.out.println(valeur[1]);
             return valeur;
        }
         public int[] rechercherAttribut(Noeud courant)
        {
        int pos = -5;
        int valeur[] ={-5,-5};
        @SuppressWarnings("static-access")
		String texte = ed.jTextPane1.getText();
        @SuppressWarnings("unused")
		int position=courant.getPosition();
        String chaine=courant.toString().substring(0,courant.toString().indexOf("=")).trim();
        String valeurChaine=courant.toString().substring(courant.toString().indexOf("=")+1,courant.toString().length()).trim();
        Pattern t=Pattern.compile(chaine+"="+"\""+valeurChaine+"\"");
        Matcher Mtexte=t.matcher(texte);
        while (Mtexte.find()) {
             pos = Mtexte.start();
              valeur[0]=pos;
              valeur[1]=Mtexte.end();
        }
        if (valeur[0]==-5&&valeur[1]==-5){
        chaine=courant.toString().substring(0,courant.toString().indexOf("="));
        valeurChaine=courant.toString().substring(courant.toString().indexOf("=")+1,courant.toString().length()).trim();
        t=Pattern.compile(chaine+"="+"\""+valeurChaine+"\"");
        Mtexte=t.matcher(texte);
        while (Mtexte.find()) {
             pos = Mtexte.start();
              valeur[0]=pos;
              valeur[1]=Mtexte.end();
        }
        }

             return valeur;
        }
      
    
}
