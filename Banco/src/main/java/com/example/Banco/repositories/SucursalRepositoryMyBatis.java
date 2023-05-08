package com.example.Banco.repositories;

import com.example.Banco.models.Sucursal;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SucursalRepositoryMyBatis {

    //TODO: Implementar sentencia SQL con los nombres cuando los tengamos
    @Insert("INSERT INTO SUCURSAL(ID, NOMBRE, DIRECTOR, DIRECCION) VALUES(#{sucursal.id}, #{sucursal.nombre}, #{sucursal.director}, #{sucursal.direccion})")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "nombre", column = "nombre"),
            @Result(property = "director", column = "director"),
            @Result(property = "direccion", column = "direccion")

    })
    public void alta(Sucursal sucursal);


    //TODO: Implementar/corregir sentencia SQL con los nombres cuando los tengamos
    @Select("SELECT id, nombre, director, direccion from sucursal")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "nombre", column = "nombre"),
            @Result(property = "director", column = "director"),
            @Result(property = "direccion", column = "direccion")

    })
    public List<Sucursal> listar();

    @Delete("DELETE FROM sucursal WHERE id=#{sucursal.id}")
    public void borrar(Sucursal sucursal);


    @Update("Update SUCURSAL SET #{sucursalvieja.id}= #{sucursalnueva.id}, " +
            "#{sucursalvieja.nombre}= #{sucursalnueva.nombre}," +
            "#{sucursalvieja.director}= #{sucursalnueva.director}," +
            "#{sucursalvieja.direccion}= #{sucursalnueva.direccion} " +
            "from SUCURSAL where id = #{sucursalvieja}")
    public void modificar(Sucursal sucursalvieja, Sucursal sucursalNueva);
}
