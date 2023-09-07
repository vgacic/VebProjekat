<template>
  <div v-if="korisnik">
    <KorisnikComp :data="this.korisnik"></KorisnikComp>
  </div>
  <hr>
  <form v-if="this.ok">
      <input type="text" id="napraviPolicu" v-model="this.nazivPolice">
      <button v-on:click="submit()">Napravi novu policu</button>
  </form>

  <button v-on:click="this.$router.push('/azurirajProfil/' + this.korisnik.id)" v-if="this.ok">Azuriraj</button>
  <button v-on:click="this.$router.push('/azurirajAutora/' + this.korisnik.id)" v-if="this.admin && this.korisnik.uloga === 'AUTOR'">Azuriraj autora</button>
  
  <router-link :to="'/dodajKnjigu/' + (this.$route.params.id ? (admin ? this.$route.params.id : '') : this.korisnik.id)" v-if="(admin && this.korisnik.uloga === 'AUTOR') || (this.$route.params.id == null && this.korisnik.uloga === 'AUTOR')">Dodaj knjigu</router-link>
  <button v-on:click="this.$router.push('/posaljiZahtev/'+this.korisnik.id)" v-if="!this.$cookies.get('PRIJAVLJEN') && this.korisnik.uloga === 'AUTOR'">Posalji zahtev</button>
</template>

<script>
import KorisnikComp from '@/components/KorisnikComp.vue';
import axios from 'axios'
export default{
  name:'ProfilKorisnikaView',
  data() {
    return {
      korisnik: {
        id: null,
        uloga: null
      },
      nazivPolice: null,
      ok: false,
      admin: false,
      aktivan: false
    };
  },
  components:{
    KorisnikComp
  },
  async created() {
      const id = this.$route.params.id;

      axios
      .get('http://localhost:8880/api/admin', {withCredentials:true})
      .then(response => {
        this.admin = response.data
      })
      .catch(error => {console.error(error)})

      if (id) {
          await axios
          .get(`http://localhost:8880/api/korisnik/` + id, { withCredentials: true })
          .then(response => {
          this.korisnik = response.data;
          })
          .catch(error => {
          console.error('Error fetching user', error);
          });

          axios
          .get('http://localhost:8880/api/aktivan/' + id)
          .then(response => {
            this.aktivan = response.data
          })
          .catch(error => { console.error(error)})
      }
      else if (this.$cookies.get("PRIJAVLJEN")) {
          await axios
          .get(`http://localhost:8880/api/korisnik`, { withCredentials: true })
          .then(response => {
            this.korisnik = response.data;
            this.ok = true
          })
          .catch(error => {
          console.error('Error fetching user', error);
          });

          axios
          .get('http://localhost:8880/api/aktivan/' + this.korisnik.id)
          .then(response => {
            this.aktivan = response.data
          })
          .catch(error => { console.error(error)})
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