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
public class vehiculo {
    static Connection con;
    static conexion cx;
    
    private long codigoVehiculo;
    private String placa;
    private String tipo;
    private String marca;
    private String modelo;
    private String descripcion;
    private String fechaInicioOperacion;
    private String estadoAsignacion;
    
    public long getCodigoVehiculo(){
        return codigoVehiculo;
    }
    
    public void setCodigoVehiculo(long codigoVehiculo){
        this.codigoVehiculo = codigoVehiculo;
    }
    
    public String getPlaca(){
        return placa;
    }
    
    public void setPlaca(String placa){
        this.placa = placa;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public String getModelo(){
        return modelo;
    }
    
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public String getFechaInicioOperacion(){
        return fechaInicioOperacion;
    }
    
    public void setFechaInicioOperacion(String fechaInicioOperacion){
        this.fechaInicioOperacion = fechaInicioOperacion;
    }
    
    public String getEstadoAsignacion(){
        return estadoAsignacion;
    }
    
    public void setEstadoAsignacion(String estadoAsignacion){
        this.estadoAsignacion = estadoAsignacion;
    }
    
    public boolean guardarVehiculo(){
        try {
            cx = new conexion();
            con = cx.getConexion();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO vehiculo(codigoVehiculo, placa, tipo, marca, modelo, descripcion, fechaInicioOperacion, estadoAsignacion ) VALUES (?,?,?,?,?,?,?,?)");
            
            stmt.setString(1,"" + this.codigoVehiculo);
            stmt.setString(2,this.placa);
            stmt.setString(3,this.tipo);
            stmt.setString(4,this.marca);
            stmt.setString(5,this.modelo);
            stmt.setString(6,this.descripcion);
            stmt.setString(7,this.fechaInicioOperacion);
            stmt.setString(8,"No Asignado");
            
            stmt.executeUpdate();
            stmt.close();
            con.close();
            
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean consultarVehiculoCodVehiculo(long codVehiculo){
        try {
            boolean consultaOk = false;
            cx = new conexion();
            con = cx.getConexion();
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM vehiculo where codigoVehiculo = " + codVehiculo);
            
            if (rs.next() == true) {
                this.codigoVehiculo=Long.parseLong(rs.getString("codigoVehiculo"));
                this.placa=rs.getString("placa");
                this.tipo= rs.getString("tipo");
                this.marca=rs.getString("marca");
                this.modelo=rs.getString("modelo");
                this.descripcion=rs.getString("descripcion");
                this.fechaInicioOperacion=rs.getString("fechaInicioOperacion");
                this.estadoAsignacion=rs.getString("estadoAsignacion");
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
    
    public boolean actualizarVehiculo(){
        try {
            cx = new conexion();
            con = cx.getConexion();
            
            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE vehiculo SET placa = '"+ this.placa +
                    "',tipo='" + this.tipo +
                    "',marca='" + this.marca +
                    "',modelo='" + this.modelo +
                    "',descripcion='" + this.descripcion +
                    "',fechaInicioOperacion='" + this.fechaInicioOperacion +
                    "' WHERE (codigoVehiculo = " + this.codigoVehiculo + ")");
            stmt.executeUpdate();
            stmt.close();
            con.close();
            
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean estadoAsignacion(){
        try {
            
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean eliminarVehiculo(long codVehiculo){
        try {
            cx = new conexion();
            con = cx.getConexion();
            PreparedStatement stmt = con.prepareStatement("DELETE FROM vehiculo WHERE (codigoVehiculo = " + codVehiculo + ")");
            
            stmt.executeUpdate();
            stmt.close();
            con.close();
            
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
