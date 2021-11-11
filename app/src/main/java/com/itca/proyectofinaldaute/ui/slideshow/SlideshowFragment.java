package com.itca.proyectofinaldaute.ui.slideshow;

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
import com.itca.proyectofinaldaute.agregarProd;
import com.itca.proyectofinaldaute.databinding.FragmentSlideshowBinding;
import com.itca.proyectofinaldaute.edit_prod;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private FragmentSlideshowBinding binding;
private Button agg, editar;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        agg = root.findViewById(R.id.agg);
        agg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent agg = new Intent(getContext(), agregarProd.class);
                startActivity(agg);
            }
        });


        editar = root.findViewById(R.id.editar);
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent edit = new Intent(getContext(), edit_prod.class);
                startActivity(edit);
            }
        });


        final TextView textView = binding.tvprod;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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