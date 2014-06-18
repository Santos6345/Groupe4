
package projet;

import javax.swing.tree.DefaultMutableTreeNode;

import org.w3c.dom.Node;

/**
 *
 * @author jawher
 */
@SuppressWarnings({ "serial", "unused" })
public class Noeud extends DefaultMutableTreeNode{

	private int type;
	private int position;
  
    public Noeud(String nom){
		super(nom);
		type=0;
		position=-1;
    }
    public Noeud(String nom,int type,int position){
		super(nom);
		this.type=type;
		this.position=position;
	}
    public int getType(){
		return type;
    }
    public int getPosition(){
		return position;
	}
    
    
}
