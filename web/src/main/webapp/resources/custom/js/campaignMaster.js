jQuery(document).ready(function($) {
    $("#create-campaign").submit(function(event) {
        event.preventDefault();

        var data = {}
        data["name"] = $("#new-campaign-name").val();
        data["fileName"] = $("#new-campaign-file").val();

        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : "/campaignMaster/save",
            data : JSON.stringify(data),
            dataType : 'json',
            timeout : 100000,
            success : function(data) {
                if (data.result == 'ERROR') {
                    alert(data.errMsg);
                }
                console.log("SUCCESS: ", data);
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
    });
});