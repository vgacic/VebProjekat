<template>
    <div>
      <h2 style="text-align: center;">Registracija korisnika</h2>
      <form @submit.prevent="register">
        <div>
          <label for="ime">Ime: </label>
          <input type="text" id="ime" v-model="registracijaDto.ime" required>
        </div>
        <div>
          <label for="prezime">Prezime: </label>
          <input type="text" id="prezime" v-model="registracijaDto.prezime" required>
        </div>
        <div>
          <label for="korisnicko-ime">Korisničko ime: </label>
          <input type="text" id="korisnicko-ime" v-model="registracijaDto.korisnickoIme" required>
        </div>
        <div>
          <label for="email-adresa">E-mail adresa: </label>
          <input type="email" id="email" v-model="registracijaDto.email" required>
        </div>
        <div>
          <label for="lozinka">Lozinka: </label>
          <input type="password" id="lozinka" v-model="registracijaDto.lozinka" required>
        </div>
        <div>
          <label for="potvrda-lozinke">Potvrda lozinke: </label>
          <input type="password" id="potvrda-lozinke" v-model="registracijaDto.potvrdaLozinke" required>
        </div>
        <div>
          <button v-on:click="submit()">Registruj se</button>
        </div>
      </form>
      <p v-if="message">{{ message }}</p>
      <p>Već imate nalog? <router-link to="/">Prijavite se</router-link></p>
    </div>
  </template>
  <script>
import axios from 'axios'
  export default{
    name:'RegistracijaView',
    data() {
    return {
      registracijaDto:{
    ime:"",
    prezime:"",
    korisnickoIme:"",
      email:"",
      lozinka:"",
      potvrdaLozinke:""
      },
    
    };
  },
  methods: {
      submit(){
        axios
        .post("http://localhost:8880/api/registracija",this.registracijaDto)
        .then(data => {
            console.log("Success: " + data);
            this.message = data;
            if(data === "Uspešna registracija") {
              localStorage.setItem("sessionToken", data);}
            
            })
              //this.$router.push("/knjige");
            
        .catch(error=>{console.log(error)})
      }

  }
};


</script>

<style>
</style>