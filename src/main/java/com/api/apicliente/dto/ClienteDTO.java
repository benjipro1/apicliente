package com.api.apicliente.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.checkerframework.checker.units.qual.N;
import org.springframework.hateoas.RepresentationModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO extends RepresentationModel<ClienteDTO>{

    private Integer idCliente;
    private Integer idUsuario;
    private String nombreCompleto;
    private String rut;
    private String direccion;
    private String telefono;

}
