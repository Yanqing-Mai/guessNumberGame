package com.ym.guessnumber.repository;

import lombok.Data;

import java.util.List;

@Data
public class Games {
    private int id;
    private int answer;
    private boolean finished;

}
