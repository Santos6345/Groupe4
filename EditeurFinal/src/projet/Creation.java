/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;

/**
 *
 * @author jawher
 */
@SuppressWarnings("serial")
public class Creation extends JFrame implements ActionListener{
private int position;
FenetrePrincipale ed;
// Variables declaration                     
    private javax.swing.JButton annuler;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nom;
    private javax.swing.JTextArea texte;
    private javax.swing.JButton valider;
    // End of variables declaration           
    public Creation(int position) {
        initComponents();
        this.position=position;
        this.setVisible(true);
    }

                       
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        texte = new javax.swing.JTextArea();
        nom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        valider = new javax.swing.JButton();
        annuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu Création ");
        setFont(new java.awt.Font("Aparajita", 1, 10)); 

        texte.setColumns(20);
        texte.setRows(5);
        jScrollPane1.setViewportView(texte);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Texte");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel1.setText("Nom de la balise à créer");

        valider.setText("Valider");
        valider.addActionListener(this);

        annuler.setText("Annuler");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nom))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 41, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(valider)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(annuler)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(nom)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valider)
                    .addComponent(annuler)))
        );

        pack();
    }                   
                                      
public String Espace(int position)
                 {
                     String s="";
                     for (int i=0;i<(position*10);i++)
                     s+=" ";
                     
                     return s;
                 }
  
            

    @SuppressWarnings({ "unused", "static-access" })
	@Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource().equals(valider)){
           String name=nom.getText();
         String contenu=texte.getText();
        int ferme=-5;
        int ouvert=-5;
        int pos = -5;
        int valeur[] ={-5,-5};
   
        int i=1;
        String text=ed.jTextPane1.getText();
        
                
                 if(text.equals(""))
                 {int espace=0;
                     String Ntext="<"+name+">\n"+contenu+"\n</"+name+">";
                    ed.jTextPane1.setText(Ntext);   
                 }
                 else
                 {
                     Pattern ouverture=Pattern.compile("<[^/\\!\\?>][^<>]*>");
                     Matcher Mouverture=ouverture.matcher(text);
                     while (i <=position && Mouverture.find()) {
                        if (i == position) {
                               ouvert = Mouverture.end();      
                        }
                        i++;
                      }
                      String Ntext=text.substring(0,ouvert+1)+"\n"+Espace(position)+"<"+name+">\n"+Espace(position)+"     "+contenu+"\n"+Espace(position)+"</"+name+">\n\n"+text.substring(ouvert+1,text.length());
                      ed.jTextPane1.setText(Ntext);  
                 }
    this.dispose(); 
       }
       if (e.getSource().equals(annuler)){
           this.dispose(); 
       }
    }
}
