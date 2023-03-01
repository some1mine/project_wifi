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
        <form method="post" action="/bookmark-group-add">
            <table>
                <tr>
                    <th>북마크 이름</th>
                    <td><input type="text" id="bookmark_name" name="bookmark_name"></td>
                </tr>
                    <th>순서</th>
                    <td><input type="number" id="ord" name="ord"></td>
                </tr>
            </table>
            <button type="submit">추가</button>
        </form>
    </body>
</html>