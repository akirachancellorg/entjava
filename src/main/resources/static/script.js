console.log("Script loaded"); // Add this at the top of script.js

document.getElementById('nameForm').addEventListener('namesubmit', function(event) {
    event.preventDefault();
    const nameInput = document.getElementById('nameInput').value;
    console.log("Submitting:", nameInput); // Log the input

    fetch('http://localhost:8081/process', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name: nameInput }),
    })
        .then(response => response.json())
        .then(data => {
            const resultDiv = document.getElementById('result');
            resultDiv.textContent = `Processed Name: ${data.first} ${data.last}`;
        })
        .catch(error => {
            console.error('Error:', error);
            document.getElementById('result').textContent = 'An error occurred. Please try again.';
        });
});

document.getElementById('emailForm').addEventListener('emailsubmit',function(event) {
    event.preventDefault();
    const emailInput = document.getElementById('emailInput').value;
    console.log("Submitting:", emailInput); // Log the input

    fetch('http://localhost:8081/process', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email: emailInput }),
    })
        .then(response => response.json())
        .then(data => {
            const resultDiv = document.getElementById('result');
            resultDiv.textContent = `Processed Email: ${data.email}`;
        })
        .catch(error => {
            console.error('Error:', error);
            document.getElementById('result').textContent = 'An error occurred. Please try again.';
        });
})