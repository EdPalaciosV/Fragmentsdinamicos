package com.example.usuario.fragmentsdinamicos.fragments;

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

public class FragmentMultiplicacion extends Fragment {


    @BindView(R.id.etMult1)
    EditText etMult1;
    @BindView(R.id.etMult2)
    EditText etMult2;
    @BindView(R.id.btnMult)
    Button btnMult;
    Unbinder unbinder;
    int resultado;
    final String keyReult="RESULT";

    public FragmentMultiplicacion() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment__multiplicacion, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btnMult)
    public void onViewClicked() {
        operacionMultiplicacion();
        changeResultFragment(resultado);
    }

    public void operacionMultiplicacion() {

        int numero1=Integer.parseInt(etMult1.getText().toString());
        int numero2=Integer.parseInt(etMult2.getText().toString());
        resultado=numero1*numero2;


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
