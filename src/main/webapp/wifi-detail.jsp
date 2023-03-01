<%@ page import="com.example.project_wifi.Wifi" %>
<%@ page import="com.example.project_wifi.BookmarkGroup" %>
<%@ page import="java.util.List" %>
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
            select option[value=""][disabled] {
                display: none;
            }
        </style>
        <title>와이파이 정보 구하기</title>
    </head>
    <body>
        <h1> 와이파이 정보 구하기 </h1>
        <a href = "${pageContext.request.contextPath}/"> 홈 </a> | <a href = "${pageContext.request.contextPath}/history"> 위치 히스토리 목록 </a> |
        <a href = "load-wifi"> Open API 와아파이 정보 가져오기 </a> |
        <a href = "bookmark-list"> 즐겨 찾기 보기 </a> | <a href = "bookmark-group"> 즐겨 그룹 관리 </a><br>

        <form method="post" action="/bookmark-add">
            <select name="bookmark_group" required>
                <option value = "" disabled selected>북마크 그룹 이름 선택</option>
                <%
                    List<BookmarkGroup> groupList = (List<BookmarkGroup>) request.getAttribute("groupList");
                    if(groupList != null) {
                        for (BookmarkGroup group: groupList) {
                            out.print("<option value = " + group.getBookmarkName() + "> " + group.getBookmarkName() + "</option>");
                        }
                    }
                %>
            </select>
            <%
                Wifi wifi = (Wifi) request.getAttribute("wifi");
                out.print("<input type='hidden' name='wifiName' value='" + wifi.getX_SWIFI_MAIN_NM() + "'>");
            %>
            <button type="submit">즐겨찾기 추가하기</button>
        </form>
        <%

            if(wifi != null)  {
                out.print("<table>");
                    out.print("<tr>");
                        out.print("<th>");
                            out.print("거리(Km)");
                        out.print("</th>");
                        out.print("<td>");
                            out.print(wifi.getDistance());
                        out.print("</td>");
                    out.print("</tr>");
                        out.print("<th>");
                            out.print("관리번호");
                        out.print("</th>");
                        out.print("<td>");
                            out.print(wifi.getX_SWIFI_MGR_NO());
                        out.print("</td>");
                    out.print("</tr>");
                        out.print("<th>");
                            out.print("자치구");
                        out.print("</th>");
                        out.print("<td>");
                            out.print(wifi.getX_SWIFI_WRDOFC());
                        out.print("</td>");
                    out.print("</tr>");
                        out.print("<th>");
                            out.print("와이파이명");
                        out.print("</th>");
                        out.print("<td>");
                            out.print(wifi.getX_SWIFI_MAIN_NM());
                        out.print("</td>");
                    out.print("</tr>");
                        out.print("<th>");
                            out.print("도로명주소");
                        out.print("</th>");
                        out.print("<td>");
                            out.print(wifi.getX_SWIFI_ADRES1());
                        out.print("</td>");
                    out.print("</tr>");
                        out.print("<th>");
                            out.print("상세주소");
                        out.print("</th>");
                        out.print("<td>");
                            out.print(wifi.getX_SWIFI_ADRES2());
                        out.print("</td>");
                    out.print("</tr>");
                        out.print("<th>");
                            out.print("설치위치(층)");
                        out.print("</th>");
                        out.print("<td>");
                            out.print(wifi.getX_SWIFI_INSTL_FLOOR());
                        out.print("</td>");
                    out.print("</tr>");
                        out.print("<th>");
                            out.print("설치유형");
                        out.print("</th>");
                        out.print("<td>");
                            out.print(wifi.getX_SWIFI_INSTL_TY());
                        out.print("</td>");
                    out.print("</tr>");
                        out.print("<th>");
                            out.print("설치기관");
                        out.print("</th>");
                        out.print("<td>");
                            out.print(wifi.getX_SWIFI_INSTL_MBY());
                        out.print("</td>");
                    out.print("</tr>");
                        out.print("<th>");
                            out.print("서비스구분");
                        out.print("</th>");
                        out.print("<td>");
                            out.print(wifi.getX_SWIFI_SVC_SE());
                        out.print("</td>");
                    out.print("</tr>");
                        out.print("<th>");
                            out.print("망종류");
                        out.print("</th>");
                        out.print("<td>");
                            out.print(wifi.getX_SWIFI_CMCWR());
                        out.print("</td>");
                    out.print("</tr>");
                        out.print("<th>");
                            out.print("설치년도");
                        out.print("</th>");
                        out.print("<td>");
                            out.print(wifi.getX_SWIFI_CNSTC_YEAR());
                        out.print("</td>");
                    out.print("</tr>");
                        out.print("<th>");
                            out.print("실내외구분");
                        out.print("</th>");
                        out.print("<td>");
                            out.print(wifi.getX_SWIFI_INOUT_DOOR());
                        out.print("</td>");
                    out.print("</tr>");
                        out.print("<th>");
                            out.print("WIFI접속환경");
                        out.print("</th>");
                        out.print("<td>");
                            out.print(wifi.getX_SWIFI_REMARS3());
                        out.print("</td>");
                    out.print("</tr>");
                        out.print("<th>");
                            out.print("X좌표");
                        out.print("</th>");
                        out.print("<td>");
                            out.print(wifi.getLAT());
                        out.print("</td>");
                    out.print("</tr>");
                        out.print("<th>");
                            out.print("Y좌표");
                        out.print("</th>");
                        out.print("<td>");
                            out.print(wifi.getLNT());
                        out.print("</td>");
                    out.print("</tr>");
                        out.print("<th>");
                            out.print("작업일자");
                        out.print("</th>");
                        out.print("<td>");
                            out.print(wifi.getWORK_DTTM());
                        out.print("</td>");
                    out.print("</tr>");
                out.print("</table>");
            }
        %>
    </body>
</html>