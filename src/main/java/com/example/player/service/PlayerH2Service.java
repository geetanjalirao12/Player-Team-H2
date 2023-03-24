package com.example.player.service;
import com.example.player.model.Player;
import com.example.player.model.PlayerRowMapper;
import com.example.player.repository.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import javax.validation.OverridesAttribute;


// Write your code here
@Service
public class PlayerH2Service implements PlayerRepository{
    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Player> getPlayers(){
        List<Player> playersList=db.query("SELECT * FROM TEAM", new PlayerRowMapper());
        ArrayList<Player> players=new ArrayList<>(playersList);
        return players;
    }

    @Override
    public Player getPlayerById(int playerId){
        try{
            Player player=db.queryForObject("SELECT * FROM TEAM WHERE playerId=?", new PlayerRowMapper(), playerId);
            return player;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override

    public Player addPlayer(Player player){
        db.update("insert into TEAM(playerName,jerseyNumber,role) values (?,?,?)",player.getPlayerName(),player.getJerseyNumber(),player.getRole());

        Player newPlayer=db.queryForObject("select * from TEAM where playerName=? and jerseyNumber=? and role=?", new PlayerRowMapper(),
        player.getPlayerName(),player.getJerseyNumber(),player.getRole());
        
        return newPlayer;
    }

    @Override

    public Player updatePlayer(int playerId, Player player){
        if(player.getPlayerName() != null){
            db.update("update TEAM set playerName=? where playerId=?",player.getPlayerName(),playerId);
        }
        if(player.getJerseyNumber() != 0){
            db.update("update TEAM set jerseyNumber=? where playerId=?",player.getJerseyNumber(),playerId);
        }
        if(player.getRole() != null){
            db.update("update TEAM set role=? where playerId=?",player.getRole(),playerId);
        }
        
        return getPlayerById(playerId);
    }

    @Override

    public void deletePlayer(int playerId){
        db.update("delete from TEAM where playerId=?",playerId);
    }
    
}