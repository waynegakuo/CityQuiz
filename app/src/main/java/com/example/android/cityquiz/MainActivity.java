package com.example.android.cityquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //initializing scores
    int score;
    int score1;
    int score2;
    int score3;
    int score4;
    int score5;
    int score6;
    int score7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    Responds to a "Submit" button event for after submitting answers provided by user
     */
    public void submitQuiz(View view) {
        //checks if user chose Mombasa and Malindi
        CheckBox msaCheckBox = (CheckBox) findViewById(R.id.q3c2);
        CheckBox mldCheckBox = (CheckBox) findViewById(R.id.q3c4);

        //asks for user input
        EditText edit = (EditText) findViewById(R.id.user_input); //labels the edit text
        String ans = edit.getText().toString(); //stores the user input

        //true or false of the checkboxes have been checked
        boolean msaChecked = msaCheckBox.isChecked();
        boolean mldChecked = mldCheckBox.isChecked();

        if (msaChecked && mldChecked == true) {
            score3 = 1;
        } else {
            score3 = 0;
        }

        if (ans.equalsIgnoreCase("Kogelo") || ans.equalsIgnoreCase("Kogalo") ) {
            score7 = 1;
        } else {
            score7 = 0;
        }

        //updates general score
        score = score1 + score2 + score3 + score4 + score5 + score6 + score7;

        //Displays score of the quiz using toast
        if (score == 4 || score == 5 || score == 6) {
            Toast.makeText(this, "Final Score is: " + score + " out of 7 \n Congratulations for making it this far!", Toast.LENGTH_LONG).show();
        }
        if (score == 7) {
            Toast.makeText(this, "Final Score is: " + score + " out of 7 \n Congratulations for getting all the questions correct!", Toast.LENGTH_LONG).show();
        } else if (score < 4) {
            Toast.makeText(this, "Final Score is: " + score + " out of 7\n Try again!", Toast.LENGTH_LONG).show();
        }

    }

    /*
    Checks when radio buttons are clicked and updates scores
     */
    public void onRadioButtonClicked(View view) {
        boolean isIncremented=false; //boolean that keeps track of whether user has tapped button once
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {

            // Qn 1
            case R.id.q1c1:
                if (checked && !isIncremented)
                    score1 = 1;
                    isIncremented=!isIncremented;
                break;

            case R.id.q1c2:
                if (checked)
                    score1 = 0;
                break;

            case R.id.q1c3:
                if (checked)
                    score1 = 0;
                break;

            case R.id.q1c4:
                if (checked)
                    score = 0;
                break;

            //Qn 2
            case R.id.q2c1:
                if (checked)
                    score2 = 0;
                break;

            case R.id.q2c2:
                if (checked)
                    score2 = 0;
                break;

            case R.id.q2c3:
                if (checked)
                    score2 = 0;
                break;

            case R.id.q2c4:
                if (checked && !isIncremented )
                    score2 = 1;
                    isIncremented=!isIncremented;
                break;


            //Question 4
            case R.id.q4c1:
                if (checked)
                    score4 = 0;
                break;

            case R.id.q4c2:
                if (checked)
                    score4 = 0;
                break;

            case R.id.q4c3:
                if (checked && !isIncremented)
                    score4 = 1;
                    isIncremented=!isIncremented;
                break;

            case R.id.q4c4:
                if (checked)
                    score4 = 0;
                break;


            //Question 5
            case R.id.q5c1:
                if (checked)
                    score5 = 0;
                break;

            case R.id.q5c2:
                if (checked)
                    score5 = 0;
                break;

            case R.id.q5c3:
                if (checked)
                    score5 = 0;
                break;

            case R.id.q5c4:
                if (checked && !isIncremented)
                    score5 += 1;
                    isIncremented=!isIncremented;
                break;
            //End of question 5

            //Question 6
            case R.id.q6c1:
                if (checked && !isIncremented)
                    score6 = 1;
                    isIncremented=!isIncremented;
                break;

            case R.id.q6c2:
                if (checked)
                    score6 = 0;
                break;

            case R.id.q6c3:
                if (checked)
                    score6 = 0;
                break;

            case R.id.q6c4:
                if (checked)
                    score6 = 0;
                break;

        }
    }

    /*
    Handles revealing of answers upon clicked by user
     */
    public void showAnswers(View view) {
        String answers = "Answers: ";
        answers += "\n1. Mombasa ";
        answers += "\n2. Nairobi ";
        answers += "\n3. Mombasa & Malindi ";
        answers += "\n4. Kakamega";
        answers += "\n5. Eldoret";
        answers += "\n6. Kisumu";
        answers += "\n7. Kogelo or Kogalo";
        displayAnswers(answers);
    }

    /*
    Sets messages passed through the method to be displayed on a TextView
     */
    private void displayAnswers(String msg) {
        TextView answersTextView = (TextView) findViewById(R.id.ans_reveal_text_view);
        answersTextView.setText("" + msg);
    }
}
