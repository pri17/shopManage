<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'newgoods.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
        #form1
        {
            height: 301px;
        }
        </style>
    <link rel="stylesheet" type="text/css" href="res/css/track.css">
     <script type="text/javascript">
         function menuFix() {
             var sfEls = document.getElementById("Nav").getElementsByTagName("li");
             for (var i = 0; i < sfEls.length; i++) {
                 sfEls[i].onmouseover = function () {
                     this.className += (this.className.length > 0 ? " " : "") + "dropdown--open";
                     //window.alert("this.id");
                     //boxID = this.id
                 }
                 sfEls[i].onMouseDown = function () {
                     this.className += (this.className.length > 0 ? " " : "") + "dropdown--open";
                 }
                 sfEls[i].onMouseUp = function () {
                     this.className += (this.className.length > 0 ? " " : "") + "dropdown--open";
                 }
                 sfEls[i].onmouseout = function () {
                     this.className = this.className.replace(new RegExp("( ?|^)dropdown--open\\b"), "");
                 }
             }
             mymantou();
         }
         window.onload = menuFix;
         function hiddenen() {
             document.getElementById("tlb_hidden").style.display = "none";
             document.getElementById("tlb_show").style.display = "block";
             document.getElementById("track_right").style.display = "none";
             document.getElementById("items").style.display = "none";
         }
         function show() {
             document.getElementById("tlb_hidden").style.display = "block";
             document.getElementById("tlb_show").style.display = "none";
             document.getElementById("track_right").style.display = "block";
             document.getElementById("items").style.display = "block";
         }
         var mflag = true;
         var aflag = true;
         var wflag = true;
         function mymantou() {
             document.getElementById("message").onmouseover = function () {
                 if (mflag)
                     document.getElementById("letter").src = "../Design/newletter_hover.png";
             }
             document.getElementById("message").onmouseout = function () {
                 if (mflag)
                     document.getElementById("letter").src = "../Design/newletter.png";
             }
             document.getElementById("advise").onmouseover = function () {
                 if (aflag)
                     document.getElementById("foot").src = "../Design/newfoot_hover.png";
             }
             document.getElementById("advise").onmouseout = function () {
                 if (aflag)
                     document.getElementById("foot").src = "../Design/newfoot.png";
             }
             document.getElementById("watch").onmouseover = function () {
                 if (wflag)
                     document.getElementById("watchimg").src = "../Design/newwatch_hover.png";
             }
             document.getElementById("watch").onmouseout = function () {
                 if (wflag)
                     document.getElementById("watchimg").src = "../Design/newwatch.png";
             }
         }
         function mmes() {
             document.getElementById("letter").src = "../Design/newletter_active.png";
             document.getElementById("foot").src = "../Design/newfoot.png";
             document.getElementById("watchimg").src = "../Design/newwatch.png";
             mflag = false;
             aflag = true;
             wflag = true;
             document.getElementById("mletter").style.display = "block";
             document.getElementById("firstleft").style.display = "none";
             document.getElementById("cwatch").style.display = "none";
             document.getElementById("cfoot").style.display = "none";
         }
         function ames() {
             document.getElementById("foot").src = "../Design/newfoot_active.png";
             document.getElementById("letter").src = "../Design/newletter.png";
             document.getElementById("watchimg").src = "../Design/newwatch.png";
             mflag = true;
             aflag = false;
             wflag = true;
             document.getElementById("mletter").style.display = "none";
             document.getElementById("firstleft").style.display = "none";
             document.getElementById("cwatch").style.display = "none";
             document.getElementById("cfoot").style.display = "block";
         }
         function wmes() {
             document.getElementById("watchimg").src = "../Design/newwatch_active.png";
             document.getElementById("letter").src = "../Design/newletter.png";
             document.getElementById("foot").src = "../Design/newfoot.png";
             mflag = true;
             aflag = true;
             wflag = false;
             document.getElementById("mletter").style.display = "none";
             document.getElementById("firstleft").style.display = "none";
             document.getElementById("cwatch").style.display = "block";
             document.getElementById("cfoot").style.display = "none";
         }
