package com.openclassrooms.realestatemanager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openclassrooms.realestatemanager.databinding.FragmentDetailBinding;

public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;
    private SharedViewModel viewModel;
    private NavController navController;
    private PhotoAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =  FragmentDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        //viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        ViewModelFactory viewModelFactory = Injection.provideViewModelFactory(requireContext());
        viewModel = new ViewModelProvider(this, viewModelFactory).get(SharedViewModel.class);

        this.configureRecyclerView();

        viewModel.initDetailFragment().observe(getViewLifecycleOwner(), this::updateUI);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void updateUI(RealEstate realEstate) {
        //adapter.submitList(realEstate.getPhotos());
        binding.fragmentDetailDescription.setText(realEstate.getDescription());
        binding.fragmentDetailSurface.setText(realEstate.getSurface());
        binding.fragmentDetailRooms.setText(realEstate.getRooms());
        binding.fragmentDetailBathrooms.setText(realEstate.getBathrooms());
        binding.fragmentDetailBedrooms.setText(realEstate.getBedrooms());
        binding.fragmentDetailLocation.setText(realEstate.getAddress());
    }

    private void configureRecyclerView() {
        adapter = new PhotoAdapter(PhotoAdapter.DIFF_CALLBACK);
        binding.fragmentDetailMedia.setAdapter(adapter);
        binding.fragmentDetailMedia.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL));
    }
}