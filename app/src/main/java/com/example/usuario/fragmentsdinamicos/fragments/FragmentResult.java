package com.example.usuario.fragmentsdinamicos.fragments;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.usuario.fragmentsdinamicos.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentResult extends Fragment {


    @BindView(R.id.resultado)
    TextView resultado;
    Unbinder unbinder;
    final String keyReult="RESULT";

    public FragmentResult() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_result, container, false);
        unbinder = ButterKnife.bind(this, view);

        Bundle bundle= getArguments();
        if(bundle!=null)
        {
            String result=String.valueOf(bundle.getInt(keyReult));

            resultado.setText("El resultado es: "+result);
        }

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
