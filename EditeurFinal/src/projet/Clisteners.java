
package projet;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotUndoException;

/**
 *
 * @author jawher
 */
public class Clisteners implements ActionListener, UndoableEditListener, CaretListener, DocumentListener {
    private FenetrePrincipale ed;

    private JFileChooser JFC; 
    private File oFichier;
    private int option; 
    private String name;
    int num=1;
    DocumentEvent dd;
    public Clisteners(FenetrePrincipale ed)
		{
			this.ed=ed;

		}
    
    @SuppressWarnings("static-access")
	@Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource().equals(ed.btnRechercher))
       {
          
           rechercher();
       }
       else if (e.getSource().equals(ed.jButton2))
       {
           openFile();	
       }
        else if (e.getSource().equals(ed.jMenuItem1))
       {
              Nouveau();
           
       }
        else if (e.getSource().equals(ed.jButton1))
       {
           Nouveau();
           
       }
        else if (e.getSource().equals(ed.jButton3))
       {
           saveFile();
       }
        else if (e.getSource().equals(ed.jButton4))
       {
           saveAsFile();
           
       }
        else if (e.getSource().equals(ed.jMenuItem5))
       {
          saveAsFile();   
           
       }
        else if (e.getSource().equals(ed.jMenuItem16))
       {
            ed.jTextPane1.selectAll();
           
       }
        else if (e.getSource().equals(ed.jMenuItem15))
       {
           rechercher();
           
       }
        else if (e.getSource().equals(ed.jMenuItem14))
       {
          JOptionPane.showMessageDialog(null,"Ce Projet Editeur xml a été développé par :\n                         A.Rado\n                         B.Zakariae\n                         B.Mehdi\n                         G.Jawher\n                         H.Youssef\n PROJET JAVA ID -ISTY- IATIC3 2013-2014\n","À propos",JOptionPane.INFORMATION_MESSAGE);
           
       }
        else if (e.getSource().equals(ed.jButton5))
       {
            cut(); 
           
       } else if (e.getSource().equals(ed.jButton7))
       {
           paste();
           
       }
        else if (e.getSource().equals(ed.jMenuItem12))
       {
          paste();
           
       }
        else if (e.getSource().equals(ed.jButton6))
       {
           copy();
           
       }
        else if (e.getSource().equals(ed.jMenuItem11))
       {
           copy();
           
       }
        else if (e.getSource().equals(ed. jMenuItem9))
       {
           cut(); 
           
       }
     
       
        else if (e.getSource().equals(ed.jMenuItem6))
       {
           if(ed.annuler.canUndo())
		      {
		         if(ed.annuler.canUndo())
		         {
		            option = JOptionPane.showConfirmDialog(null,"Voulez-vous enregistrer le fichier ?");
		            if(option == 0)
		            {
		                saveAs("");
		               ed.jTextPane1.setText("");
		             }  
		             if(option == 1)
		             {
		               System.exit(0);
		             }
		          }
		          else
		          {
		            option = JOptionPane.showConfirmDialog(null,"Voulez-vous enregistrer le fichier ?");
		            if(option == 0)
		            {
		               save();
		               System.exit(0);
		             }
		             if(option == 1)
		             {
		               System.exit(0);
		             }
		          }
		       }
           System.exit(0);
           
       }
         else if (e.getSource().equals(ed.jMenuItem3))
       {
           saveFile();
       }
        
        else if (e.getSource().equals(ed.buttonRedo))
       {
        try {
					if (ed.annuler.canRedo()) {
						ed.annuler.redo();
						ed.buttonRedo.setEnabled(true);
					}
					if (!ed.annuler.canRedo()) {
						ed.buttonRedo.setEnabled(false);
					}
				}
				catch (CannotUndoException evt) {
					System.out.println("Impossible de rétablir : ");
			        evt.printStackTrace();
				}
    }
        else if (e.getSource().equals(ed.buttonUndo))
       {
           
        try {
					if (ed.annuler.canUndo()) {
                                                ed.annuler.undo();
						ed.buttonRedo.setEnabled(true);
					}
					if (!ed.annuler.canUndo()) {
						ed.buttonUndo.setEnabled(false);
					}
				}
				catch (CannotUndoException evt) {
					System.out.println("Impossible d'annuler : ");
			        evt.printStackTrace();
				}
    }
    else if (e.getSource().equals(ed.Popup_Menu_Cut)) {
            cut();
    }
    else if (e.getSource().equals(ed.Popup_Menu_Copy)) {
            copy();
    }
    else if (e.getSource().equals(ed.Popup_Menu_Paste)) {
           paste();
   }
       
 }
    @SuppressWarnings("static-access")
	public void Nouveau()
    {
         if(ed.annuler.canUndo())
		      {
		         if(ed.annuler.canUndo())
		         {
		            option = JOptionPane.showConfirmDialog(null,"Voulez-vous enregistrer le fichier ?");
		            if(option == 0)
		            {
		                saveAs("");
		               ed.jTextPane1.setText("");
		             }  
		             if(option == 1)
		             {
		                ed.jTextPane1.setText("");
		             }
		          }
		          else
		          {
		            option = JOptionPane.showConfirmDialog(null,"Voulez-vous enregistrer le fichier ?");
		            if(option == 0)
		            {
		               save();
		               ed.jTextPane1.setText("");
		             }
		             if(option == 1)
		             {
		               ed.jTextPane1.setText("");
		             }
		          }
		       }
		       else
		       {
		          ed.jTextPane1.setText("");
		       }
		      ed.jTabbedPane2.setTitleAt(0,"Nouveau Fichier");
                      name=null;
    }
   @SuppressWarnings("static-access")
