<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="layui/css/layui.css"  media="all">
    <link rel="stylesheet" href="css/input_style.css" />
</head>
<body>
<div class="place"> <span>位置：</span>
    <ul class="placeul">
        <li><a  href="index.html" target="rightFrame">首页</a></li>
        <li><a href="#">添加员工</a></li>
    </ul>
</div>
<br><br><br><br>
<div class="container">
    <form action="AdminRegisterServlet" method="post" enctype="multipart/form-data">
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="adminNameId">登录名</label>
                    <input type="text" name="adminName" class="form-control" id="adminNameId" placeholder="请输入登录名">
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="adminRealNameId">姓名</label>
                    <input type="text" name="adminRealName" class="form-control" id="adminRealNameId" placeholder="请输入真实姓名">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="adminPwdId">密码</label>
                    <input type="password" name="adminPwd" class="form-control" id="adminPwdId">
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="adminSexId">性别</label>
                    <select class="form-control" id="adminSexId" name="adminSex">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                </div>

            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <div class="form-group">
                    <label for="adminBirthdayId">出生日期</label>
                    <input type="text" name="adminBirthday" class="form-control" id="adminBirthdayId" placeholder="yyyy-MM-dd">
                </div>
            </div>
            <div class="col-md-4">
                <div class="form-group">
                    <label for="adminPhoneId">手机号码</label>
                    <input type="text" name="adminPhone" class="form-control" id="adminPhoneId" placeholder="请输入手机号码">
                </div>
            </div>
            <div class="col-md-4">
                <div class="form-group">
                    <label for="adminTypeId">员工类型</label>
                    <select class="form-control" id="adminTypeId" name="adminType">
                        <option value="1">技术老师</option>
                        <option value="2">班主任</option>
                        <option value="3">销售老师</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-10">
                <div class="form-group">
                    <label for="adminAddressId">家庭住址</label>
                    <textarea class="form-control" name="adminAddress" rows="5" id="adminAddressId"></textarea>
                </div>
            </div>
            <div class="col-md-2">
                <div class="form-group">
                    <label for="inputFile">点击添加头像</label><br>
                    <label class="lableStyle" for="inputFile">+</label><input type="file" name="adminHead" style="display: none;" class="inputStyle" onchange="fun(this);" id="inputFile" />
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-offset-5 col-lg-2 ">
                <input type="submit" class="btn btn-info" value="确认添加用户" />
            </div>
        </div>
    </form>
</div>
<script src="js/jquery-2.1.0.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="layui/layui.js" charset="utf-8"></script>
<script>
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //常规用法
        laydate.render({
            elem: '#adminBirthdayId'
        });
    });
    function fun(obj){
        var imageFile=obj.files[0];
        var is=new FileReader();
        is.readAsDataURL(imageFile)//通过流读取指定的路径的文件
        is.onload=function(e){//当图片加载完成后触发的函数
            $(".lableStyle").css("background-image","url('"+e.target.result+"')").text("");
        }

    }
</script>
</body>
</html>
