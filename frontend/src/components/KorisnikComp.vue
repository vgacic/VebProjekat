<template>
    <p>Ime: {{data.ime}}</p>
    <p>Prezime: {{data.prezime}}</p>
    <p>Korisnicko ime: {{data.korisnickoIme}}</p>
    <p>E-mail: {{data.email}}</p>
    <p>Lozinka: {{data.lozinka}}</p>
    <p>Datum rodjenja: {{data.datumRodjenja}}</p>
    <p>Profilna slika:{{data.profilnaSlika}}</p>
    <p>Opis: {{data.opis}} </p>
    <p>Uloga: {{data.uloga}}</p>
    <p>Police:</p>

    <router-link :to="'/polica/'+polica.id" v-for="polica in data.police" :key="polica.id"> |{{polica.naziv}}|</router-link>
</template>
<script>
export default{
    name:'KorisnikComp',
    props:["data"]
}

</script>
