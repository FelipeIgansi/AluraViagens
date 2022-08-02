package com.alura.aluraviagens.util;

import androidx.annotation.NonNull;

public class DiasUtil {

    public static final String DIAS_PLURAL = " dias";
    public static final String DIAS_SINGULAR = " dia";

    @NonNull
    public static String formataEmTexto(int qtnDias) {
        if (qtnDias >1){
            return qtnDias + DIAS_PLURAL;
        }
        return qtnDias + DIAS_SINGULAR;
    }
}
