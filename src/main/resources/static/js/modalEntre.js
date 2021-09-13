// Funciones para la ventana modal de entregables
// Obtener boton para cerrar el modal de entregables
let cerrar = document.querySelectorAll(".btn-cerrar-popup-entre")[0];

// Obtnener boton para abrir el modal de entregables
let abrir = document.querySelectorAll(".btn-abrir-popup-entre")[0];

// Obtener el modal
let modal = document.querySelectorAll(".modalEntre")[0];

// Obtener el contenido del modal de entregables
let content = document.querySelectorAll(".contenidoModalEntre")[0];

// Función para ejecutar la animación del modal cuando se abra
abrir.addEventListener("click", function(e) {
    content.style.opacity = "1";
    modal.style.opacity = "1";
    modal.style.visibility = "visible";
    content.classList.toggle("modal-close-entre");
});

// Función para ejecutar la animación del modal cuando se cierre presionando la X
cerrar.addEventListener("click", function() {
    content.classList.toggle("modal-close-entre");
    setTimeout(function(){
        modal.style.opacity = "0";
        modal.style.visibility = "hidden";
    }, 600);
});

// Función para ejecutar la animación del modal cuando se cierre presionando fuera del modal
window.addEventListener("click", function(e) {
    if(e.target == modal){
        content.classList.toggle("modal-close-entre");
        setTimeout(function(){
            modal.style.opacity = "0";
            modal.style.visibility = "hidden";
        }, 600);
    }
});