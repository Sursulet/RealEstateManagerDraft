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

import com.openclassrooms.realestatemanager.databinding.FragmentMasterBinding;

public class MasterFragment extends Fragment implements RealEstateAdapter.OnItemClickListener {

    private FragmentMasterBinding binding;
    private SharedViewModel viewModel;
    private NavController navController;
    private RealEstateAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMasterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        ViewModelFactory viewModelFactory = Injection.provideViewModelFactory(requireContext());
        viewModel = new ViewModelProvider(this, viewModelFactory).get(SharedViewModel.class);

        navController = Navigation.findNavController(view);
        this.configureRecyclerView();

        viewModel.getMasterUiModelList().observe(getViewLifecycleOwner(), masterUiModel -> adapter.submitList(masterUiModel));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void configureRecyclerView() {
        adapter = new RealEstateAdapter(RealEstateAdapter.DIFF_CALLBACK, (RealEstateAdapter.OnItemClickListener) this);
        binding.fragmentMasterRecyclerview.setAdapter(adapter);
        binding.fragmentMasterRecyclerview.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onItemClick(int position) {
        viewModel.setRealEstate(position);
        navController.navigate(R.id.action_masterFragment_to_detailFragment);
    }
}