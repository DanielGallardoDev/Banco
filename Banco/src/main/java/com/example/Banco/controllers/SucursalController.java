package com.example.Banco.controllers;

import com.example.Banco.models.Sucursal;
import com.example.Banco.service.SucursalesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {
    private SucursalesService sucursalesService;

    public SucursalController(SucursalesService sucursalesService){
        this.sucursalesService = sucursalesService;
    }

    @PostMapping("")
    public void alta(Sucursal sucursal){
        this.sucursalesService.alta(sucursal);
    }

    @PutMapping("")
    public void modificar(Sucursal sucursalVieja, Sucursal sucursalNueva){
        this.sucursalesService.modificar(sucursalVieja, sucursalNueva);
    }

    @GetMapping("")
    public List<Sucursal> listar(){
        return this.sucursalesService.listar();
    }

    @DeleteMapping("")
    public void borrar(Sucursal sucursal){
        this.sucursalesService.borrar(sucursal);
    }
}
