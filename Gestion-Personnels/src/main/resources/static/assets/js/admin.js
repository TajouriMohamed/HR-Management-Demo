$(document).ready(function () {
    $(".table #editButton").on("click", function (event) {
        event.preventDefault();

        /* admin/findById/?id=['id']*/

        var href = $(this).attr("href");

        $.get(href, function (admin) {
            $('#idEdit').val(admin.id);
            $('#nomEdit').val(admin.name);
            $('#loginEdit').val(admin.login);
            $('#emailEdit').val(admin.email);
            $('#passEdit').val(admin.password);
        });
        $('#editModal').modal();
    });

    $(".table #deleteButton").on("click", function (event) {
        event.preventDefault();

        var href = $(this).attr("href");

        $('#confirmDelete').attr('href', href);

        $('#deleteModal').modal();
    });
});