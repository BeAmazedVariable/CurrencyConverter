package net.androidbootcamp.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CurrencyConverter extends AppCompatActivity {
    double cadToUsd = 0.772642;
    double cadToEur = 0.672080;
    double cadToInr = 57.4085;
    double cadToVnd = 18064.17;
    double cadAmount;
    double convertResult;
    int countryChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);

        final EditText cad= findViewById(R.id.txtCad);
        final Spinner country= findViewById(R.id.spnCountries);
        Button convert= findViewById(R.id.btnConvert);
        final TextView result= findViewById(R.id.txtResult);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadAmount= Double.parseDouble(cad.getText().toString());

                countryChoice=country.getSelectedItemPosition();

                switch(countryChoice)
                {
                    case 0:
                        convertResult = cadAmount * cadToUsd;
                        break;
                    case 1:
                        convertResult = cadAmount * cadToEur;
                        break;
                    case 2:
                        convertResult = cadAmount * cadToInr;
                        break;
                    case 3:
                        convertResult = cadAmount * cadToVnd;
                        break;
                }
                DecimalFormat currency =new DecimalFormat("$###,###.##");

                result.setText(currency.format(cadAmount) + " equals to " + currency.format(convertResult));
            }
        });





    }
}
