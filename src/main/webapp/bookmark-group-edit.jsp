<%@ page import="com.example.project_wifi.BookmarkGroup" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <style>
            table {
                width : 100%;
            }
            tr {
                width : 100%;
                height : 20px;
            }
            th {
                background-color : green;
                color : white;
            }
            td, tr {
                border : 1px solid #444444;
            }
        </style>
        <title>와이파이 정보 구하기</title>
    </head>
    <body>
        <h1> 위치 히스토리 목록 </h1>
        <a href = "${pageContext.request.contextPath}/"> 홈 </a> | <a href = "${pageContext.request.contextPath}/history"> 위치 히스토리 목록 </a> |
        <a href = "load-wifi"> Open API 와아파이 정보 가져오기 </a> |
        <a href = "bookmark-list"> 즐겨 찾기 보기 </a> | <a href = "bookmark-group"> 즐겨 그룹 관리 </a><br>
        <form method="post" action="/bookmark-group-edit">
            <table>
                <tr>
                    <th>북마크 이름</th>
                    <td>
                        <%
                            BookmarkGroup group = (BookmarkGroup) request.getAttribute("group");
                            String bookmarkName = group.getBookmarkName();
                            out.print("<input type='text' id='bookmark_name' name='bookmark_name' value='" + bookmarkName + "'>");
                        %>
                    </td>
                </tr>
                    <th>순서</th>
                    <td>
                        <%
                            int ord = group.getOrd();
                            out.print("<input type='number' id='ord' name='ord' value=" + ord + ">");
                        %>
                    </td>
                </tr>
                <%
                    int id = (int) request.getAttribute("id");
                    out.print("<input type='hidden' id='id' name='id' value=" + id + ">");
                %>
            </table>
            <button type="button" onclick="location.href='bookmark-group'">돌아가기</button> | <button type="submit">수정</button>
        </form>
    </body>
</html>