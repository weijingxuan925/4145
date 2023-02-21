$(function() {
    $('[data-toggle="tooltip"]').tooltip();
});

function saveUser(option) {
    const param = $('#' + option).serialize();
    $.ajax({
        type: 'post',
        url: '/admin/user/profile/update',
        data: param,
        success: function(data) {
            if (data.code === 1) {
                showMsg(data.msg, 'success', 1000);
            } else {
                showMsg(data.msg, 'error', 1000);
            }
        }
    });
}

function changPass() {
    const beforePass = $('#beforePass').val();
    const newPass = $('#newPass').val();
    const reNewPass = $('#reNewPass').val();
    if (beforePass === '' || newPass === '' || reNewPass === '') {
        showMsg('Please enter complete information', 'info', 2000);
        return;
    }
    if (newPass !== reNewPass) {
        showMsg('The two passwords do not match', 'error', 1000);
        return;
    }
    const param = $('#passForm').serialize();
    $.ajax({
        type: 'post',
        url: '/admin/user/changePass',
        data: param,
        success: function(data) {
            if (data.code === 1) {
                showMsg(data.msg, 'success', 1000);
            } else {
                showMsg(data.msg, 'error', 1000);
            }
        }
    });
}

$('body').on('change', '#file', function() {
    const formData = new FormData();
    const files = $($(this))[0].files[0];
    formData.append('file', files);
    $.ajax({
        url: '/file/upload/img',
        type: 'POST',
        data: formData,
        processData: false,
        contentType: false,
        dataType: 'json',
        success: function(res) {
            console.log(res);
            $('#userAvatar').val(res.result);
            $('#userAvatarImg').attr('src', res.result);
        },
        error: function(res) {}
    });
});
