package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.*;
import java.util.ArrayList;
import javax.swing.JComponent;

public class modelo extends JComponent{
    private Point inicioArrastre;
    private Point finArrastre;
    String rellenar;
    
    private ArrayList<Shape> rectangulos = new ArrayList<Shape>();
    private ArrayList<Shape> elipses = new ArrayList<Shape>();
    private ArrayList<Shape> poligonos = new ArrayList<Shape>();
    private ArrayList<Shape> lineas = new ArrayList<Shape>();
    
    public modelo(String seleccion,String rellenado) {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) { // cuando se presiona el mouse
                inicioArrastre = new Point(e.getX(), e.getY());
                finArrastre = inicioArrastre;
                repaint();
            }
            
            public void mouseReleased(MouseEvent e) { // cuando se deja de presionar el mouse
            switch(seleccion){
                    case "":
                        break;
                    case "Cuadrado":
                        Shape rectangulo = crearRectangulo(inicioArrastre.x, inicioArrastre.y, e.getX(), e.getY());
                        rectangulos.add(rectangulo);
                        break;
                    case "Elipse":
                        Shape elipse = crearElipse(inicioArrastre.x, inicioArrastre.y, e.getX(), e.getY());
                        elipses.add(elipse);
                        break;
                    case "Linea":
                        Shape linea = crearLinea(inicioArrastre.x, inicioArrastre.y, e.getX(), e.getY());
                        lineas.add(linea);
                        break;
            }
            inicioArrastre = null;
            finArrastre = null;
            repaint();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseDragged(MouseEvent e) { // cuando se esta arrastrando el mouse
                finArrastre = new Point(e.getX(), e.getY());
                repaint();
            }
        });
    }
    
    

    public void paint(Graphics g, String seleccion, String relleno) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
            for (Shape rectangulo : rectangulos) { // dibuja todos los rectangulos
               if(1==1){
                   g2.fill(rectangulo);
               }
            }
            if (inicioArrastre != null && finArrastre != null) { // se esta arrastrando el raton?
                Shape rectangulo = crearRectangulo(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y);
                g2.draw(rectangulo);
            }
    }
    
    public void paint2(Graphics g, String seleccion, String relleno) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
            for (Shape elipse : elipses) { // dibuja todos los rectangulos
                if(1==1){
                    g2.fill(elipse);
                }
            }
            if (inicioArrastre != null && finArrastre != null) { // se esta arrastrando el raton?
                Shape elipse = crearElipse(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y);
                g2.draw(elipse);
            }
    }

    private Rectangle2D.Float crearRectangulo(int x1, int y1, int x2, int y2) {
        return new Rectangle2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
    }
    
    private Ellipse2D.Float crearElipse(int x1, int y1, int x2, int y2) {
        return new Ellipse2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
    }
    
    private Line2D.Float crearLinea(int x1, int y1, int x2, int y2) {
        return new Line2D.Float(x1, y1, x2, y2);
    }
    
    public void clear(Graphics g){
     Graphics2D g2 = (Graphics2D) g;
     g2.setPaint(Color.WHITE);
     g2.fillRect(0, 0, getSize().width, getSize().height);
     g2.setPaint(Color.black);
     repaint();
    }
}
