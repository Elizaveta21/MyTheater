package com.example.android.teentheater;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class ActivityOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        personFirstName = (EditText) findViewById(R.id.first_name);
        personSecondName = (EditText) findViewById(R.id.second_name);
        personPhone = (EditText) findViewById(R.id.tel);
        personMail = (EditText) findViewById(R.id.mail);
        checkBoxNotif = (CheckBox) findViewById(R.id.not);
        checkBoxShare = (CheckBox)findViewById(R.id.net);
        textView = (TextView)findViewById(R.id.inf);
        spinner = (Spinner) findViewById(R.id.perf);
    }

    int number_tic;
    boolean order = false;
    CheckBox checkBoxNotif;
    CheckBox checkBoxShare;
    private EditText personFirstName;
    private EditText personSecondName;
    private EditText personPhone;
    private EditText personMail;
    TextView textView;
    Spinner spinner;

    /**
     * Вызывается, когда жмём на кнопку увеличения количества.
     */
    public void increment(View view) {
        if (number_tic < 15) {
            number_tic++;
            display(number_tic);
        }
    }

    /**
     * Вызывается, когда жмём на кнопку уменьшения количества.
     */
    public void decrement(View view) {
        if (number_tic > 0) {
            number_tic--;
            display(number_tic);
        }
    }

    private void display(int number) {
        TextView countTextView = (TextView) findViewById(R.id.count);
        countTextView.setText("" + number);
    }

    public void click(View view) {
        order = true;
        String s1 = getString(R.string.text4);
        String s = getString(R.string.text2);
        final boolean ischeckBoxNotif = checkBoxNotif.isChecked();
        final boolean ischeckBoxShare = checkBoxShare.isChecked();
        int selected = spinner.getSelectedItemPosition();
        if (personFirstName.getText().toString() != "" && personSecondName.getText().toString() != ""
                && personPhone.getText().toString() != "" && personMail.getText().toString() != "" && selected != 0 && number_tic != 0) {
            if (ischeckBoxNotif)
                s += getString(R.string.text3);
            if (ischeckBoxShare){
                String s2 = getString(R.string.text5);
                if (selected == 1)
                    s2 += " " + getString(R.string.perf1)+ ".";
                if (selected == 2)
                    s2 += " " + getString(R.string.perf2) + ".";
                if (selected == 3)
                    s2 += " " + getString(R.string.perf3) + ".";
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, s2);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
            textView.setTextColor(Color.GRAY);
            textView.setText(s);
        }
        else{
            textView.setTextColor(Color.RED);
            textView.setText(s1);
        }
    }
}
