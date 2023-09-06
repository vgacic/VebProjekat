<template>
    <div>
      <h2 style="text-align: center;">Prijava korisnika</h2>
      <form @submit.prevent="login">
        <div>
          <label for="mejl-adresa">Mejl adresa: </label>
          <input type="email" id="mejl-adresa" v-model="loginData.email" required>
        </div>
        <div>
          <label for="lozinka">Lozinka: </label>
          <input type="password" id="lozinka" v-model="loginData.lozinka" required>
        </div>
        <div>
          <button v-on:click="submit()">Prijavi se</button>
        </div>
      </form>
      <p v-if="this.message">{{message}}</p>
    </div>
  </template>
  
  <script>

import axios from 'axios'

  export default {
    name: "LoginView",
    data() {
      return {
        loginData: {
          email: "",
          lozinka: ""
        },
        message: ""
      };
    },
   // mounted() {
   //   this.checkLoggedIn();
  //  },
    methods: {
     // checkLoggedIn() {
      //  const sessionToken = localStorage.getItem("sessionToken") || sessionStorage.getItem("sessionToken");
      //  if (sessionToken) {
      //    this.$router.push("/knjige");
      //  }
      
         submit() {
       
           axios
          .post("http://localhost:8880/api/prijava", this.loginData, { withCredentials: true })
          .then(response => {
            console.log("Success: " + response.data)
            this.$cookies.set("PRIJAVLJEN", true);
            this.$router.push("/korisnik")
          })
          .catch(error => {
            if (error.response)
              this.message = error.response.data;
            console.log("Error: " + error);
            //alert("An error occurred: " + error);
          })
        }
    }
    };
 // };
  </script>