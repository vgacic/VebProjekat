<template>
    {{ data.naziv }}

    <router-link :to="'/knjiga/' + knjiga.id" v-for="knjiga in data.knjige" :key="knjiga.id">{{ knjiga.naslov }}</router-link>
</template>

<script>
export default {
    name: "PolicaComp",
    props: ["data"]
}
</script>