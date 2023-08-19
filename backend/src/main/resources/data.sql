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




INSERT INTO ZANR(naziv) VALUES('Krimi');
INSERT INTO ZANR(naziv) VALUES('Misterija');
INSERT INTO ZANR(naziv) VALUES('Akcija');
INSERT INTO ZANR(naziv) VALUES('Autobiografija');
INSERT INTO ZANR(naziv) VALUES('Romansa');
INSERT INTO ZANR(naziv) VALUES('Istorija');

INSERT INTO KNJIGA(naslov,broj_strana,datum_objavljivanja,ocena,opis,ISBN,zanr_id,autor_id) VALUES('Kapije Atine',500,'2022-01-20',7,'Okej','978-86-10-04702-8',2,4);
INSERT INTO KNJIGA(naslov,broj_strana,datum_objavljivanja,ocena,opis,ISBN,zanr_id,autor_id) VALUES('It starts with us',300,'2022-10-18',10,'Super','978-13-98-51817-9',5,5);
INSERT INTO KNJIGA(naslov,broj_strana,datum_objavljivanja,ocena,opis,ISBN,zanr_id,autor_id) VALUES('It ends with us',300,'2016-10-02',10,'Odlicna','978-14-71-15626-7',5,5);

INSERT INTO autor_autorove_knjige(autor_id,autorove_knjige_id) VALUES(4,2);
INSERT INTO autor_autorove_knjige(autor_id,autorove_knjige_id) VALUES(4,3);
INSERT INTO autor_autorove_knjige(autor_id,autorove_knjige_id) VALUES(5,1);


INSERT INTO POLICA(naziv,primarna,korisnik_id) VALUES('Want to read',true,2);
INSERT INTO POLICA(naziv,primarna,korisnik_id) VALUES('Currently reading',true,2);
INSERT INTO POLICA(naziv,primarna,korisnik_id) VALUES('Read',true,2);
INSERT INTO POLICA(naziv,primarna,korisnik_id) VALUES('Want to read',true,3);
INSERT INTO POLICA(naziv,primarna,korisnik_id) VALUES('Currently reading',true,3);
INSERT INTO POLICA(naziv,primarna,korisnik_id) VALUES('Read',true,3);
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


INSERT INTO POLICA(naziv,primarna,korisnik_id) VALUES('Omiljene',false,2);
INSERT INTO POLICA(naziv,primarna,korisnik_id) VALUES('Procitacu opet',false,2);
INSERT INTO POLICA(naziv,primarna,korisnik_id) VALUES('Omiljene',false,3);
INSERT INTO POLICA(naziv,primarna,korisnik_id) VALUES('Procitacu opet',false,3);


INSERT INTO korisnik_police(korisnik_id,police_id) VALUES(2,1);
INSERT INTO korisnik_police(korisnik_id,police_id) VALUES(2,2);
INSERT INTO korisnik_police(korisnik_id,police_id) VALUES(2,3);
INSERT INTO korisnik_police(korisnik_id,police_id) VALUES(2,22);
INSERT INTO korisnik_police(korisnik_id,police_id) VALUES(2,23);

INSERT INTO korisnik_police(korisnik_id,police_id) VALUES(3,4);
INSERT INTO korisnik_police(korisnik_id,police_id) VALUES(3,5);
INSERT INTO korisnik_police(korisnik_id,police_id) VALUES(3,6);
INSERT INTO korisnik_police(korisnik_id,police_id) VALUES(3,24);
INSERT INTO korisnik_police(korisnik_id,police_id) VALUES(3,25);


INSERT INTO RECENZIJA(ocena,tekst,datum_recenzije,korisnik_id) VALUES(10,'super','2023-5-12',2);


INSERT INTO STAVKA_POLICE(knjiga_id,recenzija_id) VALUES(1,1);

INSERT INTO polica_stavke_police(polica_id,stavka_police_id) VALUES(1,1);

/*buduci autor*/
INSERT INTO KORISNIK(ime,prezime,korisnicko_ime,email,lozinka,datum_rodjenja,profilna_slika,opis,uloga) VALUES('Mikica','Autorovic','miki123','mikiautorbuduci@gmail.com','lozinka1','1990-12-12','slika1.jpg','buduci autor','AUTOR');

INSERT INTO AUTOR(id,aktivan) VALUES(6,false);
/*ZAHTEV AKTIVACIJA AUTOR*/
INSERT INTO zahtev_aktivacije_autor_naloga(status,email,telefon,poruka,datum) VALUES('NA_CEKANJU','mikiautorbuduci@gmail.com','06533211232','hocu da aktiviram nalog','2023-6-6');




