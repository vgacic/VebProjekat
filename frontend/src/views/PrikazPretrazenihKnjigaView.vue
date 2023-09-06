<template>
    <div>
        <div v-if="this.ok">
            <h1>Trazena knjiga</h1>
            <ul class="book-list">
                
                <li v-for="knjiga in knjige" :key="knjiga.id" class="knjiga-item">
                    <p>Naslov {{ knjiga.naslov }}</p>
                    <p>ISBN {{knjiga.isbn}}</p>
                    <p>Datum objavljivanja {{knjiga.datumObjavljivanja }} </p>
                    <p>Broj strana {{ knjiga.brojStrana}}</p>
                    <p>Opis {{ knjiga.opis}}</p>
                    <p>Zanr {{knjiga.zanr}}</p>
                    <p>Ocena {{ knjiga.ocena }}</p>
                </li>
            </ul>
        </div>
      
        <p v-else>{{ poruka }}</p>
    </div> 
</template>




<script>

import axios from 'axios'
export default{
    name:"PrikazSvihKnjigaView",
    data(){
        return{
            knjige:null,
            poruka:null,
            ok:false
        };
    },
    async created(){
        const query=this.$route.params.query
        console.log(query)
       
       await axios.get('http://localhost:8880/api/search?query='+query)
        .then(response=>{
            
            this.knjige=response.data;
            this.ok=true
            console.log("Porvera ulazi li u metodu")
        })
        .catch(error=>{
            console.error('Neuspesan prikaz knjige',error)
            this.poruka="Knjiga nije pronadjena."
        })
    
    },
    methods:{
        test(naziv){
            this.$router.push("/knjiga/"+naziv);
        }
    }


};
   
</script>
<style scoped>
.section-title {
  color: #8B4513; /* Pastelna braon boja za naslov */
  font-size: 24px;
  margin-top: 1rem;
}

.book-list {
  list-style-type: none;
  padding: 0;
  margin: 0;
}

.knjiga-item {
  background-color: #D2B48C; /* Pastelna svetlo braon boja */
  padding: 1rem;
  margin-bottom: 1rem;
  border-radius: 5px;
}

.knjiga-naslov {
  color: #3e2723; /* Tamnija nijansa braon boje za naslov */
  margin-bottom: 0.5rem;
}
</style>
