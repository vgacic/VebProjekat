<template>
    <div>
    <h1>Prikaz svih korisnika</h1>
    
    <ul class="user-list">
        <li v-for="korisnik in korisnici" :key="korisnik.id" class="user-item">
              
               <p>Ime: {{korisnik.ime}}</p>
               <p>Prezime: {{korisnik.prezime}}</p>
              <p>Korisnicko ime: {{korisnik.korisnickoIme}}</p>
               <p>E-mail: {{korisnik.email}}</p>
              <p>Uloga: {{korisnik.uloga}}</p>

            <button v-on:click="test(korisnik.id)">Detaljnije</button>
            </li>
          </ul>
        
    </div>
    </template>


<script>

import axios from 'axios'
export default {
  name:"korisniciView",
  data() {
    return {
      korisnici:[],
    };
  },
  created() { 
        axios.get(`http://localhost:8880/api/korisnici`,{withCredentials:true})
        .then(response=>{
          this.korisnici=response.data;
        })
      
      .catch(error=>{
        console.error('Neuspesan prikaz svih korisnika',error);
      });
    
  },
  methods:
  {
    test(id){
      this.$router.push("/korisnik/"+id);
    }
  }

};
</script>

<style scoped>
.section-title {
  color: #ff9966;
  font-size: 24px;
  margin-top: 1rem;
}

.user-list {
  list-style-type: none;
  padding: 0;
  margin: 0;
}

.user-item {
  background-color: #ff9966;
  padding: 1rem;
  margin-bottom: 1rem;
}

.user-item p {
  color: blaxk;
  margin-bottom: 0.5rem;
}

.no-users {
  color: lightpink;
  font-style: italic;
}
</style>