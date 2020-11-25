package org.techtown.a2a_2019202123;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ChooseFragment extends Fragment {
    ImageSelectionCallback callback;
    RadioGroup rdGroup;
   RadioButton rdBtn1, rdBtn2, rdBtn3, rdBtn4;

    Button btnOk;
    ViewGroup rootView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof ImageSelectionCallback){
            callback = (ImageSelectionCallback)context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = (ViewGroup)inflater.inflate(R.layout.fragment_choose,container,false);
        rdGroup = rootView.findViewById(R.id.rdGroup);
        rdBtn1 = rootView.findViewById(R.id.rdBtn1);
        rdBtn2 = rootView.findViewById(R.id.rdBtn2);
        rdBtn3 = rootView.findViewById(R.id.rdBtn3);
        rdBtn4 = rootView.findViewById(R.id.rdBtn4);
        btnOk = rootView.findViewById(R.id.btnOk);



        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rdBtn1.isChecked()) {
                    callback.onImageSection(0);
                }
                else if(rdBtn2.isChecked()) {
                    callback.onImageSection(1);
                }
                else if(rdBtn3.isChecked()) {
                    callback.onImageSection(2);
                }
                else{
                    callback.onImageSection(3);
                }
            }
        });

        return rootView;
    }
}




