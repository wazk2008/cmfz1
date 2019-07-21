<%@page isELIgnored="false" pageEncoding="UTF-8" %>

<script>
    $(function(){
        $("#banner-table").jqGrid({
            url:"${pageContext.request.contextPath}/banner/selectAllBanner",
            datatype:"json",
            colNames : [ '编号', '名称', '图片', '描述', '状态','上传日期'],
            colModel : [
                {name : 'id',hidden:true},
                {name : 'name',editable:true},
                {name : 'file',editable:true,edittype:"file",formatter:function (value,options,row) {
                        return "<img style='width:100px;height:80px' src='${pageContext.request.contextPath}/other/banner/img/"+row.file+"'/>";
                    }},
                {name : 'description',editable:true},
                {name : 'status',editable:true,edittype:"select",editoptions:{value:"展示:展示;冻结:冻结"}},
                {name : 'createDate',editable:false}
            ],
            autowidth:true,
            rowNum : 3,
            height:"300px",
            rowList : [ 3, 5, 10 ],
            pager : '#banner-pager',
            viewrecords : true,
            caption : "所有轮播图信息",
            editurl : "${pageContext.request.contextPath}/banner/edit",
            styleUI:"Bootstrap"
        }).navGrid("#banner-pager",{edit:true,add:true,del:true,search:false},
            {
                closeAfterEdit:true,
                beforeShowForm:function (frm) {
                    frm.find("#file").attr("disabled",true);
                }
            },{
                closeAfterAdd:true,
                afterSubmit:function (response) {
                    var status = response.responseJSON.status;
                    var id = response.responseJSON.message;
                    if(status){
                        //添加成功，进行文件的上传
                        $.ajaxFileUpload({
                            url:"${pageContext.request.contextPath}/banner/upload",
                            type:"post",
                            fileElementId:"file",
                            data:{id:id},
                            success:function () {
                                $("#banner-table").trigger("reloadGrid");
                            }
                        });
                    }
                    return "123";
                }
            })
    })
</script>


<div class="page-header">
    <h2>展示所有轮播图</h2>
</div>
<table class="table table-striped" id="banner-table"></table>
<div id="banner-pager" style="height: 40px"></div>