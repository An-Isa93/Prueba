package com.mycompany.piapoo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author AnaPao
 */
public class Libro {
      private int id;
      private String titulo;
      private String autor;
      private String edicion;
      private String editorial;
      private String genero;
      private int year;
      private float precio;
      private Conectar conectar;
      private Connection cx;
     
      public Libro(){
         conectar= new Conectar();
         
        }
      
      public void Agregar(){
          try{
                  PreparedStatement st;
                  String sql;
                  cx = conectar.conectar();
                  sql = "INSERT INTO libro(id,titulo,autor,edicion,editorial,genero,año,precio)values(?,?,?,?,?,?,?,?)";
                  st= cx.prepareStatement(sql);
                  st.setInt(1,this.id);
                  st.setString(2, this.titulo);
                  st.setString(3,this.autor);
                  st.setString(4, this.edicion);
                  st.setString(5, this.editorial);
                  st.setString(6, this.genero);
                  st.setInt(7, this.year);
                  st.setFloat(8, this.precio);
              
               int rowsAffected = st.executeUpdate();
             /* JOptionPane.showMessageDialog(null, "Se han insertado los datos");*/
             if (rowsAffected > 0) {
             // Consulta para obtener el último ID insertado
             Statement stmt = cx.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
                if (rs.next()) {
                  int generatedId = rs.getInt(1);
                  JOptionPane.showMessageDialog(null, "Registro insertado con ID: " + generatedId);
                  }
             } else {
                  JOptionPane.showMessageDialog(null, "No se pudieron insertar los datos");
          }
          }
          catch(Exception ex)
          {
              System.err.println(ex.getMessage());
          }
        
      }
    
          
      
      public void Actualizar()
      {
          try{
                PreparedStatement st;
                String sql;
                cx = conectar.conectar();
                sql="UPDATE libro SET titulo=?,autor=?,edicion=?,editorial=?,genero=?,año=?,precio=? where id=?";
                st= cx.prepareStatement(sql);
              
                  st.setString(1, this.titulo);
                  st.setString(2,this.autor);
                  st.setString(3, this.edicion);
                  st.setString(4, this.editorial);
                  st.setString(5, this.genero);
                  st.setInt(6, this.year);
                  st.setFloat(7, this.precio);
                  st.setInt(8, this.id);
                
                  int rowsAffected = st.executeUpdate();
                  if(rowsAffected>0){
                    JOptionPane.showMessageDialog(null, "Registro actualizado");
                  }
                  else
                  {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el registro");
                  }
                  
          }
          catch(Exception ex){
               System.err.println(ex.getMessage());
          }
       
    
      }
      
      public boolean eliminar(int id) {
        try {
            Conectar conectar = new Conectar();
            Connection cx = conectar.conectar();
            String sql = "DELETE FROM libro WHERE id = ?";

            try (PreparedStatement st = cx.prepareStatement(sql)) {
                st.setInt(1, id);
                int rowsAffected = st.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (SQLException | NumberFormatException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
       finally {
        try {
            if (cx != null && !cx.isClosed()) {
                cx.close();
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the edicion
     */
    public String getEdicion() {
        return edicion;
    }

    /**
     * @param edicion the edicion to set
     */
    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    /**
     * @return the editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * @param editorial the editorial to set
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }
     
}
