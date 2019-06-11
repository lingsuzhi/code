<#assign ctx=request.getContextPath()>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<style>
    li {
        margin-bottom: 20px;
    }

</style>
<body>

<p><input type="checkbox" name="killold" id="killold"/>删除旧文件
    <input type="button" value="Json处理" id="jsonManage">&nbsp;<input type="button" value="sql转Java" id="sqlToJava"></p>

<div>
    <div style="float:left"
    <ul id="list">
        ${(code.fileList)!}

    </ul>
</div>
<div style="float: left;margin-left: 10px">
    <textarea style="width: 800px;height: 600px;" id="sqlTxt"></textarea>
</div>
</div>
</body>
</html>

<script>

    $("#list li").click(function () {
        var fileName = $(this).text();
        if (fileName) {

            $.get("./fileDo", {fileName: fileName, killold: $('#killold').prop('checked')}, function (map) {
                if (map) {
                    $("#sqlTxt").html(map.sql);

                }

            });
        }
    });

    $("#jsonManage").click(function () {
        var txt = $("#sqlTxt").val();
        if (!txt) return;
        let arr = txt.split("\n");
        let tmpStr = "";
        for (let item of arr) {
            item = item.replace("- ", "");
            let index = item.indexOf("//");
            if (index != -1) {
                item = item.substring(0, index);
            }
            tmpStr += item + "\n";
        }
        copyToClipboard(tmpStr);
        console.log(tmpStr)
    })
    $("#sqlToJava").click(function () {
        var txt = $("#sqlTxt").val();
        if (!txt) return;
        let arr = txt.split("\n");


        let cls = {
            attr: []
        };
        for (let item of arr) {
            if (item.startsWith("CREATE TABLE")) {
                cls.name = findKuohao(item, "`");
                if (cls.name.startsWith("t_")) {
                    cls.name = cls.name.substring(2)
                }
            }
            if (item.startsWith("COMMENT")) {
                cls.rem = findKuohao(item, "'").replace("表", "");
            }
            if (item.trim().startsWith("`")) {
                let attr = {}
                attr.name = javaName(findKuohao(item, "`"));
                attr.rem = findKuohaoLast(item, "'")
                if (item.includes("BIGINT")) {
                    attr.type = "Long";
                } else if (item.includes("INT")) {
                    attr.type = "Integer";
                } else if (item.includes("DECIMAL")) {
                    attr.type = "BigDecimal";
                } else if (item.includes("DATETIME") || item.includes("DATE")) {
                    attr.type = "Date";
                } else {
                    attr.type = "String"
                }
                cls.attr.push(attr);
            }

        }
        let strArr = [];
        strArr.push("import java.util.Date;")
        strArr.push("");
        if (cls.rem) {
            strArr.push("/**");
            strArr.push(" * " + cls.rem);
            strArr.push(" */");
        }
        strArr.push("public class " + cName(cls.name) + " {");
        strArr.push("");
        let i = 0;
        for (let attr of cls.attr) {
            i++;
            if (!attr.rem) {
                arr.rem = "";
            }
            arr.rem = "    //" + attr.rem;
            if (attr.name != "createTime" && attr.name != "createId" && attr.name != "updateId" && attr.name != "updateTime"
                && attr.name != "updateUser" && attr.name != "createUser" && attr.name != "isDelete") {
                if ( cls.attr.length > 10 && i > 1 && i < cls.attr.length - 9){
                    arr.rem += " <param>"

                }
            }
            strArr.push(arr.rem)
            strArr.push("    private " + attr.type + " " + attr.name + ";");
        }
        strArr.push("}");

        let tmp = strArr.join("\n");
        copyToClipboard(tmp);
        console.log(tmp)


        $.ajax({
            url:"./sql2Java",    //请求的url地址
            contentType: "application/json",
            data:JSON.stringify({fileName: cName(cls.name) + ".java", javaCode:tmp}),    //参数值
            type:"POST",   //请求方式
            beforeSend:function(){
                //请求前的处理
            },
            success:function(req){
                //请求成功时处理
            },
            complete:function(){
                //请求完成的处理
            },
            error:function(){
                //请求出错处理
            }
        });
    });

    function javaName(name) {
        let tmpB = false;
        let result = ""
        for (let i = 0; i < name.length; i++) {
            let tmpStr = name.substring(i, i + 1);
            if (tmpStr == "_") {
                tmpB = true;
                continue
            }
            if (tmpB) {
                tmpStr = tmpStr.toLocaleUpperCase();
                tmpB = false;
            }
            result += tmpStr;
        }
        return result;

    }

    function oneToUpperCase(name) {
        if (name) {
            let tmpStr = name.substring(0, 1);
            return tmpStr.toLocaleUpperCase() + name.substring(1);
        }
    }

    function cName(name) {
        return oneToUpperCase(javaName(name));
    }

    function findKuohao(txt, kuohao, kuohao2) {
        if (!kuohao2) {
            kuohao2 = kuohao;
        }
        let index = txt.indexOf(kuohao);
        if (index == -1) {
            return "";
        }
        let index2 = txt.indexOf(kuohao2, index + 1);
        if (index2 == -1) {
            return "";
        }
        return txt.substring(index + 1, index2);
    }

    function findKuohaoLast(txt, kuohao, kuohao2) {

        if (!kuohao2) {
            kuohao2 = kuohao;
        }
        let index = txt.lastIndexOf(kuohao);
        if (index == -1) {
            return "";
        }
        let index2 = txt.lastIndexOf(kuohao2, index - 1);
        if (index2 == -1) {
            return "";
        }
        return txt.substring(index2 + 1, index);
    }

    function copyToClipboard(Url2) {
        var oInput = document.createElement('textarea');
        oInput.value = Url2;
        document.body.appendChild(oInput);
        oInput.select(); // 选择对象
        document.execCommand("Copy"); // 执行浏览器复制命令
        oInput.className = 'oInput';
        oInput.style.display = 'none';
    }
</script>