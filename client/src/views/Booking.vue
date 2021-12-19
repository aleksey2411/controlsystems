<template>
  <div v-if="true" class="col">
    <div class="card shadow">
      <div class="table-responsive">
        <table class="table tablesorter table align-items-center table-flush">
          <thead class="thead-light">
          <tr>
            <th>Дата</th>
            <th>Время</th>
            <th>Маршрут</th>
            <th>Детали</th>
            <th></th>
          </tr>
          </thead>
          <tbody class="list">
          <tr v-for="trip of data.trips" :key="trip.id" :value="trip.id">
            <th scope="row">
              <div class="media align-items-center">
                <div class="media-body">
                  <span class="name mb-0 text-sm">{{ trip.date }}</span>
                </div>
              </div>
            </th>
            <td class="budget">
              <div class="">{{ trip.departureDateTime }}</div>
              <div class="">{{ trip.arrivalDateTime }}</div>
            </td>
            <td>
              <div class="">
                {{ trip.routeDTO.departureCityDTO.name }}
              </div>
              <div class="">
                {{ trip.routeDTO.arrivalCityDTO.name }}
              </div>
            </td>
            <td class="text-left">
              <div>{{ trip.busDTO.numberOfSeats }} мест</div>
              <div>{{ trip.routeDTO.cost }} BYN</div>
            </td>
            <td>
              <button @click="$router
                .push({ name: 'trip-details', params: { id: trip.id } })" class="btn btn-danger">
                Детали
              </button>
            </td>
          </tr>
          </tbody>
        </table>

      </div>
    </div>
  </div>


    <div class="container mt-8">
      <img class="img-center" src="/img/not_found.jpeg" width="600" alt=""/>
    </div>
  <div v-if="isTripsLoaded" class="container mt-loaded"/>
    <div v-else class="container mt-10"/>
</template>

<script>
import {onMounted, ref, reactive} from "vue";
import {api} from "../scripts/axios/axios";

export default {
  name: "booking",
  setup() {
    const isTripsLoaded = ref(false)
    const data = reactive({
      trips: [],
    });

    onMounted(() => {
      api.application.getTrips().then((response) => {
        data.trips = response.data;
        data.trips.forEach((trip) => {
          let departure = new Date(trip.departureDateTime);
          let arrival = new Date(trip.arrivalDateTime);
          trip.date = departure.toLocaleDateString();
          trip.departureDateTime = departure.toLocaleTimeString();
          trip.arrivalDateTime = arrival.toLocaleTimeString();
          if (data.trips.length !== 0) {
            isTripsLoaded.value = true;
          }
        })

      });
    });
    return {
      data,
      isTripsLoaded
    };
  },
};
</script>

<style scoped>
.mt-10 {
  margin-top: 294px;
}
.mt-loaded {
  margin-top: 143px;
}
</style>
