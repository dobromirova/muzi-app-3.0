
-- user roles
INSERT INTO roles (id, name)
VALUES (1, 'ADMIN');
INSERT INTO roles (id, name)
VALUES (2, 'MODERATOR');
INSERT INTO roles (id, name)
VALUES (3, 'USER');


-- test users

INSERT INTO users (id, username, password, email)
VALUES (1, 'admin123', '$2a$12$/XcA7VTcWQxYtF4wXLNb7.HQuP/Pi.bmWD.6recdKq0EU6ProiGD2', 'some@mail.com');

INSERT INTO users (id, username, password, email)
VALUES (2, 'mod123', '$2a$12$/XcA7VTcWQxYtF4wXLNb7.HQuP/Pi.bmWD.6recdKq0EU6ProiGD2', 'some1@mail.com');

INSERT INTO users (id, username, password, email)
VALUES (3, 'user123', '$2a$12$/XcA7VTcWQxYtF4wXLNb7.HQuP/Pi.bmWD.6recdKq0EU6ProiGD2', 'user@mail.com');


-- user roles

-- admin
INSERT INTO users_roles (user_id, role_id)
VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id)
VALUES (1, 2);
INSERT INTO users_roles (user_id, role_id)
VALUES (1, 3);
-- moderator
INSERT INTO users_roles (user_id, role_id)
VALUES (2, 2);
INSERT INTO users_roles (user_id, role_id)
VALUES (2, 3);
-- user
INSERT INTO users_roles (user_id, role_id)
VALUES (3, 3);

INSERT INTO genres (id, name, description)
VALUES ('1', 'POP',
        'Pop music, or simply pop, is a genre of popular music that
originated in its modern form during the mid-1950s in the United
States and the United Kingdom. The terms
popular music and pop music are often used interchangeably,
although the former more accurately describes all music that is
targeted for mass appeal and includes many disparate styles. The
vast majority of pop music uses the 4/4 time signature, also
known as "common time".');

INSERT INTO genres (id, name, description)
VALUES ('2', 'ROCK',
        'Rock music is a genre of popular music that originated in the
United States as "rock and roll" in the late 1940s and early 1950s,
developing into a range of styles from the mid-1960s, primarily in
the United States and United Kingdom. It has its roots in rock and
roll, a style that drew from the black musical genres of blues and
rhythm and blues, as well as from country music. Rock is
typically centered on the electric guitar, usually as part of a rock
group with electric bass guitar, drums, and one or more singers.
Usually, rock is song-based music with a 4/4 time signature and
using a verse–chorus form.');


INSERT INTO genres (id, name, description)
VALUES ('3', 'RNB',
        'Rhythm and blues, frequently abbreviated as R&B or RnB, is a
genre of popular music that originated within African American
communities in the 1940s. In the commercial rhythm and blues
music typical of the 1950s through the 1970s, the bands usually
consisted of a piano, one or two guitars, bass, drums, one or more
saxophones, and sometimes background vocalists. R&B lyrical
themes often encapsulate the African-American history and
experience of pain and the quest for freedom and joy, as well as
triumphs and failures in terms of societal racism, oppression,
relationships, economics, and aspirations. While 4/4 is the most
common time signature in R&B, 3/4 and 6/8 time signatures are
also frequently used, creating different feels.');



INSERT INTO genres (id, name, description)
VALUES ('4', 'JAZZ',
        'Jazz is a music genre that originated in the African-American
communities of New Orleans, Louisiana, in the late 19th and early
20th centuries. Its roots are in blues, ragtime, European harmony,
African rhythmic rituals, spirituals, hymns, marches, vaudeville
song, and dance music. Since the 1920s Jazz Age, it has been
recognized as a major form of musical expression in traditional
and popular music. Jazz is characterized by swing and blue notes,
complex chords, call and response vocals, polyrhythms and
improvisation. While 4/4 is the most common jazz time signature,
reflecting its roots as dance music, jazz extensively uses other
time signatures such as 5/4, 3/4, and even more complex or
irregular ones like 7/4.');


INSERT INTO genres (id, name, description)
VALUES ('5', 'KPOP',
        'K-pop (케이팝) is an abbreviation for Korean Pop, a form of popular music originating in South Korea. The music genre that
the term is used to refer to colloquially emerged in the 1990s as a
form of youth subculture, with Korean musicians taking influence
from Western dance music, hip-hop, R&B and rock. Today, K-pop
commonly refers to the musical output of teen idol acts, chiefly
girl groups and boy bands, who emphasize visual appeal and
performance. As a pop genre, K-pop is characterized by its
melodic quality and cultural hybridity. The vast majority of K-pop
songs, like most popular music, are in 4/4 time signature.');


INSERT INTO genres (id, name, description)
VALUES ('6', 'LATIN',
        'Latin music (Música Latina) is a term used by the music industry as
a catch-all category for various styles of music from Ibero-
America, which encompasses Latin America, Spain, Portugal, and
the Latino population in Canada and the United States, as well as
music that is sung in either Spanish and/or Portuguese. Because
the majority of Latino immigrants living in New York City in the
1950s were of Puerto Rican or Cuban descent, "Latin music" had
been stereotyped as music simply originating from the Spanish
Caribbean. The popularization of bossa nova and Herb Alpert''s
Mexican-influenced sounds in the 1960s did little to change the
perceived image of Latin music. In 1969, the first international
organization which attempted to define Latin music was the
Festival Mundial de la Canción Latina which included Spanish,
Portuguese, French, and Italian-speaking countries across Latin
America and Europe.');


INSERT INTO artists(id, name)
VALUES (1, 'Prince');

INSERT INTO albums(id, title, release_date, artist_id, genre_id, added_by_id)
VALUES (1, 'PURPLE RAIN',
        '1984-06-25',
        1, 3, 2);

INSERT INTO songs(id, title, artist_id, album_id, genre_id, added_by_id)
VALUES (1, 'Lets Go Crazy', 1, 1, 3, 2);
INSERT INTO songs(id, title, artist_id, album_id, genre_id, added_by_id)
VALUES (2, 'Take Me with U', 1, 1, 3, 2);
INSERT INTO songs(id, title, artist_id, album_id, genre_id, added_by_id)
VALUES (3, 'The Beautiful Ones', 1, 1, 3, 2);
INSERT INTO songs(id, title, artist_id, album_id, genre_id, added_by_id)
VALUES (4, 'Computer Blue', 1, 1, 3, 2);
INSERT INTO songs(id, title, artist_id, album_id, genre_id, added_by_id)
VALUES (5, 'Darling Nikki', 1, 1, 3, 2);
INSERT INTO songs(id, title, artist_id, album_id, genre_id, added_by_id)
VALUES (6, 'When Doves Cry', 1, 1, 3, 2);
INSERT INTO songs(id, title, artist_id, album_id, genre_id, added_by_id)
VALUES (7, 'I Would Die 4 U', 1, 1, 3, 2);
INSERT INTO songs(id, title, artist_id, album_id, genre_id, added_by_id)
VALUES (8, 'Baby Im a Star', 1, 1, 3, 2);
INSERT INTO songs(id, title, artist_id, album_id, genre_id, added_by_id)
VALUES (9, 'Purple Rain', 1, 1, 3, 2);




