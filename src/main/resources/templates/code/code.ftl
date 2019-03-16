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

<p><input type="checkbox" name="killold" id="killold"/>删除旧文件 </p>
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
</script>