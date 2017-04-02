<%@ page import="twitter4j.Twitter,com.github.q9029.aikatsustars.controller.constant.ControllerConst" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8" />
        <title>AikatsuStars</title>
    </head>
    <body>
        <a href="/signin">Sigin in with Twitter.</a>
        <%
        if (session.getAttribute(ControllerConst.Session.TWITTER) != null) {
        Twitter twitter = (Twitter) session.getAttribute(ControllerConst.Session.TWITTER);
        out.println("<p>Welcome " + twitter.getId() + "</p>");
        }
        %>
    </body>
</html>
