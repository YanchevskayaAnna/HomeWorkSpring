<%@ include file="include.jsp"%>

<html>

    <head>
        <title> Average rating of group</title>

        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
              integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
              crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
              integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
              crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
                integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
                crossorigin="anonymous"></script>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

    </head>

    <body>
    <div class="container">
        <label>Input group id</label>
        <input id="groupid" type="text">
        <button onclick="getAverageRatingGroup()">Average rating group</button>
        <div id="responseText"></div>
    </div>
    </body>

    <script>
        function getAverageRatingGroup() {

            var groupid  = $("#groupid").val();

            var confobj = {
                type:"POST",
                url:"averageRatingGroup",
                data:{groupid:groupid},
                success:function (result) {
                    $("#responseText").html(result);
                }
            };

            $.ajax(confobj);
        }

    </script>

</html>