package com.example.universityproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    Button btn_rock, btn_paper, btn_scissors;
    TextView score_txt, com_txt, player_txt;
    ImageView player_img, computer_img;
    int p_score=0, c_score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_paper = (Button) findViewById(R.id.btn_paper);
        btn_rock = (Button) findViewById(R.id.btn_rock);
        btn_scissors = (Button) findViewById(R.id.btn_scissors);
        player_img = (ImageView) findViewById(R.id.player_img);
        computer_img = (ImageView) findViewById(R.id.computer_img);
        player_txt = (TextView) findViewById(R.id.player_move_txt);
        com_txt = (TextView) findViewById(R.id.com_move_text);
        score_txt = (TextView) findViewById(R.id.score_txt);

        score_txt.setText(p_score + "-" + c_score);
    }


    public void playerSelection(View view) {

        int selection = 0;
        if (view.getId() == R.id.btn_paper) {
            selection = 1;
        }else if (view.getId() == R.id.btn_scissors) {
            selection = 2;
        }
        Choice playChoice = Choice.values()[selection];
        player_img.setImageResource(playChoice.getImage());
        player_txt.setText("Your move: " + playChoice.getName());

        // computer should make its choice
        Choice comChoice = computerSelection();
        computer_img.setImageResource(comChoice.getImage());
        com_txt.setText("Computer's move: " + comChoice.getName());

        // after player's and computer's selections we should determine the result
        displayResult(playChoice.getName(), comChoice.getName());

    }

    /**
     * Randomly picks one number from 0 to 2 which corresponds to
     * one of the available choices (rock, paper, scissor)
     * @return the selected choice (1 of our Choice Enums)
     */
    private Choice computerSelection() {
        Random r = new Random();
        int rand = r.nextInt(3);
        return Choice.values()[rand];
    }

    /**
     * --Determines which player should get the point
     * --Updates the current score
     * @param pl player's choice name
     * @param com computer's choice name
     */
    private void displayResult(String pl , String com) {
       String msg = "";
        if (pl == com) {
            msg = "Draw";
        }else if ((pl == Choice.ROCK.getName() && com == Choice.SCISSOR.getName())
                || (pl == Choice.PAPER.getName() && com ==Choice.ROCK.getName()) ||
                (pl == Choice.SCISSOR.getName() && com == Choice.PAPER.getName()) ){
            p_score++;
            msg = "You win!";
        } else {
            c_score++;
            msg = "You lost!";

        }

        score_txt.setText(p_score + "-" + c_score);
        Toast.makeText(MainActivity.this,  msg, Toast.LENGTH_SHORT).show();
    }



}
