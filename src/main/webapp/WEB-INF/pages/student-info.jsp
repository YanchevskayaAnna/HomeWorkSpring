<%@ include file="include.jsp"%>
<html>
<head>
  <title>User Info</title>
</head>
<body>

<%--<% Student transfered = (Student) request.getAttribute("student");%>--%>
<c:set var="transfered" value="${student}"/>


<div class="container">
  <ul>
    <li>
      <div class="column">
        id : ${transfered.id}
      </div>
    </li>

    <li>
      <div class="column">
        name : ${transfered.name}
      </div>
    </li>

    <li>
      <div class="column">
        group : ${transfered.group}
      </div>
    </li>

  </ul>
</div>
</body>
</html>
