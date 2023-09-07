<template>
  <div class="pocetna">
    <div class="goodreads">
      <p class="good">good</p><p class="reads">reads</p>
    </div>
    <img src="@/assets/pozadinaSajt.jpg" alt="" class="slika" />
  </div>
</template>

<script>
// Import PocetnaStranica if needed

export default {
  name: 'PocetnaView',
  components: {
    // Import PocetnaStranica if needed
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

.goodreads {
  text-align: center;
}

.good {
  font-size: 36px; /* Adjust the font size as needed */
  font-style: italic; /* Italic style */
  font-family: 'YourDesiredFont', sans-serif; /* Replace 'YourDesiredFont' with the actual font you want to use */
  color: #8B4513; /* Light brown color */
  display: inline; /* Make "good" and "reads" appear inline */
}

.reads {
  font-size: 36px; /* Adjust the font size as needed */
  font-style: italic; /* Italic style */
  font-family: 'YourDesiredFont', sans-serif; /* Replace 'YourDesiredFont' with the actual font you want to use */
  color: darkbrown; /* Dark brown color */
  display: inline; /* Make "good" and "reads" appear inline */
}
</style>
