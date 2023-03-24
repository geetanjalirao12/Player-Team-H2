package com.example.player.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


// Write your code here
public class PlayerRowMapper implements RowMapper<Player>{
    public Player mapRow(ResultSet rs, int rowNum) throws SQLException{
        return new Player(
            rs.getInt("playerId"),
            rs.getString("playerName"),
            rs.getInt("jerseyNumber"),
            rs.getString("role")
        );
    }
}