</script>

    <link rel="stylesheet" type="text/css" href="res/css/home.css">
    <link rel="stylesheet" type="text/css" href="res/css/combox.css">
    <link rel="stylesheet" type="text/css" href="res/css/box.css">
  </head>
  <body id="order-check">
    <div id="doc" class="bg-for-new-index">
    <header id="site-mast" class="site-mast set-mast--poisearch">
        <div id="Nav" class="site-mast__user-nav-w">
        <div id="Navbd" class="site-mast__user-nav cf">
            <ul id="NavL" class="mobile-info"></ul>
            <li id="J-user-info-w" class="user-info cf"></li>
            
                </div>  
        </div>
        <div class="site-mast__branding cf">
        
            <a class="site-logo sp-header-new-hd" href="res/image/logo.png">mei</a>

             

            
            <div class="site-commitment"></div>
            </div>
        <div class="site-mast__site-nav-w">
            <div class="site-mast__site-nav">
                <div class="site-mast__site-nav-inner">
                    <span class="mt-cates J-nav__trigger">新进商品</span>
                <nav>
                <ul class="navbar cf"><li class="navbar__item-w">
                </li>
                
                
                
                <li class="navbar__item-w"></li>
                </ul>
            </nav>
        </div></div></div>
    </header>
    
    <div id="bdw" class="bdw">
        <div id="bd" class="cf">
        <div id="content" class="pg-signup" style="width:920px;">
        <div class="mainbox" style=" padding-left: 120px; padding-top: 60px; padding-right: 120px; padding-bottom: 60px; ">
        <div class="head-section cf">
            <ul><li class="current"><a class="email-trigger">
            <i></i>
            <span></span>商品信息</a></li></ul>
            
        </div>
<form method="post" action="register.aspx" onsubmit="javascript:return WebForm_OnSubmit();" id="Form1" class="common-form signup-form" autocomplete="off">
<div class="aspNetHidden">
<input type="hidden" name="__EVENTTARGET" id="__EVENTTARGET" value="">
<input type="hidden" name="__EVENTARGUMENT" id="__EVENTARGUMENT" value="">
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="/wEPDwUKLTY4MTgwMDYwNWQYAQUeX19Db250cm9sc1JlcXVpcmVQb3N0QmFja0tleV9fFgEFF2N0bDAwJGNvbnRlbnQkQ2hlY2tCb3gyWQqoQhGqZ9cQlzO2oMDuajFNk2o5hcYwFzjBJvbAg0g=">
</div>

<script type="text/javascript">
//<![CDATA[
    var theForm = document.forms['Form1'];
    if (!theForm) {
        theForm = document.Form1;
    }
    function __doPostBack(eventTarget, eventArgument) {
        if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
            theForm.__EVENTTARGET.value = eventTarget;
            theForm.__EVENTARGUMENT.value = eventArgument;
            theForm.submit();
        }
    }
//]]>
</script>


<script src="/mantou/WebResource.axd?d=j6jtKYFpfdevGCzGcOPy5SPhjJ0d4yur8ZcKeV73gpmM39GgGwy76SB7kgo8mIQW51sIwORF0QPp5PHmD_os-wvcGv8hU0Ja_LOV0E-FXMY1&amp;t=635195661120000000" type="text/javascript"></script>


<script src="/mantou/WebResource.axd?d=6Nkq_LHvxfHGZaiEmXLU7ql-LuenEIug1edX7g9I722gzn2Bai5gHs8EwqKigmzBvtg2SS51KKE3xIJeyUbuFhR9qZTVVVes12Tpywzl3-81&amp;t=635195661120000000" type="text/javascript"></script>
<script type="text/javascript">
//<![CDATA[
    function WebForm_OnSubmit() {
        if (typeof (ValidatorOnSubmit) == "function" && ValidatorOnSubmit() == false) return false;
        return true;
    }
//]]>
</script>

<div class="aspNetHidden">

	<input type="hidden" name="__EVENTVALIDATION" id="__EVENTVALIDATION" value="/wEdAA9c0LSLfmfjtnIUHaqHnmfZKyRRtVC6hgKCXBJmykxt3zb+zsdlBBFGPIscPlJKdnTUDBa1J/HIodMaVuY9oGUTaVjEL3RsIk1E6HEZaw7J2wWy25Jk/vh1o1U6hMMqVZV/o9c8rqV9xrolkFxcYcYsK1erB5k5pv/mi26dnCXX5bkqF28K23XYEr0jryQcSQ1Ceyg9CmOVL051acxr3tQvUMdhvKCVcM4zkC3nEmspHN8kn3HB5+F+JmKhiTjuEQ4/77Sn6Djun10MAtrNvRSpdAhg79RkWjOYUupOMitJyKL25ymok2mQEjTT0R9vRx4wzDUy2+Qw0OnlwHB9K4k5hJGtRCncoPFlPr3telnykw==">
</div>
     <div class="field-group field-group--type"> 
    <label for="signup-username">商品名字</label>
    
                   
        <input name="ctl00$content$TextBox1" type="text" id="content_TextBox1" class="f-text smiddle-text user-name"><br />
