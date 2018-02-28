package com.example.android.rendelesapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.NodeList;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int totalAmount=0;
    int partAmount=0;
    String []idk={"ar1","ar2"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increaseButton(View view) {

        Button btn= (Button) view;
        LinearLayout parent= (LinearLayout) btn.getParent();
        int size=parent.getChildCount();
String a="";
        View []views =new View[size];
        for (int i = 0; i <size ; i++) {
            views[i]=parent.getChildAt(i);
            a+=views[i].toString();
        }
        int ez=views[1].getId();
                displayPrice("alma"+ez);

    }

    public void decreaseButton(View view) {
//       Activity a=this.getParent();
//       displayPrice(a.toString());
        displayPrice("körte");

    }

    private void displayPrice(String partAmount){
        TextView priceTextView=(TextView)findViewById(R.id.vegsoAr);
        priceTextView.setText(partAmount);
    }


}
