<%@page isELIgnored="false" pageEncoding="UTF-8" %>

<script>

    $("#article-table").jqGrid({
        url : "${pageContext.request.contextPath}/article/selectAllArticle",
        datatype : "json",
        styleUI:"Bootstrap",
        autowidth:true,
        colNames : [ '编号', '标题', '作者', '内容','创建日期',"操作" ],
        colModel : [
            {name : 'id',hidden:true},
            {name : 'title',editable:true},
            {name : 'author',editable:true},
            {name : 'content',editable:true,formatter:function(value,options,row){
                console.log(row.content.split("，")[0]);
                return row.content.split("，")[0];
                }},
            {name : 'createDate'},
            {name : 'aa',formatter:function (value,options,row) {
                    return "<a class='btn btn-warning' onclick=\"openModal('edit','"+row.id+"')\">修改</a>";
                }}
        ],
        height:"300px",
        rowNum : 3,
        rowList : [ 3, 5, 10 ],
        pager : '#article-pager',
        viewrecords : true,
        editurl : "${pageContext.request.contextPath}/article/edit"
    }).navGrid("#article-pager", {edit : false,add : false,del : true,search : false});


    //打开modal的方法
    function openModal(oper,id) {
        KindEditor.html("#editor_id","");
        // 拿到jqgrid中当前行中的数据
        var article = $("#article-table").jqGrid("getRowData",id);
        // 开始给表单设置默认值
        $("#article-id").val(article.id);
        $("#article-title").val(article.title);
        $("#article-author").val(article.author);
        KindEditor.html("#editor_id",article.content);
        $("#article-oper").val(oper);

        //打开modal
        $("#article-modal").modal("show");
    }


    KindEditor.create('#editor_id',{
        width : "700px",
        uploadJson : "${pageContext.request.contextPath}/article/upload",
        filePostName:"articleImage",
        fileManagerJson:"${pageContext.request.contextPath}/article/browse",
        allowFileManager:true,
        resizeType:1,
        afterBlur:function () {
            this.sync();
        }
    });
    
    function dealSave() {
        $.ajax({
            url:"${pageContext.request.contextPath}/article/edit",
            type:"post",
            datatype:"json",
            data:$("#article-from").serialize(),
            success:function (data) {
            //    关闭模态框
                $("#article-modal").modal("hide");
            //    刷新jqgrid
                $("#article-table").trigger("reloadGrid");

            }
        })
    }

</script>








<ul class="nav nav-pills">
    <li role="presentation" class="active"><a href="#">所有文章</a></li>
    <li role="presentation"><a href="javascript:;" onclick="openModal('add','')">添加文章</a></li>
</ul>
<table id="article-table"></table>
<div id="article-pager" style="height: 40px;"></div>


<%--模态框--%>
<div id="article-modal" class="modal fade" tabindex="-1" role="dialog" >
    <div class="modal-dialog" role="document">
        <div class="modal-content" style="width: 702px;">
            <%--头--%>
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title text-center">我的文章</h4>
            </div>
            <%--内容--%>
            <div class="modal-body">


                <form class="form-horizontal" id="article-from">
                    <input type="hidden" id="article-id" name="id">
                    <input type="hidden" id="article-oper" name="oper">
                    <div class="form-group">
                        <label for="article-title" class="col-sm-2 control-label">文章标题</label>
                        <div class="col-sm-10">
                            <input type="email" name="title" class="form-control" id="article-title" placeholder="文章标题">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="article-author" class="col-sm-2 control-label">文章作者</label>
                        <div class="col-sm-10">
                            <input type="text" name="author" class="form-control" id="article-author" placeholder="文章作者">
                        </div>
                    </div>
                    <div class="form-group">
                        <textarea name="content" id="editor_id" style="width: 700px;height: 300px;"></textarea>
                    </div>
                </form>


            </div>
            <%--脚--%>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="dealSave()">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->



