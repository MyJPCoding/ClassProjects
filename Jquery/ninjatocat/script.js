$(document).ready(function(){
    $('img').click(function(){

        // var temp = $(this);
        // $(this) = $(this).attr('data-alt-src');
        // console.log('data-alt-src value is', $(this).attr('data-alt-src'));

        var src2 = $(this).attr('alt');
        var alt2 = $(this).attr('src');

            $(this).attr({
            src: src2,
            alt: alt2
        })

    })



})