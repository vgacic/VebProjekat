<template>
    <div v-if="this.$route.params.id">
      <h2>Izmena knjige</h2>
      <form class="knjiga-form">
        <div class="form-group">
          <label for="naslov">Naslov: </label>
          <input type="text" id="naslov" v-model="knjiga.naslov" required>

          <label for="isbn">ISBN: </label>
          <input type="text" id="isbn" v-model="knjiga.ISBN" required>

          <label for="naslov">Broj strana: </label>
          <input type="number" id="brojStrana" v-model="knjiga.brojStrana" min="1" required>

          <label for="naslov">Opis: </label>
          <input type="text" id="opis" v-model="knjiga.opis">
        </div>
        <button v-on:click="submit()">Izmeni knjigu</button>
      </form>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name: "IzmenaKnjigeView",
    data() {
      return {
        knjiga: {
          naslov: "",
          ISBN: "",
          brojStrana: null,
          opis:""
        }
      };
    },
    created() {
        axios.get('http://localhost:8880/api/knjiga/' + this.$route.params.id).then(response => { this.knjiga = response.data}).catch(error => {console.error(error)})
    },
    methods: {
      submit() {
        axios
          .put(`http://localhost:8880/api/izmenaKnjige/` + this.$route.params.id, this.knjiga, {withCredentials:true})
          .then((response) => {
            console.log("Knjiga uspešno dodata", response.data);
            this.knjiga = response.data
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
  