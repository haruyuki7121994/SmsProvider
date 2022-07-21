<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create</title>
</head>
<body>
<label>Please select service type sms:</label> <br>
<input type="radio" id="vietguys" name="sms" checked value="VIETGUYS">
<label for="html">Vietguys</label><br>
<input type="radio" id="vmgs" name="sms" value="VMGS">
<label for="css">VMGs</label><br>
<input type="radio" id="fpt" name="sms" value="FPT">
<label for="javascript">FPT</label><br>

<label for="phone">Phone: </label><br>
<input id="phone" placeholder="Enter phone number" required><br>
<label for='content'>Content: </label><br>
<textarea id='content'></textarea><br>
<button id='send_snippet' type='submit' onclick='send()'>Submit</button>

<script>
    function send() {
        let object = {
            "phone": document.getElementById("phone").value,
            "content": document.getElementById("content").value,
            "type": document.querySelector('input[name="sms"]:checked').value
        };

        for (const [param, value] of Object.entries(object)) {
            if (value === "") {
                let error = param + " cannot empty"
                alert(error)
                return
            }
        }

        let json = JSON.stringify(object);

        let xhr = new XMLHttpRequest();
        xhr.open("POST", '/api/send', false)
        xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
        xhr.send(json);

        if (xhr.status === 200) {
            alert(JSON.parse(xhr.response).message);
        }
        if (xhr.status === 400) {
            alert("Bad Request!")
        }
        if (xhr.status === 404) {
            alert("Provider not found!")
        }
    }
</script>
</body>
</html>