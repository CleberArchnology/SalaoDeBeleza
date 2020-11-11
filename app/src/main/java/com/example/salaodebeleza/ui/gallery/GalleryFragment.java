package com.example.salaodebeleza.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.salaodebeleza.ClienteDAO;
import com.example.salaodebeleza.ClienteDTO;
import com.example.salaodebeleza.R;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {
    Button buttonNovoCliente;
    ListView listViewCliente;
    ArrayList<ClienteDTO> arrayListCliente;
    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);

        buttonNovoCliente = root.findViewById(R.id.buttonNovoCliente);
        listViewCliente = root.findViewById(R.id.listViewCliente);
        ClienteDAO clienteDAO = new ClienteDAO(getActivity().getApplicationContext());
        arrayListCliente = clienteDAO.consultarTodos();
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1,arrayListCliente);
        listViewCliente.setAdapter(adapter);

        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}