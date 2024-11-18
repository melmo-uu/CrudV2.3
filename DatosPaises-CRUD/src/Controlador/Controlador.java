package Controlador;

import Modelo.Ciudad;
import Modelo.Conexion;
import Modelo.Idioma;
import Modelo.Pais;
import Vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener {

    Ventana vista = new Ventana();
    DefaultTableModel modelo = new DefaultTableModel();
    Pais p = new Pais();
    Ciudad c = new Ciudad();
    Idioma i = new Idioma();
    PaisOperaciones paisOp = new PaisOperaciones();
    CiudadOperaciones CiuOp = new CiudadOperaciones();
    IdiomaOperaciones IdioOP = new IdiomaOperaciones();
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    

    public Controlador(Ventana v) {
        this.vista = v;
        //Btnes Pais
        this.vista.btnConsultar.addActionListener(this);
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        //Btnes Ciudad
        this.vista.btnAgregarC.addActionListener(this);
        this.vista.btnConsultarC.addActionListener(this);
        this.vista.btnModificarC.addActionListener(this);
        this.vista.btnEliminarC.addActionListener(this);
        this.vista.btnGuardarC.addActionListener(this);
        this.vista.btnLimpiarC.addActionListener(this);
        //Btnes idioma
        this.vista.btnConsultarIdio.addActionListener(this);
        this.vista.btnAgregarIdio.addActionListener(this);
        this.vista.btnModificarIdio.addActionListener(this);
        this.vista.btnEliminarIdio.addActionListener(this);
        this.vista.btnGuardarIdio.addActionListener(this);
        this.vista.btnLimpiarIdio.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//Ventana Pais

        if (e.getSource() == vista.btnAgregar) {
            agregar();
            vista.mostrarDatos();
            
        }
        
        if (e.getSource() == vista.btnConsultar) {
            Consultar1();
            
            

        }
        
        if (e.getSource() == vista.btnModificar) {
            Modificar();
            vista.mostrarDatos();
           
        }
        
        if (e.getSource() == vista.btnGuardar) {
          
        }
        
        if (e.getSource() == vista.btnEliminar) {
            Eliminar();
            vista.mostrarDatos();
            
        }
        
        if (e.getSource() == vista.btnLimpiar) {
            limpiar();
            vista.mostrarDatos();
        }
//Ventana Ciudad
        if (e.getSource() == vista.btnAgregarC) {
            agregarC();
            vista.mostrarDatosC();
            limpiar();
            
            
            
        }
        if (e.getSource() == vista.btnConsultarC) {
            ConsultarC();
            
            

        }
        if (e.getSource() == vista.btnModificarC) {
            ModificarC();
            vista.mostrarDatosC();
            limpiar();
           
        }
        
        if (e.getSource() == vista.btnGuardarC) {
          
        }
        
        if (e.getSource() == vista.btnEliminarC) {
            EliminarC();
            vista.mostrarDatosC();
            
            
        }
        
        if (e.getSource() == vista.btnLimpiarC) {
            limpiarC();
        }
        

//Ventana Idioma
        if (e.getSource() == vista.btnAgregarIdio) {
            agregarI();
            vista.mostrarDatosIdio();
            limpiarIdio();
            
        }
        
        if (e.getSource() == vista.btnConsultarIdio) {
            ConsultarI();
            
            
            

        }
        
        if (e.getSource() == vista.btnModificarIdio) {
            ModificarI();
            vista.mostrarDatosIdio();
            limpiarIdio();
           
        }
        
        if (e.getSource() == vista.btnGuardarIdio) {
          
        }
        
        if (e.getSource() == vista.btnEliminarIdio) {
            EliminarI();
            vista.mostrarDatosIdio();
            limpiarIdio();
        }
        
        if (e.getSource() == vista.btnLimpiarIdio) {
            limpiarIdio();
        }


    }

    public void limpiar() {
        vista.txtNombrePais.setText("");
        vista.txtCodigoPais.setText("");
        vista.txtPoblacionPais.setText("");
        vista.txtContinentePais.setText("");
        vista.txtCodigoPais.requestFocus();
        vista.txtGob.setText("");
        
    }
    public void limpiarC() {
        vista.txtIDC.setText("");
        vista.txtNombreC.setText("");
        vista.txtPoblacionC.setText("");
        vista.txtCodigoPC.setText("");
        vista.txtNombreC.requestFocus();
    }
    public void limpiarIdio() {
        vista.txtIDIdio.setText("");
        vista.txtNombreIdio.setText("");
        vista.txtOficialdio.setText("");
        vista.txtCodigoPIdio.setText("");
        vista.txtNombreIdio.requestFocus();
    }
    public void limpiarcodigo()
    {
        vista.txtCodigoPais.setText("");
    }
    public void centrarCeldas(JTable tabla) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < vista.jTablePais.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }
    public void centrarCeldasC(JTable tabla) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < vista.JTableCiudad.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }
    public void centrarCeldasIdio(JTable tabla) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < vista.jTableIdioma.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }

    
   /*Codigo de la venntana Ciudad*/
    public void agregar() {
    try {
        String codigo = vista.txtCodigoPais.getText();
        String nombre = vista.txtNombrePais.getText();
        String continente = vista.txtContinentePais.getText();
        String poblacionText = vista.txtPoblacionPais.getText(); 
        String TipoGob = vista.txtGob.getText();
        
        int poblacion;
        int tipgob = 0;
        
            if (codigo.isEmpty() || nombre.isEmpty() || continente.isEmpty() || poblacionText.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "No dejes campos vacíos.");
                return;
            }
            try{
                tipgob = Integer.parseInt(TipoGob);
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(vista, "Ingrese un gobierno valido 0-1.");
            }
            try {  
                poblacion = Integer.parseInt(poblacionText); 
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vista, "Ingrese un numero valido.");
                return;
            }

        p.setCodigo(codigo);
        p.setNombre(nombre);
        p.setContinente(continente);
        p.setPoblacion(poblacion);
        p.setTipoGobierno(tipgob);
 
        int r = paisOp.agregar(p);
        
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "País agregado con éxito.");
            limpiar();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al agregar el país.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(vista, "Ocurrió un error inesperado: " + e.getMessage());
        
    }
}
    public void Consultar1() {
            String nombre = vista.txtNombrePais.getText();
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Por favor ingrese un nombre de país.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            List<Pais> paises = paisOp.Consultar(nombre);
            DefaultTableModel model = (DefaultTableModel) vista.jTablePais.getModel();
            model.setRowCount(0);
                    
             if (paises.isEmpty()) {
                
            } else {
                for (Pais pais : paises){
                    Object[] row = new Object[5];
                    row[0] = pais.getCodigo();
                    row[1] = pais.getNombre();
                    row[2] = pais.getContinente();
                    row[3] = pais.getPoblacion();
                    row[4] = pais.getTipoGobierno();
                    
                    model.addRow(row);
                }
            }
    }
    
    public void Modificar(){
        String codigo = vista.txtCodigoPais.getText();
        String nombre = vista.txtNombrePais.getText();
        String continente = vista.txtContinentePais.getText();
        String poblacionStr = vista.txtPoblacionPais.getText();
        String TipoGob = vista.txtGob.getText();

            if (codigo.isEmpty() || nombre.isEmpty() || continente.isEmpty() || poblacionStr.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Todos los campos deben ser llenados.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int poblacion;
            int tipgob = 0;
            try{
                tipgob = Integer.parseInt(TipoGob);
            }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(vista, "Ingrese un gobierno valido.", "ERROR", JOptionPane.ERROR_MESSAGE);

            }
            try {
                poblacion = Integer.parseInt(poblacionStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(vista, "La población debe ser un número válido.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        p.setCodigo(codigo);
        p.setNombre(nombre);
        p.setContinente(continente);
        p.setPoblacion(poblacion);
        p.setTipoGobierno(tipgob);
        
        int r = paisOp.modificar(p);
            if (r == 1) {
                JOptionPane.showMessageDialog(vista, "País modificado con éxito.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al modificar el país.");
            }
            
    }

    void limpiarTabla() {
        for (int i = 0; i < vista.jTablePais.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }   
    public void Eliminar(){
        try{
            String codigo = vista.txtCodigoPais.getText();
            Pais p = new Pais();
            
            if(codigo.isEmpty()){
                JOptionPane.showMessageDialog(vista, "Ingrese un codigo.","ERROR", JOptionPane.ERROR_MESSAGE);  
            }
            else
            {
                int r = paisOp.eliminar(codigo);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "País eliminado con éxito.");
            limpiar();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al agregar el país.");
        }
            }

        }catch(Exception e){
                JOptionPane.showMessageDialog(vista, "Error: " +e );
        }
    }
    
    /*Codigo de la venntana Ciudad*/
    public void agregarC() {
    try {
        
        String nombreC = vista.txtNombreC.getText();
        String codigoPC = vista.txtCodigoPC.getText();
        String poblacionC = vista.txtPoblacionC.getText();
        int poblacion;
        
        if (codigoPC.isEmpty() || nombreC.isEmpty() ) {
            JOptionPane.showMessageDialog(vista, "No dejes campos vacíos.");
            return;
        }

        try {  
            poblacion = Integer.parseInt(poblacionC); 
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Ingrese un numero valido.");
            return;
        }

        c.setNombreC(nombreC);
        c.setPoblacionC(poblacion);
        c.setCodigoC(codigoPC);
 
        Ciudad ciudad = new Ciudad(poblacion, nombreC, poblacion, codigoPC);
        int r = CiuOp.agregarC(ciudad);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Ciudad agregada con éxito.");
            limpiar();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al agregar la ciudad.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(vista, "Ocurrió un error inesperado: " + e.getMessage());
        
    }
}
    
    public void ModificarC() {
    try {
        String id = vista.txtIDC.getText();
        String nombreC = vista.txtNombreC.getText();
        String codigoPC = vista.txtCodigoPC.getText();
        String poblacionC = vista.txtPoblacionC.getText();
        int poblacion;
        int idc;
        if (codigoPC.isEmpty() || nombreC.isEmpty() ) {
            JOptionPane.showMessageDialog(vista, "No dejes campos vacíos.");
            return;
        }

        try {  
            poblacion = Integer.parseInt(poblacionC); 
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Ingrese un numero valido.");
            return;
        }
        try {  
            idc = Integer.parseInt(id); 
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Ingrese un numero valido.");
            return;
        }
        
        c.setIDC(idc);
        c.setNombreC(nombreC);
        c.setPoblacionC(poblacion);
        c.setCodigoC(codigoPC);
 
        Ciudad ciudad = new Ciudad(idc, nombreC, poblacion, codigoPC);
        int r = CiuOp.modificarC(ciudad);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Ciudad modificada con éxito.");
            limpiar();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al modificar la ciudad.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(vista, "Ocurrió un error inesperado: " + e.getMessage());
        
    }
}
    public void EliminarC(){
        try{
            String Nombre = vista.txtNombreC.getText();
            Pais p = new Pais();
            
            if(Nombre.isEmpty()){
                JOptionPane.showMessageDialog(vista, "Ingrese un nombre","ERROR", JOptionPane.ERROR_MESSAGE);  
            }
            else
            {
        
        int r = CiuOp.eliminarC(Nombre);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Ciudad eliminada con éxito.");
            limpiar();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al agregar la ciudad.");
        }
            }

        }catch(Exception e){
                JOptionPane.showMessageDialog(vista, "Error: " +e );
        }
    }
    public void ConsultarC() {
        
         String nombre = vista.txtNombreC.getText();
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Por favor ingrese el nombre de la ciudad.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            List<Ciudad> ciudades = CiuOp.ConsultarC(nombre);
            DefaultTableModel modelC = (DefaultTableModel) vista.JTableCiudad.getModel();
            modelC.setRowCount(0);
                    
             if (ciudades.isEmpty()) {
                
                 
            } else {
                for (Ciudad ciudad : ciudades){
                    Object[] row = new Object[4];
                    row[0] = ciudad.getIDC();
                    row[1] = ciudad.getNombreC();
                    row[2] = ciudad.getPoblacionC();
                    row[3] = ciudad.getCodigoC();
                    
                    modelC.addRow(row);
                }
            }
    }
    
    /*Codigo de la venntana Idioma*/
     
    public void agregarI() {
    try { 
        String nombreidio = vista.txtNombreIdio.getText();
        String oficial = vista.txtOficialdio.getText();
        String codigoidio = vista.txtCodigoPIdio.getText();
        int oficialidio = 0;
        
        if (codigoidio.isEmpty() || nombreidio.isEmpty() ) {
            JOptionPane.showMessageDialog(vista, "No dejes campos vacíos.");
            return;
        }

        try {  
            oficialidio = Integer.parseInt(oficial); 
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Ingrese un numero valido.");
            return;
        }

        i.setNombre(nombreidio);
        i.setOficial(oficialidio);
        i.setCodigoP(codigoidio);
        
        int r = IdioOP.agregarIdioma(i);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Idioma agregado con éxito.");
            
        } else {
            JOptionPane.showMessageDialog(vista, "Error al agregar el idioma.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(vista, "Ocurrió un error inesperado: " + e.getMessage());
        
    }
}
    public void ModificarI() {
    try {
        String idIdio = vista.txtIDIdio.getText();
        String nombreIdio = vista.txtNombreIdio.getText();
        String oficial = vista.txtOficialdio.getText();
        String codigoIdio = vista.txtCodigoPIdio.getText();
        int oficialIdio = 0;

        if (idIdio.isEmpty() || codigoIdio.isEmpty() || nombreIdio.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "No dejes campos vacíos.");
            return;
        }
        try {
            oficialIdio = Integer.parseInt(oficial);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Ingrese un número válido.");
            return;
        }

        i.setIdIdio(Integer.parseInt(idIdio)); 
        i.setNombre(nombreIdio);
        i.setOficial(oficialIdio);
        i.setCodigoP(codigoIdio);

        int r = IdioOP.modificarIdioma(i);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Idioma modificado con éxito.");
            limpiarIdio(); 
        } else {
            JOptionPane.showMessageDialog(vista, "Error al modificar el idioma.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(vista, "Ocurrió un error inesperado: " + e.getMessage());
    }
}

    public void EliminarI(){
        try{
            String Nombre = vista.txtNombreIdio.getText();

            if(Nombre.isEmpty()){
                JOptionPane.showMessageDialog(vista, "Ingrese un nombre","ERROR", JOptionPane.ERROR_MESSAGE);  
            }
            else
            {
        
        int r = IdioOP.eliminarIdioma(Nombre);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Idioma eliminado con éxito.");
            
        } else {
            JOptionPane.showMessageDialog(vista, "Error al eliminar el idioma.");
        }
            }

        }catch(Exception e){
                JOptionPane.showMessageDialog(vista, "Error: " +e );
        }
    }
    
    public void ConsultarI() {
        String nombre = vista.txtNombreIdio.getText();
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Por favor ingrese el nombre del idioma.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            List<Idioma> idiomas = IdioOP.ConsultarIdioma(nombre);
            DefaultTableModel modelC = (DefaultTableModel) vista.jTableIdioma.getModel();
            modelC.setRowCount(0);
                    
             if (idiomas.isEmpty()) {
                
            } else {
                for (Idioma idioma : idiomas){
                    Object[] row = new Object[4];
                    row[0] = idioma.getIdIdio();
                    row[1] = idioma.getNombre();
                    row[2] = idioma.getOficial();
                    row[3] = idioma.getCodigoP();
                    
                    modelC.addRow(row);
                }
            }
    }
}   
    
        
        

    