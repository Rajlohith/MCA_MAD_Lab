if ('serviceWorker' in navigator) {
    navigator.serviceWorker.register("./sw.js")
        .then((reg) => console.log("Registered", reg))
        .catch((err) => console.log("Error", err));
} else {
    console.log('No service worker support in this browser');
}