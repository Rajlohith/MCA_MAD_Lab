if ("serviceWorker" in navigator) {
    window.addEventListener("load", () => {
    navigator.serviceWorker.register("serviceworker.js")
        .then((registration) => {
            console.log("Service Worker registered:", registration.scope);
        })
        .catch((error) => {
            console.log("Registration failed:", error);
        });
    });
}