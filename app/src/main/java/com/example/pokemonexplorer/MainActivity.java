package com.example.pokemonexplorer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pokemonexplorer.alerts.DialogAlert;
import com.example.pokemonexplorer.pokemon.Pokemon;
import com.example.pokemonexplorer.pokemon.PokemonAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private EditText inputText;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputText = findViewById(R.id.collectName);
        Button submitButton = findViewById(R.id.submitButton);

        inputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Set new color teal_200 when user starts typing
                int newColor = s.length() > 0
                        ? ContextCompat.getColor(MainActivity.this, R.color.teal_200)
                        : ContextCompat.getColor(MainActivity.this, com.google.android.material.R.color.design_default_color_background);
                inputText.setTextColor(newColor);
                //update the underline (backgroundTint)
                inputText.setBackgroundTintList(ColorStateList.valueOf(newColor));
            }

            @Override
            public void afterTextChanged(Editable s) {
                //no action needed after text is changed

            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String userName = inputText.getText().toString();

        if (userName.isEmpty()){
            /* i could use toast.makeText() here but I decided to follow the Alert dialog instead
             according to alertDialog docs , it is preferable option for output to better presented
             to the user, especially if there is a fail, I can also re-use the class elsewhere in the code
                          */
             DialogAlert.showUserMessage(MainActivity.this,"Registration Error","Please check your details and re-submit.");

        }
        else {
            //Automated upper letter start of the user name to support friendly UX design
            String upperLetter = userName.substring(0,1).toUpperCase() + userName.substring(1).toLowerCase();
            inputText.setText(upperLetter);
            userName = upperLetter;
            /* if user entered their name correctly , the input value is passed to pokemonList activity
            via Intent object as a key-value pair
             */
            Intent intent = new Intent(MainActivity.this, pokemon_list_activity.class);
            //Passing the user's name as a key value
            intent.putExtra(getResources().getString(R.string.user_name_key),userName);
            startActivity(intent);
        }
    }


}

