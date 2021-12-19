<template>
  <nav class="navbar mt-0 navbar-expand-lg navbar-light bg-white">
    <div class="container">
      <button
        @click="$router.push('/booking')"
        class="btn btn-outline-secondary btn-lg"
      >
        <i class="ni ni-delivery-fast" />
        <span class="nav-link-inner--text text-dark text-lg">Поездки</span>
      </button>
      <ul class="navbar-nav align-items-lg-center ml-lg-auto">

        <li class="nav-item d-none d-lg-block ml-lg-4">
          <button
              @click="$router.push('login')"
              class="btn btn-icon btn-outline-secondary">
            <i class="ni ni-circle-08" />
            <span class="nav-link-inner--text text-dark text-lg">Войти</span>
          </button>
        </li>
      </ul>
    </div>
  </nav>
</template>
<script>
export default {
  name: "app-header",
};
</script>
<style></style>
