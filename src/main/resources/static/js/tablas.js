var table = document.getElementsByTagName("table")[0];
var textarea = document.getElementsByTagName("textarea")[0];
var div = document.getElementById("data");
var btn = document.getElementsByTagName("button")[0];
var checkboxes = document.getElementById("columns");
var inputs = [], visible = [], hidden = [];

var datatable = new DataTable(table, {
    perPage: 5,
});

datatable.on("datatable.init", function() {
    setCheckboxes()
});

function updateColumns() {
    try {
        datatable.columns().show(visible);
        datatable.columns().hide(hidden);
    } catch(e) {
        console.log(e);
    }
}

function setCheckboxes() {
    inputs = [];
    visible = [];
    checkboxes.innerHTML = "";

    util.each(datatable.headings, function(i, heading) {
        var checkbox = util.createElement("div", { class: "checkbox" });
        var input = util.createElement("input", { type: "checkbox", id: "checkbox-" + i, name: "checkbox" });
        var label = util.createElement("label", { for: "checkbox-" + i, text: heading.textContent });

        input.idx = i;

        if ( datatable.columns().visible(heading.cellIndex) ) {
            input.checked = true;
            visible.push(i);
        } else {
            if ( hidden.indexOf(i) < 0 ) {
                hidden.push(i);
            }
        }

        checkbox.appendChild(input)
        checkbox.appendChild(label)

        checkboxes.appendChild(checkbox);

        inputs.push(input);
    });

    util.each(inputs, function(i, input) {

        input.onchange = function(e) {
            if ( input.checked ) {
                hidden.splice(hidden.indexOf(input.idx), 1);
                visible.push(input.idx);
            } else {
                visible.splice(visible.indexOf(input.idx), 1);
                hidden.push(input.idx);
            }

            updateColumns();
        };
    });
}

textarea.addEventListener("input", function(e) {
    if ( this.value.length ) {
        this.parentNode.classList.remove("error");
    }
})
