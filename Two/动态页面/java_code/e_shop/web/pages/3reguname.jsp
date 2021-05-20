<%--
  Created by IntelliJ IDEA.
  User: JAVASM
  Date: 2021/5/13
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js" type="text/javascript" charset="utf-8"></script>

</head>
<body>
用户名 <input type="text" id="mytext"><span id="nameReg"></span>

</body>
<script>
    /*
    * jquery优化的ajax调用
    * 有完整参数配置的ajax方法
    * $.ajax({url:"ajaxdemo",
          type:"get",
          data:{"uname":$("#mytext").val()},         //json格式 {"key":value}   urlencoded格式  xxx=xx&xxx=xx
          dataType:"text",
          success:function(data){
                console.log(data);
          }})
    *$.post("地址",参数,回调,返回数据格式)
    *$.get("地址",参数,回调,返回数据格式)
    *$.getJSON("地址",参数,回调)
    * */


    $("#mytext").change(function(){
       /* $.post("regUname",{"uname":$(this).val()},function(data){
            //如果返回的json格式有错
            console.log(data);
           /!* 手动转json
           var myJson = JSON.parse(data);
            //{"msg":"用户名重复","color":"red"}
            *!/
            $("#nameReg").html(data.msg);
            $("#nameReg").css("color",data.color);
        },"json")*/
       // {"code":10001,"returnData":"red","returnMsg":"用户名可用"}
       $.getJSON("regUname",{"uname":$(this).val()},function(data){
           console.log(data.code);
           $("#nameReg").html(data.returnMsg);
           $("#nameReg").css("color",data.returnData);
       })
        /*
         接口访问地址  : regUname
        * 接收的参数    : uname  用户名
        * 接收方式      : get/post
        * 返回数据格式  :json
        * 返回数据示例  :  {"code":10001,
        *                   "returnData":"red",
        *                   "returnMsg":"用户名可用"}
        *
        *
        * */
    })

</script>
</html>
