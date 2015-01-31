package com.example.match_000.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    //creating variables
    TextView display; // for result bar
    String op;
    double num1;
    double num2;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //defining variables
        display = (TextView) findViewById(R.id.textView);
        display.setText("0"); // the result bar will have 0 in the beginning
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    boolean isEmpty = true; // variable to see if the result bar is empty. We start it as empty

    public void num_clicked(View sender)
    {
        Button bt = (Button) sender;

//        if(display.getText().length() > 15 ) // making sure the user can type only 15 numbers
//            return; // go out of this method, do nothing
        // if we dont have if, else, but just one code that says "display.append(bt.getText())", then, we will see 0 infront of numberd all the time

        if (isEmpty) {
            /*if (bt.getText().toString().equals("0")) // do not allow to add 0 the first time, ex: 0000
                return;*/
            display.setText(bt.getText());
            isEmpty = false;
        }
        else
            display.append(bt.getText());

        if (bt.getId() == R.id.reset) {
            display.setText("0"); // reset to 0
            isEmpty = true;
            result = 0.0;
        }

    }

    public void op_clicked(View sender)
    {
        num1 = Double.parseDouble(display.getText().toString());
        Button bt2 = (Button) sender;
        op = bt2.getText().toString();
        isEmpty = true; // preparing for the second operand*/

    }

   public void display_result(View sender)// = displays the result
    {
        String s = display.getText().toString();
        num2 = Double.parseDouble(s);

        if(op.equals("+"))
            result = num1+num2;
        else if(op.equals("_"))
            result = num1-num2;
        else if(op.equals("*"))
            result = num1*num2;
        else if(op.equals("/"))
        {
            if(num2 == 0)
            {
                display.setText("Can't divide by 0");
                return;
            }
            else
                result = num1/num2;

        }
        display.setText(""+result);
    }
}

