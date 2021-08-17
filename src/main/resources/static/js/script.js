let sidebar = document.querySelector(".sidebar");
let closeBtn = document.querySelector("#btn");
let searchBtn = document.querySelector(".bx-search");

closeBtn.addEventListener("click", ()=>{
  sidebar.classList.toggle("open");
  menuBtnChange();//llama a la función
});

searchBtn.addEventListener("click", ()=>{ // La barra lateral se abre al oprimir el icono
  sidebar.classList.toggle("open");
  menuBtnChange(); //llama a la función
});

// funciones predeterminadas al darle click al icono del menu
function menuBtnChange() {
 if(sidebar.classList.contains("open")){
   closeBtn.classList.replace("bx-menu", "bx-menu-alt-right");
 }else {
   closeBtn.classList.replace("bx-menu-alt-right","bx-menu");
 }
}

let ubicacionPrincipal = window.pageYOffset;


//scroll efectos de data-aos

AOS.init();


//funcion para ocultar la parte superior del menu

window.addEventListener("scroll", function() {
    let desplazamientoActual = window.pageYOffset;
    if (ubicacionPrincipal >= desplazamientoActual) {
        document.getElementsByTagName("nav")[0].style.top = "0px"
    } else {
        document.getElementsByTagName("nav")[0].style.top = "-100px"
    }
    ubicacionPrincipal = desplazamientoActual;
});

$('.button').click(function(){
    var $btn = $(this),
        $step = $btn.parents('.modal-body'),
        stepIndex = $step.index(),
        $pag = $('.modal-header span').eq(stepIndex);

    if(stepIndex === 0 || stepIndex === 1) { step1($step, $pag); }
    else { step3($step, $pag); }

});


function step1($step, $pag){
    console.log('step1');
    // animate the step out
    $step.addClass('animate-out');

    // animate the step in
    setTimeout(function(){
        $step.removeClass('animate-out is-showing')
            .next().addClass('animate-in');
        $pag.removeClass('is-active')
            .next().addClass('is-active');
    }, 600);

    // after the animation, adjust the classes
    setTimeout(function(){
        $step.next().removeClass('animate-in')
            .addClass('is-showing');

    }, 1200);
}

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