window._ = require('lodash');
try {
    require('slick-carousel');
    window.$ = window.jQuery = require('jquery');
    require('bootstrap');
    require('babel-polyfill');
} catch (e) {}

window.axios = require('axios');

window.axios.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

// let token = document.head.querySelector('meta[name="csrf-token"]');

// if (token) {
    // window.axios.defaults.headers.common['X-CSRF-TOKEN'] = token.content;
// } else {
    // console.error('CSRF token not found');
// }


window.Vue = require('vue');

Vue.component('hello', require('./components/Hello.vue'));

const app = new Vue({
    el: '#app',
});


$(document).ready(function () {
    const isMobile = Boolean(window.outerWidth > 1023);

    if (isMobile) {


        var $tourBookingBarWrap = $("#tour-booking-bar-wrap");
        var $tourBody = $("#tour-body");

        if ($tourBookingBarWrap.length > 0) {
            $tourBody.css("min-height", $tourBookingBarWrap.height() - 350);
        }


    }

    if ($('.navbar-toggler').length > 0) {
        $('.navbar-toggler').click(function () {
            if ($('#navbars').hasClass('show')) {
                $("body").removeClass("stop-scroll");
            } else {
                $("body").addClass("stop-scroll");
            }
        });
    }
    if ($('.offers-slider').length > 0) {
        $('.offers-slider').slick({
            slidesToShow: 3,
            slidesToScroll: 1,
            infinite: true,
            prevArrow: '<button type="button" class="slick-prev"><i class="fa fa-angle-left"></i></button>',
            nextArrow: '<button type="button" class="slick-next"><i class="fa fa-angle-right"></i></button>',
            autoplay: true,
            autoplaySpeed: 4000,
            responsive: [
                {
                    breakpoint: 992,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 2
                    }
                },
                {
                    breakpoint: 768,
                    settings: {
                        slidesToShow: 1,
                        slidesToScroll: 1
                    }
                }
            ]
        });
    }
    if ($('.photo-gallery').length > 0) {
        $('.photo-gallery').slick({
            infinite: true,
            slidesToShow: 1,
            dots: true,
            prevArrow: '<button type="button" class="slick-prev"><i class="fa fa-angle-left"></i></button>',
            nextArrow: '<button type="button" class="slick-next"><i class="fa fa-angle-right"></i></button>',
            autoplay: true,
            autoplaySpeed: 4000,
        });
    }
    $('.nav-link').click(function () {
        if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
            var target = $(this.hash);
            target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
            if (target.length) {
                $('html,body').animate({
                    scrollTop: target.offset().top
                }, 500);
                return false;
            }
        }
    });
    $(window).scroll(function () {
        var subNav = $('header').outerHeight() + $('.single-header').outerHeight() + $('.tour-info-outer').outerHeight();
        var navbarContent = $('#navbar-content');
        var backToTop = $('.footer-back-to-top-button');
        var asideBar = $('#asidebar');

        if ($(this).scrollTop() > subNav) {
            navbarContent.addClass('fixed');
            navbarContent.parent().css("height", navbarContent.height());
        } else {
            navbarContent.removeClass('fixed');
        }


        if ($(this).scrollTop() > 200) {
            backToTop.fadeIn();
        } else {
            backToTop.fadeOut();
        }

    });

    $("a.footer-back-to-top-button").click(function (e) {
        e.preventDefault();
        $("html,body").animate({scrollTop: 0}, "slow");
    });


    $.fn.customerPopup = function (e, intWidth, intHeight, blnResize) {

        // Prevent default anchor event
        e.preventDefault();

        // Set values for window
        var intWidth = intWidth || '500';
        var intHeight = intHeight || '400';
        var strResize = (blnResize ? 'yes' : 'no');

        // Set title and open popup with focus on it
        var strTitle = ((typeof this.attr('title') !== 'undefined') ? this.attr('title') : 'Social Share'),
            strParam = 'width=' + intWidth + ',height=' + intHeight + ',resizable=' + strResize,
            objWindow = window.open(this.attr('href'), strTitle, strParam).focus();
    }

    /* ================================================== */

        $('.share').on("click", function (e) {
            $(this).customerPopup(e);
        });
});

$(document).ready(function() {
    $('#hero-slider').on('init', function(e, slick) {
        var $firstAnimatingElements = $('div.hero-slide:first-child').find('[data-animation]');
        doAnimations($firstAnimatingElements);
    });
    $('#hero-slider').on('beforeChange', function(e, slick, currentSlide, nextSlide) {
        var $animatingElements = $('div.hero-slide[data-slick-index="' + nextSlide + '"]').find('[data-animation]');
        doAnimations($animatingElements);
    });
    $('#hero-slider').slick({
        autoplay: true,
        autoplaySpeed: 8000,
        dots: false,
        fade: true,
        infinite: true,
        prevArrow: '<button type="button" class="slick-prev"><i class="fa fa-angle-left"></i></button>',
        nextArrow: '<button type="button" class="slick-next"><i class="fa fa-angle-right"></i></button>',
    });
    function doAnimations(elements) {
        var animationEndEvents = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
        elements.each(function() {
            var $this = $(this);
            var $animationDelay = $this.data('delay');
            var $animationType = 'animated ' + $this.data('animation');
            $this.css({
                'animation-delay': $animationDelay,
                '-webkit-animation-delay': $animationDelay
            });
            $this.addClass($animationType).one(animationEndEvents, function() {
                $this.removeClass($animationType);
            });
        });
    }
});