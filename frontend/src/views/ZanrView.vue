<template>
    <div>
        <div>
            <ul class="book-list">
                
                <li v-for="knjiga in knjige" :key="knjiga.id" class="knjiga-item">
                    <p>Naslov {{ knjiga.naslov }}</p>
                    <p>ISBN {{knjiga.isbn}}</p>
                    <p>Datum objavljivanja {{knjiga.datumObjavljivanja }} </p>
                    <p>Broj strana {{ knjiga.brojStrana}}</p>
                    <p>Opis {{ knjiga.opis}}</p>
                    <p>Zanr {{knjiga.zanr.naziv}}</p>
                    <p>Ocena {{ knjiga.ocena }}</p>
                </li>
            </ul>
        </div>
    </div> 
</template>

<script>
import axios from 'axios';

export default {
    name: "ZanrView",
    data() {
        return {
            knjige: []
        }
    },
    created() {
        axios
        .get("http://localhost:8880/api/zanr/" + this.$route.params.id + "/knjige")
        .then(response => {
            this.knjige = response.data
        })
        .catch(error => {
            console.error(error)
        })
    }
}
</script>