package mvc;
import modelo.modelo;
import vista.vista;
import controlador.controlador;

public class mvc
  {
  public static void main( String args[] ){
    modelo mod = new modelo(null, null);
    vista view = new vista();
    controlador ctrl = new controlador(view, mod);
    ctrl.iniciar(null);
  }
}
