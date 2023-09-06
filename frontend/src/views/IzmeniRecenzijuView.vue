<template>
    <div>
      <h2>Izmena Recenzije</h2>
      <form>
        <label for="ocena">Ocena:</label>
        <input type="number" id="ocena" v-model="recenzija.ocena" min="1" max="10" required><br>
  
        <label for="tekst">Tekst Recenzije:</label>
        <textarea id="tekst" v-model="recenzija.tekst" required></textarea><br>
  
        <button v-on:click="submit()">Izmeni recenziju</button>
      </form>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name:'IzmeniRecenzijuView',
    data() {
      return {
        recenzija: { 
          ocena: 1,
          tekst: '',
          idStavke: null
        },
      };
    },
    created(){
      this.recenzija.idStavke=this.$route.params.id; //dobavila stare podatke i popunila formu sa njima
      axios.get(`http://localhost:8880/api/recenzijaPoStavki/`+this.recenzija.idStavke).then(response=>{
        this.recenzija.ocena=response.data.ocena;
        this.recenzija.tekst=response.data.tekst;
      })
    },
    methods: {
      
      submit() {
        this.recenzija.idStavke=this.$route.params.id; //kad hocu da promenim ovde menjam 
        axios
          .put(`http://localhost:8880/api/recenzije/izmena/${this.recenzija.idStavke}`, this.recenzija,{withCredentials:true})
          .catch((error) => {
            console.error('Greska pri izmeni recenzije', error);
            
          });
      },
    },
  };
  </script>

<style scoped>
.recenzija-form {
  max-width: 400px; /* Adjust the width as needed */
  margin: 0 auto; /* Center the form horizontally */
}

.form-group {
  margin-bottom: 20px; /* Add space between form elements */
}

label {
  display: block; /* Labels as block elements for vertical alignment */
  font-weight: bold; /* Make labels bold for emphasis */
}

input[type="number"],
textarea {
  width: 100%; /* Make input elements full width within their container */
  padding: 8px; /* Add some padding for better appearance */
  border: 1px solid #ccc; /* Add a border for input elements */
  border-radius: 4px; /* Add rounded corners for input elements */
  box-sizing: border-box; /* Include padding and border in element's total width/height */
}
</style>
  