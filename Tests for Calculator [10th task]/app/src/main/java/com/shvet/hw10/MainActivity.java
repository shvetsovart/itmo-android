package com.shvet.hw10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextView workingsTV;
    TextView resultTV;
    ArrayList<String> operations = new ArrayList<>();

    String workings = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> operationsCreate = new ArrayList<>(
                Arrays.asList("+", "-", "*", "/", "^")
        );
        operations.addAll(operationsCreate);
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
    }

    private void initTextViews() {
        workingsTV = findViewById(R.id.workingsTextView);
        resultTV = findViewById(R.id.resultTextView);
    }

    private void setWorkings(String givenValue) {
        if (Objects.equals(workings, "0") && Objects.equals(givenValue, "0"))
            return;

        String lastChar = "-";
        if (workings.length() > 0) {
            lastChar = String.valueOf(workings.charAt(workingsTV.length() - 1));
        }
        if (!givenValue.equals("-") && operations.contains(givenValue) &&
                (workings.length() == 0 || lastChar.equals(givenValue)))
            return;

        workings = workings + givenValue;
        workingsTV.setText(workings);
    }

    public void equalsOnClick(View view) {
        equals();
    }

    private void equals() {
        try {
            ExpressionParser parser = new ExpressionParser();
            String stringExpression = parser.makeStringFromExpression(parser.parse(workings));
            resultTV.setText(stringExpression);
            workingsTV.setText(stringExpression);
            workings = stringExpression;
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