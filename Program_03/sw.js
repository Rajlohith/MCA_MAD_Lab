if ("serviceWorker" in navigator) {
  window.addEventListener("load", () => {
    navigator.serviceWorker.register("./serviceworker.js")
      .then(registration => console.log("SW registered", registration.scope))
      .catch(error => console.log("SW failed", error));
  });
}