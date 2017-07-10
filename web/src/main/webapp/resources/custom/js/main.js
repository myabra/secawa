jQuery(document).ready(function($) {
    $("#employees tr").each(function(i) {
        if (i > 10) {
            $(this).hide()
        }
    });
    $("#departments tr").each(function(i) {
        if (i > 10) {
            $(this).hide()
        }
    });

    /*$("ul.pagination a").click(function () {
        var page = $(this).data("page");
        var table = $($(this).closest("nav")).prev("table");
        pagination(page, table);
    })*/
});

pagination = function (page, table) {
    var rows = $(table).find('tr');
    rows.hide();
    rows.slice((page - 1)*10, page*10 ).show();
}
