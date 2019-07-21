<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<html lang="en">
<head>

    <script type="text/javascript" src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>

    <script>

        var goEasy = new GoEasy({appkey: "BC-8337111ed1794dada1c2051b702a2ac4"});
        goEasy.subscribe(
            {channel: "154_channel",
             onMessage: function(message){
                alert('收到：'+message.content);
             }
            });



    </script>

</head>
<body>

</body>
</html>