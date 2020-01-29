import javax.swing.*;
import java.awt.*;

public class DrawAppGeneral extends JPanel {

    private static GeneralTree<Integer> tree;


    public DrawAppGeneral(GeneralTree tree){
        this.tree = tree;
    }

    public void paintComponent(Graphics g){
        //draw tree here
        layout(tree, tree.root(), 1, 1);
        for(Position<Integer> pos : tree.breadthFirst()){
            if(tree.isInternal(pos)){
                g.setColor(Color.BLUE);
                g.drawOval(pos.getX()*20, pos.getY()*50, 20, 20);
                g.fillOval(pos.getX()*20, pos.getY()*50, 19, 19);
                g.drawString(String.valueOf(pos.getElement()), pos.getX()*20, pos.getY()*50);

                //tried drawing lines between them. Got it but it looks terrible. :)
                if(pos != tree.root()) {
                    g.drawLine(tree.parent(pos).getX()*20, tree.parent(pos).getY()*50, pos.getX() * 20, pos.getY() * 50);
                }
            }
            else{
                g.setColor(Color.RED);
                g.drawRect((pos.getX()*20), pos.getY()*50, 19, 19);
                g.fillRect((pos.getX()*20), pos.getY()*50, 19, 19);
                g.drawString(String.valueOf(pos.getElement()), pos.getX()*20, pos.getY()*50);

                //same as above!
                if(pos != tree.root()) {
                    g.drawLine(tree.parent(pos).getX()*20, tree.parent(pos).getY()*50, pos.getX() * 20, pos.getY() * 50);
                }
            }
        }
    }


    public <E extends Position> int layout(GeneralTree<Integer> T, Position<Integer> p, int depth, int x){
        if(T.children(p) != null){
            for (Position<Integer> child : T.children(p)) {
                x = layout(T, child, depth+1, x);
            }
        }
        p.setX(x++);
        p.setY(depth);
        return x;
    }
}
