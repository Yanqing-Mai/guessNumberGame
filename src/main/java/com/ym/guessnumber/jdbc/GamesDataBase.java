package com.ym.guessnumber.jdbc;

import com.ym.guessnumber.repository.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import java.sql.*;
import java.util.List;

@Repository
public class GamesDataBase implements GamesDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GamesDataBase(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Game> getAll() {
      return null;
    }

    @Override
    public Game findById(int id) {
        return null;
    }

    @Override
    public void addGame(Game game) {
        final String sql = "INSERT INTO games(answer) VALUES(?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection conn) -> {

            PreparedStatement statement = conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, game.getAnswer());
            return statement;

        }, keyHolder);

        game.setId(keyHolder.getKey().intValue());
        game.setFinished(false);

    }

    private static final class GamesMapper implements RowMapper<Game>{
        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException{
            Game game = new Game();
            game.setId(rs.getInt("id"));
            game.setAnswer(rs.getInt("answer"));
            game.setFinished(rs.getBoolean("finished"));
            return game;
        }


    }


}
