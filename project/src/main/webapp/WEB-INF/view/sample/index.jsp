<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    String path = request.getContextPath(); // "/project";
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>홈페이지 메인</title>
	<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <link rel='stylesheet' href='<%=path %>/css/reset.css'/>
    <link rel='stylesheet' href='<%=request.getContextPath() %>/css/main.css'/> <!--  경로수정  -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="<%=request.getContextPath() %>/js/script.js"></script> <!--  경로수정  --> 
    <%-- 다른 jsp파일과 다르게 필요한 파일이 다르기 때문에 이 파일만 include안함<%@ include file="/WEB-INF/view/include/head.jsp" %> --%>
    <script>

        $(function() {
            var swiper = new Swiper(".mySwiper", {
                loop:true,
                autoplay:{delay:3000},
                navigation: {
                    nextEl: ".swiper-button-next",
                    prevEl: ".swiper-button-prev",
                },
            });

            $(".section > img").mouseover(function(){
                $(this).css('margin','-6px');
                $(this).css('border','6px solid #999');
            }).mouseleave(function(){
                $(this).css('margin','0px');
                $(this).css('border','none');
            });

            // 높이
            var h = ($(window).height()-$(".divPop").height())/2+$(window).scrollTop();
            var w = ($(window).width()-$(".divPop").width())/2+$(window).scrollLeft();
            $(".divPop").css({
                "top":h+"px",
                "left":w+"px"
            });

            $(".divPop").draggable();

        });
    </script>
</head>
<body>
    <div class="divPop">
        <img src="/project/img/event_popup.png">
    </div>
    <div class="wrap">
        <%@ include file="/WEB-INF/view/include/top.jsp" %>
        <div class="visual">
            <div class="swiper-container mySwiper">
                <div class="swiper-wrapper">
                  <div class="swiper-slide" style="background-image: url('/project/img/visual1.png');">&nbsp;</div>
                  <div class="swiper-slide" style="background-image: url('/project/img/visual2.png');">&nbsp;</div>
                  <div class="swiper-slide" style="background-image: url('/project/img/visual3.png');">&nbsp;</div>
                  <div class="swiper-slide" style="background-image: url('/project/img/visual4.png');">&nbsp;</div>
                </div>
                
                <div class="swiper-button-next"></div>
                <div class="swiper-button-prev"></div>
                
              </div>
        </div>
        <div class="container">
            <div class="size">
                <div class="section">
                    <img src="/project/img/section1_1.png">
                </div>
                <div class="section">
                    <img src="/project/img/section1_2.png">
                </div>
                <div class="section">
                    <img src="/project/img/section1_3.png">
                </div>
                <div class="section">
                    <img src="/project/img/section1_4.png">
                </div>
                <div class="section">
                    <img src="/project/img/section1_5.png">
                </div>
                <div class="section">
                    <img src="/project/img/section1_6.png">
                </div>
            </div>
        </div>
        <div class="info">
            <div class="content">
                <div class="board_area">
                    <div class="board_title on">공지사항</div>
                    <div class="board_title">자료실</div>
                    <div class="board_content" id="board_notice">
                        <ul>
                            <li>공지사항입니다.<span>2021-07-02</span></li>
                            <li>공지사항입니다.<span>2021-07-02</span></li>
                            <li>공지사항입니다.<span>2021-07-02</span></li>
                            <li>공지사항입니다.<span>2021-07-02</span></li>
                            <li>공지사항입니다.<span>2021-07-02</span></li>
                            <li>공지사항입니다.<span>2021-07-02</span></li>
                            <li>공지사항입니다.<span>2021-07-02</span></li>
                            <li>공지사항입니다.<span>2021-07-02</span></li>
                            <li>공지사항입니다.<span>2021-07-02</span></li>
                        </ul>
                    </div>
                    <div class="board_content" id="board_data">
                        <ul>
                            <li>자료실입니다.</li>
                            <li>자료실입니다.</li>
                            <li>자료실입니다.</li>
                            <li>자료실입니다.</li>
                            <li>자료실입니다.</li>
                            <li>자료실입니다.</li>
                            <li>자료실입니다.</li>
                            <li>자료실입니다.</li>
                            <li>자료실입니다.</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="content">
                <div class="video_area">
                    <iframe width="100%" height="350" src="https://www.youtube.com/embed/FNMOf8tlOVM" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                </div>
            </div>
        </div>
        <%@ include file="/WEB-INF/view/include/bottom.jsp" %>
    </div>
</body>
</html>