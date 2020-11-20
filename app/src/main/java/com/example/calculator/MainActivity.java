package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private double currentBillTotal;//סכום החיוב
    private int currentCustomPercent;//הטיפ שבוחר הלקוח בעזרת פקד ה Seek Bar
    private EditText bill;

    //private EditText tt;

    private TextView tip10EditText;
    private TextView total10EditText;
    private TextView tip15EditText;
    private TextView total15EditText;
    private TextView tip20EditText;
    private TextView total20EditText;

    private SeekBar costumeSeekBar;
    private TextView costumPercent;
    private TextView costumeTip;
    private TextView costumeTotal;


    //private EditText bill;
    //private EditText bill;
    private SeekBar customSeekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tip10EditText=findViewById(R.id.try);
        //tip10EditText=findViewById(R.id.editText);
        tip10EditText= findViewById(R.id.textView6);
        total10EditText = findViewById(R.id.textView10);
        tip15EditText= findViewById(R.id.textView7);
        total15EditText = findViewById(R.id.textView11);
        tip20EditText= findViewById(R.id.textView8);
        total20EditText = findViewById(R.id.textView12);

        costumPercent = findViewById(R.id.textView14);

        costumeSeekBar = findViewById(R.id.costumeSeekBar);
        costumeSeekBar.setOnSeekBarChangeListener(customSeekBarListener);

        costumeTip= findViewById(R.id.textView16);
        costumeTotal = findViewById(R.id.textView18);

        bill = findViewById(R.id.billTotal);
        bill.addTextChangedListener(billEditTextWatcher);
        //=    findViewById(R.id.textView1);
        //currentBillTotal = Double.parseDouble(bill.toString());
       //------no need this tip10EditText.setT`ext(bill);
       // updateStandard();
    }

    private void updateStandard(){

       tip10EditText.setText(String.format("%.02f", currentBillTotal*0.1));
       total10EditText.setText(String.format("%.02f", currentBillTotal + (currentBillTotal*0.1) ));

       tip15EditText.setText(String.format("%.02f", currentBillTotal*0.15));
       total15EditText.setText(String.format("%.02f", currentBillTotal + (currentBillTotal*0.15) ));

       tip20EditText.setText(String.format("%.02f", currentBillTotal*0.2));
       total20EditText.setText(String.format("%.02f", currentBillTotal + (currentBillTotal*0.2) ));

    }
    private void updateCustom(){
        costumPercent.setText(currentCustomPercent+ "%");
        double costumTipAmount = currentBillTotal * currentCustomPercent*.01;
        double costumTotalAmount = currentBillTotal + costumTipAmount;

        costumeTip.setText(String.format("%.02f", costumTipAmount));
        costumeTotal.setText(String.format("%.02f", costumTotalAmount));
    }



    private TextWatcher billEditTextWatcher = new TextWatcher() {
        //@Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                currentBillTotal = Double.parseDouble(s.toString());
            }//end try
            catch (NumberFormatException e) {
                currentBillTotal = 0.0;
            }
            updateStandard();
        }
        public void beforeTextChanged(CharSequence s, int start, int before, int count) {

        }
        //@Override
        public void afterTextChanged(Editable s) {

        }
    };
    private SeekBar.OnSeekBarChangeListener customSeekBarListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            currentCustomPercent = seekBar.getProgress();
            updateCustom();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

}