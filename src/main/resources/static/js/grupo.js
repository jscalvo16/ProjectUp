//scroll efectos de data-aos

AOS.init();

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

