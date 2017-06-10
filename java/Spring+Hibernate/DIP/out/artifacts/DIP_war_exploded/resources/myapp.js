/**
 * Created by artem on 06.05.2017.
 */
$("#btn-update").click(function() {
    $("#myform").attr("action", "update");
    $("#myform").submit();
});