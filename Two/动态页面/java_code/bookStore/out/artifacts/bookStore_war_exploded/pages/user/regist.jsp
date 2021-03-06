<%@ page contentType="text/jsp;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="/day10/css/bootstrap.css" /> -->
	<!--<script src="../../js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>-->
	<!--<script src="../../js/addr.js" type="text/javascript" charset="utf-8"></script>-->
	<!--<script src="../../js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>-->
	<!--<script src="../../js/echarts.min.js" type="text/javascript" charset="utf-8"></script>-->
	<!--<script src="../../css/bootstrap.min.css" type="text/javascript" charset="utf-8"></script>-->
	<script src="/book/js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="/book/js/addr.js" type="text/javascript" charset="utf-8"></script>
	<script src="/book/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="/book/js/echarts.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="/book/css/bootstrap.min.css" type="text/javascript" charset="utf-8"></script>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.4/favicon.ico">
	<link rel="canonical" href="https://getbootstrap.com/docs/3.4/examples/signin/">
	<title>Signin Template for Bootstrap</title>
	<link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.4/dist/css/bootstrap.min.css"
		  rel="stylesheet">
	<link
			href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.4/assets/css/ie10-viewport-bug-workaround.css"
			rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.4/examples/signin/signin.css"
		  rel="stylesheet">
	<style>
		.mycls {
			margin-top: 30px;

		}
	</style>

</head>
<body>
<div class="container">
	<div class="form-signin-heading" align="center">
		<h1 class="form-signin-heading" style="font-size: 50px;">?????? ??????</h1>
	</div>
	<div class="row mycls">
		<div class="col-lg-8">
			<form class="form-horizontal" action="/book/jsp/user/login" method="get">
				<div class="container" style="font-size: 18px;">
					<div class="form-group">
						<label class="col-sm-3 control-label">??????</label>
						<div class="col-sm-6">
							<input type="text" name="name" class="form-control" placeholder="?????????2?????????" data-val="true"
								   required autofocus
								   data-val-length="???????????? 4-10 ????????? (2-5 ?????????)" data-val-length-max="10"
								   data-val-length-min="2" data-val-nospace="?????????????????????????????????"
								   data-val-remote="'???????????????' is invalid."
								   data-val-remote-additionalfields="*.LoginName,*.Email" data-val-remote-type="Post"
								   data-val-required="????????????????????????" id="LoginName" aria-invalid="false"
								   aria-describedby="LoginName-error">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">??????</label>
						<div class="col-sm-6">
							<input class="is-invalid form-control validate-equalTo-blur" type="password" name="password"
								   placeholder="??????8?????????????????????????????????????????????????????????" required autofocus
								   data-val="true" data-val-length-max="50" data-val-length-min="8"
								   data-val-nospace="????????????????????????"
								   data-val-password-complexity="??????????????????????????????????????????????????????????????????????????????"
								   data-val-regex="???????????????????????????????????????" data-val-regex-pattern="^((?![^\x00-\xff]).)*$"
								   data-val-required="???????????????" id="Password" data-toggle="tooltip"
								   data-placement="bottom" title="" data-original-title="?????????????????????"
								   aria-autocomplete="list" aria-invalid="true">
						</div>
					</div>
					<div class="form-group">
						<label for="ConfirmPassword" class="col-sm-3 control-label">????????????</label>
						<div class="col-sm-6">
							<input type="password" name="ConfirmPassword" class="form-control is-invalid"
								   placeholder="?????????????????????" required autofocus data-val="true"
								   data-val-equalto-other="*.Password" id="ConfirmPassword" data-toggle="tooltip"
								   data-placement="bottom" title="" data-original-title="?????????????????????" aria-invalid="true">
							<span class="invalid-feedback field-validation-error" data-valmsg-for="ConfirmPassword"
								  data-valmsg-replace="true"><span id="ConfirmPassword-error"
																   class="is-invalid">????????????????????????????????????</span></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">?????????</label>
						<div class="col-sm-6">
							<input type="text" name="phone" class="form-control" placeholder="phone" required autofocus
								   data-val="true" data-val-maxlength="????????????????????????" data-val-maxlength-max="15"
								   data-val-regex="????????????????????????" data-val-regex-pattern="^\d{4,15}$"
								   data-val-remote="'????????????' is invalid."
								   data-val-remote-additionalfields="*.PhoneNum,*.CountryCode"
								   data-val-required="?????????????????????" id="PhoneNum" value=""
								   aria-describedby="PhoneNum-error" aria-invalid="true">
							<span class="invalid-feedback field-validation-error" data-valmsg-for="PhoneNum"
								  data-valmsg-replace="true"><span id="PhoneNum-error"
																   class="is-invalid">????????????????????????</span></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">??????</label>
						<div class="col-sm-6">
							<input type="email" name="email" class="form-control" placeholder="email" required
								   autofocus data-val="true"
								   data-val-email="????????????????????????" data-val-maxlength="????????????????????????120?????????"
								   data-val-maxlength-max="120" data-val-regex="????????????????????????????????????"
								   data-val-regex-pattern="[\w!#\$%&amp;'\*\+\-\/=\^_`{\|}~.]+@([\w-]+\.)+(com|net|cn|org|me|cc|biz)$"
								   data-val-remote="'??????' is invalid." data-val-remote-additionalfields="*.Email"
								   data-val-remote-type="Post" data-val-remote-url="/account/checkemail"
								   data-val-required="?????????????????????" id="Email" value=""
								   aria-describedby="Email-error" aria-invalid="false">
							<span class="invalid-feedback field-validation-valid" data-valmsg-for="Email"
								  data-valmsg-replace="true"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">??????</label>
						<div class="col-sm-6">
							<label class="checkbox-inline">
								<input type="radio" name="gender" value="0">???
							</label>
							<label class="checkbox-inline">
								<input type="radio" name="gender" value="1">???
							</label>
							<label class="checkbox-inline">
								<input type="radio" name="gender" value="2" checked="checked">??????
							</label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">????????????</label>
						<div class="col-sm-6">
							<input type="date" name="birth" class="form-control" placeholder="birth" required autofocus>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label">??????</label>
						<div class="col-sm-6" style="display: inline-block;" ;>
							<select id="prov" class="form-control" name="prov">
								<option disabled selected>------?????????------</option>
							</select>
							<select id="city" class="form-control" name="city">
								<option disabled selected>------?????????------</option>
							</select>
							<select id="coun" class="form-control" name="county">
								<option disabled selected>------?????????------</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">??????</label>
						<div class="col-sm-6">
							<input type="text" name="areaDetail" class="form-control" placeholder="Address" required
								   autofocus>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">????????????</label>
						<div class="col-sm-6">
									<textarea class="form-control" name="resume" rows="7" cols="40"
											  placeholder="Personal resume"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">??????</label>
						<div class="col-sm-6">
									<textarea class="form-control" name="comment" rows="4" cols="40"
											  placeholder="Comments"></textarea>
						</div>
					</div>
					<div class="form-group" align="center">
						<input type="submit" value="??????" align="center">
						<input type="reset" value="??????" align="center">
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</body>

