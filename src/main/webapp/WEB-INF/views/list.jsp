<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
		<table>
			<thead>
				<tr>
					<td>이미지</td>
					<td>제목</td>
					<td>출판사</td>
					<td>ISBN</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="item">
				<tr>
					<td><img src="${item }" alt="" /> </td>
				</tr>
				</c:forEach>
			</tbody>
		</table>