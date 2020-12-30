$(document).ready(function(){
    $.get("https://pokeapi.co/api/v2/pokemon/1/", function(res) {
        var html_str = "";
        html_str += "<h4>Types</h4>";
        html_str += "<ul>"; 
        for(var i = 0; i < res.types.length; i++) {
            html_str += "<li>" + res.types[i].type.name + "</li>";
        }
        html_str += "</ul>";
        $("#bulbasaur").html(html_str);
    }, "json");
})