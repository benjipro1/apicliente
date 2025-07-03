package com.api.apicliente.controller;

import com.api.apicliente.dto.ClienteDTO;
import com.api.apicliente.services.ClienteService;

import org.checkerframework.checker.units.qual.s;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")



public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteDTO> crear(@RequestBody ClienteDTO dto) {
        return ResponseEntity.ok(service.guardar(dto));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obtener(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> actualizar(@PathVariable Integer id, @RequestBody ClienteDTO dto) {
        return service.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        return service.eliminar(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }


    @GetMapping("/hateoas/{id}")
    public ClienteDTO obtenerHateoas(@PathVariable Integer id) {
        ClienteDTO dto = service.obtenerPorId(id);
        dto.add(linkTo(methodOn(ClienteController.class).obtenerHateoas(id)).withSelfRel());
        dto.add(linkTo(methodOn(ClienteController.class).listarHateoas()).withRel("TODOS"));
        dto.add(linkTo(methodOn(ClienteController.class).eliminar(id)).withRel("ELIMINAR"));
        return dto;
    }

    @GetMapping("/hateoas")
    public List<ClienteDTO> listarHateoas() {
        List<ClienteDTO> clientes = service.listar();
        for (ClienteDTO dto : clientes) {
            dto.add(linkTo(methodOn(ClienteController.class).obtenerHateoas(dto.getId())).withSelfRel());
        }
        return clientes;
    }

}
