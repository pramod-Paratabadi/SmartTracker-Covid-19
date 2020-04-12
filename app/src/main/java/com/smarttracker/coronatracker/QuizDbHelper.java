package com.smarttracker.coronatracker;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.smarttracker.coronatracker.QuizContract.*;

import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyCoronaChecker.dp";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME );
        onCreate(db);
    }

    private void fillQuestionsTable(){
        Question q1 = new Question("Coronavirus will not affect us with the onset of summer","True","False", "Maybe true", 2);
        addQuestion(q1);
        Question q2 = new Question("Consumption of alcohol can protect you from coronavirus.","False","True", "Definitely True", 1);
        addQuestion(q2);
        Question q3 = new Question("Can Coronavirus be transmitted through mosquitoes and other insects ?","Yes","No", "Yes, my doctor said so", 2);
        addQuestion(q3);
        Question q4=new Question("You should wash your hands often with soap and water for at least 20 seconds as often as you can.","True","False","No idea",1);
        addQuestion(q4);
        Question q5 = new Question("Pnuemonia and other vaccines can provide protection from coronavirus.","False, there are no vaccines against coronavirus","Truth, these vaccines help", "Maight be true", 1);
        addQuestion(q5);
        Question q6 = new Question("Does Coronavirus only affects people who are old, and not the young ?","Yes, that is true","No, the new updated data is different", "No idea", 2);
        addQuestion(q6);
        Question q7=new Question("Fever, cough, and shortness of breath are some of the symptoms caused by the COVID-19 virus.","True","False","No idea",1);
        addQuestion(q7);
        Question q8=new Question("It is ok to come into contact with someone who is sick as long as they don't sneeze or cough on you.","True","False","No idea",2);
        addQuestion(q8);
        Question q9 = new Question("The Indian immune system is better than the west and thus Indians will survive COVID-19 infection better","Yes, Indians are immune","No, the virus affects everyone equally", "Might be true", 2);
        addQuestion(q9);
        Question q10 = new Question("Is there a possibility that a person who was infected and cured can get infected again ?","No, Absolutely no chance","Yes, they can get infected again", "No definite answer", 3);
        addQuestion(q10);
        Question q11=new Question("COVID-19, Novel Coronavirus, and 2019-nCoV all refer to the same infectious disease.","True","False","No idea",1);
        addQuestion(q11);



/*        Question q1 = new Question("A is correct", "A", "B", "C", 1);
        addQuestion(q1);
        Question q2 = new Question("B is correct", "A", "B", "C", 2);
        addQuestion(q2);
        Question q3 = new Question("C is correct", "A", "B", "C", 3);
        addQuestion(q3);
        Question q4 = new Question("A is correct again", "A", "B", "C", 1);
        addQuestion(q4);
        Question q5 = new Question("B is correct again", "A", "B", "C", 2);
        addQuestion(q5);*/
    }

    private void addQuestion(Question question){
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public List<Question> getAllQuestions(){
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if(c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while(c.moveToNext());
        }

        c.close();
        return questionList;
    }

}
