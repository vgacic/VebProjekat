<template>
    <div>
      <h2>Dodavanje knjige</h2>
      <form class="knjiga-form">
        <div class="form-group">
          <label for="naslov">Naslov: </label>
          <input type="text" id="naslov" v-model="knjiga.naslov" required>

          <label for="isbn">ISBN: </label>
          <input type="text" id="isbn" v-model="knjiga.ISBN" required unique>

          <label for="naslov">Broj strana: </label>
          <input type="number" id="brojStrana" v-model="knjiga.brojStrana" min="1" required>

          <label for="naslov">Opis: </label>
          <input type="text" id="opis" v-model="knjiga.opis">

          <label for="naslov">Zanr: </label>
          <input type="text" id="zanr" v-model="knjiga.zanr" required>
        </div>
        <button v-on-click="submit()">Dodaj knjigu</button>
      </form>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name: "DodajKnjiguView",
    data() {
      return {
        knjiga: {
          naslov: "",
          ISBN: "",
          brojStrana: null,
          opis:"",
          zanr:""
        }
      };
    },
    methods: {
      submit() {
        axios
          .post(`http://localhost:8880/api/dodajKnjigu`, this.knjiga, {
            headers: {
              'Content-Type': 'application/json'
            },
          })
          .then((response) => {
            console.log("Knjiga uspešno dodata", response.data);
            this.knjiga = {
              naziv: "",
              // Reset other book properties as well
            };
          })
          .catch((error) => {
            console.error("Greška pri dodavanju knjige", error);
          });
      },
    },
  };
  </script>
  
  <style scoped>
  .knjiga-form {
    max-width: 400px;
    margin: 0 auto;
  }
  
  .form-group {
    margin-bottom: 20px;
  }
  
  label {
    display: block;
    font-weight: bold;
  }
  
  input[type="text"],
  button {
    width: 100%;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
  }
  </style>
  