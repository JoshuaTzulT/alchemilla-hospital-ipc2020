

<div id="nav" class="vmenu">
    <a class="menu_link_active" href="#">Pagina Principal</a>
    <a class="menu_link" href="#">LINK 1</a>
    <a class="menu_link" href="#">LINK 2</a>
    <a class="menu_link" href="#">LINK 3</a>
</div>

<script>
    //Esto añade una clase actival al boton, es decir lo resalta.
    var encabezado=document.getElmentById("nav");
    var links = encabezado.getElementsByClassName("menu_link");
    
    for(var i =0; i<links.length; i++){
        links[i].addEventListener("click", function(){
            var actual= document.getElementsByClassName("activo");
            actual[0].className = actual[0].className.replace("activo", "");
            this.className+="activo";
        });
    }
</script>