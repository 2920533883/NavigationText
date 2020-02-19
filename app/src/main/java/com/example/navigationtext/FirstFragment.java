package com.example.navigationtext;


import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationtext.databinding.FragmentFirstBinding;
import com.example.navigationtext.databinding.FragmentSecondBinding;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    public FirstFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        MyViewModel myViewModel;
        myViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(MyViewModel.class);
        FragmentFirstBinding binding;
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false);
        binding.setData1(myViewModel);
        binding.setLifecycleOwner(getActivity());
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 导航控制
                NavController controller = Navigation.findNavController(v);
                // 导航
                controller.navigate(R.id.action_firstFragment_to_secondFragment);
            }
        });
        return binding.getRoot();
    }

}
