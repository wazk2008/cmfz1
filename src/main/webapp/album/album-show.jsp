<%@page pageEncoding="UTF-8" isELIgnored="false" %>

<script>
    $("#album-table").jqGrid({
        url : "${pageContext.request.contextPath}/album/selectAllAlbum",
        datatype : "json",
        height : 190,
        colNames : [ '编号', '名称', '封面', "集数", "评分",'作者', '播音员','简介', '创建日期' ],
        colModel : [
            {name : 'id',hidden:true},
            {name : 'title'},
            {name : 'cover'},
            {name : 'count',width:"50px"},
            {name : 'score',width:"50px"},
            {name : 'author'},
            {name : 'broadcast'},
            {name : 'brief'},
            {name : 'createDate'}
        ],
        styleUI:"Bootstrap",
        autowidth:true,
        rowNum : 8,
        rowList : [ 8, 10, 20, 30 ],
        pager : '#album-pager',
        viewrecords : true,
        multiselect : false,
        subGrid : true,
        caption : "专辑详情",
        subGridRowExpanded : function(subgrid_id, albumId) {//子表容器id     关系id
            var subgrid_table_id = subgrid_id + "_t";
            var pager_id = "p_" + subgrid_table_id;
            $("#" + subgrid_id).html(
                "<table id='" + subgrid_table_id + "' class='scroll'></table>" +
                "<div id='" + pager_id + "' class='scroll'></div>");
            $("#" + subgrid_table_id).jqGrid(
                {
                    url : "${pageContext.request.contextPath}/chapter/selectChaptersByAlbumId?albumId="+albumId,
                    datatype : "json",
                    colNames : [ '编号', '名字', '大小', '时长','创建日期',"在线播放" ],
                    colModel : [
                        {name : "id"},
                        {name : "title"},
                        {name : "size"},
                        {name : "duration"},
                        {name : "createDate"},
                        {name : "aa"}
                    ],
                    rowNum : 3,
                    rowList : [ 3, 5, 10 ],
                    pager : pager_id,
                    sortname : 'num',
                    sortorder : "asc",
                    height : '100%',
                    autowidth:true,
                    styleUI:"Bootstrap"
                }).jqGrid("navGrid","#"+pager_id,{add:true,del:false,edit:false,search:false},{},{});
        }
    }).jqGrid('navGrid', '#album-pager', {
        add : true,
        edit : false,
        del : false,
        search:false
    },{},{
        //添加
    });
</script>



<div class="page-header">
    <h2>所有专辑展示</h2>
</div>
<table id="album-table"></table>
<div id="album-pager" style="height: 40px;"></div>