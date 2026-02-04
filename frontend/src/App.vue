<template>
  <div class="app-container">
    <ChatBot />
  </div>
</template>

<script setup lang="ts">
import ChatBot from './components/ChatBot.vue'
</script>

<style>
body {
  margin: 0;
  padding: 0;
  background-color: #f5f5f5;
}

.app-container {
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 20px;
}
</style>
