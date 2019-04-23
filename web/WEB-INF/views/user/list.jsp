<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/17 0017
  Time: 下午 4:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>list</title>
</head>
<body>

    <table>
        <tr>
            <th>编号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>
                <a href="/user/delete/${user.id}">删除</a>
                <a href="/user/queryOne/${user.id}">修改</a>
            </td>
        </tr>
        </c:forEach>
        <tr>
            <td colspan="4">
                <c:if test="${pageIndex>1}">
                    <a href="/user/queryPage?pageIndex=${pageIndex-1}">上一页</a>
                </c:if>
                <c:choose>
                    <c:when test="${pages<=10}">
                        <c:set var="start" value="1"></c:set>
                        <c:set var="end" value="${pages}"></c:set>
                    </c:when>
                    <c:otherwise>
                        <c:set var="start" value="${pageIndex-5}"></c:set>
                        <c:set var="end" value="${pageIndex+4}"></c:set>
                        <c:if test="${pageIndex-5<1}">
                            <c:set var="start" value="1"></c:set>
                            <c:set var="end" value="10"></c:set>
                        </c:if>
                        <c:if test="${pageIndex+4>pages}">
                            <c:set var="start" value="${pages-9}"></c:set>
                            <c:set var="end" value="${pages}"></c:set>
                        </c:if>
                    </c:otherwise>
                </c:choose>

                <c:forEach var="i" step="1" begin="${start}" end="${end}">
                   <c:if test="${pageIndex==i}">
                       【${i}】
                   </c:if>
                   <c:if test="${pageIndex!=i}">
                      <a href="/user/queryPage?pageIndex=${i}">【${i}】</a>
                   </c:if>
                </c:forEach>
                <c:if test="${pageIndex<pages}">
                    <a href="/user/queryPage?pageIndex=${pageIndex+1}">下一页</a>
                </c:if>
            </td>
        </tr>
    </table>
    <a href="/user/toadd" >添加</a>
</body>
</html>
