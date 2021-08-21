

// Funciones para la ventana modal
// Obtener boton para cerrar el modal
let cerrar = document.querySelectorAll(".btn-cerrar-popup")[0];

// Obtnener boton para abrir el modal
let abrir = document.querySelectorAll(".btn-abrir-popup")[0];

// Obtener el modal
let modal = document.querySelectorAll(".overlay")[0];

// Obtener el contenido del modal
let content = document.querySelectorAll(".popup")[0];

// Función para ejecutar la animación del modal cuando se abra
abrir.addEventListener("click", function(e) {
    content.style.opacity = "1";
    modal.style.opacity = "1";
    modal.style.visibility = "visible";
    content.classList.toggle("modal-close");
});

// Función para ejecutar la animación del modal cuando se cierre presionando la X
cerrar.addEventListener("click", function() {
    content.classList.toggle("modal-close");
    setTimeout(function(){
        modal.style.opacity = "0";
        modal.style.visibility = "hidden";
    }, 600);
});

// Función para ejecutar la animación del modal cuando se cierre presionando fuera del modal
window.addEventListener("click", function(e) {
    if(e.target == modal){
        content.classList.toggle("modal-close");
        setTimeout(function(){
            modal.style.opacity = "0";
            modal.style.visibility = "hidden";
        }, 600);
    }
});