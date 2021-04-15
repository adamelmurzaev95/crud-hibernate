<%@ page import="model.Programmer" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>Programmer Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: tomato">
        <div>
            <a class="navbar-brand"> Programmer Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">Programmers</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${programmer != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${programmer == null}">
                <form action="insert" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${programmer != null}">
                                Edit Programmer
                            </c:if>
                            <c:if test="${programmer == null}">
                                Add New Programmer
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${programmer != null}">
                        <input type="hidden" name="id" value="<c:out value='${programmer.id}' />" />
                    </c:if>

                    <fieldset class="form-group">
                        <label>Programmer name</label> <input type="text"
                                                       value="<c:out value='${programmer.name}' />" class="form-control"
                                                       name="name" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Programmer surname</label> <input type="text"
                                                        value="<c:out value='${programmer.surname}' />" class="form-control"
                                                        name="surname">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>City</label> <input type="text"
                                                       value="<c:out value='${programmer.city}' />" class="form-control"
                                                       name="city">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Profession</label> <input type="text"
                                                          value="<c:out value='${programmer.profession}' />" class="form-control"
                                                          name="profession">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Wife</label> <input type="text"
                                                value="<c:out value='${programmer.wife}' />" class="form-control"
                                                   name="wife">
                    </fieldset>


                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>