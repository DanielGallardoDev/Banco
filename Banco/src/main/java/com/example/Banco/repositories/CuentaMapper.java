package com.example.Banco.repositories;

import com.example.Banco.models.Cuenta;
import org.apache.ibatis.annotations.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

//todo: Terminar la clase Mapper

@Mapper
public interface CuentaMapper {

    @Select("Select ID_CUENTA, NUMERO_CUENTA, ID_CLIENTE, BALANCE from BANCO.CUENTA")
    @Results(value = {
            @Result(property = "idCuenta", column = "ID_CUENTA"),
            @Result(property = "numeroCuenta", column = "NUMERO_CUENTA"),
            @Result(property = "idCliente", column = "ID_CLIENTE"),
            @Result(property = "balance", column = "BALANCE")})
    List<Cuenta> findAll();

    @Select("Select ID_CUENTA, NUMERO_CUENTA, ID_CLIENTE, BALANCE from BANCO.CUENTA WHERE ID = #{id}")
    @Results(value = {
            @Result(property = "idCuenta", column = "ID_CUENTA"),
            @Result(property = "numeroCuenta", column = "NUMERO_CUENTA"),
            @Result(property = "idCliente", column = "ID_CLIENTE"),
            @Result(property = "balance", column = "BALANCE")})
    Optional<Cuenta> findById(int id);

    @Select("Select ID_CUENTA, NUMERO_CUENTA, sucursal, ID_CLIENTE, BALANCE from BANCO.CUENTA WHERE ID_CUENTA = #{numero_cuenta}")
    @Results(value = {
            @Result(property = "numeroCuenta", column = "ID_CUENTA"),
            @Result(property = "nombreSucursal", column = "sucursal"),
            @Result(property = "idUsuario", column = "ID_CLIENTE"),
            @Result(property = "balance", column = "BALANCE")})
    Optional<Cuenta> findByCuenta(int id);

    @Insert("INSERT INTO CUENTA (NUMERO_CUENTA, ID_CLIENTE, BALANCE) VALUES (#{numeroCuenta, jdbcType = VARCHAR}, #{idCliente}, #{balance})")
    @Options(useGeneratedKeys = true, keyProperty = "idCuenta", keyColumn="ID_CUENTA")
    Cuenta addCuenta(Cuenta cuenta);
}
