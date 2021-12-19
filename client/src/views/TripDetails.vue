<template>
  <div v-if="isTripLoaded" class="col">
    <div class="card shadow">
      <div class="table-responsive">
        <table class="table tablesorter table align-items-center table-flush">
          <thead class="thead-light">
            <tr>
              <th>Дата</th>
              <th>Время</th>
              <th>Маршрут</th>
              <th>Водитель</th>
              <th>Рейтинг водителя</th>
              <th>Автомобиль</th>
              <th>Детали</th>
              <th></th>
            </tr>
          </thead>
          <tbody class="list">
            <tr>
              <th scope="row">
                <div class="media align-items-center">
                  <div class="media-body">
                    <span class="name mb-0 text-sm">{{ data.trip.date }}</span>
                  </div>
                </div>
              </th>
              <td class="budget">
                <div class="">{{ data.trip.departureDateTime }}</div>
                <div class="">{{ data.trip.arrivalDateTime }}</div>
              </td>
              <td>
                <div class="">{{ data.trip.routeDTO.departureCityDTO.name }}</div>
                <div class="">{{ data.trip.routeDTO.arrivalCityDTO.name }}</div>
              </td>
              <td>
                <div>
                  {{ data.trip.driverDTO.firstName }}
                  {{ data.trip.driverDTO.lastName }}
                </div>
              </td>
              <td>
                <div class="d-flex align-items-center">
                  <span class="completion mr-2">90%</span>
                  <div>
                    <div class="progress-wrapper pt-0">
                      <!---->
                      <div class="progress" style="height: 3px">
                        <div
                          class="progress-bar bg-warning"
                          role="progressbar"
                          aria-valuenow="90"
                          aria-valuemin="0"
                          aria-valuemax="100"
                          style="width: 90%"
                        ></div>
                      </div>
                    </div>
                  </div>
                </div>
              </td>
              <td class="text-left">
                {{ data.trip.busDTO.mark }}
                {{ data.trip.busDTO.model }},
                {{ data.trip.busDTO.color }},
                {{ data.trip.busDTO.number }}
              </td>
              <td class="text-left">
                <div>{{ data.trip.busDTO.numberOfSeats }} мест</div>
                <div>{{ data.trip.routeDTO.cost }} BYN</div>
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
  <div v-if="isTripLoaded" class="container mt-loaded"/>
  <div v-else class="container mt-10"/>
</template>

<script>
import {onMounted, reactive, ref} from "vue";
import { api } from "../scripts/axios/axios";
import { useRoute } from "vue-router";

export default {
  name: "trip-details",
  setup() {
    const route = useRoute();
    const isTripLoaded = ref(false);
    const data = reactive({
      trip: '',
    });

    onMounted(() => {
      console.log(route.params.id)
      api.application.getTrip(route.params.id).then((response) => {
        data.trip = response.data;
        let departure = new Date(data.trip.departureDateTime);
        let arrival = new Date(data.trip.arrivalDateTime);
        data.trip.date = departure.toLocaleDateString();
        data.trip.departureDateTime = departure.toLocaleTimeString();
        data.trip.arrivalDateTime = arrival.toLocaleTimeString();
        if (data.trip.length !== 0) {
          isTripLoaded.value = true;
        }
      });
    });

    return {
      data,
      isTripLoaded
    };
  },
};
</script>

<style scoped>
.mt-10 {
  margin-top: 422px;
}
.mt-loaded {
  margin-top: 219px;
}
</style>
