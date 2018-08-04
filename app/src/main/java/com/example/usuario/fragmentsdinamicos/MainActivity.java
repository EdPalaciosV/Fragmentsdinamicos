package com.example.usuario.fragmentsdinamicos;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.usuario.fragmentsdinamicos.fragments.FragmentMultiplicacion;
import com.example.usuario.fragmentsdinamicos.fragments.FragmentResta;
import com.example.usuario.fragmentsdinamicos.fragments.FragmentSuma;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnSumaActivity)
    Button btnSumaActivity;
    @BindView(R.id.btnRestaActivity)
    Button btnRestaActivity;
    @BindView(R.id.btnMultActivity)
    Button btnMultActivity;

    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btnSumaActivity, R.id.btnRestaActivity, R.id.btnMultActivity})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnSumaActivity:
                FragmentSuma fragmentSuma=new FragmentSuma();
                //getSupportFragmentManager().beginTransaction().add(R.id.viewFragment,fragmentSuma).commit();
                //

                transaction=getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_right,R.anim.enter_from_right,R.anim.exit_to_right);
                transaction.addToBackStack(null);
                transaction.replace(R.id.viewFragment, fragmentSuma);
                transaction.commit();
                break;
            case R.id.btnRestaActivity:

                FragmentResta fragmentResta=new FragmentResta();
                transaction=getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_right,R.anim.enter_from_right,R.anim.exit_to_right);
                transaction.addToBackStack(null);
                transaction.replace(R.id.viewFragment, fragmentResta);
                transaction.commit();

                break;
            case R.id.btnMultActivity:

                FragmentMultiplicacion fragmentMultiplicacion = new FragmentMultiplicacion();

                transaction=getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_right,R.anim.enter_from_right,R.anim.exit_to_right);
                transaction.addToBackStack(null);
                transaction.replace(R.id.viewFragment,fragmentMultiplicacion);
                transaction.commit();
                break;
        }
    }
}
