package com.ym.guessnumber.reqandres;

import com.ym.guessnumber.repository.Game;
import lombok.Data;

@Data
public class BeginResponse {
    private String message;
    Game game;
}
