<template>
    {{ data.naziv }}
    <ul>
        <li v-for="knjiga in data.knjige" :key="knjiga.id">
            <router-link :to="'/knjiga/' + knjiga.id">{{ knjiga.naslov }}</router-link>
            {{ knjiga.ocena }}
            <router-link v-if="knjiga.ocena===null" :to="'/dodajRecenziju/'+knjiga.idStavke">Dodaj recenziju</router-link>
            <router-link v-else :to="'/izmeniRecenziju/'+knjiga.idStavke">Izmeni recenziju</router-link>
        </li>
    </ul>
    
</template>

<script>
export default {
    name: "PolicaComp",
    props: ["data"]
}
</script>