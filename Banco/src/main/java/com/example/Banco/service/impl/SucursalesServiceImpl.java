package com.example.Banco.service.impl;

import com.example.Banco.models.Sucursal;
import com.example.Banco.repositories.SucursalRepositoryMyBatis;
import com.example.Banco.service.SucursalesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalesServiceImpl implements SucursalesService {

    private SucursalRepositoryMyBatis sucursalRepositoryMyBatis;

    public SucursalesServiceImpl(SucursalRepositoryMyBatis sucursalRepositoryMyBatis) {
        this.sucursalRepositoryMyBatis = sucursalRepositoryMyBatis;
    }

    @Override
    public void alta(Sucursal sucursal) {
        sucursalRepositoryMyBatis.alta(sucursal);
    }

    @Override
    public List<Sucursal> listar() {
        return sucursalRepositoryMyBatis.listar();
    }

    @Override
    public void borrar(Sucursal sucursal) {
        sucursalRepositoryMyBatis.borrar(sucursal);
    }

    @Override
    public void modificar(Sucursal sucursalvieja, Sucursal sucursalNueva) {
        sucursalRepositoryMyBatis.modificar(sucursalvieja,sucursalNueva);
    }
}
