// script.js

document.addEventListener("DOMContentLoaded", function() {
    const sections = document.querySelectorAll("section");

    sections.forEach(section => {
        section.querySelector(".section-title").addEventListener("click", () => {
            section.classList.toggle("active");
        });
    });
});

function toggleMenu() {
    const menu = document.getElementById("menu");
    menu.classList.toggle("show");
}
