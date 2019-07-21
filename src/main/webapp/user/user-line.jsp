<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<div id="main" style="width: 600px;height:400px;"></div>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '商品销量情况'
        },
        tooltip: {trigger:'axis'},
        legend: {
            data:["销量"]
        },
        xAxis: {
            data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
        },
        yAxis: {}
        // series: [{
        //     name: '销量',
        //     type: 'bar',
        //     data: [3, 22, 15, 40, 30, 45]
        // }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

    $.ajax({
        url:"${pageContext.request.contextPath}/user/user-line.json",
        datatype:"json",
        type:"get",
        success:function (aa) {
            myChart.setOption({
                series: [{
                    name: '销量',
                    type: 'line',
                    data: aa.count
                }],
                xAxis: {
                    data: aa.name
                }
            });
        }

    })


</script>



