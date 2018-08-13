 <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h2>Please enter your user id and password to sign in.</h2>
<form:form action="${pageContext.request.contextPath}/login" method="post" modelAttribute="loginForm">				
  <c:if test="${message != ''}">${message} </c:if>
  <table>
   <tr>
    <td>User:</td>
    <td><input type='text' name='username' value=''>
    </td>
   </tr>
   <tr>
    <td>Password:</td>
    <td><input type='password' name='password' />
    </td>
   </tr>
   <tr>
    <td colspan='2'><input name="submit" type="submit"
     value="submit" />
    </td>
   </tr>
   <tr>
    <td colspan='2'><input name="reset" type="reset" />
    </td>
   </tr>
  </table>
 
 </form:form>


 
 