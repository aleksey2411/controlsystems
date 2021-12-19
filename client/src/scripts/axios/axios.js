import ApplicationApi from "./routes/application.api";

const api = {
  application: new ApplicationApi(),
};

export { api };
