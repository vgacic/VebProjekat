<template>
    <div v-if="admin">
      <h1>Zahtevi Aktivacije Autora</h1>
      <ul >
        <li v-for="zahtev in zahtevi" :key="zahtev.id">{{ zahtev.poruka }}
          <div v-if="zahtev.status === 'NA_CEKANJU'">
            <button v-on:click="obradiZahtev(true, zahtev.id)" class="odobri-button">Odobri</button>
            <button @click="obradiZahtev(false, zahtev.id)" class="odbij-button">Odbij</button>
          </div>
        </li>

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
    },
    methods: {
      obradiZahtev(odobri, id) {
        axios
        .get('http://localhost:8880/api/obradi/' + id + '?obradi=' + odobri, {withCredentials:true})
        .then(response => {
          console.log(response)
          this.$router.go()
        })
        .catch(error => {console.error(error)})
      }
    }
  };
  </script>

<style scoped>
.odobri-button{
  background-color: #4CAF50; /* Green background color */
  border: none;
  color: white; /* White text color */
  padding: 5px 10px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 2px;
  transition: background-color 0.3s;
}

.odobri-button:hover {
  background-color: #45a049; /* Darker green color on hover */
}

.odbij-button {
  background-color: rgb(246, 76, 76); /* Green background color */
  border: none;
  color: white; /* White text color */
  padding: 5px 10px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 2px;
  transition: background-color 0.3s;
}

.odbij-button:hover {
  background-color: lightcoral; /* Darker green color on hover */
}

</style>

  