&nbsp;<span id="content_RequiredFieldValidator4" class="inline-tip" style="color:Red;visibility:hidden;">用户名不能为空</span>
       </div>


    <div class="field-group">
        <label for="fullname">
                   
                    商品原价
                    </label>
        <input name="ctl00$content$TextBox7" type="text" id="content_TextBox7" class="f-text">
        <span id="content_RequiredFieldValidator9" style="color:Red;visibility:hidden;">
        <br />
        真实姓名不能为空</span>
        </div>

    <div class="field-group">
        <label for="fullname">
                   
                    商品售价
                    </label> 
        <input name="ctl00$content$TextBox8" type="text" id="content_TextBox8" class="f-text">

        <span id="content_RequiredFieldValidator10" style="color:Red;visibility:hidden;">
        <br />
        身份证号不能为空</span>
        <span id="content_RegularExpressionValidator1" style="color:Red;visibility:hidden;">身份证号格式错误</span>
        </div>

     <div class="field-group">
        <label for="fullname">
                   
                    商品类别
                    </label> 
        <select name="ctl00$content$DropDownList1" id="content_DropDownList1" class="style1" style="width:232px;height:32px;">
	<option value="0">家电</option>
	<option value="1">食品</option>
  <option value="0">日用百货</option>
  <option value="0">其他</option>

</select>
        <span id="content_RequiredFieldValidator11" style="color:Red;visibility:hidden;">
         <br />
         选择性别</span>
        </div>


     <div class="field-group">
        <label for="fullname">
                    
                  商品数量
                    </label> 
        <input name="ctl00$content$TextBox6" type="text" id="content_TextBox6" class="f-text">
        <span id="content_RequiredFieldValidator12" style="color:Red;visibility:hidden;">年龄<br />
         不能为空</span>
        </div>


    



    

  





        <div class="field-group">
            <input type="submit" value="确认录入" name="ctl00$content$Button2" onclick="" id="content_Button2" class="btn submit-btn btn-primary" style="height:32px;width:213px;">
        </div>
     </form></div>  
    
    
<script type="text/javascript">
//<![CDATA[
    var Page_Validators = new Array(document.getElementById("content_RequiredFieldValidator4"), document.getElementById("content_RequiredFieldValidator9"), document.getElementById("content_RequiredFieldValidator10"), document.getElementById("content_RegularExpressionValidator1"), document.getElementById("content_RequiredFieldValidator11"), document.getElementById("content_RequiredFieldValidator12"), document.getElementById("content_RequiredFieldValidator13"), document.getElementById("content_RequiredFieldValidator14"), document.getElementById("content_CompareValidator1"), document.getElementById("content_RequiredFieldValidator15"), document.getElementById("content_RequiredFieldValidator16"));
//]]>
</script>

