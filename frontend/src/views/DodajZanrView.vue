<template>
    <div>
        <h2>Dodavanje zanra</h2>
        <form >
            <label for="naziv">Unesite naziv zanra: </label>
            <input type="text" id="naziv" v-model="zanr.naziv" required>
            <button v-on:click="submit()">Dodaj</button>

        </form>
    </div>
</template>
<script>
import axios from 'axios';

export default{
    name:"DodajZanrView",
    data(){
    return{
        zanr: {
            naziv:""
        }

        }
    },

    methods:{
        submit(){
            
            axios
            .post(`http://localhost:8880/api/dodajZanr`,this.zanr, {withCredentials:true})
            .then(response=>{ 
                console.log("Zanr uspesno dodat",response.data);
            })
            .catch(error=>{
                console.error("Greska pri dodavanju zanra",error)
            })
        }

    }

};

</script>