package practicaclienteservidor2.Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;

import practicaclienteservidor2.Controlador.Caja;

public class DatosCaja {
    public void insertar(Caja caja){
    try{
       //1-crear la conexion con la base de datos
       ConectarBD con;
        con = new ConectarBD();
       //2-creamos la sentencia
       PreparedStatement misql = con.crearPreparedStatement("INSERTE INTO caja VALUES(?,?,?,?)");
       misql.setInt(1,caja.getNumeroReferencia());
       misql.setString(2, caja.getContenido());
       misql.setInt(3,caja.getPrecio());
       misql.setInt(4, caja.getAlmacen());
       //3-ejecutar el comando sql
       misql.executeUpdate();
       //4-cerrar la conexion 
       con.cerrarConexion();
    }catch(SQLException e){
        Logger.getLogger(DatosCaja.class.getName()).log(Level.SEVERE,null,e);
        
    }
}
  public ArrayList<Caja>listaCajas(){
      ArrayList<Caja>miListaCaja=new ArrayList<>();
      try{
          //1-crear la conexion con la base de datos
       ConectarBD con=new ConectarBD();
        //2-creamos la sentencia
        Statement st=con.crearStatement();
        ResultSet rs=st.executeQuery("SELECT*FROM caja");
        while (rs.next()){
            Caja caja=new Caja(
                rs.getInt("numReferencias"),
                rs.getString("Contenido"),
                rs.getInt("Precio"),
                rs.getInt("Almacen")
            );
            miListaCaja.add(caja);//se agrega un articulo a la lista
        }
        //3 cerrar la busqueda y la conexion
        rs.close();
        con.cerrarConexion();
        }catch(SQLException e){
            Logger.getLogger(DatosCaja.class.getName()).log(Level.SEVERE, null,e);
        }
      return miListaCaja;
  }

 public ArrayList<Caja>BuscarCajaContenido(String contenido){
      ArrayList<Caja>miListaCajas=new ArrayList<>();
      try{
          //1-crear la conexion con la base de datos
       ConectarBD con=new ConectarBD();
        //2-creamos la sentencia
        PreparedStatement misql
            =con.crearPreparedStatement("SELECT*FROM caja WHERE Contenido like ?");
        contenido='%'+contenido+'%' + '%';
        misql.setString(1, contenido);
        ResultSet rs= misql.executeQuery();
        while (rs.next()){
            Caja caja = new Caja(
                rs.getInt("numReferencias"),
                rs.getString("Contenido"),
                rs.getInt("Precio"),
                rs.getInt("Almacen")
            );
            miListaCajas.add(caja);//se agrega un articulo a la lista
        }
        //3 cerrar la busqueda y la conexion
        rs.close();
        con.cerrarConexion();
        }catch(SQLException e){
            Logger.getLogger(DatosCaja.class.getName()).log(Level.SEVERE, null,e);
        }
      return miListaCajas;
  }
 public void eliminarArticulo(int codigo){
     try{
                 //1-crear la conexion con la base de datos
       ConectarBD con=new ConectarBD(); 
       //2-creamos la sentencia 
        Statement st=con.crearStatement();
        ResultSet rs=st.executeQuery("DELETE*FROM articulo WHERE codigo=?");
        rs.close();
        con.cerrarConexion();
      }catch(SQLException e){
          Logger.getLogger(DatosCaja.class.getName()).log(Level.SEVERE, null,e);
      }
 }
}
