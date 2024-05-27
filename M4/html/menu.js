// scripts.js

document.addEventListener("DOMContentLoaded", function() {
    const introImage = document.getElementById("introImage");
    const introSection = document.getElementById("intro");
    const indexSection = document.getElementById("index");
    const header = document.querySelector("header");
    const footer = document.querySelector("footer");

    introImage.addEventListener("click", function() {
        introSection.style.transform = "translateY(-100%)";
        setTimeout(() => {
            introSection.classList.add("hidden");
            header.classList.remove("hidden");
            footer.classList.remove("hidden");
            header.classList.add("visible");
            footer.classList.add("visible");
            indexSection.classList.remove("hidden");
        }, 1000); // Corresponde al tiempo de transición en CSS
    });
});
