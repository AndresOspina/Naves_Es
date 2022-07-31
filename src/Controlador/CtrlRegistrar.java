/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Consultar_Nave;
import Modelo.Registrar_Nave;
import Vista.frmRegistrar_Naves;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author USER
 */
public class CtrlRegistrar implements ActionListener {
     public Registrar_Nave mod;
    public Consultar_Nave modc;
    public frmRegistrar_Naves frm;
    
  
    public CtrlRegistrar(Registrar_Nave mod,Consultar_Nave modc,frmRegistrar_Naves frm){
        
        this.mod = mod;
        this.modc = modc;
        this.frm = frm;
        this.frm.btnguardar.addActionListener(this);
        this.frm.btnmodificar.addActionListener(this);
        this.frm.btneliminar.addActionListener(this);
        this.frm.btnlimpiar.addActionListener(this);
        this.frm.btnbuscar.addActionListener(this);
        
    } 
    
   public void Iniciar()
    {
        frm.setTitle("Registrar Nave");
        frm.setLocationRelativeTo(null);
        frm.txtid.setVisible(true);
    } 
    
          

   
    public void actionPerformed(ActionEvent ae) {
        
          if(ae.getSource()== frm.btnguardar){
            
      
            mod.setNombre(frm.txtnombre.getText());
        mod.setTamaño(frm.txttamaño.getText());
        mod.setSerial(Integer.parseInt(frm.txtserial.getText()));
        mod.setPais(frm.txtpais.getText());
       mod.setTipo(frm.txttipo.getText());
        
        if (modc.registrar(mod))
        {
            
              JOptionPane.showInputDialog(null, "Se ha guardado");
              limpiar (); 
        }else{
             JOptionPane.showInputDialog(null, "No se ha guardado");
             limpiar ();
        }
    }
          
          if(ae.getSource()== frm.btnmodificar){
            
                    mod.setNombre(frm.txtnombre.getText());
                    mod.setTamaño(frm.txttamaño.getText());
                    mod.setSerial(Integer.parseInt(frm.txtserial.getText()));
                    mod.setPais(frm.txtpais.getText());
                    mod.setTipo(frm.txttipo.getText());
                    
        if (modc.modificar(mod))
        {
            
              JOptionPane.showInputDialog(null, "Se ha modificado");
              limpiar ();
        }else{
             JOptionPane.showInputDialog(null, "No se ha modificado");
             limpiar ();
        }
    }
          
       if(ae.getSource()== frm.btneliminar){
            
       mod.setId(Integer.parseInt(frm.txtid.getText()));
         
        
        if (modc.Eliminar(mod))
        {
            
              JOptionPane.showInputDialog(null, "Se ha eliminado");
              limpiar ();
        }else{
             JOptionPane.showInputDialog(null, "No se ha eliminado");
             limpiar ();
        }
    }


          
          
        
       if (ae.getSource() == frm.btnbuscar) {

           mod.setSerial(Integer.parseInt(frm.txtserial.getText()));

            if (modc.Buscar(mod)) {
                
                
                frm.txtnombre.setText(mod.getNombre());
                frm.txttamaño.setText(mod.getTamaño());
                frm.txtserial.setText(String.valueOf(mod.getSerial()));
                frm.txtpais.setText(mod.getPais());
                frm.txttipo.setText(mod.getTipo());
                

               
            } else {
                JOptionPane.showInputDialog(null, "No se ha encontrado");
                limpiar();
            }
            
            
        }
       
                   if (ae.getSource() == frm.btnlimpiar) {
                limpiar();
            }
           
        
          }
    
    public void limpiar ()
    {
        frm.txtid.setText(null);
        frm.txtnombre.setText(null);
        frm.txttamaño.setText(null);
        frm.txtserial.setText(null);
        frm.txtpais.setText(null);
        frm.txttipo.setText(null);
    }

       
    
    }
            
    