package com.example.kruger.petagram.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kruger.petagram.R;
import com.example.kruger.petagram.adapters.PetAdapter;
import com.example.kruger.petagram.model.Pet;
import com.example.kruger.petagram.model.PetConstructor;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    private ArrayList<Pet> pets = new ArrayList<>();
    private RecyclerView rvPets;
    private PetConstructor petConstructor;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        rvPets = view.findViewById(R.id.rv_pet_list);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvPets.setLayoutManager(llm);
        initializeList();
        initializeAdapter();
        return view;
    }
    private void initializeList(){
        petConstructor = new PetConstructor(getActivity());
        pets = petConstructor.getPets();
    }

    private void initializeAdapter(){
        PetAdapter pa = new PetAdapter(pets,getActivity());
        rvPets.setAdapter(pa);
    }
}
