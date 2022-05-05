package com.example.again;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    int numDucks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }//End onCreate

    public void upClick (View v)
    {
        Toast.makeText(this, "You clicked the up button!", Toast.LENGTH_SHORT).show();
        numDucks++;
        updateTextView();
    }//End up count button handler

    public void downClick (View v)
    {
        Toast.makeText(this, "You clicked the up button!", Toast.LENGTH_SHORT).show();
        numDucks--;
        updateTextView();
    }//End down count button handler

    public void openDialog (View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Confirm reset count");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick (DialogInterface dialog, int which)
            {
                Toast.makeText(MainActivity.this, "YESSSIREEE", Toast.LENGTH_SHORT).show();
                numDucks = 0;
                //Need to update text again
                updateTextView();
            }//End onClick overridden method
        });//End set positive or "Yes" button handler

        builder.setNegativeButton("No way Jose!", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int which)
            {
                //Method is empty because all it needs to do is close the dialog
            }//End onClick
        });//End set negative button or "No" button handler

        AlertDialog resetDialog = builder.create();
        resetDialog.show();
    }//End open reset dialog handler

    public void updateTextView ()
    {
        TextView countTextView = (TextView) findViewById(R.id.countableView);
        countTextView.setText("Number of CrownDucks: " + numDucks);
    }
}//End class mainActivity