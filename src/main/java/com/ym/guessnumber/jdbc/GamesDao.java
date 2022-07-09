package com.ym.guessnumber.jdbc;

import com.ym.guessnumber.repository.Game;

import java.util.List;

public  interface GamesDao {
    List<Game> getAll();

    Game findById(int id);

    void addGame(Game game);
}
