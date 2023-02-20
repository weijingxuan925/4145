/**
 * Create by JingxuanWei
 * @param text is the message
 * @param icon is the icon
 * @param hideAfter is the time to hide
 */
function showMsg(text, icon, hideAfter) {
    const heading = "Tips";
    $.toast({
        text: text,
        heading: heading,
        icon: icon,
        showHideTransition: 'fade',
        allowToastClose: true,
        hideAfter: hideAfter,
        loader: true,
        loaderBg: '#ffffff'
    });
}


function showMsgAndReload(text, icon, hideAfter) {
    const heading = "Tips";
    $.toast({
        text: text,
        heading: heading,
        icon: icon,
        showHideTransition: 'fade',
        allowToastClose: true,
        hideAfter: hideAfter,
        loader: true,
        loaderBg: '#ffffff',
        afterHidden: function () {
            window.location.reload();
        }
    });
}

function showMsgAndRedirect(text, icon, hideAfter, redirectUrl) {
    const heading = "Tips";
    $.toast({
        text: text,
        heading: heading,
        icon: icon,
        showHideTransition: 'fade',
        allowToastClose: true,
        hideAfter: hideAfter,
        loader: true,
        loaderBg: '#ffffff',
        afterHidden: function () {
            window.location.href = redirectUrl;
        }
    });
}



/**
 * 全选和反选在admin界面里面
 */
function doCheck() {
    const ch = document.getElementsByName("ids");
    const allSelect = document.getElementById("allSelect").checked;
    for (let i = 0; i < ch.length; i++) {
        ch[i].checked = allSelect;
    }
}


