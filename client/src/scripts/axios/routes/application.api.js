import {get} from "../configuration/instance";

const TRIPS = "/api/trips/";
const TRIP_BY_ID = (tripId) => `/api/trips/${tripId}`;

export default class ApplicationApi {
    getTrip(tripId) {
        return get(TRIP_BY_ID(tripId))
    }

    getTrips() {
        return get(TRIPS)
    }
}
