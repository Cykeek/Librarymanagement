<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="common/header.jsp" %>

<form action="adminlogin" method='post' class="form-group">
    <input name="email" type="email" placeholder="Enter admin Email" class="form-control">
    <input name="password" type="password" placeholder="Enter Password" class="form-control">
    <button type="submit" value="submit" class="btn btn-danger">Submit</button>
</form>


<script>
    var urlParams = new URLSearchParams(window.location.search);
    var invalid = urlParams.get('invalid');
    if(invalid !== null && invalid === "true") {
        window.alert("Invalid Credentials");
    }
    setTimeout(function(){

        if (document.body.contains(document.querySelector('.alert'))) {
            document.querySelector('.alert button').click();
        }
    });
</script>
<%@ include file="common/footer.jsp" %>