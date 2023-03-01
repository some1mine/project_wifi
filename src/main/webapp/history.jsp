<%@ page import="java.util.List" %>
<%@ page import="com.example.project_wifi.History" %>
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
                height : 100px;
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

        <table>
            <thead>
            <tr>
                <th> ID </th>
                <th> X좌표 </th>
                <th> Y쫘표 </th>
                <th> 조회일자 </th>
                <th> 비고</th>
            </tr>
            </thead>
            <tbody>
                <%
                    List<History> historyList = (List<History>) request.getAttribute("historyList");
                    if(historyList != null)  {
                        for(History history : historyList) {
                            out.print("<tr>");
                                out.print("<td>");
                                    out.print(history.getId());
                                out.print("</td>");
                                out.print("<td>");
                                    out.print(history.getLAT());
                                out.print("</td>");
                                out.print("<td>");
                                    out.print(history.getLNT());
                                out.print("</td>");
                                out.print("<td>");
                                    out.print(history.getWORK_DTTM());
                                out.print("</td>");
                                out.print("<td>");
                                    out.print("<button id = 'id" + history.getId() + "' onclick='deleteHistory(" + history.getId() + ");'> 삭제 </button> ");
                                out.print("<td>");
                            out.print("</tr>");
                        }
                    }
                %>
            </tbody>
        </table>

        <script type="text/javascript">

            function success({ coords, timestamp }) {
                const latitude = coords.latitude;   // 위도
                const longitude = coords.longitude; // 경도

                document.getElementById('LAT').value = latitude;
                document.getElementById('LNT').value = longitude;
            }
            function getUserLocation() {
                if (!navigator.geolocation) {
                    throw "위치 정보가 지원되지 않습니다.";
                }
                navigator.geolocation.getCurrentPosition(success);
            }

            function deleteHistory(id) {
                let form = document.createElement("form");
                form.setAttribute("charset", "UTF-8");
                form.setAttribute("method", "Post");
                form.setAttribute("action", "history");

                let hiddenField = document.createElement("input");
                hiddenField.setAttribute("type", "hidden");
                hiddenField.setAttribute("name", "id");
                hiddenField.setAttribute("value", id);
                form.appendChild(hiddenField);
                document.body.appendChild(form);
                form.submit();
            }
        </script>
    </body>
</html>