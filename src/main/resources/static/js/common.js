$(document).ready(function(){
	$("img.rollimg").mouseenter(function() {
		$(this).attr("src", $(this).attr("src").replace("_off","_on"));
	});
	$("img.rollimg").mouseleave(function() {
		$(this).attr("src", $(this).attr("src").replace("_on", "_off"));
	});

	$("a.cate").click(function() {
		$(this).toggleClass('on');

		if ($(this).hasClass('on')){
			$(this).find('img').attr("src", $(this).find('img').attr("src").replace("_off","_color"));
		} else {
			$(this).find('img').attr("src", $(this).find('img').attr("src").replace("_color", "_off"));
		}
	});


	$(".tab_a a").each(function() {
		if ($(this).hasClass('active')){
			$(this).find('img').attr("src", $(this).find('img').attr("src").replace("_off","_color"));
		} else {
			$(this).find('img').attr("src", $(this).find('img').attr("src").replace("_color", "_off"));
		}
	});

});
