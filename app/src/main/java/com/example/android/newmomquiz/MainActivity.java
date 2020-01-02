package com.example.android.newmomquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int score = 0;
    int percentage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Validates if all question's Options are checked when passed true
     * When passed false resets all the options to unchecked state
     * @param ToValidateChecked: boolean
     * @return int. Based on return value, onSubmitBtnClick function will perform activities
     */
    public int allQuestionsAttendedCheck(boolean ToValidateChecked) {
        int questionCounter = 0;
        EditText firstQAnswer = (EditText) findViewById(R.id.first_Question_EditText_view);
        RadioGroup r2 = (RadioGroup) findViewById(R.id.second_question_radio_group);
        RadioGroup r3 = (RadioGroup) findViewById(R.id.third_question_radio_group);
        CheckBox ans4_1 = (CheckBox) findViewById(R.id.one_week_check_box);
        CheckBox ans4_2 = (CheckBox) findViewById(R.id.seven_days_check_box);
        CheckBox ans4_3 = (CheckBox) findViewById(R.id.fourteen_days_check_box);
        RadioGroup r5 = (RadioGroup) findViewById(R.id.fifth_question_radio_group);
        RadioGroup r6 = (RadioGroup) findViewById(R.id.sixth_question_radio_group);
        RadioGroup r7 = (RadioGroup) findViewById(R.id.seventh_question_radio_group);
        RadioGroup r8 = (RadioGroup) findViewById(R.id.eighth_question_radio_group);
        RadioGroup r9 = (RadioGroup) findViewById(R.id.ninth_question_radio_group);
        RadioGroup r10 = (RadioGroup) findViewById(R.id.tenth_question_radio_group);
        if (ToValidateChecked) {
            if (!(firstQAnswer.getText().toString().isEmpty())) {
                questionCounter += 1;
            }
            if (!(r2.getCheckedRadioButtonId() == -1)) {
                questionCounter += 1;
            }
            if (!(r3.getCheckedRadioButtonId() == -1)) {
                questionCounter += 1;
            }
            if ((ans4_1.isChecked()) || (ans4_2.isChecked()) || (ans4_3.isChecked())) {
                questionCounter += 1;
            }
            if (!(r5.getCheckedRadioButtonId() == -1)) {
                questionCounter += 1;
            }
            if (!(r6.getCheckedRadioButtonId() == -1)) {
                questionCounter += 1;
            }
            if (!(r7.getCheckedRadioButtonId() == -1)) {
                questionCounter += 1;
            }
            if (!(r8.getCheckedRadioButtonId() == -1)) {
                questionCounter += 1;
            }
            if (!(r9.getCheckedRadioButtonId() == -1)) {
                questionCounter += 1;
            }
            if (!(r10.getCheckedRadioButtonId() == -1)) {
                questionCounter += 1;
            }
        } else {
            firstQAnswer.setText("");
            r2.clearCheck();
            r3.clearCheck();
            ans4_1.setChecked(false);
            ans4_2.setChecked(false);
            ans4_3.setChecked(false);
            r5.clearCheck();
            r6.clearCheck();
            r7.clearCheck();
            r8.clearCheck();
            r9.clearCheck();
            r10.clearCheck();
            clearName();
        }
        return questionCounter;
    }

    /**
     * calculates the score and updates the global variables - score & percentage
     */
    public void calculateScores() {
        score = 0;
        percentage = 0;
        EditText firstQAnswer = (EditText) findViewById(R.id.first_Question_EditText_view);
        RadioButton ans2 = (RadioButton) findViewById(R.id.three_second_radio_button);
        RadioButton ans3 = (RadioButton) findViewById(R.id.three_months_radio_button);
        CheckBox ans4_1 = (CheckBox) findViewById(R.id.one_week_check_box);
        CheckBox ans4_2 = (CheckBox) findViewById(R.id.seven_days_check_box);
        CheckBox ans4_3 = (CheckBox) findViewById(R.id.fourteen_days_check_box);
        RadioButton ans5 = (RadioButton) findViewById(R.id.hearing_radio_button);
        RadioButton ans6 = (RadioButton) findViewById(R.id.seven_and_half_k_radio_button);
        RadioButton ans7 = (RadioButton) findViewById(R.id.false_option_radio_button);
        RadioButton ans8 = (RadioButton) findViewById(R.id.three_to_four_percent_radio_button);
        RadioButton ans9 = (RadioButton) findViewById(R.id.five_hundred_times_radio_button);
        RadioButton ans10 = (RadioButton) findViewById(R.id.six_to_nine_radio_button);

        addScores(firstQAnswer);
        addScores(ans2);
        addScores(ans3);
        addScores(ans4_1, ans4_2, ans4_3);
        addScores(ans5);
        addScores(ans6);
        addScores(ans7);
        addScores(ans8);
        addScores(ans9);
        addScores(ans10);
        percentage = score * 10;

    }

    /**
     * Validates if a option is checked and adds the score based on outcome
     * @param rb - Radiobutton
     */
    private void addScores(RadioButton rb) {
        if (rb.isChecked()) {
            score = score + 1;
        }
    }

    /**
     * Validates if a option is checked and adds the score based on outcome
     * @param cb1 - first Checkbox option
     * @param cb2 - second checkbox option
     * @param cb3 - third checkbox option
     */
    private void addScores(CheckBox cb1, CheckBox cb2, CheckBox cb3) {
        if ((cb1.isChecked()) && (cb2.isChecked()) && (!cb3.isChecked())) {
            score = score + 1;
        }
    }

    /**
     * Adds scores by checking the content of the text box for first question.
     * @param edit_txt
     */
    private void addScores(EditText edit_txt) {
        if ((edit_txt.getText().toString().equalsIgnoreCase(getString(R.string.first_question_answer).trim()))) {
            score = score + 1;
        }
    }

    /**
     * returns the name which is entered by user
     * @return
     */
    public String getName() {
        EditText nameofCustomer = (EditText) findViewById(R.id.name_EditText_view);
        return nameofCustomer.getText().toString();
    }

    /**
     * clears the entered name. this function will be called, when reset button is pressed
     */
    private void clearName() {
        EditText nameofCustomer = (EditText) findViewById(R.id.name_EditText_view);
        nameofCustomer.setText("");
    }

    /**
     * This function will be called when Submit button is clicked. It checks if all questions are attended, and also checks if user entered the name. Based on the outcome it will either display the score to user or it will display message to user to update the missed ones
     * @param view
     */
    public void onSubmitBtnClick(View view) {
        if(!getName().isEmpty()){
        if (allQuestionsAttendedCheck(true) == 10) {
            calculateScores();
            displayToastMessage(getString(R.string.score_msg, percentage, getName()));
        } else {
            displayToastMessage(getString(R.string.attend_questions_msg));
        }
        }else{
            displayToastMessage(getString(R.string.enter_name_msg));
        }
    }

    /**
     * Displays Toast messages
     * @param message
     */
    public void displayToastMessage(String message) {

        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }

    /**
     * This function is called when Reset button is pressed. It resets all options to its original state and also displays a message to user
     * @param view - resetButton
     */
    public void resetAllOptions(View view) {
        score = 0;
        int questionCounter = allQuestionsAttendedCheck(false);
        if (questionCounter == 0) {
            displayToastMessage(getString(R.string.reset_msg));
        }
    }
}
