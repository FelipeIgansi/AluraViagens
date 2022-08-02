package com.alura.aluraviagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import com.alura.aluraviagens.model.Pacote;

public class ResourcesUtil {

    public static final String DRAWABLE = "drawable";

    @Nullable
    public static Drawable devolveDrawable(Context context, String drawableEmTexto) {
        Resources resources = context.getResources();
        int idDoDrawable = resources.getIdentifier(drawableEmTexto
                , DRAWABLE, context.getPackageName());
        Drawable drawableImagemPacote = ResourcesCompat.getDrawable(resources, idDoDrawable, null);
        return drawableImagemPacote;
    }
}
