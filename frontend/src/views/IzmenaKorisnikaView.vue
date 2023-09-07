<template>
    <div>
      <h2 style="text-align: center;">Azuriraj korisnika</h2>
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
        <br><br>
        <div>
          <button v-on:click="submit()" class="submit-button">Azuriraj</button>
        </div>
      </form>
      <p v-if="message">{{ message }}</p>
    </div>
  </template>
  <script>
import axios from 'axios'
  export default{
    name:'IzmenaKorisnikaView',
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
      admin:false
    };
  },
  created(){
    axios
    .get(`http://localhost:8880/api/korisnik/` + this.$route.params.id, { withCredentials: true })
    .then(response => {
    this.registracijaDto = response.data;
    })
    .catch(error => {
    console.error('Error fetching user', error);
    });
  },
  methods: {
      submit(){
        axios
        .put("http://localhost:8880/api/azuriraj",this.registracijaDto, {withCredentials:true})
        .then(response => {
            console.log(response)
            this.$router.push('/korisnik')
        })
        .catch(error=>{console.log(error)})
      }
  }
};


</script>

<style scoped>
.registration-form {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  background-color: #ffe4b5; /* Peach background color */
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

h2 {
  text-align: center;
  color: #ff6347; /* Darker peach for headings */
}

.form-group {
  margin-bottom: 15px;
}

label {
  font-weight: bold;
  color: #ff6347; /* Darker peach for labels */
}

input[type="text"],
input[type="email"],
input[type="password"] {
  width: 100%;
  padding: 10px;
  border: 1px solid #ff6347; /* Darker peach border */
  border-radius: 3px;
}

.submit-button {
  display: block;
  width: 100%;
  padding: 10px;
  background-color: #ff6347; /* Darker peach button background color */
  color: #fff; /* White text color */
  border: none;
  border-radius: 3px;
  cursor: pointer;
}

.message {
  text-align: center;
  color: #ff6347; /* Darker peach for messages */
}

.submit-button {
  display: block;
  width: 100%;
  padding: 10px;
  background-color: #fd8069; /* Darker peach button background color */
  color: #fff; /* White text color */
  border: none;
  border-radius: 20px; /* Increase border-radius for rounded corners */
  cursor: pointer;
  transition: background-color 0.3s; /* Smooth transition on hover */
}

.submit-button:hover {
  background-color: #ff7f50; /* Lighter peach color on hover */
}
</style>