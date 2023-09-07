/*ADMIN*/
INSERT INTO KORISNIK(ime,prezime,korisnicko_ime,email,lozinka,datum_rodjenja,profilna_slika,opis,uloga) VALUES('Valentina','Gacic','vaki123','vaki@gmail.com','admin','2002-6-1','slika1','admin','ADMINISTRATOR');

INSERT INTO ADMIN(id) VALUES(1);

/*CITALAC*/
INSERT INTO KORISNIK(ime,prezime,korisnicko_ime,email,lozinka,datum_rodjenja,profilna_slika,opis,uloga) VALUES('Tanja','Savic','taca123','taca@gmail.com','lozinka1','1990-12-12','slika.png','pevacica','CITALAC');
INSERT INTO KORISNIK(ime,prezime,korisnicko_ime,email,lozinka,datum_rodjenja,profilna_slika,opis,uloga) VALUES('Sergej','Cetkovic','seki123','seki@gmail.com','lozinka1','1980-12-12','slika.jpg','pevac','CITALAC');

INSERT INTO CITALAC(id) VALUES(2);
INSERT INTO CITALAC(id) VALUES(3);

/*AUTOR*/
INSERT INTO KORISNIK(ime,prezime,korisnicko_ime,email,lozinka,datum_rodjenja,profilna_slika,opis,uloga) VALUES('Colleen','Hoover','coki123','coki@gmail.com','lozinka1','1990-12-12','slika.png','pisac','AUTOR');
INSERT INTO KORISNIK(ime,prezime,korisnicko_ime,email,lozinka,datum_rodjenja,profilna_slika,opis,uloga) VALUES('Kon','Igulden','kon123','kon@gmail.com','lozinka1','1990-12-12','slika.png','pisac','AUTOR');

INSERT INTO AUTOR(id,aktivan) VALUES(4,true);
INSERT INTO AUTOR(id,aktivan) VALUES(5,true);

/*NEAKTIVAN AUTOR*/
INSERT INTO KORISNIK(ime,prezime,korisnicko_ime,email,lozinka,datum_rodjenja,profilna_slika,opis,uloga) VALUES('Mikica','Autorovic','miki123','mikiautorbuduci@gmail.com','lozinka1','1990-12-12','slika1.jpg','buduci autor','AUTOR');

INSERT INTO AUTOR(id,aktivan) VALUES(6,false);

/*ZAHTEV AKTIVACIJA AUTOR*/
INSERT INTO zahtev_aktivacije_autor_naloga(status,email,telefon,poruka,datum, autor_id) VALUES('NA_CEKANJU','mikiautorbuduci@gmail.com','06533211232','hocu da aktiviram nalog','2023-6-6', 6);



INSERT INTO POLICA(naziv,primarna) VALUES('Want to read',true);
INSERT INTO POLICA(naziv,primarna) VALUES('Currently reading',true);
INSERT INTO POLICA(naziv,primarna) VALUES('Read',true);

INSERT INTO POLICA(naziv,primarna) VALUES('Want to read',true);
INSERT INTO POLICA(naziv,primarna) VALUES('Currently reading',true);
INSERT INTO POLICA(naziv,primarna) VALUES('Read',true);

INSERT INTO POLICA(naziv,primarna) VALUES('Want to read',true);
INSERT INTO POLICA(naziv,primarna) VALUES('Currently reading',true);
INSERT INTO POLICA(naziv,primarna) VALUES('Read',true);

INSERT INTO POLICA(naziv,primarna) VALUES('Want to read',true);
INSERT INTO POLICA(naziv,primarna) VALUES('Currently reading',true);
INSERT INTO POLICA(naziv,primarna) VALUES('Read',true);

INSERT INTO korisnik_police(korisnik_id,police_id) VALUES(2,1);
INSERT INTO korisnik_police(korisnik_id,police_id) VALUES(2,2);
INSERT INTO korisnik_police(korisnik_id,police_id) VALUES(2,3);

INSERT INTO korisnik_police(korisnik_id,police_id) VALUES(3,4);
INSERT INTO korisnik_police(korisnik_id,police_id) VALUES(3,5);
INSERT INTO korisnik_police(korisnik_id,police_id) VALUES(3,6);

INSERT INTO korisnik_police(korisnik_id,police_id) VALUES(4,7);
INSERT INTO korisnik_police(korisnik_id,police_id) VALUES(4,8);
INSERT INTO korisnik_police(korisnik_id,police_id) VALUES(4,9);

INSERT INTO korisnik_police(korisnik_id,police_id) VALUES(5,10);
INSERT INTO korisnik_police(korisnik_id,police_id) VALUES(5,11);
INSERT INTO korisnik_police(korisnik_id,police_id) VALUES(5,12);



INSERT INTO POLICA(naziv,primarna) VALUES('Omiljene',false);
INSERT INTO POLICA(naziv,primarna) VALUES('Procitacu opet',false);

INSERT INTO korisnik_police(korisnik_id,police_id) VALUES(2,13);
INSERT INTO korisnik_police(korisnik_id,police_id) VALUES(2,14);

INSERT INTO ZANR(naziv) VALUES('Krimi');
INSERT INTO ZANR(naziv) VALUES('Misterija');
INSERT INTO ZANR(naziv) VALUES('Akcija');
INSERT INTO ZANR(naziv) VALUES('Autobiografija');
INSERT INTO ZANR(naziv) VALUES('Romansa');
INSERT INTO ZANR(naziv) VALUES('Istorija');

