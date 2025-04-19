package com.example.pokemonexplorer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pokemonexplorer.pokemon.Pokemon;


public class pokemon_detail_activity extends AppCompatActivity {

    Button exploreMore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pokemon_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Initiating pokemon var to retrieve data held in pokemon_detail_object
        Pokemon pokemon;
        pokemon = (Pokemon) getIntent().getSerializableExtra(getResources().getString(R.string.pokemon_detail_object));

        //Initiate views
        TextView pokemonName = findViewById(R.id.pokemonName);
        ImageView pokemonImage = findViewById(R.id.pokemonImage);
        TextView pokemonDescription = findViewById(R.id.pokemonDescription);
        RadioGroup infoRadioGroup = findViewById(R.id.infoRadioGroup);
        TextView pokemonType = findViewById(R.id.infoDetailText);

        //set initial data from pokemon class with help of get methods
        pokemonName.setText(pokemon.getName());
        pokemonImage.setImageResource(pokemon.getImageResourseId());
        pokemonDescription.setText(pokemon.getDescription());
        //set default value when detailscreen launch befere user selects different radio button
        pokemonType.setText(pokemon.getHeight());

        //Setting up selection and calling value for each radio button
        infoRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioHeight){
                    pokemonType.setText(pokemon.getHeight());
                }
                else if (checkedId == R.id.radioWeight){
                    pokemonType.setText(pokemon.getWeight() + "Kg");
                }
                else if (checkedId == R.id.radioCategory){
                    pokemonType.setText(pokemon.getCategory());
                }
                else if (checkedId == R.id.radioAbility){
                    pokemonType.setText(pokemon.getAbility());
                }

                }
        });
        // Return to previous page for further Pokemon exploration
         exploreMore = findViewById(R.id.exploreMoreButton);
         exploreMore.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 finish();
             }
         });


    }


}