public void openFile()
    {
           if (ed.annuler.canUndo()) {
                   int iReponse = JOptionPane.showConfirmDialog(ed.jTextPane1, "Attention, le document xml actuel n'a pas été enregistré.\n\nVoulez-vous enregistrer les modifications avant d'ouvrir un autre document xml ?", "Enregistrement des modifications", JOptionPane.YES_NO_CANCEL_OPTION);
                   if (iReponse == JOptionPane.YES_OPTION) {
                           saveAsFile();
                   }
                   else if (iReponse == JOptionPane.CANCEL_OPTION) {
                           return;
                   }
           }
           open("");
    }
   @SuppressWarnings("static-access")
public void cut()
    {
    try {
            StringSelection ss = new StringSelection(ed.jTextPane1.getSelectedText());
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	} catch( IllegalStateException e) {
            System.out.println("Erreur");
	}
	ed.jTextPane1.replaceSelection("");
				
    }
   @SuppressWarnings("static-access")
public void copy()
    {
        try {
                StringSelection ss = new StringSelection(ed.jTextPane1.getSelectedText());
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
            } catch( IllegalStateException e) {
            System.out.println("Erreur");
            }			
    }
   @SuppressWarnings("static-access")
public void paste()
    {
        Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
           try {
               String sText = "";
               if( t!=null && t.isDataFlavorSupported(DataFlavor.stringFlavor) ) {
               sText = (String)t.getTransferData(DataFlavor.stringFlavor);
               } 
               if (sText != "") {
                   ed.jTextPane1.replaceSelection(sText);
               }
           } catch( UnsupportedFlavorException e1) {
               System.out.println("Format inconnu");
               } catch( IOException e2 ) {
                   System.out.println("Erreur" );
               }
    }
   @SuppressWarnings("static-access")
