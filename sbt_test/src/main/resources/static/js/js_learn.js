/*
    js包含基础、BOM[Broswe Object Model浏览器对象模型]、DOM[Document Object Model文档对象模型]

* */

// PART_A 基础
/* 通过javascript向文档中输出文本 */
function js_hello_js() {
    var x = 99;
    console.log("x的值为：" + x);
    document.writeln("hello JavaScript...你好" + ++x);
    alert("我透\r\n" + new Date().toLocaleString());
}


/* 基本数据类型：undefined、boolean、number、string、var、typeof、null */
function js_base_data_type() {
    // 声明但未赋值
    var x;
    document.writeln('声明但未赋值的变量 x：' + x + '<br/>');

    // 布尔值
    x = true;
    var y = false;
    document.writeln('布尔值x:' + x + ' || y:' + y + '<br/>');

    // 数字
    var a = 10, b = 012, c = 0xF, d = 3.14, e = 3.14e2;
    document.writeln("十进制10:" + a + " || 八进制012:" + b + " || 十六进制0xF:" + c + " || 浮点数3.14:" + d + " || 科学计数法3.14e2:" + e + '<br/>');

    // 字符串
    x = 'hello';
    y = "javascript";
    document.writeln("单双引号内的字符串分别为：" + x + " || " + y + '<br/>');

    // typeof
    document.writeln("x的类型为：" + typeof x + '<br/>');
}


/* 类型转换 */
function js_type_change() {
    // 伪对象
    var s = 'hello catface';
    document.writeln('变量s的类型：' + typeof s + " || 变量s的长度：" + s.length + '<hr/>');

    // 转换为字符串
    var a = 10;
    document.writeln('数字' + a + '转换为字符串' + a.toString() + '<br/>');
    var b = true;
    document.writeln('布尔' + b + '转换为字符串' + b.toString() + '<br/>');
    var c = 'hello world';
    document.writeln('字串' + c + '转换为字符串' + c.toString() + '<hr/>');

    // 数字转字符串
    var n = 10;
    document.writeln('默认模式下，数字 10 转为十进制' + n.toString() + '<br/>');
    document.writeln('默认模式下，数字 10 转为二进制' + n.toString(2) + '<br/>');
    document.writeln('默认模式下，数字 10 转为八进制' + n.toString(8) + '<br/>');
    document.writeln('默认模式下，数字 10 转为十六进制' + n.toString(16) + '<hr/>');

    // 转换为数字
    document.writeln('字符串 10 转换为数字' + parseInt("10") + '<br/>');
    document.writeln('字符串 3.14 转换为数字' + parseFloat("3.14") + '<br/>');
    document.writeln('字符串 10abc 转换为数字' + parseInt("10abc") + '<br/>');
    document.writeln('字符串 hello 转换为数字' + parseInt("hello") + '<hr/>');

    // 转换为布尔
    document.writeln('空串/数字0/空对象null转换为布尔值为false || 非空串/非0/非空对象转换布尔值为true' + '<hr/>');

    // Number() vs parseInt()
    document.write("通过Number() 函数转换字符串'123' 后得到的数字：" + Number("123"));   //正常的
    document.write("<br>");
    document.write("通过Number() 函数转换字符串'123abc' 后得到的数字：" + Number("123abc"));   //包含非数字
    document.write("<br>");
    document.write("通过Number() 函数转换字符串'abc123' 后得到的数字：" + Number("abc123"));   //包含非数字
    document.write("<br>");

    document.write("通过parseInt() 函数转换字符串'123' 后得到的数字：" + parseInt("123"));   //正常的
    document.write("<br>");
    document.write("通过parseInt() 函数转换字符串'123abc' 后得到的数字：" + parseInt("123abc"));   //包含非数字,返回开头的合法数字部分
    document.write("<br>");
    document.write("通过parseInt() 函数转换字符串'abc123' 后得到的数字：" + parseInt("abc123") + '<hr/>');   //包含非数字,以非数字开头，返回NaN

    // String() vs toString()
    a = null;
    document.write('String(null) 把空对象转换为字符串：' + String(a));
    document.write("<br/>");
    document.write('null.toString() 就会报错，所以后面的代码不能执行');
    document.write(a.toString());
    document.write("因为第5行报错，所以这一段文字不会显示");
}


