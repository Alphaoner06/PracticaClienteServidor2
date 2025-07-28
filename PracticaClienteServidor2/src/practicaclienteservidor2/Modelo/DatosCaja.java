package practicaclienteservidor2.Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import practicaclienteservidor2.Controlador.Articulo;

public class DatosCaja {
    public void insertar(Articulo arti){
    try{
       //1-crear la conexion con la base de datos
       ConectarBD con;
        con = new ConectarBD();
       //2-creamos la sentencia
       PreparedStatement misql = con.crearPreparedStatement("INSERTE INTO articulo VALUES(?,?,?)");
       misql.setInt(1,arti.getCodigo());
       misql.setString(2, arti.getDescripcion());
       misql.setFloat(3,arti.getPrecio());
       //3-ejecutar el comando sql
       misql.executeUpdate();
       //4-cerrar la conexion 
       con.cerrarConexion();
    }catch(SQLException e){
        Logger.getLogger(DatosArticulo.class.getName()).log(Level.SEVERE,null,e);
        
    }
}
  public ArrayList<Articulo>todosArticulos(){
      ArrayList<Articulo>miListaArticulo=new ArrayList<>();
      try{
          //1-crear la conexion con la base de datos
       ConectarBD con=new ConectarBD();
        //2-creamos la sentencia
        Statement st=con.crearStatemnt();
        ResultSet rs=st.executeQuery("SELECT*FROM articulo");
        while (rs.next()){
            Articulo arti=new Articulo(rs.getInt("codigo"),
                    rs.getString("descripcion"),rs.getFloat("precio"));
            miListaArticulo.add(arti);//se agrega un articulo a la lista
        }
        //3 cerrar la busqueda y la conexion
        rs.close();
        con.cerrarConexion();
        }catch(SQLException e){
            Logger.getLogger(DatosArticulo.class.getName()).log(Level.SEVERE, null,e);
        }
      return miListaArticulo;
  }

 public ArrayList<Articulo>BuscarArticuloDescripcion(String descripcion){
      ArrayList<Articulo>miListaArticulo=new ArrayList<>();
      try{
          //1-crear la conexion con la base de datos
       ConectarBD con=new ConectarBD();
        //2-creamos la sentencia
        PreparedStatement misql
            =con.crearPreparedStatement("SELECT*FROM articulo WHERE descripcion like?");
        descripcion='%'+descripcion+'%';
        misql.setString(1, descripcion);
        ResulSet rs= misql.executeQuery();
        while (rs.next()){
            Articulo arti=new Articulo(rs.getInt("codigo"),
                    rs.getString("descripcion"),rs.getFloat("precio"));
            miListaArticulo.add(arti);//se agrega un articulo a la lista
        }
        //3 cerrar la busqueda y la conexion
        rs.close();
        con.cerrarConexion();
        }catch(SQLException e){
            Logger.getLogger(DatosArticulo.class.getName()).log(Level.SEVERE, null,e);
        }
      return miListaArticulo;
  }
 public void eliminarArticulo(int codigo){
     try{
                 //1-crear la conexion con la base de datos
       ConectarBD con=new ConectarBD(); 
       //2-creamos la sentencia 
        Statement st=con.crearStatemnt();
        ResultSet rs=st.executeQuery("DELETE*FROM articulo WHERE codigo=?");
        rs.close();
        con.cerrarConexion();
      }catch(SQLException e){
          Logger.getLogger(DatosArticulo.class.getName()).log(Level.SEVERE, null,e);
      }
 }
<<<<<<< HEAD
}
=======
}
>>>>>>> 2ce8521455f16f4e2c33a2537a88864de2c2d385
