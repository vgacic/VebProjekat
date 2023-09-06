<template>
    <div v-if="admin">
      <h1>Zahtevi Aktivacije Autora</h1>
      <ul>
        <li v-for="zahtev in zahtevi" :key="zahtev.id">{{ zahtev.poruka }}</li>
      </ul>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name:'ZahteviView',
    data() {
      return {
        zahtevi: [],
        admin : false
      };
    },
   async mounted() {
      await axios.get(`http://localhost:8880/api/admin`,{withCredentials : true}).then(response=>{this.admin=response.data}).catch(error=>{console.error("Greskica",error)})
      if(this.admin){
      axios.get('http://localhost:8880/api/zahtevi',{withCredentials : true})
        .then(response => {
          // Ažurirajte podatke sa odgovorom sa servera
          this.zahtevi = response.data;
        })
        .catch(error => {
          console.error('Došlo je do greške pri dohvatanju zahteva:', error);
        });
          }
    }
  };
  </script>
  