<%@ page pageEncoding="utf-8" %>
<script type="text/javascript">
    //页面加载后，定义初始化按钮
    $(function () {
        //初始化表单控件---title
        $("#title").textbox({
            required: true,
            validType: "length[0,10]"
        });
        //初始化表单控件---status
        $("#status").textbox({
            required: true,
            validType: "length[0,10]"
        });
        //初始化表单控件---pubDate
        $("#pubDate").datebox({
            required: true
        });
        //初始化表单控件---description
        $("#description").textbox({
            required: true,
            validType: "length[0,30]"
        });
        //初始化表单控件---保存按钮
        $("#addFormSaveBtn").linkbutton({
            onClick: function () {
                // 提交表单 -- 调form的submit方法
                $("#addForm").form({
                    url: "${pageContext.request.contextPath}/banner/insert",
                    onSubmit: function () {
                        // 表单验证 -- 调form的validate方法
                        return $("#addForm").form("validate");
                    },
                    success: function () {
                        console.log("添加成功");
                        $.messager.show({
                            title: "系统提示",
                            msg: "添加成功！"
                        });
                        //点击添加按钮， 关闭添加对话框
                        $("#addDialog").dialog("close");
                        // 刷新datagrid中的数据 -- 调load方法
                        $("#dg").datagrid("reload");
                    },
                });
                $("#addForm").submit();
            }
        });
        //初始化重置按钮
        $("#reset").linkbutton({
            onClick: function () {
                $("#addForm").form("clear");
            }
        });
    });
</script>
<form id="addForm" method="post" enctype="multipart/form-data">
    名称：<input name="title" id="title"/><br/>
    图片：<input name="file1" id="imgPath" type="file"/><br/>
    状态：<input name="status" id="status"/><br/>
    发布日期：<input name="pubDate" id="pubDate"/><br/>
    描述：<input name="description" id="description"/><br/>
    <a id="addFormSaveBtn">添加</a>
    <a id="reset">重置</a>
</form>
