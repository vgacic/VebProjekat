<template>
    <div>
      <h1 class="page-title">Prikaz svih knjiga</h1>
            <ul class="book-list">
                
                <li v-for="knjiga in knjige" :key="knjiga.id" class="knjiga-item">
                    <p>Naslov {{ knjiga.naslov }}</p>
                    <p>ISBN {{knjiga.ISBN}}</p>
                    <p>Datum objavljivanja {{knjiga.datumObjavljivanja }} </p>
                    <p>Broj strana {{ knjiga.brojStrana}}</p>
                    <p>Opis {{ knjiga.opis}}</p>
                    <p>Zanr {{knjiga.zan}}</p>
                    <p>Ocena {{ knjiga.ocena }}</p>
                </li>
            </ul>
        </div>
      
       

  </template>
  
  <script>

import axios from 'axios'
  export default {
    name: 'KnjigeView',
    data() {
      return {
        knjige: [],
      };
    },
    created() {
      axios.get(`http://localhost:8880/api/knjige`)
        .then(response => {
          this.knjige = response.data;
        })
        .catch(error => {
          console.error('Neuspešan prikaz svih knjiga', error);
        });
    },
  };
  </script>

<style>
/* Stil za naslov */
.page-title {
  font-size: 24px;
  color: #ff9966; /* Breskvasta boja za naslov */
}

/* Stil za pozadinu stranice */
body {
  background-color: #ffdab9; /* Breskvasta boja za pozadinu */
}

/* Stil za listu knjiga */
.book-list {
  list-style: none;
  padding: 0;
}

.knjiga-item {
  margin-bottom: 20px;
  padding: 10px;
  border: 1px solid #ff9966; /* Breskvasta boja za okvir knjige */
  background-color: #fff; /* Bela pozadina za svaku knjigu */
}

/* Stil za ostale elemente po potrebi */
</style>