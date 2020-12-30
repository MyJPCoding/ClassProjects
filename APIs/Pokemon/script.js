$(document).ready(function(){

    var temp=1;


    $('button').click(function(){
        console.log("we got to the function");

        $('img').hide();

        for(i=temp; i<temp+20; i++ ){

            console.log("we got ot the for loop");

            var newNum = i;
            var image = document.createElement('img'); 
            image.setAttribute( "src", "http://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+newNum+".png"); 
            // var src = document.getElementById(".wrapper");
            document.body.appendChild(image);

        }

        temp+=20;

    })


})