<script type="text/javascript">
//<![CDATA[
    var content_RequiredFieldValidator4 = document.all ? document.all["content_RequiredFieldValidator4"] : document.getElementById("content_RequiredFieldValidator4");
    content_RequiredFieldValidator4.controltovalidate = "content_TextBox1";
    content_RequiredFieldValidator4.errormessage = "用户名不能为空";
    content_RequiredFieldValidator4.evaluationfunction = "RequiredFieldValidatorEvaluateIsValid";
    content_RequiredFieldValidator4.initialvalue = "";
    var content_RequiredFieldValidator9 = document.all ? document.all["content_RequiredFieldValidator9"] : document.getElementById("content_RequiredFieldValidator9");
    content_RequiredFieldValidator9.controltovalidate = "content_TextBox7";
    content_RequiredFieldValidator9.errormessage = "真实姓名不能为空";
    content_RequiredFieldValidator9.evaluationfunction = "RequiredFieldValidatorEvaluateIsValid";
    content_RequiredFieldValidator9.initialvalue = "";
    var content_RequiredFieldValidator10 = document.all ? document.all["content_RequiredFieldValidator10"] : document.getElementById("content_RequiredFieldValidator10");
    content_RequiredFieldValidator10.controltovalidate = "content_TextBox8";
    content_RequiredFieldValidator10.errormessage = "身份证号不能为空";
    content_RequiredFieldValidator10.evaluationfunction = "RequiredFieldValidatorEvaluateIsValid";
    content_RequiredFieldValidator10.initialvalue = "";
    var content_RegularExpressionValidator1 = document.all ? document.all["content_RegularExpressionValidator1"] : document.getElementById("content_RegularExpressionValidator1");
    content_RegularExpressionValidator1.controltovalidate = "content_TextBox8";
    content_RegularExpressionValidator1.errormessage = "身份证号格式错误";
    content_RegularExpressionValidator1.evaluationfunction = "RegularExpressionValidatorEvaluateIsValid";
    content_RegularExpressionValidator1.validationexpression = "\\d{17}[\\d|X]|\\d{15}";
    var content_RequiredFieldValidator11 = document.all ? document.all["content_RequiredFieldValidator11"] : document.getElementById("content_RequiredFieldValidator11");
    content_RequiredFieldValidator11.controltovalidate = "content_DropDownList1";
    content_RequiredFieldValidator11.errormessage = "选择性别";
    content_RequiredFieldValidator11.evaluationfunction = "RequiredFieldValidatorEvaluateIsValid";
    content_RequiredFieldValidator11.initialvalue = "";
    var content_RequiredFieldValidator12 = document.all ? document.all["content_RequiredFieldValidator12"] : document.getElementById("content_RequiredFieldValidator12");
    content_RequiredFieldValidator12.controltovalidate = "content_TextBox6";
    content_RequiredFieldValidator12.errormessage = "年龄不能为空";
    content_RequiredFieldValidator12.evaluationfunction = "RequiredFieldValidatorEvaluateIsValid";
    content_RequiredFieldValidator12.initialvalue = "";
    var content_RequiredFieldValidator13 = document.all ? document.all["content_RequiredFieldValidator13"] : document.getElementById("content_RequiredFieldValidator13");
    content_RequiredFieldValidator13.controltovalidate = "content_TextBox10";
    content_RequiredFieldValidator13.errormessage = "所在地不能为空";
    content_RequiredFieldValidator13.evaluationfunction = "RequiredFieldValidatorEvaluateIsValid";
    content_RequiredFieldValidator13.initialvalue = "";
    var content_RequiredFieldValidator14 = document.all ? document.all["content_RequiredFieldValidator14"] : document.getElementById("content_RequiredFieldValidator14");
    content_RequiredFieldValidator14.controltovalidate = "content_TextBox2";
    content_RequiredFieldValidator14.errormessage = "密码不能为空";
    content_RequiredFieldValidator14.evaluationfunction = "RequiredFieldValidatorEvaluateIsValid";
    content_RequiredFieldValidator14.initialvalue = "";
    var content_CompareValidator1 = document.all ? document.all["content_CompareValidator1"] : document.getElementById("content_CompareValidator1");
    content_CompareValidator1.controltovalidate = "content_TextBox4";
    content_CompareValidator1.errormessage = "密码输入不一致";
    content_CompareValidator1.evaluationfunction = "CompareValidatorEvaluateIsValid";
    content_CompareValidator1.controltocompare = "content_TextBox2";
    content_CompareValidator1.controlhookup = "content_TextBox2";
    var content_RequiredFieldValidator15 = document.all ? document.all["content_RequiredFieldValidator15"] : document.getElementById("content_RequiredFieldValidator15");
    content_RequiredFieldValidator15.controltovalidate = "content_TextBox3";
    content_RequiredFieldValidator15.errormessage = "邮箱号不能为\r\n\r\n空";
    content_RequiredFieldValidator15.evaluationfunction = "RequiredFieldValidatorEvaluateIsValid";
    content_RequiredFieldValidator15.initialvalue = "";
    var content_RequiredFieldValidator16 = document.all ? document.all["content_RequiredFieldValidator16"] : document.getElementById("content_RequiredFieldValidator16");
    content_RequiredFieldValidator16.controltovalidate = "content_TextBox5";
    content_RequiredFieldValidator16.errormessage = "请输出验证码";
    content_RequiredFieldValidator16.evaluationfunction = "RequiredFieldValidatorEvaluateIsValid";
    content_RequiredFieldValidator16.initialvalue = "";
//]]>
</script>


<script type="text/javascript">
//<![CDATA[

    var Page_ValidationActive = false;
    if (typeof (ValidatorOnLoad) == "function") {
        ValidatorOnLoad();
    }

    function ValidatorOnSubmit() {
        if (Page_ValidationActive) {
            return ValidatorCommonOnSubmit();
        }
        else {
            return true;
        }
    }
        //]]>
</script>

    </div>
    </div>
    </div>

    <footer class="site-info-w">
    </footer>

<div id="track" style="right: 0px; top: 220px;">
        <div class="main_track">
            
            <div id="track_right" style="display: none;">
                <div class="tr_content">
                    <div class="trc_left">
                        <ul id="firstleft"><li style="font-family:Droid Sans; font-size:14px; color:White; text-align:center; padding-top:50px">和馒头在一起的日子~</li></ul>
                       <ul id="mletter" style="display:none;">
                            
                        </ul>
                        <ul id="cfoot" style="display:none;">
                            
                        </ul>
                        <ul id="cwatch" style="display:none;">
                            
                        </ul>
                    </div>
                    <!-- end trc_left -->
                    <div class="clear">
                    </div>
                </div>
                <!-- end tr_content -->
            </div>
            <!-- end track_right -->
            <!-- end track_left -->
            <div class="clear">
            </div>
        </div>
        <!-- end main_track -->
    </div>
    <div class="site-info-nav cf">
  &nbsp;<font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 东华大学科学与技术学院
    <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 版权所有 卓越软件12级 朱博宇 周敏 周佳雯 2014年4月1日
  </font>
        </div>
</div>
  </body>
</html>
