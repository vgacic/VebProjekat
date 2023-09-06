<template>
    <KnjigaComp  v-if="knjiga" :data="knjiga"/>

    <form>
        <input type="text" id="nazivPolice" v-model="query">
        <button v-on:click="submit()">Dodaj na policu</button>
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
            knjiga: null
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
    },
    submit()
    {
        //dodavanje knjige na policu
    }
}
</script>