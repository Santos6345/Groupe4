
package projet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 *
 * @author jawher
 * 
 */
@SuppressWarnings("serial")
public class InsertionCdata extends JFrame implements ActionListener{

     // Variables declaration                     
    private javax.swing.JButton ajouter;
    private javax.swing.JButton annuler;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nom;
    FenetrePrincipale ed;
    // End of variables declaration     
    public InsertionCdata() {
        initComponents();
        this.setVisible(true);
    }
                       
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        ajouter = new javax.swing.JButton();
        annuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nom de l'élément");

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 12)); 
        jLabel1.setText("Nom de la balise");

        ajouter.setText("Ajouter");
        ajouter.addActionListener(this);

        annuler.setText("Annuler");
        annuler.addActionListener(this);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ajouter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(annuler))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ajouter)
                    .addComponent(annuler)))
        );

        pack();
    }                  
                 

    @SuppressWarnings("static-access")
	@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(ajouter)){
            String texte=ed.jTextPane1.getSelectedText();
            if (ed.jTextPane1.getSelectedText()!=null)
            {
             ed.jTextPane1.replaceSelection(("<"+nom.getText()+"><![CDATA["+texte+"]]></"+ nom.getText()+">"));
             this.dispose();
            }
            else{
                ed.jTextPane1.replaceSelection(("<"+nom.getText()+"><![CDATA["+""+"]]></"+ nom.getText()+">"));
                this.dispose();
            }
        }
    
        else if (e.getSource().equals(annuler)){
            this.dispose();
        }
    }
}