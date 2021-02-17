package com.openclassrooms.realestatemanager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openclassrooms.realestatemanager.databinding.FragmentAddBinding;

public class AddFragment extends Fragment {

    private FragmentAddBinding binding;
    private SharedViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewModelFactory viewModelFactory = Injection.provideViewModelFactory(requireContext());
        viewModel = new ViewModelProvider(this, viewModelFactory).get(SharedViewModel.class);

        binding.fragmentAddCreateBtn.setOnClickListener(v -> addRealEstate());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void addRealEstate() {
        RealEstate realEstate = new RealEstate(
                "Flat",
                "123,000,000",
                "2","2","3","2","Lorem Ipsum","22",
                "School",true,2,0, "Peach"
        );

        viewModel.addRealEstate(realEstate);
    }
}