/* 循环语句 */
function js_test_for() {
    for (var i = 0; i < 5; i++) {
        if (3 === i) continue;
        alert('循环弹框：' + i);
    }
}


/* 异常捕获 */
function js_test_try() {
    try {
        document.write('试试执行 1/0');
        var a = 1 / 0;
        f2();
        document.write('结果：' + a);
    } catch (error) {
        document.write('捕获到异常：' + error);
    }
}


/* 对象-数字 */
function p1(s) {
    document.write(s);
    document.write("<br>");
}

function js_test_number() {
    var x = new Number(123);
    document.write('数字对象x的值:' + x);
    document.write("<br>");
    document.write('数字对象x的类型:' + typeof x); // object
    document.write("<br>");
    var y = 123;
    document.write('基本类型y的值:' + y);
    document.write("<br>");
    document.write('基本类型y的类型:' + typeof y + '<hr/>'); // Number

    document.write('Number对象的最小值:' + Number.MIN_VALUE);
    document.write("<br>");
    document.write('Number对象的最大值:' + Number.MAX_VALUE + '<hr/>');

    var a = new Number("123abc"); // 通过非数字创建Number对象，得到的是一个NaN
    p1('通过非数字字符串"123abc"创建出来的Number对象 a的值是：' + a);
    p1('但是, a==Number.NaN会返回:' + (a == Number.NaN)); // 即便是一个NaN 也"不等于" Number.NaN
    p1('正确判断是否是NaN的方式是调用isNaN函数:' + isNaN(a) + '<hr/>'); // 正确的方式是通过isNaN() 函数进行判断

    a = new Number("123");
    p1("数字对象123通过toFixed(2) 保留两位小数:" + a.toFixed(2)); // 保留两位小数点
    var b = new Number("3.1415926");
    p1("PI 通过toFixed(3) 保留三位小数:" + b.toFixed(3) + '<hr/>');    // 保留三位小数点

    a = new Number("123");
    p1("数字对象123通过toExponential 返回计数法表达 " + a.toExponential());
    b = new Number("3.1415926");
    p1("数字对象3.1415926通过toExponential 返回计数法表达 " + b.toExponential() + '<hr/>');

    a = new Number("123");
    b = a.valueOf();
    p1('数字对象a的类型是: ' + typeof a); // object
    p1('通过valueOf()返回的值的类型是' + typeof b); // Number
}


