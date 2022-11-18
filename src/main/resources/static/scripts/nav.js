// the empty div to be filled in the html
const divToBeFilled = document.getElementById("users-to-be-filled-from-db");

// The server request
const asyncRequest = new XMLHttpRequest();


// the last part of the url
const queryString = window.location.pathname;
const lastSegment = queryString.split("/").pop();


if (lastSegment === "/") {
    getSensorInfoFromDB();
    }


function getSensorInfoFromDB() {
    asyncRequest.addEventListener("load", fillFieldsWithResponse);

    asyncRequest.open("GET", "/");
    asyncRequest.setRequestHeader("Accept", "application/json");
    asyncRequest.setRequestHeader("Content-Type", "application/json");
    asyncRequest.send();
    asyncRequest.onreadystatechange = onResponseReceivedFromGET;



    function fillFieldsWithResponse() {
        let responseJson = JSON.parse(this.responseText);
        if (responseJson.length !== 0){
            for (let i = 0; i<responseJson.length;i++){
                let customerJson = responseJson[i];
                let firstName = customerJson.firstName;
                let email = customerJson.email;
                let active = customerJson.active;
                let role = customerJson.role;

                let tag = document.createElement("div");

                if (active.toString() === "true"){
                    tag.innerHTML =
                        '<label for="firstName">Firstname</label>' + '<input class="firstName" type="text" value="'+ firstName +'">' +
                        '<label for="email">Email</label>' + '<input class="email" type="email" value="'+ email +'">' +
                        '<label for="active">Active</label>' + '<input class="active" type="checkbox" checked>'+
                        '<label for="email">Role</label>' + '<input class="email" type="email" value="'+ role +'">'
                }else{
                    tag.innerHTML =
                        '<label for="firstName">Firstname</label>' + '<input class="firstName" type="text" value="'+ firstName +'">' +
                        '<label for="email">Email</label>' + '<input class="email" type="email" value="'+ email +'">' +
                        '<label for="active">Active</label>' + '<input class="active" type="checkbox">'+
                        '<label for="email">Role</label>' + '<input class="email" type="email" value="'+ role +'">'
                }

                divToBeFilled.appendChild(tag);
            }
        }else{
            divToBeFilled.innerText = "No products in database";
        }
    }
}