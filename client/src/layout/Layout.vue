<template>
  <app-header/>
  <router-view/>
  <app-footer/>
</template>

<script>

import AppHeader from './AppHeader';
import AppFooter from './AppFooter';
export default {
  name: 'layout',
  components: {
    AppHeader,AppFooter
  },

};
</script>

<style>

</style>