/* 对象-->String */
function js_test_string() {
    // 创建字符串对象
    var x = "5";
    var y = new String(x);
    document.write("变量x的值是:" + x);
    document.write("<br>");
    document.write("变量x的类型是:" + (typeof x));
    document.write("<br>");
    document.write("变量y的值是:" + y);
    document.write("<br>");
    document.write("变量y的类型是:" + (typeof y) + '<hr/>');

    // 字符串长度
    y = new String("Hello JavaScript");
    document.write("通过.length属性获取字符串'Hello JavaScript'的长度" + y.length + '<hr/>');

    // 指定位置的字符
    document.write("字符串y的值:" + y);
    document.write("<br>");
    document.write('通过 charAt(0)获取位置0的字符串： ' + y.charAt(0));
    document.write("<br>");
    document.write('通过 charCodeAt(0)获取位置0的字符的 Unicode码 ：' + y.charCodeAt(0) + '<hr/>');

    // 字符串拼接
    x = new String("Hello ");
    y = new String("Javascript");
    document.write('字符串x的值: ' + x);
    document.write('<br>');
    document.write('字符串y的值: ' + y);
    document.write('<br>');
    document.write('通过函数concat()把x和y连接起来: ' + x.concat(y) + '<hr/>');

    // 子串出现的位置
    y = new String("Hello JavaScript");
    document.write('字符串y的值: ' + y);
    document.write('<br>');
    document.write('通过 indexOf ("a")获取子字符"a" 第一次出现的位置 ' + y.indexOf("a"));
    document.write('<br>');
    document.write('通过 lastIndexOf ("a")获取子字符"a" 最后出现的位置 ' + y.lastIndexOf("a") + '<hr/>');

    // 比较两段字符串是否相同
    x = new String("Hello");
    y = new String("Hello");
    var z = new String("aloha");
    document.write('字符串x的值: ' + x);
    document.write('<br>');
    document.write('字符串y的值: ' + y);
    document.write('<br>');
    document.write('字符串z的值: ' + z);
    document.write('<br>');
    document.write('通过 localeCompare()判断 x和y是否相等 ' + x.localeCompare(y));
    document.write('<br>');
    document.write('通过 localeCompare()判断 x和z是否相等 ' + x.localeCompare(z));
    document.write('<br>');
    document.write('<input type="text" style="color: gray">' + '0 表示相等<br>');
    document.write('<input type="text" style="color: gray">' + '1 表示字母顺序靠后<br>');
    document.write('<input type="text" style="color: gray">' + '-1 表示字母顺序靠前' + '<hr/>');

    // 截取一段子串
    x = new String("Hello JavaScript");
    document.write('字符串x的值: ' + x);
    document.write('<br>');
    document.write('x.substring (0,3) 获取位0到3的字符串： ' + x.substring(0, 3));
    document.write('<br>');
    document.write('左闭右开，取得到0，取不到3' + '<hr/>');

    // 根据分隔符将字串转换为数组
    x = new String("Hello This Is JavaScript");
    document.write('字符串x的值: ' + x);
    document.write('<br>');
    y = x.split(" ");
    document.write('通过空格分隔split(" "),得到数组' + y);
    document.write("<br>");
    z = x.split(" ", 2);
    document.write('通过空格分隔split(" ",2),得到数组，并且只保留前两个' + z + '<hr/>');

    // 替换子串
    x = new String("Hello JavaScript");
    p1('这个是原字符串: ' + x);
    y = x.replace("a", "o");
    p1('只替换第一个 a:  ' + y);
    var regS = new RegExp("a", "g");
    z = x.replace(regS, "o");
    p1('替换掉所有的 a:  ' + z + '<hr/>');

    // 返回基本类型
    x = new String("Hello JavaScript");
    var temp = x.charAt(0);
    p1('charAt返回的值' + temp);
    p1('其类型是' + typeof temp);
    temp = x.concat("!!!");
    p1('concat返回的值' + temp);
    p1('其类型是' + typeof temp);
    temp = x.substring(0, 5);
    p1('substring返回的值' + temp);
    p1('其类型是' + typeof temp);
}


/* 对象-->Array */
function p(s, v) {
    document.write(s + ' ' + v);
    document.write("<br>");
}

function comparator(v1, v2) {   // 比较器函数
    return v2 - v1;
}

