<template>
    <div>
      <h1>Prikaz svih recenzija</h1>
  
      <ul class="recenzija-list">
        <li v-for="recenzija in recenzije" :key="recenzija.id" class="recenzija-item">
          <p>Naslov: {{ recenzija.tekst }}</p>
          <p>Ocena: {{ recenzija.ocena }}</p>
          <p>Komentar: {{ recenzija.datumRecenzije }}</p>
         
        </li>
      </ul>
    </div>
  </template>
  
  <script>

import axios from 'axios'
  export default {
    name: 'RecenzijeView',
    data() {
      return {
        recenzije: [],
      };
    },
    created() {
      axios.get(`http://localhost:8880/api/recenzije`)
        .then(response => {
          this.recenzije = response.data;
        })
        .catch(error => {
          console.error('Neuspešan prikaz svih recenzija', error);
        });
    },
  };
  </script>
  
  <style scoped>
  .recenzija-list {
    list-style-type: none;
    padding: 0;
    margin: 0;
  }
  
  .recenzija-item {
    background-color: #ff9966;
    padding: 1rem;
    margin-bottom: 1rem;
  }
  
  .recenzija-item p {
    margin-bottom: 0.5rem;
  }
  </style>
  