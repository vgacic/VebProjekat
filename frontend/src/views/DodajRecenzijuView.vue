<template>
   <div>
       <h2>Dodavanje recenzije</h2>
       <form >
           <label for="naziv">Unesite ocenu: </label>
           <input type="number" id="naziv" v-model="recenzija.ocena" min="1" max="10" required> <br>

           <label for="naziv">Unesite tekst: </label>
           <input type="text" id="ocena" v-model="recenzija.tekst" required> <br> <br>


           <button v-on:click="submit()">Dodaj</button>

       </form>
   </div>
</template>
<script>
import axios from 'axios';

export default{
   name:"DodajRecenzijuView",
   data(){
   return{
      recenzija:{
       ocena: null,
       tekst: "",
       idStavke: null
      }

       }
   },

   methods:{
       submit(){
           this.recenzija.idStavke=this.$route.params.id;
           axios
           .post(`http://localhost:8880/api/dodajRecenziju`,this.recenzija, {withCredentials:true})
           .catch(error=>{
               console.error("Greska pri dodavanju recenzije",error)
           })
       }

   }

};

</script>

<style scoped>
.recenzija-form {
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

input[type="number"],
textarea,
button {
  width: 100%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
</style>