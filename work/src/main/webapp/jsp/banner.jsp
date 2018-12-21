<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {
        var toolbar = [{
            iconCls: 'icon-add',
            text: "添加",
            handler: function () {
                $("#addDialog").dialog("open");
            }
        }, '-', {
            text: "修改",
            iconCls: 'icon-edit',
            handler: function () {
                //获取选中行
                var row = $("#dg").edatagrid("getSelected");
                if (row != null) {
                    //编辑指定行
                    var index = $("#dg").edatagrid("getRowIndex", row);
                    $("#dg").edatagrid("editRow", index);
                } else {
                    alert("请先选中行")
                }
            }
        }, '-', {
            text: "删除",
            iconCls: 'icon-remove',
            handler: function () {
                //获取选中行
                var row = $("#dg").edatagrid("getSelected");
                if (row != null) {
                    $.messager.confirm('确认对话框', '您确认删除吗？', function (r) {
                        if (r) {
                            $.post("${pageContext.request.contextPath}/banner/delete", {id: row.id}, function (res) {
                                $.messager.show({
                                    title: '提示窗口',
                                    msg: '删除成功。',
                                    timeout: 5000,
                                    showType: 'slide'
                                });
                                $("#dg").datagrid("reload");
                            })
                        }
                    });
                } else {
                    alert("请先选中行")
                }
            }
        }, '-', {
            text: "保存",
            iconCls: 'icon-save',
            handler: function () {
                $("#dg").edatagrid("saveRow")

            }
        }]

        $('#dg').edatagrid({
            // method: "GET",
            updateUrl: "${pageContext.request.contextPath}/banner/update",
            url: '${pageContext.request.contextPath}/banner/queryByPage',
            columns: [[
                {field: 'id', title: 'Id', width: 100},
                {field: 'title', title: '名称', width: 100},
                {field: 'imgPath', title: '路径', width: 100, align: 'right'},
                {
                    field: 'status', title: '状态', width: 100, formatter: aaa, editor: {
                        type: "text",
                        options: {required: true}
                    }
                },
                {field: 'pubDate', title: '时间', width: 100},
                {field: 'description', title: '描述', width: 100, align: 'right'}
            ]],
            fitColumns: true,
            fit: true,
            pagination: true,
            pageList: [1, 3, 5, 7, 9],
            pageSize: 3,
            toolbar: toolbar,
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.imgPath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>描述: ' + rowData.description + '</p>' +
                    '<p>日期: ' + rowData.pubDate + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }

        });
        //初始化添加对话框按钮
        $("#addDialog").dialog({
            title: "添加页面",
            width: 300,
            height: 300,
            closed: true,
            cache: false,
            href: "${pageContext.request.contextPath}/jsp/addBanner.jsp",
            collapsible: true,
            minimizable: true,
            maximizable: true,
            resizable: true
        });
    })

    function aaa(value, row, index) {
        if (value == "y") {
            return "图片展示";
        } else {
            return "无";
        }
    }
</script>
<!--定义添加对话框-->
<div id="addDialog"></div>
<!--定义轮播图表格-->
<table id="dg"></table>