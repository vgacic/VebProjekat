INSERT INTO ZANR(naziv) VALUES('Krimi');
INSERT INTO ZANR(naziv) VALUES('Misterija');
INSERT INTO ZANR(naziv) VALUES('Akcija');
INSERT INTO ZANR(naziv) VALUES('Autobiografija');
INSERT INTO ZANR(naziv) VALUES('Romansa');
INSERT INTO ZANR(naziv) VALUES('Istorija');

INSERT INTO KNJIGA(naslov,brojStrana,datum_objavljivanja,ocena,opis,ISBN) VALUES('Kapije Atine',500,'2022-1-20',7,'Okej','978-86-10-04702-8');
INSERT INTO KNJIGA(naslov,brojStrana,datum_objavljivanja,ocena,opis,ISBN) VALUES('It starts with us',300,'2022-10-18',10,'Super','978-13-98-51817-9');
INSERT INTO KNJIGA(naslov,brojStrana,datum_objavljivanja,ocena,opis,ISBN) VALUES('It ends with us',300,'2016-10-2',10,'Odlicna','978-14-71-15626-7');



INSERT INTO KNJIGA_ZANR(knjiga_id,zanr_id) VALUES(1,6);
INSERT INTO KNJIGA_ZANR(knjiga_id,zanr_id) VALUES(2,5);
INSERT INTO KNJIGA_ZANR(knjiga_id,zanr_id) VALUES(3,5);

INSERT INTO KORISNIK(ime,korisnicko_ime,email,lozinka,uloga_korisnika,datum_rodjenja,opis) VALUES();

