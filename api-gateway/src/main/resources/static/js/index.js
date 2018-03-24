layui.use(['table','form'], function(){
    var form = layui.form;
    form.on('switch(switchEnabled)',function(){
        vm.gateway.enabled = !vm.gateway.enabled;
    });
    form.on('switch(switchRetryable)',function(){
        vm.gateway.retryable = !vm.gateway.retryable;
    });
    form.on('switch(switchStripPrefix)',function(){
        vm.gateway.stripPrefix = !vm.gateway.stripPrefix;
    });

    //监听工具条
    var table = layui.table;
    table.on('tool(routeFilter)', function(obj){
        if(obj.event === 'detail'){
            vm.detail(obj.data);
        } else if(obj.event === 'del'){
            layer.confirm('确定删除此路由规则？', function(index){
                $.ajax({
                    type: "DELETE",
                    url:"/gateway/routes?id="+obj.data.id,
                    contentType: "application/json",
                    success: function(r){
                        if(r.code == 0){
                            layer.close(index);
                            //刷新当前页
                            $(".layui-laypage-btn")[0].click();
                            layer.msg("操作成功");

                        }else{
                            layer.msg(r.msg);
                        }
                    }
                });

            });
        } else if(obj.event === 'edit'){
            vm.update(obj.data);
        }
    });
    form.on('switch(enableRoute)', function(data){
        var id = $(data.elem).attr('name');
        var enabled = data.elem.checked;//开关是否开启，true或者false
        $.ajax({
            type: "PUT",
            url: '/gateway/routes/status?id='+id+"&isEnabled="+enabled,
            contentType: "application/json",
            success: function(result){
                if(result.code === 0){
                    layer.msg('操作成功');
                    vm.reload();
                }else{
                    layer.alert(result.msg);
                }
            }
        });
    });

    table.render({
        elem: '#routeTable'
        ,url:'/gateway/routes'
        ,id:'routeTableId'
        ,method:"GET"
        ,request: {
            pageName: 'pageNum' //页码的参数名称，默认：page
            ,limitName: 'pageSize' //每页数据量的参数名，默认：limit
        }
        ,response: {
            statusName: 'code' //数据状态的字段名称，默认：code
            ,statusCode: 0 //成功的状态码，默认：0
            ,msgName: 'msg' //状态信息的字段名称，默认：msg
            ,countName: 'total' //数据总数的字段名称，默认：count
            ,dataName: 'data' //数据列表的字段名称，默认：data
        }
        ,skin: 'line' //行边框风格
        ,even: true //开启隔行背景
        ,page: {
            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']
            ,groups: 1
            ,first: false
            ,last: false
        }
        ,cellMinWidth: 120 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        ,cols: [[
            /* {type:'checkbox', fixed: 'left'}
             ,*/{field:'id', width:120, title: 'ID', sort: true,fixed: 'left'}
            ,{field:'path', width:240, title: '路径'}
            ,{field:'serviceId', width:240, title: '服务ID', sort: true}
            ,{field:'url', width:300, title: 'URL'}
            ,{field:'apiName',width:120, title: 'api名称'}
            ,{field:'stripPrefix',width:120, title: '忽略前缀', sort: true}
            ,{field:'retryable', width:120, title: '是否重试'} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
            ,{field:'enabled',width:120, title: '是否开启', sort: true, templet: '#checkboxTpl', unresize: true}
            ,{fixed: 'right', minWidth:160,align:'left',title: '操作', toolbar: '#barTool'}
        ]]
    });

});

var vm = new Vue({
    el:'#app',
    data:{
        showList: true,
        title:null,
        gateway:{}
    },
    methods: {
        add: function(){
            vm.showList = false;
            vm.title = '新增';
        },
        detail: function (row) {
            if(row == null){
                return ;
            }
            vm.showList = false;
            vm.title = "查看";
            vm.gateway = row;
        },
        update: function (row) {
            if(row == null){
                return ;
            }
            vm.showList = false;
            vm.title = "编辑";
            vm.gateway = row;
        },
        saveOrUpdate: function () {
            var method = vm.title == "新增" ? 'POST' : 'PUT';
            layui.$.ajax({
                type: method,
                url: '/gateway/routes',
                contentType: "application/json",
                data: JSON.stringify(vm.gateway),
                success: function(result){
                    if(result.code === 0){
                        layer.msg('操作成功');
                        vm.reload();
                    }else{
                        layer.alert(result.msg);
                    }
                }
            });
        },
        reload: function () {
            vm.showList = true;
            var routeReload = layui.$('#routeReload');
            //执行重载
            layui.table.reload('routeTableId', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {
                    keyword: routeReload.val()
                }
            });
            vm.gateway = {};
        },
        publish: function(){
            layui.$.ajax({
                type: "POST",
                url: '/gateway/routes/refresh',
                contentType: "application/json",
                data: JSON.stringify(vm.gateway),
                success: function(result){
                    if(result.code === 0){
                        layer.msg('发布成功');
                        vm.reload();
                    }else{
                        layer.msg('发布失败');
                    }
                }
            });
        }
    },
    updated: function () { layui.form.render()}
});