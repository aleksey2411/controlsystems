import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import ArgonDashboard from "./plugins/argon-dashboard";
import "element-plus/lib/theme-chalk/index.css";

const app = createApp(App);

app.use(router);
app.use(ArgonDashboard);

app.mount("#app");
