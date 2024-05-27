function toggleMenu() {
    const menu = document.getElementById('menu');
    const toggleButton = document.querySelector('.menu-toggle');
    const isExpanded = toggleButton.getAttribute('aria-expanded') === 'true';

    toggleButton.setAttribute('aria-expanded', !isExpanded);
    menu.style.display = isExpanded ? 'none' : 'flex';
}
