<template>
    <KnjigaComp  v-if="this.knjiga" :data="this.knjiga"/>

    <form>
        <input type="text" id="nazivPolice" v-model="query">
        <button v-on:click="submit()">Dodaj na policu</button>
        <router-link :to="'/izmenaKnjige/'+this.knjiga.id" v-if="admin ||jeLiMoja">Izmeni knjigu</router-link>
    </form>
</template>

<script>
import KnjigaComp from "@/components/KnjigaComp.vue"
import axios from 'axios'

export default {
    name: "KnjigaView",
    components: {
        KnjigaComp
    },
    data() {
        return {
            knjiga: null,
            admin: false,
            jeLiMoja:false
        }
    },
    created() {
        const id = this.$route.params.id
        axios
        .get('http://localhost:8880/api/knjiga/' + id)
        .then(response => {
            this.knjiga = response.data
        })
        .catch(error => {
            console.error(error);
        })

        axios.get('http://localhost:8880/api/admin', {withCredentials:true}).then(response => { this.admin = response.data}).catch(error=>{console.error(error)})

        axios.get('http://localhost:8880/api/autor', {withCredentials:true}).then(response => { this.jeLiMoja = response.data}).catch(error=>{console.error(error)})
    },
    submit()
    {
        //dodavanje knjige na policu
    }
}
</script>