package com.khoga.bmicalculator;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private float height;
    private float weight;
    private float BMI;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        Button compute_button = (Button) rootView.findViewById(R.id.compute_button);
        final EditText height_value = (EditText) rootView.findViewById(R.id.height);
        final EditText weight_value = (EditText) rootView.findViewById(R.id.weight);
        final TextView result = (TextView) rootView.findViewById(R.id.result);

        compute_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(height_value.getText().length()>0 && weight_value.getText().length()>0){
                    height = Float.parseFloat(height_value.getText().toString());
                    weight = Float.parseFloat(weight_value.getText().toString());
                    BMI = calculateBMI(weight,height);

                    if(BMI<16){
                        result.setText("Your BMI: "+BMI+" ( Severely Underweight ) ");
                    }

                    else if(BMI<18.5){
                        result.setText("Your BMI: "+BMI+" ( Underweight ) ");
                    }

                    else if(BMI<25){
                        result.setText("Your BMI: "+BMI+" ( Normal ) ");
                    }

                    else if(BMI<30){
                        result.setText("Your BMI: "+BMI+" ( Overweight ) ");
                    }

                    else {
                        result.setText("Your BMI: "+BMI+" ( Obese ) ");
                    }
                }
            }
        });


        return rootView;
    }

    private float calculateBMI(float weight, float height) {
        height=(height/100);
        return (weight/(height*height));
    }
}
