function toggleMenu() {
    const menu = document.getElementById('menu');
    const toggleButton = document.querySelector('.menu-toggle');
    const isExpanded = toggleButton.getAttribute('aria-expanded') === 'true';

    console.log('Menu toggled');  // Agrega este log para verificar que la función se está ejecutando

    toggleButton.setAttribute('aria-expanded', !isExpanded);
    menu.style.display = isExpanded ? 'none' : 'flex';
}