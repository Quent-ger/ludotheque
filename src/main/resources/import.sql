delete from jeux_genres;
delete from genres;
SET IDENTITY_INSERT genres ON;
insert into genres (no_genre, libelle)values (1, 'Jeu de plateau');
insert into genres (no_genre, libelle)values (2, 'Jeu de cartes');
insert into genres (no_genre, libelle)values (3, 'Jeu de stratégie');
insert into genres (no_genre, libelle)values (4, 'Coopératif');
insert into genres (no_genre, libelle)values (5, 'Jeu de dé');
insert into genres (no_genre, libelle)values (6, 'Jeu d''enquete');
SET IDENTITY_INSERT genres OFF;
SET IDENTITY_INSERT jeux ON
insert into jeux (id, titre, reference, age_min, description, duree, tarif_jour)values (1, 'Risk', 12, 12, 'une descr', 300, 5.25);
SET IDENTITY_INSERT jeux OFF
