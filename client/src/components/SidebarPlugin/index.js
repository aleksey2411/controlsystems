import Sidebar from "./SideBar.vue";
import SidebarItem from "./SidebarItem.vue";
import { reactive } from "vue";

const SidebarStore = reactive({
  showSidebar: false,
  sidebarLinks: [],
  isMinimized: false,
  displaySidebar(value) {
    this.showSidebar = value;
  },
  toggleMinimize() {
    document.body.classList.toggle("sidebar-mini");
    const simulateWindowResize = setInterval(() => {
      window.dispatchEvent(new Event("resize"));
    }, 180);

    setTimeout(() => {
      clearInterval(simulateWindowResize);
    }, 1000);

    this.isMinimized = !this.isMinimized;
  },
});

const SidebarPlugin = {
  install(app, options) {
    if (options && options.sidebarLinks) {
      SidebarStore.sidebarLinks = options.sidebarLinks;
    }

    app.config.globalProperties.$sidebar = SidebarStore;
    app.component("side-bar", Sidebar);
    app.component("sidebar-item", SidebarItem);
  },
};

export default SidebarPlugin;
