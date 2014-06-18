
package projet;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;

/**
 *
 * @author jawher
 */
@SuppressWarnings({ "unused", "serial" })
public class Recherche extends JFrame implements ActionListener {
int begin;
Boolean trouve=false;
 // Variables declaration       
    private FenetrePrincipale ed;
    private javax.swing.JButton annuler;
    private javax.swing.JRadioButton balise;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton mot;
    private javax.swing.JTextField nom;
    private javax.swing.JButton suivant;           
  
    public Recherche() {
        initComponents();
        begin=0;
        this.setVisible(true);
        
    }
                  
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        mot = new javax.swing.JRadioButton();
        balise = new javax.swing.JRadioButton();
        nom = new javax.swing.JTextField();
        suivant = new javax.swing.JButton();
        annuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); 
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Mot/Balise à chercher");

        buttonGroup1.add(mot);
        mot.setSelected(true);
        mot.setText("Mot");
        mot.addActionListener(this);
        buttonGroup1.add(balise);
        balise.setText("Balise");
        balise.addActionListener(this);
        suivant.setText("Suivant");
        suivant.addActionListener(this);
        annuler.setText("Annuler");
        annuler.addActionListener(this);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(balise, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(suivant)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(annuler)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(nom)))
                .addGap(18, 18, 18)
                .addComponent(mot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(balise)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suivant)
                    .addComponent(annuler)))
        );

        pack();
    }                    

    @SuppressWarnings("static-access")
	@Override
    public void actionPerformed(ActionEvent e) {
        String text=ed.jTextPane1.getText();
        
         text=text.substring(begin);
        if (e.getSource().equals(suivant)){
        
                
                if (mot.isSelected())
                {
                    String recherche=nom.getText();             
                        if(text.indexOf(recherche) == -1)
                         {
                             if (!trouve)
                             JOptionPane.showMessageDialog(null,"Mot introuvable!","Résultat",JOptionPane.WARNING_MESSAGE);
                             else JOptionPane.showMessageDialog(null,"Vérification du document terminée","Résultat",JOptionPane.WARNING_MESSAGE);
                         }
                         else
                        {
                             ed.jTextPane1.select(begin+text.indexOf(recherche),recherche.length()+text.indexOf(recherche)+begin);
                             begin+=text.indexOf(recherche)+recherche.length();
                             trouve=true;
                        }
                   
                 }
             else
                {
                String recherche="<"+nom.getText()+">";
                String recherche2="<"+nom.getText()+"/>";
                   
                        if((text.indexOf(recherche) == -1)&&(text.indexOf(recherche2) == -1))
                         {
                             if (!trouve)
                             JOptionPane.showMessageDialog(null,"Mot introuvable!","Résultat",JOptionPane.WARNING_MESSAGE);
                             else JOptionPane.showMessageDialog(null,"Vérification du document terminée","Résultat",JOptionPane.WARNING_MESSAGE);
                         }
                        else
                            {               
                                        if(text.indexOf(recherche) != -1)
                                        {
                                         ed.jTextPane1.select(begin+text.indexOf(recherche),recherche.length()+text.indexOf(recherche)+begin);
                                         begin+=text.indexOf(recherche)+recherche.length();
                                         trouve=true;
               
                                        }
                                        else
                                        {
                                       ed.jTextPane1.select(begin+text.indexOf(recherche2),recherche2.length()+text.indexOf(recherche2)+begin);
                                         begin+=text.indexOf(recherche)+recherche2.length();
                                         trouve=true;
                                        }
                            
                    } 
                 
        }
        }
        else if (e.getSource().equals(annuler)){
            this.dispose();
        }
        else if (e.getSource().equals(balise)){
            begin=0;
            trouve=false;
        }
        else if (e.getSource().equals(mot)){
            begin=0;
            trouve=false;
        }
    
    
    
    
    }

          
}
