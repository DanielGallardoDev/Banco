package com.example.Banco.service;

import com.example.Banco.models.Sucursal;

import java.util.List;

public interface SucursalesService {
    public void alta(Sucursal sucursal);

    public List<Sucursal> listar();

    public void borrar(Sucursal sucursal);

    public void modificar(Sucursal sucursalvieja, Sucursal sucursalNueva);
}
