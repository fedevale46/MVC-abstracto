/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.Serializable;
import java.util.List;
import modelo.Model;
import vista.View;


/**
 *
 * @author Norberto Díaz-Díaz
 */
public interface Controller <M extends Model, V extends View, D extends Serializable >{
    //Metodo para enlazar la vista y el modelo
    void setup(M model, List<V> view);
    //Metodo para lanzar la aplicación MVC
    void start();

    void addView(V view);
    void removeView(V view);

    M getModel();
    void setModel(M model);

    //Métodos a los que la vista llamará. Por ahora permitimos crear nuevos contactos
    void nuevaEntidadGesture(List<D> datos);
    void borraEntidadGesture(D pk);
    void actualizaEntidadGesture(List<D> datos);

    //Métodos que el modelo puede llamar
    void fireDataModelChanged();

}
