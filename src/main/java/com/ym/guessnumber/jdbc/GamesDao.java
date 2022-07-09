package com.ym.guessnumber.jdbc;

import com.ym.guessnumber.repository.Games;

import java.util.List;

public  interface GamesDao {
    List<Games> getAll();

    Games findById(int id);
}
