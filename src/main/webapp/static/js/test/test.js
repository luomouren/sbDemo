/**
 * Created by DELL on 2017-12-17.
 */

var host = "localhost:8088/";

/**
 * 登录获取token
 */
function login() {
    var url = "";
    $.ajax({
        type: "POST",
        url: host + url,
        data: {},
        success: function (data) {
            console.log("login-data", data);
            $("#accessToken").val(data);
        }
    })
}


/**
 * 测试Token请求
 */
function testToken() {
    var url = "user/modifyUserInfo";

    var userId;
    var userName;
    var realName;
    var cellphone;
    var emodelId;
    var email;
    var description;

    var params = {};
    params["userId"] = userId;
    params["userName"] = userName;
    params["realName"] = realName;
    params["cellphone"] = cellphone;
    params["emodelId"] = emodelId;
    params["email"] = email;
    params["description"] = description;


    $.ajax({
        type: "POST",
        url: host + url,
        data: params,
        success: function (data) {
            console.log("data", data);
        }
    })
}