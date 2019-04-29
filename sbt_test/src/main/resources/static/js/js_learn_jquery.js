function js_test_jqeury() {
    /* hello jquey */
    $("#b1").click(function () {
        $("#d").hide();
    });
    $("#b2").click(function () {
        $("#d").show();
    });


    /* 常见方法 */
    // 取值.val
    $("#b_get_value").click(function () {
        alert("当前值：" + $("#t_value").val());
    });

    // 获取元素内容，若有子元素会保留标签.html
    $("#b_get_all_value_dot_html").click(function () {
        alert($("#d_value").html());
    });

    // 获取元素内容，若有子元素不会保留标签.text
    $("#b_get_all_value_dot_text").click(function () {
        alert($("#d_value").text());
    });


    /* css */
    // 增加css
    $("#b_add_color").click(function () {
        $("#d").addClass("pink");
    });
    // 去除css
    $("#b_remove_color").click(function () {
        $("#d").removeClass("pink");
    });
    // 添加css开关
    $("#b_toggle_color").click(function () {
        $("#d").toggleClass("pink");
    });
    // 添加单一样式
    $("#b_add_class_single").click(function () {
        $("#d").css("background-color", "gray");
    });
    // 添加多重样式
    $("#b_add_class_multi").click(function () {
        $("#d").css({"background-color": "blue", "color": "white"});
    });


    /* 选择器 */
    // $("tag_name")
    $("#b_selection_tag_name").click(function () {
        $("div").addClass("pink");
    });
    // $(".className")
    $("#b_selection_class_name").click(function () {
        $(".div_1").css("background-color", "blue");
    });
    // $("selector1 selector2")
    $("#b_selection_selector_selector").click(function () {
        $("div#id_div_3 span").css("color", "red");
    });
    // 先后
    $("#b_selection_first").click(function () {
        $("div:first").addClass("pink");
    });
    $("#b_selection_last").click(function () {
        $("div:last").addClass("pink");
    });
    // 奇偶
    $("#b_selection_odd").click(function () {
        $("div:odd").toggleClass("pink");
    });
    $("#b_selection_even").click(function () {
        $("div:even").toggleClass("pink");
    });
    // 可见性
    $("#b_selection_hide_visible").click(function () {
        $("div:visible").hide();
    });
    $("#b_selection_show_visible").click(function () {
        $("div:hidden").show();
    });
    // 属性
    // $(selector[attr])        满足条件的有某属性的元素
    // $(selector[attr=value])  满足条件的属性等于value的元素
    // $(selector[attr!=value]) 满足条件的属性不等于value的元素
    // $(selector[attr^=value]) 满足条件的属性以value开头的元素
    // $(selector[attr$=value]) 满足条件的属性以value结尾的元素
    // $(selector[attr*=value]) 满足条件的属性包含value的元素
    $("#b_attr_1").click(function () {
        $("div[id]").toggleClass("border");
    });
    $("#b_attr_2").click(function () {
        $("div[id=pink]").toggleClass("pink");
    });
    $("#b_attr_3").click(function () {
        $("div[id!=pink]").toggleClass("border");
    });
    $("#b_attr_4").click(function () {
        $("div[id^='p']").toggleClass("pink");
    });
    $("#b_attr_5").click(function () {
        $("div[id$='k']").toggleClass("pink");
    });
    $("#b_attr_6").click(function () {
        $("div[id*='ee']").toggleClass("border");
    });
    // 表单对象:$("td[rowspan!=13] 后面有一个空格，表示层级选择器 || toggle(500) 表示在显示与隐藏之间来回切换，生效时间是500毫秒
    $(".b").click(function () {
        var value = $(this).val();
        $("td[rowspan!=13] " + value).toggle(500);
    });
    // 表单对象属性
    $(".b1").click(function () {
        var value = $(this).val();
        $("td[rowspan!=13] " + value).toggle(500);
    });
    $(".b2").click(function () {
        var value = $(this).val();
        var options = $("td[rowspan!=13] " + value);
        alert("选中了" + options.length + "条记录！");
    });
    // 当前元素
    $("#b_this").click(function () {
        $(this).toggleClass("pink");
    });


    /* 筛选器[first()last()eq(num)parent()parents()children()find()siblings()] */
    $("#b_filter_1").click(function () {
        $("div").first().toggleClass("pink");
    });
    $("#b_filter_2").click(function () {
        $("div").last().toggleClass("pink");
    });
    $("#b_filter_3").click(function () {
        $("div").eq(3).toggleClass("pink");
    });
    $("#b_filter_parent").click(function () {
        $("#div_child").parent().toggleClass("pink");
    });
    $("#b_filter_parents").click(function () {
        $("#div_child").parents().toggleClass("pink");
    });
    $("#b_filter_child").click(function () {
        $("#div_child").children().toggleClass("pink");
    });
    $("#b_filter_find").click(function () {
        $("#div_child").find("div").toggleClass("pink");
    });
    $("#b_filter_siblings").click(function () {
        $("#div_grand_parent").siblings().toggleClass("pink");
    });


    /* 属性 */
    $("#b_attr_01").click(function () {
        console.log("h1标题的align属性：" + $('#h1_1').attr('align'));
    });
    $("#b_attr_02").click(function () {
        console.log("h1标题的自定义属性game：" + $('#h1_1').attr('game'));
    });
    $("#b_attr_03").click(function () {
        $("#h1_1").attr("align", "right");
    });
    $("#b_attr_04").click(function () {
        $("#h1_1").removeAttr("align");
    });
    $("#b_attr_05").click(function () {
        console.log("自定义属性game：" + $('#checkbox').attr('game'));
    });
    $("#b_attr_06").click(function () {
        console.log("自定义属性game：" + $('#checkbox').prop('game'));
    });
    $("#b_attr_07").click(function () { // attr 只能获取初始值 || prop 能够访问变化后的值且以true|false返回
        console.log("属性checked：" + $('#checkbox').attr('checked'));
    });
    $("#b_attr_08").click(function () {
        console.log("属性checked：" + $('#checkbox').prop('checked'));
    });


    /* 效果 */
    var div_effect = $("#div_effect");
    // 上下滑动
    $("#b_effect_1").click(function () {
        div_effect.slideUp();
    });
    $("#b_effect_2").click(function () {
        div_effect.slideDown();
    });
    $("#b_effect_3").click(function () {
        div_effect.slideToggle();
    });
    $("#b_effect_4").click(function () {
        div_effect.slideUp(1200);
    });
    $("#b_effect_5").click(function () {
        div_effect.slideDown(1200);
    });
    $("#b_effect_6").click(function () {
        div_effect.slideToggle(1200);
    });
    // 淡入淡出
    $("#b_effect_21").click(function () {
        div_effect.fadeOut();
    });
    $("#b_effect_22").click(function () {
        div_effect.fadeIn();
    });
    $("#b_effect_23").click(function () {
        div_effect.fadeToggle();
    });
    $("#b_effect_24").click(function () {
        div_effect.fadeOut(1200);
    });
    $("#b_effect_25").click(function () {
        div_effect.fadeIn(1200);
    });
    $("#b_effect_26").click(function () {
        div_effect.fadeToggle(1200);
    });
    $("#b_effect_27").click(function () {
        div_effect.fadeTo("slow", 0.5);
    });
    // 自定义动画
    $("#b_anim").click(function () {
        div_effect.animate({left: '100px'}, 2000);
        div_effect.animate({left: '0px', top: '50px', height: '50px'}, 2000);
    });
    $("#b_anim_callback").click(function () {
        div_effect.animate({left: '100px'}, 2000);
        div_effect.animate({left: '0px', top: '50px', height: '50px'}, 2000, function () {
            alert("动画演示结束");
        });
    });


    /* 数组操作 */
    // 遍历
    var arr1 = new Array(1, 3, 5, 7);
    $.each(arr1, function (i, v) {
        console.log("元素[" + i + "]-->" + v + "---111");
    });
    // 去重
    var arr2 = new Array(1, 3, 3, 5, 5, 7);
    $.unique(arr2);
    $.each(arr2, function (i, v) {
        console.log("去重后元素[" + i + "]-->" + v + "---222");
    });
    // 返回元素在数组中索引若无返回-1
    console.log($.inArray(3, arr1) + "---333");


    /* 字符串操作 */
    // trim
    console.log($.trim("  hello world  .   ") + "---444");


    /* json */
    var json = "{\"name\":\"akali\", \"sex\":\"female\"}";
    var hero = $.parseJSON(json);
    console.log("hero:" + hero + " || hero's name:" + hero["name"]);


    /* 对象转换 */
    $("#b_object_1").click(function () {
        var div_effect = $("#div_effect");
        var d = div_effect[0];
        var s = "jquery对象是：" + div_effect;
        console.log(s + " || 对应的dom对象是：" + d);
    });
    $("#b_object_2").click(function () {
        var div_effect = document.getElementById("div_effect");
        var d = $(div_effect);
        var s = "dom对象是：" + div_effect;
        console.log(s + " || 对应的jquery对象是：" + d);
    });


    /* 事件- */
    /* ajax- */
    $("#name_ajax").keyup(function () {
        var page = "http://how2j.cn/study/checkName.jsp";
        var value = $(this).val();
        $.ajax({
            url: page,
            data: {"name": value},
            success: function (result) {
                $("#span_check_result").html(result);
            },
            error: function (result) {
                $("#span_check_result").html(result);
            }
        });
    });
    $("#name_get").keyup(function () {
        var page = "http://how2j.cn/study/checkName.jsp";
        var value = $(this).val();
        $.get(
            page,
            {"name": value},
            function (result) {
                $("#span_check_result").html(result);
            }
        )
    });
    $("#name_post").keyup(function () {
        var page = "http://how2j.cn/study/checkName.jsp";
        var value = $(this).val();
        $.post(
            page,
            {"name": value},
            function (result) {
                $("#span_check_result").html(result);
            }
        )
    });
    $("#name_easy").keyup(function () {
        var page = "http://how2j.cn/study/checkName.jsp?name=" + $(this).val();
        $("#span_check_result").load(page);
    });
    // 格式化form下的输入数据
    $("input").keyup(function () {
        var data = $("#form_test").serialize();
        var url = "http://www.catface.cc";
        var link = url + "?" + data;
        $("#a_test").html(link);
        $("#a_test").attr("href", link);
    })
}