package com.example.usuario.fragmentsdinamicos.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.usuario.fragmentsdinamicos.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSuma extends Fragment {


    @BindView(R.id.etSum1)
    EditText etSum1;
    @BindView(R.id.etSum2)
    EditText etSum2;
    @BindView(R.id.btnSum)
    Button btnSum;

    Unbinder unbinder;

    final String keyReult="RESULT";
    int resultado;



    public FragmentSuma() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_suma, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btnSum)
    public void onViewClicked() {

        operacionSuma();
        changeResultFragment(resultado);
    }

    public void operacionSuma() {
        int numero1=Integer.parseInt(etSum1.getText().toString());
        int numero2=Integer.parseInt(etSum2.getText().toString());
        resultado=numero1+numero2;
    }
    public void changeResultFragment(int resultado)
    {
        FragmentTransaction transaction;

        Bundle bundle= new Bundle();
        bundle.putInt(keyReult,resultado);

        FragmentResult fragmentRusultado=new FragmentResult();
        fragmentRusultado.setArguments(bundle);

        transaction=getActivity().getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_right,R.anim.enter_from_right,R.anim.exit_to_right);
        transaction.addToBackStack(null);
        transaction.replace(R.id.viewFragment,fragmentRusultado);
        transaction.commit();
    }
}
