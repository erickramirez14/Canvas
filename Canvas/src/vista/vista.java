package vista;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modelo.modelo;


public class vista extends JFrame{
    public JPanel panel;
    public JLabel label;
    public JComboBox combo = new JComboBox();
    public JButton clear;
    public  JCheckBox rellenoJCheckBox; 
    public JCheckBox  sinrellenoJCheckBox; 
    
    public void show(modelo modelo){
     modelo drawArea = modelo;
     JFrame frame = new JFrame("Dibujo");
     Container content = frame.getContentPane();
     content.setLayout(new BorderLayout());
                
     content.add(drawArea, BorderLayout.CENTER);
     JPanel controls = new JPanel();
     
     label = new JLabel("Escoja la figura");
     controls.add(label);
     controls.setLayout(new FlowLayout());
     
     combo.addItem("");
     combo.addItem("Cuadrado");
     combo.addItem("Linea");
     combo.addItem("Circulo");
     controls.add(combo);

     rellenoJCheckBox = new JCheckBox("Rellenado");
     controls.add(rellenoJCheckBox);
     
     clear = new JButton("Limpiar");
     controls.add(clear);
     
     content.add(controls,BorderLayout.NORTH);
     frame.setSize(800,800);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setVisible(true);
    }
}
