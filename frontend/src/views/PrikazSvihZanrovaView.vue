<template>
    <div>
      <h1>Prikaz svih žanrova</h1>
  
      <ul class="zanr-list">
        <li v-for="zanr in zanrovi" :key="zanr.id" class="zanr-item">
          <router-link :to='"/zanr/"+zanr.id'>{{ zanr.naziv }}</router-link>
        </li>
      </ul>
    </div>
  </template>
  
  <script>

import axios from 'axios'
  export default {
    name: 'ZanroviView',
    data() {
      return {
        zanrovi: [],
      };
    },
    created() {
      axios.get(`http://localhost:8880/api/zanrovi`)
        .then(response => {
          this.zanrovi = response.data;
        })
        .catch(error => {
          console.error('Neuspešan prikaz svih žanrova', error);
        });
    },
  };
  </script>

<style scoped>
.section-title {
  color: #ff9966; 
  font-size: 24px;
  margin-top: 1rem;
}

.zanr-list {
  list-style-type: none;
  padding: 0;
  margin: 0;
}

.zanr-item {
  background-color: #ff9966; 
  padding: 1rem;
  margin-bottom: 1rem;
  border-radius: 5px;
}

.zanr-naziv {
  color: #ff9966; 
  margin-bottom: 0.5rem;
}
</style>