package com.ym.guessnumber.repository;

import lombok.Data;

@Data
public class Game {
    private int id;
    private int answer;
    private boolean finished;

}
