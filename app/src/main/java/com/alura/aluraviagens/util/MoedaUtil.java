package com.alura.aluraviagens.util;

import androidx.annotation.NonNull;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static final String PORTUGUES = "pt";
    public static final String BRASIL = "br";
    public static final String FORMATO_SEM_ESPACO = "R$";
    public static final String FORMATO_COM_ESPACO = "R$ ";

    @NonNull
    public static String formataPara_MoedaReal(BigDecimal valor) {
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(new Locale(PORTUGUES, BRASIL));
        String moedaBrasileiraFormatada =
                formatoBrasileiro.format(valor).replace(FORMATO_SEM_ESPACO, FORMATO_COM_ESPACO);
        return moedaBrasileiraFormatada;
    }
}
