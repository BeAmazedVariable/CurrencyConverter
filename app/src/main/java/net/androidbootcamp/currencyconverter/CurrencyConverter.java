package net.androidbootcamp.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CurrencyConverter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);
        //Display the Action Bar Icon
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //Initiate instance of an object of the layout file
        final EditText cad= findViewById(R.id.txtCad);
        final Spinner country= findViewById(R.id.spnCountries);
        Button convert= findViewById(R.id.btnConvert);
        final ImageView canada = findViewById(R.id.imgConverted);
        final ImageView selectedCountry = findViewById(R.id.imgResult);
        final TextView converted= findViewById(R.id.txtConverted);
        final TextView result= findViewById(R.id.txtResult);


        //Make actions when the user clicks the button
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Declare constant variable for the convert rate and currency unit with appropriate countries
                final double cadToUsd = 0.772642;
                final double cadToEur = 0.672080;
                final double cadToInr = 57.4085;
                final double cadToVnd = 18064.17;
                final String canadaUnit = "CAD";
                final String usaUnit = "USD";
                final String europeUnit = "EUR";
                final String indianUnit = "INR";
                final String vietnamUnit = "VND";

                //Declare variable to collect user input in CAD and the country has been selected to calculate the selected country currency
                double cadAmount;
                double convertResult = 0;
                int countryChoice;
                String countryUnit = "";



                //Collect the amount of money that the user has entered and the country that has been selected
                cadAmount= Double.parseDouble(cad.getText().toString());
                countryChoice=country.getSelectedItemPosition();

                //Decision making statement to make sure the user input lower than $100000
                if (cadAmount <100000)
                {
                    //Decision making statements decide which convert rate and image should be use to calculate and indicate the appropriate amount money in the selected country
                    switch(countryChoice)
                    {
                        case 0:
                            convertResult = cadAmount * cadToUsd;
                            selectedCountry.setImageResource(R.drawable.usa);
                            countryUnit = usaUnit;
                            break;
                        case 1:
                            convertResult = cadAmount * cadToEur;
                            selectedCountry.setImageResource(R.drawable.europe);
                            countryUnit = europeUnit;
                            break;
                        case 2:
                            convertResult = cadAmount * cadToInr;
                            selectedCountry.setImageResource(R.drawable.indian);
                            countryUnit = indianUnit;
                            break;
                        case 3:
                            convertResult = cadAmount * cadToVnd;
                            selectedCountry.setImageResource(R.drawable.vietnam);
                            countryUnit = vietnamUnit;
                            break;
                    }
                }
                else
                {
                    //Make a toast notification when the user input more than $100,000
                    Toast.makeText(CurrencyConverter.this,"We can't convert more than $100,000CAD",Toast.LENGTH_LONG).show();
                }

                //Declare an output format for the output
                DecimalFormat currency =new DecimalFormat("###,###.##");

                //Indicate the appropriate currency in the selected country
                canada.setImageResource(R.drawable.canada);
                converted.setText(currency.format(cadAmount) + " " + canadaUnit + "           =");
                result.setText(currency.format(convertResult) + " " + countryUnit);
            }
        });





    }
}
