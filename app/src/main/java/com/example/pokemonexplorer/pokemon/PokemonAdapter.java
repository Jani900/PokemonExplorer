package com.example.pokemonexplorer.pokemon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pokemonexplorer.MainActivity;
import com.example.pokemonexplorer.R;

import java.util.List;

public class PokemonAdapter extends BaseAdapter {

    List<Pokemon> data;
    Context context;

    public PokemonAdapter(List<Pokemon> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    class Elements{
        ImageView image;
        TextView pokemonName;
        TextView pokemonDetails;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Elements elements = null;

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.layout_pokemon_item, null);
        }
        elements = new Elements();
        elements.image = view.findViewById(R.id.pokemonCardImage);
        elements.pokemonName = view.findViewById(R.id.pokemonCardName);
        Pokemon pokemonDetails = data.get(i);
        elements.image.setImageResource(pokemonDetails.getImageResourseId());
        elements.pokemonName.setText(pokemonDetails.getName());
        return view;
    }
}
