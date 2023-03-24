create table if not exists team(
    playerId INT PRIMARY KEY AUTO_INCREMENT,
    playerName varchar(255),
    jerseyNumber SMALLINT,
    role varchar(255)
);