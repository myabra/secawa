var lines_per_page = 10;
jQuery(document).ready(function($) {
    pagination(1, $("#employees"));
    pagination(1, $("#departments"));

    $("ul.pagination a").click(function () {
        var nav = $($(this).closest("nav"));
        var page = nav.data("current-page");
        var table = nav.prev("table");
        if ($(this).data("direction") == "next")
            page++;
        else
            page--;
        if (page == NaN || page < 1)
            page = 1;

        pagination(page, table);
    })
});

pagination = function (page, table) {
    var rows = $(table).find('tbody tr');
    var showFrom = (page - 1) * lines_per_page;
    var showTill = page*lines_per_page;
    if (showFrom > rows.length - 1) {
        return;
    }
    $(table).next("nav").data("current-page", page);
    rows.hide();
    rows.slice(showFrom, showTill).show();
}
