<%@ page pageEncoding="utf-8" %>
<script type="text/javascript">
    //页面加载后，定义初始化按钮
    $(function () {
        //初始化表单控件---title
        $("#title").textbox({
            required: true,
            validType: "length[0,10]"
        });
        //初始化表单控件---count
        $("#count").textbox({
            required: true,
            validType: "length[0,10]"
        });
        //初始化表单控件---author
        $("#author").textbox({
            required: true,
            validType: "length[0,10]"
        });	//初始化表单控件---broadcast
        $("#broadcast").textbox({
            required: true,
            validType: "length[0,10]"
        });
        //初始化表单控件---brief
        $("#brief").textbox({
            required: true,
            validType: "length[0,30]"
        });
        //初始化表单控件---pubDate
        $("#pubDate").datebox({
            required: true
        });
        //初始化表单控件---保存按钮
        $("#addFormSaveBtn").linkbutton({
            onClick: function () {
                // 提交表单 -- 调form的submit方法
                $("#addForm").form({
                    url: "${pageContext.request.contextPath}/album/insert",
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
    专辑名称：<input type="text" name="title" id="title"/><br/>
    章节数量：<input type="text" name="count" id="count"/><br/>
    专辑图片：<input type="file" name="file" id="imgPath"><br/>
    专辑作者：<input type="text" name="author" id="author"/><br/>
    播音员： <input type="text" name="broadcast" id="broadcast"/><br/>
    内容简介：<input type="text" name="brief" id="brief"/><br/>
    发布日期：<input name="pubDate" id="pubDate"/><br/>
    <a id="addFormSaveBtn">添加</a>
    <a id="reset">重置</a>
</form>
