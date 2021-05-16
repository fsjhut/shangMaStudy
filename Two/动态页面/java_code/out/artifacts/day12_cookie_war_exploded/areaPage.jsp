<%--
  Created by IntelliJ IDEA.
  User: JAVASM
  Date: 2021/5/13
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.6.0.min.js" type="text/javascript" charset="utf-8"></script>

</head>
<body>
    <select id="prov">
        <option disabled selected >----请选择-----</option>

    </select>省
    <select id="city">
        <option disabled selected >----请选择-----</option>

    </select>市
    <select id="coun">
        <option disabled selected >----请选择-----</option>
    </select>县区
</body>
<script>
    /*获取地区服务接口
 * 接口访问地址  : getarea
 * 接收的参数    : pcode  上级数据的编号
 * 接收方式      : get/post
 * 返回数据格式  :json
 * 返回数据示例  :  {"code":10001,
 *                   "returnMsg":"用户名可用",
 *                   "returnData":[{"areaCode":100000,"areaName":"xxxxxx"},
 *                                {"areaCode":200000,"areaName":"xxxxxx"}]
 *                   }
*
*
*   附加文档 状态码表
*     NAME_OK(10001,"用户名可用"),
    NAME_DUP(10003,"用户名重复"),
    REQ_SUCCESS(20001,"请求成功"),
    REQ_FAILED(50000,"请求失败");
    */
//页面加载结束后 访问后台接口
    $.post("getarea",{"pcode":0},function(data){
        if(data.code == 20001){
            $.each(data.returnData,function(i,d){
                var mycontent = '<option value="'+d.areaCode+'">'+d.areaName+'</option>';
                $("#prov").append(mycontent);
            })
        }else if(data.code == 50000){
            console.log(data.returnMsg);
        }
    },"json")

    //省发生改变时 访问后台接口
    $("#prov").change(function(){
        var provCode = $("#prov").val();
        $("#city").html('<option disabled selected >----请选择-----</option>');
        $("#coun").html('<option disabled selected >----请选择-----</option>');
        $.post("getarea",{"pcode":provCode},function(data){
            if(data.code == 20001){
                $.each(data.returnData,function(i,d){
                    var mycontent = '<option value="'+d.areaCode+'">'+d.areaName+'</option>';
                    $("#city").append(mycontent);
                })
            }else if(data.code == 50000){
                console.log(data.returnMsg);
            }
        },"json")

    })

    //市发生改变 访问后台接口
    $("#city").change(function(){
        var cityCode = $(this).val();
        $("#coun").html('<option disabled selected >----请选择-----</option>');
        $.post("getarea",{"pcode":cityCode},function(data){
            if(data.code == 20001){
                $.each(data.returnData,function(i,d){
                    var mycontent = '<option value="'+d.areaCode+'">'+d.areaName+'</option>';
                    $("#coun").append(mycontent);
                })
            }else if(data.code == 50000){
                console.log(data.returnMsg);
            }
        },"json")
    })



</script>
</html>
