package com.example.kruger.petagram.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kruger.petagram.R;
import com.example.kruger.petagram.model.Pet;

import java.util.ArrayList;

/**
 * Created by Kruger on 27/12/2017.
 */

public class PetGridAdapter extends RecyclerView.Adapter<PetGridAdapter.PetViewHolder> {
    private ArrayList<Pet> pets;

    public PetGridAdapter(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_list_pet, parent, false);
        return new PetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PetViewHolder holder, int position) {
        final Pet pet = pets.get(position);
        holder.ivImage.setImageResource(pet.getImage());
        holder.tvPetRating.setText(String.valueOf(pet.getRating()));
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder {

        ImageView ivImage;
        TextView tvPetRating;

        public PetViewHolder(View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_image);
            tvPetRating = itemView.findViewById(R.id.tv_rating);
        }
    }
}
