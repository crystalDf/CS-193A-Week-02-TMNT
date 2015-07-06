package com.star.tmnt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result = parent.getSelectedItem().toString();
                setResult(result);
                setImageView(result);
                setInfo(result);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setResult(String result) {
        TextView resultTextView = (TextView) findViewById(R.id.textView);
        resultTextView.setText("You chose " + result);
    }

    private void setImageView(String result) {
        String[] turtles = getResources().getStringArray(R.array.turtles);
        String[] images = getResources().getStringArray(R.array.images);
        for (int i = 0; i < turtles.length; i++) {
            if (turtles[i].equals(result)) {
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                imageView.setImageResource(getResources().getIdentifier(
                        images[i], "mipmap", getPackageName()));
            }
        }
    }

    private void setInfo(String result) {
        String[] turtles = getResources().getStringArray(R.array.turtles);
        String[] infos = getResources().getStringArray(R.array.infos);
        for (int i = 0; i < turtles.length; i++) {
            if (turtles[i].equals(result)) {
                TextView infoTextView = (TextView) findViewById(R.id.turtle_info);
                infoTextView.setText(getResources().getIdentifier(
                        infos[i], "string", getPackageName()));
            }
        }
    }

}
