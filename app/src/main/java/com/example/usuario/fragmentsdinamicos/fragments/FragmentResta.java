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


public class FragmentResta extends Fragment {


    View view;
    @BindView(R.id.etRes1)
    EditText etRes1;
    @BindView(R.id.etRes2)
    EditText etRes2;
    @BindView(R.id.btnRes)
    Button btnRes;
    Unbinder unbinder;
    int resultado;
    final String keyReult="RESULT";

    public FragmentResta() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fragment__resta, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btnRes)
    public void onViewClicked() {
        operacionResta();
        changeResultFragment(resultado);
    }

    public void operacionResta() {

        int numero1=Integer.parseInt(etRes1.getText().toString());
        int numero2=Integer.parseInt(etRes2.getText().toString());
        resultado=numero1-numero2;
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