public void saveAs(String sFileName ){
	FileWriter ecrire;
        try
        {
        if (sFileName.compareTo("") == 0) {
            JFC = new JFileChooser(".");
            JFC.setFileFilter(new FichierXml());
            JFC.showSaveDialog(ed.jTextPane1);
           File oFichier = JFC.getSelectedFile();
           if (oFichier.exists()) {
                   if (JOptionPane.showConfirmDialog(ed.jTextPane1, "Le fichier existe déjà, voulez-vous l'écraser ?", "Confirmation de l'écrasement", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                           return;
                   }
           }
           if (oFichier != null) {
                   sFileName = oFichier.getAbsolutePath();
                   if (!sFileName.endsWith(".xml")) {
                           sFileName = sFileName + ".xml";
                   }
           }
                }
            ecrire = new FileWriter(sFileName);
            ecrire.write(ed.jTextPane1.getText(0,ed.jTextPane1.getDocument().getLength()));
            ecrire.close();        
            @SuppressWarnings("unused")
			String content = ed.jTextPane1.getText();
            name = (JFC.getSelectedFile().getPath());
            ed.setTitle(JFC.getSelectedFile().getAbsolutePath() + " - Editeur XML");
            @SuppressWarnings("unused")
			String str = JFC.getSelectedFile().getAbsolutePath();
			}
			catch (Exception ex) {System.out.println("Impossible de sauvegarder le docuement XML: ");}	    	

	      
	    }
   @SuppressWarnings({ "unused", "static-access" })
public void save()
		{
                    FileWriter ecrire;
		    try
		    {       
                        String content = ed.jTextPane1.getText();
                        name = JFC.getSelectedFile().getPath();
                        ed.setTitle(JFC.getSelectedFile().getAbsolutePath() + " - Editeur XML");
		        String str = JFC.getSelectedFile().getAbsolutePath();
                        File oFichier = JFC.getSelectedFile();
                        ecrire = new FileWriter(name+".xml");
		        ecrire.write(ed.jTextPane1.getText(0,ed.jTextPane1.getDocument().getLength()));
	   	        ecrire.close();
		    }
			catch (Exception ex) {System.out.println("Impossible de sauvegarder le docuement XML: " + ex.toString());}	    	 
		   }
   public void saveAsFile() {
		       saveAs(""); 
		}
		public void saveFile()
		{	
			if(name == null)
		       {
		          saveAs(""); 
		       }
		       else
		       {
		          save();
		       }
		}
    public void rechercher(){
        
        new Recherche();
        /*try
        {

        word = JOptionPane.showInputDialog("Tapez le mot à trouver");
        while(ed.jTextPane1.getDocument().getText(0, length).indexOf(word) == -1)
        {
            JOptionPane.showMessageDialog(null,"Mot introuvable!","Résultat",JOptionPane.WARNING_MESSAGE);
            word = JOptionPane.showInputDialog("Tapez le mot à chercher");
        }
         ed.jTextPane1.select(ed.jTextPane1.getDocument().getText(0,length).indexOf(word),
                        ed.jTextPane1.getDocument().getText(0,length).indexOf(word) + word.length());
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Recherche annulée","Annulation",JOptionPane.INFORMATION_MESSAGE);
        }*/
    }
    @SuppressWarnings({ "static-access", "unused" })
	public void open(String sFileName ) {
		
     try
		{
                    if (sFileName.compareTo("") == 0) {
                    JFC = new JFileChooser();
		    JFC.setFileFilter(new FichierXml());
		    JFC.showOpenDialog(ed.jTextPane1);
		    oFichier = JFC.getSelectedFile();
		    if (oFichier != null) 
                    {
			sFileName = oFichier.getAbsolutePath();
			if (!sFileName.endsWith(".xml")) {
			sFileName = sFileName + ".xml";}}}
			FileInputStream input = new FileInputStream(sFileName);
                        String strLine;
                        @SuppressWarnings("resource")
						BufferedReader br = new BufferedReader(new InputStreamReader(input));
                        String Text="";
                        while ((strLine = br.readLine()) != null) {
                            Text=Text+strLine+"\n";
                        }
                        String nom=sFileName.substring(sFileName.lastIndexOf("\\")+1);
                        ed.jTextPane1.setText("");
                        ed.jTabbedPane2.setTitleAt(0, nom);
                        ed.jTextPane1.setText(Text);                      
                        ed.annuler.die();
                        String content = ed.jTextPane1.getText();
                        name = JFC.getSelectedFile().getPath();
                        ed.setTitle(JFC.getSelectedFile().getAbsolutePath() + " - Editeur XML");
                        String str = JFC.getSelectedFile().getAbsolutePath();
		 }
			catch (Exception ex) {System.out.println("Impossible de charger le document xml : ");}
    }
 
    @SuppressWarnings("static-access")
	@Override
   public void undoableEditHappened(UndoableEditEvent arg0) {
			ed.annuler.addEdit(arg0.getEdit());
		        ed.buttonUndo.setEnabled(true);
                        ed.buttonRedo.setEnabled(false);
			
			
		}
  
    @SuppressWarnings("static-access")
	@Override
    public void caretUpdate(CaretEvent e) {
	      if ( ed.jTextPane1.getSelectedText() == null) {
	    	  ed.jButton5.setEnabled(false);
                  ed.jButton6.setEnabled(false);
                  ed.jMenuItem9.setEnabled(false);
                  ed.jMenuItem11.setEnabled(false);
	      }
	      else {
	    	   ed.jButton5.setEnabled(true);
                  ed.jButton6.setEnabled(true);
                  ed.jMenuItem9.setEnabled(true);
                  ed.jMenuItem11.setEnabled(true);
	      }
    }

    @Override
    public void insertUpdate(DocumentEvent dd) {
        
    }

    @Override
    public void removeUpdate(DocumentEvent dd) {
     //ed.annuler.undo();
       // System.out.println("test1");
    }

    @Override
    public void changedUpdate(DocumentEvent dd) {
       

    }
    
}
