/*ADMIN*/
INSERT INTO KORISNIK(ime,prezime,korisnickoIme,email,lozinka,datumRodjenja,profilnaSlika,opis,uloga) VALUES('Valentina','Gacic','vaki123','vaki@gmail.com','admin','2002-6-1','slika1','admin','ADMINISTRATOR');


/*CITALAC*/
INSERT INTO KORISNIK(ime,prezime,korisnickoIme,email,lozinka,datumRodjenja,profilnaSlika,opis,uloga) VALUES('Tanja','Savic','taca123','taca@gmail.com','lozinka1','1990-12-12','slika.png','pevacica','CITALAC');
INSERT INTO KORISNIK(ime,prezime,korisnickoIme,email,lozinka,datumRodjenja,profilnaSlika,opis,uloga) VALUES('Sergej','Cetkovic','seki123','seki@gmail.com','lozinka1','1980-12-12','slika.jpg','pevac','CITALAC');

/*AUTOR*/

INSERT INTO KORISNIK(ime,prezime,korisnickoIme,email,lozinka,datumRodjenja,profilnaSlika,opis,uloga,aktivan) VALUES('Colleen','Hoover','coki123','coki@gmail.com','lozinka1','1990-12-12','slika.png','pisac','AUTOR',true);
INSERT INTO KORISNIK(ime,prezime,korisnickoIme,email,lozinka,datumRodjenja,profilnaSlika,opis,uloga,aktivan) VALUES('Kon','Igulden','kon123','kon@gmail.com','lozinka1','1990-12-12','slika.png','pisac','AUTOR',true);



INSERT INTO ZANR(naziv) VALUES('Krimi');
INSERT INTO ZANR(naziv) VALUES('Misterija');
INSERT INTO ZANR(naziv) VALUES('Akcija');
INSERT INTO ZANR(naziv) VALUES('Autobiografija');
INSERT INTO ZANR(naziv) VALUES('Romansa');
INSERT INTO ZANR(naziv) VALUES('Istorija');

INSERT INTO KNJIGA(naslov,brojStrana,datumObjavljivanja,ocena,opis,ISBN,zanr_id,autor_id) VALUES('Kapije Atine',500,'2022-01-20',7,'Okej','978-86-10-04702-8',2,2);
INSERT INTO KNJIGA(naslov,brojStrana,datumObjavljivanja,ocena,opis,ISBN,zanr_id,autor_id) VALUES('It starts with us',300,'2022-10-18',10,'Super','978-13-98-51817-9',5,1);
INSERT INTO KNJIGA(naslov,brojStrana,datumObjavljivanja,ocena,opis,ISBN,zanr_id,autor_id) VALUES('It ends with us',300,'2016-10-02',10,'Odlicna','978-14-71-15626-7',5,1);


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
INSERT INTO POLICA(naziv,primarna) VALUES('Want to read',true);
INSERT INTO POLICA(naziv,primarna) VALUES('Currently reading',true);
INSERT INTO POLICA(naziv,primarna) VALUES('Read',true);
INSERT INTO POLICA(naziv,primarna) VALUES('Want to read',true);
INSERT INTO POLICA(naziv,primarna) VALUES('Currently reading',true);
INSERT INTO POLICA(naziv,primarna) VALUES('Read',true);
INSERT INTO POLICA(naziv,primarna) VALUES('Want to read',true);
INSERT INTO POLICA(naziv,primarna) VALUES('Currently reading',true);
INSERT INTO POLICA(naziv,primarna) VALUES('Read',true);


INSERT INTO POLICA(naziv,primarna) VALUES('Omiljene',false);
INSERT INTO POLICA(naziv,primarna) VALUES('Procitacu opet',false);


INSERT INTO RECENZIJA(ocena,tekst,datumRecenzije) VALUES(10,'super','2023-5-12');


INSERT INTO STAVKA_POLICE(knjiga_id,recenzija_id) VALUES(1,1);


/*buduci autor*/
INSERT INTO KORISNIK(ime,prezime,korisnickoIme,email,telefon,lozinka,datumRodjenja,profilnaSlika,opis,uloga,aktivan) VALUES('Mikica','Autorovic','miki123','mikiautorbuduci@gmail.com','06533211232','lozinka1','1990-12-12','slika1.jpg','buduci autor','AUTOR',false);

/*ZAHTEV AKTIVACIJA AUTOR*/
INSERT INTO ZAHTEVAKTIVACIJAAUTOR(status,email,telefon,poruka,datum) VALUES('NA_CEKANJU','mikiautorbuduci@gmail.com','06533211232','hocu da aktiviram nalog','2023-6-6');




