/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naves_es;
import Controlador.CtrlRegistrar;
import Modelo.Consultar_Nave;
import Modelo.Registrar_Nave;
import Vista.frmRegistrar_Naves;

/**
 *
 * @author USER
 */
public class Naves_Es {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Registrar_Nave mod = new Registrar_Nave();
        Consultar_Nave modc= new Consultar_Nave();
        frmRegistrar_Naves frm = new frmRegistrar_Naves();
        
        CtrlRegistrar ctrl= new CtrlRegistrar(mod, modc, frm);
        ctrl.Iniciar();
        frm.setVisible(true);
        
        
        
        
       
        
    }
    
}
