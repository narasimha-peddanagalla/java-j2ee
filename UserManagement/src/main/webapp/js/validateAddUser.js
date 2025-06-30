document.getElementById("userForm").addEventListener("submit", function(event) {
  event.preventDefault();

  // Get Input Values
  const name = document.getElementById("name").value.trim();
  const email = document.getElementById("email").value.trim();
  const contact = document.getElementById("contact").value.trim();
  const password = document.getElementById("password").value.trim(); // ✅ YOU MISSED THIS LINE

  // Clear previous messages
  const responseMsg = document.getElementById("responseMsg");
  responseMsg.textContent = "";
  responseMsg.style.color = "";

  // Validations
  if (name.length < 3) {
    responseMsg.textContent = "Name should contain at least 3 characters";
    responseMsg.style.color = "red";
    return;
  }

  const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailPattern.test(email)) {
    responseMsg.textContent = "Invalid Email Address";
    responseMsg.style.color = "red";
    return;
  }

  const contactPattern = /^\d{10}$/;
  if (!contactPattern.test(contact)) {
    responseMsg.textContent = "Contact Number should be 10 digits";
    responseMsg.style.color = "red";
    return;
  }

  if (password.length < 6) {
    responseMsg.textContent = "Password should be at least 6 characters long";
    responseMsg.style.color = "red";
    return;
  }

  // Submit using AJAX
  addUserAjax(name, email, contact, password);
});

function addUserAjax(name, email, contact, password) {
  const params = new URLSearchParams();
  params.append("name", name);
  params.append("email", email);
  params.append("contact", contact);
  params.append("password", password); // ✅ Add this to send password to Java

  const xhr = new XMLHttpRequest();
  xhr.open("POST", "addUser", true);
  xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

  xhr.onload = function () {
    const responseMsg = document.getElementById("responseMsg");
    const trimmed = xhr.responseText.trim();

    if (xhr.status === 200 && trimmed === "success") {
      responseMsg.textContent = "User added successfully!";
      responseMsg.style.color = "green";
      document.getElementById("userForm").reset();
    } else {
      responseMsg.textContent = "Failed to add user.";
      responseMsg.style.color = "red";
    }
  };

  xhr.send(params.toString());
}
