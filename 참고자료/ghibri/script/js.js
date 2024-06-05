$(function(){
         // silde---------------------------------------------------------  
         var swiper = new Swiper(".mySwiper2", {
            loop: true,
            loopFillGroupWithBlank: true,
            speed : 1000,
            navigation: {
              nextEl: ".prev_btn",
              prevEl: ".next_btn",
            },
            autoplay: {
              delay: 3000,
              disableOntnteraction:false,
            },
        });

     var swiper = new Swiper(".mySwiper", {
            loop: true,
            loopFillGroupWithBlank: true,
            spaceBetween: 30,
            slidesPerView: 4,
            mousewheel: true,
            autoplay: {
                delay: 3000,
                disableOntnteraction:false,
            },
            pagination: {
              el: ".swiper-pagination",
              clickable: true,
            },
        });

        var swiper = new Swiper(".mySwiper1", {
            loop: true,
            slidesPerView: 6,
            spaceBetween: 30,
            pagination: {
                el: ".swiper-pagination",
                clickable: true,
            },
            navigation: {
                nextEl: ".swiper-button-next",
                prevEl: ".swiper-button-prev",
            },
        });


        $('.tab_menu a').click(function(e){
            e.preventDefault()
            var href=$(this).attr('href')
            $('#sect3 article').removeClass('on')
            $(href).addClass('on')
            pointerInit($(this))
        })

        pointerInit($('.tab_inner a').first())

        function pointerInit(self){
            var aOn=self

            var aPos=aOn.offset().left
            var ahWid=aOn.width()/2
            $('span.pointer').stop().animate({'left':aPos+ahWid-5})
        }

        $(window).resize(function(){
            pointerInit($('.tab_inner a').first())
        })
    // sect6 ul li---------------------------------------------------------
        $('#sect6 ul li').removeClass('dimBg')
            $('#sect6 ul li').mouseenter(function(){
                $('#sect6 ul li').removeClass('dimBg')
                $(this).addClass('dimBg')
        })
})