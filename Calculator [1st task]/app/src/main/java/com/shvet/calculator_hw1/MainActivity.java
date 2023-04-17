package com.shvet.calculator_hw1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView workingsTV;
    TextView resultTV;

    String workings = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("CurrentWorkings", workings);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        workings = savedInstanceState.getString("CurrentWorkings");

        workingsTV.setText(workings);
        equals();
    }

    private void initTextViews() {
        workingsTV = findViewById(R.id.workingsTextView);
        resultTV = findViewById(R.id.resultTextView);
    }

    private void setWorkings(String givenValue) {
        workings = workings + givenValue;
        workingsTV.setText(workings);
    }

    public void equalsOnClick(View view) {
        try {
            equals();
        } catch (Exception e) {
            Toast myToast = Toast.makeText(this, "Not allowed format",
                    Toast.LENGTH_SHORT);
            clearOnClick(view);
            myToast.show();
        }
    }

    private void equals() {
        try {
            ExpressionParser parser = new ExpressionParser();
            Double result = parser.parse(workings).evaluate();
            if (result == (result.intValue())) {
                resultTV.setText(String.valueOf(result.intValue()));
            } else {
                String ans = new DecimalFormat("#0.00").format(result);
                resultTV.setText(String.valueOf(ans));
            }
        } catch (Exception e) {
            Toast myToast = Toast.makeText(this, "Not allowed format",
                    Toast.LENGTH_SHORT);
            clear();
            myToast.show();
        }
    }

    public void clearOnClick(View view) {
        clear();
    }

    private void clear() {
        workingsTV.setText("");
        workings = "";
        resultTV.setText("");
    }

    public void expOnClick(View view) {
        setWorkings("^");
    }

    public void divideOnClick(View view) {
        setWorkings("/");
    }

    public void sevenOnClick(View view) {
        setWorkings("7");
    }

    public void eightOnClick(View view) {
        setWorkings("8");
    }

    public void nineOnClick(View view) {
        setWorkings("9");
    }

    public void timesOnClick(View view) {
        setWorkings("X");
    }

    public void fourOnClick(View view) {
        setWorkings("4");
    }

    public void fiveOnClick(View view) {
        setWorkings("5");
    }

    public void sixOnClick(View view) {
        setWorkings("6");
    }

    public void minusOnClick(View view) {
        setWorkings("-");
    }

    public void oneOnClick(View view) {
        setWorkings("1");
    }

    public void twoOnClick(View view) {
        setWorkings("2");
    }

    public void threeOnClick(View view) {
        setWorkings("3");
    }

    public void plusOnClick(View view) {
        setWorkings("+");
    }

    public void dotOnClick(View view) {
        setWorkings(".");
    }

    public void zeroOnClick(View view) {
        setWorkings("0");
    }
}