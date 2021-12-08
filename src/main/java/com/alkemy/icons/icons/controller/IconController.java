package com.alkemy.icons.icons.controller;

import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("iconos")
public class IconController {

    @Autowired
    private IconService iconService;

    @GetMapping
    public ResponseEntity<List<IconDTO>> getAll() {
        List<IconDTO> iconos = this.iconService.getAllIcons();
        return ResponseEntity.ok().body(iconos);
    }

    //Este método nos ayuda a manejar las respuestas
    @PostMapping
    public ResponseEntity<IconDTO>  save(@RequestBody IconDTO icono) {
        //Guardar icono
        IconDTO iconoGuardado = iconService.save(icono);

        //Response with 201, which means Save Success
        return ResponseEntity.status(HttpStatus.CREATED).body(iconoGuardado);

    }

}
