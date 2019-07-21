<%@page isELIgnored="false" pageEncoding="UTF-8" %>

<script>
    $("#banner-table").jqGrid({
        url : "${pageContext.request.contextPath}/banner/selectAllBanner",
        datatype : "json",
        styleUI:"Bootstrap",
        autowidth:true,
        colNames : [ '编号', '名称', '图片', '描述', '状态','创建日期' ],
        colModel : [
            {name : 'id',hidden:true},
            {name : 'name',editable:true},
            {name : 'file',editable:true,edittype:"file",formatter:function (value,options,row) {
                    return "<img style='width:100px;height:80px' src='${pageContext.request.contextPath}/other/banner/img/"+row.file+"'/>";
                }},
            {name : 'description',editable:true},
            {name : 'status',editable:true,edittype:"select",editoptions:{value:"展示:展示;冻结:冻结"}},
            {name : 'createDate'}
        ],
        height:"300px",
        rowNum : 3,
        rowList : [ 3, 5, 10 ],
        pager : '#banner-pager',
        viewrecords : true,
        caption : "轮播图的详细信息",
        editurl : "${pageContext.request.contextPath}/banner/edit"
    }).navGrid("#banner-pager", {edit : true,add : true,del : true,search : false},{
        //修改
        closeAfterEdit:true,
        beforeShowForm:function (frm) {
           frm.find("#file").attr("disabled",true);
        }

    },{
        //添加
        closeAfterAdd:true,
        afterSubmit:function (response) {
            var status = response.responseJSON.status;
            var id = response.responseJSON.message;
            if(status){
                $.ajaxFileUpload({
                    url:"${pageContext.request.contextPath}/banner/upload",
                    type:"post",
                    fileElementId:"file",
                    data:{id:id},
                    success:function () {
                        //刷新jqgrid
                        $("#banner-table").trigger("reloadGrid");
                    }
                })
            }
            return "123";
        }
    });


</script>


<div class="page-header">
    <h2>展示所有的轮播图</h2>
</div>
<table id="banner-table"></table>
<div id="banner-pager" style="height: 40px"></div>