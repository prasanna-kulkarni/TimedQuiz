package com.example.ledzee.timedquiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by ledzee on 3/31/15.
 */

public class QuestionnAnswers {

    List<QnADataClass> qdata;
    List<QnADataClass> combination;


    QuestionnAnswers() {
        //questions = new ArrayList<String>();
        //answers = new ArrayList<Integer>();
        qdata = new ArrayList<QnADataClass>();
        combination = new ArrayList<QnADataClass>();
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

    private void addQuestionsAnswers(List<QnADataClass> qdata) {
        QnADataClass q1= new QnADataClass();
        q1.question = "Taj Mahal is in India";
        q1.answer = 1;
        q1.level = 1;
        q1.questionid =1;
        qdata.add(q1);


        q1= new QnADataClass();
        q1.question = "Mexico is in Europe";
        q1.answer = 0;
        q1.questionid =2;
        q1.level = 1;

        qdata.add(q1);

        q1= new QnADataClass();
        q1.question = "Great wall of china is in London";
        q1.answer = 0;
        q1.level = 1;
        q1.questionid =3;
        qdata.add(q1);

        q1= new QnADataClass();
        q1.question = "Earth is a planet";
        q1.answer = 1;
        q1.level = 2;
        q1.questionid =4;
        qdata.add(q1);

        q1= new QnADataClass();
        q1.question = "There are 50 states in America";
        q1.answer = 1;
        q1.level = 2;
        q1.questionid =5;
        qdata.add(q1);

        q1= new QnADataClass();
        q1.question = "USA was a british colony";
        q1.answer = 1;
        q1.level = 2;
        q1.questionid =6;
        qdata.add(q1);

        q1= new QnADataClass();
        q1.question = "Canada is in north of USA";
        q1.answer = 1;
        q1.level = 1;
        q1.questionid =7;
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

    public QnADataClass getQuestionAnswer(){
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(qdata.size());

       // if (randomNumber < qdata.size())
         //   return qdata.get(randomNumber);
        return pick(randomGenerator);
    }
    private void shuffle(Random randomGenerator) {
        Collections.shuffle(qdata, randomGenerator);
        combination.addAll(qdata.subList(0,1));
    }

    private QnADataClass pick(Random randomGenerator) {
        int randomNumber = 0;
        for (int i = 0; i < 1; i++) {
            randomNumber = 0;
            do {
                randomNumber = randomGenerator.nextInt(qdata.size());
            } while (combination.contains(qdata.get(randomNumber)));
            combination.add(qdata.get(randomNumber));
        }
        return qdata.get(randomNumber);
    }

}