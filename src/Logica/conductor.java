/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juand
 */
public class conductor {
    static Connection con;
    static conexion cx;

    private long identificacion;
    private String nombre;
    private String apellido;
    private String genero;
    private String telefono;
    private String celular;
    private String fechaNacimiento;
    private String correo;
    private String numLicencia;
    private String categoriaLicencia;
    private String turno;
    private String ciudadResidencia;
    private String direccion;
    private String barrio;
    private String estadoCivil;
    private long codigoVehiculo;

    public long getId(){
        return identificacion;
    }

    public void setId(long identificacion){
        this.identificacion = identificacion;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public String getTelefono(){
        return telefono;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public String getCelular(){
        return celular;
    }

    public void setCelular(String celular){
        this.celular = celular;
    }

    public String getFecahaNacimiento(){
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo(){
        return correo;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public String getNumLicencia(){
        return numLicencia;
    }

    public void setNumLicencia(String numLicencia){
        this.numLicencia = numLicencia;
    }

    public String getCategoriaLicencia(){
        return categoriaLicencia;
    }

    public void setCategoriaLicencia(String categoriaLicencia){
        this.categoriaLicencia = categoriaLicencia;
    }

    public String getTurno(){
        return turno;
    }

    public void setTurno(String turno){
        this.turno = turno;
    }

    public String getCiudadResidencia(){
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia){
        this.ciudadResidencia = ciudadResidencia;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public String getBarrio(){
        return barrio;
    }

    public void setBarrio(String barrio){
        this.barrio = barrio;
    }

    public String getEstadoCivil(){
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil){
        this.estadoCivil = estadoCivil;
    }

    public long getCodigoVehiculo(){
        return codigoVehiculo;
    }

    public void setCodigoVehiculo(long codigoVehiculo){
        this.codigoVehiculo = codigoVehiculo;
    }

    public boolean guardarConductor(){
        try {
            cx = new conexion();
            con = cx.getConexion();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO conductor(identificacion, nombres, apellidos, genero, telefono, celular, fechaNacimiento, correo, numLicencia, categoriaLicencia, turno, ciudadResidencia, direccion, barrio, estadoCivil, codigoVehiculo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            stmt.setString(1,"" + this.identificacion);
            stmt.setString(2,this.nombre);
            stmt.setString(3,this.apellido);
            stmt.setString(4,this.genero);
            stmt.setString(5,this.telefono);
            stmt.setString(6,this.celular);
            stmt.setString(7,this.fechaNacimiento);
            stmt.setString(8,this.correo);
            stmt.setString(9,this.numLicencia);
            stmt.setString(10,this.categoriaLicencia);
            stmt.setString(11,this.turno);
            stmt.setString(12,this.ciudadResidencia);
            stmt.setString(13,this.direccion);
            stmt.setString(14,this.barrio);
            stmt.setString(15,this.estadoCivil);
            stmt.setString(16,"" + this.codigoVehiculo);

            stmt.executeUpdate();
            stmt = con.prepareStatement("UPDATE vehiculo SET estadoAsignacion = 'Asignado' WHERE codigoVehiculo = '" + this.codigoVehiculo +"'");
            stmt.executeUpdate();
            stmt.close();
            con.close();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean actualizarConductor(){
        try {
            cx = new conexion();
            con = cx.getConexion();

            PreparedStatement stmt = con.prepareStatement("UPDATE conductor SET nombres = '" + this.nombre + "', apellidos = '"+ this.apellido + "',genero='"+ this.genero + "',telefono='"+ this.telefono + "',celular='"+ this.celular + "',fechaNacimiento='"+ this.fechaNacimiento + "',correo='"+ this.correo + "',numLicencia='"+ this.numLicencia + "',categoriaLicencia='"+ this.categoriaLicencia + "',turno='"+ this.turno + "',ciudadResidencia='"+ this.ciudadResidencia + "',direccion='"+ this.direccion + "',barrio='"+ this.barrio + "',estadoCivil='"+ this.estadoCivil + "',codigoVehiculo='"+ this.codigoVehiculo + "' WHERE (identificacion = " + this.identificacion + ")");
            stmt.executeUpdate();
            stmt.close();
            con.close();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean consultarConductorId(long idBuscar){
        try {
            boolean consultaOk = false;
            cx = new conexion();
            con = cx.getConexion();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM conductor where identificacion = " + idBuscar);

            if (rs.next() == true) {
                this.identificacion = Long.parseLong(rs.getString("identificacion"));
                this.nombre=rs.getString("nombres");
                this.apellido=rs.getString("apellidos");
                this.genero= rs.getString("genero");
                this.telefono=rs.getString("telefono");
                this.celular=rs.getString("celular");
                this.fechaNacimiento=rs.getString("fechaNacimiento");
                this.correo=rs.getString("correo");
                this.numLicencia=rs.getString("numLicencia");
                this.categoriaLicencia=rs.getString("categoriaLicencia");
                this.turno=rs.getString("turno");
                this.ciudadResidencia=rs.getString("ciudadResidencia");
                this.direccion=rs.getString("direccion");
                this.barrio=rs.getString("barrio");
                this.estadoCivil=rs.getString("estadoCivil");
                this.codigoVehiculo=Long.parseLong(rs.getString("codigoVehiculo"));
                consultaOk = true;
            }else{
                consultaOk = false;
            }

            stmt.close();
            con.close();

            return consultaOk;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean eliminarConductor(long idBuscar){
        try {
            cx = new conexion();
            con = cx.getConexion();
            PreparedStatement stmt = con.prepareStatement("DELETE FROM conductor WHERE (identificacion = " + idBuscar + ")");

            stmt.executeUpdate();
            stmt.close();
            con.close();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public DefaultTableModel consultarConductor(){
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            cx = new conexion();
            con = cx.getConexion();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM conductor");
            
            modelo.addColumn("Identificacion");
            modelo.addColumn("Nombres");
            modelo.addColumn("Apellidos");
            modelo.addColumn("Genero");
            modelo.addColumn("Telefono");
            modelo.addColumn("celular");
            modelo.addColumn("FechaNacimiento");
            modelo.addColumn("Correo");
            modelo.addColumn("NumLicencia");
            modelo.addColumn("CategoriaLicencia");
            modelo.addColumn("Turno");
            modelo.addColumn("CiudadResidencia");
            modelo.addColumn("Direccion");
            modelo.addColumn("Barrio");
            modelo.addColumn("EstadoCivil");
            modelo.addColumn("CodigoVehiculo");
            int numColumnas = 16;
            
            while (rs.next()) {                
                Object[] fila = new Object[numColumnas];
                
                for (int i = 0; i < numColumnas; i++) {
                    fila[i] = rs.getObject(i+1);
                }
                
                modelo.addRow(fila);
            }
            
            stmt.close();
            con.close();
            
            return  modelo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return modelo;
        }
    }
    
    public DefaultTableModel consultarIdConductor(int id){
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            cx = new conexion();
            con = cx.getConexion();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM conductor WHERE identificacion = " + id);
            
            modelo.addColumn("Identificacion");
            modelo.addColumn("Nombres");
            modelo.addColumn("Apellidos");
            modelo.addColumn("Genero");
            modelo.addColumn("Telefono");
            modelo.addColumn("celular");
            modelo.addColumn("FechaNacimiento");
            modelo.addColumn("Correo");
            modelo.addColumn("NumLicencia");
            modelo.addColumn("CategoriaLicencia");
            modelo.addColumn("Turno");
            modelo.addColumn("CiudadResidencia");
            modelo.addColumn("Direccion");
            modelo.addColumn("Barrio");
            modelo.addColumn("EstadoCivil");
            modelo.addColumn("CodigoVehiculo");
            int numColumnas = 16;
            
            while (rs.next()) {                
                Object[] fila = new Object[numColumnas];
                
                for (int i = 0; i < numColumnas; i++) {
                    fila[i] = rs.getObject(i+1);
                }
                
                modelo.addRow(fila);
            }
            
            stmt.close();
            con.close();
            
            return  modelo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return modelo;
        }
    }
    
    public DefaultTableModel consultarNombreConductor(String nombre){
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            cx = new conexion();
            con = cx.getConexion();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM conductor WHERE nombres = '" + nombre + "'");
            
            modelo.addColumn("Identificacion");
            modelo.addColumn("Nombres");
            modelo.addColumn("Apellidos");
            modelo.addColumn("Genero");
            modelo.addColumn("Telefono");
            modelo.addColumn("celular");
            modelo.addColumn("FechaNacimiento");
            modelo.addColumn("Correo");
            modelo.addColumn("NumLicencia");
            modelo.addColumn("CategoriaLicencia");
            modelo.addColumn("Turno");
            modelo.addColumn("CiudadResidencia");
            modelo.addColumn("Direccion");
            modelo.addColumn("Barrio");
            modelo.addColumn("EstadoCivil");
            modelo.addColumn("CodigoVehiculo");
            int numColumnas = 16;
            
            while (rs.next()) {                
                Object[] fila = new Object[numColumnas];
                
                for (int i = 0; i < numColumnas; i++) {
                    fila[i] = rs.getObject(i+1);
                }
                
                modelo.addRow(fila);
            }
            
            stmt.close();
            con.close();
            
            return  modelo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return modelo;
        }
    }
    
        public DefaultTableModel consultarApellidoConductor(String apellido){
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            cx = new conexion();
            con = cx.getConexion();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM conductor WHERE apellidos = '" + apellido + "'");
            
            modelo.addColumn("Identificacion");
            modelo.addColumn("Nombres");
            modelo.addColumn("Apellidos");
            modelo.addColumn("Genero");
            modelo.addColumn("Telefono");
            modelo.addColumn("celular");
            modelo.addColumn("FechaNacimiento");
            modelo.addColumn("Correo");
            modelo.addColumn("NumLicencia");
            modelo.addColumn("CategoriaLicencia");
            modelo.addColumn("Turno");
            modelo.addColumn("CiudadResidencia");
            modelo.addColumn("Direccion");
            modelo.addColumn("Barrio");
            modelo.addColumn("EstadoCivil");
            modelo.addColumn("CodigoVehiculo");
            int numColumnas = 16;
            
            while (rs.next()) {                
                Object[] fila = new Object[numColumnas];
                
                for (int i = 0; i < numColumnas; i++) {
                    fila[i] = rs.getObject(i+1);
                }
                
                modelo.addRow(fila);
            }
            
            stmt.close();
            con.close();
            
            return  modelo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return modelo;
        }
    }
        
        public DefaultTableModel consultarCatLicConductor(String catLic){
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            cx = new conexion();
            con = cx.getConexion();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM conductor WHERE CategoriaLicencia = '" + catLic + "'");
            
            modelo.addColumn("Identificacion");
            modelo.addColumn("Nombres");
            modelo.addColumn("Apellidos");
            modelo.addColumn("Genero");
            modelo.addColumn("Telefono");
            modelo.addColumn("celular");
            modelo.addColumn("FechaNacimiento");
            modelo.addColumn("Correo");
            modelo.addColumn("NumLicencia");
            modelo.addColumn("CategoriaLicencia");
            modelo.addColumn("Turno");
            modelo.addColumn("CiudadResidencia");
            modelo.addColumn("Direccion");
            modelo.addColumn("Barrio");
            modelo.addColumn("EstadoCivil");
            modelo.addColumn("CodigoVehiculo");
            int numColumnas = 16;
            
            while (rs.next()) {                
                Object[] fila = new Object[numColumnas];
                
                for (int i = 0; i < numColumnas; i++) {
                    fila[i] = rs.getObject(i+1);
                }
                
                modelo.addRow(fila);
            }
            
            stmt.close();
            con.close();
            
            return  modelo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return modelo;
        }
    }
        
        public DefaultTableModel consultarCodVehiculoConductor(String cod){
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            cx = new conexion();
            con = cx.getConexion();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM conductor WHERE codigoVehiculo = '" + cod + "'");
            
            modelo.addColumn("Identificacion");
            modelo.addColumn("Nombres");
            modelo.addColumn("Apellidos");
            modelo.addColumn("Genero");
            modelo.addColumn("Telefono");
            modelo.addColumn("celular");
            modelo.addColumn("FechaNacimiento");
            modelo.addColumn("Correo");
            modelo.addColumn("NumLicencia");
            modelo.addColumn("CategoriaLicencia");
            modelo.addColumn("Turno");
            modelo.addColumn("CiudadResidencia");
            modelo.addColumn("Direccion");
            modelo.addColumn("Barrio");
            modelo.addColumn("EstadoCivil");
            modelo.addColumn("CodigoVehiculo");
            int numColumnas = 16;
            
            while (rs.next()) {                
                Object[] fila = new Object[numColumnas];
                
                for (int i = 0; i < numColumnas; i++) {
                    fila[i] = rs.getObject(i+1);
                }
                
                modelo.addRow(fila);
            }
            
            stmt.close();
            con.close();
            
            return  modelo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return modelo;
        }
    }
        
        public DefaultTableModel consultarCiudadBarrioConductor(String cB){
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            cx = new conexion();
            con = cx.getConexion();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM conductor WHERE ciudadResidencia = '" + cB + "' || barrio = '" + cB + "'");
            
            modelo.addColumn("Identificacion");
            modelo.addColumn("Nombres");
            modelo.addColumn("Apellidos");
            modelo.addColumn("Genero");
            modelo.addColumn("Telefono");
            modelo.addColumn("celular");
            modelo.addColumn("FechaNacimiento");
            modelo.addColumn("Correo");
            modelo.addColumn("NumLicencia");
            modelo.addColumn("CategoriaLicencia");
            modelo.addColumn("Turno");
            modelo.addColumn("CiudadResidencia");
            modelo.addColumn("Direccion");
            modelo.addColumn("Barrio");
            modelo.addColumn("EstadoCivil");
            modelo.addColumn("CodigoVehiculo");
            int numColumnas = 16;
            
            while (rs.next()) {                
                Object[] fila = new Object[numColumnas];
                
                for (int i = 0; i < numColumnas; i++) {
                    fila[i] = rs.getObject(i+1);
                }
                
                modelo.addRow(fila);
            }
            
            stmt.close();
            con.close();
            
            return  modelo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return modelo;
        }
    }
}
