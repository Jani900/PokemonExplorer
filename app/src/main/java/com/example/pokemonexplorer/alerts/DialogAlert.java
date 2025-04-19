package com.example.pokemonexplorer.alerts;

import android.content.Context;


import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class DialogAlert {

    public static void showUserMessage(Context context, String alertTitle , String alert){
        new MaterialAlertDialogBuilder(context)
        .setTitle(alertTitle)
                .setMessage(alert)
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }
}
