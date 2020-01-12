$(document).ready(function () {
    $("#teamhref").hover(function() {
        $("#teamhref").addClass("hoverhref");
    });
    $("#teamhref").mouseleave(function() {
        $("#teamhref").removeClass("hoverhref");
    });

    $('#menuSel').change(function() {
        var selectedVal = $(this).val();
            window.location.href = selectedVal;        
    });

});