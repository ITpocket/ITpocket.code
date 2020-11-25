package org.techtown.a2a_2019202123;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ImageSelectionCallback{
    ChooseFragment chooseFragment;
    ViewFragment viewFragment;
    int[] images={R.drawable.main, R.drawable.su, R.drawable.nam, R.drawable.han};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        chooseFragment = (ChooseFragment) manager.findFragmentById(R.id.chooseFragment);
        viewFragment = (ViewFragment) manager.findFragmentById(R.id.viewFragment);
    }

    @Override
    public void onImageSection(int position) {
        viewFragment.setImage(images[position]);
    }

}
