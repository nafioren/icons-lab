package com.example.icons.service;

import org.springframework.stereotype.Service;
import com.example.icons.dto.ContinenteDTO;

@Service
public class ContinenteService {
    //metodo para guardar
    //TODO: guardar continente
    public ContinenteDTO save (ContinenteDTO dto) {
        System.out.println("GUARDAR CONTINENTE");
        return dto;
    }

}
