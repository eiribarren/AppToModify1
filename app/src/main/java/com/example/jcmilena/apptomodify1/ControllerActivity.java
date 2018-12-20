package com.example.jcmilena.apptomodify1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ControllerActivity extends AppCompatActivity implements EasyFragment.EasyFragmentInterface {

    String fragment_number = "1";
    int fragment_color = R.color.colorFragment1;
    int fragment_container = R.id.fragment_container1;
    String fragment_tag = "Frag1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ( savedInstanceState != null ) {
            fragment_number = savedInstanceState.getString("fragment_number", "1");
            fragment_color = savedInstanceState.getInt("fragment_color", R.color.colorFragment1);
            fragment_container = savedInstanceState.getInt("fragment_container", R.id.fragment_container1);
            fragment_tag = savedInstanceState.getString("fragment_tag", "Frag1");
        }
        setContentView(R.layout.activity_controller);

        FragmentManager fm = getSupportFragmentManager();
        EasyFragment fragment = EasyFragment.newInstance(fragment_number, fragment_color);
        fm.beginTransaction().replace(fragment_container, fragment, fragment_tag).commit();

    }

    @Override
    public void pulsado(String numero) {
        FragmentManager fm = getSupportFragmentManager();
        if(numero.equalsIgnoreCase("1")){
            Fragment fragmentToRemove = fm.findFragmentByTag("Frag1");
            fm.beginTransaction().remove(fragmentToRemove).commit();

            fragment_number = "2";
            fragment_color = R.color.colorFragment2;
            fragment_container = R.id.fragment_container2;
            fragment_tag = "Frag2";
        }
        else{
            Fragment fragmentToRemove = fm.findFragmentByTag("Frag2");
            fm.beginTransaction().remove(fragmentToRemove).commit();

            fragment_number = "1";
            fragment_color = R.color.colorFragment1;
            fragment_container = R.id.fragment_container1;
            fragment_tag = "Frag1";
        }
        EasyFragment fragment = EasyFragment.newInstance(fragment_number, fragment_color);
        fm.beginTransaction().add(fragment_container, fragment, fragment_tag).commit();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("fragment_number", fragment_number);
        outState.putInt("fragment_color", fragment_color);
        outState.putInt("fragment_container", fragment_container);
        outState.putString("fragment_tag", fragment_tag);
        super.onSaveInstanceState(outState);
    }

}
