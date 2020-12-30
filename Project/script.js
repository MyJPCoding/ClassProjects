$(document).ready(function(){

    // Starting Number is pikachu
    var targetID=25;
    $('#SnomWorld').hide();
    $('#SnomWorld2').hide();
    $('#SnomWorld3').hide();
    $('sprite').hide();

    function pokeSort(){

        $("#moves1 li").sort(asc_sort).appendTo('#moves1');
            //$("#debug").text("Output:");
            // accending sort
            function asc_sort(a, b){
            return ($(b).text()) < ($(a).text()) ? 1 : -1; 
            }

        $("#moves2 li").sort(asc_sort).appendTo('#moves2');
            //$("#debug").text("Output:");
            // accending sort
            function asc_sort(a, b){
            return ($(b).text()) < ($(a).text()) ? 1 : -1;  
            }
             
        $("#moves3 li").sort(asc_sort).appendTo('#moves3');
            //$("#debug").text("Output:");
            // accending sort
            function asc_sort(a, b){
            return ($(b).text()) < ($(a).text()) ? 1 : -1;
            }    
    }


    $.get("https://pokeapi.co/api/v2/pokemon/"+ targetID +"/", function(res) {
        // NAME
        var html_str = "";
        html_str += "<h1>"+res.name+"</h1>";
        $("#name").html(html_str);

        // SPRITE

        var boximage = document.createElement('img'); 
        boximage.setAttribute( "src", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+targetID+".png"); 
        console.log (boximage);
        boximage.id = `${targetID}`;
        console.log(boximage.id);
        document.getElementById("sprite").appendChild(boximage);

        var boxshinyimage = document.createElement('img'); 
        boxshinyimage.setAttribute( "src", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/"+targetID+".png"); 
        console.log (boxshinyimage);
        boxshinyimage.id = `shiny${targetID}`;
        console.log(boxshinyimage.id);
        document.getElementById("shinysprite").appendChild(boxshinyimage);

        // TYPES
        var html_str = "";
        html_str += "<h2>type</h2>";
        html_str += "<ul>"; 
        for(var i = 0; i < res.types.length; i++) {
            html_str += "<li>" + res.types[i].type.name + "</li>";
        }
        html_str += "</ul>";
        $("#types").html(html_str);

        // Ability
        var html_str = "";
        html_str += "<h2>Ability</h2>";
        html_str += "<ul>"; 
        for(var i = 0; i < res.abilities.length; i++) {
            html_str += "<li>" + res.abilities[i].ability.name + "</li>";
        }
        html_str += "</ul>";
        $("#ability").html(html_str);

        // moves

        var html_str = "";
        
        html_str += "<ul>"; 
        var movecounter=1;
        for(var i = 0; i < 19; i++) {
            html_str += "<li>" + res.moves[i].move.name + "</li>";
        }
        html_str += "</ul>";
        $("#moves1").html(html_str);

        var html_str = "";
       
        html_str += "<ul>"; 
        for(var i; i < 38; i++) {
            html_str += "<li>" + res.moves[i].move.name + "</li>";
        }
        html_str += "</ul>";
        $("#moves2").html(html_str);

        var html_str = "";
        html_str += "<ul>"; 
        for(var i; i < 57; i++) {
            html_str += "<li>" + res.moves[i].move.name + "</li>";
        }
        html_str += "</ul>";
        $("#moves3").html(html_str);

        pokeSort();    

        for(i=1; i<152; i++)
        {
            var boximage = document.createElement('img'); 
            boximage.setAttribute( "src", "http://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+i+".png"); 
            console.log (boximage);
            boximage.id = `${i}`;
            console.log(boximage.id);
            document.getElementById("options").appendChild(boximage);

        }


        var scizor = 212;
        var boximage = document.createElement('img'); 
        boximage.setAttribute( "src", "http://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+scizor+".png"); 
        console.log (boximage);
        boximage.id = `${scizor}`;
        console.log(boximage.id);
        document.getElementById("options").appendChild(boximage);

        var lugia = 249;
        var boximage = document.createElement('img'); 
        boximage.setAttribute( "src", "http://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+lugia+".png"); 
        console.log (boximage);
        boximage.id = `${lugia}`;
        console.log(boximage.id);
        document.getElementById("options").appendChild(boximage);

        var mudkip = 258;
        var boximage = document.createElement('img'); 
        boximage.setAttribute( "src", "http://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+mudkip+".png"); 
        console.log (boximage);
        boximage.id = `${mudkip}`;
        console.log(boximage.id);
        document.getElementById("options").appendChild(boximage);

        
        $('#pokemonbox').show();
        $('sprite').show();


    }, "json");
  
  $(this).click(function(){

        console.log("we got to the click");

        


        var targetID = event.target.id;
        console.log(targetID);

        if (targetID > 0) {
       

            $.get("https://pokeapi.co/api/v2/pokemon/"+ targetID +"/", function(res) {

                $('#pokemonbox').hide();

                $('#sprite img').remove();
        
                $('#shinysprite img').remove();

            // NAME
            var html_str = "";
            html_str += "<h1>"+res.name+"</h1>";
            $("#name").html(html_str);

            // SPRITE

            var boximage = document.createElement('img'); 
            boximage.setAttribute( "src", "http://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+targetID+".png"); 
            console.log (boximage);
            boximage.id = `${targetID}`;
            console.log(boximage.id);
            document.getElementById("sprite").appendChild(boximage);

            var boxshinyimage = document.createElement('img'); 
            boxshinyimage.setAttribute( "src", "http://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/"+targetID+".png"); 
            console.log (boxshinyimage);
            boxshinyimage.id = `${targetID}`;
            console.log(boxshinyimage.id);
            document.getElementById("shinysprite").appendChild(boxshinyimage);

            // TYPES
            var html_str = "";
            html_str += "<h2>Type</h2>";
            html_str += "<ul>"; 
            for(var i = 0; i < res.types.length; i++) {
                html_str += "<li>" + res.types[i].type.name + "</li>";
            }
            html_str += "</ul>";
            $("#types").html(html_str);

            // Ability
            var html_str = "";
            html_str += "<h2>Ability</h2>";
            html_str += "<ul>"; 
            for(var i = 0; i < res.abilities.length; i++) {
                html_str += "<li>" + res.abilities[i].ability.name + "</li>";
            }
            html_str += "</ul>";
            $("#ability").html(html_str);

            // moves

            var html_str = "";
            html_str += "<ul>"; 
            var movecounter=1;
            for(var i = 0; i < 18; i++) {
                html_str += "<li>" + res.moves[i].move.name + "</li>";
            }
            html_str += "</ul>";
            $("#moves1").html(html_str);

            var html_str = "";
            html_str += "<ul>"; 
            for(var i = 18; i < 36; i++) {
                html_str += "<li>" + res.moves[i].move.name + "</li>";
            }
            html_str += "</ul>";
            $("#moves2").html(html_str);

            var html_str = "";
            html_str += "<ul>"; 
            for(var i = 36; i < 54; i++) {
                html_str += "<li>" + res.moves[i].move.name + "</li>";
            }
            html_str += "</ul>";
            $("#moves3").html(html_str);

            pokeSort();

            if(targetID==258) {


                var boximage = document.createElement('img'); 
                boximage.setAttribute( "src", "http://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+0+".png"); 
                console.log (boximage);
                boximage.id = `${999}`;
                console.log(boximage.id);
                document.getElementById("options").appendChild(boximage);

            } 


            $('#pokemonbox').show();


            }, "json");

        }

        if (targetID == 999) {

            alert("Hello, user. Would you like to see the perfect pokmeon?")

            alert("Converting God into a perfect, pokemon form. Please wait.")
            alert(" . . . ")
            alert(" . . . ")
            alert(" . . . ")

            alert("He is ready to see you now. Please come in.");

            console.log("wegotthisclick")
            $('#pokemonbox').remove();
            console.log("remove1")
            $('#options').remove();
            console.log("remove2")
            $('h2').remove();
            $('#SnomWorld').show();

            // NavBar
            var html_str = "";
            for (i=0; i<7; i++){

                if (i==3){
                    html_str += "<h1>THE CUTEST THING EVER!</h1>";
                } else {                
                html_str += "<h2>SNOM</h2>";
                }
            }
            $("#NavBar").html(html_str);



        } 

        

    })

    $('#SnomWorld button').click(function(){

        $('#SnomWorld').hide();
        $('#SnomWorld2').show();        

    })

    $('#SnomWorld2 img').click(function(){

        alert("Where are you going? You cannot leave yet.");
    })

    $('#SnomWorld2 h1').click(function(){

        alert("Priase the Perfect Snom.");
    })

    $('#SnomWorld2 button').click(function(){

        $('#SnomWorld2').hide();
        $('#SnomWorld3').show();

    })

    $('#SnomWorld3 img').click(function(){

        alert("You cannot leave yet. Snom requires your presence, and faith!");
    })

    $('#SnomWorld3 button').click(function(){

        alert("You escaped this time, but remember... you cannot run from him forever.")

        window.opener = self;
        window.close();

    })
})