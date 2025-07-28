package practicaclienteservidor2.Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
import practicaclienteservidor2.Controlador.Almacen;

public class DatosAlmacen {

    // ➤ Insertar un nuevo almacen
    public void insertar(Almacen almacen) {
        try {
            ConectarBD con = new ConectarBD();
            PreparedStatement ps = con.crearPreparedStatement("INSERT INTO almacen VALUES(?,?,?)");
            ps.setInt(1, almacen.getCodigo());
            ps.setString(2, almacen.getLugar());
            ps.setInt(3, almacen.getCapacidad());
            ps.executeUpdate();
            con.cerrarConexion();
        } catch (SQLException e) {
            Logger.getLogger(DatosAlmacen.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // ➤ Obtener todos los almacenes
    public ArrayList<Almacen> todosAlmacenes() {
        ArrayList<Almacen> lista = new ArrayList<>();
        try {
            ConectarBD con = new ConectarBD();
            Statement st = con.crearStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM almacen");
            while (rs.next()) {
                Almacen al = new Almacen(rs.getInt("codigo"),
                                         rs.getString("lugar"),
                                         rs.getInt("capacidad"));
                lista.add(al);
            }
            rs.close();
            con.cerrarConexion();
        } catch (SQLException e) {
            Logger.getLogger(DatosAlmacen.class.getName()).log(Level.SEVERE, null, e);
        }
        return lista;
    }

    // ➤ Buscar almacenes por lugar
    public ArrayList<Almacen> buscarPorLugar(String lugar) {
        ArrayList<Almacen> lista = new ArrayList<>();
        try {
            ConectarBD con = new ConectarBD();
            PreparedStatement ps = con.crearPreparedStatement("SELECT * FROM almacen WHERE lugar LIKE ?");
            ps.setString(1, "%" + lugar + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Almacen al = new Almacen(rs.getInt("codigo"),
                                         rs.getString("lugar"),
                                         rs.getInt("capacidad"));
                lista.add(al);
            }
            rs.close();
            con.cerrarConexion();
        } catch (SQLException e) {
            Logger.getLogger(DatosAlmacen.class.getName()).log(Level.SEVERE, null, e);
        }
        return lista;
    }

    // ➤ Eliminar un almacen por código
    public void eliminarAlmacen(int codigo) {
        try {
            ConectarBD con = new ConectarBD();
            PreparedStatement ps = con.crearPreparedStatement("DELETE FROM almacen WHERE codigo=?");
            ps.setInt(1, codigo);
            ps.executeUpdate();
            con.cerrarConexion();
        } catch (SQLException e) {
            Logger.getLogger(DatosAlmacen.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}

