<template>
  <div>
    <h1>Welcome, {{ state.username }}</h1>
    <!-- Your other content goes here -->
  </div>
</template>

<script>
import { reactive, onMounted } from 'vue';
import fetchUsername from '../helpers/fetchUsername';

export default {
  name: 'HomePage',
  setup() {
    const state = reactive({
      username: ''
    });

    onMounted(async () => {
      try {
        state.username = await fetchUsername();
      } catch (error) {
        // Handle error
      }
    });

    return { state };
  }
};

</script>

<style>
/* Your styles go here */
</style>
