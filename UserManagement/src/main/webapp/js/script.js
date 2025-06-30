document.getElementById("userForm").addEventListener("submit", function(event) {
  event.preventDefault();

  const name = document.getElementById("name").value;
  const email = document.getElementById("email").value;
  const contact = document.getElementById("contact").value;
  const password = document.getElementById("password").value;


  const params = new URLSearchParams();
  params.append("name", name);
  params.append("email", email);
  params.append("contact", contact);
  params.append("password", password);

  const xhr = new XMLHttpRequest();
  xhr.open("POST", "addUser", true);
  xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

  xhr.onload = function() {
    if (xhr.status === 200) {
      window.location.href = "viewUsers"; // redirect to user list
    } else {
      document.getElementById("responseMsg").textContent = "Failed to add user.";
    }
  };

  xhr.send(params.toString());
});
