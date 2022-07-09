package com.ym.guessnumber.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StartGameService {
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