<script type="text/javascript">
    // ?????????????????????
    // 1. ??????????????????????????????prov??????????????????  temp???????????????
    $.each(temp, function (i, d) {
        var content = "<option value='" + d.code + "'>" + d.label + "</option>"
        $("#prov").append(content);
    });
    // 2. ??????????????????????????????????????????????????????
    $("#prov").change(function () {
        $("#city").jsp('<option disabled selected>-----?????????-----</option>');
        $("#coun").jsp("<option disabled selected>-----?????????-----</option>");
        $.each(temp, function (i, d) {
            // ????????????????????????code
            if (d.code == $("#prov").val()) {
                // ???????????????????????????
                $.each(d.children, function (i, d) {
                    var content = "<option value='" + d.code + "'>" + d.label + "</option>"
                    $("#city").append(content)
                })
            }
        })
    })
    // 3. ??????/??????????????????????????????????????????
    $("#city").change(function () {
        $("#coun").jsp("<option disabled selected>-----?????????-----</option>");
        var cityCode = $("#city").val();
        var provCode = $("#prov").val();
        $.each(temp, function (i, d) {
            if (d.code == provCode) {
                $.each(d.children, function (i, d) {
                    if (d.code == cityCode) {
                        $.each(d.children, function (i, d) {
                            var content = "<option value='" + d.code + "'>" + d.label +
                                "</option>";
                            $("#coun").append(content);
                        })
                    }
                })
            }
        })
    })
</script>
</html>

