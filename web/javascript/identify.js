function isValid(){
    const userId = document.getElementById("userId");
    const userPass = document.getElementById("userPass");
    const agree = document.getElementById("agreement");

    if($("#iii").css("color") == "rgb(255, 0, 0)" || userPass.length < 6 || userPass.length > 16){
        alert("账号已存在或格式不正确！");
        return false;
    }
    if(!agree.checked) {
        alert("请同意本站服务条款！");
        return false;
    }

    return true;
}
