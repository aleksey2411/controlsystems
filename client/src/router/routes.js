import Layout from "../layout/Layout";
import Booking from "../views/Booking";
import TripDetails from "../views/TripDetails";
import Login from "../views/Auth/Login";
import Register from "../views/Auth/Register";

const routes = [
  {
    path: "/",
    redirect: "/booking",
    name: "layout",
    component: Layout,
    children: [
      {
        path: "/booking",
        name: "booking",
        components: {default: Booking}
      },
      {
        path: "/booking/trip/:id",
        name: "trip-details",
        components: {default: TripDetails}
      },
      {
        path: "/login",
        name: "login",
        components: {default: Login}
      },
      {
        path: "/register",
        name: "register",
        components: {default: Register}
      }
    ]
  }
];

export default routes;
