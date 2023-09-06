<template>
</template>


<script>

//import axios from 'axios'
export default{
    name: "LogoutView",
    mounted: function () {
            fetch('http://localhost:8880/api/odjava',{
        method: 'POST',
        credentials: 'include',
        headers: {
          'Content-Type': 'application/json'
        },})
            .then(response => response.json())
                .then(data => {console.log("Success:", JSON.stringify(data));})
                .then (this.$router.push('/pocetna'))
                .catch((error) => {
                    console.error("Error:", error);
                });    
        }
}
</script>