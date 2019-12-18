var isAdd=false;
var trObj;

function onclickAdd(){
    isAdd = true;
    $("#inputWindow").css("display", "block");
    $("#textTitle").val("");
    $("#textAbstract").val("");
    $("#textAuthor").val("");
    $("#selectType").val("");
}

var count = 0;
function onclickSave(){
    var title = $("#textTitle").val();
    var abstract = $("#textAbstract").val();
    var author = $("#textAuthor").val();
    var type = $("#selectType").val();
    if (isAdd == true) {
        var newTr = document.createElement("tr");
        var newTd = document.createElement("td");
        newTd.innerHTML = ++count;
        newTr.appendChild(newTd);
        newTd = document.createElement("td");
        newTd.innerHTML = title;
        newTr.appendChild(newTd);
        newTd = document.createElement("td");
        newTd.innerHTML = abstract;
        newTr.appendChild(newTd);
        newTd = document.createElement("td");
        newTd.innerHTML = author;
        newTr.appendChild(newTd);
        newTd = document.createElement("td");
        newTd.innerHTML = type;
        newTr.appendChild(newTd);
        newTd1 = document.createElement("td");
        $(newTd1).css({
            "width":"15%"
        });
        var newDiv = document.createElement("div");
        var div1 = document.createElement("div");
        var edit = document.createElement("input");
        $(edit).attr({
            "type":"button",
            "value":"修改"
        })
        var div2 = document.createElement("div");
        var del = document.createElement("input");
        $(del).attr({
            "type":"button",
            "value":"删除"
        })
        div1.appendChild(edit);
        $(div1).css({
            "margin-left":"25px",
            "float":"left",
            "width":"25%",
            "height":"95%",
            // "border":"1px black solid"
        });
        div2.appendChild(del);
        $(div2).css({
            "margin-right":"25px",
            "float":"right",
            "width":"25%",
            "height":"95%",
            // "border":"1px black solid"
        });
        newDiv.appendChild(div1);
        newDiv.appendChild(div2);
        $(newDiv).css({
            "margin":"auto",
            // "border":"1px black solid",
            "width":"95%",
            "height":"95%"
        })
        newTd1.appendChild(newDiv);
        newTr.appendChild(newTd1);
    
        $("table")[0].appendChild(newTr);
        $("td").css({
            "border":"2px solid black"
        });
        $("td").attr({
            "align":"center"
        });

        isAdd = false;
    } else {
        var arr = trObj.children();
        $(arr[1]).text(title);
        $(arr[2]).text(abstract);
        $(arr[3]).text(author);
        $(arr[4]).text(type);
    }
    $("#inputWindow").css("display", "none");
    $("#textTitle").val("");
    $("#textAbstract").val("");
    $("#textAuthor").val("");
    $("#selectType").val("");
}

function onclickReset(){
    $("#textTitle").val("");
    $("#textAbstract").val("");
    $("#textAuthor").val("");
    $("#selectType").val("");
}

// ready事件
$(function(){
    // 注册新增按钮事件
    $("[value=新增]").click(onclickAdd);
    // 注册保存按钮事件
    $("[value=保存]").click(onclickSave);
    $("[value=重置]").click(onclickReset);
})

$("[value=删除]").live({
    "click":function(){
        var tr = $(this).parents("tr");
        tr.remove();
    }
})

$("[value=修改]").live({
    "click":function(){
        var tr = $(this).parents("tr");
        var arr = tr.children();

        $("#textTitle").val($(arr[1]).text());
        $("#textAbstract").val($(arr[2]).text());
        $("#textAuthor").val($(arr[3]).text());
        $("#selectType").val($(arr[4]).text());
        $("#inputWindow").css("display", "block");
        isAdd = false;
        trObj = tr;
    }
})