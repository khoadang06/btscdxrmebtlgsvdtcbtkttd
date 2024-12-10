<script setup>
import HeaderLayout from '@/layout/HeaderLayout.vue'
import FooterLayout from '@/layout/FooterLayout.vue'
</script>
<template>
  <HeaderLayout/>
    <main>
      <RouterView/>
    </main>
  <FooterLayout/>
</template>
