/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ActionMap;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.text.DefaultEditorKit;
import javax.swing.undo.UndoManager;

/**
 *
 * @author jawher
 */
@SuppressWarnings("serial")
public class FenetrePrincipale  extends JFrame{
    public static JButton btnRechercher;
    public static JButton buttonRedo;
    public static JButton buttonUndo;
    public static JButton jButton1;
    public static JButton jButton2;
    public static JButton jButton3;
    public static JButton jButton4;
    public static JButton jButton5;
    public static JButton jButton6;
    public static JButton jButton7;
    public static JMenu jMenu1;
    public static JMenu jMenu2;
    public static JMenu jMenu4;
    public static JMenuBar jMenuBar1;
    public static JMenuItem jMenuItem1;
    public static JMenuItem jMenuItem10;
    public static JMenuItem jMenuItem11;
    public static JMenuItem jMenuItem12;
    public static JMenuItem jMenuItem13;
    public static JMenuItem jMenuItem14;
    public static JMenuItem jMenuItem15;
    public static JMenuItem jMenuItem16;
    public static JMenuItem jMenuItem2;
    public static JMenuItem jMenuItem3;
    public static JMenuItem jMenuItem4;
    public static JMenuItem jMenuItem5;
    public static JMenuItem jMenuItem6;
    public static JMenuItem jMenuItem7;
    public static JMenuItem jMenuItem8;
    public static JMenuItem jMenuItem9;
    public static JPanel jPanel1;
    public static JPopupMenu jPopupMenu1;
    public static JScrollPane jScrollPane1;
    public static JScrollPane jScrollPane2;
    public static JScrollPane jScrollPane3;
    public static JSeparator jSeparator1;
    public static JToolBar.Separator jSeparator10;
    public static JPopupMenu.Separator jSeparator11;
    public static JPopupMenu.Separator jSeparator2;
    public static JPopupMenu.Separator jSeparator3;
    public static JToolBar.Separator jSeparator4;
    public static JToolBar.Separator jSeparator5;
    public static JToolBar.Separator jSeparator6;
    public static JToolBar.Separator jSeparator7;
    public static JPopupMenu.Separator jSeparator8;
    public static JPopupMenu.Separator jSeparator9;
    public static JSplitPane jSplitPane1;
    public static JTabbedPane jTabbedPane2;
    protected static JTextField jTextField1;
    static UndoManager annuler = new UndoManager();
    public static JToolBar jToolBar1;
    public static Tree jTree1= new  Tree();
    public static Editeur jTextPane1;
    public static  final String Button_Paste = "Paste";
    public static  final String Button_Cut = "Cut";
    public static  final String Button_Copy = "Copy";
    Clisteners  l=new Clisteners(this);
    static JPopupMenu Edition_Popup_Menu;
    static JPopupMenu Tree_Popup_Menu;
    static JMenuItem Popup_Menu_Cut, Popup_Menu_Copy, Popup_Menu_Paste, Popup_Menu_SelectAll;
    static JMenuItem Popup_Menu_Creer, Popup_Menu_Supprimer, Popup_Menu_Renommer, Popup_Menu_Copier, Popup_Menu_Deplacer;

