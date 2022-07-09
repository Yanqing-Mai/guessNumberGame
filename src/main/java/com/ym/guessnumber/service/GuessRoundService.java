package com.ym.guessnumber.service;

import com.ym.guessnumber.reqandres.GuessRequest;
import com.ym.guessnumber.reqandres.GuessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.Round;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuessRoundService {

    public GuessResponse guess(GuessRequest request){

        GuessResponse response = new GuessResponse();

        Round round = new Round();

        //Get the correct answer from database
        int correctAnswer = 1235;

        round.setResult(calculateResult(String.valueOf(correctAnswer), String.valueOf(request.getAnswer())));

        response.setRound(round);

        //insert round into database based on gameId
        

        return new GuessResponse();
    }

    public String calculateResult(String correctAnswer, String userAnswer) {

        //compare correct answer with user input answer
        List<Integer> correct = new ArrayList();
        List<Integer> user = new ArrayList();

        for (int i = 0; i < userAnswer.length(); i++){
            char cU = userAnswer.charAt(i);
            char cA = correctAnswer.charAt(i);
            user.add(cU-'0');
            correct.add(cA-'0');
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < correct.size(); i++){
            if (correct.get(i) == user.get(i)){
                result.append("E");
            }else{
                if (correct.contains(user.get(i))){
                    result.append("P");
                }else{
                    result.append("0");
                }
            }
            result.append(":");
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }
}
