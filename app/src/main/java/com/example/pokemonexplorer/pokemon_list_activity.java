package com.example.pokemonexplorer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pokemonexplorer.pokemon.Pokemon;
import com.example.pokemonexplorer.pokemon.PokemonAdapter;

import java.util.ArrayList;
import java.util.List;

public class pokemon_list_activity extends AppCompatActivity {

    //Initializing ListView varibale and calling data from the Pokemon class
    ListView pokemonList;
    List<Pokemon> data = new ArrayList<>();
    private TextView userDetails;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pokemon_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
         userDetails = findViewById(R.id.nameOutput);
        /* use of intent method to access the intent object that was created in the main activity
        and passed to pokemon_list_activity to be displayed using getString function to deconstruct
        intent object
        */
        String userName = getIntent().getStringExtra(
                getResources().getString(R.string.user_name_key)
        );
        //Setting the userName stored in the userName
        userDetails.setText("Welcome " + userName + "\nLet us explore Pokemon");
        //calling function
        createPokemonList();
        pokemonList = findViewById(R.id.pokemonListView);
        /* Initialising adapter var for populating the pokemon item in list view with Image and name of the pokemon
        via Pokemon adapter class
         */
        PokemonAdapter adapter = new PokemonAdapter(data, getApplicationContext());
        pokemonList.setAdapter(adapter);
         /* Using setOnItmeClickListener() to listen for e when user taps on Pokemon to be directed to
         Pokemon details activity , Intent helps to pass user between different screens/activities along with
         data via putExtra().
         */
        pokemonList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), pokemon_detail_activity.class);
                intent.putExtra(getResources().getString(R.string.pokemon_detail_object),data.get(position));
                startActivity(intent);
            }
        });

    }
    /* Typed array is a container that holds an array value in this instance images of the pokemons
    initiating string arrays to hold value from each array about pokemons data then looping through
    each pokemon name adding the correct arrays to a particular Pokemon
      */
    private void createPokemonList(){
        TypedArray images = getResources().obtainTypedArray(R.array.images);
        String [] pokemonNames = getResources().getStringArray(R.array.pokemon_names);
        String [] pokemonDescriptions = getResources().getStringArray(R.array.pokemon_descriptions);
        String [] pokemonHeight = getResources().getStringArray(R.array.height);
        String [] pokemonCategory = getResources().getStringArray(R.array.category);
        String [] pokemonWeight = getResources().getStringArray(R.array.weight);
        String [] pokemonAbilities = getResources().getStringArray(R.array.abilities);


        for (int i = 0; i < pokemonNames.length; i++ ){

            Pokemon item = new Pokemon(images.getResourceId(i,-1),
                    pokemonNames[i],
                    pokemonDescriptions[i],
                    pokemonHeight[i],
                    pokemonCategory[i],
                    pokemonWeight[i],
                    pokemonAbilities[i]
            );
            data.add(item);

        }

    }
}