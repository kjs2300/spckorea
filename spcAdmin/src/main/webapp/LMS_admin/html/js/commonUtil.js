/**
 * 공통
 */

$(document).ready(function(){
	
	var lnbH;
	var containerW;
	var containerH;
	var contentsH;
	var footerW;

	lnbHeight()
	containerSize()
	//contentsHeight()
	footerWidth()

	/*  메뉴 height  */
	function lnbHeight(){
		//lnbH = window.innerHeight - $('#header').height() + 30;
		lnbH = $('#container').height() - 60
		
		if($('#container').height()< window.innerHeight){
			lnbH = window.innerHeight - $('#header').height() + 30;
		}

		$('#nav').height(lnbH);
	}

	/*  container size  */
	function containerSize(){
		containerW = window.innerWidth - $('#nav').width();
		$('#container').width(containerW);

		containerH = $('#nav').height(lnbHeight);
		$('#container').width(containerH);
	}

	/*  contents height 
	function contentsHeight(){
		contentsH = window.innerHeight - $('#header').height() - $('.footer').height() - 30;
		$('.contents-wrap').height(contentsH);
	} */

	/*  footer width  */
	function footerWidth(){
		footerW = $('#container').width() - 60;
		$('.footer').width(footerW);
	}
	
	
	
	$(window).resize(function () {
		lnbHeight()
		containerSize()
		//contentsHeight()
		footerWidth()
	});

	

	/*   2depth   */
	$('.depth01-menu li a').click(function(){
		
		if ($(this).parent().hasClass('on')) { 
			$(this).next('.depth02-menu').slideUp(400); 
			$(this).parent().removeClass('on'); 
		} else { 
			$('#nav').find('.on').removeClass('on'); 
			
			$(this).parent().addClass('on');
			$(this).next('.depth02-menu').slideDown(400); 
		}
	});
	
	
	
	/*   datepicker  */
	$( function() {
		$( "#datepickerFrom" ).datepicker({
		  showOn: "button",
		  buttonImage: "./images/common/ico_calendar.png",
		  buttonImageOnly: true,
		  buttonText: "Select date"
		});
		$( "#datepickerTo" ).datepicker({
			showOn: "button",
			buttonImage: "./images/common/ico_calendar.png",
			buttonImageOnly: true,
			buttonText: "Select date"
		  });

		$( "#datepickerDefault" ).datepicker({
			showOn: "button",
			buttonImage: "./images/common/ico_calendar.png",
			buttonImageOnly: true,
			buttonText: "Select date"
		  });

	  });
	
	
	/*   팝업 begin  */
	$('.pop-wrap').css({
		"top": (($(window).height()-$('.pop-wrap').outerHeight())/2+$(window).scrollTop())+'px',
		"left": (($(window).width()-$('.pop-wrap').outerWidth())/2+$(window).scrollLeft())+'px'
	});
	/*  팝업 end */
	
	
	
});
		
		










		
			