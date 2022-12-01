INSERT INTO T_ARTIST (name) VALUES ('Nirvana');
INSERT INTO T_ARTIST (name) VALUES ('Metallica');

INSERT INTO T_ALBUM (name, ARTIST_ID) VALUES ('Nevermind', 1);
INSERT INTO T_ALBUM (name) VALUES ('In Utero');

INSERT INTO T_SONG (name, ARTIST_ID, ALBUM_ID, length) VALUES ('Heart-Shaped Box', 1, 1, '3.23');
INSERT INTO T_SONG (name, ARTIST_ID, ALBUM_ID, length) VALUES ('Something in the way', 1,1 , '3.36');
INSERT INTO T_SONG (name, length) VALUES ('Polly', '4.10');