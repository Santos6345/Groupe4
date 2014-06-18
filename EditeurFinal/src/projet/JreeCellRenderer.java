
package projet;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.tree.DefaultTreeCellRenderer;


@SuppressWarnings({ "serial", "unused" })
public class JreeCellRenderer extends DefaultTreeCellRenderer {
    private ImageIcon ICON_XML = new ImageIcon((ClassLoader.getSystemResource("icones/xml.png")));
    private ImageIcon ICON_XML3 = new ImageIcon((ClassLoader.getSystemResource("icones/xml3.png")));
    private ImageIcon ICON_ATTRIBUT = new ImageIcon((ClassLoader.getSystemResource("icones/xml2.png")));
    private SimpleAttributeSet carac=new SimpleAttributeSet();
    @Override
    public Component getTreeCellRendererComponent(JTree jTree1, Object value, boolean isSelected, boolean expanded,boolean leaf, int row, boolean hasFocus)
    {
        
		super.getTreeCellRendererComponent(jTree1,value,isSelected, expanded, leaf, row, hasFocus);
                
                    //attribut
                     if (((Noeud)value).getType()==1){
                         
                          this.setIcon(ICON_ATTRIBUT);
                          this.setForeground(Color.blue);
                    }
                    //element
                    else if (((Noeud)value).getType()==2){
                         
                          this.setIcon(ICON_XML);
                          this.setForeground(Color.black);
			
                    }
                    //texte
                    else if (((Noeud)value).getType()==3){
                       
                        this.setIcon(ICON_XML3);
			this.setForeground(Color.GREEN.darker());
                    }
		return this;
	}
}

             