INSERT INTO KNJIGA(naslov,broj_strana,datum_objavljivanja,ocena,opis,ISBN,zanr_id,autor_id) VALUES('Kapije Atine',500,'2022-01-20',7,'Okej','978-86-10-04702-8',2,4);
INSERT INTO KNJIGA(naslov,broj_strana,datum_objavljivanja,ocena,opis,ISBN,zanr_id,autor_id) VALUES('It starts with us',300,'2022-10-18',10,'Super','978-13-98-51817-9',5,5);
INSERT INTO KNJIGA(naslov,broj_strana,datum_objavljivanja,ocena,opis,ISBN,zanr_id,autor_id) VALUES('It ends with us',300,'2016-10-02',10,'Odlicna','978-14-71-15626-7',5,5);

INSERT INTO KNJIGA(naslov, broj_strana, datum_objavljivanja, ocena, opis, ISBN, zanr_id, autor_id)
VALUES ('Naslov knjige 1', 250, '2022-08-12', 9, 'Opis knjige 1.', '978-1-23-456789-1', 1, 4);
INSERT INTO KNJIGA(naslov, broj_strana, datum_objavljivanja, ocena, opis, ISBN, zanr_id, autor_id)
VALUES ('Naslov knjige 2', 300, '2021-11-25', 8, 'Opis knjige 2.', '978-1-23-456789-2', 2, 5);
INSERT INTO KNJIGA(naslov, broj_strana, datum_objavljivanja, ocena, opis, ISBN, zanr_id, autor_id)
VALUES ('Naslov knjige 3', 400, '2020-06-10', 7, 'Opis knjige 3.', '978-1-23-456789-3', 3, 4);
INSERT INTO KNJIGA(naslov, broj_strana, datum_objavljivanja, ocena, opis, ISBN, zanr_id, autor_id)
VALUES ('Naslov knjige 4', 280, '2019-03-17', 9, 'Opis knjige 4.', '978-1-23-456789-4', 4, 5);
INSERT INTO KNJIGA(naslov, broj_strana, datum_objavljivanja, ocena, opis, ISBN, zanr_id, autor_id)
VALUES ('Naslov knjige 5', 350, '2018-09-08', 8, 'Opis knjige 5.', '978-1-23-456789-5', 5, 4);
INSERT INTO KNJIGA(naslov, broj_strana, datum_objavljivanja, ocena, opis, ISBN, zanr_id, autor_id)
VALUES ('Naslov knjige 6', 420, '2017-12-05', 7, 'Opis knjige 6.', '978-1-23-456789-6', 6, 4);

INSERT INTO RECENZIJA(ocena,tekst,datum_recenzije,korisnik_id) VALUES(10,'super','2023-5-12',2);
INSERT INTO RECENZIJA(ocena, tekst, datum_recenzije, korisnik_id)
VALUES(9, 'Odlična knjiga! Preporučujem je svima.', '2023-09-05', 3);
INSERT INTO RECENZIJA(ocena, tekst, datum_recenzije, korisnik_id)
VALUES(8, 'Solidna knjiga, ali očekivao/la sam više.', '2023-08-20', 4);
INSERT INTO RECENZIJA(ocena, tekst, datum_recenzije, korisnik_id)
VALUES(7, 'Nije loša, ali ima boljih.', '2023-07-15', 5);
INSERT INTO RECENZIJA(ocena, tekst, datum_recenzije, korisnik_id)
VALUES(9, 'Izvanredna knjiga, definitivno jedna od mojih omiljenih!', '2023-06-28', 2);
INSERT INTO RECENZIJA(ocena, tekst, datum_recenzije, korisnik_id)
VALUES(10, 'Super knjiga! Morate je pročitati!', '2023-05-12', 3);


INSERT INTO STAVKA_POLICE(knjiga_id,recenzija_id) VALUES(1,1);
INSERT INTO STAVKA_POLICE(knjiga_id,recenzija_id) VALUES(4,2);
INSERT INTO STAVKA_POLICE(knjiga_id,recenzija_id) VALUES(2,3);
INSERT INTO STAVKA_POLICE(knjiga_id,recenzija_id) VALUES(2,4);
INSERT INTO STAVKA_POLICE(knjiga_id,recenzija_id) VALUES(3,5);
INSERT INTO STAVKA_POLICE(knjiga_id,recenzija_id) VALUES(5,6);
INSERT INTO STAVKA_POLICE(knjiga_id) VALUES(2);
INSERT INTO STAVKA_POLICE(knjiga_id) VALUES(3);
INSERT INTO STAVKA_POLICE(knjiga_id) VALUES(5);

INSERT INTO polica_stavke_police(polica_id,stavka_police_id) VALUES(3,1);
INSERT INTO polica_stavke_police(polica_id,stavka_police_id) VALUES(6,2);
INSERT INTO polica_stavke_police(polica_id,stavka_police_id) VALUES(9,3);
INSERT INTO polica_stavke_police(polica_id,stavka_police_id) VALUES(12,4);
INSERT INTO polica_stavke_police(polica_id,stavka_police_id) VALUES(3,5);
INSERT INTO polica_stavke_police(polica_id,stavka_police_id) VALUES(6,6);
INSERT INTO polica_stavke_police(polica_id,stavka_police_id) VALUES(3,7);
INSERT INTO polica_stavke_police(polica_id,stavka_police_id) VALUES(3,8);
INSERT INTO polica_stavke_police(polica_id,stavka_police_id) VALUES(3,9);


