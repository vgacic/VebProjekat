<template>
  <div v-if="korisnik">
    <KorisnikComp :data="this.korisnik"></KorisnikComp>
  </div>
  <hr>
  <form>
      <input type="text" id="napraviPolicu" v-model="this.nazivPolice">
      <button v-on:click="submit()">Napravi novu policu</button>
  </form>
</template>

<script>
import KorisnikComp from '@/components/KorisnikComp.vue';
import axios from 'axios'
export default{
  name:'ProfilKorisnikaView',
  data() {
    return {
      korisnik: null,
      nazivPolice: null
    };
  },
  components:{
    KorisnikComp
  },
  created() {
      const id = this.$route.params.id;
      if (id) {
          axios
          .get(`http://localhost:8880/api/korisnik/` + id, { withCredentials: true })
          .then(response => {
          this.korisnik = response.data;
          })
          .catch(error => {
          console.error('Error fetching user', error);
          });
      }
      else if (this.$cookies.get("PRIJAVLJEN")) {
          axios
          .get(`http://localhost:8880/api/korisnik`, { withCredentials: true })
          .then(response => {
          this.korisnik = response.data;
          })
          .catch(error => {
          console.error('Error fetching user', error);
          });
      }
      else {
          this.$router.push('/pocetna')
      }
  },
  methods: {
    submit() {
        const id = this.korisnik.id;

        //pravljenje nove police u polica kontroleru metoda 
        if(id){
          axios
          .post(`http://localhost:8880/api/napraviPolicu`, 'nazivPolice='+this.nazivPolice,{withCredentials: true})
          .then(response=>{
            this.nazivPolice=response.data;
          })
          .catch(error=>{
            console.error('Greska prilikom dodavanja nove police',error);
          })
        }
        
    }
  }
}

</script>