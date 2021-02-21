<%@ page import = "java.io.*,java.util.*" %>
<%
    // Get session creation time.
    Date createTime = new Date(session.getCreationTime());

    // Get last access time of this Webpage.
    Date lastAccessTime = new Date(session.getLastAccessedTime());

    String title = "Welcome Back to my website";
    Integer visitCount = new Integer(0);
    String visitCountKey = new String("visitCount");
    String userIDKey = new String("userID");

    if (session.isNew() ){
        title = "Welcome to my website";

        session.setAttribute(visitCountKey,  visitCount);
    }
    visitCount = (Integer)session.getAttribute(visitCountKey);
    visitCount = visitCount + 1;
    session.setAttribute(visitCountKey,  visitCount);
%>

<html>
<head>
    <title>Wejscia</title>
</head>

<body>
<center>
    <h1>Session Tracking</h1>
</center>

<table border = "1" align = "center">
    <tr bgcolor = "#949494">
        <th>Wejscia</th>
        <th>Value</th>
    </tr>

    <tr>
        <td>Number of visits</td>
        <td><% out.print(visitCount); %></td>
    </tr>
</table>

</body>
</html>