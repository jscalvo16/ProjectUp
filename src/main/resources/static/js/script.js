
let arrow = document.querySelectorAll(".arrow");
for (var i = 0; i < arrow.length; i++) {
    arrow[i].addEventListener("click", (e)=>{
        let arrowParent = e.target.parentElement.parentElement;//selecting main parent of arrow
        arrowParent.classList.toggle("showMenu");
    });
}

let ubicacionPrincipal = window.pageYOffset;





let sidebar = document.querySelector(".sidebar");
let sidebarBtn = document.querySelector(".bx-menu");
console.log(sidebarBtn);
sidebarBtn.addEventListener("click", ()=>{
    sidebar.classList.toggle("close");
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
