document.getElementById('validationForm').addEventListener('submit', async function(event) {
    event.preventDefault();
    
    const email = document.getElementById('email').value;
    const fullName = document.getElementById('full-name').value;
    const message = document.getElementById('message');
    const form = document.getElementById('validationForm');
    // Clear previous results
    message.innerHTML = '';

    // Create Fragment
    const messageFragment = document.createDocumentFragment('');
    
    const local = 'http://localhost'
    const port = '8080'
    const success = true

    try {
        const first = document.getElementById('first')
        const last = document.getElementById('last')
        const nameMessage = document.getElementById('name-message');
        // Parse name
        const nameResponse = await fetch(`${local}:${port}/parse/name?name=${fullName}`);
        const parsedName = await nameResponse.json();
        console.log(parsedName);

        if (parsedName.error) {
            message.innerHTML += `<p style="color: red">Error parsing name: ${parsedName.error}</p>`;
        } else {
            first.value = parsedName.first
            last.value = parsedName.last
        }
    } catch (error) {
        message.innerHTML += `<p>Error: ${error.message}</p>`;
        success = false
    }

    try {
        // Validate email
        const emailResponse = await fetch(`${local}:${port}/validate/email?email=${email}`);
        const isEmailValid = await emailResponse.json();
        console.log(isEmailValid)

        if (!isEmailValid) {
            message.innerHTML += `<p style="color: red">Email is invalid.</p>`;
        } else {
            message.innerHTML += `<p style="color: green">Email is valid.</p>`;
        }
    } catch (error) {
        message.innerHTML += `<p>Error: ${error.message}</p>`;
        success = false
    }

    if (success) {
        alert('Success')
    }

});