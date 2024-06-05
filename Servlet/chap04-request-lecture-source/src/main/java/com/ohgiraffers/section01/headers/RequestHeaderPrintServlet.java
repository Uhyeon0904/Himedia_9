package com.ohgiraffers.section01.headers;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/headers")
public class RequestHeaderPrintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        * [헤더의 종류]
        * 1. General header: 요청 및 응답 모두에 적용되지만 최종적으로는 body에 전송되는 것과 관련 없는 헤더
        * 2. Request header: Fetch될 리소스나 클라이언트 자체에 대한 상세 정보를 포함하는 헤더
        * 3. Response header: 위치나 서버 자체와 같은 응답에 대한 부가적인 정보를 갖는 헤더
        * 4. Entity header: 컨텐츠 길이나 MIME 타입과 같은 엔티티 body에 대한 상세 정보를 포함하는 헤더
        *   (요청, 응답 모두 사양되며, 메시지 바디의 컨텐츠를 나타내므로 GET 요청은 해당X)    */

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            System.out.println(headerNames.nextElement());
        }

        /*
        Host: 요청이 전송되는 대상 서버의 호스트명과 포트번호를 지정합니다.
        Connection: 클라이언트와 서버 간의 연결 상태를 관리하는 옵션을 설정합니다.
        Sec-Ch-Ua: 요청한 클라이언트의 User-Agent 문자열과 관련된 보안 정책을 정의합니다.
        Sec-Ch-Ua-Mobile: 요청한 클라이언트의 모바일 사용 여부를 나타냅니다.
        Sec-Ch-Ua-Platform: 요청한 클라이언트의 플랫폼을 지정합니다.
        Upgrade-Insecure-Requests: HTTP 요청을 HTTPS로 업그레이드할 것을 지시합니다.
        User-Agent: 클라이언트의 웹 브라우저나 애플리케이션 정보를 포함한 문자열입니다.
        Accept: 클라이언트가 서버로부터 받을 수 있는 콘텐츠 유형을 나타냅니다.
        Sec-Fetch-Site: 요청이 어떤 사이트에서 시작되었는지를 나타냅니다.
        Sec-Fetch-Mode: 리소스를 어떻게 가져올 것인지를 지정합니다(예: cors, navigate 등).
        Sec-Fetch-User: 사용자에 대한 정보를 요청 헤더에 추가할 것인지 여부를 나타냅니다.
        Sec-Fetch-Dest: 가져온 리소스의 목적지를 지정합니다(예: document, image 등).
        Referer: 현재 요청이 발생한 페이지의 URL을 나타냅니다.
        Accept-Encoding: 클라이언트가 지원하는 인코딩 방식을 나타냅니다.
        Accept-Language: 클라이언트가 선호하는 언어를 나타냅니다.
        Cookie: 클라이언트에서 서버로 전송되는 쿠키 정보를 포함합니다.
        */
        System.out.println("host : " + request.getHeader("host"));
        System.out.println("connection : " + request.getHeader("connection"));
        System.out.println("sec-ch-ua : " + request.getHeader("sec-ch-ua"));
        System.out.println("sec-ch-ua-mobile : " + request.getHeader("sec-ch-ua-mobile"));
        System.out.println("sec-ch-ua-platform : " + request.getHeader("sec-ch-ua-platform"));
        System.out.println("upgrade-insecure-requests : " + request.getHeader("upgrade-insecure-requests"));
        System.out.println("user-agent : " + request.getHeader("user-agent"));
        System.out.println("accept : " + request.getHeader("accept"));
        System.out.println("sec-fetch-site : " + request.getHeader("sec-fetch-site"));
        System.out.println("sec-fetch-mode : " + request.getHeader("sec-fetch-mode"));
        System.out.println("sec-fetch-user : " + request.getHeader("sec-fetch-user"));
        System.out.println("sec-fetch-dest : " + request.getHeader("sec-fetch-dest"));
        System.out.println("referer : " + request.getHeader("referer"));
        System.out.println("accept-encoding : " + request.getHeader("accept-encoding"));
        System.out.println("accept-language : " + request.getHeader("accept-language"));
        System.out.println("cookie : " + request.getHeader("cookie"));
    }
}