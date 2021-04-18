package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int gameState[] = {2,2,2,2,2,2,2,2,2};
    int winningPositions[][] = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    int activePlayer = 0;
    int w = 0;
    String message;

    public void pClick(View view) {

        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2 && w == 0) {
            counter.setTranslationY(-1500);
            gameState[tappedCounter] = activePlayer;

            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.o);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.x);
                activePlayer = 0;
            }
            counter.animate().translationYBy(1500).setDuration(10);

            for (int[] i : winningPositions) {
                if (gameState[i[0]] == 1 && gameState[i[1]] == 1 && gameState[i[2]] == 1) {
                    message = "Player 2 wins";
                    w = 1;
                    TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
                    winnerTextView.setText(message);
                    winnerTextView.setVisibility(View.VISIBLE);
                    Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
                    playAgainButton.setVisibility(View.VISIBLE);
                }
                else if (gameState[i[0]] == 0 && gameState[i[1]] == 0 && gameState[i[2]] == 0) {
                    message = "Player 1 wins";
                    w = 1;
                    TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
                    winnerTextView.setText(message);
                    winnerTextView.setVisibility(View.VISIBLE);
                    Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
                    playAgainButton.setVisibility(View.VISIBLE);
                }
            }
            int p = 0;
            for (int[] i : winningPositions) {
                if (gameState[i[0]] == 2 || gameState[i[1]] == 2 || gameState[i[2]] == 2) {
                    p = 1;
                }
            }
            if (p == 0 && w!= 1) {
                message = "Game draw";
                w = 1;
                TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
                winnerTextView.setText(message);
                winnerTextView.setVisibility(View.VISIBLE);
                Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
                playAgainButton.setVisibility(View.VISIBLE);
            }
        }
    }

    public void playAgain(View view) {
        activePlayer = 0;
        w = 0;

        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
        winnerTextView.setVisibility(View.INVISIBLE);
        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
        playAgainButton.setVisibility(View.INVISIBLE);

        /*GridLayout gridLayout = (GridLayout) findViewById(R.id.grid);
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            ImageView counter = (ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }*/

        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
    }

    /*public void firstClick(View clickedElement) {
        if(f==0){
            TextView tap = (TextView) findViewById(R.id.tap);
            tap.setVisibility(View.GONE);
            ImageView title = (ImageView) findViewById(R.id.gameTitle);
            title.setVisibility(View.GONE);
            clickedElement.setClickable(false);
            View grid = findViewById(R.id.grid);
            grid.setVisibility(View.VISIBLE);
            clickedElement.setBackgroundColor(Color.parseColor("#3E3D3D"));
            f++;
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*TextView tap = (TextView) findViewById(R.id.tap);
        ImageView title = (ImageView) findViewById(R.id.gameTitle);
        title.setX(-1000);
        title.animate().translationXBy(1000).setDuration(2000);
        tap.animate().alpha(1).setDuration(3000);
        int f = 0;*/
    }
}