<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    var id = "";
    var toolbar = [{
        iconCls: 'icon-add',
        text: "专辑详情",
        handler: function () {
            //获取选中行
            var row = $("#album").edatagrid("getSelected");
            if (row != null) {
                id = row.id;
                $("#album1Dialog").dialog("open");


            } else {
                alert("请先选中行")
            }
        }
    }, '-', {
        text: "添加专辑",
        iconCls: 'icon-edit',
        handler: function () {
            $("#addDialog").dialog("open");
        }
    }, '-', {
        text: "添加音频",
        iconCls: 'icon-remove',
        handler: function () {
            alert('帮助按钮')
        }
    }, '-', {
        text: "音频下载",
        iconCls: 'icon-save',
        handler: function () {
            $("#dg").edatagrid("saveRow")

        }
    }]
    $(function () {
        $('#album').treegrid({
            url: '${pageContext.request.contextPath}/album/queryAll',
            idField: 'id',
            treeField: 'title',
            columns: [[
                {field: 'title', title: '名字', width: 60},
                {field: 'size', title: '大小', width: 80},
                {field: 'duration', title: '时长', width: 80},
                {field: 'url', title: '路径', width: 80},
                {field: 'uploadDate', title: '上传时间', width: 80}
            ]],
            fit: true,
            fitColumns: true,
            toolbar: toolbar,
        });
        //初始化添加对话框按钮
        $("#addDialog").dialog({
            title: "添加页面",
            width: 300,
            height: 300,
            closed: true,
            cache: false,
            href: "${pageContext.request.contextPath}/jsp/addAlbum.jsp",
            collapsible: true,
            minimizable: true,
            maximizable: true,
            resizable: true
        });
        //初始化专辑详情框按钮
        $("#album1Dialog").dialog({
            title: "显示专辑详情页面",
            width: 300,
            height: 300,
            closed: true,
            cache: false,
            href: "${pageContext.request.contextPath}/jsp/album1.jsp",
            collapsible: true,
            minimizable: true,
            maximizable: true,
            resizable: true
        });

    })

</script>
<!--定义专辑详情对话框-->
<div id="album1Dialog"></div>
<!--定义添加专辑对话框-->
<div id="addDialog"></div>
<table id="album"></table>