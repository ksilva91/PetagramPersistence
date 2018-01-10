package com.example.kruger.petagram.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kruger.petagram.R;
import com.example.kruger.petagram.adapters.PetGridAdapter;
import com.example.kruger.petagram.model.Pet;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GridListFragment extends Fragment {

    private ArrayList<Pet> pets = new ArrayList<>();
    private RecyclerView rvPets;
    private CircularImageView civ_pet_image;
    private TextView tv_pet_name;

    public GridListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grid_list, container, false);
        rvPets = view.findViewById(R.id.rv_pet_grid_list);
        civ_pet_image = view.findViewById(R.id.civ_pet_image);
        tv_pet_name = view.findViewById(R.id.tv_pet_name);

        Pet dummyPet = new Pet(R.drawable.first_pet,"Bobby",0);
        civ_pet_image.setImageResource(dummyPet.getImage());
        tv_pet_name.setText(dummyPet.getName());

        GridLayoutManager dlm = new GridLayoutManager(getActivity(),3);
        dlm.setOrientation(GridLayoutManager.VERTICAL);
        rvPets.setLayoutManager(dlm);
        initializeList();
        initializeAdapter();
        return view;
    }

    private void initializeList(){
        pets.add(new Pet(R.drawable.first_pet,"Bobby",0));
        pets.add(new Pet(R.drawable.first_pet,"Bobby",1));
        pets.add(new Pet(R.drawable.first_pet,"Bobby",3));
        pets.add(new Pet(R.drawable.first_pet,"Bobby",1));
        pets.add(new Pet(R.drawable.first_pet,"Bobby",5));
        pets.add(new Pet(R.drawable.first_pet,"Bobby",10));
        pets.add(new Pet(R.drawable.first_pet,"Bobby",21));
        pets.add(new Pet(R.drawable.first_pet,"Bobby",2));
        pets.add(new Pet(R.drawable.first_pet,"Bobby",3));
        pets.add(new Pet(R.drawable.first_pet,"Bobby",0));
        pets.add(new Pet(R.drawable.first_pet,"Bobby",4));
        pets.add(new Pet(R.drawable.first_pet,"Bobby",8));
    }

    private void initializeAdapter(){
        PetGridAdapter pa = new PetGridAdapter(pets);
        rvPets.setAdapter(pa);
    }

}
