insert into team(playerName, jerseyNumber, role)
select 'Alexander', 5, 'All-rounder'
where not exists(select 1 from team where playerId=1);

 insert into team(playerName, jerseyNumber, role)
select 'Benjamin', 3, 'All-rounder'
where not exists(select 2 from team where playerId=2);

insert into team(playerName, jerseyNumber, role)
select 'Michael', 18, 'Batsman'
where not exists(select 3 from team where playerId=3);

insert into team(playerName, jerseyNumber, role)
select 'William', 45, 'Batsman'
where not exists(select 4 from team where playerId=4);

insert into team(playerName, jerseyNumber, role)
select 'Joshua', 19, 'Batsman'
where not exists(select 5 from team where playerId=5);

insert into team(playerName, jerseyNumber, role)
select 'Daniel', 10, 'Bowler'
where not exists(select 6 from team where playerId=6);

insert into team(playerName, jerseyNumber, role)
select 'Matthew', 34, 'Bowler'
where not exists(select 7 from team where playerId=7);

insert into team(playerName, jerseyNumber, role)
select 'Samuel', 17, 'Batsman'
where not exists(select 8 from team where playerId=8);

insert into team(playerName, jerseyNumber, role)
select 'John', 1, 'Bowler'
where not exists(select 9 from team where playerId=9);

insert into team(playerName, jerseyNumber, role)
select 'Earnest', 2, 'All-rounder'
where not exists(select 10 from team where playerId=10);

insert into team(playerName, jerseyNumber, role)
select 'Bob', 25, 'Batsman'
where not exists(select 11 from team where playerId=11);
