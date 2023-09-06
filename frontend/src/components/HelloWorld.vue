<template>
  <div class="hello">
    <h1>{{ message }}</h1>
    <button @click="fetchData">Cao</button>
    
    
    <div v-if="response">
      <h3>Response from Spring Boot:</h3>
      <p>{{ response }}</p>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'HelloWorld',
  data() {
    return {
      message: 'Hello from Vue!',
      response: null,
    };
  },
  methods: {
    fetchData() {
      axios.get('http://localhost:8880/api/cao')
        .then(response => {
          this.response = response.data;
        })
        .catch(error => {
          console.error('Error:', error);
        });
    }
  }
}
</script>

<style scoped>
h3 {
  margin-top: 20px;
}
button {
  margin-top: 10px;
}
</style>