<template>
    <PolicaComp  v-if="polica" :data="polica"/>
</template>

<script>
import PolicaComp from "@/components/PolicaComp.vue"
import axios from 'axios'

export default {
    name: "PolicaView",
    components: {
        PolicaComp
    },
    data() {
        return {
            polica: null
        }
    },
    created() {
        const id = this.$route.params.id
        axios
        .get('http://localhost:8880/api/polica/' + id)
        .then(response => {
            this.polica = response.data
        })
        .catch(error => {
            console.error(error);
        })
    }
}
</script>