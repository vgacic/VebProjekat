<template>
  <nav>
    <router-link to="/pocetna">Pocetna</router-link> |
    <router-link to="/about">About</router-link>|
    <router-link to="/registracija">Registracija</router-link>|
    <router-link to="/korisnici">Prikaz svih korisnika</router-link>|
    <router-link to="/knjige">Prikaz svih knjiga</router-link>|
    <router-link to="/recenzije">Prikaz svih recenzija</router-link>|
    <router-link to="/zanrovi">Prikaz svih zanrova</router-link>|
    <router-link to="/">Login</router-link>|
    <router-link to="/zahtevi">Pregled svih zahteva</router-link>|
    <router-link to="/dodajZanr">Dodaj zanr</router-link>|
    <router-link to="/dodajRecenziju">Dodaj recenziju</router-link>|
    <router-link to="/izmeniRecenziju">Izmeni recenziju</router-link>|
    <router-link to="/dodajKnjigu">Dodaj knjigu</router-link>
    <hr>
    <!-- <router-link to="/logout">Logout</router-link> -->
    <button @click="logout()">Logout</button>

    <hr>
    <form>
      <label for="naziv">Naziv knjige: </label>
      <input type="text" id="naziv" v-model="query" required>
      <button v-on:click="submit()">Pretrazi knjige</button>
    </form>
 
  </nav>
  <router-view/>
</template>

<script>
import axios from 'axios';
export default{
  data(){
    return{
      query:""
    }
  },
  methods:{
    submit(){
      this.$router.push("/pretraga/"+this.query);
    },
    logout(){
      axios
      this.$cookies.remove('JSESSIONID'); //nece da obrise JSESSIONID mora rucno
      this.$cookies.set('PRIJAVLJEN',false);
      this.$router.go('/');
    }


  }
}
</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
