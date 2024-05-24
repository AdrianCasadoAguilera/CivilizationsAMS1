document.addEventListener('DOMContentLoaded', function() {
    fetch('/run-script')
        .then(response => response.json())
        .then(data => {
            if (data.status === 'success') {
                console.log(data.message);
            } else {
                console.error(data.message);
            }
        })
        .catch(error => console.error('Error:', error));
});
