package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import modelo.modelo;
import vista.vista;

public class controlador implements ActionListener{
    private vista view;
    private modelo model;
    modelo drawArea;
    String seleccion = "Cuadrado";
    String rellenado = "No";
    
    public controlador(vista view, modelo model){
        this.view = view;
        this.model = model;
        this.view.combo.addActionListener(this);
    }

    public void iniciar(modelo drawArea) {
        if(drawArea == null){
            drawArea = new modelo(seleccion, rellenado);
        }
        view.show(drawArea);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       view.combo.addItemListener(
            new ItemListener(){
                public void itemStateChanged( ItemEvent evento )
                {
                     if ( evento.getStateChange() == ItemEvent.SELECTED ){
                         //seleccion = view.combo.getSelectedItem().toString();
                         seleccion = "Linea";
                         modelo drawArea = new modelo(seleccion, rellenado);
                         iniciar(drawArea);
                     }
                }
            }
        );
    }
}