    public FenetrePrincipale(String title)  {
        setTitle(title);
        initComponents();
        jTextPane1=new Editeur();
        jTextPane1.addCaretListener(new Parseur(jTree1,jTextPane1));
        jScrollPane1.setViewportView(jTextPane1);
        jTabbedPane2.setTitleAt(0, "Nouveau document XML");
         jTextPane1.addMouseListener(
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
                         Edition_Popup_Menu.show(e.getComponent(), e.getX(), e.getY());
                      }
                   }
                }
             );
        
        //jTextPane1.getDocument().addDocumentListener(l);
        jTextPane1.getDocument().addUndoableEditListener(l);
         jTextPane1.addCaretListener(l);
        
        this.setVisible(true);
    }
    public void updatePopupOptions(){
	      if ( jTextPane1.getSelectedText() == null) {
	    	  Popup_Menu_Cut.setEnabled(false);
	    	  Popup_Menu_Copy.setEnabled(false);
	      }
	      else {
	    	  Popup_Menu_Cut.setEnabled(true);
	    	  Popup_Menu_Copy.setEnabled(true);
	      }
	   
        
    }
    private void initComponents() {

        jSeparator1 = new JSeparator();
        jMenuItem4 = new JMenuItem();
        jMenuItem10 = new JMenuItem();
        jPopupMenu1 = new JPopupMenu();
        jToolBar1 = new JToolBar();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jSeparator4 = new JToolBar.Separator();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jSeparator5 = new JToolBar.Separator();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jButton7 = new JButton();
        jSeparator6 = new JToolBar.Separator();
        buttonUndo = new JButton();
        buttonRedo = new JButton();
        jSeparator7 = new JToolBar.Separator();
        btnRechercher = new JButton();
        jSeparator10 = new JToolBar.Separator();
        jPanel1 = new JPanel();
        jSplitPane1 = new JSplitPane();
        jTabbedPane2 = new JTabbedPane();
        jScrollPane1 = new JScrollPane();
        jScrollPane3 = new JScrollPane();
        jScrollPane2 = new JScrollPane();
        jTextField1 = new JTextField();
        jMenuBar1 = new JMenuBar();
        
        jMenu1 = new JMenu();
        jMenuItem1 = new JMenuItem();
        jMenuItem2 = new JMenuItem();
        jSeparator3 = new JPopupMenu.Separator();
        jMenuItem3 = new JMenuItem();
        jMenuItem5 = new JMenuItem();
        jSeparator2 = new JPopupMenu.Separator();
        jMenuItem6 = new JMenuItem();
        jMenu2 = new JMenu();
        jMenuItem7 = new JMenuItem();
        jMenuItem8 = new JMenuItem();
        jSeparator8 = new JPopupMenu.Separator();
        jMenuItem9 = new JMenuItem();
        jMenuItem11 = new JMenuItem();
        jMenuItem12 = new JMenuItem();
        jSeparator9 = new JPopupMenu.Separator();
        jMenuItem15 = new JMenuItem();
        jSeparator11 = new JPopupMenu.Separator();
        jMenuItem16 = new JMenuItem();
        jMenuItem13 = new JMenuItem();
        jMenu4 = new JMenu();
        jMenuItem14 = new JMenuItem();

        jMenuItem4.setText("jMenuItem4");

        jMenuItem10.setText("jMenuItem10");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        jButton1.setIcon(new ImageIcon(getClass().getResource("/icones/new.png")));
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(l);
        jToolBar1.add(jButton1);

        jButton2.setIcon(new ImageIcon(getClass().getResource("/icones/open.png")));
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(l);
        jToolBar1.add(jButton2);
        jToolBar1.add(jSeparator4);

        jButton3.setIcon(new ImageIcon(getClass().getResource("/icones/save.png"))); 
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(l);
        jToolBar1.add(jButton3);

        jButton4.setIcon(new ImageIcon(getClass().getResource("/icones/saveas.png"))); 
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);
        jButton4.addActionListener(l);
        jToolBar1.add(jSeparator5);

        jButton5.setIcon(new ImageIcon(getClass().getResource("/icones/couper.png")));
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(l);
        jToolBar1.add(jButton5);

        jButton6.setIcon(new ImageIcon(getClass().getResource("/icones/copier.png"))); 
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(l);
        jToolBar1.add(jButton6);

        jButton7.setIcon(new ImageIcon(getClass().getResource("/icones/paste.png"))); 
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(SwingConstants.BOTTOM);
        jButton7.addActionListener(l);
        jToolBar1.add(jButton7);
        jToolBar1.add(jSeparator6);

        buttonUndo.setIcon(new ImageIcon(getClass().getResource("/icones/undo.png"))); 
        buttonUndo.setFocusable(false);
        buttonUndo.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonUndo.setVerticalTextPosition(SwingConstants.BOTTOM);
        buttonUndo.addActionListener(l);
        jToolBar1.add(buttonUndo);

        buttonRedo.setIcon(new ImageIcon(getClass().getResource("/icones/redo.png"))); 
        buttonRedo.setFocusable(false);
        buttonRedo.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonRedo.setVerticalTextPosition(SwingConstants.BOTTOM);
        buttonRedo.addActionListener(l);
        jToolBar1.add(buttonRedo);
        jToolBar1.add(jSeparator7);

        btnRechercher.setIcon(new ImageIcon(getClass().getResource("/icones/find.png"))); 
        btnRechercher.setFocusable(false);
        btnRechercher.setHorizontalTextPosition(SwingConstants.CENTER);
        btnRechercher.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnRechercher.addActionListener(l);
        jToolBar1.add(btnRechercher);
        jToolBar1.add(jSeparator10);

        jTabbedPane2.setToolTipText("");
        jTabbedPane2.addTab("tab1", jScrollPane1);

        jSplitPane1.setRightComponent(jTabbedPane2);
        jSplitPane1.setLeftComponent(jScrollPane3);

       
        jScrollPane2.setViewportView(jTree1);

        jSplitPane1.setLeftComponent(jScrollPane2);
        // Popup_Menu jtextPane//
	Edition_Popup_Menu = new JPopupMenu();
        Popup_Menu_Cut = new JMenuItem("Couper");
	Popup_Menu_Cut.setMnemonic('C');
        Popup_Menu_Cut.setName(Button_Cut);
	Popup_Menu_Cut.addActionListener(l);
	Edition_Popup_Menu.add(Popup_Menu_Cut); 
	Popup_Menu_Copy = new JMenuItem("Copier");
	Popup_Menu_Copy.setMnemonic('p');
        Popup_Menu_Cut.setName(Button_Copy);
	Popup_Menu_Copy.addActionListener(l);
        Edition_Popup_Menu.add(Popup_Menu_Copy);
        Popup_Menu_Paste = new JMenuItem("Coller");
	Popup_Menu_Paste.setMnemonic('o');
        Popup_Menu_Cut.setName(Button_Paste);
	Popup_Menu_Paste.addActionListener(l);
	Edition_Popup_Menu.add(Popup_Menu_Paste);
	Edition_Popup_Menu.addSeparator();
	Popup_Menu_SelectAll = new JMenuItem("Selectionner tout");
	Popup_Menu_SelectAll.setMnemonic('t');
	Popup_Menu_SelectAll.addActionListener(new ActionListener(){@Override
	public void actionPerformed(ActionEvent e){
          jTextPane1.selectAll();}});
	  Edition_Popup_Menu.add(Popup_Menu_SelectAll);
          
          
          
        javax.swing.GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1,GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1,GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
        );
        jMenu1.setText("Fichier");
        jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new ImageIcon(getClass().getResource("/icones/new.png"))); 
        jMenuItem1.setText("Nouveau");
        jMenuItem1.addActionListener(l);
        jMenu1.add(jMenuItem1);
        jMenuItem2.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new ImageIcon(getClass().getResource("/icones/open.png"))); 
        jMenuItem2.setText("Ouvrir");
         jMenuItem12.addActionListener(l);
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator3);
        jMenuItem3.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new ImageIcon(getClass().getResource("/icones/save.png"))); 
        jMenuItem3.setText("Enregistrer");   
         jMenuItem3.addActionListener(l);
        jMenu1.add(jMenuItem3);
        jMenuItem5.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, InputEvent.CTRL_MASK));
        jMenuItem5.setIcon(new ImageIcon(getClass().getResource("/icones/saveas.png"))); 
        jMenuItem5.setText("Enregistrer sous");     
         jMenuItem5.addActionListener(l);
        jMenu1.add(jMenuItem5);
        jMenu1.add(jSeparator2);
        jMenuItem6.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, InputEvent.ALT_MASK));
        jMenuItem6.setIcon(new ImageIcon(getClass().getResource("/icones/logout.png"))); 
        jMenuItem6.setText("Quitter");
         jMenuItem6.addActionListener(l);
        jMenu1.add(jMenuItem6);
        jMenuBar1.add(jMenu1);
        jMenu2.setText("Edition");
        jMenuItem7.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, InputEvent.CTRL_MASK));
        jMenuItem7.setIcon(new ImageIcon(getClass().getResource("/icones/undo.png"))); 
        jMenuItem7.setText("Undo");
         jMenuItem7.addActionListener(l);
        jMenu2.add(jMenuItem7);
        jMenuItem8.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, InputEvent.CTRL_MASK));
        jMenuItem8.setIcon(new ImageIcon(getClass().getResource("/icones/redo.png"))); 
        jMenuItem8.setText("Redo");
         jMenuItem8.addActionListener(l);
        jMenu2.add(jMenuItem8);
        jMenu2.add(jSeparator8);
        jMenuItem9.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X,InputEvent.CTRL_MASK));
        jMenuItem9.setIcon(new ImageIcon(getClass().getResource("/icones/couper.png")));
        jMenuItem9.setText("Couper");  
         jMenuItem9.addActionListener(l);
        jMenu2.add(jMenuItem9);
        jMenuItem11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        jMenuItem11.setIcon(new ImageIcon(getClass().getResource("/icones/copier.png"))); 
        jMenuItem11.setText("Copier");   
         jMenuItem11.addActionListener(l);
        jMenu2.add(jMenuItem11);
        jMenuItem12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem12.setIcon(new ImageIcon(getClass().getResource("/icones/paste.png"))); 
        jMenuItem12.setText("Coller");    
         jMenuItem12.addActionListener(l);
        jMenu2.add(jMenuItem12);
        jMenu2.add(jSeparator9);
        jMenuItem15.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
        jMenuItem15.setIcon(new ImageIcon(getClass().getResource("/icones/find.png")));
        jMenuItem15.setText("Rechercher");   
         jMenuItem15.addActionListener(l);
        jMenu2.add(jMenuItem15);
        jMenu2.add(jSeparator11);
        jMenuItem16.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
        jMenuItem16.setIcon(new ImageIcon(getClass().getResource("/icones/select_all.png")));
        jMenuItem16.setText("Sélectionner tout");      
         jMenuItem16.addActionListener(l);
        jMenu2.add(jMenuItem16);
        jMenuBar1.add(jMenu2);
        jMenuItem13.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem13.setIcon(new ImageIcon(getClass().getResource("/icones/option.png"))); 
        jMenuItem13.setText("Option");
         jMenuItem13.addActionListener(l);
        jMenu4.setText("?");
        jMenuItem14.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.ALT_MASK));
        jMenuItem14.setIcon(new ImageIcon(getClass().getResource("/icones/info.png"))); 
        jMenuItem14.setText("A propos");
         jMenuItem14.addActionListener(l);
        jMenu4.add(jMenuItem14);
        jMenuBar1.add(jMenu4);
        setJMenuBar(jMenuBar1);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1,GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
            .addComponent(jTextField1)
            .addComponent(jPanel1, GroupLayout.Alignment.TRAILING,GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1,GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
        );
        pack();
    }    
}
