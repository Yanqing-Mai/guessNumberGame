package com.ym.guessnumber.service;

import com.ym.guessnumber.jdbc.GamesDataBase;
import com.ym.guessnumber.repository.Game;
import com.ym.guessnumber.reqandres.BeginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StartGameService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    GamesDataBase gamesDataBase;
    public BeginResponse generatedMessage(){
        BeginResponse response = new BeginResponse();
        response.setMessage("CREATED");

        //insert this into database
        Game game = new Game();
        game.setAnswer(generateAnswer());
        gamesDataBase.addGame(game);

        response.setGame(game);

        return response;
    }

    //Generate the answer
    public int generateAnswer(){
      Random random = new Random();
      Set<Integer> seen = new HashSet<>();

        int result = 0;
      while(seen.size() < 4){
          int num = random.nextInt(10);
          while(!seen.add(num)){
              num = random.nextInt(10);
          }
          result *= 10;
          result += num;
      }

      return result;
    }



}
