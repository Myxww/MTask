<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sum</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <script>
            function rBar() {
                var bar = document.getElementById("progressBar");
                bar.style.width = "0%";
                bar.setAttribute("aria-valuenow", 0);
                bar.classList.add("progress-bar-animated");
            }

            function submitAdd() {
                var number1 = document.getElementById("number1").value;
                var number2 = document.getElementById("number2").value;
                var http = new XMLHttpRequest();
                http.open("POST", "Controller", true);
                http.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
                http.onreadystatechange = function () {

                    if (http.readyState === 4 && http.status === 200) {
                        var result = http.responseText;
                        var bar = document.getElementById("progressBar");
                        var barEle = document.getElementById("progressBarValue");
                        bar.style.width = "100%";
                        bar.setAttribute("aria-valuenow", 100);
                        bar.classList.remove("progress-bar-animated");
                        barEle.innerHTML = result;

                    }
                };

                http.send("number1=" + number1 + "&number2=" + number2);
                resetProgressBar();
            }
            function refreshPage() {
                location.reload();
            }
        </script>
    </head>
    <body onload="rBar()">
        <div class="container text-center">
            <h1>Cộng hai số lớn</h1><br/><br/>
            <form>
                <div class="form-group">
                    <label for="number1">Số thứ 1</label>
                    <input type="text" class="form-control" id="number1" value=""/>
                </div>
                <div class="form-group">
                    <label for="number2">Số thứ 2</label>
                    <input type="text" class="form-control" id="number2" value=""/>
                </div>
                <button type="button" class="btn btn-primary" onclick="submitAdd()" onmouseenter="rBar()">Cộng</button><br/><br/>
            </form>
            <div class="progress progress-sm">
                <div id="progressBar" class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%"></div>
            </div><br/>

            <div id="progressBarValue"></div>
        </div>
    </body>
</html>