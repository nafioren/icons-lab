package com.example.icons.controller;


import com.example.icons.dto.ContinenteDTO;
import com.example.icons.service.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("continentes")
public class ContinenteController {
    @Autowired
    private ContinenteService continenteService;
    //Para guardar
    @PostMapping
    public ResponseEntity<ContinenteDTO> save (@RequestBody ContinenteDTO continente){
        //save continente
        //201, continente guardado
        ContinenteDTO continenteGuardado = continenteService.save(continente);
        return ResponseEntity.status(HttpStatus.CREATED).body(continenteGuardado);

    }
}

