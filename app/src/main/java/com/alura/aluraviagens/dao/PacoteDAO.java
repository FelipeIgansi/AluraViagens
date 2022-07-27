package com.alura.aluraviagens.dao;

import com.alura.aluraviagens.model.Pacote;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacoteDAO {
    public List<Pacote> lista(){
        List<Pacote> pacotes = new ArrayList<>(Arrays.asList(
            new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal(243.99)),
            new Pacote("Belo Horizonte", "belo_horizonte_mg", 3, new BigDecimal(421.50)),
            new Pacote("Recife", "recife_pe", 4, new BigDecimal(754.20)),
            new Pacote("Rio de Janeiro", "salvador_ba", 5, new BigDecimal(899.99)),
            new Pacote("Foz do iguaçu", "foz_iguacu", 1, new BigDecimal(289.90))

        ));
        return pacotes;
    }
}
