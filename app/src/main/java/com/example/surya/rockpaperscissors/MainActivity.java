package com.example.surya.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random rand = new Random();

    int winCounter = 0;
    int lossCounter = 0;
    int tieCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnRock = (Button)findViewById(R.id.btnRock);
        final Button btnPaper = (Button)findViewById(R.id.btnPaper);
        final Button btnScissors = (Button)findViewById(R.id.btnScissors);
        final TextView lblMessage = (TextView)findViewById(R.id.lblMessage);
        btnRock.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v)
            {

                lblMessage.setText("You chose rock.");
                int compChoice = generate();
                switch(compChoice)
                {

                    case 1: lblMessage.setText(lblMessage.getText() + "\nThe CPU chose rock."); break;
                    case 2: lblMessage.setText(lblMessage.getText() + "\nThe CPU chose paper."); break;
                    case 3: lblMessage.setText(lblMessage.getText() + "\nThe CPU chose scissors."); break;

                }
                int winLoseTie = evaluateWin(1, compChoice);
                switch (winLoseTie)
                {

                    case 1: lblMessage.setText(lblMessage.getText() + "\nYou won!"); break;
                    case 2: lblMessage.setText(lblMessage.getText() + "\nYou lost."); break;
                    case 3: lblMessage.setText(lblMessage.getText() + "\nIt's a tie."); break;

                }

                lblMessage.setText(lblMessage.getText() + "\nYour record is: " + winCounter + "-" + lossCounter + "-" + tieCounter);

            }

        });

        btnPaper.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v)
            {

                lblMessage.setText("You chose paper.");
                int compChoice = generate();
                switch(compChoice)
                {

                    case 1: lblMessage.setText(lblMessage.getText() + "\nThe CPU chose rock."); break;
                    case 2: lblMessage.setText(lblMessage.getText() + "\nThe CPU chose paper."); break;
                    case 3: lblMessage.setText(lblMessage.getText() + "\nThe CPU chose scissors."); break;

                }
                int winLoseTie = evaluateWin(2, compChoice);
                switch (winLoseTie)
                {

                    case 1: lblMessage.setText(lblMessage.getText() + "\nYou won!"); break;
                    case 2: lblMessage.setText(lblMessage.getText() + "\nYou lost."); break;
                    case 3: lblMessage.setText(lblMessage.getText() + "\nIt's a tie."); break;

                }

                lblMessage.setText(lblMessage.getText() + "\nYour record is: " + winCounter + "-" + lossCounter + "-" + tieCounter);

            }

        });

        btnScissors.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v)
            {

                lblMessage.setText("You chose scissors.");
                int compChoice = generate();
                switch(compChoice)
                {

                    case 1: lblMessage.setText(lblMessage.getText() + "\nThe CPU chose rock."); break;
                    case 2: lblMessage.setText(lblMessage.getText() + "\nThe CPU chose paper."); break;
                    case 3: lblMessage.setText(lblMessage.getText() + "\nThe CPU chose scissors."); break;

                }
                int winLoseTie = evaluateWin(3, compChoice);
                switch (winLoseTie)
                {

                    case 1: lblMessage.setText(lblMessage.getText() + "\nYou won!"); break;
                    case 2: lblMessage.setText(lblMessage.getText() + "\nYou lost."); break;
                    case 3: lblMessage.setText(lblMessage.getText() + "\nIt's a tie."); break;

                }

                lblMessage.setText(lblMessage.getText() + "\nYour record is: " + winCounter + "-" + lossCounter + "-" + tieCounter);

            }

        });

    }

    private int generate()
    {

        return rand.nextInt(3) + 1;

    }

    private int evaluateWin(int userChoice, int compChoice)
    {

        if (userChoice == 1)
        {

            switch(compChoice)
            {

                case 1: tieCounter++; return 3;
                case 2: lossCounter++; return 2;
                case 3: winCounter++; return 1;

            }

        }

        else if (userChoice == 2)
        {

            switch(compChoice)
            {

                case 1: winCounter++; return 1;
                case 2: tieCounter++; return 3;
                case 3: lossCounter++; return 2;

            }

        }

        else
        {

            switch(compChoice)
            {

                case 1: lossCounter++; return 2;
                case 2: winCounter++; return 1;
                case 3: tieCounter++; return 3;

            }

        }

        return 3;

    }

}