

function updateVote(){
    //创建xhr对象
    const xhr = new XMLHttpRequest();
    if(xhr == null){
        alert("浏览器版本过低！！！");
        return ;
    }

    //账号
    const id = document.getElementById("putId").innerText;
    const title = document.getElementById("title").value;
    //密码
    const content = document.getElementById("content").value;
    const url = "/ov/UpdateVoteAjaxServlet";

    //post方式提交
    xhr.open("post", url, true);
    xhr.onreadystatechange = function () {
        if(xhr.readyState == 4 && xhr.status == 200) {
            if(xhr.responseText.indexOf("true") >= 0) {
                alert("修改成功");
            } else {
                alert("修改失败, 发布内容不能超过120个字，标题不能大于16个字.");
            }
        }
    };
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send("title=" + title + "&content=" + content + "&id=" + id);

}


function addVote(){
    //创建xhr对象
    const xhr = new XMLHttpRequest();
    if(xhr == null){
        alert("浏览器版本过低！！！");
        return ;
    }

    //账号
    const id = document.getElementById("id").innerText;
    const title = document.getElementById("title").value;
    //密码
    const content = document.getElementById("content").value;
    const url = "/ov/AddVoteAjaxServlet";

    //post方式提交
    xhr.open("post", url, true);
    xhr.onreadystatechange = function () {
        if(xhr.readyState == 4 && xhr.status == 200) {
            if(xhr.responseText == "true") {
                alert("发布成功");
            } else {
                alert("发布失败, 发布内容不能超过120个字，标题不能大于16个字.");
            }
        }
    };
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send("title=" + title + "&content=" + content + "&id=" + id);

}

function checkID2() {
    //创建xhr对象
    const xhr = new XMLHttpRequest();
    if(xhr == null){
        alert("浏览器版本过低！！！");
        return ;
    }
    //账号
    const name = document.getElementById("userId").value;
    //密码
    const password = document.getElementById("userPass").value;
    const url = "/ov/AcountAjaxServlet";

    //post方式提交
    xhr.open("post", url, true);
    xhr.onreadystatechange = function () {
        if(xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById("iii").innerHTML = xhr.responseText;
            if(xhr.responseText.indexOf("验") >= 0){
                document.getElementById("iii").style.color = "green";
            } else document.getElementById("iii").style.color = "red";
        }
    };
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send("name=" + name + "&password=" + password);
}

function putVote() { //创建xhr对象
    const xhr = new XMLHttpRequest();
    if(xhr == null){
        alert("浏览器版本过低！！！");
        return ;
    }
    const id = document.getElementById("putId").innerText;

    const url = "/ov/PutVoteAjaxServlet?id="+id;
    //post方式提交
    xhr.open("get", url, true);
    xhr.onreadystatechange = function () {
        if(xhr.readyState == 4 && xhr.status == 200) {
            if(xhr.responseText.indexOf("成功")>=0){
                window.location.reload();
                document.getElementById("count").innerText = parseInt(document.getElementById("count").innerText)+1;
            }
            alert(xhr.responseText);
        }
    };
    xhr.send(null);
}


function updatePass(){

    const xhr = new XMLHttpRequest();
    if(xhr == null){
        alert("浏览器版本过低！！！");
        return ;
    }


    const before = document.getElementById("before");
    const pass = document.getElementById("update");
    const pass2 = document.getElementById("update2");

    if(pass.value != pass2.value){
        alert("两次密码不同");
        return ;
    }

    const url = "/ov/UpdatePassServlet";

    //post方式提交
    xhr.open("post", url, true);
    xhr.onreadystatechange = function () {
        if(xhr.readyState == 4 && xhr.status == 200) {
            if(parseInt(xhr.responseText) >= 1){
                alert("修改成功，下次登录需要重新验证");
               pass2.value = pass.value = before.value = "";
            } else alert("修改失败");
        }
    };
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send("before=" + before.value + "&password=" + pass.value);
}
