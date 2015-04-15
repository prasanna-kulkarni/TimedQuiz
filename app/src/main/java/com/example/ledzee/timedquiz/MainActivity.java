package com.example.ledzee.timedquiz;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Random;
import  java.util.List;


public class MainActivity extends ActionBarActivity {
    QuestionnAnswers qa = new QuestionnAnswers();
    QnAData questionAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView question;
        Button trueButton;
        Button falseButton;
        final TextView timeRemaining;
        //QuestionnAnswers qa = new QuestionnAnswers();
        Random randomGenerator = new Random();
        final int randomNumber = randomGenerator.nextInt(qa.qdata.size());
        question = (TextView) findViewById(R.id.questionView);
        timeRemaining = (TextView) findViewById(R.id.timeRemaining);
        questionAnswer = qa.getQuestionAnswer();
        final CountDownTimer countDownTimer;



    if(questionAnswer!=null)

    {
        question.setText(questionAnswer.question);
        //question.setText(qaList.get(randomNumber).question);
    }

    trueButton=(Button)

    findViewById(R.id.trueButton);

    falseButton=(Button)

    findViewById(R.id.falseButton);


        //This timer is for the whole app as whole which will be used if needed
    new CountDownTimer(50000,1000) {
        //Log.v(MyTaG, "index=" + i);
        public void onFinish () {
            Intent gameOver = new Intent(MainActivity.this, WrongAnswerActivity.class);
            startActivity(gameOver);
            Log.d("OnclickTag", "Game over");
        }

    public void onTick(long millisUntilFinished) {
        timeRemaining.setText("seconds remaining: " + millisUntilFinished / 1000);;
    }
}.start();


        trueButton.setOnClickListener(new View.OnClickListener(){
@Override
public void onClick(View v){
        if(questionAnswer.answer==1)
        //if (qaList.get(randomNumber).answer == 1)
        {

        questionAnswer=qa.getQuestionAnswer();
        question.setText(questionAnswer.question);

//             CountDownTimer countDownTimer = new CountDownTimer(10000,1000) {
//                @Override
//                public void onTick(long millisUntilFinished) {
//
//                }
//
//                @Override
//                public void onFinish() {
//
//                    Intent gameover = new Intent(MainActivity.this, WrongAnswerActivity.class);
//                    startActivity(gameover);
//                    Log.d("OnclickTag", "Game over");
//                }
//            }.start();


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
        //if(qaList.get(randomNumber).answer == 0)
        {
        questionAnswer=qa.getQuestionAnswer();
        if(questionAnswer!=null)
        question.setText(questionAnswer.question);

            CountDownTimer countDownTimer = new CountDownTimer(10000,1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {

                    Intent gameover = new Intent(MainActivity.this, WrongAnswerActivity.class);
                    startActivity(gameover);
                    Log.d("OnclickTag", "Game over");
                }
            }.start();


                   /*Log.d("OnclickTag", "Onclick is working");
                   Intent startActivity2 = new Intent(MainActivity.this, SecondQuestion.class);
                   startActivity(startActivity2);*/
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
