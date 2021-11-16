package com.itca.proyectofinaldaute.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.itca.proyectofinaldaute.R;
import com.itca.proyectofinaldaute.aggcategoria;
import com.itca.proyectofinaldaute.agregarProd;
import com.itca.proyectofinaldaute.databinding.FragmentGalleryBinding;
import com.itca.proyectofinaldaute.editcat;
import com.itca.proyectofinaldaute.listar_cat;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;
    private Button agcat, editar,listar ;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        agcat = root.findViewById(R.id.agcat);
        editar = root.findViewById(R.id.editar);
        listar = root.findViewById(R.id.listar);

        agcat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent agcat = new Intent(getContext(), aggcategoria.class);
                startActivity(agcat);
            }
        });

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent agcat = new Intent(getContext(), editcat.class);
                startActivity(agcat);
            }
        });

        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent agcat = new Intent(getContext(), listar_cat.class);
                startActivity(agcat);
            }
        });


        final TextView textView = binding.tv1;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}