package com.example.ledzee.timedquiz;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;
    QuestionnAnswers qa = new QuestionnAnswers();
    QnADataClass questionAnswer;
    int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView question;
        TextView lvlview;
        Button trueButton;
        Button falseButton;
        final TextView timeRemaining;
//        Random randomGenerator = new Random();
//        final int randomNumber = randomGenerator.nextInt(qa.qdata.size());
        question = (TextView) findViewById(R.id.questionView);
        timeRemaining = (TextView) findViewById(R.id.timeRemaining);
        questionAnswer = qa.getQuestionAnswer();

        trueButton=(Button) findViewById(R.id.trueButton);
        falseButton=(Button) findViewById(R.id.falseButton);
        lvlview = (TextView) findViewById(R.id.lvlTextView);


        lvlview.setText("Lvl: " + questionAnswer.level);

    if(questionAnswer!=null)
    {
        question.setText(questionAnswer.question);
        counter++;
    }

        //This timer is for the MainActivity
    new CountDownTimer(50000,1000) {

        public void onFinish () {
            Intent gameOver = new Intent(MainActivity.this, WrongAnswerActivity.class);
            startActivity(gameOver);
            Log.d("OnclickTag", "Game over");
        }

    public void onTick(long millisUntilFinished) {
        timeRemaining.setText("Beats remaining: " + millisUntilFinished / 1000);;
    }
 }.start();


        trueButton.setOnClickListener(new View.OnClickListener(){
@Override
public void onClick(View v){
        if(questionAnswer.answer==1)
        //if (qaList.get(randomNumber).answer == 1)
        {

            if (counter==qa.qdata.size())
            {Intent youDidIt = new Intent(MainActivity.this, YouDidIt.class);
                startActivity(youDidIt);}

            else
            {
                questionAnswer=qa.getQuestionAnswer();
                question.setText(questionAnswer.question);
                counter++;
                Log.d("counterTag","counter:" + counter);
            }

        }
        else
        {

        Intent gameover=new Intent(MainActivity.this,WrongAnswerActivity.class);
        startActivity(gameover);
        Log.d("OnclickTag","Game over");
        }


        }
        });

        falseButton.setOnClickListener(new View.OnClickListener(){
@Override
public void onClick(View v){

        if(questionAnswer.answer==0)
        {

            if (counter==qa.qdata.size())
            {Intent youDidIt = new Intent(MainActivity.this, YouDidIt.class);
                startActivity(youDidIt);}
            else
            {
                questionAnswer=qa.getQuestionAnswer();
                question.setText(questionAnswer.question);
                counter++;
                Log.d("counterTag","counter:" + counter);

            }


        }

        else
        {
        Intent gameover=new Intent(MainActivity.this,WrongAnswerActivity.class);
        startActivity(gameover);
        Log.d("OnclickTag","Game over");
        }

        }
        });
        }
        }
