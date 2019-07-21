<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<html lang="en">
<head>

    <title>dindertor页面</title>
    <script charset="utf-8" src="kindeditor/kindeditor-all.js"></script>
    <script charset="utf-8" src="kindeditor/lang/zh-CN.js"></script>

    <script>
        KindEditor.ready(function(K) {
            window.editor = K.create('#editor_id',{
                width : "700px",
                uploadJson : "${pageContext.request.contextPath}/article/upload",
                filePostName:"articleImage",
                fileManagerJson:"${pageContext.request.contextPath}/article/browse",
                allowFileManager:true
            });
        });
    </script>
</head>
<body>
    <textarea id="editor_id" name="content" style="width:700px;height:300px;">
        &lt;strong&gt;HTML内容&lt;/strong&gt;
    </textarea>

</body>
</html>