function js_test_array() {
    // 创建数组对象
    var x = new Array(); //创建长度是0的数组
    p('通过 new Array()创建一个空数组:', x);
    x = new Array(5); //创建长度是5的数组,，但是其每一个元素都是undefine
    p('通过 new Array(5)创建一个长度是5的数组:', x);
    p('像new Array(5) 这样没有赋初值的方式创建的数组，每个元素的值都是:', x[0]);
    x = new Array(3, 1, 4, 1, 5, 9, 2, 6); //根据参数创建数组
    p('创建有初值的数组new Array(3,1,4,1,5,9,2,6) :', x);
    document.write('<hr/>');

    // 数组长度
    x = new Array(3, 1, 4, 1, 5, 9, 2, 6); //根据参数创建数组
    p1('当前数组是:' + x);
    p1('通过.length获取当前数组的长度:' + x.length);
    document.write('<hr/>');

    // 遍历数组
    x = new Array(3, 1, 4);
    p1('当前数组是:' + x);
    p1("使用普通的for循环遍历数组");
    for (i = 0; i < x.length; i++) {  //普通for循环
        p1(x[i]);
    }
    p1("使用增强for循环遍历数组");
    for (i in x) {  //for in 循环
        p1(x[i]);
    }
    document.write('<hr/>');

    // 连接数组
    x = new Array(3, 1, 4);
    var y = new Array(1, 5, 9, 2, 6);
    p1('数组x是:' + x);
    p1('数组y是:' + y);
    var z = x.concat(y);
    p1('使用concat连接数组x和y');
    p1('数组z是:' + z);
    document.write('<hr/>');

    // 通过制定分隔符得到数组字串
    x = new Array(3, 1, 4);
    p1('数组x是:' + x);
    y = x.join();
    p1('y = x.join() 得到的是数组x的字符串表达，其值是' + y + " 其类型是 :" + (typeof y));
    z = x.join("@");
    p1('z = x.join("@");是x的字符串表达，不过分隔符不是默认的"," 而是"@" : ' + z);
    document.write('<hr/>');

    // 在数组末尾插入和获取元素
    x = new Array(3, 1, 4);
    p1('数组x是:' + x);
    x.push(5);
    p1('向x中push 5,得到 ' + x);
    var e = x.pop();
    p1('从x中pop一个值出来，其值是 ' + e);
    p1('pop之后，x数组的值是:' + x);
    document.write('<hr/>');

    // 在数组首位插入和获取元素
    x = new Array(3, 1, 4);
    p1('数组x是:' + x);
    x.unshift(5);
    p1('对数组 unshift 值5(在最前面加)，数组变为:' + x);
    e = x.shift();
    p1('从数组中 shift 一个数(从最前面取)，其值是:' + e);
    p1('shift之后，数组变为:' + x);
    document.write('<hr/>');

    // 排序
    x = new Array(3, 1, 4, 1, 5, 9, 2, 6);
    p1('数组x是:' + x);
    x.sort();
    p1('使用sort排序后的数组x是:' + x);
    document.write('<hr/>');

    // 自定义排序算法
    x = new Array(3, 1, 4, 1, 5, 9, 2, 6);
    p1('数组x是:' + x);
    x.sort(comparator);
    p1('使用sort 进行自定义倒排序后的数组x是:' + x);
    document.write('<hr/>');

    // 数组反转
    x = new Array(3, 1, 4, 1, 5, 9, 2, 6);
    p1('数组x是:' + x);
    x.reverse();
    p1('使用reverse()函数进行反转后的值是:' + x);
    document.write('<hr/>');

    // 获取子数组
    x = new Array(3, 1, 4, 1, 5, 9, 2, 6);
    p1('数组x是:' + x);
    var y = x.slice(1);
    p1('x.slice(1)获取的子数组是:' + y);
    var z = x.slice(1, 3);
    p1('x.slice(1,3)获取的子数组是:' + z);
    p1('第二个参数取不到');
    document.write('<hr/>');

    // 删除和插入元素
    x = new Array(3, 1, 4, 1, 5, 9, 2, 6);
    p1('数组x是:' + x);
    x.splice(3, 2);//从位置3开始 ，删除2个元素
    p1('x.splice (3,2) 表示从位置3开始 ，删除2个元素:' + x);
    x.splice(3, 0, 1, 5);
    p1('x.splice(3,0,1,5) 从位置3开始，删除0个元素，但是插入1和5,最后得到:' + x);
    document.write('<hr/>');
}


