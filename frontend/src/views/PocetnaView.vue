<template>
<div class="pocetna">
    <PocetnaStranica msg="Dobrodosli"/>
    <img src="@/assets/pozadinaSajt.jpg" alt="" class="slika" />
</div>
        
</template>
<script>

import PocetnaStranica from '@/components/PocetnaStranica.vue'
//import axios from 'axios'

export default{

    name:'PocetnaView',
    components:{
        PocetnaStranica
    }
}
</script>

<style scoped>
.pocetna {
  text-align: center;
}

.slika {
  max-width: 100%;
  height: auto;
  margin-top: 20px;
  border: 2px solid #8B4513; /* Boja okvira (pastelna braon) */
  box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.2); /* Senka */
  border-radius: 10px; /* Zaobljeni uglovi */
}
</style>