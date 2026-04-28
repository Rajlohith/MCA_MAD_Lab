localStorage.setItem("username", "rvce");
localStorage.setItem("password", "rvce");

function verify() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    let un = localStorage.getItem("username");
    let pas = localStorage.getItem("password");

    if (username === un && password === pas) {
        alert("Authentication done");
    } else {
        alert("Authentication failure");
    }
}