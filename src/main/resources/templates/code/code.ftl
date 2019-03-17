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

<p><input type="checkbox" name="killold" id="killold"/>删除旧文件  <input type="button" value="Json处理" id="jsonManage"></p>

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
        if (!txt)return;
        var arr = txt.split("\n");
        let tmpStr ="";
        for (let item of arr){
            item  = item.replace("- ","");
            let index = item.indexOf("//");
            if (index != -1){
                item = item.substring(0,index);
            }
            tmpStr += item + "\n";
        }
        copyToClipboard(tmpStr);
        console.log(tmpStr)
    })

    function copyToClipboard(txt) {
        if (window.clipboardData) {
            window.clipboardData.clearData();
            clipboardData.setData("Text", txt);
            alert("复制成功！");

        } else if (navigator.userAgent.indexOf("Opera") != -1) {
            window.location = txt;
        } else if (window.netscape) {
            try {
                netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
            } catch (e) {
                alert("被浏览器拒绝！\n请在浏览器地址栏输入'about:config'并回车\n然后将 'signed.applets.codebase_principal_support'设置为'true'");
            }
            var clip = Components.classes['@mozilla.org/widget/clipboard;1'].createInstance(Components.interfaces.nsIClipboard);
            if (!clip)
                return;
            var trans = Components.classes['@mozilla.org/widget/transferable;1'].createInstance(Components.interfaces.nsITransferable);
            if (!trans)
                return;
            trans.addDataFlavor("text/unicode");
            var str = new Object();
            var len = new Object();
            var str = Components.classes["@mozilla.org/supports-string;1"].createInstance(Components.interfaces.nsISupportsString);
            var copytext = txt;
            str.data = copytext;
            trans.setTransferData("text/unicode", str, copytext.length * 2);
            var clipid = Components.interfaces.nsIClipboard;
            if (!clip)
                return false;
            clip.setData(trans, null, clipid.kGlobalClipboard);
            alert("复制成功！");
        }
    }
</script>