/* 对象-->Date */
function js_test_date() {
    // 创建日期对象
    var d = new Date();
    document.write('new Date():' + d + '<hr/>');

    // 年月日
    document.write('分别获取年月日: ');
    document.write(d.getFullYear());
    document.write("/");
    document.write(d.getMonth() + 1);
    document.write("/");
    document.write(d.getDate() + '<hr/>');

    // 时分秒毫秒
    document.write("分别获取时:分:秒:毫秒 ");
    document.write(d.getHours());
    document.write(":");
    document.write(d.getMinutes());
    document.write(":");
    document.write(d.getSeconds());
    document.write(":");
    document.write(d.getMilliseconds() + '<hr/>');

    // 一周的第几天
    var day = new Date().getDay(); //通过日期对象获取数字形式的星期几
    var weeks = new Array("星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
    document.write("今天是 ： " + weeks[day] + '<hr/>');

    // 经历的毫秒数
    var time = new Date().getTime();
    document.write("从1970/1/1 08:00:00 到今天的毫秒数： " + time + '<hr/>');

    // 修改日期和时间
    d = new Date();
    document.write("修改日期对象的值为世界末日:<br>");
    d.setFullYear(2012);
    d.setMonth(11); //月份时基0的，所以11表示12月
    d.setDate(12);
    d.setHours(0);
    d.setMinutes(0);
    d.setSeconds(0);
    document.write(d + '<hr/>');
}


/* 对象-->Math */
function js_test_math() {
    // 自然对数和圆周率
    document.write(Math.E);
    document.write("<br>");
    document.write(Math.PI + '<hr/>');

    // 绝对值
    document.write(Math.abs(-1) + '<hr/>');

    // 最值
    document.write(Math.min(1, 100));
    document.write("<br>");
    document.write(Math.max(1, 100) + '<hr/>');

    // 幂
    document.write(Math.pow(3, 3) + '<hr/>'); //3的立方，即27

    // 四舍五入
    document.write(Math.round(3.4));
    document.write("<br>");
    document.write(Math.round(3.5) + '<hr/>');

    // 随机数
    document.write("一个 0-1 之间的随机数 : Math.random():");
    document.write("<br>");
    document.write(Math.random());
    document.write("<br>");
    document.write("十个 5-10 之间的随机数 : Math.round(Math.random() *5)+5 ");
    document.write("<br>");
    for (i = 0; i < 10; i++) {
        document.write(Math.round(Math.random() * 5) + 5); //5-10之间的随机整数
        document.write("<br>");
    }
}


// PART_B BOM
/* Window */
function js_test_window() {
    // 获取文档显示区域的高度和宽度
    document.write("文档内容");
    document.write("文档显示区域的宽度" + window.innerWidth);
    document.write("<br>");
    document.write("文档显示区域的高度" + window.innerHeight + '<hr/>');

    // 获取外部窗体的宽度和高度
    document.write("浏览器的宽度:" + window.outerWidth);
    document.write("<br>");
    document.write("浏览器的高度:" + window.outerHeight);
}


/* Navigator */
function js_test_navigator() {
    document.write("<p>浏览器产品名称：");
    document.write(navigator.appName + "</p>");
    document.write("<p>浏览器版本号：");
    document.write(navigator.appVersion + "</p>");
    document.write("<p>浏览器内部代码：");
    document.write(navigator.appCodeName + "</p>");
    document.write("<p>操作系统：");
    document.write(navigator.platform + "</p>");
    document.write("<p>是否启用Cookies：");
    document.write(navigator.cookieEnabled + "</p>");
    document.write("<p>浏览器的用户代理报头：");
    document.write(navigator.userAgent + "</p>");
}


/* Screen */
function js_test_screen() {
    document.write("用户的屏幕分辨率: ")
    document.write(screen.width + "*" + screen.height)
    document.write("<br />")
    document.write("可用区域大小: ")
    document.write(screen.availWidth + "*" + screen.availHeight)
    document.write("<br />")
}


/* 计时器 */
function printTime() {
    var d = new Date();
    var h = d.getHours();
    var m = d.getMinutes();
    var s = d.getSeconds();
    alert(h + ":" + m + ":" + s);

}

function js_test_timer() {
    setTimeout(printTime, 3000);
}


// DOM
/* 节点概念 */
function js_test_node_concept() {
    var d1 = document.getElementById("d1");
    p1('文档节点' + document);
    p1('元素' + d1);
    p1('属性节点' + d1.attributes[0]);
    p1('内容节点' + d1.childNodes[0]);
}


/* 获取节点 */
function js_test_node_get() {
    //
    document.write('<hr/>' + '通过标签名称获取元素节点<br/>');
    var divs = document.getElementsByTagName('div');
    for (var i = 0; i < divs.length; i++) {
        document.write(divs[i]);
        document.write('<br/>');
    }
    //
    document.write('<hr/>' + '通过类名获取元素节点<br/>');
    var clz1s = document.getElementsByClassName('clz1');
    for (var i = 0; i < clz1s.length; i++) {
        document.write(clz1s[i]);
        document.write('<br/>');
    }
    //
    document.write('<hr/>' + '通过表单元素的name获取元素节点<br/>');
    var names = document.getElementsByName('username');
    for (var i = 0; i < names.length; i++) {
        document.write(names[i]);
        document.write('<br/>');
    }
    document.write('<hr/>' + '获取属性节点<br/>');
    var d3 = document.getElementById('d3')
    var attrs = d3.attributes;
    //
    document.write("div(d3)总共有" + attrs.length + " 个属性，");
    document.write("分别是:");
    for (i = 0; i < attrs.length; i++) {
        document.write("<br>");
        document.write(attrs[i].nodeName);
        document.write(":");
        document.write(attrs[i].nodeValue);
    }
    document.write("<br>");
    document.write("div的id属性值是：" + attrs["id"].nodeValue);
    //
    document.write('<hr/>' + '获取内容节点<br/>');
    var content = d3.childNodes[0];
    document.write("div的内容节点名是:" + content.nodeName);
    document.write("<br>");
    document.write("div的内容节点值是:" + content.nodeValue);
}