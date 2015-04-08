package com.example.ledzee.timedquiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ledzee on 3/31/15.
 */

public class QuestionnAnswers {
    //List<String> questions;
    //List<Integer> answers;
    List<QnAData> qdata;



    QuestionnAnswers() {
        //questions = new ArrayList<String>();
        //answers = new ArrayList<Integer>();
        qdata = new ArrayList<QnAData>();
        addQuestionsAnswers(qdata);
        //addAnswers(answers);
    }

    private void addQuestions(List<String> questions) {
        questions.add("Taj Mahal is in Bangladesh");
        questions.add("Mexico is in Europe");
        questions.add("Great wall of china is in London");
        questions.add("Earth is a planet");
        questions.add("There are 50 states in America");
        questions.add("USA was a british colony");
        questions.add("Canada is in north of USA");
    }

    private void addQuestionsAnswers(List<QnAData> qdata) {
        QnAData q1= new QnAData();
        q1.question = "Taj Mahal is in India";
        q1.answer = 1;
        qdata.add(q1);


        q1= new QnAData();
        q1.question = "Mexico is in Europe";
        q1.answer = 0;
        qdata.add(q1);

        q1= new QnAData();
        q1.question = "Great wall of china is in London";
        q1.answer = 0;
        qdata.add(q1);

        q1= new QnAData();
        q1.question = "Earth is a planet";
        q1.answer = 1;
        qdata.add(q1);

        q1= new QnAData();
        q1.question = "There are 50 states in America";
        q1.answer = 1;
        qdata.add(q1);

        q1= new QnAData();
        q1.question = "USA was a british colony";
        q1.answer = 1;
        qdata.add(q1);

        q1= new QnAData();
        q1.question = "Canada is in north of USA";
        q1.answer = 1;
        qdata.add(q1);


    }

    private void addAnswers(List<Integer> answers) {
        answers.add(0);
        answers.add(0);
        answers.add(0);
        answers.add(1);
        answers.add(1);
        answers.add(1);
        answers.add(1);
    }

//    public String getQuestion(int index){
//        if (index < questions.size())
//            return questions.get(index);
//        return "";
//    }
//
//    public int getAnswer(int index) {
//        if(index < answers.size())
//            return answers.get(index);
//        return -1;
//    }

    public QnAData getQuestionAnswer(){
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(qdata.size());
        if (randomNumber < qdata.size())
            return qdata.get(randomNumber);
        return null;
    }
}