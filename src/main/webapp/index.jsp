<%@ page import="java.util.List" %>
<%@ page import="com.example.project_wifi.Wifi" %>
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
        <h1> 와이파이 정보 구하기 </h1>
        <a href = "${pageContext.request.contextPath}/"> 홈 </a> | <a href = "${pageContext.request.contextPath}/history"> 위치 히스토리 목록 </a> |
        <a href = "load-wifi"> Open API 와아파이 정보 가져오기 </a> |
        <a href = "bookmark-list"> 즐겨 찾기 보기 </a> | <a href = "bookmark-group"> 즐겨 그룹 관리 </a><br>

        <form method="GET" action="/index">
            LAT : <input type = "text" id="LAT" name="LAT" value="${empty LAT ? '0.0' : LAT}">. LNT : <input type = "text" id="LNT" name="LNT" value="${empty LNT ? '0.0' : LNT}">
            <button type="button" onclick="getUserLocation();">내 위치 가져오기</button> <button type="submit">근처 WiFi 정보 보기</button>
        </form>
        <table>
            <thead>
            <tr>
                <th> 거리 (Km) </th>
                <th> 관리번호 </th>
                <th> 자치구 </th>
                <th> 와이파이명 </th>
                <th> 도로명주소 </th>
                <th> 상세주소 </th>
                <th> 설치위치(층) </th>
                <th> 설치유형 </th>
                <th> 설치기관 </th>
                <th> 서비스구분 </th>
                <th> 망종류 </th>
                <th> 설치년도 </th>
                <th> 실내외구분 </th>
                <th> WiFi접속환경 </th>
                <th> X좌표 </th>
                <th> Y좌표 </th>
                <th> 작업일자 </th>
            </tr>
            </thead>
            <tbody>
                <%
                    List<Wifi> wifiList = (List<Wifi>) request.getAttribute("wifiList");
                    if(wifiList != null)  {
                        for(Wifi wifi : wifiList) {
                            out.print("<tr>");
                                out.print("<td>");
                                    out.print(wifi.getDistance());
                                out.print("</td>");
                                out.print("<td>");
                                    out.print(wifi.getX_SWIFI_MGR_NO());
                                out.print("</td>");
                                out.print("<td>");
                                    out.print(wifi.getX_SWIFI_WRDOFC());
                                out.print("</td>");
                                out.print("<td>");
                                    out.print("<a href = 'wifiDetail?X_SWIFI_MAIN_NM=" + wifi.getX_SWIFI_MAIN_NM());
                                    out.print("&LAT=" + request.getAttribute("LAT") + "&LNT=" + request.getAttribute("LNT") + "'>");
                                        out.print(wifi.getX_SWIFI_MAIN_NM());
                                    out.print("</a>");
                            out.print("</td>");
                                out.print("<td>");
                                    out.print(wifi.getX_SWIFI_ADRES1());
                                out.print("</td>");
                                out.print("<td>");
                                    out.print(wifi.getX_SWIFI_ADRES2());
                                out.print("</td>");
                                out.print("<td>");
                                    out.print(wifi.getX_SWIFI_INSTL_FLOOR());
                                out.print("</td>");
                                out.print("<td>");
                                    out.print(wifi.getX_SWIFI_INSTL_TY());
                                out.print("</td>");
                                out.print("<td>");
                                    out.print(wifi.getX_SWIFI_INSTL_MBY());
                                out.print("</td>");
                                out.print("<td>");
                                    out.print(wifi.getX_SWIFI_SVC_SE());
                                out.print("</td>");
                                out.print("<td>");
                                    out.print(wifi.getX_SWIFI_CMCWR());
                                out.print("</td>");
                                out.print("<td>");
                                    out.print(wifi.getX_SWIFI_CNSTC_YEAR());
                                out.print("</td>");
                                out.print("<td>");
                                    out.print(wifi.getX_SWIFI_INOUT_DOOR());
                                out.print("</td>");
                                out.print("<td>");
                                    out.print(wifi.getX_SWIFI_REMARS3());
                                out.print("</td>");
                                out.print("<td>");
                                    out.print(wifi.getLAT());
                                out.print("</td>");
                                out.print("<td>");
                                    out.print(wifi.getLNT());
                                out.print("</td>");
                                out.print("<td>");
                                    out.print(wifi.getWORK_DTTM());
                                out.print("</td>");
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

        </script>
    </body>
</html>